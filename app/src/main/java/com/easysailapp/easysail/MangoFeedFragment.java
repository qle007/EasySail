package com.easysailapp.easysail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Quoc on 2/3/2018.
 */

public class MangoFeedFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private FeedAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mango_feed, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.feed_recycler_layout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI();

        return view;
    }

    private class FeedHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView message;

        public FeedHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.feed_item, parent, false));
            name = (TextView) itemView.findViewById(R.id.name_id);
            message = (TextView) itemView.findViewById(R.id.message_id);

        }

        public void bind(User user){


        }

    }

    private class FeedAdapter extends RecyclerView.Adapter<FeedHolder>{
        private List<User> mUsers;
        public FeedAdapter(List<User> users){
            mUsers = users;
        }

        @Override
        public FeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new FeedHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(FeedHolder holder, int position) {
            User user = mUsers.get(position);
            holder.bind(user);
        }

        @Override
        public int getItemCount() {
            return mUsers.size();
        }

    }

    private void updateUI(){
        UserLab userLab = UserLab.get(getActivity());
        List<User> users = userLab.getUserItems();
        mAdapter = new FeedAdapter(users);
        mRecyclerView.setAdapter(mAdapter);
    }
}
