package news.app;

import android.graphics.Bitmap;

import androidx.fragment.app.Fragment;

public class News {
    private String newsTitle;
    private Bitmap newsIcon;
    private int ids;

    public News(int ids, String newsTitle, Bitmap newsIcon) {
        this.ids = ids;
        this.newsTitle = newsTitle;
        this.newsIcon = newsIcon;
    }

    public int getIds() {
        return ids;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public Bitmap getNewsIcon() {
        return newsIcon;
    }

    public void setIds(int id) {
        this.ids = id;
    }

    public void setNewsTitle(String title) {
        this.newsTitle = title;
    }

    public void setNewsIcon(Bitmap newsIcon) {
        this.newsIcon = newsIcon;
    }
}
