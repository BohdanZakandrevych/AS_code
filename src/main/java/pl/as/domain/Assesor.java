package pl.as.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class Assesor {
    @NotBlank
    private String imie;

    @NotBlank
    private String nazwisko;

    @NotNull
    @Size(min = 2)
    @Valid
    private final List<OcenaIndywidualna> ocenyIndywidualne = new ArrayList<>();

    @NotNull
    @Valid
    private final List<Projekt> projektyWiodace = new ArrayList<>();

    @NotNull
    @Valid
    private final List<RaportNaDrugieSpotkanie> raportyNaDrugieSpotkanie = new ArrayList<>();

    public Assesor(String imie, String nazwisko) {
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

    public List<OcenaIndywidualna> getOcenyIndywidualne() {
        return List.copyOf(ocenyIndywidualne);
    }

    public void dodajOceneIndywidualna(OcenaIndywidualna ocena) {
        ValidationUtils.requireNotNull(ocena, "ocena");
        if (!ocenyIndywidualne.contains(ocena)) {
            ocenyIndywidualne.add(ocena);
        }
    }

    void usunOceneIndywidualna(OcenaIndywidualna ocena) {
        if (ocena == null) {
            return;
        }
        ocenyIndywidualne.remove(ocena);
    }

    public List<Projekt> getProjektyWiodace() {
        return List.copyOf(projektyWiodace);
    }

    public void dodajProjektWiodacy(Projekt projekt) {
        ValidationUtils.requireNotNull(projekt, "projekt");
        if (!projektyWiodace.contains(projekt)) {
            projektyWiodace.add(projekt);
        }
        if (projekt.getAssesorWiodacy() != this) {
            projekt.setAssesorWiodacy(this);
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
        if (raport.getAssesor() != this) {
            raport.setAssesor(this);
        }
    }

    void usunRaportNaDrugieSpotkanie(RaportNaDrugieSpotkanie raport) {
        if (raport == null) {
            return;
        }
        raportyNaDrugieSpotkanie.remove(raport);
    }
}
