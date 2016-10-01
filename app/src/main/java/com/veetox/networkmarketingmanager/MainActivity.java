package com.veetox.networkmarketingmanager;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.veetox.networkmarketingmanager.data.Prospects;
import com.veetox.networkmarketingmanager.helper.FileHelper;
import com.veetox.networkmarketingmanager.helper.ProspectListAdapter;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    public static ArrayList<Prospects> prospectList = new ArrayList<>();
    Resources res;
    FileHelper fileHelper = new FileHelper(this);


    ListView prospectsListEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = getResources();

        //Build list of prospects
        createProspectList();

        //setup toolbar
        Toolbar appToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(appToolbar);

    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_addProspect:

                //TODO add functionality to add a new prospect to the list which is then saved.

                fileHelper.saveProspects(prospectList);

                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


        public void onItemClick(AdapterView parent, View v, int position, long id)
        {
            EditText editText = (EditText) findViewById(R.id.pr_name);
            CheckBox checkBox = (CheckBox) findViewById(R.id.pr_checkBox);
            prospectList.get(position).setName(editText.getText().toString());
            prospectList.get(position).setContacted(checkBox.isChecked());

        }


    public void onCheckboxClicked(View view)
    {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked)
        {
            //TODO add behaviour when checkbox clicked

        }

    }

    public void createProspectList()
    {
        fileHelper = new FileHelper(this);

        //Uncomment after testing
        //prospectList = fileHelper.loadProspects();

        prospectList = fileHelper.testProspects();

        //Create the list
        ProspectListAdapter pla = new ProspectListAdapter(this, R.layout.prospects_list_layout, prospectList);
        prospectsListEntry = (ListView) findViewById(R.id.prospects_list);
        prospectsListEntry.setAdapter(pla);

    }
}
