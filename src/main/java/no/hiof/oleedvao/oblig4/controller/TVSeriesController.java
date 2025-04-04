package no.hiof.oleedvao.oblig4.controller;

import no.hiof.oleedvao.oblig4.model.TVSeries;
import no.hiof.oleedvao.oblig4.repository.TVSeriesRepository;
import io.javalin.http.Context;
import java.time.LocalDate;

public class TVSeriesController {

    private TVSeriesRepository tvSeriesRepository;

    public TVSeriesController(TVSeriesRepository tvSeriesRepository) {
        this.tvSeriesRepository = tvSeriesRepository;
    }


    // get /api/tvseries
    public void getAllTVSeries(Context context) {
        context.json(tvSeriesRepository.getAllTVSeries());
    }

    // get /api/tvseries/{tvseries-name}
    public void getTVSeries(Context context) {
        String tvSeriesName = context.pathParam("tvseries-name");
        TVSeries fetchedTvSeries = tvSeriesRepository.getTVSeries(tvSeriesName);

        if (fetchedTvSeries != null) {
            context.json(fetchedTvSeries);
        } else {
            context.result("Could not find the tv series " + tvSeriesName);
        }
    }

    // post /api/add-tvseries
    public void addTVSeries(Context context) {
        String title = context.formParam("title");
        String description = context.formParam("description");
        int year = Integer.parseInt(context.formParam("release-date-year"));
        int month = Integer.parseInt(context.formParam("release-date-month"));
        int day = Integer.parseInt(context.formParam("release-date-day"));
        LocalDate releaseDate = LocalDate.of(year, month, day);

        TVSeries newTVSeries = new TVSeries(title, description, releaseDate);
        tvSeriesRepository.addTVSeries(newTVSeries);

        context.redirect("/tvseries/" + title);
    }

}
