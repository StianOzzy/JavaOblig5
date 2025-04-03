package no.hiof.oleedvao.oblig4;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import java.time.LocalDate;
import java.util.ArrayList;


public class Application {

    public static void main(String[] args) {

        Javalin app = Javalin.create(JavalinConfig -> {
            JavalinConfig.staticFiles.enableWebjars();
            JavalinConfig.vue.vueInstanceNameInJs = "app";
        }).start();

        app.get("/", new VueComponent("home-page"));


    }


}
