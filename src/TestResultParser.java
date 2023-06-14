import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestResultParser {

    public static void parseByName(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            //init variables for TestResult
            int count = 0;
            int countSuccess = 0;
            String date = null;

            while (line != null) {
                //reading lines
                count++;
                if (line.substring(line.length()-4).equals("[ok]")) {
                    countSuccess++;
                }
                //check date
                String dateCheck = line.split("_")[0];
                //compare date from file (current & previous line)
                if (date == null) {
                    date = dateCheck;
                } else if (!date.equals(dateCheck)) {
                    TestResult tr = new TestResult(count, countSuccess, (count-countSuccess), date);
                    //init variables for new TestResult
                    date = dateCheck;
                    count = 0;
                    countSuccess = 0;
                    System.out.println(tr);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
