package com.kenny.my4096;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private TextView gridBoard0;
	private TextView gridBoard1;
	private TextView gridBoard2;
	private TextView gridBoard3;
	private TextView gridBoard4;
	private TextView gridBoard5;
	private TextView gridBoard6;
	private TextView gridBoard7;
	private TextView gridBoard8;
	private TextView gridBoard9;
	private TextView gridBoard10;
	private TextView gridBoard11;
	private TextView gridBoard12;
	private TextView gridBoard13;
	private TextView gridBoard14;
	private TextView gridBoard15;
	public static Logic gameBoard;
	private Button restartButton;
	private GestureDetector gestureDetector;
	private TableLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_main);
		
		gameBoard = new Logic();
		gameBoard.InitBoard();
		
		SetTextBoard();
		
		RefreshBoard();
		
		layout = (TableLayout) findViewById(R.id.container);
		
		gestureDetector = new GestureDetector(this, new MyGestureListener());
		
		layout.setOnTouchListener(new OnTouchListener(){
			
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				gestureDetector.onTouchEvent(event);
				RefreshBoard();
				
				if(gameBoard.FailCheck())
					Toast.makeText(MainActivity.this, R.string.game_over, Toast.LENGTH_LONG).show();
				
				return true;
			}
		});
		
		restartButton = (Button) findViewById(R.id.restart_button);
		restartButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameBoard.InitBoard();
				RefreshBoard();
				
			}
		});
		
			
	}
	
	private void SetTextBoard()
	{
		gridBoard0 = (TextView)findViewById(R.id.ttll);
		gridBoard1 = (TextView)findViewById(R.id.ttl);
		gridBoard2 = (TextView)findViewById(R.id.ttr);
		gridBoard3 = (TextView)findViewById(R.id.ttrr);
		gridBoard4 = (TextView)findViewById(R.id.tll);
		gridBoard5 = (TextView)findViewById(R.id.tl);
		gridBoard6 = (TextView)findViewById(R.id.tr);
		gridBoard7 = (TextView)findViewById(R.id.trr);
		gridBoard8 = (TextView)findViewById(R.id.bll);
		gridBoard9 = (TextView)findViewById(R.id.bl);
		gridBoard10 = (TextView)findViewById(R.id.br);
		gridBoard11 = (TextView)findViewById(R.id.brr);
		gridBoard12 = (TextView)findViewById(R.id.bbll);
		gridBoard13 = (TextView)findViewById(R.id.bbl);
		gridBoard14 = (TextView)findViewById(R.id.bbr);
		gridBoard15 = (TextView)findViewById(R.id.bbrr);
		
		
	
	}
	
	private void RefreshBoard()
	{
			if(gameBoard.getCell(0) != 0)
				gridBoard0.setText(Integer.toString(gameBoard.getCell(0)));
			else
				gridBoard0.setText(" ");
			if(gameBoard.getCell(1) != 0)
				gridBoard1.setText(Integer.toString(gameBoard.getCell(1)));
			else
				gridBoard1.setText(" ");
			if(gameBoard.getCell(2) != 0)
				gridBoard2.setText(Integer.toString(gameBoard.getCell(2)));
			else
				gridBoard2.setText(" ");
			if(gameBoard.getCell(3) != 0)
				gridBoard3.setText(Integer.toString(gameBoard.getCell(3)));
			else
				gridBoard3.setText(" ");
			if(gameBoard.getCell(4) != 0)
				gridBoard4.setText(Integer.toString(gameBoard.getCell(4)));
			else
				gridBoard4.setText(" ");
			if(gameBoard.getCell(5) != 0)
				gridBoard5.setText(Integer.toString(gameBoard.getCell(5)));
			else
				gridBoard5.setText(" ");
			if(gameBoard.getCell(6) != 0)
				gridBoard6.setText(Integer.toString(gameBoard.getCell(6)));
			else
				gridBoard6.setText(" ");
			if(gameBoard.getCell(7) != 0)
				gridBoard7.setText(Integer.toString(gameBoard.getCell(7)));
			else
				gridBoard7.setText(" ");
			if(gameBoard.getCell(8) != 0)
				gridBoard8.setText(Integer.toString(gameBoard.getCell(8)));
			else
				gridBoard8.setText(" ");
			if(gameBoard.getCell(9) != 0)
				gridBoard9.setText(Integer.toString(gameBoard.getCell(9)));
			else
				gridBoard9.setText(" ");
			if(gameBoard.getCell(10) != 0)
				gridBoard10.setText(Integer.toString(gameBoard.getCell(10)));
			else
				gridBoard10.setText(" ");
			if(gameBoard.getCell(11) != 0)
				gridBoard11.setText(Integer.toString(gameBoard.getCell(11)));
			else
				gridBoard11.setText(" ");
			if(gameBoard.getCell(12) != 0)
				gridBoard12.setText(Integer.toString(gameBoard.getCell(12)));
			else
				gridBoard12.setText(" ");
			if(gameBoard.getCell(13) != 0)
				gridBoard13.setText(Integer.toString(gameBoard.getCell(13)));
			else
				gridBoard13.setText(" ");
			if(gameBoard.getCell(14) != 0)
				gridBoard14.setText(Integer.toString(gameBoard.getCell(14)));
			else
				gridBoard14.setText(" ");
			if(gameBoard.getCell(15) != 0)
				gridBoard15.setText(Integer.toString(gameBoard.getCell(15)));
			else
				gridBoard15.setText(" ");
	}
}
