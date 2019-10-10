import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public static void main(String args[]) throws IOException
    {
        int sucessfulEntry=0, failedEntry=0, recordReceived=0;
        try
        {
            // getting database setup
            DatabaseEntry de = new DatabaseEntry();
            de.createDatabaseConnection();

            // Reader and CSVParser are used to read the file
            //apache csv reader detect's the header
            Reader reader = Files.newBufferedReader(Paths.get("Entry Level Coding Challenge Page 2.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            //the records that are completed are written in userinfo-bad.csv
            //Filewriter is used to do it.
            //apache csv printer print the file with respective headers
            FileWriter fw =new FileWriter("userinfo-bad.csv");
            CSVPrinter printer = new CSVPrinter(fw,CSVFormat.DEFAULT.withHeader("A","B","C","D","E","F","G","H","I","J"));


            for(CSVRecord csvRecord :csvParser)
            {
                String firstName = csvRecord.get("A");
                String lastName = csvRecord.get("B");
                String email = csvRecord.get("C");
                String gender = csvRecord.get("D");
                String image = csvRecord.get("E");
                String cardType = csvRecord.get("F");
                String cost = csvRecord.get("G");
                String bolValue1 = csvRecord.get("H");
                String bolValue2 = csvRecord.get("I");
                String place = csvRecord.get("J");

                User user = new User(firstName,lastName,email,gender,image,cardType,cost,bolValue1,bolValue2,place);
                recordReceived++;

                //if the record is complete we add it to the database
                if(user.isComplete()) {
                    sucessfulEntry++;
                    de.insertIntoDatabase(user);
                }
                else {
                    // if record is incomplete we add it to the userinfo-bad.csv
                    failedEntry++;
                    printer.printRecord(user);
                    printer.flush();
                }
            }
            printer.close();
            // we have maintained counter for failed, successful and no of record
            // we will create a list and print the list value that has counter info into the userinfo.log file
            List<String> record = Arrays.asList("Entries Received : "+recordReceived,"Successful Entries : "+sucessfulEntry,"Failed Entries : "+failedEntry);
            Path logFile = Paths.get("userinfo.log");
            Files.write(logFile,record, StandardCharsets.UTF_8);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
