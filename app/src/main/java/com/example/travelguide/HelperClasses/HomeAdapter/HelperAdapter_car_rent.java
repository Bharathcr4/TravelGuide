package com.example.travelguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelguide.HelperClasses.FetchData_car_rent;
import com.example.travelguide.R;

import java.util.List;

public class HelperAdapter_car_rent extends RecyclerView.Adapter {

    List<FetchData_car_rent> fetchData_car_rentList;

    public HelperAdapter_car_rent(List<FetchData_car_rent> fetchData_car_rentList) {
        this.fetchData_car_rentList = fetchData_car_rentList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_rent_item, parent, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);

        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass=(ViewHolderClass)holder;
        FetchData_car_rent fetchData_car_rent = fetchData_car_rentList.get(position);
        viewHolderClass.Company.setText(fetchData_car_rent.getCompany());
        viewHolderClass.Location.setText(fetchData_car_rent.getLocation());
        viewHolderClass.phonenumber.setText(fetchData_car_rent.getPhonenumber());
        viewHolderClass.DownloadLink.setText(fetchData_car_rent.getDownloadLink());
    }

    @Override
    public int getItemCount() {
        return fetchData_car_rentList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView Company, Location, phonenumber, DownloadLink;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            Company = itemView.findViewById(R.id.cname_one);
            Location = itemView.findViewById(R.id.location_one);
            phonenumber = itemView.findViewById(R.id.phonenum_one);
            DownloadLink = itemView.findViewById(R.id.download_link);
        }
    }
}
