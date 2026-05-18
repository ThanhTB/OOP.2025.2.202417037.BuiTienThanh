package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<>();

    public Book() {
        super();
    }
    
    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public void addAuthor(String authorName){
        if(authorInAuthorList(authorName)){
            System.out.println("Existed");
        }
        else{
            try {
                authors.add(authorName);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void removeAuthor(String authorName){
        if(!authorInAuthorList(authorName)){
            System.out.println("Not Existed");
        }
        else{
            try {
                authors.remove(authorName);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public boolean authorInAuthorList(String authorName){
        return authors.contains(authorName);
    }
}
