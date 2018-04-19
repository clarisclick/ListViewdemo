package com.example.claris.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    private ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.lv);
        final String[] city=getResources().getStringArray(R.array.city);
        adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,city);
        lv.setAdapter(adapter);/*adaper适配器*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s1=city[position];
                String s2=adapter.getItem(position);
                String s3=parent.getItemAtPosition(position).toString();
                String s4=lv.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,"s1="+s1+",s2="+s2+",s3="+s3+",s4="+s4,Toast.LENGTH_SHORT).show();

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"长按事件",Toast.LENGTH_SHORT).show();
                return false;/*对长按事件不响应*/
            }
        });
    }
}
