package no.hiof.oleedvao.oblig4;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import io.javalin.vue.VueHandler;
import no.hiof.oleedvao.oblig4.controller.TVSeriesController;
import no.hiof.oleedvao.oblig4.model.TVSeries;
import no.hiof.oleedvao.oblig4.repository.TVSeriesDataRepository;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;


public class Application {


    public static void main(String[] args) {

        // All code up to task 2.7 is commented out, because of how task 2.7 affect the application. See marked line
        /*
------------------------------------------------------------------------------------------------------------------------

        TVSeriesDataRepository tvSeriesDataRepository1 = new TVSeriesDataRepository();

        Javalin app = Javalin.create(JavalinConfig -> {
            JavalinConfig.staticFiles.enableWebjars();
            JavalinConfig.vue.vueInstanceNameInJs = "app";
        }).start();

        // 2.3
        app.get("/", new VueComponent("home-page"));


        // 2.4 A)

        app.get("/api/tvseries", new Handler() {
                    @Override
                    public void handle(@NotNull Context context) throws Exception {
                        context.json(tvSeriesDataRepository1.getAllTVSeries());
                    }
                });


        // 2.4 B)

        app.get("/tvseries", new VueComponent("tvseries-overview"));


        // 2.5 A)

        app.get("/api/tvseries/{tvseries-name}", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                String tvSeriesName = context.pathParam("tvseries-name");
                TVSeries fetchedTvSeries = tvSeriesDataRepository1.getTVSeries(tvSeriesName);

                if (fetchedTvSeries != null) {
                    context.json(fetchedTvSeries);
                }
                else {
                    context.result("Could not find the tv series " + tvSeriesName);
                }
            }
        });


        // 2.5 B)

        app.get("/tvseries/{tvseries-name}", new VueComponent("tvseries-detail"));


        // 2.6 A)

        app.get("/add-tvseries", new VueComponent("add-tvseries"));


        // 2.6 B)

        app.post("/api/add-tvseries", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                String title = context.formParam("title");
                String description = context.formParam("description");
                int year = Integer.parseInt(context.formParam("release-date-year"));
                int month = Integer.parseInt(context.formParam("release-date-month"));
                int day = Integer.parseInt(context.formParam("release-date-day"));
                LocalDate releaseDate = LocalDate.of(year, month, day);

                TVSeries newTVSeries = new TVSeries(title, description, releaseDate);
                tvSeriesDataRepository1.addTVSeries(newTVSeries);

                context.redirect("/tvseries/" + title);
            }
        });
------------------------------------------------------------------------------------------------------------------------
         */

        // Code from here on out is specific to task 2.7

        TVSeriesDataRepository tvSeriesDataRepository1 = new TVSeriesDataRepository();
        TVSeriesController tvSeriesController = new TVSeriesController(tvSeriesDataRepository1);

        
        Javalin app = Javalin.create(JavalinConfig -> {
            JavalinConfig.staticFiles.enableWebjars();
            JavalinConfig.vue.vueInstanceNameInJs = "app";
        }).start();

        // Vue components
        app.get("/", new VueComponent("home-page"));
        app.get("/tvseries", new VueComponent("tvseries-overview"));
        app.get("/tvseries/{tvseries-name}", new VueComponent("tvseries-detail"));
        app.get("/add-tvseries", new VueComponent("add-tvseries"));

        // API-calls from TVSeriesController
        app.get("/api/tvseries", context -> tvSeriesController.getAllTVSeries(context));
        app.get("/api/tvseries/{tvseries-name}", context -> tvSeriesController.getTVSeries(context));
        app.post("/api/add-tvseries", context -> tvSeriesController.addTVSeries(context));

    }

}
