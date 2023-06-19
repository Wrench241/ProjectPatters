
package application;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import entities.HourContract;
import entities.Worker;
import entitiesEnum.WorkLevel;

public class Program {
    public static void main(String[] args) {
        Worker w = new Worker();
        HourContract h = new HourContract();
        Scanner read = new Scanner(System.in);
        System.out.print("Enter department's name: ");
        read.next();
        String departmentName = read.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Enter user name: ");
        read.next();
        w.setName(read.nextLine());
        System.out.print("Level: ");
        try {
            w.setLevel(WorkLevel.valueOf(read.next()));
        } catch (Exception ey) {
            System.out.println("Error 404");
        }

        System.out.print("Base salary: ");
        w.setBaseSalary(read.nextDouble());
        System.out.println("How many contracts to this worker?");
        Integer a = read.nextInt();
        DateTimeFormatter d1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for(int i = 0; i < a; i++){
            System.out.printf("Enter contract #%d data:",a+1);
            System.out.println("Date (DD/MM/YYYY: ");
            String dateConverter = read.next();
            d1.format(dateConverter);



        }
    }

}
