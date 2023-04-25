package com.example.bearbikes.modeles;

import java.util.List;

public class Sitios {
    private List<String> nombres;
    private List<Integer> ids;

    public Sitios(List<String> nombres, List<Integer> ids) {
        this.nombres = nombres;
        this.ids = ids;
    }

    public List<String> getNombres() {
        return nombres;
    }

    public List<Integer> getIds() {
        return ids;
    }
}






