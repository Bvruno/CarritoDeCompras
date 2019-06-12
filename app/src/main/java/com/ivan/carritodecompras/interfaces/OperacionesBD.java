package com.ivan.carritodecompras.interfaces;

import java.util.ArrayList;

public interface OperacionesBD<T> {

    boolean insert(T t);
     boolean delee(Object id);
     boolean update(T t);
     T selectById(Object id);
     ArrayList<T> selectAll();
}
