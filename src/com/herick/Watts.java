package com.herick;

import java.util.Locale;
import java.util.Scanner;

public class Watts {

    private Integer tipo = null;
    private Comodo comodo = new Comodo();


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

                watts.comodo.setAreaComodo(watts.calculaAreaComodo());
                System.out.println("O comodo tem " + watts.comodo.getAreaComodo() + " m²");

                System.out.println("O comodo necessita de " + Math.ceil(watts.calcuLampada()) + " lâmpadas.");

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
                comodo.setTipo(tipo);

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
                comodo.setLargura(input.nextFloat());

                if (comodo.getLargura() <= 0) {
                    System.out.println("A largura não pode ser 0 ou negativa, digite novamente.");
                }

            } catch (Exception ex) {
                System.out.println("Você digitou uma largura errada, digite novamente.");
                input.next();
            }
        } while (comodo.getLargura() <= 0);
    }

    public void inputAltura(Scanner input) {
        do {
            try {
                System.out.print("Informe a altura do comodo: ");
                comodo.setAltura(input.nextFloat());

                if (comodo.getAltura() <= 0) {
                    System.out.println("A altura não pode ser 0 ou negativa, digite novamente.");
                }

            } catch (Exception ex) {
                System.out.println("Você digitou uma altura errada, digite novamente.");
                input.next();
            }
        } while (comodo.getAltura() <= 0);
    }

    public float calculaAreaComodo() {
        return comodo.getAltura() * comodo.getLargura();
    }

    public float calcuLampada() {
        int potencia;
        switch (comodo.getTipo()) {
            case 0:
                potencia = 12;
                break;
            case 1:
                potencia = 15;
                break;
            case 2:
                potencia = 18;
                break;
            case 3:
                potencia = 20;
                break;
            case 4:
                potencia = 22;
                break;
            default:
                potencia = 0;  // Tipo inválido
        }
        return (comodo.getAreaComodo() * potencia) / 60;
    }
}





