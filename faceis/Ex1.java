package faceis;

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
    for (int i = 1; i < nums.length; i++) { // for para percorrer todo o array
        for (int j = i; j < nums.length; j++) { // for para percorrer todo o array
          if ((nums[j] + nums[j - i]) == target) { // se a soma dos dois números for igual ao target
            return new int[] {j, j - i}; // retorna os índices
          }
        }
    }
    // Basicamente, o código acima percorre o array e verifica se a soma de dois números é igual ao target 
    // e retorna os índices dos números que somados são iguais ao target
    // A lógica o i percorre o array e o j percorre o array a partir do i
    // É verificado a posição j e j - i, se a soma for igual ao target, retorna os índices
    return null; // se não encontrar, retorna null
  }
}