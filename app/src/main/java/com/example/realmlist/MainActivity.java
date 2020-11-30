package com.example.realmlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

import android.os.Bundle;
import android.view.DragAndDropPermissions;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Realm realm;
RecyclerView recyclerView;
EditText etName, etCount;
Button button;
ArrayList<String> arrayList = new ArrayList<>();
ArrayList<String> arrayList2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplicationContext());
         realm = Realm.getInstance(RealmUtility.getDefaultConfig());
        recyclerView = findViewById(R.id.rec);
        button = findViewById(R.id.bOk);
        etName = findViewById(R.id.etName);
        etCount = findViewById(R.id.etCount);
        final Adapter adapter1 = new Adapter(this, arrayList, arrayList2);
        Base dataBase = new Base();
        RealmAdapter realmAdapter =  new RealmAdapter(realm.where(Base.class).findAll(), this);
        Touh touh = new Touh();
        ItemTouchHelper itemTouchHelper  = new ItemTouchHelper(touh);

      //   recyclerView.setAdapter(realmAdapter);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        arrayList.add("fuck");
        arrayList.add("fuck2");
        arrayList2.add("you");
        arrayList2.add("you2");

       recyclerView.setAdapter(adapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          addNom(etName.getText().toString(), etCount.getText().toString(), "0");
/*
                DataBase dataBase = realm.createObject(DataBase.class);

                try {
                    realm.beginTransaction();
                    dataBase.setName(etName.getText().toString());
                    dataBase.setCount(etCount.getText().toString());
                    realm.commitTransaction();
                    arrayList.add(etName.getText().toString());
                    arrayList2.add(etCount.getText().toString());
                    recyclerView.setAdapter(adapter1);
                }catch (RealmException r){

                    r.printStackTrace();
                } catch (NullPointerException e){
                    Toast.makeText(getApplicationContext(), "NullERROR", Toast.LENGTH_LONG).show();
                }

*/

            }
        });




    }
    public  void addNom(String name, String count, String code){
        SecureRandom secureRandom = new SecureRandom();
        int id= secureRandom.nextInt(1000000000);
        DataHelper.add(realm, id,name,count,code);

    }

    private class Touh extends ItemTouchHelper.SimpleCallback{
        Touh(){
            super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT);
        }


        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            DataHelper.delete(realm, viewHolder.getItemId());

        }
    }
}
