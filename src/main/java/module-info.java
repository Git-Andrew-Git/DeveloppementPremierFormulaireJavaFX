module fr.andrew.developpementpremierformulaire {
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires com.jfoenix;

    opens fr.andrew.developpementpremierformulaire to javafx.fxml;
    exports fr.andrew.developpementpremierformulaire;
}