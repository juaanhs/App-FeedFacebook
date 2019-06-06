package br.com.juaanhs.facebookfeed;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.juaanhs.facebookfeed.adapter.PostAdapter;
import br.com.juaanhs.facebookfeed.model.Post;

public class FeedActivity extends AppCompatActivity {

    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        TabLayout tabLayout = findViewById(R.id.top_nav);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.feed));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.request));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.users));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.watch));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.notify));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.more));


        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        postAdapter = new PostAdapter(this);

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


}
