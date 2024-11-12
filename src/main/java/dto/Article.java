package dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Article {
    public int id;
    public String title;
    public String body;
    public String nowTime;

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
