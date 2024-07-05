package media;

class Ex148 {
  /**
   * Definition for singly-linked list.
   * Um algoritmo de dividir e conquistar
   */
  static class ListNode { // apenas para representar uma lista
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

    // método para imprimir os valores da lista
    public void printList() {
      ListNode current = this;
      while (current != null) {
        System.out.print(current.val + " ");
        current = current.next;
      }
      System.out.println();
    }
  }
  public static void main(String args[]) {
    ListNode l1 = new ListNode(4);
    l1.add(2);
    l1.add(1);
    l1.add(3);

    l1.printList();

    l1 = sortList(l1);

    l1.printList();
  }

  public static ListNode findMidListNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public static ListNode mergeListNode(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode tail = head;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        tail.next = l1;
        l1 = l1.next;
      } else {
        tail.next = l2;
        l2 = l2.next;
      }
      tail = tail.next;
    }

    if (l2 == null) {
      tail.next = l1;
    } else {
      tail.next = l2;
    }

    return head.next;
  }

  public static ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode middle = findMidListNode(head); // meio da lista
    ListNode afterMiddle = middle.next; // referência pós-meio
    middle.next = null; // quebrando a lista

    ListNode left = sortList(head);
    ListNode right = sortList(afterMiddle);

    return mergeListNode(left, right);
  }
}