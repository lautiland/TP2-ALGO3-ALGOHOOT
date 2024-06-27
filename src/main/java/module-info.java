module edu.fiuba.algo3 {
    requires javafx.controls;
    requires com.google.gson;
    exports edu.fiuba.algo3;

    exports edu.fiuba.algo3.modelo;  // Exporta el paquete edu.fiuba.algo3.modelo
    opens edu.fiuba.algo3 to javafx.graphics;
}