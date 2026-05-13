package pl.as.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BiuroNagrody {
    @NotBlank
    private String rodzaj;

    @NotNull
    private Double wartosc;

    @NotBlank
    private String nazwaOddzialu;

    @NotBlank
    private String osobaOdpowiedzialna;

    @NotBlank
    private String telefonKontaktowy;

    private LocalDateTime dataDostarczenia;

    @NotNull
    @Valid
    private EdycjaKonkursu edycjaKonkursu;

    @Size(min = 1)
    @Valid
    private final List<Finalista> finalisci = new ArrayList<>();

    public BiuroNagrody(
            String rodzaj,
            Double wartosc,
            String nazwaOddzialu,
            String osobaOdpowiedzialna,
            String telefonKontaktowy,
            LocalDateTime dataDostarczenia
    ) {
        setRodzaj(rodzaj);
        setWartosc(wartosc);
        setNazwaOddzialu(nazwaOddzialu);
        setOsobaOdpowiedzialna(osobaOdpowiedzialna);
        setTelefonKontaktowy(telefonKontaktowy);
        setDataDostarczenia(dataDostarczenia);
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = ValidationUtils.requireNotBlank(rodzaj, "rodzaj");
    }

    public Double getWartosc() {
        return wartosc;
    }

    public void setWartosc(Double wartosc) {
        this.wartosc = ValidationUtils.requireNotNull(wartosc, "wartosc");
    }

    public String getNazwaOddzialu() {
        return nazwaOddzialu;
    }

    public void setNazwaOddzialu(String nazwaOddzialu) {
        this.nazwaOddzialu = ValidationUtils.requireNotBlank(nazwaOddzialu, "nazwaOddzialu");
    }

    public String getOsobaOdpowiedzialna() {
        return osobaOdpowiedzialna;
    }

    public void setOsobaOdpowiedzialna(String osobaOdpowiedzialna) {
        this.osobaOdpowiedzialna = ValidationUtils.requireNotBlank(osobaOdpowiedzialna, "osobaOdpowiedzialna");
    }

    public String getTelefonKontaktowy() {
        return telefonKontaktowy;
    }

    public void setTelefonKontaktowy(String telefonKontaktowy) {
        this.telefonKontaktowy = ValidationUtils.requireNotBlank(telefonKontaktowy, "telefonKontaktowy");
    }

    public LocalDateTime getDataDostarczenia() {
        return dataDostarczenia;
    }

    public void setDataDostarczenia(LocalDateTime dataDostarczenia) {
        this.dataDostarczenia = dataDostarczenia;
    }

    public EdycjaKonkursu getEdycjaKonkursu() {
        return edycjaKonkursu;
    }

    public void setEdycjaKonkursu(EdycjaKonkursu edycjaKonkursu) {
        EdycjaKonkursu nowaEdycja = ValidationUtils.requireNotNull(edycjaKonkursu, "edycjaKonkursu");
        if (this.edycjaKonkursu == nowaEdycja) {
            return;
        }
        if (this.edycjaKonkursu != null) {
            throw new IllegalStateException("edycjaKonkursu jest już przypisana");
        }

        this.edycjaKonkursu = nowaEdycja;
        if (nowaEdycja.getBiuroNagrody() != this) {
            nowaEdycja.setBiuroNagrody(this);
        }
    }

    public List<Finalista> getFinalisci() {
        return List.copyOf(finalisci);
    }

    public void dodajFinaliste(Finalista finalista) {
        ValidationUtils.requireNotNull(finalista, "finalista");
        if (!finalisci.contains(finalista)) {
            finalisci.add(finalista);
        }
        if (finalista.getBiuroNagrody() != this) {
            finalista.setBiuroNagrody(this);
        }
    }

    void usunFinaliste(Finalista finalista) {
        if (finalista == null) {
            return;
        }
        finalisci.remove(finalista);
    }
}
