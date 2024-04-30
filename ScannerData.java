import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
class ParseStringData{
    public void analysisData(String [] a) {
        String date_s = " ";
        if(a.length < 6){
            throw new InformationException("Недостаточно данных");
        }else if(a.length > 6){
            throw new InformationException("Слишком много данных");
        } else{
            DateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
            dt.setLenient(false);
            try {
                Date date = dt.parse(a[3]);
                date_s = dt.format(date);
            } catch (ParseException e) {
                System.out.println("Не верный формат даты.");
            }
            try {
                long formatNumber = Long.parseLong((a[4]));
            }catch (NumberFormatException e){
                System.out.println("Не верный формат номера телефона.");
            }
            if(!(a[5].equals("f") || a[5].equals("m"))){
                throw new InformationException("Не верно указан пол.");
            }

            try {
                File file = new File("./exceptions-in-JAVA",a[0]+".txt");
                if (file.exists()){
                    FileWriter writer = new FileWriter(file, true);
                    writer.write("\n"+ a[0]+" "+ a[1]+" "+a[2]+" "+a[3]+" "+a[4]+" "+a[5]);
                    writer.close();
                }else{
                    FileWriter writer = new FileWriter(file);
                    writer.write("\n"+ a[0]+" "+ a[1]+" "+a[2]+" "+a[3]+" "+a[4]+" "+a[5]);
                    writer.close();
                }
            }catch (IOException e) {
                System.out.println("Ошибка при создании файла");
                e.printStackTrace();
            }
        }
    }
}
public class ScannerData {
    public static void main(String[] args) {

        ParseStringData parseStringData = new ParseStringData();
        Scanner scanner = new Scanner(System.in);
        if (args.length == 0) {
            String[] b = scanner.nextLine().split(" ");
            parseStringData.analysisData(b);
        } else {
            String [] a  = {args[0]};
            parseStringData.analysisData(a);
        }
    }
}
// Петров Василий Петрович 01.01.2000 88008008080 m
//// Петров Иван Петрович 01.01.2001 88008008081 m
//Иванов Иван Петрович 01.01.2001 88008008081 m
//Васечкин Иван Петрович 01.01.2001 88008008081 m

