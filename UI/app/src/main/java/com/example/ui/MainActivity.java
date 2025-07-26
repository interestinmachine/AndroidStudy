package com.example.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    private ImageView imageView;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button1);
        editText = (EditText)findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.img_view);
        progressBar = (ProgressBar)findViewById(R.id.processBar);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
//            if (progressBar.getVisibility() == View.VISIBLE) {
//                progressBar.setVisibility(View.GONE);
//            } else {
//                progressBar.setVisibility(View.VISIBLE);
//            }
//            progressBar.setProgress(progressBar.getProgress()+10);
//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            builder.setTitle("title");
//            builder.setMessage("message");
//            builder.setCancelable(false);
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//
//                }
//            });
//            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//
//                }
//            });
//            builder.show();
            Dialog dialog = new ProgressDialog(MainActivity.this);
            dialog.setCancelable(true);
            dialog.setTitle("AAA");

        }
    }
}