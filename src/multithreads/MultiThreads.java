/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xue
 */
public class MultiThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        List<Integer> list = new ArrayList<>();
        List<Integer> sortedlist = new ArrayList<>();
        
        if (args.length == 0) {
            System.out.println("No Command Line arguments");
        } else { 
            for (int i = 0; i < args.length; i++) {
            list.add(Integer.parseInt(args[i]));
            }
        }
        
        int middle = list.size()/2;
        
        InsertionSort r1 = new InsertionSort(list.subList(0, middle));
        Thread t1 = new Thread(r1);
        t1.start();
        
        InsertionSort r2 = new InsertionSort(list.subList(middle, list.size()));
        Thread t2 = new Thread(r2);
        t2.start();
        
        try {
          t1.join( );
          t2.join( );
        }catch (InterruptedException e) {}
        
        //System.out.print(list);
        MergeLists r3 = new MergeLists(list.subList(0, middle), list.subList(middle, list.size()), sortedlist);
        Thread t3 = new Thread(r3);
        t3.start();
        
        try {
          t3.join( );
        }catch (InterruptedException e) {}
        
        System.out.print(sortedlist);
        File filew = new File("C:\\Users\\zxuuzx\\Desktop\\output.txt");
        FileWriter fileWriter = new FileWriter(filew,true);
        fileWriter.write(sortedlist.toString() + "\n");
        fileWriter.close();

    }
    
}
