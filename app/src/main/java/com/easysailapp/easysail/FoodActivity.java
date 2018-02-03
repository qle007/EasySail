package com.easysailapp.easysail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FoodActivity extends AppCompatActivity {
    private RecyclerView mFoodRecyclerView;
    private FoodAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        mFoodRecyclerView = (RecyclerView) findViewById(R.id.food_recycler_layout);
        mFoodRecyclerView.setLayoutManager(new LinearLayoutManager(FoodActivity.this));

        FoodMenu mFoodMenu = new FoodMenu();

        mAdapter = new FoodAdapter(mFoodMenu.getMenuItems());
        mFoodRecyclerView.setAdapter(mAdapter);


    }

    private class FoodHolder extends RecyclerView.ViewHolder{

        private TextView mFoodName;
        private TextView mDescription;
        private TextView mPrice;
        private Food mFood;

        public FoodHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.food_item, parent, false));
            mFoodName = (TextView) itemView.findViewById(R.id.food_name_text);
            mDescription = (TextView) itemView.findViewById(R.id.description_text);
            mPrice = (TextView) itemView.findViewById(R.id.price_text);
        }
        public void bind(Food food)
        {
            mFood = food;
            mFoodName.setText(mFood.getFoodName());
            mDescription.setText(mFood.getDescription());
            mPrice.setText(mFood.getPrice());
        }
    }

    private class FoodAdapter extends RecyclerView.Adapter<FoodHolder>{
        private List<Food> mFoods;

        public FoodAdapter(List<Food> foods){
            mFoods = foods;
        }

        @Override
        public FoodHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(FoodActivity.this);
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

}
