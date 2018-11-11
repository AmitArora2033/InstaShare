package com.example.amit.instashare.module.feeds;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import butterknife.BindView;
import com.example.amit.instashare.R;
import com.example.amit.instashare.base.BaseFragment;
import com.example.amit.instashare.base.ViewModelProviderFactory;
import com.example.amit.instashare.model.Feed;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class MyFeedFragment extends BaseFragment
    implements MyFeedAdapter.FeedClickedListener, MyFeedView {
  @BindView(R.id.rcv_my_feed) RecyclerView recyclerView;

  private ArrayList<Feed> feeds;
  private MyFeedAdapter adapter;
  @Inject MyFeedViewModel viewModel;
  @Inject ViewModelProvider.Factory factory;

  public static Fragment getInstance() {
    return new MyFeedFragment();
  }

  @Override protected void supportAndroidInjecton() {
    AndroidSupportInjection.inject(this);
  }

  @Override protected void detachView() {
    viewModel.detachView();
  }

  @Override public int getLayout() {
    return R.layout.fragment_my_feed;
  }

  @Override protected void initExtras() {

  }

  @Override protected void initDependencies() {
    viewModel = ViewModelProviders.of(this, factory).get(MyFeedViewModel.class);
    viewModel.attachView(this);
  }

  @Override protected void initViews() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(linearLayoutManager);
  }

  @Override protected void onReady() {
    viewModel.getLocalDeviceFeeds();
  }

  public void showToast(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
  }

  @Override public void onLikeClicked(int position) {
    feeds.get(position).onFeedLiked();
    adapter.notifyItemChanged(position);
  }

  @Override public void onCommentClicked(int position) {

  }

  @Override public void showFeedList(List<Feed> feedList) {
    this.feeds = (ArrayList<Feed>) feedList;
    adapter = new MyFeedAdapter(getContext(), this);
    recyclerView.setAdapter(adapter);

    adapter.setData(feeds);
  }
}
