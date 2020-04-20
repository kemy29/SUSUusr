package com.example.tictac_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void buClick(View view) {
        Button buSelected= (Button) view;
        int CellID=0;
        //Get cellID depending on button clicked
        switch ((buSelected.getId())){

            case R.id.btn1:
                CellID=1;
                break;

            case R.id.btn2:
                CellID=2;
                break;

            case R.id.btn3:
                CellID=3;
                break;

            case R.id.btn4:
                CellID=4;
                break;

            case R.id.btn5:
                CellID=5;
                break;

            case R.id.btn6:
                CellID=6;
                break;

            case R.id.btn7:
                CellID=7;
                break;

            case R.id.btn8:
                CellID=8;
                break;

            case R.id.btn9:
                CellID=9;
                break;
        }
        PlayGame(CellID, buSelected);
    }

    int ActivePlayer=1; // 1- for first , 2 for second
    ArrayList<Integer> Player1= new ArrayList<Integer>();// hold player 1 data
    ArrayList<Integer> Player2= new ArrayList<Integer>();// hold player 2 data
    void PlayGame(int CellID,Button buSelected){

        Log.d("Player:",String.valueOf(CellID));

        if (ActivePlayer==1){
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.GREEN);
            Player1.add(CellID);
            ActivePlayer=2;

            AutoPlay();
        }
        else if (ActivePlayer==2){
            buSelected.setText("O");
            buSelected.setBackgroundColor(Color.BLUE);
            Player2.add(CellID);
            ActivePlayer=1;

        }

        buSelected.setEnabled(false);
        CheckWiner();

    }

    void CheckWiner(){
        int Winer=-1;
        //row 1
        if (Player1.contains(1) && Player1.contains(2)  && Player1.contains(3))  {
            Winer=1 ;
        }
        if (Player2.contains(1) && Player2.contains(2)  && Player2.contains(3))  {
            Winer=2 ;
        }

        //row 2
        if (Player1.contains(4) && Player1.contains(5)  && Player1.contains(6))  {
            Winer=1 ;
        }
        if (Player2.contains(4) && Player2.contains(5)  && Player2.contains(6))  {
            Winer=2 ;
        }

        //row 3
        if (Player1.contains(7) && Player1.contains(8)  && Player1.contains(9))  {
            Winer=1 ;
        }
        if (Player2.contains(7) && Player2.contains(8)  && Player2.contains(9))  {
            Winer=2 ;
        }


        //col 1
        if (Player1.contains(1) && Player1.contains(4)  && Player1.contains(7))  {
            Winer=1 ;
        }
        if (Player2.contains(1) && Player2.contains(4)  && Player2.contains(7))  {
            Winer=2 ;
        }

        //col 2
        if (Player1.contains(2) && Player1.contains(5)  && Player1.contains(8))  {
            Winer=1 ;
        }
        if (Player2.contains(2) && Player2.contains(5)  && Player2.contains(8))  {
            Winer=2 ;
        }


        //col 3
        if (Player1.contains(3) && Player1.contains(6)  && Player1.contains(9))  {
            Winer=1 ;
        }
        if (Player2.contains(3) && Player2.contains(6)  && Player2.contains(9))  {
            Winer=2 ;
        }

        //diagonal 1
        if (Player1.contains(1) && Player1.contains(5)  && Player1.contains(9))  {
            Winer=1 ;
        }

        if (Player2.contains(1) && Player2.contains(5)  && Player2.contains(9))  {
            Winer=2 ;
        }
        //diagonal 2
        if (Player1.contains(3) && Player1.contains(5)  && Player1.contains(7))  {
            Winer=1 ;
        }

        if (Player2.contains(3) && Player2.contains(5)  && Player2.contains(7))  {
            Winer=2 ;
        }


        if ( Winer !=-1){
            // We have winer

            if (Winer==1){
                Toast.makeText(this,"Player 1 is winner",Toast.LENGTH_LONG).show();
            }

            if (Winer==2){
                Toast.makeText(this,"Player 2 is winner",Toast.LENGTH_LONG).show();
            }

        }

    }

    void AutoPlay(){

        ArrayList<Integer> EmptyCells= new ArrayList<Integer>(); // all un selected cells
        //Find empty cells

        for (int cellID=1; cellID<10;cellID++){
            if (!( Player1.contains(cellID) || Player2.contains(cellID))){
                EmptyCells.add(cellID);
            }
        }

        Random r= new Random();
        int  RandIndex=r.nextInt(EmptyCells.size()- 0)+ 0; // if size =3 , select (0,1,2)
        int CellID=EmptyCells.get(RandIndex);

        Button buSelected;
        switch (CellID){

            case 1 :
                buSelected=(Button) findViewById(R.id.btn1);
                break;

            case 2:
                buSelected=(Button) findViewById(R.id.btn2);
                break;

            case 3:
                buSelected=(Button) findViewById(R.id.btn3);
                break;

            case 4:
                buSelected=(Button) findViewById(R.id.btn4);
                break;

            case 5:
                buSelected=(Button) findViewById(R.id.btn5);
                break;

            case 6:
                buSelected=(Button) findViewById(R.id.btn6);
                break;

            case 7:
                buSelected=(Button) findViewById(R.id.btn7);
                break;

            case 8:
                buSelected=(Button) findViewById(R.id.btn8);
                break;

            case 9:
                buSelected=(Button) findViewById(R.id.btn9);
                break;
            default:
                buSelected=(Button) findViewById(R.id.btn1);
                break;

        }
        PlayGame(CellID, buSelected);
    }


    public void buCLick(View view) {


    }
}
