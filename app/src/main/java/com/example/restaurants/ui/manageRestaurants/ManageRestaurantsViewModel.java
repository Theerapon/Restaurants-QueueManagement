package com.example.restaurants.ui.manageRestaurants;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ManageRestaurantsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ManageRestaurantsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}