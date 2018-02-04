package com.easysailapp.easysail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

public class MangoFeedActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MangoFeedFragment();
    }
    TextView mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mButton = (TextView) findViewById(R.id.order_textview);
        mButton.setText("Compose");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MangoFeedActivity.this,PostFeed.class);
                startActivity(intent);
            }
        });
    }


}
