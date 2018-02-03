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

public class FoodFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private FoodAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_food, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.food_recycler_layout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private class FoodHolder extends RecyclerView.ViewHolder{
        private Food mFood;
        private TextView mFoodNameTextView;
        private TextView mPriceTextView;
        private TextView mDescriptionTextView;

        public FoodHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.food_item, parent, false));
            mFoodNameTextView = (TextView) itemView.findViewById(R.id.food_name_text);
            mDescriptionTextView = (TextView) itemView.findViewById(R.id.description_text);
            mPriceTextView = (TextView) itemView.findViewById(R.id.price_text);
        }

        public void bind(Food food){
            mFood = food;
            mFoodNameTextView.setText(mFood.getFoodName());
            mDescriptionTextView.setText(mFood.getDescription());
            mPriceTextView.setText(mFood.getPrice());
        }

    }

    private class FoodAdapter extends RecyclerView.Adapter<FoodHolder>{
        private List<Food> mFoods;
        public FoodAdapter(List<Food> foods){
           mFoods = foods;
        }

        @Override
        public FoodHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new FoodHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(FoodHolder holder, int position) {
            Food food = mFoods.get(position);
            holder.bind(food);
        }

        @Override
        public int getItemCount() {
            return mFoods.size();
        }

    }

    private void updateUI(){
        FoodMenu foodMenu = FoodMenu.get(getActivity());
        List<Food> foods = foodMenu.getMenuItems();
        mAdapter = new FoodAdapter(foods);
        mRecyclerView.setAdapter(mAdapter);
    }
}
