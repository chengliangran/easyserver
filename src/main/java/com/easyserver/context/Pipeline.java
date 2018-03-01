package com.easyserver.context;

import com.easyserver.components.Request;
import com.easyserver.components.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/1 0001.
 */
public class Pipeline {

    int index=0;

    List<Valve> valves=new ArrayList<Valve>();

    Valve basicValve=new BasicValve();

    Wrapper wrapper=new BasicWrapper();

    public void invoke(Request request, Response response){
        int subscripe=index;
        index++;
        if (subscripe<valves.size()){
            valves.get(0).invoke(request,response);

        }else if(subscripe==valves.size()){
            basicValve.invoke(request,response);
        }
    }

    //getter and setting
    public void addValve(Valve valve){
        valves.add(valve);
    }

    public void addBasic(Valve basicValve){
        this.basicValve=basicValve;
    }

}
