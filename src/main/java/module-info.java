module edu.fiuba.algo3 {
    requires javafx.controls;
    requires com.google.gson;
    requires java.desktop;
    exports edu.fiuba.algo3;

    opens edu.fiuba.algo3 to javafx.graphics;
}