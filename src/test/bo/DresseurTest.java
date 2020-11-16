package test.bo;

import main.bo.Dresseur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DresseurTest {

    Dresseur sasha = new Dresseur("Du Bourg-Palette", "Sasha");

    @Test
    void getNom() {
    }

    @Test
    void setNom() {
    }

    @Test
    void getPrenom() {
    }

    @Test
    void setPrenom() {
    }

    @Test
    void dresseur() {
        assertEquals(sasha.getPrenom(), "Sasha");
        assertEquals(sasha.getNom(), "Du Bourg-Palette");
        sasha.setPrenom("Bob");
        assertEquals(sasha.getPrenom(), "Bob");
    }
}