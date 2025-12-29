package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        // Alarm Clock

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "On the Flip.wav";

        while (alarmTime == null) {
            try {
                System.out.println("Enter an alarm time (HH:MM:SS): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmTime);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please use HH:MM:SS");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start(); // executes run method

    }
}
