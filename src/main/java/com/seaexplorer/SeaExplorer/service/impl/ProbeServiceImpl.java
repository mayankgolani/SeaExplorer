package com.seaexplorer.SeaExplorer.service.impl;

import com.seaexplorer.SeaExplorer.model.Direction;
import com.seaexplorer.SeaExplorer.model.Grid;
import com.seaexplorer.SeaExplorer.model.Position;
import com.seaexplorer.SeaExplorer.model.Probe;
import com.seaexplorer.SeaExplorer.service.ProbeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProbeServiceImpl implements ProbeService {

    private Probe probe;

    public ProbeServiceImpl() {
        probe = new Probe(new Position(0, 0), Direction.N, new Grid(5, 5), Set.of());
    }

    public void executeCommand(String command) {
        probe.executeCommands(command);
    }

    public Position getProbePosition() {
        return probe.getPosition();
    }
}