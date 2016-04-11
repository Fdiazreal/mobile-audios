package com.fdiazreal.android.tinchos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Android's view that recycles UI elements en a list/grid
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardList);
        recyclerView.setHasFixedSize(true); // Improve performance #PerfMatters (?)

        // RecyclerView requires a manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        CardAdapter cardAdapter = new CardAdapter(createElements());
        recyclerView.setAdapter(cardAdapter);
    }

    private List<SentAudio> createElements() {
        List<SentAudio> elements = new ArrayList<>();

        elements.add(new SentAudio("Derecha", R.raw.derecha));
        elements.add(new SentAudio("Taxi", R.raw.taxi));
        elements.add(new SentAudio("Dónde estan?!?!", R.raw.dondeestan));
        elements.add(new SentAudio("Estamos yendoo", R.raw.estamosyendo));
        elements.add(new SentAudio("Guarda con Cramer!", R.raw.guardaconcramer));
        elements.add(new SentAudio("Nahuuu", R.raw.nahuuu));
        elements.add(new SentAudio("Todo simulado", R.raw.todosimulado));

        return elements;
    }
}
