package id.mustaf.carousel.carousellayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;
    private CoverFlowAdapter adapter;
    private ArrayList<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);

        settingDummyData();
        adapter = new CoverFlowAdapter(this, books);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
    }

    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
            }
        };
    }

    private void settingDummyData() {
        books = new ArrayList<>();
        books.add(new Book(R.mipmap.harry_potter7, "Harry Potter and the Deathly Hallows"));
        books.add(new Book(R.mipmap.hunger_games, "The Hunger Games"));
        books.add(new Book(R.mipmap.kite_runner, "The Kite Runner"));
        books.add(new Book(R.mipmap.book_thief, "The Book Thief "));
        books.add(new Book(R.mipmap.harry_potter6, "Harry Potter and the Half-Blood Prince"));
        books.add(new Book(R.mipmap.harry_potter5, "Harry Potter and the Order of the Phoenix"));
        books.add(new Book(R.mipmap.the_help, "The Help "));
        books.add(new Book(R.mipmap.splendid_suns, "A Thousand Splendid Suns "));
        books.add(new Book(R.mipmap.life_of_pi, "Life of Pi "));
        books.add(new Book(R.mipmap.catching_fire, "Catching Fire"));
    }
}
