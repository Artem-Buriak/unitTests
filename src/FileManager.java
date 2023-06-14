import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileManager {

    public static void log(File file, String status, String method) {
        try (FileWriter writer = new FileWriter(file, true)) {
            String log = String.format("%s_%s: [%s]%n",
                    new Date(), method, status);
            writer.write(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
