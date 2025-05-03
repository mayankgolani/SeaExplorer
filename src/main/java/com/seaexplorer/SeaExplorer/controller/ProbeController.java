package com.seaexplorer.SeaExplorer.controller;

import com.seaexplorer.SeaExplorer.model.DTO.CommandRequest;
import com.seaexplorer.SeaExplorer.model.DTO.InitRequest;
import com.seaexplorer.SeaExplorer.model.DTO.ProbeStatus;
import com.seaexplorer.SeaExplorer.service.ProbeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/probe")
public class ProbeController {

    private final ProbeService probeService;

    public ProbeController(ProbeService probeService) {
        this.probeService = probeService;
    }

    @PostMapping("/init")
    public ResponseEntity<String> init(@RequestBody InitRequest request) {
        probeService.initializeProbe(
                request.getGridWidth(),
                request.getGridHeight(),
                request.getStartX(),
                request.getStartY(),
                request.getStartDirection(),
                request.getObstacles()
        );
        return ResponseEntity.ok("Probe initialized");
    }

    @PostMapping("/commands")
    public ResponseEntity<String> executeCommands(@RequestBody CommandRequest request) {
        if (!probeService.isInitialized()) {
            return ResponseEntity.badRequest().body("Probe not initialized");
        }

        probeService.executeCommand(request.getCommands());
        return ResponseEntity.ok("Commands executed");
    }

    @GetMapping("/status")
    public ResponseEntity<ProbeStatus> getStatus() {
        if (!probeService.isInitialized()) {
            return ResponseEntity.badRequest().build();
        }

        ProbeStatus status = new ProbeStatus(
                probeService.getCurrentPosition(),
                probeService.getCurrentDirection(),
                probeService.getVisitedPositions()
        );
        return ResponseEntity.ok(status);
    }
}
