package org.example.pou_pruebastest;


public class Modelo {

    private String nombre;
    private int hambre;
    private int felicidad;
    private int energia;
    private int dinero;

    private int hamburguesa;
    private int kebab;
    private int taco;
    private int sushi;
    private int pan;

    public Modelo(String nombre, int hambre, int felicidad, int energia, int dinero){
        this.nombre = nombre;
        this.hambre = hambre;
        this.felicidad = felicidad;
        this.energia = energia;
        this.dinero = dinero;

        this.hamburguesa = 0;
        this.kebab = 0;
        this.taco = 0;
        this.sushi = 0;
        this.pan = 0;
    }


    public String getNombre(){ return nombre; }
    public int getHambre(){ return hambre; }
    public int getFelicidad(){ return felicidad; }
    public int getEnergia(){ return energia; }
    public int getDinero(){ return dinero; }

    public int getHamburguesa(){ return hamburguesa; }
    public int getKebab(){ return kebab; }
    public int getTaco(){ return taco; }
    public int getSushi(){ return sushi; }
    public int getPan(){ return pan; }


    public void setHambre(int hambre){
        this.hambre = Math.max(0, Math.min(100, hambre));
    }

    public void setFelicidad(int felicidad){
        this.felicidad = Math.max(0, Math.min(100, felicidad));
    }

    public void setEnergia(int energia){
        this.energia = Math.max(0, Math.min(100, energia));
    }

    public void setDinero(int dinero){
        this.dinero = Math.max(0, dinero);
    }

    public void setHamburguesa(int v){ hamburguesa = Math.max(0, v); }
    public void setKebab(int v){ kebab = Math.max(0, v); }
    public void setTaco(int v){ taco = Math.max(0, v); }
    public void setSushi(int v){ sushi = Math.max(0, v); }
    public void setPan(int v){ pan = Math.max(0, v); }


    public boolean estaVivo(){
        return hambre > 0;
    }


    public void aumentarHambre(int cantidad){
        setHambre(this.hambre + cantidad);
    }

    public void reducirHambre(int cantidad){
        setHambre(this.hambre - cantidad);
    }

    public void aumentarEnergia(int cantidad){
        setEnergia(this.energia + cantidad);
    }

    public void reducirEnergia(int cantidad){
        setEnergia(this.energia - cantidad);
    }

    public void aumentarFelicidad(int cantidad){
        setFelicidad(this.felicidad + cantidad);
    }

    public void reducirFelicidad(int cantidad){
        setFelicidad(this.felicidad - cantidad);
    }

    public void aumentarDinero(int cantidad){
        setDinero(this.dinero + cantidad);
    }

    public void reducirDinero(int cantidad){
        setDinero(this.dinero - cantidad);
    }


    public boolean tieneComida(String comida){
        switch (comida){
            case "Hamburguesa": return hamburguesa > 0;
            case "Kebab": return kebab > 0;
            case "Taco": return taco > 0;
            case "Sushi": return sushi > 0;
            case "Pan": return pan > 0;
        }
        return false;
    }

    public void consumirComida(String comida){
        switch (comida){
            case "Hamburguesa": hamburguesa--; aumentarHambre(30); break;
            case "Kebab": kebab--; aumentarHambre(25); break;
            case "Taco": taco--; aumentarHambre(20); break;
            case "Sushi": sushi--; aumentarHambre(35); break;
            case "Pan": pan--; aumentarHambre(10); break;
        }
    }

    public void comprarComida(String comida, int precio){

        if(dinero < precio) return;

        reducirDinero(precio);

        switch (comida){
            case "Hamburguesa": hamburguesa++; break;
            case "Kebab": kebab++; break;
            case "Taco": taco++; break;
            case "Sushi": sushi++; break;
            case "Pan": pan++; break;
        }
    }
}