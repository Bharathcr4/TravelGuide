package com.example.travelguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelguide.HelperClasses.FetchData_lodging;
import com.example.travelguide.HelperClasses.FetchData_restaurant;
import com.example.travelguide.R;

import java.util.List;

public class HelperAdapter_lodging extends RecyclerView.Adapter {

    List<FetchData_lodging> fetchData_lodgingList;

    public HelperAdapter_lodging(List<FetchData_lodging> fetchData_lodgingList) {
        this.fetchData_lodgingList = fetchData_lodgingList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lodging_item, parent, false);
        HelperAdapter_lodging.ViewHolderClass viewHolderClass = new HelperAdapter_lodging.ViewHolderClass(view);

        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HelperAdapter_lodging.ViewHolderClass viewHolderClass = (HelperAdapter_lodging.ViewHolderClass) holder;
        FetchData_lodging fetchData_lodging = fetchData_lodgingList.get(position);
        viewHolderClass.Name.setText(fetchData_lodging.getName());
        viewHolderClass.Phone_number.setText(fetchData_lodging.getPhone_number());
        viewHolderClass.Residency_address.setText(fetchData_lodging.getResidency_address());
    }

    @Override
    public int getItemCount() {
        return fetchData_lodgingList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView Name, Phone_number, Residency_address;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.lodge_name);
            Phone_number = itemView.findViewById(R.id.lodge_phone);
            Residency_address = itemView.findViewById(R.id.lodge_location);
        }
    }

}
