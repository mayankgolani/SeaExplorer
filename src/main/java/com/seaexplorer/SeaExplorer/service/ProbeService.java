package com.seaexplorer.SeaExplorer.service;

import com.seaexplorer.SeaExplorer.model.Position;

public interface ProbeService {
    void executeCommand(String command);

    Position getProbePosition();
}
