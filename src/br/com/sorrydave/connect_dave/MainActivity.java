package br.com.sorrydave.connect_dave;

import java.util.ArrayList;

import br.com.sorrydave.connect_dave.sqlite.Connection;
import br.com.sorrydave.connect_dave.sqlite.MySQLiteHelper;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

public class MainActivity extends Activity {

	final static int FRAGMENT_HOME = 0;
	final static int FRAGMENT_LIST = 1;
	final static int FRAGMENT_REGISTER = 2;
	final static int FRAGMENT_SETTINGS = 3;
	final static int FRAGMENT_ABOUT = 4;
	MySQLiteHelper db;	
	public ArrayList<Connection> Lista = new ArrayList<Connection>();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        db = new MySQLiteHelper(this);      
        
        
        
        /*
               List<Connection> list = db.getAllConnections();        
        db.deleteConnection(list.get(0));        
        db.getAllConnections();
        */
                
    }
	
	
	public void initRegisterFragment(){
		setContentView(R.layout.activity_main);        
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new RegisterFragment())
                .commit();
        /*
        db.addConnection(new Connection("teste2", "test2e"));
        db.getAllConnections();
        
        */
        
	}
	
	public void initListFragment(){
		setContentView(R.layout.activity_main);        
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new ListFragment())
                .commit();
	}

	public void initConfigFragment(){
		setContentView(R.layout.activity_main);        
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new ConfigFragment())
                .commit();
	}
	
	public void initAboutFragment(){
		setContentView(R.layout.activity_main);        
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new AboutFragment())
                .commit();
	}
	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_register_website) {      
        	initRegisterFragment();
        	Log.v("ActionBar", "Register Pressionado");
            return true;            
        }else if(id == R.id.action_list_website) {
        	initListFragment();
        	Log.v("ActionBar", "List Pressionado");
        	return true;
        }else if(id == R.id.action_config) {
        	initConfigFragment();
        	Log.v("ActionBar", "Config Pressionado");
        	return true;
        }else if(id == R.id.action_about) {
        	initAboutFragment();
        	Log.v("ActionBar", "About Pressionado");
        	return true;
        }
        
        
        return super.onOptionsItemSelected(item);
    }

}