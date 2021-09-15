import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.util.Date;
import java.util.*;
import java.nio.ByteBuffer;

class Board{
	private int[][] board = new int[20][20];
	private String redStones ; 


	Board(){
		for(int i = 0; i<20; i++){
			for(int j = 0; j<20; j++){
				this.board[i][j] =0;
			}
		}
		redStones = redStoneGenerater();
	}

	public boolean checkWin(){
		//Check if game is end
		return true;
	}

	private boolean checkValid(String stone){
		//Check if given stone is valid 
		return true;
	}


	public String getRedStones(){
		return redStones;
	}

	private boolean storeRedStones(int a, int b){
		if(this.board[20-b][a]!=-1){
			board[20-b][a] = -1;
			return true;
		}
		else{
			return false;
		}
	}

	private String redStoneGenerater(){
		int a  , b, numberOfRedstones;
		numberOfRedstones = 4;
		String newRedstones ="";
		
		for(int i=0; i<numberOfRedstones; i++){
			while(true){
				a = (int)((Math.random()* 10000)%19);
				if(a!=8) break;
			}	
			b = (int)((Math.random()*10000)%19)+1;
			char c = (char)(65+a);
			if(storeRedStones(a, b)){
				newRedstones = newRedstones+String.valueOf(c);
				if(b<10){
					newRedstones = newRedstones+ Integer.toString(0);
				}
				newRedstones = newRedstones+ Integer.toString(b);
			}
		}	
		return newRedstones;
	}	

}
