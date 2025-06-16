public class Main3 {
    public static void main(String[] args) {
        System.out.println(finallyTrickQuestions());

//        throw, throws, exception propagation

//        final, finally, finalize
    }

    public static int finallyTrickQuestions() {
        String s = "Hello";
        try {
            String substring = s.substring(1);
            System.exit(0);
            return 10;
        }finally {
            System.out.println("I will work or not");
        }
    }
}
