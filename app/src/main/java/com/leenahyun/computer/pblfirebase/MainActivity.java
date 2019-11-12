package com.leenahyun.computer.pblfirebase;

import android.content.Intent;
import android.renderscript.Sampler;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> arrayList;
    private Button top;
    private Button bottom;
    private Button outer;
    private Button shoe;
    private Button onepiece;
    private Button knit;
    private String sendData;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private ArrayAdapter<String> adapter;
    private ArrayList<Item> items;
    private String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();

        // Adapter adapter=new Adapter();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        items=new ArrayList<Item>();
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemListener);

    }


    private void initLayout(){
        arrayList=new ArrayList<>();
       // arrayList.add("test");
        listView=findViewById(R.id.listView);

        top=findViewById(R.id.Top);
        bottom=findViewById(R.id.Bottom);
        knit=findViewById(R.id.Knit);
        onepiece=findViewById(R.id.Onepiece);
        shoe=findViewById(R.id.Shoe);
        outer=findViewById(R.id.Outer);

        top.setOnClickListener(catListener);
        bottom.setOnClickListener(catListener);
        knit.setOnClickListener(catListener);
        onepiece.setOnClickListener(catListener);
        shoe.setOnClickListener(catListener);
        outer.setOnClickListener(catListener);


    }
    public View.OnClickListener catListener=new View.OnClickListener(){
        public void onClick(View v){
            switch(v.getId()){
                case R.id.Bottom:
                    databaseReference.addValueEventListener(bottomEventListener);
                    break;


                case R.id.Knit:
                    databaseReference.addValueEventListener(knitEventListener);

                    break;
                case R.id.Onepiece:
                    databaseReference.addValueEventListener(onepieceEventListener);

                    break;
                case R.id.Shoe:
                    databaseReference.addValueEventListener(shoesEventListener);

                    break;
                case R.id.Outer:
                    databaseReference.addValueEventListener(outerEventListener);

                    break;
                case R.id.Top:
                    databaseReference.addValueEventListener(topEventListener);

                    break;

            }
        }
    };

    ValueEventListener bottomEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.hasChild("bottom")){
                System.out.println(dataSnapshot.child("bottom").getValue().toString());
                value=dataSnapshot.child("bottom").getValue().toString();
                value.substring(0,value.length()-1);
                arrayList= Arrays.asList(value.split(","));
                System.out.println(arrayList.get(0));
                adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(adapter);

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    ValueEventListener knitEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.hasChild("knit")){
               // System.out.println(dataSnapshot.child("knit").getValue());
                String value=dataSnapshot.child("knit").getValue().toString();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
    ValueEventListener onepieceEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.hasChild("onepiece")){
               // System.out.println(dataSnapshot.child("onepiece").getValue());
                String value=dataSnapshot.child("onepiece").getValue().toString();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
    ValueEventListener outerEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.hasChild("outer")){
               // System.out.println(dataSnapshot.child("outer").getValue());
                String value=dataSnapshot.child("outer").getValue().toString();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
    ValueEventListener shoesEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.hasChild("shoes")){
                System.out.println(dataSnapshot.child("shoes").getValue());
                String value=dataSnapshot.child("shoes").getValue().toString();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
    ValueEventListener topEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.hasChild("top")){
                System.out.println(dataSnapshot.child("top").getValue());
                String value=dataSnapshot.child("top").getValue().toString();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };




    public AdapterView.OnItemClickListener itemListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            sendData=value;
            Intent intent=new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("sendData",sendData);
            startActivity(intent);

        }
    };
}