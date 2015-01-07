package com.hungphandinh.technologies;

/**
 * Created by hungphandinh on 05-Jan-15.
 */
public class CardData {
    String txtTitle;
    String txtContent;
    String txtTime;
    String txtPage;
    String imgLink;
    String urlFeed;
    int imgIcon;

    public CardData(String txtTitle, String txtContent, String txtTime, String txtPage, int imgIcon) {
        this.txtTitle = txtTitle;
        this.txtContent = txtContent;
        this.txtTime = txtTime;
        this.txtPage = txtPage;
        this.imgIcon = imgIcon;
    }

    public CardData(String txtTitle, String txtContent, String txtTime, String txtPage, String imgLink, String urlFeed, int imgIcon) {
        this.txtTitle = txtTitle;
        this.txtContent = txtContent;
        this.txtTime = txtTime;
        this.txtPage = txtPage;
        this.imgLink = imgLink;
        this.urlFeed = urlFeed;
        this.imgIcon = imgIcon;
    }
}
