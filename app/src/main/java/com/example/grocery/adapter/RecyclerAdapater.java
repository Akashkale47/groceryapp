package com.example.grocery.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.grocery.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerAdapater extends RecyclerView.Adapter<RecyclerAdapater.ViewHolder> /*RecyclerView.Adapter<RecyclerAdapater.recyclerviewholder>*/
{


    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapater(Context context, ArrayList<String> mNames, ArrayList<String> mImageUrls) {
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_layout_xml, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");


        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(position))
                .placeholder(R.drawable.ic_burgur)
                .error(R.drawable.ic_notifications)
                .into(holder.image);

        holder.name.setText(mNames.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on an image: " + mNames.get(position));
                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name);
        }
    }

  /*  public boolean isPressed;
    private String[] data;
    public RecyclerAdapater(String[] data)
    {
        this.data = data;

    }
    @NonNull
    @Override
    public recyclerviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_view_layout,viewGroup,false);
        return new recyclerviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerviewholder recyclerviewholder, int i) {

        String title = data[i];
        recyclerviewholder.textView.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class recyclerviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView imageButtonCheck,imageButtonCheck2,imageButtonCancel,imageButtonCancel2,imageButtonHalf,imageButtonHalf2,imageButtonNote,imageButtonNote2;
        RelativeLayout relativeLayout,relativeLayout2,relativeLayout3,relativeLayout4;
        ImageView imageView;

         TextView textView;
        public recyclerviewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ic_image);
            textView = itemView.findViewById(R.id.tv_text);

            imageButtonCheck = itemView.findViewById(R.id.ib_check);
            imageButtonCancel = itemView.findViewById(R.id.ib_cancel);
            imageButtonCheck2 = itemView.findViewById(R.id.ib_uncheck);
            imageButtonCancel2 = itemView.findViewById(R.id.ib_notcancel);
            imageButtonHalf2 = itemView.findViewById(R.id.ib_nothalfday);
            imageButtonHalf = itemView.findViewById(R.id.ib_halfday);

            relativeLayout = itemView.findViewById(R.id.rg_check);
            relativeLayout.setOnClickListener(this);



        }

        @Override
        public void onClick(View v) {

            if (isPressed) {

                v.setBackgroundResource(R.drawable.ic_verifiednew);
                imageButtonCheck.setVisibility(View.INVISIBLE);

            } else {

                v.setBackgroundResource(R.drawable.ic_unverified);
            }
            isPressed = !isPressed;
*/
}










