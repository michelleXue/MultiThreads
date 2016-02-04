/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreads;

/**
 *
 * @author xue
 */
public class MultiThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
    public static void QuickSort(int[] values, int low, int high) {
        
        if (low < high) {
            int p = Partition(values, low, high);
            QuickSort(values, low, p);
            QuickSort(values, p + 1, high);
        }
    }
    
    public static int Partition(int[] values, int low, int high) {
        
        int pivot = values[low];
        int i = low - 1;
        int j = high + 1;
        
        while(true){
            do {
                i = i + 1;
            } while(values[i] < pivot);
            do {
                j = j - 1;
            } while(values[j] > pivot);
            
            if (values[j] > pivot){
                break;
            }
        }
        
        values = swap(values, i, j);
        
        return j;
    }

    public static int[] swap(int[] values, int i, int j) {
        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
        
        return values;
    }
}
