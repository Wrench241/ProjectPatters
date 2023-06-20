
package application;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entitiesEnum.WorkLevel;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CANADA);
        Worker w = new Worker();
        Departament d = new Departament();
        HourContract h = new HourContract();
        Scanner read = new Scanner(System.in);
        System.out.print("Enter department's name: ");
        d.setName(read.nextLine());
        System.out.println(d.getName());
        System.out.println("Enter worker data:");
        System.out.print("Enter user name: ");
        read.next();
        w.setName(read.nextLine());
        boolean continued = true;
        while (continued) {
            try {
                System.out.print("Level: ");
                w.setLevel(WorkLevel.valueOf(read.next()));
                continued = false;
            } catch (Exception ey) {
                System.out.println("Error 404");
            }
        }
        System.out.print("Base salary: ");
        w.setBaseSalary(read.nextDouble());
        System.out.print("How many contracts to this worker? ");
        Integer a = read.nextInt();
        String dateConverter = "";
        LocalDate localdate = LocalDate.parse(dateConverter);
        DateTimeFormatter d1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for(int i = 0; i < a; i++){
            System.out.printf("Enter contract #%d data:\n",i+1);
            System.out.println("Date (DD/MM/YYYY): ");
            dateConverter = read.next();



        }
    }

}
