package com.iesebre.DAM2.consolegeneration;

import com.iesebre.DAM2.consolegeneration.productos_json;
import com.iesebre.DAM2.consolegeneration.HomeActivity;
import com.iesebre.DAM2.consolegeneration.R;




import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.*;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public abstract class DashBoardActivity extends Activity {

	   /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    public void setHeader(String title, boolean btnHomeVisible, boolean btnFeedbackVisible)
    {
    		ViewStub stub = (ViewStub) findViewById(R.id.vsHeader);
    		View inflated = stub.inflate();
    }

	

	
	
	

	/**
	 * Handle the click of a Feature button.
	 * 
	 * @param v View
	 * @return void
	 */

	
	

	/**
	 * Use the activity label to set the text in the activity's title text view.
	 * The argument gives the name of the view.
	 *
	 * <p> This method is needed because we have a custom title bar rather than the default Android title bar.
	 * See the theme definitons in styles.xml.
	 * 
	 * @param textViewId int
	 * @return void
	 */

	public void setTitleFromActivityLabel (int textViewId)
	{
	    TextView tv = (TextView) findViewById (textViewId);
	    if (tv != null) tv.setText (getTitle ());
	} // end setTitleText

	/**
	 * Show a string on the screen via Toast.
	 * 
	 * @param msg String
	 * @return void
	 */

	public void toast (String msg)
	{
	    Toast.makeText (getApplicationContext(), msg, Toast.LENGTH_SHORT).show ();
	} // end toast

	/**
	 * Send a message to the debug log and display it using Toast.
	 */
	public void trace (String msg) 
	{
	    Log.d("Demo", msg);
	    toast (msg);
	}

	} // end class


