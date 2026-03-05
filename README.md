**# ECU Analyzer

Command-line Java tool that analyzes OBD-II ECU telemetry logs exported from OBD Fusion.

## Features
- Parses CSV telemetry logs
- Computes max RPM, max throttle
- Computes average STFT (fuel trim)
- Detects high-throttle events (time + RPM)

## Data Source
Logs exported from the OBD Fusion app (OBD-II), fields used:
- Time (sec)
- STFT Bank 1 (%)
- Engine RPM (RPM)
- Vehicle speed (MPH)
- Absolute throttle position (%)

## Run
1. Export a CSV from OBD Fusion.
2. Place it at `src/data/ecu_log.csv` (or update the path in code).
3. Run the program.

## Example Output
Samples analyzed: 8400  
Max RPM: 3420  
Max throttle: 58%  
Average STFT: 1.9%

## Author
Adrian Matos**
