package com.example.amit.instashare.module.feeds;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.amit.instashare.R;
import com.example.amit.instashare.model.Feed;
import java.util.List;

public class MyFeedAdapter extends RecyclerView.Adapter<MyFeedAdapter.ViewHolder> {

  private final Context context;
  private List<Feed> feedList;
  private final LayoutInflater layoutInflater;
  private final FeedClickedListener listener;
  private final RequestOptions requestOptions;

  public MyFeedAdapter(Context context, FeedClickedListener listener) {
    this.context = context;

    this.listener = listener;
    this.layoutInflater = LayoutInflater.from(context);
    this.requestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL);
  }

  public void setData(List<Feed> feedList) {
    this.feedList = feedList;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(layoutInflater.inflate(R.layout.item_my_feed, parent, false), listener);
  }

  @Override public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.friendName.setText(feedList.get(position).getFriendName());
    holder.friendNameCaption.setText(feedList.get(position).getFriendName());
    holder.feedCaption.setText(feedList.get(position).getCaption());
    holder.feedImage.setImageURI(feedList.get(position).getImgeUri());
    holder.ivLike.setImageResource(feedList.get(position).isLikedByUser() ? R.drawable.ic_heart_red
        : R.drawable.ic_heart_outline_grey);

    Glide.with(context)
        .load(R.drawable.anaonymus)
        .apply(RequestOptions.circleCropTransform())
        .into(holder.ivFriendProfileImage);
    holder.tvNoOfLikes.setText(String.valueOf(feedList.get(position).getLikes()));
  }

  @Override public int getItemCount() {
    return feedList.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_friend_profile_image) ImageView ivFriendProfileImage;
    @BindView(R.id.tv_friend_name) TextView friendName;
    @BindView(R.id.img_feed) ImageView feedImage;
    @BindView(R.id.tv_friend_name_caption) TextView friendNameCaption;
    @BindView(R.id.tv_feed_caption) TextView feedCaption;
    @BindView(R.id.iv_like) ImageView ivLike;
    @BindView(R.id.iv_comment) ImageView ivComment;
    @BindView(R.id.iv_share) ImageView ivShare;
    @BindView(R.id.tv_no_of_likes) TextView tvNoOfLikes;

    ViewHolder(final View itemView, final FeedClickedListener listener) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      ivLike.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          listener.onLikeClicked(getAdapterPosition());
        }
      });
    }
  }

  interface FeedClickedListener {

    void onLikeClicked(int position);

    void onCommentClicked(int position);
  }
}
