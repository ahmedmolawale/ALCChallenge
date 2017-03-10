package com.alc.alcchallenge.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.alc.alcchallenge.R;
import com.alc.alcchallenge.activity.GitHubDeveloperDetails;
import com.alc.alcchallenge.model.GitHubUser;
import com.koushikdutta.ion.Ion;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class DeveloperListAdapter extends RecyclerView.Adapter<DeveloperListAdapter.GitHubUserViewHolder> {

    private Context context;
    private List<GitHubUser> gitHubUsers;


    public DeveloperListAdapter(Context context, List<GitHubUser> gitHubUsers) {

        this.context = context;
        this.gitHubUsers = gitHubUsers;
    }

    @Override
    public GitHubUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.github_user_card_view, parent, false);
        return new GitHubUserViewHolder(view, context, this.gitHubUsers);

    }

    @Override
    public void onBindViewHolder(GitHubUserViewHolder holder, int position) {

        GitHubUser gitHubUser = gitHubUsers.get(position);
        //loading the image with the ION library
        final float ROTATE_FROM = 0.0f;
        final float ROTATE_TO = -10.0f * 360.0f;
        RotateAnimation r;
        r = new RotateAnimation(ROTATE_FROM, ROTATE_TO, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        Ion.with(context)
                .load(gitHubUser.getAvatar_url())
                .withBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).animateIn(r)
                .intoImageView(holder.gitHubUserImage);
        holder.gitHubUsername.setText(gitHubUser.getLogin());
    }

    @Override
    public int getItemCount() {
        return gitHubUsers.size();
    }

    private static class GitHubUserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CircleImageView gitHubUserImage;
        private TextView gitHubUsername;
        private Context context;
        private List<GitHubUser> gitHubUsers;
        private CardView gitHubUserCardView;

        public GitHubUserViewHolder(View itemView, Context context, List<GitHubUser> gitHubUsers) {
            super(itemView);
            this.gitHubUserImage = (CircleImageView) itemView.findViewById(R.id.user_image);
            this.gitHubUsername = (TextView) itemView.findViewById(R.id.user_name);
            this.context = context;
            this.gitHubUsers = gitHubUsers;
            this.gitHubUserCardView = (CardView) itemView.findViewById(R.id.github_user_card_view);
            this.gitHubUserCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(this.context, GitHubDeveloperDetails.class);
            intent.putExtra(Intent.EXTRA_TEXT, gitHubUsers.get(getAdapterPosition()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.context.startActivity(intent);

        }
    }
}
