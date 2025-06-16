import java.util.EmptyStackException;

public class MyLinkedList<T> {

     private class Node {
          private T val;
          private Node next;

          public Node() {}

          public Node(T val) {
               this.val = val;
          }
     }

     private Node head;
     private int size;

     public void addLast(T val) {
          Node newNode = new Node(val);
          if (head == null) {
               head = newNode;
          } else {
               Node current = head;
               while (current.next != null) {
                    current = current.next;
               }
               current.next = newNode;
          }
          size++;

     }

     public void addFirst(T val) {
          Node newNode = new Node(val);
          newNode.next = head;
          head = newNode;
          size++;

     }

     public void printList() {
          Node temp = head;
          while (temp != null) {
               System.out.println(temp.val);
               temp = temp.next;
          }
     }

     public void remove(T val) {
          if(size==0){
               throw  new EmptyStackException();
          }
          if (head.val == val) {
               head = head.next;
               size--;
               return;
          }
        Node temp=head;
          while(temp.next!=null){
               if(temp.next.val==val){
                    temp.next=temp.next.next;
                    size--;
                    return;
               }
               temp=temp.next;
          }
     }

     public void removeIndex(int index) {
          if (size == 0) {
               throw new EmptyStackException();
          }

          if (index < 0 || index >= size) {
               throw new IndexOutOfBoundsException();
          }

          if (index == 0) {
               head = head.next;
               size--;
               return;
          }

          Node temp = head;

          if (index == size - 1) {
               while (temp.next.next != null) {
                    temp = temp.next;
               }
               temp.next = null;
               size--;
               return;
          }

          for (int i = 0; i < index - 1; i++) {
               temp = temp.next;
          }

          temp.next = temp.next.next;
          size--;
     }

     public int size() {
          return size;
     }
}
