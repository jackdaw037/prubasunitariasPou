package org.example.pou_pruebastest;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controlador {

    private Modelo modelo;


    @FXML private Label lblNombre;
    @FXML private Label lblDinero;
    @FXML private Label lblInventario;

    @FXML private ProgressBar barraHambre;
    @FXML private ProgressBar barraFelicidad;
    @FXML private ProgressBar barraEnergia;

    @FXML private Button btnComer;
    @FXML private Button btnDormir;
    @FXML private Button btnJugar;
    @FXML private Button btnTienda;


    public void setModelo(Modelo modelo){
        this.modelo = modelo;
        configurarEventos();
        actualizar();
    }

    private void configurarEventos(){
        btnComer.setOnAction(e -> comer());
        btnDormir.setOnAction(e -> dormir());
        btnJugar.setOnAction(e -> jugar());
        btnTienda.setOnAction(e -> tienda());
    }

    // ------------------- ACCIONES -------------------

    private void comer(){

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Hamburguesa",
                "Hamburguesa","Kebab","Taco","Sushi","Pan");

        dialog.setTitle("Inventario");

        dialog.showAndWait().ifPresent(comida -> {

            if(modelo.tieneComida(comida)){
                modelo.consumirComida(comida);
            } else {
                alerta("No tienes esa comida");
            }

            actualizar();
        });
    }

    private void dormir(){
        modelo.aumentarEnergia(30);
        modelo.reducirHambre(10);
        actualizar();
    }

    private void jugar(){

        if(modelo.getEnergia() < 10){
            alerta("Tu Pou está muy cansado");
            return;
        }

        modelo.reducirEnergia(15);
        modelo.aumentarFelicidad(20);
        modelo.aumentarDinero(10);

        actualizar();
    }

    private void tienda(){

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Hamburguesa 20",
                "Hamburguesa 20","Kebab 15","Taco 10","Sushi 25","Pan 5");

        dialog.setTitle("Tienda");

        dialog.showAndWait().ifPresent(comida -> {

            int precio = obtenerPrecio(comida);

            if(modelo.getDinero() < precio){
                alerta("Dinero insuficiente");
                return;
            }

            modelo.comprarComida(extraerNombre(comida), precio);

            actualizar();
        });
    }


    private int obtenerPrecio(String comida){

        if(comida.contains("Hamburguesa")) return 20;
        if(comida.contains("Kebab")) return 15;
        if(comida.contains("Taco")) return 10;
        if(comida.contains("Sushi")) return 25;
        if(comida.contains("Pan")) return 5;

        return 0;
    }

    private String extraerNombre(String comida){
        return comida.split(" ")[0];
    }


    private void actualizar(){

        lblNombre.setText("Pou: " + modelo.getNombre());
        lblDinero.setText("Dinero: " + modelo.getDinero());

        barraHambre.setProgress(modelo.getHambre() / 100.0);
        barraFelicidad.setProgress(modelo.getFelicidad() / 100.0);
        barraEnergia.setProgress(modelo.getEnergia() / 100.0);

        lblInventario.setText(
                "Hamburguesa: " + modelo.getHamburguesa() + "\n" +
                        "Kebab: " + modelo.getKebab() + "\n" +
                        "Taco: " + modelo.getTaco() + "\n" +
                        "Sushi: " + modelo.getSushi() + "\n" +
                        "Pan: " + modelo.getPan()
        );

        verificarEstado();
    }

    private void verificarEstado(){

        if(modelo.getHambre() <= 0){
            alerta("Tu Pou murió de hambre");
            System.exit(0);
        }

        if(modelo.getHambre() < 20)
            alerta("Tu Pou tiene mucha hambre");

        if(modelo.getEnergia() < 20)
            alerta("Tu Pou está cansado");

        if(modelo.getFelicidad() < 20)
            alerta("Tu Pou está triste");
    }


    private void alerta(String texto){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(texto);
        alert.show();
    }
}