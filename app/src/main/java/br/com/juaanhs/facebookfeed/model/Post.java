package br.com.juaanhs.facebookfeed.model;

public class Post {

    private int imageViewUser;
    private String textViewTime;
    private String textViewUserName;
    private String TextViewContent;
    private int imageViewPost;
    private String textViewTitle;

    public int getImageViewUser() {
        return imageViewUser;
    }

    public void setImageViewUser(int imageViewUser) {
        this.imageViewUser = imageViewUser;
    }

    public String getTextViewTime() {
        return textViewTime;
    }

    public void setTextViewTime(String textViewTime) {
        this.textViewTime = textViewTime;
    }

    public String getTextViewUserName() {
        return textViewUserName;
    }

    public void setTextViewUserName(String textViewUserName) {
        this.textViewUserName = textViewUserName;
    }

    public String getTextViewContent() {
        return TextViewContent;
    }

    public void setTextViewContent(String textViewContent) {
        this.TextViewContent = textViewContent;
    }

    public int getImageViewPost() {
        return imageViewPost;
    }

    public void setImageViewPost(int imageViewPost) {
        this.imageViewPost = imageViewPost;
    }

    public String getTextViewTitle() {
        return textViewTitle;
    }

    public void setTextViewTitle(String textViewTitle) {
        this.textViewTitle = textViewTitle;
    }

    public String getTextViewSubtitle() {
        return textViewSubtitle;
    }

    public void setTextViewSubtitle(String textViewSubtitle) {
        this.textViewSubtitle = textViewSubtitle;
    }

    private String textViewSubtitle;
}
