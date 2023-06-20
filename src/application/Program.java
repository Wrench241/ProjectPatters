
package application;

import java.text.ParseException;
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
        Departament d = new Departament();
        Scanner read = new Scanner(System.in);
        System.out.print("Enter department's name: ");
        read.next();
        String departamenteName = read.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Enter user name: ");
        read.next();
        String workerName = read.nextLine();
        boolean continued = true;
        WorkLevel workLevel;
        String workerLevel = "";
        while (continued) {
            System.out.print("Level: ");
            workerLevel = read.next();
            try {
                WorkLevel.valueOf(workerLevel);
                continued = false;
            } catch (Exception ey) {
                System.out.println("Error 404");
            }
        }
        System.out.print("Base salary: ");
        Double baseSalary = read.nextDouble();
        Worker w = new Worker(workerName,WorkLevel.valueOf(workerLevel),baseSalary, new Departament(departamenteName));
        System.out.print("How many contracts to this worker? ");
        int a = read.nextInt();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        for (int i = 0; i < a; i++) {
            System.out.printf("Enter contract #%d data:\n", i + 1);
            System.out.print("Date ex(DD/MM/YYYY): ");
            String data01 = read.next();
            Date date = null;
            while (continued) {
                try {
                    date = format.parse(data01);
                    continued = false;
                } catch (ParseException e) {
                    System.out.println("Error, insert a valid date");
                }
            }
            System.out.print("Value per hour: ");
            double valuePerHour= read.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = read.nextInt();
            HourContract hourContract = new HourContract(date,valuePerHour,hours);
            w.addContract(hourContract);

        }
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String parse = read.next();
        Date date=null;
        while (continued) {
            try {
                date = format.parse("MM/yyyy");
                parse = read.next();
                continued = false;
            } catch (ParseException e) {
                System.out.println("Error, insert correct date.");

            }
        }
        int month = Integer.parseInt(parse.substring(0,2));
        int year = Integer.parseInt(parse.substring(3));
        System.out.print("Name: "+w.getName());
        System.out.print("Department: "+w.getDepartment());
        System.out.print("Income for "+parse+": "+String.format("%.2f",w.income(month,year)));

    }

}
