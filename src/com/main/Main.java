package com.main;

/**
 *
 *  * @author Jose Henriquez 7088792
 *  * @since November 11, 2022
 *  * @version 1.0
 *
 *  This is the main class of the program, it calls all the methods asked from the assignment.
 */


public class Main {
    DrugHeap dh = new DrugHeap();
    /**
     * this is the constructor of main, it calls the methods required of the assignment, the are described in the other classes
     */
    public Main(){
        dh.buildHeap();//build the heap
        dh.inOrderTraverse(); //print inorder to file
        dh.heapSort();//print heapsort to file

    }//constructor

    public static void main(String[] args) {
       Main m = new Main();
        }
    }//main
