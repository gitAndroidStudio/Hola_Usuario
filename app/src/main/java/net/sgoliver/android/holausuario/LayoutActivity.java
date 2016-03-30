package net.sgoliver.android.holausuario;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class LayoutActivity extends AppCompatActivity {

    private Button btnFrameLayout;
    private Button btnLinearLayout;
    private Button btnTableLayout;
    private Button btnGridLayout;
    private Button btnRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        btnFrameLayout = (Button) findViewById(R.id.BtnFrameLayout);
        btnFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LayoutActivity.this, FrameLayoutActivity.class);
                startActivity(intent);
            }
        });

        btnLinearLayout = (Button) findViewById(R.id.BtnLinearLayout);
        btnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LayoutActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
            }
        });

        btnTableLayout = (Button) findViewById(R.id.BtnTableLayout);
        btnTableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LayoutActivity.this, TableLayoutActivity.class);
                startActivity(intent);
            }
        });

        btnGridLayout = (Button) findViewById(R.id.BtnGridLayout);
        btnGridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LayoutActivity.this, GridLayoutActivity.class);
                startActivity(intent);
            }
        });

        btnRelativeLayout = (Button) findViewById(R.id.BtnRelativeLayout);
        btnRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LayoutActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }
}
