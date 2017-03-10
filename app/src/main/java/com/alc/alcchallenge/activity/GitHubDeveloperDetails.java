package com.alc.alcchallenge.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alc.alcchallenge.R;
import com.alc.alcchallenge.model.GitHubUser;
import com.koushikdutta.ion.Ion;

public class GitHubDeveloperDetails extends AppCompatActivity {


    GitHubUser gitHubUser;
    private TextView username;
    private ImageView profilePhoto;
    private TextView profileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.git_hub_developer_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_developer_details);
        setSupportActionBar(toolbar);

        username = (TextView) findViewById(R.id.username_on_details);
        profilePhoto = (ImageView) findViewById(R.id.profile_photo);
        profileUrl = (TextView) findViewById(R.id.profile_url);


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            gitHubUser = (GitHubUser) intent.getSerializableExtra(Intent.EXTRA_TEXT);
            username.setText(gitHubUser.getLogin());
            //loading the image
            Ion.with(this)
                    .load(gitHubUser.getAvatar_url())
                    .withBitmap()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .intoImageView(profilePhoto);
            profileUrl.setText(gitHubUser.getHtml_url());
            profileUrl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(gitHubUser.getHtml_url()));
                    startActivity(intent);

                }
            });
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.git_hub_developer_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_share) {
            //Intent intent = new Intent();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            String shareText = "Check out this awesome developer @ " + gitHubUser.getLogin()
                    + ", " + gitHubUser.getHtml_url();
            sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}