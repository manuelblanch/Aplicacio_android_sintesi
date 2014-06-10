package com.iesebre.DAM2.consolegeneration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.iesebre.DAM2.consolegeneration.DashBoardActivity;
import com.iesebre.DAM2.consolegeneration.PantallaCarga;
import com.iesebre.DAM2.consolegeneration.R;

public class PantallaCarga extends Activity {
	
private final int DURACION_SPLASH = 3000;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_carga);
        
        new Handler().postDelayed(new Runnable(){
        	public void run(){
        		Intent intent = new Intent(PantallaCarga.this, DashBoardActivity.class);
        		startActivity(intent);
        		finish();
        	};
        	
        }, DURACION_SPLASH);
        
	}
	

}
