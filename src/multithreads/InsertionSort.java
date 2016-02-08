/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreads;

import java.util.List;

/**
 *
 * @author zxuuzx
 */
public class InsertionSort implements Runnable {
    List<Integer> list;
    
    public InsertionSort(List<Integer> list){
        this.list = list;
    }
    
    public void run() {
        for (int i=1; i < list.size(); i++) {
            int temp = list.get(i);
            int j;
            for (j = i - 1; j >= 0 && temp < list.get(j) ; j--)
                list.set(j+1, list.get(j));
            list.set(j+1, temp);
        }
    }        
}
