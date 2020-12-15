package com.example.travelguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelguide.HelperClasses.FetchData_Tourist_place;
import com.example.travelguide.HelperClasses.FetchData_shopping;
import com.example.travelguide.R;

import java.util.List;

public class HelperAdapter_Tourist_place extends RecyclerView.Adapter  {
    List<FetchData_Tourist_place> fetchData_Tourist_placeList;
    public HelperAdapter_Tourist_place (List<FetchData_Tourist_place> fetchData_Tourist_placeList) {
        this.fetchData_Tourist_placeList = fetchData_Tourist_placeList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tourist_place_item, parent, false);
        HelperAdapter_Tourist_place.ViewHolderClass viewHolderClass = new HelperAdapter_Tourist_place.ViewHolderClass(view);

        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HelperAdapter_Tourist_place.ViewHolderClass viewHolderClass = (HelperAdapter_Tourist_place.ViewHolderClass) holder;
        FetchData_Tourist_place fetchData_Tourist_place = fetchData_Tourist_placeList.get(position);
        viewHolderClass.Name.setText(fetchData_Tourist_place.getName());
        viewHolderClass.T_location.setText(fetchData_Tourist_place.getT_location());

    }

    @Override
    public int getItemCount() {
        return fetchData_Tourist_placeList.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView Name,T_location ;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.T_name);
            T_location = itemView.findViewById(R.id.T_location);
        }
    }

}
