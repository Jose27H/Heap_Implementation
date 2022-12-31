package com.main;

import java.io.*;
import java.util.Scanner;


/**
 * This is the DrugHeap Class, it implements the functionality of a minheap, this is called in the main class to create one instance  of this
 */
public class DrugHeap {

    File file = new File("C:\\Users\\joseh\\Desktop\\COSC2P03_A3_Jose_Henriquez_7088792\\src\\com\\main\\dockedApproved.tab");// The file given from the Assignment
    File out = new File("C:dockedApprovedInOrder.tab");// the inorder file Witten by the program
    File out1 = new File("C:dockedApprovedSorted.tab");// the inorder file Witten by the program
    FileWriter fw,fw1; // to write to the file

    {
        try {
            fw = new FileWriter(out);
            fw1 = new FileWriter(out1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    PrintWriter pw = new PrintWriter( fw);// to print to new file
    PrintWriter pw1 = new PrintWriter( fw1);// to print to new file
    Scanner scan,scan2 ;// to scan the file for data,to scan file for number of lines
    public Drug[] data ;//array to store all the drugs into
    private int size;
    String[] substrings= new String[6]; // string array that each line of the .txt file will be broken down into
    String  line;// String that will be broken down
    int number_lines = 0;// int used to keep track of number of drugs given
    {
        try {
            scan = new Scanner(file);
            scan2 = new Scanner(file);}
        catch (FileNotFoundException e) {e.printStackTrace();}
    }

    /**
     * This is the Constructor for drugheap, this runs for each time the class is instantiated
     */

    public DrugHeap(){
        number_lines = numLines(); //get number of drugs
        size = number_lines;
        data= new Drug[number_lines];//set array
        readData(data);//load array
    }//constructor

    /**
     * This is the remove min method, it removes the top (lowest-drugBankID) and the performs trickle down to set the lowest value to top again
     */

    public void removeMin(){
        data[0] = data[size-1];
        trickleDown(0);
        size--;
    }//removeMin


    /**
     * This is recursive method inorder traverse, it calls recursive method that loops thur the heap in an inOrder fashion and prints to specified .tab document
     */
    public void inOrderTraverse(){
        displayHelp(data,0);
        pw.close();
    }// inOrderTraverse

    /**
     * this is the displayHelp method, it recursively travels down the list in inorder fashion, printing to the file as it moves
     * @param root the current root observed
     */

    private void displayHelp(Drug[] root,int index) {
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        if(left <= size-1){
            displayHelp(root, left);
        }
        pw.println(data[index].displayDrug() );
        if(right<=size-1){
            displayHelp(root,right);
        }
    }//displayHelp

    /**
     *This is the heapsort method, it prints the top element to the file and then removes it and trickles down the 0th element
     * to ensure lowest is always at top
     */

    public void heapSort(){
        for(int i = 0; i< number_lines; i++){
            pw1.println(data[0].displayDrug());
            removeMin();
        }
        pw1.close();
    }//heapsort


    /**
     * This is trickle down it is a recursive method that sets the lowest of 3 elements as root and then recursively does that down the array
     * @param i = the index of the node
     */
    private void trickleDown(int i){
        int smallest = i;//temporary smallest
        int leftChild = (2*i)+1; //left
        int rightChild = (2*i)+2;//right
        if(leftChild < size && data[leftChild].getDrugBankID().compareTo(data[smallest].drugBankID) < 0 ){ // if the left is smaller than root
            smallest =leftChild;
        }
        if(rightChild < size && data[rightChild].getDrugBankID().compareTo(data[smallest].drugBankID) < 0 ){// if the right is smaller than root
            smallest =rightChild;
        }
        if(smallest != i ){ // if the root was not the lowest to begin with
            swap(i, smallest);
            trickleDown(smallest);
        }

    }//trickleDown


    /**
     * This is buildHeap, it calls trickleDown over and over again to swap all the items in the array to their right heap positions
     */
    public void buildHeap(){
        for(int i =size/2; i>=0; i--){
            trickleDown(i);
        }
    }//buildHeap

    /**
     * This is the Swap Method, it switches 2 items inside an array
     * @param child //one item switch
     * @param parent// second item to switch
     */
    private void swap(int child, int parent){
        Drug temp = data[child];
        data[child] = data[parent];
        data[parent] = temp;
    }//swap


    /**
     * This method reads the original file given by assignment and returns the number of lines in the file
     * @return number of lines in file
     */

    private int numLines(){
        scan2.nextLine();
        int i =0;
        while(scan2.hasNextLine()){
            i++;
            scan2.nextLine();
        }
        return i;
    }//numLines

    /**
     * ReadData Method Specified by assignment, it reads the file and loads it into an array of Drug instances
     * @param drugs the drugs that will be loaded
     */

    private void readData(Drug[] drugs){

        scan.nextLine();
        int i =0;

        while(scan.hasNextLine()) {
            line = scan.nextLine();
            substrings = line.split("\t"); //sets substrings to an array of the different parts of a line from the file
            Drug drug = new Drug(substrings);
            drugs[i] = drug;
            i++;


        }
    }//readData
}//DrugHeap
