import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("==Program Start==");

        Scanner sc = new Scanner(System.in);
        System.out.printf("command: ");
        String command = sc.nextLine();
        System.out.printf("input>> %s\n",command);
        int num = sc.nextInt();
        System.out.printf("num: %d\n", num);
        sc.close();
        System.out.println("==Program End==");
    }
}