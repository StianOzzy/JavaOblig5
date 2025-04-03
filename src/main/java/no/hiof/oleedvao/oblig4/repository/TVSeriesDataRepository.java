package no.hiof.oleedvao.oblig4.repository;

import no.hiof.oleedvao.oblig4.model.Episode;
import no.hiof.oleedvao.oblig4.model.TVSeries;

import java.time.LocalDate;
import java.util.ArrayList;

public class TVSeriesDataRepository implements TVSeriesRepository {

    private ArrayList<TVSeries> allTvSeries = new ArrayList<>();

    public TVSeriesDataRepository() {

        // Create TVSeries Breaking bad, with 3 Episode objects.
        TVSeries breakingBad = new TVSeries("Breaking Bad", "A teacher breaks bad", LocalDate.of(2008, 1, 20));
        Episode breakingBad_s1e1 = new Episode("s1e1",1,1);
        Episode breakingBad_s1e2 = new Episode("s1e2",2,1);
        Episode breakingBad_s1e3 = new Episode("s1e3",3,1);
        breakingBad.addEpisode(breakingBad_s1e1);
        breakingBad.addEpisode(breakingBad_s1e2);
        breakingBad.addEpisode(breakingBad_s1e3);

        // Add Breaking Bad Object to allTvSeries ArrayList
        allTvSeries.add(breakingBad);

        // Repeat process for TVSeries Game of Thrones
        TVSeries gameOfThrones = new TVSeries("Game of Thrones", "The game of power in Westeros", LocalDate.of(2000,4,17));
        Episode gameOfThrones_s1e1 = new Episode("s1e1",1,1);
        Episode gameOfThrones_s1e2 = new Episode("s1e2",2,1);
        Episode gameOfThrones_s1e3 = new Episode("s1e3",3,1);
        gameOfThrones.addEpisode(breakingBad_s1e1);
        gameOfThrones.addEpisode(breakingBad_s1e2);
        gameOfThrones.addEpisode(breakingBad_s1e3);

        allTvSeries.add(gameOfThrones);

    }

    // KODE MÅ SKRIVES---------------------------------------------------
    @Override
    public ArrayList<TVSeries> getAllTVSeries() {
        return new ArrayList<>(allTvSeries);
    }

    // KODE MÅ SKRIVES---------------------------------------------------
    @Override
    public TVSeries getTVSeries(String title) {
        for (TVSeries tvSeriesX : allTvSeries) {
            if (tvSeriesX.getTitle().equalsIgnoreCase(title)) {
                return tvSeriesX;
            }
        }
        return null;
    }

    @Override
    public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries) {

    }
}
