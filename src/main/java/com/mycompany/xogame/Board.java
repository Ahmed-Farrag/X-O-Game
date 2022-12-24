/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xogame;


public class Board {
    char[][] arr;

    public Board() {
        this.arr = new char[][] {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    }
    public int getRow(int index){
       return((index-1)/3);
    }
    public int getCol(int index){
       return((index-1)%3);
    }
    
    public  boolean isEmpty(int index){
        if (index < 0 || index > 9)return false;
        int row = getRow(index);
        int col = getCol(index);
            return !(arr[row][col] == 'x' || arr[row][col] == 'o' || arr[row][col] == 'X' || arr[row][col] == 'O');
    }
    public boolean replaceChar(int index, player p){
        if(isEmpty(index)){
            int row = getRow(index);
            int col = getCol(index);
            arr[row][col] = p.getOp();
            return true;
            }
        return false;
    }
    public void drow(){
        for(int i = 0 ; i < 3 ; i++){
            System.out.println("-----------");
            for(int j = 0 ; j < 3 ; j++){
                System.out.print(" | "+arr[i][j] + " ");
            }
             System.out.println("|");
        }
         System.out.println("-----------");
    }
    public boolean isfull(){
         int count = 0;
         for(int i =1; i<=9; i++){
             if(isEmpty(i))count++;
         }
         return count == 0;
     
    }
    
    public boolean isWin(player p){
        if(arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2] && arr[0][1]==arr[0][2])
            return true;
        if(arr[1][0] == arr[1][1] && arr[1][0] == arr[1][2] && arr[1][1]==arr[1][2])
            return true;
        if(arr[2][0] == arr[2][1] && arr[2][0] == arr[2][2] && arr[2][1]==arr[2][2])
            return true;
        if(arr[0][0] == arr[1][0] && arr[0][0] == arr[2][0] && arr[1][0]==arr[2][0])
            return true;
        if(arr[0][1] == arr[1][1] && arr[0][1] == arr[2][1] && arr[1][1]==arr[2][1])
            return true;
        if(arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2] && arr[0][2]==arr[2][2])
            return true;
         if(arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2] && arr[1][1]==arr[2][2])
            return true;
         return arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0] && arr[1][1]==arr[2][0];
    }
    
}
