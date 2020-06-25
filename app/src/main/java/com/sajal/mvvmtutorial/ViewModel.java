package com.sajal.mvvmtutorial;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ViewModel extends androidx.lifecycle.ViewModel  {

    private MutableLiveData<List<Place>> nicePlaces;
    private Repository repo;
    private MutableLiveData<Boolean> updating = new MutableLiveData<>();

    public void init(){
        if (nicePlaces!=null){
            return;
        }
        repo = Repository.getInstance();
        nicePlaces = repo.getNicePlaces();
    }

    public void addNewValue(final Place place){
        updating.setValue(true);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<Place> currentPlaces = nicePlaces.getValue();
                currentPlaces.add(place);
                nicePlaces.postValue(currentPlaces);
                updating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<Place>> getPlaces(){
        return nicePlaces;
    }

    public LiveData<Boolean> loading(){
        return updating;
    }
}
