package br.com.juaanhs.facebookfeed.ui;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.juaanhs.facebookfeed.R;
import br.com.juaanhs.facebookfeed.model.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageViewUser;
    private TextView textViewTime;
    private TextView textViewUserName;
    private TextView textViewContent;
    private ImageView imageViewPost;
    private TextView textViewTitle;
    private TextView textViewSubtitle;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        criaCampoDoPost(itemView);
    }

    private void criaCampoDoPost(@NonNull View itemView) {
        imageViewUser = itemView.findViewById(R.id.image_view_user);
        textViewTime = itemView.findViewById(R.id.textView_time);
        textViewUserName = itemView.findViewById(R.id.text_view_user_name);
        textViewContent = itemView.findViewById(R.id.text_view_content);
        imageViewPost = itemView.findViewById(R.id.image_view_post);
        textViewTitle = itemView.findViewById(R.id.text_view_post_title);
        textViewSubtitle = itemView.findViewById(R.id.text_view_post_subtitle);
    }

    public void bind(Post post) {
        adicionaDadosNoPost(post);
        if(post.getTextViewTitle() == null) {
            RemoveConteudoSite();
        } else {
            adicionaConteudoSite();
        }
    }

    private void adicionaDadosNoPost(Post post) {
        imageViewPost.setImageResource(post.getImageViewPost());
        imageViewUser.setImageResource(post.getImageViewPost());
        imageViewUser.setImageResource(post.getImageViewUser());
        textViewTime.setText(post.getTextViewTime());
        textViewUserName.setText(post.getTextViewUserName());
        textViewContent.setText(post.getTextViewContent());
        textViewTitle.setText(post.getTextViewTitle());
        textViewSubtitle.setText(post.getTextViewSubtitle());
    }

    private void adicionaConteudoSite() {
        itemView.findViewById(R.id.post_container).setVisibility(View.VISIBLE);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone((ConstraintLayout) itemView);
        constraintSet.setDimensionRatio(R.id.image_view_post,"16:9");
        constraintSet.applyTo((ConstraintLayout) itemView);
    }

    private void RemoveConteudoSite() {
        itemView.findViewById(R.id.post_container).setVisibility(View.GONE);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone((ConstraintLayout) itemView);
        constraintSet.setDimensionRatio(R.id.image_view_post,"1:1");
        constraintSet.applyTo((ConstraintLayout) itemView);
    }
}