package media;

public class Ex5 {
  public static void main(String args[]) {
    String teste = "adam";

    String result = longestPalindrome(teste);

    System.out.println("Resultado: " + result);
  }

  public static String longestPalindrome(String s) {
    int n = s.length();

    if(n ==1 || n ==2 
    && s.charAt(1) == s.charAt(0)){
        return s;
    }
    if(n == 2 && s.charAt(1) != s.charAt(0)){
        return s.substring(0,1);
    }

    int start = 0, end = 0;
    for (int i = 0; i < n; i++) {
      // Expande a partir de um centro único
      int len1 = expandAroundCenter(s, i, i);
      // Expande a partir de um centro duplo
      int len2 = expandAroundCenter(s, i, i + 1);
      // Determina o comprimento máximo entre as duas expansões
      int len = Math.max(len1, len2);

      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }

    return s.substring(start, end + 1);
  }

  private static int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1; // Tamanho do palíndromo encontrado
  }
}