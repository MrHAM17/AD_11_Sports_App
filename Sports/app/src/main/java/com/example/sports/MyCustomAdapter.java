package com.example.sports;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

// This class is an adapter class
// It's a bridge between your Data (List<Sport>) and the RecyclerView + CardView
public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MySportsViewHolder>{

    // 1. List to hold the data source for the RecyclerView.
    //    This list contains the data that will be displayed in the RecyclerView.
    //    Each item in the list corresponds to a single entry (e.g., a sport).
    private List<Sport> sportList;

    // 2. Constructor to initialize the data source.
    //    The adapter is initialized with a list of data items (passed from the activity or fragment).
    public MyCustomAdapter(List<Sport> sportList) {
        this.sportList = sportList;
    }


    @NonNull
    @Override
    public MyCustomAdapter.MySportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 3. Inflate the layout for each item in the RecyclerView.
        //    This method creates a new ViewHolder by inflating the layout XML for a single item.
        //    It only creates enough ViewHolders to fit the visible screen and a few extra for smooth scrolling.
        // responsible for creating new view holders for your items
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.card_item_layout,
                        parent,
                        false
                );

        return new MySportsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCustomAdapter.MySportsViewHolder holder, int position) {
        // 4. Bind data from the item list to the ViewHolder.
        //    This method sets the data for each view in the ViewHolder using the dataset at the given position.
        //    This ensures that the ViewHolder is updated with the correct data when recycled.
        // Binds the data from your dataset to the views within the view holder
        Sport sport = sportList.get(position);

        // Set the sport's name and image to the respective views in the layout.
        holder.textView.setText(sport.sportName);
        holder.imageView.setImageResource(sport.sportImg);

    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }

    public class MySportsViewHolder extends RecyclerView.ViewHolder {
        // 5. Define views for the item layout.
        //    The ViewHolder is a container for the views in a single item layout.
        //    It holds references to the views (e.g., ImageView, TextViews) that will display the data.
        // Holds references to the views within the item layout
        TextView textView;
        ImageView imageView;

        public MySportsViewHolder(@NonNull View itemView) {
            super(itemView);

            // 6. Initialize the views for each item layout.
            //    This initialization happens for each visible item on the screen when the RecyclerView creates a ViewHolder.
            //    The RecyclerView only creates enough ViewHolders to fill the visible portion of the screen, plus a few extra for smooth scrolling.
            //    When items scroll off the screen, their ViewHolders are recycled and reused for new items coming into view.
            //    Therefore, this initialization ensures that the same ViewHolder can efficiently display different data as items are reused.
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
