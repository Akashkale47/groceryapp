package com.example.grocery;



import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.grocery.adapter.RecyclerAdapater;
import com.example.grocery.adapter.RecyclerViewAdapter;
import com.example.grocery.adapter.Slider_Adapter;

import java.util.ArrayList;

import ss.com.bannerslider.Slider;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "CartActivity";
    SwipeRefreshLayout mSwipeRefreshLayout;

    //vars
    private ArrayList<String> mOffersprice = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mLabel = new ArrayList<>();
    private ArrayList<String> mWeight = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private ArrayList<String> mCutoff = new ArrayList<>();

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Slider.init(new PicassoImageLoadingService(this));
        Slider slider = findViewById(R.id.banner_slider1);
        slider.setAdapter(new Slider_Adapter());
// swiperefreshlayout
        mSwipeRefreshLayout = findViewById(R.id.srl_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);


        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);


        getImages();
        getImages1();


    }

    /**RECYCLERVIEW PRODUCT LIST **/
    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        String offerprice="30%OFF";
        String rs="Rs.";


        mOffersprice.add(offerprice);
        mImage.add("https://us.123rf.com/450wm/atoss/atoss1510/atoss151000013/46938944-ripe-mango-isolated-on-white-clipping-path.jpg?ver=6");
        mLabel.add("Mongo 1 Kg/Dozen sell");
        mWeight.add("240g");
        mPrice.add(rs+"994/-");
        mCutoff.add(rs+"1000/-");

        mOffersprice.add(offerprice);
        mImage.add("https://media.istockphoto.com/photos/pineapple-isolated-picture-id90965948?k=6&m=90965948&s=612x612&w=0&h=hbUfhxwZe3-yJ20Xkeo8pns9nMU0iHARNV0yIGu86WY=");
        mLabel.add("Pineapple 1 Kg/Dozen sell");
        mWeight.add("270g");
        mPrice.add(rs+"704/-");
        mCutoff.add(rs+"1400/-");

        mOffersprice.add(offerprice);
        mImage.add("https://media.istockphoto.com/photos/red-apple-with-leaf-picture-id683494078?k=6&m=683494078&s=612x612&w=0&h=aVyDhOiTwUZI0NeF_ysdLZkSvDD4JxaJMdWSx2p3pp4=");
        mLabel.add("Apple 1 Kg/Dozen sell");
        mWeight.add("440g");
        mPrice.add(rs+"304/-");
        mCutoff.add(rs+"500/-");




        initRecyclerView();

    }
// recycler view adapters
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");



        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
       /* GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);*/
        RecyclerView recyclerView = findViewById(R.id.rv_products1);

        /*recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));*/
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mOffersprice, mImage, mLabel,mWeight,mPrice,mCutoff);
        recyclerView.setAdapter(adapter);
    }
    // category_recyclerview
    private void getImages1(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");



        mImageUrls.add("https://www.cdc.gov/foodsafety/images/comms/GettyImages-898001644-300px.png");
        mNames.add("Vegetables");

        mImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSXoSKz27Dzv1PXUQU3Y-YMBsQgSKgACfNOfApU0AvMIUTjF_x");
        mNames.add("Fruits");

        mImageUrls.add("https://www.eatright.org/-/media/eatrightimages/food/vitaminsandsupplements/nutrientrichfoods/5grainstokeepyourfamilyhealthy.jpg");
        mNames.add("Grains");

        mImageUrls.add("https://images-na.ssl-images-amazon.com/images/I/91waMDBVveL._SY679_.jpg");
        mNames.add("Beverages");


        mImageUrls.add("https://images-na.ssl-images-amazon.com/images/I/812o4EQXPKL._SX679_.jpg");
        mNames.add("Noodles");




        initRecyclerView1();

    }

    // category_recyclerview
    private void initRecyclerView1(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.rc_Recyclerview);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapater recyclerAdapater = new RecyclerAdapater(this,mNames,mImageUrls);

        recyclerView.setAdapter(recyclerAdapater);

    }


    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(this, "Refreshed", Toast.LENGTH_SHORT).show();

    }
}
