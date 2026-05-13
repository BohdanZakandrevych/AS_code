package pl.as.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class CzlonekJury {
    @NotBlank
    private String imie;

    @NotBlank
    private String nazwisko;

    @NotBlank
    private String tytulNaukowy;

    @NotBlank
    private String funkcja;

    @NotBlank
    @Pattern(regexp = ValidationUtils.EMAIL_REGEX)
    private String email;

    @NotNull
    @Size(min = 1)
    private final List<EdycjaKonkursu> edycje = new ArrayList<>();

    @NotNull
    @Valid
    private final List<RaportNaPierwszeSpotkanie> raportyNaPierwszeSpotkanie = new ArrayList<>();

    public CzlonekJury(String imie, String nazwisko, String tytulNaukowy, String funkcja, String email) {
        setImie(imie);
        setNazwisko(nazwisko);
        setTytulNaukowy(tytulNaukowy);
        setFunkcja(funkcja);
        setEmail(email);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = ValidationUtils.requireNotBlank(imie, "imie");
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = ValidationUtils.requireNotBlank(nazwisko, "nazwisko");
    }

    public String getTytulNaukowy() {
        return tytulNaukowy;
    }

    public void setTytulNaukowy(String tytulNaukowy) {
        this.tytulNaukowy = ValidationUtils.requireNotBlank(tytulNaukowy, "tytulNaukowy");
    }

    public String getFunkcja() {
        return funkcja;
    }

    public void setFunkcja(String funkcja) {
        this.funkcja = ValidationUtils.requireNotBlank(funkcja, "funkcja");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = ValidationUtils.requireValidEmail(email, "email");
    }

    public List<EdycjaKonkursu> getEdycje() {
        return List.copyOf(edycje);
    }

    public void dodajEdycje(EdycjaKonkursu edycja) {
        ValidationUtils.requireNotNull(edycja, "edycja");
        if (!edycje.contains(edycja)) {
            edycje.add(edycja);
        }
        if (!edycja.getPrzewodniczacy().contains(this)) {
            edycja.dodajPrzewodniczacego(this);
        }
    }

    public List<RaportNaPierwszeSpotkanie> getRaportyNaPierwszeSpotkanie() {
        return List.copyOf(raportyNaPierwszeSpotkanie);
    }

    public void dodajRaportNaPierwszeSpotkanie(RaportNaPierwszeSpotkanie raport) {
        ValidationUtils.requireNotNull(raport, "raport");
        if (!raportyNaPierwszeSpotkanie.contains(raport)) {
            raportyNaPierwszeSpotkanie.add(raport);
        }
        if (raport.getCzlonekJury() != this) {
            raport.setCzlonekJury(this);
        }
    }

    void usunRaportNaPierwszeSpotkanie(RaportNaPierwszeSpotkanie raport) {
        if (raport == null) {
            return;
        }
        raportyNaPierwszeSpotkanie.remove(raport);
    }
}
