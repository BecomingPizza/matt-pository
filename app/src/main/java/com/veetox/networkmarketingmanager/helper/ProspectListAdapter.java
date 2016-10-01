package com.veetox.networkmarketingmanager.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.veetox.networkmarketingmanager.R;
import com.veetox.networkmarketingmanager.data.Prospects;

import java.util.ArrayList;

/**
 * Created by Matt on 29/09/2016.
 */

public class ProspectListAdapter extends ArrayAdapter<Prospects>
{
    private Context context;
    private int layoutResourceId;
    private ArrayList<Prospects> prospect;

    public ProspectListAdapter(Context context, int layoutResourceId, ArrayList<Prospects> prospect)
    {
        super(context, layoutResourceId, prospect);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.prospect = prospect;
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        View v = convertView;

        if (v == null)
        {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(layoutResourceId, parent, false);
        }

        Prospects p = prospect.get(position);

        if (p != null)
        {
            TextView prname = (TextView) v.findViewById(R.id.pr_name);
            CheckBox complete = (CheckBox) v.findViewById(R.id.pr_checkBox);


            if (prname != null)
            {
                prname.setText(p.getName());
            }

            if (complete != null)
            {
                complete.setChecked(p.getContacted());
            }
        }

        return v;
    }

}
