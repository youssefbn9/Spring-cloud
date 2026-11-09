package org.example.instrument.restControllers;

import org.example.instrument.config.Configuration;
import org.example.instrument.dto.InstrumentDto;
import org.example.instrument.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instruments")
@RefreshScope
public class InstrumentController {

    private final InstrumentService instrumentService;
    private final Configuration configuration;
    private final Environment environment;

    @Value("${build.version:unknown}")
    private String buildVersion;

    @Autowired
    public InstrumentController(InstrumentService instrumentService, Configuration configuration, Environment environment) {
        this.instrumentService = instrumentService;
        this.configuration = configuration;
        this.environment = environment;
    }

    private HttpHeaders instanceHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String port = environment.getProperty("local.server.port", environment.getProperty("server.port", "unknown"));
        String hostname = System.getenv().getOrDefault("HOSTNAME", "localhost");
        headers.add("X-Instance-Id", hostname + ":" + port);
        return headers;
    }

    @GetMapping("/version")
    public ResponseEntity<String> getVersion() {
        return new ResponseEntity<>(buildVersion, instanceHeaders(), HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        String info = configuration.getName() + " " + configuration.getEmail();
        return new ResponseEntity<>(info, instanceHeaders(), HttpStatus.OK);
    }

    @GetMapping("{code}")
    public ResponseEntity<InstrumentDto> getInstrumentByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(instrumentService.getInstrumentByCode(code), instanceHeaders(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<InstrumentDto> getInstrumentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(instrumentService.getInstrumentById(id), instanceHeaders(), HttpStatus.OK);
    }
}
