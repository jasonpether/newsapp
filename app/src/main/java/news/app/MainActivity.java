package news.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewone, TopStoriesRV;
    RVAdapter rvAdapterone, TopStoriesAdapter;
    List<News> newsList = new ArrayList<>();
    List<News> topStoriesList = new ArrayList<>();

    String[] TopStories = {"NEW ANIMAL DISCOVERED", "FLYING WATERMELON INVASION", "ALIEN UFO DISCOVERED?"};
    String[] headlineList =  {" BEAR ON THE LOOSE", "POTATO SHORTAGE", "TAX REDUCED", "SCHOOL CANCELLED"};
    Bitmap[] TopStoryBitMaps;
    Bitmap[] bitmaps;

    private void fragmentChoiceOpen(int position)
    {
        Fragment fragment;

        switch (position){
            case 0:
                fragment = new BearFrag();
                break;
            case 1:
                fragment = new PotatoFrag();
                break;
            case 2:
                fragment = new TaxFrag();
                break;
            default:
                fragment = new SchoolFrag();
                break;
        }
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewone = findViewById(R.id.NewsRV);
        rvAdapterone = new RVAdapter(newsList, this);
        recyclerViewone.setAdapter(rvAdapterone);
        recyclerViewone.setLayoutManager(new GridLayoutManager(this, 2));

        int[] images = {R.drawable.images, R.drawable.potatos, R.drawable.money, R.drawable.school};
        bitmaps = new Bitmap[images.length];


        for (int i = 0; i < images.length; i++) {
            bitmaps[i] = BitmapFactory.decodeResource(getResources(), images[i]);
        }

        for (int x = 0; x < headlineList.length; x++) {
            News news = new News(x, headlineList[x], bitmaps[x]);
            newsList.add(news);
        }

        rvAdapterone.setOnItemClickListener(position -> {
            fragmentChoiceOpen(position);
            Toast.makeText(MainActivity.this, "Item clicked at position " + position, Toast.LENGTH_SHORT).show();
        });



        TopStoriesRV = findViewById(R.id.TopStoriesRV);
        TopStoriesAdapter = new RVAdapter(topStoriesList, this);
        TopStoriesRV.setAdapter(TopStoriesAdapter);
        TopStoriesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        int[] topStoriesimg = {R.drawable.question, R.drawable.melon, R.drawable.ufo};
        TopStoryBitMaps = new Bitmap[topStoriesimg.length];

        for (int z = 0; z < topStoriesimg.length; z++)
        {
            TopStoryBitMaps[z] = BitmapFactory.decodeResource(getResources(), topStoriesimg[z]);
        }
        for (int a = 0; a < TopStories.length; a++)
        {
            News topstories = new News(a, TopStories[a], TopStoryBitMaps[a]);
            topStoriesList.add(topstories);
        }


    }

}