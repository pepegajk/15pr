package com.example.a15pr;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DataBaseHelper dbHelper;
    private ArrayList<Book> bookArrayList;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DataBaseHelper(this);
        bookArrayList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, bookArrayList);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab_add_book);
        fab.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AddBookActivity.class)));
        loadBooks();

        private void loadBooks() {
            bookArrayList.clear();
            Cursor cursor = dbHelper.getAllBooks();
            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndex0rThrow(DataBaseHelper.COLUMN_ID));
                    String name = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.COLUMN_NAME));
                    String author= cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.COLUMN_AUTHOR));
                    bookArrayList.add(new Book(id, author, name));
                } while (cursor.moveToNext());
            }
            cursor.close();
            adapter.notifyDataSetChanged();

        }

        @Override
        protected void onResume() {
            super.onResume();
            loadBooks();
        }
    }
}