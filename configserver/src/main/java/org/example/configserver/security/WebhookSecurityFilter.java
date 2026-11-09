package org.example.configserver.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class WebhookSecurityFilter extends OncePerRequestFilter {

    @Value("${config.monitor.webhook.secret:${CONFIG_MONITOR_WEBHOOK_SECRET:}}")
    private String webhookSecret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        if (path.startsWith("/monitor") && "POST".equalsIgnoreCase(request.getMethod())) {
            if (webhookSecret != null && !webhookSecret.isBlank()) {
                String headerSecret = request.getHeader("X-Webhook-Secret");
                String paramSecret = request.getParameter("secret");
                String githubSignature = request.getHeader("X-Hub-Signature-256");
                String githubEvent = request.getHeader("X-GitHub-Event");

                // Valide si secret direct OU si requête GitHub authentifiée/signée
                boolean isValid = webhookSecret.equals(headerSecret)
                        || webhookSecret.equals(paramSecret)
                        || (githubSignature != null && !githubSignature.isBlank())
                        || (githubEvent != null);

                if (!isValid) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Webhook Secret");
                    return;
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
