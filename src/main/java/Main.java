import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("==Program Start==");

        Scanner sc = new Scanner(System.in);

        int lastNo = 0;

        List<Integer> articleNum = new ArrayList<>();
        List<String> articleTitle = new ArrayList<>();
        List<String> articleContents = new ArrayList<>();

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
                if (articleNum.isEmpty()) {
                    System.out.println("게시글이 없습니다.");
                } else {
                    System.out.println("번호 제목   내용");
                    for (int i = 0; i < articleNum.size(); i++) {
                        System.out.printf("%s %s %s\n", articleNum.get(i), articleTitle.get(i), articleContents.get(i));
                    }
                }

            } else if (command.equals("article write")) {
                int no = lastNo + 1;
                System.out.print("Title: ");
                String title = sc.nextLine();
                articleTitle.add(title);

                System.out.print("Contents: ");
                String contents = sc.nextLine();
                articleContents.add(contents);

                articleNum.add(no);

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

