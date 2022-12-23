package com.ingeneo.scalingguacamole.fakers;

import java.util.ArrayList;
import java.util.List;

public abstract class Factory <T>{
    public abstract T Generate();
    public List<T> Generate(int count){
        List<T> list = new ArrayList<>();
        for(int i=1; i<= count; i++){
            list.add(this.Generate());
        }
        return list;
    }
}
