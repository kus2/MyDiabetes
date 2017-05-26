package com.kus.mydiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {

    TextView textTitle, textBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        textTitle = (TextView) findViewById(R.id.articleTitle);
        textBody = (TextView) findViewById(R.id.articleBody);

        Intent intentIn= getIntent();
        Bundle intentData = intentIn.getExtras();
        if(intentData != null){
            String title = (String) intentData.get("ARTICLE_TITLE");
            String body = (String) intentData.get("ARTICLE_BODY");

            setTitle(title);
            textTitle.setText(title +" "+ getResources().getString(R.string.appText));
            textBody.setText(body);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
