public class Main {
    public static void main(String[] args) {
        int a = 100, b = 10;
        String k = "null";
        int i;
        try {
            k.equals("k");
            i = a / b;
        }catch (ArithmeticException e) {
            i = a / 1;
        }catch (NullPointerException e) {
            i = a / 100;
            int arr[] = new int[100];
            try {
                System.out.println(arr[100]);
            }catch (ArrayIndexOutOfBoundsException ee) {

            }
        }finally {
            System.out.println("I will work any time");
        }

        i *= 10;
        System.out.println(i);
    }


}