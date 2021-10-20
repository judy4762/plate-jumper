module js.jumpnrun {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens js.jumpnrun to javafx.fxml;
    exports js.jumpnrun;
}