package com.easysailapp.easysail;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quoc on 2/4/2018.
 */

public class UserLab {
    List<User> Users = new ArrayList<>();
    private static UserLab sUserLab;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("User");



    public static UserLab get(Context context){
        if(sUserLab == null){
            sUserLab = new UserLab(context);
        }
        return sUserLab;
    }

    public List<User> getUserItems() {
        return Users;
    }

    private UserLab(Context context){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Users = new ArrayList<>();
                for(DataSnapshot e : dataSnapshot.getChildren())
                {

                    String key = e.getKey();
                    String name = dataSnapshot.child(key).child("name").getValue(String.class);
                    String message = dataSnapshot.child(key).child("message").getValue(String.class);

                    Users.add(new User(name,message));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("read from data ", "Failed to read value.", error.toException());
            }
        });
    }


}
