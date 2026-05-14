package pl.as.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Finalista extends Projekt {
    private static final Set<String> WYKORZYSTANE_KODY_CERTYFIKATOW = new HashSet<>();

    @NotNull
    private Boolean czyLaureat;

    @NotNull
    private Integer miejsceRankingowe;

    @NotBlank
    private String uzasadnienieWerdyktu;

    @NotNull
    private LocalDateTime dataPrzyznaniaTytulu;

    @NotNull
    private Boolean czyOdebralNagrode;

    @NotBlank
    private String kodCertyfikatu;

    @NotNull
    @Valid
    private BiuroNagrody biuroNagrody;

    public Finalista(
            String nazwa,
            String imieKierownika,
            String nazwiskoKierownika,
            Integer czasTrwania,
            Integer liczbaCzlonkow,
            Double budzetProjektu,
            Integer liczbaPodwykonawcow,
            Boolean zgodnoscZCB4_0,
            Boolean dostepnoscDoPublikacji,
            Boolean czyUkonczony,
            String opis,
            Adres adres,
            String imieNazwiskoOsobyPotwierdzajacej,
            Boolean czyZaplacony,
            EdycjaKonkursu edycjaKonkursu,
            Aplikant aplikant,
            OsobaKontaktowa osobaKontaktowa,
            InicjatorProjektu inicjatorProjektu,
            LocalDateTime data,
            LocalDateTime dataZakonczenia,
            Kategoria kategoria,
            Boolean czyLaureat,
            Integer miejsceRankingowe,
            String uzasadnienieWerdyktu,
            LocalDateTime dataPrzyznaniaTytulu,
            Boolean czyOdebralNagrode,
            String kodCertyfikatu
    ) {
        super(
                nazwa,
                imieKierownika,
                nazwiskoKierownika,
                czasTrwania,
                liczbaCzlonkow,
                budzetProjektu,
                liczbaPodwykonawcow,
                zgodnoscZCB4_0,
                dostepnoscDoPublikacji,
                czyUkonczony,
                opis,
                adres,
                imieNazwiskoOsobyPotwierdzajacej,
                czyZaplacony,
                edycjaKonkursu,
                aplikant,
                osobaKontaktowa,
                inicjatorProjektu,
                data,
                dataZakonczenia,
                kategoria
        );

        setCzyLaureat(czyLaureat);
        setMiejsceRankingowe(miejsceRankingowe);
        setUzasadnienieWerdyktu(uzasadnienieWerdyktu);
        setDataPrzyznaniaTytulu(dataPrzyznaniaTytulu);
        setCzyOdebralNagrode(czyOdebralNagrode);
        setKodCertyfikatu(kodCertyfikatu);
    }

    public Boolean getCzyLaureat() {
        return czyLaureat;
    }

    public void setCzyLaureat(Boolean czyLaureat) {
        this.czyLaureat = ValidationUtils.requireNotNull(czyLaureat, "czyLaureat");
    }

    public Integer getMiejsceRankingowe() {
        return miejsceRankingowe;
    }

    public void setMiejsceRankingowe(Integer miejsceRankingowe) {
        this.miejsceRankingowe = ValidationUtils.requireNotNull(miejsceRankingowe, "miejsceRankingowe");
    }

    public String getUzasadnienieWerdyktu() {
        return uzasadnienieWerdyktu;
    }

    public void setUzasadnienieWerdyktu(String uzasadnienieWerdyktu) {
        this.uzasadnienieWerdyktu = ValidationUtils.requireNotBlank(uzasadnienieWerdyktu, "uzasadnienieWerdyktu");
    }

    public LocalDateTime getDataPrzyznaniaTytulu() {
        return dataPrzyznaniaTytulu;
    }

    public void setDataPrzyznaniaTytulu(LocalDateTime dataPrzyznaniaTytulu) {
        this.dataPrzyznaniaTytulu = ValidationUtils.requireNotNull(dataPrzyznaniaTytulu, "dataPrzyznaniaTytulu");
    }

    public Boolean getCzyOdebralNagrode() {
        return czyOdebralNagrode;
    }

    public void setCzyOdebralNagrode(Boolean czyOdebralNagrode) {
        this.czyOdebralNagrode = ValidationUtils.requireNotNull(czyOdebralNagrode, "czyOdebralNagrode");
    }

    public String getKodCertyfikatu() {
        return kodCertyfikatu;
    }

    public void setKodCertyfikatu(String kodCertyfikatu) {
        String nowyKod = ValidationUtils.requireNotBlank(kodCertyfikatu, "kodCertyfikatu");
        synchronized (WYKORZYSTANE_KODY_CERTYFIKATOW) {
            if (Objects.equals(this.kodCertyfikatu, nowyKod)) {
                return;
            }
            if (WYKORZYSTANE_KODY_CERTYFIKATOW.contains(nowyKod)) {
                throw new IllegalArgumentException("kodCertyfikatu musi być unikalny");
            }
            if (this.kodCertyfikatu != null) {
                WYKORZYSTANE_KODY_CERTYFIKATOW.remove(this.kodCertyfikatu);
            }
            this.kodCertyfikatu = nowyKod;
            WYKORZYSTANE_KODY_CERTYFIKATOW.add(nowyKod);
        }
    }

    public BiuroNagrody getBiuroNagrody() {
        return biuroNagrody;
    }

    public void setBiuroNagrody(BiuroNagrody biuroNagrody) {
        if (this.biuroNagrody == biuroNagrody) {
            return;
        }

        if (this.biuroNagrody != null) {
            this.biuroNagrody.usunFinaliste(this);
        }
        this.biuroNagrody = biuroNagrody;

        if (biuroNagrody != null && !biuroNagrody.getFinalisci().contains(this)) {
            biuroNagrody.dodajFinaliste(this);
        }
    }

    @Override
    public void setEdycjaKonkursu(EdycjaKonkursu edycjaKonkursu) {
        EdycjaKonkursu nowaEdycja = ValidationUtils.requireNotNull(edycjaKonkursu, "edycjaKonkursu");
        EdycjaKonkursu staraEdycja = getEdycjaKonkursu();
        if (staraEdycja == nowaEdycja) {
            if (!nowaEdycja.getFinalisci().contains(this)) {
                nowaEdycja.dodajFinaliste(this);
            }
            return;
        }

        super.setEdycjaKonkursu(nowaEdycja);

        if (staraEdycja != null) {
            staraEdycja.usunFinaliste(this);
        }
        if (!nowaEdycja.getFinalisci().contains(this)) {
            nowaEdycja.dodajFinaliste(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Finalista other)) return false;
        return Objects.equals(kodCertyfikatu, other.kodCertyfikatu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kodCertyfikatu);
    }
}
