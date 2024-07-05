package media;

/*
Você recebe duas listas vinculadas não vazias que representam dois números inteiros não negativos. 
Os dígitos são armazenados em ordem inversa e cada um de seus nós contém um único dígito. 
Adicione os dois números e retorne a soma como uma lista vinculada.

Você pode assumir que os dois números não contêm nenhum zero à esquerda, exceto o próprio número 0.

Entrada: l1 = [2,4,3], l2 = [5,6,4]
Saída: [7,0,8]
Explicação: 342 + 465 = 807.
*/

public class Ex2 {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    // método add
    public void add(int val) {
      ListNode newNode = new ListNode(val);
      ListNode current = this;

      while (current.next != null) {
        current = current.next;
      }

      current.next = newNode;
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode();
    l1.add(2);
    l1.add(4);

    ListNode l2 = new ListNode();
    l2.add(2);
    l2.add(4);

    ListNode resposta = addTwoNumbers(l1, l2);

    System.out.print("Resposta: ");
    while (resposta.next != null) {
      resposta = resposta.next;
      System.out.print(resposta.val);
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode l3 = dummyHead;
    int carry = 0;

    // enquanto l1 ou l2 não for nulo ou carry for diferente de 0
    while (l1 != null || l2 != null || carry != 0) {
      int sum = carry; // soma recebe carry da iteração anterior
      if (l1 != null) { // se l1 não for nulo
        sum += l1.val; // soma recebe soma + l1.val
        l1 = l1.next; // l1 recebe o próximo nó
      }
      if (l2 != null) { // se l2 não for nulo
        sum += l2.val; // soma recebe soma + l2.val
        l2 = l2.next; // l2 recebe o próximo nó
      }
      carry = sum / 10; // carry recebe a parte iteira da divisão da soma por 10
      l3.next = new ListNode(sum % 10); // l3.next recebe o resto da divisão da soma por 10
      l3 = l3.next; // l3 recebe o próximo nó
    }

    return dummyHead.next; // retorna o próximo nó
  }
}