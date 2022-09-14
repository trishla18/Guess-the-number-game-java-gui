package com.java;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.*;

class Main extends JFrame{
    JTextField guess, bestScore, totalGuess;
    JLabel inputLabel,guessLabel,tryLabel,bestScoreLabel,totalGuessLabel,imgLabel;

    int rand = (int) (Math.random()*100);
    int count=0;
    public Main(){
        Container c=getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        guessLabel=new JLabel("GUESS THE NUMBER?");
        guessLabel.setForeground(Color.YELLOW);
        guessLabel.setFont(new Font("times new roman",Font.BOLD,24));
        guessLabel.setSize(270,20);
        guessLabel.setLocation(70,70);

        inputLabel=new JLabel("ENTER A NUMBER BETWEEN 1-100");
        inputLabel.setFont(new Font("Comic sans MS",Font.PLAIN,14));
        inputLabel.setSize(270,20);
        inputLabel.setLocation(70,90);

        tryLabel=new JLabel("TRY AND GUESS IT!");
        tryLabel.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        tryLabel.setSize(270,20);
        tryLabel.setLocation(110,160);

        guess=new JTextField(10);
        guess.setSize(50,30);
        guess.setLocation(140,120);

        bestScore=new JTextField(10);
        bestScore.setSize(30,20);
        bestScore.setLocation(10,10);

        bestScoreLabel = new JLabel("YOUR BEST SCORE");
        bestScoreLabel.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        bestScoreLabel.setSize(270,20);
        bestScoreLabel.setLocation(50,10);

        totalGuess=new JTextField(10);
        totalGuess.setSize(30,20);
        totalGuess.setLocation(10,40);

        totalGuessLabel=new JLabel("NUMBER OF GUESSES");
        totalGuessLabel.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        totalGuessLabel.setSize(270,20);
        totalGuessLabel.setLocation(50,40);

        imgLabel=new JLabel("");
        imgLabel.setIcon(new ImageIcon("C:/Users/trish/OneDrive/Desktop/Shinchan.png"));
        imgLabel.setBounds(400,40,500,550);

        JButton guessButton = new JButton("GUESS");
        guessButton.setSize(100,30);
        guessButton.setLocation(110,190);
        guessButton.setBackground(Color.GREEN);
        guessButton.addActionListener(new ActionListener() {
            int bestScore=100;
            @Override
            public void actionPerformed(ActionEvent e) {
                int a=Integer.parseInt(guess.getText());
                count=count+1;
                if(a<rand){
                    tryLabel.setText(a + " IS LOW, TRY AGAIN!");
                }
                else if(a>rand){
                    tryLabel.setText(a+" IS HIGH, TRY AGAIN!");
                }
                else{
                    tryLabel.setText("YOUR GUESS IS CORRECT, YOU WIN!!");
                    if (count<bestScore){
                        bestScore=count;
                        bestScoreLabel.setText(bestScore + "") ;
                    }
                    else{
                        bestScoreLabel.setText(""+bestScore);
                    }
                    guess.setEditable(false);
                }
                guess.requestFocus();
                guess.selectAll();
                totalGuess.setText(count + "");
            }
        });

        JButton giveUpButton = new JButton("GIVE UP");
        giveUpButton.setSize(100,30);
        giveUpButton.setLocation(50,240);
        giveUpButton.setBackground(Color.GREEN);
        giveUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalGuess.setText("");
                tryLabel.setText("THE CORRECT ANSWER IS "+rand+"!!");
                guess.setText("");
                guess.setEditable(false);
            }
        });

        JButton playAgainButton = new JButton("PLAY AGAIN");
        playAgainButton.setSize(100,30);
        playAgainButton.setLocation(170,240);
        playAgainButton.setBackground(Color.GREEN);
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rand=(int)(Math.random()*100);
                guess.setText("");
                totalGuess.setText("");
                tryLabel.setText("TRY AND GUESS IT!");
                totalGuess.setText("");
                count=0;
                guess.setEditable(true);
                guess.requestFocus();


            }
        });

        c.add(bestScoreLabel);
        c.add(totalGuessLabel);
        c.add(tryLabel);
        c.add(imgLabel);
        c.add(guessLabel);
        c.add(inputLabel);
        c.add(guess);
        c.add(bestScore);
        c.add(totalGuess);
        c.add(guessButton);
        c.add(giveUpButton);
        c.add(playAgainButton);

        bestScore.setEditable(false);
        totalGuess.setEditable(false);
        setTitle("GUESS THE NUMBER");
        setSize(500,350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Main();
    }
}

//    private class buttonListener implements ActionListener{
//        int bestScore=100;
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            int a=Integer.parseInt(guess.getText());
//            count=count+1;
//            if(a<rand){
//                tryLabel.setText(a + " IS LOW, TRY AGAIN!");
//            }
//            else if(a>rand){
//                tryLabel.setText(a+" IS HIGH, TRY AGAIN!");
//            }
//            else{
//                tryLabel.setText("YOUR GUESS IS CORRECT, YOU WIN!!");
//                if (count<bestScore){
//                    bestScore=count;
//                    bestScoreLabel.setText(bestScore + " ") ;
//                }
//                else{
//                    bestScoreLabel.setText(" "+bestScore);
//                }
//                guess.setEditable(false);
//            }
//            guess.requestFocus();
//            guess.selectAll();
//            totalGuess.setText(count + " ");
//        }


//    private class buttonListener2 implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            totalGuess.setText(" ");
//            tryLabel.setText("THE CORRECT ANSWER IS "+rand+"!!");
//            guess.setText(" ");
//            guess.setEditable(false);
//        }
//    }
//
//    private class buttonListener3 implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            rand=(int)(Math.random()*100);
//            guess.setText(" ");
//            totalGuess.setText(" ");
//            tryLabel.setText("TRY AND GUESS IT!");
//            totalGuess.setText(" ");
//            count=0;
//            guess.setEditable(true);
//            guess.requestFocus();
//        }
//    }

