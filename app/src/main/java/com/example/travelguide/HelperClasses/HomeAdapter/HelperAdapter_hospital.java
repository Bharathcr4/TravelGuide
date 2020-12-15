package com.example.travelguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelguide.HelperClasses.FetchData_hospital;
import com.example.travelguide.HelperClasses.FetchData_restaurant;
import com.example.travelguide.R;

import java.util.List;

public class HelperAdapter_hospital extends RecyclerView.Adapter {
    List<FetchData_hospital> fetchData_hospitalList;
    public HelperAdapter_hospital(List<FetchData_hospital> fetchData_hospitalList) {
        this.fetchData_hospitalList = fetchData_hospitalList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_item, parent, false);
        HelperAdapter_hospital.ViewHolderClass viewHolderClass = new HelperAdapter_hospital.ViewHolderClass(view);

        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HelperAdapter_hospital.ViewHolderClass viewHolderClass = (HelperAdapter_hospital.ViewHolderClass) holder;
        FetchData_hospital fetchData_hospital = fetchData_hospitalList.get(position);
        viewHolderClass. H_name.setText(fetchData_hospital.getH_name());
        viewHolderClass.Location.setText(fetchData_hospital.getLocation());
        viewHolderClass.Phone.setText(fetchData_hospital.getPhone());
    }

    @Override
    public int getItemCount() {
        return fetchData_hospitalList.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView H_name, Location,Phone;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            H_name= itemView.findViewById(R.id.hosp_name);
            Location = itemView.findViewById(R.id.hosp_location);
            Phone = itemView.findViewById(R.id.hosp_phone);
        }
    }
}

