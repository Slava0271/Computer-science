package com.shpp.p2p.cs.vkolisnichenko.assignment17.tests.testpriorityqueue;

import com.shpp.p2p.cs.vkolisnichenko.assignment17.priorityqueue.MyPriorityQueue;

public class TestRemove {
    boolean testRemove(MyPriorityQueue<Integer> queue,int lowValue,int secondLowValue){
        int beginSize = queue.size();
        boolean checkFirstDelete = queue.delete()==lowValue;
        boolean checkSize = queue.size()==beginSize-1;
        boolean checkTopElement  = queue.get()==secondLowValue;
        queue.delete();
        boolean checkSecondDelete =  queue.get()!=secondLowValue;
        return checkFirstDelete&&checkSize&&checkTopElement&&checkSecondDelete;
    }
}
