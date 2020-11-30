package com.example.realmlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmRecyclerViewAdapter;

public class RealmAdapter extends RealmRecyclerViewAdapter<Base, RealmAdapter.ViewHolder> {
  private  Context context;
    public RealmAdapter(@Nullable OrderedRealmCollection<Base> data, Context context) {
        super(data, true);
        this.context=context;
        setHasStableIds(true);


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false );
        return new RealmAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Base dataBase = getItem(position);

            assert dataBase != null;
            holder.tvName.setText(dataBase.getName());
            holder.tvCode.setText(dataBase.getCode());



    }

    @Override
    public long getItemId(int index) {
        return Objects.requireNonNull(getItem(index)).getId();


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
