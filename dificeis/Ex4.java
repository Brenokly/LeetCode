package dificeis;

/*
Dadas duas matrizes classificadas nums1e nums2de tamanho me nrespectivamente, retorne a mediana das duas matrizes classificadas.

A complexidade geral do tempo de execução deve ser O(log (m+n)).

Exemplo 1:

Entrada: nums1 = [1,3], nums2 = [2]
Saída: 2,00000
Explicação: array mesclado = [1,2,3] e mediana é 2.
*/

import java.util.Arrays;
import java.util.Random;

public class Ex4 {
  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 4};
    int[] nums2 = {5, 6, 7, 8};

    // Medir o tempo da primeira implementação
    // long startTime = System.nanoTime();
    // double median1 = findMedianSortedArrays(nums1, nums2);
    // long endTime = System.nanoTime();
    // long duration1 = endTime - startTime;

    // System.out.println("Mediana (Primeira Implementação): " + median1);
    // System.out.println("Tempo de execução (Primeira Implementação): " + duration1
    // + " nanosegundos");

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Medir o tempo da segunda implementação (otimizada)
    long startTime = System.nanoTime();
    double median2 = oTimizadofindMedianSortedArrays(nums1, nums2);
    long endTime = System.nanoTime();
    long duration2 = endTime - startTime;

    System.out.println("Mediana (Segunda Implementação): " + median2);
    System.out.println("Tempo de execução (Segunda Implementação): " + duration2 + " nanosegundos");
  }

  public static double oTimizadofindMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;

    // Garantir que nums1 seja o menor array
    if (n > m) {
      return oTimizadofindMedianSortedArrays(nums2, nums1);
    }

    int min = 0;
    int max = n;
    int half = (n + m + 1) / 2; // representa a posição média juntando os dois arrays

    while (min <= max) {
      int i = (max + min) / 2; // i é calculado como o ponto médio entre min e max.
      int j = half - i; // é calculado como half - i, que representa a posição correspondente em nums2
                        // após i elementos de nums1.

      if (i < n && nums1[i] < nums2[j - 1]) { // Se entrar aqui é porque os elementos de nums1 são menores que os elementos de nums2
        // o que pode indicar que nums1 tem elementos da esquerda se tratando do vetor completo ordenado
        min = i + 1; // Oh i é muito pequeno aqui o i sobe e o j desce
      } else if (i > 0 && nums1[i - 1] > nums2[j]) { // já se ele entrar aqui é porque os elementos de nums1 são maiores que os elementos de nums2
        // o que pode indicar que nums1 tem elementos da direita se tratando do vetor completo e ordenado
        max = i - 1; // Oh i é muito grande aqui o i desce e o j sobe
      } else {
        // i é perfeito e não precisa ser alterado
        int maxOfLeft;
        if (i == 0) { // i == 0 indica que todos os elementos de nums1 estão ah direita de nums2[j - 1] no vetor completo e ordenado
          maxOfLeft = nums2[j - 1];
        } else if (j == 0) { // j == 0 indica que todos os elementos de nums2 estão ah direita de nums1[i - 1] no vetor completo e ordenado
          maxOfLeft = nums1[i - 1];
        } else {
          maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        }
        if ((n + m) % 2 == 1) {
          return maxOfLeft;
        }

        int minOfRight = 0;
        if (i == n) {
          minOfRight = nums2[j];
        } else if (j == m) {
          minOfRight = nums1[i];
        } else {
          minOfRight = Math.min(nums1[i], nums2[j]);
        }

        return (maxOfLeft + minOfRight) / 2.0;
      }
    }

    return 0.0;
  }

  // private static int[] generateSortedArray(int n) {
  // int[] array = new int[n];
  // Random random = new Random();
  // array[0] = random.nextInt(10);
  // for (int i = 1; i < n; i++) {
  // array[i] = array[i - 1] + random.nextInt(10) + 1;
  // }
  // return array;
  // }

  // minha solução que é bem mais ou menos
  // public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
  // int n = nums1.length;
  // int m = nums2.length;
  // int nm = n + m;
  // double[] nums = new double[nm];

  // if (n == 0) {
  // if (m % 2 == 0) {
  // return (nums2[m / 2 - 1] + nums2[m / 2]) / 2.0;
  // } else {
  // return nums2[m / 2];
  // }
  // } else if (m == 0) {
  // if (n % 2 == 0) {
  // return (nums1[n / 2 - 1] + nums1[n / 2]) / 2.0;
  // } else {
  // return nums1[n / 2];
  // }
  // }

  // int i = 0;
  // int j = 0;
  // int k = 0;
  // boolean check1 = true;
  // boolean check2 = true;

  // while (check1 || check2) {

  // if (check1 && nums1[i] < nums2[j] || !check2) {
  // nums[k] = nums1[i];

  // i++;
  // } else if (check2 || !check1) {
  // nums[k] = nums2[j];

  // j++;
  // }

  // k++;

  // if (i == n) {
  // check1 = false;
  // i--;
  // }

  // if (j == m) {
  // check2 = false;
  // j--;
  // }
  // }

  // if (nums.length % 2 == 0) {
  // return (nums[nm / 2 - 1] + nums[nm / 2]) / 2.0;
  // } else {
  // return nums[nm / 2];
  // }
  // }
}