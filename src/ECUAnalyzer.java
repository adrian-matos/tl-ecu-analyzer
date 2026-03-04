import java.io.BufferedReader;
import java.io.FileReader;

public class ECUAnalyzer {
    public static void main(String[] args) throws Exception{
        System.out.println("ECU Analyzer started :)");
        BufferedReader reader = new BufferedReader(new FileReader("src/data/ecu_log.csv"));
        reader.readLine();
        reader.readLine();
        int maxRPM = 0;
        double maxThrottlePosition = 0;
        double maxAbsFuelTrim = 0;
        int count = 0;
        double totalSTFT = 0;
        String line;
        while((line = reader.readLine())!=null) {
            String[] data = line.split(",");
            double time = Double.parseDouble(data[0]);
            double stft = Double.parseDouble(data[1]);      // fuel trim
            int rpm = (int) Double.parseDouble(data[2]);    // RPM
            double speed = Double.parseDouble(data[3]);     // MPH
            double throttle = Double.parseDouble(data[4]);  // %
            totalSTFT += stft;
            count++;

            if (rpm > maxRPM) {
                maxRPM = rpm;
            }
            if (throttle > maxThrottlePosition) {
                maxThrottlePosition = throttle;
            }

            if (throttle > 70) {
                System.out.println("High throttle event at " + time + " sec | RPM: " + rpm);
            }

            double absTrim = Math.abs(stft);
            if (absTrim > maxAbsFuelTrim) {
                maxAbsFuelTrim = absTrim;
            }

        }
        double avgSTFT = totalSTFT / count;
        reader.close();
        System.out.println("Samples analyzed: " + count);
        System.out.println("TL ECU Log Report ===>");
        System.out.println("Average STFT %: " + avgSTFT);
        System.out.println("Max RPM: " + maxRPM);
        System.out.println("Max Throttle %: " + maxThrottlePosition);
        System.out.println("Max STFT %: " + maxAbsFuelTrim);
    }



    }

