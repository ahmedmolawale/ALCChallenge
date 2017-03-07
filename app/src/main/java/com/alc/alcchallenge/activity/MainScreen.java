package com.alc.alcchallenge.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.alc.alcchallenge.R;
import com.alc.alcchallenge.model.User;
import com.alc.alcchallenge.model.UsersResponse;
import com.alc.alcchallenge.rest.ApiClient;
import com.alc.alcchallenge.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        makeApiCall();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    /**
     * @class MainScreen
     *
     * A method to make the Api Service call
     *
     *@param
     *@return
     */
    private void makeApiCall() {



        final String SEARCH_TERMS = "language:java+location:lagos";
        final String TYPE = "user";
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<UsersResponse> call = apiService.getUsers(SEARCH_TERMS,TYPE);

        //asynchronously call to the api
        call.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {

                List<User> users = response.body().getItems();
                Toast toast = Toast.makeText(getApplicationContext(), "No of users Received: " + users.size(), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainScreen.this);
                builder.setTitle("Error");
                builder.setMessage(t.toString());

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

    private boolean isOnline() {
        ConnectivityManager conn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conn.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;

        } else {
            return false;
        }
    }

}
