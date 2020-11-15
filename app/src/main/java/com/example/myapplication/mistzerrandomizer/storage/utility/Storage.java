package com.example.myapplication.mistzerrandomizer.storage.utility;

import java.util.List;

public interface Storage<T> {

    void insert(T object, String name);

    List<T> findAll();

    T find(int id);

    int size();

    void update(int id, T object);
}
