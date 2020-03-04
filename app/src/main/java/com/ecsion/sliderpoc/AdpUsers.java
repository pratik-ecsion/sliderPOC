package com.ecsion.sliderpoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdpUsers extends RecyclerView.Adapter<AdpUsers.HolderUsers> {

    String[] arrName = {"Abigail Abraham", "Alexandra Allan", "Alison Alsop", "Amanda Anderson",
            "Amelia Arnold", "Amy Avery", "Andrea Bailey", "Angela Baker", "Anna Ball"};

    String[] arrImage = {
            "https://randomuser.me/api/portraits/women/32.jpg",
            "https://randomuser.me/api/portraits/women/26.jpg",
            "https://randomuser.me/api/portraits/men/64.jpg",
            "https://randomuser.me/api/portraits/women/13.jpg",
            "https://randomuser.me/api/portraits/women/92.jpg",
            "https://randomuser.me/api/portraits/women/51.jpg",
            "https://randomuser.me/api/portraits/women/2.jpg",
            "https://randomuser.me/api/portraits/men/91.jpg",
            "https://randomuser.me/api/portraits/men/60.jpg"
    };
    Context mContext;

    public AdpUsers(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public HolderUsers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderUsers(LayoutInflater.from(mContext).inflate(R.layout.adp_users, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderUsers holder, int position) {
        holder.tvName.setText(arrName[position]);
        Picasso.with(mContext).load(arrImage[position]).into(holder.ciImage);
    }

    @Override
    public int getItemCount() {
        return arrName.length;
    }

    public class HolderUsers extends RecyclerView.ViewHolder {

        TextView tvName;
        CircleImageView ciImage;

        public HolderUsers(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            ciImage = itemView.findViewById(R.id.profile_image);
        }
    }
}
