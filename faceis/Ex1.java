package faceis;

import java.util.HashMap;
import java.util.Map;

/*

Dada uma matriz de números inteiros nums e um número inteiro target, retorne os índices dos dois números de forma que a soma deles seja
target.

Você pode assumir que cada entrada teria exatamente uma solução e não pode usar o mesmo elemento duas vezes.

Você pode retornar a resposta em qualquer ordem.

Entrada: nums = [2,7,11,15], alvo = 9
Saída: [0,1]
Explicação: Como nums[0] + nums[1] == 9, retornamos [0, 1].

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109

*/

public class Ex1 {
  public static void main(String[] args) {

    int[] nums = { 2,3,6,5};
    int target = 7;

    int[] resposta = twoSum(nums, target);

    System.out.println("Indíce resposta: " + resposta[0] + " " + resposta[1]);
    System.out.println(nums[resposta[0]] + " + " + nums[resposta[1]] + " = " + target + "\n\n");
  }

  public static int[] twoSum(int[] nums, int target) { // explicação
    Map<Integer, Integer> hasher = new HashMap<>(); // Cria um HashMap

    for (int i = 0; i < nums.length; i++) {
      if (hasher.containsKey(nums[i])) {
        return new int[] { hasher.get(nums[i]), i }; // Retorna o índice do complemento
      } else {
        int complement = target - nums[i]; // Calcula o complemento
        hasher.put(complement, i); // Adiciona o complemento ao HashMap
      }
    }

    return new int[] {0, 0}; // Retorna um array vazio
  }
}