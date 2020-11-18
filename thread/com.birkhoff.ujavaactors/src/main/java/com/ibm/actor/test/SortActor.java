package com.ibm.actor.test;

import com.ibm.actor.AbstractActor;
import com.ibm.actor.Actor;
import com.ibm.actor.DefaultMessage;
import com.ibm.actor.Message;

import java.util.Arrays;
/**
 * birkhoff
 */
public class SortActor  extends AbstractActor {
    @Override
    protected void loopBody(Message m) {
        if(m.getSource().equals("sort")){
            System.out.println("enter  sortActor " + this.getName());
            int[] data = (int[]) m.getData();
            Arrays.sort(data);
            int[] topData = Arrays.copyOf(data,10);
            System.out.println("sortActor  sortActor " + this.getName() + " , finished " + Arrays.toString(topData));
            DefaultMessage rm = new DefaultMessage("result",topData);
            this.getManager().send(rm,this,m.getSource());
        }
    }
}
