package com.easysailapp.easysail;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    private ImageView foodButton;
    private ImageView callButton;
    private ImageView maintenanceButton;
    private ImageView cleanButton;
    private ImageView mangoFeedImage; //takes u to the cool secret chat

    private String itemSelected;
    private String[] maintenanceList = {"Shower", "Toilet", "Lighting", "Electricity", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        foodButton = (ImageView) findViewById(R.id.food_button);
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });

        mangoFeedImage = (ImageView) findViewById(R.id.mango_button);
        mangoFeedImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,MangoFeedActivity.class);
                startActivity(intent);
            }
        });
        callButton = (ImageView) findViewById(R.id.call_button);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MenuActivity.this);
                builder1.setMessage("Please confirm that you want to call us.").setTitle("Call us");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Confirm",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:" + "1 (800) 111 1111"));
                                if (intent.resolveActivity(getPackageManager()) != null) {
                                    startActivity(intent);
                                }
                            }
                        });

                builder1.setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });


        maintenanceButton = (ImageView) findViewById(R.id.maintenance_button);
        maintenanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("Select a maintenance:");
                builder.setItems(maintenanceList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        itemSelected = maintenanceList[i];
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MenuActivity.this);
                        builder1.setMessage("Your request for "+ itemSelected + " has been sent. Someone will be there shortly to help you.");
                        builder1.setCancelable(true);

                        builder1.setNegativeButton(
                                "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        FoodFragment.checkoutPrice = 0;
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                });
                builder.setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(MenuActivity.this);
                                builder1.setMessage("Your request has been canceled");
                                builder1.setCancelable(true);

                                builder1.setNegativeButton(
                                        "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });

                                AlertDialog alert11 = builder1.create();
                                alert11.show();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });


        cleanButton = (ImageView) findViewById(R.id.clean_button);
        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MenuActivity.this);
                builder1.setMessage("Please confirm that you need your room cleaned").setTitle("Cleaning Service");
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "Confirm",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(MenuActivity.this);
                                builder1.setMessage("Your request has been sent. Someone will be there shortly to help you.");
                                builder1.setCancelable(true);

                                builder1.setNegativeButton(
                                        "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });

                                AlertDialog alert11 = builder1.create();
                                alert11.show();
                            }
                        });

                builder1.setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(MenuActivity.this);
                                builder1.setMessage("Your request has been canceled");
                                builder1.setCancelable(true);

                                builder1.setNegativeButton(
                                        "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });

                                AlertDialog alert11 = builder1.create();
                                alert11.show();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
    }
}
