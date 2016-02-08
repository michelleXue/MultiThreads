/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreads;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zxuuzx
 */
public class MergeLists implements Runnable {
    List<Integer> list1;
    List<Integer> list2;
    List<Integer> sortedlist;
    
    public MergeLists (List<Integer> list1, List<Integer> list2, List<Integer> sortedlist){
        this.list1 = list1;
        this.list2 = list2;
        this.sortedlist = sortedlist;
    }
    
    public void run() {
        int len = list1.size() + list2.size();  // length of the final list
        int middle = len/2;
        int index1 = 0, index2 = 0;             // two index point point to the first element in two arrays
        for (int i = 0; i < len; i++) {
            if (index1 > list1.size() -1) { // list 1 complete merge
                sortedlist.addAll(list2.subList(index2, list2.size()));
                break;
            }
            if (index2 > list2.size() -1) { // list 2 complete merge
                sortedlist.addAll(list1.subList(index1, list1.size()));
                break;
            }
            if (list1.get(index1) < list2.get(index2)) { // first element in array 1 is smaller
                sortedlist.add(list1.get(index1));
                index1++;
            }
            else { // first element in array 2 is smaller
                sortedlist.add(list2.get(index2));
                index2++;
            }           
        }
    }
}
