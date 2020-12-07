package BitsPlease;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Birthday 
{
    public void birthdays()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDate today = LocalDate.now();  
        FileInputStream inputStream;
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            File f = new File(classLoader.getResource("birthdays.txt").getFile());
            inputStream = new FileInputStream(f);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(";");
                System.out.println(tokens);
                if(isSameDate(LocalDate.parse(tokens[2].trim(), dtf), today))
                    System.out.println("Happy birthday " + tokens[0].trim() + " !");
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if two date are the same day
     * @param date1
     * @param date2
     * @return Matching boolean
     */
    public static boolean isSameDate(LocalDate date1, LocalDate date2) {
        return date1.isEqual(date2);
    }
}