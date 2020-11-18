package com.ibm.actor.test;

import com.ibm.actor.*;

import java.util.Arrays;

/**
 * birkhoff
 */
public class ParallSortActor extends AbstractActor {
    public static ActorManager manager = DefaultActorManager.getDefaultInstance();
    int count = 10;
    int finishedCount = 10;
    @Override
    protected void loopBody(Message m) {
        if(m.getSource().equals("init")){
            System.out.println("begin parall sort.....");
             int totalItems = 10000;
             for (int i = 0 ; i < count ; i++){
                 Actor sortActor = manager.createAndStartActor(SortActor.class,SortActor.class.getSimpleName() + i);
                 int [] data = new int[totalItems / count];
                 for(int j = 0 ; j < data.length ; j++){
                     data[j] = (int)(Math.abs(Math.random() * totalItems));
                 }
                 DefaultMessage rm = new DefaultMessage("sort" ,data);
                 manager.send(rm,this,sortActor);
             }
        }else if(m.getSource().equals("result")){
            finishedCount++;
            System.out.println("received result from " + m.getSource().getName() + " result " + Arrays.toString((int[])m.getData()));
            m.getSource().shutdown();
            if(finishedCount == 10){
                System.out.println("all finished ");
                this.shutdown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Actor myactor = manager.createAndStartActor(ParallSortActor.class,ParallSortActor.class.getSimpleName());
        while (!myactor.isShutdown()){
            Thread.sleep(1000);
            System.out.println(".............");
        }
    }
}
