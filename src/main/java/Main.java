import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
    static MongoCollection detailColl;
    static MongoCollection attColl;
    public static void main(String[] args)
    {
//        Create 4 choices which is:
//        1. Create
//        2. Read
//        3. Update
//        4. Delete

        int choice = 0;
        String emp_name = null;
        int emp_num = 0;
        String emp_status = null;

        String date = null;
        String time_in = null;
        String time_out = null;



//-----------------------------------------------------------

        //Initialize the connection to the database
        DB db = new MongoClient().getDB("employee");

        Jongo jongo = new Jongo(db);


//      Establish the connection to the employee collection
        detailColl = jongo.getCollection("detail");
        attColl = jongo.getCollection("attendance");

//---------------------------------------------------------------

        System.out.println("Please Enter Your Choice : ");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        input.nextLine();

        if (choice==1)
        {
//            Save employee name, employee number and status
            System.out.println("Please Your Full Name : ");
            emp_name = input.nextLine().toLowerCase();
            System.out.println("Please Your Employee Number : ");
            emp_num = input.nextInt();
            input.nextLine();
            System.out.println("Please Employee Status : ");
            emp_status = input.nextLine().toLowerCase();

//            save the data into mongodb
//            check the employee number first, ist it exist or not

            Detail check = detailColl.findOne("{emp_num: "+emp_num+"}").as(Detail.class);
            if(check==null)
            {
                System.out.println("Data null");
                Detail detail = new Detail(emp_name,emp_num, emp_status);
                detailColl.save(detail);
            }
            else
            {
                System.out.println("Employee Number Already Exist");
            }


//        Employee e = new Employee("wish",3);
//        employeeCollection.save(e);

        }

        else if(choice==2)
        {
            System.out.println("Please Enter Employee Number : ");
            emp_num = input.nextInt();
            input.nextLine();
            System.out.println("Please Enter The Date : ");
            date = input.nextLine().toLowerCase();
//            LocalDate date = LocalDate.now(); // Create a date object
//            System.out.println(date);
            System.out.println("Please Enter The Time In : ");
            time_in = input.nextLine().toLowerCase();
            System.out.println("Please Enter The Time Out : ");
            time_out = input.nextLine().toLowerCase();


            Attendance check = attColl.findOne("{date: '"+date+"', emp_num: "+emp_num+" }").as(Attendance.class);
            if(check==null)
            {
                System.out.println("Data null");
                Attendance att = new Attendance(emp_num, date,time_in, time_out);
                attColl.save(att);
            }
            else
            {
//                attColl.update("{time_out: 3}").with("{$set: {time_out: 2}}");
                String lama = "time_out: 2";
                String baru = "time_out: 3";

//                Attendance a = attColl.findOne("{time_out:'1'}").as(Attendance.class);

//                System.out.println(a);

                attColl.update("{emp_num: 1, date: '123'}").with("{$set:{time_out: '3'}}");

            }

        }

    }

//    static Detail findEmpNum(int emp_nums)
//    {
//        return detailColl.findOne("{emp_num: "+emp_nums+"}").as(Detail.class);
//    }

}
