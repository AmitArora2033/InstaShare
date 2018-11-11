package com.example.amit.instashare.model;

import android.net.Uri;
import java.util.List;

public class Feed {

  private Uri imageUri;
  private String FriendName;
  private int likes;
  private String caption;
  private List<String> commentsList;
  private boolean isLikedByUser;

  public static Feed create(String ownerName, int likes, String caption, Uri imageUri) {
    return new Feed(ownerName, likes, caption, imageUri);
  }

  private Feed(String ownerName, int likes, String caption, Uri imageUri) {
    this.FriendName = ownerName;
    this.likes = likes;
    this.caption = caption;
    this.imageUri = imageUri;
  }

  public boolean isLikedByUser() {
    return isLikedByUser;
  }

  public void setLikedByUser(boolean likedByUser) {
    isLikedByUser = likedByUser;
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

  public Uri getImgeUri() {
    return imageUri;
  }

  public void setImgeUri(String imgeUrl) {
    this.imageUri = imageUri;
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
