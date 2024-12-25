package com.example.sports;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerView extends AppCompatActivity {

    // 1. Declare RecyclerView to display the list of items.
    private RecyclerView myRecyclerView;

    // 2. Declare a data source to hold the list of items.
    private List<Sport> sportList;

    // 3. Declare the adapter to bridge data and RecyclerView.
    private MyCustomAdapter myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_recycler_view);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        // 4. Initialize the RecyclerView.
        myRecyclerView = findViewById(R.id.recyclerView);

        // 5. Prepare the data source by creating a list of items.
        sportList = new ArrayList<>();
        Sport s1 = new Sport("Football", R.drawable.football);
        Sport s2 = new Sport("Basketball", R.drawable.basketball);
        Sport s3 = new Sport("VolleyBall", R.drawable.volley);
        Sport s4 = new Sport("Tennis", R.drawable.tennis);
        Sport s5 = new Sport("Ping Pong", R.drawable.ping);
        sportList.add(s1);
        sportList.add(s2);
        sportList.add(s3);
        sportList.add(s4);
        sportList.add(s5);

        // 6. Set the layout manager for the RecyclerView.
        // LinearLayoutManager is used for a vertical list.
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        myRecyclerView.setLayoutManager(layoutManager);
//      // Above 2 lines also woks instead of below one as well (used in previous project)
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 7. Initialize the adapter and pass the data source to it.
        myCustomAdapter = new MyCustomAdapter(sportList);

        // 8. Set the adapter to the RecyclerView.
        myRecyclerView.setAdapter(myCustomAdapter);
    }
}