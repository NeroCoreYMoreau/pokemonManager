package test.bo;

import main.bo.Attaque;
import main.bo.Dresseur;
import main.bo.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    Dresseur sasha = new Dresseur("Du Bourg-Palette", "Sasha");
    Pokemon pikachu = new Pokemon(25, "Pikachu", 6.0f, 0.4f , new Attaque("Statik", 25), new Attaque("Paratonnerre", 55), sasha);

    @Test
    void pokemon() {
        assertEquals(pikachu.getNom(), "Pikachu");
        assertEquals(pikachu.getAttaque01().getNom(), "Statik");
        assertEquals(pikachu.getDesign(), "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png");
    }
    //test accesseur
    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getNom() {
    }

    @Test
    void setNom() {
    }

    @Test
    void getPoids() {
    }

    @Test
    void setPoids() {
    }

    @Test
    void getTaille() {
    }

    @Test
    void setTaille() {
    }

    @Test
    void getDesign() {
    }

    @Test
    void setDesign() {
    }

    @Test
    void getAttaque01() {
    }

    @Test
    void setAttaque01() {
    }

    @Test
    void getAttaque02() {
    }

    @Test
    void setAttaque02() {
    }

    @Test
    void getDresseur() {
    }

    @Test
    void setDresseur() {
    }

    @Test
    void testToString() {
    }
}