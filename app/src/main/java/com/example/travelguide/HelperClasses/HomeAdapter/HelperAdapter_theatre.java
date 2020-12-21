package com.example.travelguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelguide.HelperClasses.FetchData_car_rent;
import com.example.travelguide.HelperClasses.FetchData_theatre;
import com.example.travelguide.R;

import java.util.List;

public class HelperAdapter_theatre extends RecyclerView.Adapter {

    List<FetchData_theatre> fetchData_theatreList;

    public HelperAdapter_theatre(List<FetchData_theatre> fetchData_theatreList) {
        this.fetchData_theatreList = fetchData_theatreList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.theatre_item, parent, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);

        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass=(ViewHolderClass)holder;
        FetchData_theatre fetchData_theatre = fetchData_theatreList.get(position);
        viewHolderClass.Name.setText(fetchData_theatre.getName());
        viewHolderClass.T_loc.setText(fetchData_theatre.getT_loc());

    }

    @Override
    public int getItemCount() {
        return fetchData_theatreList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView Name,T_loc;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
           Name= itemView.findViewById(R.id.theatre_name);
            T_loc= itemView.findViewById(R.id.theatre_loc);
        }
    }
}
