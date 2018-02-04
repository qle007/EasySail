package com.easysailapp.easysail;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodActivity extends SingleFragmentActivity {
    String holder = "";
    TextView orderText;
    @Override
    protected Fragment createFragment() {
        return new FoodFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderText = (TextView) findViewById(R.id.order_textview);
        orderText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(FoodActivity.this);

                for (String e : FoodFragment.checkoutDes) {
                    holder +=e + "\n";
                }
                builder1.setMessage(holder + "Your Total is: " + FoodFragment.checkoutPrice +"\n Please Confirm:");
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "Confirm",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(FoodActivity.this);
                                builder1.setMessage("Your Order has been sent. It will arrive shortly");
                                builder1.setCancelable(true);
                                FoodFragment.checkoutPrice = 0;
                                holder = "";
                                FoodFragment.checkoutDes = new ArrayList<>();
                                builder1.setNegativeButton(
                                        "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                Intent intent = new Intent(FoodActivity.this, MenuActivity.class);
                                                startActivity(intent);
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
                                holder = "";
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
    }
}