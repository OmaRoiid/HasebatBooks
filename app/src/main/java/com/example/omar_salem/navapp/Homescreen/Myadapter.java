package com.example.omar_salem.navapp.Homescreen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.omar_salem.navapp.Books.Cs;
import com.example.omar_salem.navapp.Books.Is;
import com.example.omar_salem.navapp.Books.It;
import com.example.omar_salem.navapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Omar_Salem on 8/4/2017.
 */
public class Myadapter  extends  RecyclerView.Adapter<Myadapter.MyViewHolder>{
    //Home Screen
    private ArrayList<Datamodel> dataSet;
    private static ClickListener clicklistener = null;
    private Context context;


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView head;
        TextView Desc;
        ImageView image;
        private LinearLayout main;
        public MyViewHolder(final View itemView) {
            super(itemView);
            this.head=(TextView)itemView.findViewById(R.id.Head_id);
            this.Desc=(TextView)itemView.findViewById(R.id.Desc_id);
            this.image=(ImageView)itemView.findViewById(R.id.img_id);
            this.main=(LinearLayout)itemView.findViewById(R.id.main);
            main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(itemView.getContext(), "Position:" + Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();
                    if(Integer.toString(getPosition())=="0"&& MainActivity.isActive()){
                        itemView.getContext().startActivity(new Intent(itemView.getContext(),Cs.class));

                    }
                    else if(Integer.toString(getPosition())=="1" && MainActivity.isActive()){

                        itemView.getContext().startActivity(new Intent(itemView.getContext(),Is.class));
                    }
                    else if( Integer.toString(getPosition())=="2" && MainActivity.isActive() )
                    { itemView.getContext().startActivity(new Intent(itemView.getContext(),It.class));}

                    if(clicklistener !=null){
                        clicklistener.itemClicked(v,getAdapterPosition());
                    }
                }
            });

        }

    }//this Method for HomeScreen

    public void setClickListener(ClickListener clickListener){
        clicklistener = clickListener;
    }

    public Myadapter(ArrayList<Datamodel> data,Context context){
        this.dataSet = data;
        this.context=context;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        final View viewall;

        viewall = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem, parent, false);
        return new MyViewHolder(viewall);







    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Datamodel datamodel = dataSet.get(position);
        if(MainActivity.isActive()) {

            TextView header = holder.head;
            TextView Descr = holder.Desc;
            ImageView image = holder.image;
            header.setText(dataSet.get(position).getHead());
            Descr.setText(dataSet.get(position).getDescraption());
            image.setImageResource(dataSet.get(position).getImg());
        }
        else{

            TextView header = holder.head;
            TextView Descr = holder.Desc;
            ImageView image = holder.image;
            header.setText(dataSet.get(position).getHead());
            Descr.setText(dataSet.get(position).getDescraption());
            Picasso.with(context).load(dataSet.get(position).getImgStr()).into(holder.image);
        }

        //
        //Picasso.with(context).load(dataSet.get(position).getImg()).into(holder.image);
    }




    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
