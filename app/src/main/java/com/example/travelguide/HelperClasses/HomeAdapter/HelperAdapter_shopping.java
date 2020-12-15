package com.example.travelguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelguide.HelperClasses.FetchData_restaurant;
import com.example.travelguide.HelperClasses.FetchData_shopping;
import com.example.travelguide.R;

import java.util.List;

public class HelperAdapter_shopping extends RecyclerView.Adapter {

    List<FetchData_shopping> fetchData_shoppingList;
    public HelperAdapter_shopping(List<FetchData_shopping> fetchData_shoppingList) {
        this.fetchData_shoppingList = fetchData_shoppingList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item, parent, false);
        HelperAdapter_shopping.ViewHolderClass viewHolderClass = new HelperAdapter_shopping.ViewHolderClass(view);

        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HelperAdapter_shopping.ViewHolderClass viewHolderClass = (HelperAdapter_shopping.ViewHolderClass) holder;
        FetchData_shopping fetchData_shopping = fetchData_shoppingList.get(position);
        viewHolderClass.Name.setText(fetchData_shopping.getName());
        viewHolderClass.S_location.setText(fetchData_shopping.getS_location());
    }

    @Override
    public int getItemCount() {
        return fetchData_shoppingList.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView Name,S_location ;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Mall_name);
            S_location = itemView.findViewById(R.id.Mall_location);
        }
    }
}
