package com.example.amit.instashare.model;

import java.util.List;

public class Feed {

  private String FriendName;

  private int likes;

  private String caption;

  private String imgeUrl;

  private int imageResorceID;

  private List<String> commentsList;

  private boolean isLikedByUser;


  public static Feed create(String ownerName, int likes, String caption, String imgeUrl) {
    return Feed.create(ownerName, likes, caption, imgeUrl, 0);
  }

  public static Feed create(String ownerName, int likes, String caption, String imageUrl,
      int imageResourceID) {
    return new Feed(ownerName, likes, caption, imageUrl, imageResourceID);
  }

  private Feed(String ownerName, int likes, String caption, String imageUrl, int imageResourceID) {
    this.FriendName = ownerName;
    this.likes = likes;
    this.caption = caption;
    this.imgeUrl = imageUrl;
    this.imageResorceID = imageResourceID;
  }



  public boolean isLikedByUser() {
    return isLikedByUser;
  }

  public void setLikedByUser(boolean likedByUser) {
    isLikedByUser = likedByUser;
  }

  public int getImageResourceID() {
    return imageResorceID;
  }

  public void setImageResourceID(int imageResorceID) {
    this.imageResorceID = imageResorceID;
  }



  public String getFriendName() {
    return FriendName;
  }

  public void setFriendName(String friendName) {
    this.FriendName = friendName;
  }

  public int getLikes() {
    return likes;
  }

  public void setLikes(int likes) {
    this.likes = likes;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public String getImgeUrl() {
    return imgeUrl;
  }

  public void setImgeUrl(String imgeUrl) {
    this.imgeUrl = imgeUrl;
  }

  private void increaseLikeCount() {
    setLikes(getLikes() + 1);
  }

  private void decreaseLikeCount() {
    setLikes(getLikes() - 1);
  }

  public void onFeedLiked() {
    if (isLikedByUser) {
      decreaseLikeCount();
      setLikedByUser(false);
    } else {
      increaseLikeCount();
      setLikedByUser(true);
    }
  }

  public List<String> getCommentsList() {
    return commentsList;
  }

  public void setCommentsList(List<String> commentsList) {
    this.commentsList = commentsList;
  }
}
