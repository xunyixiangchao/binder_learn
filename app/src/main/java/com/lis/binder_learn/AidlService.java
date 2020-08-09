package com.lis.binder_learn;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AidlService extends Service {
    private ArrayList<Person> persons;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        persons = new ArrayList<>();
        Log.e("AidlService", "success onBind");
        return mIBinder;
    }

    private IBinder mIBinder = new Aidl.Stub() {
        @Override
        public void addPerson(Person person) throws RemoteException {

            persons.add(person);
            Log.e("AidlService", "persons.size: "+persons.size());
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            Log.e("AidlService", "getPersonList.size: "+persons.size());
            return persons;
        }
    };
}
