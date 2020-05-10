package com.example.grocery.adapter;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.grocery.R;

import ss.com.bannerslider.Slider;
import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;


public class Slider_Adapter extends SliderAdapter {


    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {

            switch (position) {


                case 0:
                    imageSlideViewHolder.bindImageSlide(R.drawable.blanket);
                    break;
                case 1:
                    imageSlideViewHolder.bindImageSlide(R.drawable.ad1);
                    break;
                case 2:
                    imageSlideViewHolder.bindImageSlide(R.drawable.ad2);
                    break;

            }


    }

}
