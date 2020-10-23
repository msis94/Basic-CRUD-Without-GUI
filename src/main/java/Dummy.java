import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Dummy
{
    public static void main(String[] args)
    {
        LocalDate date = LocalDate.now(); // Create a date object
        System.out.println(date);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(dateFormat);
        System.out.println("After formatting: " + formattedDate);

        LocalTime time = LocalTime.now();
        System.out.println(time);
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = date.format(timeFormat);
        System.out.println("After formatting: " + formattedTime);

    }
}
