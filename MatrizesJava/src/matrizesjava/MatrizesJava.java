
package matrizesjava;

import java.util.Random;
import java.util.Scanner;

public class MatrizesJava {
    public static void main(String[] args) {

   Scanner in = new Scanner(System.in);
    System.out.print("Digite o tamanho da matriz quadrada de valores aleátorios: ");
    int Linha = in.nextInt();
    int Coluna = Linha;

    //Instancia da classe que gerara os numeros aleatorios;
    Random r = new Random();

    //Declarando 3 arrays bidimensionais(matrizes);
    int A[][] = new int[Linha][Coluna];
    int B[][] = new int[Linha][Coluna];
    int Soma[][] = new int[Linha][Coluna];
    int Sub[][] = new int[Linha][Coluna];
    int Mult[][] = new int[Linha][Coluna];

    //Gerando a Matriz A LxCo Aij, com i e j valores iguais e sendo gerados aleatoriamente :
    System.out.println(" A matriz 'A' é: ");
    for (int l = 0; l < Linha; l++) {
        for (int co = 0; co < Coluna; co++) {
            A[l][co] = r.nextInt(9) + 1;
            System.out.print(A[l][co] + " ");
        }
        System.out.println("");
    }
    System.out.println("_______________");

    //Gerando a Matriz B LxCo Bij, com i e j valores iguais e sendo gerados aleatoriamente :
    System.out.println("A matriz 'B' é: ");
    for (int l = 0; l < Linha; l++) {
        for (int co = 0; co < Coluna; co++) {
            B[l][co] = r.nextInt(9) + 1;
            System.out.print(B[l][co] + " ");
        }
        System.out.println("");
    }
    System.out.println("______________________________");

    //Vou efetuar a soma das matrizes A e B;
    System.out.println("A soma das matrizes A e B é: ");
    for (int l = 0; l < Linha; l++) {
        for (int co = 0; co < Coluna; co++) {
            Soma[l][co] = A[l][co] + B[l][co];
            System.out.print(Soma[l][co] + " ");
        }
        System.out.println("");
    }
    System.out.println("______________________________");

    //Vou efetuar a subtração das matrizes A e B;
    System.out.println(" A subtração das matrizes A e B é: ");
    for (int l = 0; l < Linha; l++) {
        for (int co = 0; co < Coluna; co++) {
            Sub[l][co] = A[l][co] - B[l][co];
            System.out.print(Sub[l][co] + " ");
        }
        System.out.println("");
    }
    System.out.println("______________________________");

    //Vou efetuar a multiplicação das matrizes A e B;
    System.out.println(" A multiplicação das matrizes A e B é: ");
    for (int l = 0; l < Linha; l++) {
        for (int co = 0; co < Coluna; co++) {
            Mult[l][co] = A[l][co] * B[l][co];
            System.out.print(Mult[l][co] + " ");
        }
        System.out.println("");
    }

    }
    
}
