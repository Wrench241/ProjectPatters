
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
        HourContract h = new HourContract();
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
            try {
                System.out.print("Level: ");
                 workerLevel = read.next();
                continued = false;
            } catch (Exception ey) {
                System.out.println("Error 404");
            }
        }
        System.out.print("Base salary: ");
        Double baseSalary = read.nextDouble();
        Worker w = new Worker(workerName,WorkLevel.valueOf(workerLevel),baseSalary, new Departament(departamenteName));
        System.out.print("How many contracts to this worker? ");
        Integer a = read.nextInt();
        String dateConverter = "";

        for (int i = 0; i < a; i++) {
            System.out.printf("Enter contract #%d data:\n", i + 1);
            System.out.print("Date ex(DD/MM/YYYY): ");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
            String data01 = read.next();
            while (continued) {
                try {
                    Date date = format.parse(data01);
                    h.setDate(date);
                    continued = false;
                } catch (ParseException e) {
                    System.out.println("Erro, insira uma data válida");
                }
            }
        }
    }

}
