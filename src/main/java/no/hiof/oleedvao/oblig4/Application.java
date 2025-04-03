package no.hiof.oleedvao.oblig4;

import io.javalin.Javalin;

public class Application {

    public static void main(String[] args) {

        Javalin app = Javalin.create(JavalinConfig -> {
            JavalinConfig.staticFiles.enableWebjars();
            JavalinConfig.vue.vueInstanceNameInJs = "app";
        }).start();

    }

}
