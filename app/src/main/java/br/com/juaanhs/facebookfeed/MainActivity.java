package br.com.juaanhs.facebookfeed;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.top_nav);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.feed));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.request));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.users));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.watch));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.notify));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.more));


        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        postAdapter = new PostAdapter();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL);

        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.divider));
        rv.addItemDecoration(dividerItemDecoration);

        rv.setAdapter(postAdapter);

        List<Post> posts = new ArrayList<>();
        Post post1 = new Post();
        post1.setImageViewUser(R.drawable.jon_snow);
        post1.setImageViewPost(R.drawable.post_1);
        post1.setTextViewUserName("Jon Snow");
        post1.setTextViewTime("2 min");
        post1.setTextViewContent("No matter what Ygritte says, Jon Snow knows a few things. The bastard son of Ned Stark (or is he?) grew up in a house-hold where he was welcomed by Ned and his half-siblings but not so much by Catelyn Stark. When the opportunity came to join the Night's Watch at Castle Black, he saw.");
        post1.setTextViewTitle("gameofthrones.com".toUpperCase());
        post1.setTextViewSubtitle("Game of Thornes is an American fantasy drama television series created by David Benioff and D. B. Weiss. It is an adaptation ");
        posts.add(post1);


        Post post2 = new Post();
        post2.setImageViewUser(R.drawable.red_queen);
        post2.setImageViewPost(R.drawable.post_2);
        post2.setTextViewUserName("Melisandre");
        post2.setTextViewTime("5 min");
        post2.setTextViewContent("My ability to see visions in the flames, and completely trusts in the power of her god, R'hllor. Although she acknowledges that visions can be misinterpreted,[8] she has faith in her ability to correclty interpret visions, even if the vision does not entirely agree with the proposed interpretation.[4]");
        posts.add(post2);

        Post post3 = new Post();
        post3.setImageViewUser(R.drawable.sansa);
        post3.setImageViewPost(R.drawable.post_3);
        post3.setTextViewUserName("Sansa Stark");
        post3.setTextViewTime("45 min");
        post3.setTextViewContent("for years we've discovered the wonderfully complex world of westeros and followed a medley of different stories, locations, and characters, but the heart of the series has always been with the Stark family.");
        posts.add(post3);


        postAdapter.setPosts(posts);
        postAdapter.notifyDataSetChanged();
    }

    private static class PostViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewUser;
        private final TextView textViewTime;
        private final TextView textViewUserName;
        private final TextView textViewContent;
        private final ImageView imageViewPost;
        private final TextView textViewTitle;
        private final TextView textViewSubtitle;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewUser = itemView.findViewById(R.id.image_view_user);
            textViewTime = itemView.findViewById(R.id.textView_time);
            textViewUserName = itemView.findViewById(R.id.text_view_user_name);
            textViewContent = itemView.findViewById(R.id.text_view_content);
            imageViewPost = itemView.findViewById(R.id.image_view_post);
            textViewTitle = itemView.findViewById(R.id.text_view_post_title);
            textViewSubtitle = itemView.findViewById(R.id.text_view_post_subtitle);
        }

        public void bind(Post post) {
            imageViewPost.setImageResource(post.getImageViewPost());
            imageViewUser.setImageResource(post.getImageViewPost());
            imageViewUser.setImageResource(post.getImageViewUser());
            textViewTime.setText(post.getTextViewTime());
            textViewUserName.setText(post.getTextViewUserName());
            textViewContent.setText(post.getTextViewContent());
            textViewTitle.setText(post.getTextViewTitle());
            textViewSubtitle.setText(post.getTextViewSubtitle());
            if(post.getTextViewTitle() == null) {
                itemView.findViewById(R.id.post_container).setVisibility(View.GONE);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) itemView);
                constraintSet.setDimensionRatio(R.id.image_view_post,"1:1");
                constraintSet.applyTo((ConstraintLayout) itemView);
            } else {
                itemView.findViewById(R.id.post_container).setVisibility(View.VISIBLE);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) itemView);
                constraintSet.setDimensionRatio(R.id.image_view_post,"16:9");
                constraintSet.applyTo((ConstraintLayout) itemView);
            }
        }
    }

    private class PostAdapter extends RecyclerView.Adapter<PostViewHolder>{

        private List<Post> posts = new ArrayList<>();

        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.feed_item,viewGroup,false);
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
}
