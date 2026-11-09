package org.example.song.restControllers;

import org.example.song.config.Configuration;
import org.example.song.dto.APIResponseDto;
import org.example.song.service.SongService;
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
@RequestMapping("/api/songs")
@RefreshScope
public class SongController {

    private final SongService songService;
    private final Configuration configuration;
    private final Environment environment;

    @Value("${build.version:unknown}")
    private String buildVersion;

    @Autowired
    public SongController(SongService songService, Configuration configuration, Environment environment) {
        this.songService = songService;
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

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getSongById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(songService.getSongById(id), instanceHeaders(), HttpStatus.OK);
    }
}
