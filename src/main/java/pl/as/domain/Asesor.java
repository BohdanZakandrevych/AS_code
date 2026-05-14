package pl.as.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class Asesor {
    @NotBlank
    private String imie;

    @NotBlank
    private String nazwisko;

    @Valid
    private final List<Projekt> projektyWiodace = new ArrayList<>();

    @Size(min = 1)
    @Valid
    private final List<RaportNaDrugieSpotkanie> raportyNaDrugieSpotkanie = new ArrayList<>();

    public Asesor(String imie, String nazwisko) {
        setImie(imie);
        setNazwisko(nazwisko);
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

    public List<Projekt> getProjektyWiodace() {
        return List.copyOf(projektyWiodace);
    }

    public void dodajProjektWiodacy(Projekt projekt) {
        ValidationUtils.requireNotNull(projekt, "projekt");
        if (projekt.getAsesorWiodacy() != this) {
            projekt.setAsesorWiodacy(this);
        }
        if (!projektyWiodace.contains(projekt)) {
            projektyWiodace.add(projekt);
        }
    }

    void usunProjektWiodacy(Projekt projekt) {
        if (projekt == null) {
            return;
        }
        projektyWiodace.remove(projekt);
    }

    public List<RaportNaDrugieSpotkanie> getRaportyNaDrugieSpotkanie() {
        return List.copyOf(raportyNaDrugieSpotkanie);
    }

    public void dodajRaportNaDrugieSpotkanie(RaportNaDrugieSpotkanie raport) {
        ValidationUtils.requireNotNull(raport, "raport");
        if (!raportyNaDrugieSpotkanie.contains(raport)) {
            raportyNaDrugieSpotkanie.add(raport);
        }
        if (raport.getAsesor() != this) {
            raport.setAsesor(this);
        }
    }

    void usunRaportNaDrugieSpotkanie(RaportNaDrugieSpotkanie raport) {
        if (raport == null) {
            return;
        }
        raportyNaDrugieSpotkanie.remove(raport);
    }
}
