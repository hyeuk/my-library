package com.example.naman_dy2;

public class BookSave {

    private String booktitle;
    private String bookimage;
    private String bookauthor;


    public BookSave(){}

    public String getBooktitle() {
        return booktitle;
    }

    public void setBookTitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getBookImage() {
        return bookimage;
    }

    public void setBookImage(String bookimage) {
        this.bookimage = bookimage;
    }

    public String getBookAuthor() {
        return bookauthor;
    }

    public void setBookAuthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public BookSave(String booktitle, String bookimage, String bookauthor){
        this.booktitle = booktitle;
        this.bookimage = bookimage;
        this.bookauthor = bookauthor;
    }
}
