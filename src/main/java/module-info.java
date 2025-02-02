module hr.algebra.java2.cartographers {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires annotations;
    requires static lombok;
    requires jdk.internal.le;

    opens hr.algebra.java2.cartographers to javafx.fxml;
    exports hr.algebra.java2.cartographers;
    exports  hr.algebra.java2.cartographers.controllers;
    opens hr.algebra.java2.cartographers.controllers to javafx.fxml;
}