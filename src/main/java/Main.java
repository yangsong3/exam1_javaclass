import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("==Program Start==");

        Scanner sc = new Scanner(System.in);

        int lastNo = 0;

        while (true) {
            System.out.printf("command: ");
            String command = sc.nextLine();
            command = command.trim();

            if (command.length() == 0) {
                continue;
            }

            if (command.equals("exit")) {
                break;
            } else if (command.equals("article list")) {
                System.out.println("게시글이 없습니다.");

            } else if (command.equals("article write")) {
                int no = lastNo + 1;
                System.out.printf("%d번 글이 생성되었습니다.\n", no);
                lastNo = no;
            } else {
                System.out.printf("%s (은)는 존재하지 않는 명령어입니다.\n", command);
            }
        }
        sc.close();
        System.out.println("==Program End==");
    }
}