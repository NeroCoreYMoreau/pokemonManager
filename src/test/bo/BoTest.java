package test.bo;

import main.bo.Attaque;
import main.bo.Dresseur;
import main.bo.Pokemon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoTest {

    Dresseur sasha = new Dresseur("Du Bourg-Palette", "Sasha");
    Pokemon pikachu = new Pokemon(25, "Pikachu", 6.0f, 0.4f , new Attaque("Statik", 25), new Attaque("Paratonnerre", 55), sasha);


        @Test
        void dresseur() {
            assertEquals(sasha.getPrenom(), "Sasha");
            assertEquals(sasha.getNom(), "Du Bourg-Palette");
            sasha.setPrenom("Bob");
            assertEquals(sasha.getPrenom(), "Bob");
        }

        @Test
        void pokemon() {
            assertEquals(pikachu.getNom(), "Pikachu");
            assertEquals(pikachu.getAttaque01().getNom(), "Statik");
            assertEquals(pikachu.getDesign(), "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png");
        }

}
