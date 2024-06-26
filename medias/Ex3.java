package medias;

/*
Dada uma string s, encontre o comprimento da maior 
substring
sem repetir caracteres.

Entrada: s = "abcabcbb"
Saída: 3
Explicação: A resposta é "abc", com comprimento 3.

*/

import java.util.logging.Logger;

public class Ex3 {
  private static final Logger logger = Logger.getLogger(Ex3.class.getName());

  public static void main(String[] args) {
    String s = "pwwkew";

    logger.info("" + lengthOfLongestSubstring(s));
  }

  public static int lengthOfLongestSubstring(String s) { // explicação
    int minLen = 0; // inicializa a variável minLen com 0
    int maxLen = 0; // inicializa a variável maxLen com 0
    int[] index = new int[127]; // cria um array de inteiros com 127 posições

    for (int i = 0; i < s.length(); i++) { // for para percorrer a string
      char c = s.charAt(i); // pega o caractere na posição i

      minLen = Math.max(minLen, index[c]); // pega o maior valor entre minLen e index[c]
      
      index[c] = i + 1; // index na posição c recebe i + 1

      maxLen = Math.max(maxLen, i - minLen + 1); // pega o maior valor entre maxLen e i - minLen + 1
    }

    return maxLen; // retorna o valor de maxLen
  }
}
