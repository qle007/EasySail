package com.easysailapp.easysail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostFeed extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("User");
    EditText mName;
    EditText mMessage;
    Button mPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_feed);

        mName = (EditText) findViewById(R.id.username_id);
        mMessage = (EditText) findViewById(R.id.dialog_message_id);
        mPost = (Button) findViewById(R.id.post_button);

        mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.push().setValue(new User(mName.getText().toString(),mMessage.getText().toString()));
                Intent intent = new Intent(PostFeed.this, MangoFeedActivity.class);
                startActivity(intent);
            }
        });




    }
}
