/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xogame;

import java.util.Scanner;


public class game {
    private player p1 = new player();
    private player p2 = new player();
    private Board myBoard = new Board();
    private int count = 0;
    
    
    public void readPlayerData(){
        Scanner cin = new Scanner (System.in);
        System.out.println("Enter Player l name");
        String s = cin.next();
        p1.setName(s);
        
        System.out.println("Enter Player 1 op");
        String op = cin.next();
        p1.setOp(op.charAt(0));
        
        System.out.println("Enter Player 2 Name");
        s = cin.next();
        p2.setName(s);
        
        if(p1.getOp() == 'x' || p1.getOp() == 'X')
            p2.setOp('o');
        else
            p2.setOp('x');
    }
    
    public void play(){
        readPlayerData();
        myBoard.drow();
        
        
        while(!myBoard.isfull()){
            player currentPlayer = p1;
            if(count % 2 == 1) currentPlayer = p2;
            
            while(true){
                Scanner cin = new Scanner (System.in);
                int pos;
                System.out.print("Please Enter Number from 1 to 9 : ");
                pos = cin.nextInt();
                if(myBoard.replaceChar(pos , currentPlayer))
                    break;
            }
            myBoard.drow();
    if(myBoard.isWin(currentPlayer)){
        System.out.println("The Winner is : " + currentPlayer.getName());
        break;
    }
    count++;
        }
        if(myBoard.isfull()){
            System.out.println("Game is Drow");
        }
    
    }
}
