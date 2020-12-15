package com.example.travelguide.HelperClasses.HomeAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelguide.HelperClasses.FetchData_restaurant;
import com.example.travelguide.R;

import java.util.List;

public class HelperAdapter_restaurant extends RecyclerView.Adapter{

    List<FetchData_restaurant> fetchData_restaurantList;
    public HelperAdapter_restaurant(List<FetchData_restaurant> fetchData_restaurantList) {
        this.fetchData_restaurantList = fetchData_restaurantList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item, parent, false);
        HelperAdapter_restaurant.ViewHolderClass viewHolderClass = new HelperAdapter_restaurant.ViewHolderClass(view);

        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HelperAdapter_restaurant.ViewHolderClass viewHolderClass = (HelperAdapter_restaurant.ViewHolderClass) holder;
        FetchData_restaurant fetchData_restaurant = fetchData_restaurantList.get(position);
        viewHolderClass.Hotel_name.setText(fetchData_restaurant.getHotel_name());
        viewHolderClass.Location.setText(fetchData_restaurant.getLocation());

    }

    @Override
    public int getItemCount() {
        return fetchData_restaurantList.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView Hotel_name, Location;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            Hotel_name = itemView.findViewById(R.id.hotel_name);
            Location = itemView.findViewById(R.id.hotel_location);
        }
        }
}
