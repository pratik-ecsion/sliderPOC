package com.ecsion.sliderpoc;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

public class ActUsers extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_users);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView rvUser = findViewById(R.id.rvUser);
        AdpUsers adpUsers = new AdpUsers(getApplicationContext());
        rvUser.setAdapter(adpUsers);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvUser.getContext(),
                DividerItemDecoration.VERTICAL);
        rvUser.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
