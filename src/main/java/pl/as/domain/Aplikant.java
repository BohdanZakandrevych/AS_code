package pl.as.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Aplikant {
    private static final Set<String> WYKORZYSTANE_NIPY = new HashSet<>();

    @NotBlank
    private String nazwa;

    @NotBlank
    // Ograniczenie {unique} z UML
    private String nip;

    @NotNull
    @Valid
    private Adres adres;

    @NotNull
    @Valid
    private OsobaZarzadzajacaOrganizacja zarzadca;

    @NotNull
    @Size(min = 1)
    @Valid
    private final List<Projekt> projekty = new ArrayList<>();

    public Aplikant(String nazwa, String nip, Adres adres) {
        setNazwa(nazwa);
        setNip(nip);
        setAdres(adres);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = ValidationUtils.requireNotBlank(nazwa, "nazwa");
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        String nowyNip = ValidationUtils.requireNotBlank(nip, "nip");
        synchronized (WYKORZYSTANE_NIPY) {
            if (Objects.equals(this.nip, nowyNip)) {
                return;
            }
            if (WYKORZYSTANE_NIPY.contains(nowyNip)) {
                throw new IllegalArgumentException("nip musi być unikalny");
            }
            if (this.nip != null) {
                WYKORZYSTANE_NIPY.remove(this.nip);
            }
            this.nip = nowyNip;
            WYKORZYSTANE_NIPY.add(nowyNip);
        }
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = ValidationUtils.requireNotNull(adres, "adres");
    }

    public OsobaZarzadzajacaOrganizacja getZarzadca() {
        return zarzadca;
    }

    public void setZarzadca(OsobaZarzadzajacaOrganizacja zarzadca) {
        OsobaZarzadzajacaOrganizacja nowyZarzadca = ValidationUtils.requireNotNull(zarzadca, "zarzadca");
        if (this.zarzadca != null && this.zarzadca != nowyZarzadca) {
            throw new IllegalStateException("zarzadca jest już ustawiony");
        }
        this.zarzadca = nowyZarzadca;
        if (nowyZarzadca.getAplikant() != this) {
            nowyZarzadca.setAplikant(this);
        }
    }

    public List<Projekt> getProjekty() {
        return List.copyOf(projekty);
    }

    public void dodajProjekt(Projekt projekt) {
        ValidationUtils.requireNotNull(projekt, "projekt");
        if (projekt.getAplikant() != this) {
            projekt.setAplikant(this);
        }
        if (!projekty.contains(projekt)) {
            projekty.add(projekt);
        }
    }

    void usunProjekt(Projekt projekt) {
        if (projekt == null) {
            return;
        }
        projekty.remove(projekt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aplikant other)) return false;
        return Objects.equals(nip, other.nip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nip);
    }
}
