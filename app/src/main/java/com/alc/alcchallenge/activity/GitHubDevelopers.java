package com.alc.alcchallenge.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alc.alcchallenge.R;
import com.alc.alcchallenge.adapter.DeveloperListAdapter;
import com.alc.alcchallenge.model.GitHubUser;
import com.alc.alcchallenge.rest.ApiClient;
import com.alc.alcchallenge.rest.ApiInterface;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitHubDevelopers extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_developers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        makeApiCall();

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.makeApiCall();
    }

    /**
     * @param
     * @return
     * @class GitHubDevelopers
     * <p>
     * A method to make the Api Service call
     */
    private void makeApiCall() {
        progressBar.setVisibility(View.VISIBLE);
        //progressBar.setVisibility(View.VISIBLE);
        final String SEARCH_TERMS = "language:java location:lagos";
        final String TYPE = "user";
        final String ITEMS_PER_PAGE = "100";
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<com.alc.alcchallenge.model.GitHubUsers> call = apiService.getUsers(SEARCH_TERMS, TYPE, ITEMS_PER_PAGE);

        //asynchronously call to the api
        call.enqueue(new Callback<com.alc.alcchallenge.model.GitHubUsers>() {
            @Override
            public void onResponse(Call<com.alc.alcchallenge.model.GitHubUsers> call, Response<com.alc.alcchallenge.model.GitHubUsers> response) {
                progressBar.setVisibility(View.GONE);
                com.alc.alcchallenge.model.GitHubUsers gitHubUsersBody = response.body();
                call.request().url().toString();


                if (gitHubUsersBody == null) {
                    //404 not found or could not convert response to UserResponse object
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        try {
                            Toast toast = Toast.makeText(getApplicationContext(), "Response body " + responseBody.string(), Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Response body is null", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                    }


                } else {
                    List<GitHubUser> gitHubUsers = response.body().getItems();
                    if (gitHubUsers.size() == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "No user found. Swipe to refresh.", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    } else {
                        //create the developer list adapter here
                        DeveloperListAdapter developerListAdapter = new DeveloperListAdapter(getApplicationContext(), gitHubUsers);
                        recyclerView.setAdapter(developerListAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<com.alc.alcchallenge.model.GitHubUsers> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                AlertDialog.Builder builder = new AlertDialog.Builder(GitHubDevelopers.this);
                builder.setTitle("Error");
                builder.setMessage(t.getMessage());


                builder.setCancelable(true);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

    }

}
