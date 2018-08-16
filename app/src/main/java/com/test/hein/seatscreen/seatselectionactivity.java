package com.test.hein.seatscreen;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import java.util.ArrayList;

/**
 *
 * @author Saurabh tomar
 *
 */

public class seatselectionactivity extends Activity implements OnItemClickListener
{
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    customgridviewadapter customGridAdapter;
    public Bitmap seatIcon;
    public Bitmap seatSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seatselectionactivity);

        // set grid view item
        seatIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.seat_layout_screen_nor_avl);
        seatSelect = BitmapFactory.decodeResource(this.getResources(), R.drawable.seat_layout_screen_nor_std);
        totalSeat(50);

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new customgridviewadapter(this, R.layout.seatrow_grid, gridArray);
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener(this);
    }

    public void totalSeat(int n)
    {
        for (int i = 1; i <= n; ++i)
        {
            gridArray.add(new Item(seatIcon, "seat " + i));

        }
    }

    public void seatSelected(int pos)
    {
        gridArray.remove(pos);
        gridArray.add(pos, new Item(seatSelect, "select"));
        customGridAdapter.notifyDataSetChanged();
    }

    public void seatDeselcted(int pos)
    {

        gridArray.remove(pos);
        int i = pos + 1;
        gridArray.add(pos, new Item(seatIcon, "seat" + i));
        customGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

        Item item = gridArray.get(position);
        Bitmap seatcompare = item.getImage();
        if (seatcompare == seatIcon)
        {
            seatSelected(position);
        }
        else
        {
            seatDeselcted(position);

        }

    }

}