package br.com.juaanhs.facebookfeed.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.juaanhs.facebookfeed.FeedActivity;
import br.com.juaanhs.facebookfeed.R;
import br.com.juaanhs.facebookfeed.model.Post;
import br.com.juaanhs.facebookfeed.ui.PostViewHolder;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder>{

    private FeedActivity feedActivity;
    private List<Post> posts = new ArrayList<>();

    public PostAdapter(FeedActivity feedActivity) {
        this.feedActivity = feedActivity;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = feedActivity.getLayoutInflater().inflate(R.layout.feed_item,viewGroup,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        Post post = posts.get(i);
        postViewHolder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
