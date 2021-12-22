package com.herick;

import java.util.Locale;
import java.util.Scanner;

public class Watts {

    Integer tipo = null;
    float largura = 0f;
    float altura = 0f;
    float areaComodo = 0f;


    public static void main(String[] args) {
        Watts watts = new Watts();
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        System.out.println("Tipos de comodo: 0, 1, 2, 3 e 4 (-1 para encerrar))\n");

        while (watts.tipo == null || watts.tipo != -1) {
            watts.inputTipoComodo(input);

            if (watts.tipo >= 0 && watts.tipo <= 4) {
                watts.inputLargura(input);
                watts.inputAltura(input);

                watts.areaComodo = watts.calculaAreaComodo();
                System.out.println(watts.areaComodo);

            } else {
                System.out.println("Você digitou um valor errado, digite valores entre 0 e 4 ");
            }
        }

    }

    public void inputTipoComodo(Scanner input) {
        do {
            try {
                System.out.print("Informe o tipo do comodo: ");
                tipo = input.nextInt();
            } catch (Exception ex) {
                System.out.println("Você digitou um tipo de comodo errado, digite novamente.");
                tipo = null;
                input.next();
            }
        } while (tipo == null);

        if (tipo == -1) {
            input.close();
        }
    }

    public void inputLargura(Scanner input) {
        do {
            try {
                System.out.print("Informe a largura do comodo: ");
                largura = input.nextFloat();

                if (largura <= 0) {
                    System.out.println("A largura não pode ser 0 ou negativa, digite novamente.");
                }

            } catch (Exception ex) {
                System.out.println("Você digitou uma largura errada, digite novamente.");
                input.next();
            }
        } while (largura <= 0);
    }

    public void inputAltura(Scanner input) {
        do {
            try {
                System.out.print("Informe a altura do comodo: ");
                altura = input.nextFloat();

                if (altura <= 0) {
                    System.out.println("A altura não pode ser 0 ou negativa, digite novamente.");
                }

            } catch (Exception ex) {
                System.out.println("Você digitou uma altura errada, digite novamente.");
                input.next();
            }
        } while (altura <= 0);
    }

    public float calculaAreaComodo(){
        return altura * largura;
    }



}

