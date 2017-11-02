package puzzle;

import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;  



public class Puzzle extends JFrame implements ActionListener{  
             JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,newGame;  
             
             Puzzle(){  
                    // calling super class
                        super("Puzzle Game by Vaidehi"); 
                        
                        //creating buttons
                         b1= new JButton("1");  
                         b2= new JButton(" ");  
                         b3=new JButton("3");  
                         b4=new JButton("4");  
                         b5=new JButton("5");  
                         b6=new JButton("6");  
                         b7=new JButton("7");  
                         b8=new JButton("8");  
                         b9=new JButton("2");  
                         newGame=new JButton("New Game");  
                       
                          
                         //setting button positions
                        b1.setBounds(20, 30, 100, 100); 
                        b4.setBounds(20, 140, 100, 100);
                        b7.setBounds(20, 250, 100, 100);
                         
                        b2.setBounds(130, 30, 100, 100);  
                        b5.setBounds(130, 140, 100, 100); 
                        b8.setBounds(130, 250, 100, 100);  
                        
                        b3.setBounds(240, 30, 100, 100);  
                        b6.setBounds(240, 140, 100, 100);  
                        b9.setBounds(240, 250, 100, 100); 
                        
                        
                        newGame.setBounds(103, 380, 150, 40);  
                         //setting size of JFrame
                        setSize(380,470);  
                          
                        //adding buttons to JFrame
                        add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9); add(newGame); 
                        
                                               
                        //adding ActionListener
                        b1.addActionListener(this);  
                        b2.addActionListener(this);  
                        b3.addActionListener(this);  
                        b4.addActionListener(this);  
                        b5.addActionListener(this);  
                        b6.addActionListener(this);  
                        b7.addActionListener(this);  
                        b8.addActionListener(this);  
                        b9.addActionListener(this); 
                        
                        newGame.addActionListener(this);  
                        newGame.setBackground(Color.black);  
                        newGame.setForeground(Color.green);  
                        
                        setLayout(null);  
                        setVisible(true);  
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            } 

            
            private void swapLables(JButton button1, JButton button2){
                        String s = button1.getLabel();
                        button1.setLabel(button2.getLabel());
                        button2.setLabel(s);
             }
  
            private boolean playerWonCheck(){
                     if(     b1.getLabel().equals("1")
                             &&b2.getLabel().equals("2")
                             &&b3.getLabel().equals("3")
                             &&b4.getLabel().equals("4")
                             &&b5.getLabel().equals("5")  
                             &&b6.getLabel().equals("6")
                             &&b7.getLabel().equals("7")
                             &&b8.getLabel().equals("8")
                             &&b9.getLabel().equals(" "))
                     {   
                        JOptionPane.showMessageDialog(Puzzle.this,"!!!you won!!!");  
                        
                        return true;
                     }
                     return false;
            }

            public void actionPerformed(ActionEvent e){ 
                
                //newGame button is clicked
                if(e.getSource()==newGame){  
                    //swap b4 lable with b9
                           swapLables(b4, b9);
                    //swap b1 lable with b5        
                          swapLables(b1, b5);
                    //swap b2 lable with b7
                          swapLables(b2, b7);
                }  
                
                //b1 clicked
                if(e.getSource()==b1){  
                            if(b2.getLabel().equals(" ")){
                                   swapLables(b2, b1);
                            } else if(b4.getLabel().equals(" ")){ 
                                   swapLables(b4, b1);
                            }  
                            playerWonCheck();
                 } 
                
                 //b2 clicked
                if(e.getSource()==b2){ 
                            if(b1.getLabel().equals(" ")){ 
                                swapLables(b1, b2);
                            }else if(b3.getLabel().equals(" ")){ 
                                swapLables(b3, b2);
                            }  
                            else if(b5.getLabel().equals(" ")){
                                swapLables(b5, b2);
                            }  
                            playerWonCheck();
                 }

                //b3 clicked
                if(e.getSource()==b3){  
                            if(b2.getLabel().equals(" ")){ 
                                swapLables(b2, b3);
                            } else if(b6.getLabel().equals(" ")){ 
                                swapLables(b3, b6);
                            }  
                            playerWonCheck();
                 } 

                //b4 clicked
                if(e.getSource()==b4){  
                            if(b1.getLabel().equals(" ")){ 
                                swapLables(b1, b4);
                            } else if(b7.getLabel().equals(" ")){ 
                                swapLables(b7, b4);
                            }else if(b5.getLabel().equals(" ")){
                                swapLables(b5, b4);
                            }  
                            playerWonCheck();
                 }

                //b5 clicked
                if(e.getSource()==b5){  
                            if(b2.getLabel().equals(" ")){ 
                                swapLables(b2, b5);
                            } else if(b4.getLabel().equals(" ")){
                                swapLables(b4, b5);
                            } else if(b6.getLabel().equals(" ")){
                                swapLables(b6, b5);
                            }  
                            else if(b8.getLabel().equals(" ")){ 
                                swapLables(b8, b5);
                            }  
                            playerWonCheck();
                }

                //b6 clicked
                if(e.getSource()==b6){  
                            if(b9.getLabel().equals(" ")){
                                swapLables(b9, b6);
                            } else if(b3.getLabel().equals(" ")){
                                swapLables(b3, b6);
                            }else if(b5.getLabel().equals(" ")){
                                swapLables(b5, b6);
                            }
                            playerWonCheck();
                 } 

                //b7 clicked
                if(e.getSource()==b7){  
                            if(b4.getLabel().equals(" ")){
                                swapLables(b4, b7);
                            } else if(b8.getLabel().equals(" ")){ 
                                swapLables(b8, b7);
                            }  
                            playerWonCheck();

                 }

                //b8 clicked
                if(e.getSource()==b8){  
                            if(b7.getLabel().equals(" ")){ 
                                swapLables(b7, b8);
                            } else if(b9.getLabel().equals(" ")){ 
                                swapLables(b9, b8);
                            }else if(b5.getLabel().equals(" ")){
                                swapLables(b5, b8);
                            } 
                            playerWonCheck();
                 } 

                //b9 clicked
                if(e.getSource()==b9){  
                            if(b6.getLabel().equals(" ")){ 
                                swapLables(b6, b9);
                            } else if(b8.getLabel().equals(" ")){
                                swapLables(b8, b9);
                            }  
                            playerWonCheck();
                }

        }

         //main method
        public static void main(String[] args){  
                        new Puzzle();  
        }
  
} 