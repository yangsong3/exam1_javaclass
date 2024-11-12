import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 ==");

        Scanner sc = new Scanner(System.in);

        int lastArticleId = 0;

        List<Article> articles = new ArrayList<>();

        while (true) {
            System.out.printf("명령어) ");
            String command = sc.nextLine();
            command = command.trim();

            if (command.length() == 0) {
                continue;
            }

            if (command.equals("exit")) {
                break;
            } else if (command.equals("article list")) {
                if (articles.size() == 0) {
                    System.out.println("게시글이 없습니다.");
                    continue;
                }

                System.out.println("번호, 제목, 내용");
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);

                    System.out.printf("%d, %s\n", article.id, article.title);

                }
            } else if (command.equals("article write")) {
                int id = lastArticleId + 1;
                System.out.printf("제목 : ");
                String title = sc.nextLine();
                System.out.printf("내용 : ");
                String body = sc.nextLine();

                Article article = new Article(id, title, body);
                articles.add(article);

                lastArticleId = id;

                System.out.printf("%d번 글이 생성되었습니다.\n", id);
            } else if (command.startsWith("article detail ")) {
                String[] commandBits = command.split(" ", 3);
                int id = Integer.parseInt(commandBits[2]);

                Article foundArticle = null;

                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    if (article.id == id) {
                        foundArticle = article;
                        break;
                    }
                }

                if (foundArticle == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    continue;
                }

                System.out.printf("번호: %d\n", id);
                System.out.printf("날짜: %s\n", foundArticle.nowTime);
                System.out.printf("제목: %s\n", foundArticle.title);
                System.out.printf("내용: %s\n", foundArticle.body);


            } else if (command.startsWith("article delete ")) {
                String[] commandBits = command.split(" ", 3);
                int id = Integer.parseInt(commandBits[2]);

                Article foundArticle = null;

                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    if (article.id == id) {
                        foundArticle = article;
                        break;
                    }
                }

                if (foundArticle == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    continue;
                }
                id = id - 1;
                articles.remove(articles.get(Integer.valueOf(id)));

                System.out.printf("%d번 게시물이 삭제되었습니다.\n", id+1);

            } else {
                System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", command);
            }

        }

        sc.close();
        System.out.println("== 프로그램 끝 ==");
    }
}

class Article {
    int id;
    String title;
    String body;
    String nowTime;

    public Article(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;

        Date now = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(now);
        this.nowTime = nowTime;

    }


}
