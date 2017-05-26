package com.kus.mydiabetes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;
    CardView cardPengertian, cardGejala, cardTipe, cardKomplikasi, cardPencegahan, cardKontrol, cardPengobatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardPengertian = (CardView) findViewById(R.id.cardPengertian);
        cardPengertian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artikel(getStringFromR(R.string.titlePengertian), getStringFromR(R.string.bodyPengertian));
            }
        });

        cardGejala = (CardView) findViewById(R.id.cardGejala);
        cardGejala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artikel(getStringFromR(R.string.titleGejala), getStringFromR(R.string.bodyGejala));
            }
        });

        cardTipe = (CardView) findViewById(R.id.cardTipe);
        cardTipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artikel(getStringFromR(R.string.titleTipe), getStringFromR(R.string.bodyTipe));
            }
        });

        cardKomplikasi = (CardView) findViewById(R.id.cardKomplikasi);
        cardKomplikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artikel(getStringFromR(R.string.titleKomplikasi), getStringFromR(R.string.bodyKomplikasi));
            }
        });

        cardPencegahan = (CardView) findViewById(R.id.cardPencegahan);
        cardPencegahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artikel(getStringFromR(R.string.titlePencegahan), getStringFromR(R.string.bodyPencegahan));
            }
        });

        cardKontrol = (CardView) findViewById(R.id.cardKontrol);
        cardKontrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artikel(getStringFromR(R.string.titleKontrol), getStringFromR(R.string.bodyKontrol));
            }
        });

        cardPengobatan = (CardView) findViewById(R.id.cardPengobatan);
        cardPengobatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artikel(getStringFromR(R.string.titlePengobatan), getStringFromR(R.string.bodyPengobatan));
            }
        });

    }

    @Override
    public void onBackPressed() {
        //Checking for fragment count on backstack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this,"Tekan tombol Back lagi untuk keluar.", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();
            return;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAbout:
                //TODO about apps
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                break;
            case R.id.menuExit:
                //TODO exit apps
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Anda yakin mau keluar ?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog quit = builder.create();
                quit.show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    public String getStringFromR(int id){
        return getResources().getString(id);
    }

    public void artikel(String title, String body){
        Intent intent = new Intent(this, ArticleActivity.class);
        intent.putExtra("ARTICLE_TITLE", title);
        intent.putExtra("ARTICLE_BODY", body);
        startActivity(intent);
    }


}
