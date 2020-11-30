package com.example.realmlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
Context context;
    ArrayList<String> arrayList = new ArrayList();
    ArrayList<String> arrayList2 = new ArrayList();


public Adapter(Context context, ArrayList arrayList, ArrayList arrayList2){
    this.context=context;
    this.arrayList=arrayList;
    this.arrayList2=arrayList2;


}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    MainActivity mainActivity = new MainActivity();
    holder.tvName.setText(arrayList.get(position));
        holder.tvCode.setText(arrayList2.get(position));
        Log.d("DEB","pos"+position);




    }

    @Override
    public int getItemCount() {
    MainActivity mainActivity = new MainActivity();
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName, tvCode;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName= itemView.findViewById(R.id.first);
            tvCode=itemView.findViewById(R.id.second);

        }

        @Override
        public void onClick(View v) {



        }
    }
}
