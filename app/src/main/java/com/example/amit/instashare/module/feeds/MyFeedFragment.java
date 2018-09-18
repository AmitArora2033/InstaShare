package com.example.amit.instashare.module.feeds;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import butterknife.BindView;
import com.example.amit.instashare.R;
import com.example.amit.instashare.base.BaseFragment;
import com.example.amit.instashare.model.Feed;
import java.util.ArrayList;
import java.util.List;

public class MyFeedFragment extends BaseFragment implements MyFeedAdapter.FeedClickedListener {

  @BindView(R.id.fab_camera) FloatingActionButton fabCamera;
  @BindView(R.id.rcv_my_feed) RecyclerView recyclerView;
  private ArrayList<Feed> feeds;
  private MyFeedAdapter adapter;

  public static Fragment getInstance() {
    return new MyFeedFragment();
  }

  @Override public int getLayout() {
    return R.layout.fragment_my_feed;
  }

  @Override protected void initExtras() {

  }

  @Override protected void onReady() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(linearLayoutManager);
    adapter = new MyFeedAdapter(getContext(), getFeedList(), this);
    recyclerView.setAdapter(adapter);
  }

  public void showToast(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
  }

  public List<Feed> getFeedList() {

    feeds = new ArrayList<Feed>();
    feeds.add(Feed.create("Amit Arora", 23, "Caption goes like this", "", R.drawable.batman));
    feeds.add(Feed.create("Narender Modi", 1, "Sabka Sath Sabka Vikas", "", R.drawable.batman));
    return feeds;
  }

  @Override public void onLikeClicked(int position) {
    feeds.get(position).onFeedLiked();
    adapter.notifyItemChanged(position);
  }

  @Override public void onCommentClicked(int position) {

  }
}
