package com.metanit;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String com ;
        String input;
        Scanner in = new Scanner(System.in);
        Primer y = new Primer();
        System.out.println("Введите значения: ");
        input = in.nextLine();
        try {
            double x = Double.parseDouble(input);
            y.Resheni(x);
            System.out.println("Введите <save> для сохранения объекта или <upload> для восстановления объекта!");
            com = in.nextLine();
            if (com.equalsIgnoreCase("save")) {
                try (ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("file.txt"))) {
                    save.writeObject(y);
                    System.out.println("Данные сохранены");
                } catch (IOException ex) {
                    ex.getMessage();
                }
        }
            else if (com.equalsIgnoreCase("upload")) {
                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("file.txt"))) {
                    y = (Primer) inputStream.readObject();
                    System.out.println("Данные восстановлены");
                } catch (Exception ex) {
                    ex.getMessage();
                }
            } else {
                System.out.println("Вы ввели не верную команду!");
            }
        }
    catch (Exception e){
        e.getMessage();
        }
    }}
class Primer implements Serializable {
    double x;
    double y;

    Primer() {
        x = 0;
        y = 0;
    }
    void Resheni(double x) {
        this.x = x;
        y = this.x - Math.sin(this.x);
        System.out.println(y);
    }}



