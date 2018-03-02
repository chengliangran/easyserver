package com.easyserver.context;

import com.easyserver.components.Request;
import com.easyserver.components.Response;
import com.easyserver.core.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/1 0001.
 */
public class Pipeline {


    List<Valve> valves=new ArrayList<Valve>();

    Valve basicValve=new BasicValve();

    Context context;

    class ValveContext{
        int index=0;
        public void invoke(Request request,Response response){
            int subscrip=index;
            index++;
            if (valves.size()>0&&subscrip<valves.size()){
                List<Wrapper> wrappers= getContext().getWrappers();
                for (Wrapper wrapper : wrappers) {
                    wrapper.invoke(request,response);
                }
            }else if (valves.size()==subscrip){
                basicValve.setContext(getContext());
                basicValve.invoke(request,response);
            }else {
                System.out.println("出错");
            }
        }
    }

    public void invoke(Request request, Response response){
        new ValveContext().invoke(request,response);
     }

    //getter and setting
    public void addValve(Valve valve){
        valves.add(valve);
    }

    public void addBasic(Valve basicValve){
        this.basicValve=basicValve;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
