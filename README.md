Sample Requests:

For Initializing: /api/probe/init
{
    "gridWidth": 5,
    "gridHeight": 5,
    "startX": 0,
    "startY": 0,
    "startDirection": "N",
    "obstacles": [
        {
            "x": 1,
            "y": 1
        },
        {
            "x": 2,
            "y": 3
        }
    ]
}

For Command: /api/probe/commands
{
    "commands": "FFRFFLBB"
}

For Status: /api/probe/status
