public class my {
     public static void main(String[] args) {

          MyLinkedList linkedList = new MyLinkedList();
linkedList.addLast(5);
linkedList.addLast(10);
linkedList.addLast(15);
linkedList.addLast(20);
linkedList.addFirst(30);

linkedList.remove(10);
          linkedList.printList();
MonTh monTh=MonTh.APRIL;
          switch (monTh) {
               case APRIL:
                    linkedList.addLast(15);
                    break;


          }

     }
}
