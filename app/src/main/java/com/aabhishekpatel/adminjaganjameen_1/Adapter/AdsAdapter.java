package com.aabhishekpatel.adminjaganjameen_1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aabhishekpatel.adminjaganjameen_1.Model.Ads;
import com.aabhishekpatel.adminjaganjameen_1.R;
import com.aabhishekpatel.adminjaganjameen_1.Front.UsersActivity;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public  class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.ViewHolder> {

    public Context mcontext;
    public List<Ads> adss;

    private static final int REQUEST_CALL =1;

    DatabaseReference reference;

    public AdsAdapter(Context mcontext, List<Ads> adss) {
        this.mcontext = mcontext;
        this.adss = adss;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.comments, viewGroup, false);
        return new AdsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {

         reference= FirebaseDatabase.getInstance().getReference("Comments");
        //firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        final Ads ads = adss.get(i);

        holder.cxname.setText(adss.get(i).getCxname());
        holder.cxphone.setText(adss.get(i).getCxphone());
        holder.cxemail.setText(adss.get(i).getCxemail());
        holder.cxhouse.setText(adss.get(i).getCxhouse());
        holder.cxaddress.setText(adss.get(i).getCxaddress());
        holder.cxdistrict.setText(adss.get(i).getCxdistrict());
        holder.cxstate.setText(adss.get(i).getCxstate());
        holder.cxpincode.setText(adss.get(i).getCxpincode());
        holder.cxcomments.setText(adss.get(i).getCxcomments());

        holder.cxname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext.getApplicationContext(), UsersActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);

                Toast.makeText(mcontext, "hiii", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return adss.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cxname, cxemail, cxphone, cxhouse, cxaddress,
        cxdistrict, cxstate, cxpincode, cxcomments;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cxname = itemView.findViewById(R.id.cxname);
            cxemail = itemView.findViewById(R.id.cxemail);
            cxphone = itemView.findViewById(R.id.cxphone);
            cxhouse = itemView.findViewById(R.id.cxhouseno);
            cxaddress = itemView.findViewById(R.id.cxaddress);
            cxdistrict = itemView.findViewById(R.id.cxdistric);
            cxstate = itemView.findViewById(R.id.cxstate);
            cxpincode = itemView.findViewById(R.id.cxpincode);
            cxcomments = itemView.findViewById(R.id.cxcomments);

        }
    }
}
