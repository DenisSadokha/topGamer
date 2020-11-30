package com.example.realmlist;

import io.realm.Realm;
import io.realm.RealmResults;

public class DataHelper {

    public static void add(Realm realm, int id, String name, String count, String code) {
        realm.beginTransaction();
        Base dataBase = realm.createObject(Base.class, id);
        dataBase.setName(name);
        dataBase.setCode(code);
        dataBase.setCount(count);
        realm.commitTransaction();

    }

    public static void delete(Realm realm, final long id) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Base> d = realm.where(Base.class).findAll();
                Base dataBase = realm.where(Base.class).equalTo("id", id).findFirst();
                if (dataBase != null) {
                    dataBase.deleteFromRealm();

                }
            }
        });

    }
}
