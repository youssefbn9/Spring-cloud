package org.example.gatewayserver.config;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.cloud.gateway.config.HttpClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyConfig {

    /**
     * Utilise le résolveur d'adresses standard de la JVM (InetAddress) pour Netty.
     * Indispensable sous Windows pour résoudre les noms d'hôtes locaux (ex: .mshome.net)
     * sans dépendre d'un serveur DNS externe.
     */
    @Bean
    public HttpClientCustomizer httpClientCustomizer() {
        return httpClient -> httpClient.resolver(DefaultAddressResolverGroup.INSTANCE);
    }
}
