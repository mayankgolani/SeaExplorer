package com.seaexplorer.SeaExplorer.controller;

import com.seaexplorer.SeaExplorer.model.Position;
import com.seaexplorer.SeaExplorer.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/probe")
public class ProbeController {

    @Autowired
    private ProbeService probeService;

    @GetMapping("/position")
    public Position getPosition() {
        return probeService.getProbePosition();
    }

    @PostMapping("/command")
    public void executeCommands(@RequestBody String commands) {
        probeService.executeCommand(commands);
    }
}
