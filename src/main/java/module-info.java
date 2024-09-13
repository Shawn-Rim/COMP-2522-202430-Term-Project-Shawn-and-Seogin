module com.example.comp2522202430termprojectshawnandseogin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.comp2522202430termprojectshawnandseogin to javafx.fxml;
    exports com.example.comp2522202430termprojectshawnandseogin;
}