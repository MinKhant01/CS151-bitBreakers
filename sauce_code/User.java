package redditClone;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;
import java.util.Date;

public class User {
    private int userID;
    static int userCount = 0;
    private String username;
    private String password;
    private String userLastName;
    private String userFirstName;
    private long timestamp;
    private String displayTimeStamp;
    ArrayList<Content> userContent;
    Thread [] userThread;
    Page userPage;

    public User(String username, String password, String userFirstName, String userLastName){
        userCount++;
        userID = userCount;

        this.username = username;
        this.password = password;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;

        String displayTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        long timeStamp = System.currentTimeMillis();

        userContent = new ArrayList<Content>();



    }

    // boolean displayUser();

    boolean makePost(String s){
        Content c = new Content(s);
        userContent.add(c);
        return true;
    }

    boolean deletePost(int id) {

        for(int i = 0; i < userContent.size(); i++){
            if(userContent.get(i).getContentID() == id){
                 userContent.remove(i);
                 break;
            }
        }
        return true;

    }

    boolean makeThread(String comment, int id) {

        for(int i = 0; i < userContent.size(); i++){
            if(userContent.get(i).getContentID() == id){
                Content c = userContent.get(i);
                //get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment));
                break;
            }
        }


        return true;

    }

    boolean makeComment(String comment, int contentID, int threadID) {

        for(int i = 0; i < userContent.size(); i++){
            if(userContent.get(i).getContentID() == contentID){
                Content c = userContent.get(i);
                //get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment));

                ArrayList<CommentThread> thread = c.getThread();

                for(int j = 0;  j < thread.size(); j++){
                    if(thread.get(j).getID() == threadID){
                        thread.get(j).add(new Comment(comment));
                        break;
                    }
                }
                break;
            }
        }


        return true;

    }


    boolean updateCommentThread(String comment, int contentID, int threadID) {

        for(int i = 0; i < userContent.size(); i++){
            if(userContent.get(i).getContentID() == contentID){
                Content c = userContent.get(i);
                //get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment));

                ArrayList<CommentThread> thread = c.getThread();

                for(int j = 0;  j < thread.size(); j++){
                    if(thread.get(j).getID() == threadID){
                        thread.get(j).set(comment);
                        break;
                    }
                }
                break;
            }
        }


        return true;
    }

    boolean deleteCommentThread(String comment, int contentID, int threadID) {

        for(int i = 0; i < userContent.size(); i++){
            if(userContent.get(i).getContentID() == contentID){
                Content c = userContent.get(i);
                //get threads returns arrayList of threads
                c.getThread().add(new CommentThread(comment));

                ArrayList<CommentThread> thread = c.getThread();

                for(int j = 0;  j < thread.size(); j++){
                    if(thread.get(j).getID() == threadID){
                        thread.get(j).remove(threadID);
                        break;
                    }
                }
                break;
            }
        }


        return true;
    }

}