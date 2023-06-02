package de.oszimt.database.model.versand;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Kunden {
    private String p_kunden_nr;
    private String status;
    private String zahlung;
    private String vname;
    private String nname;
    private String strasse;
    private String plz;
    private String ort;
    private String letztebestellung;
    private String letztewerbeaktion;

    public Kunden() {
    }

    public Kunden(String p_kunden_nr, String nname) {
        this.p_kunden_nr = p_kunden_nr;
        this.nname = nname;
    }
    public Kunden(String p_kunden_nr, String status, String zahlung, String vname, String nname, String strasse, String plz, String ort) {
        this.p_kunden_nr = p_kunden_nr;
        this.status = status;
        this.zahlung = zahlung;
        this.vname = vname;
        this.nname = nname;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }

    /*public Kunden(String p_kunden_nr, String status, String zahlung, String vname, String nname, String strasse, String plz, String ort, String letztebestellung) {
        this.p_kunden_nr = p_kunden_nr;
        this.status = status;
        this.zahlung = zahlung;
        this.vname = vname;
        this.nname = nname;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.letztebestellung = letztebestellung;
    }

    public Kunden(String p_kunden_nr, String status, String zahlung, String vname, String nname, String strasse, String plz, String ort, String letztewerbeaktion) {
        this.p_kunden_nr = p_kunden_nr;
        this.status = status;
        this.zahlung = zahlung;
        this.vname = vname;
        this.nname = nname;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.letztewerbeaktion = letztewerbeaktion;
    }*/

    public Kunden(String p_kunden_nr, String status, String zahlung, String vname, String nname, String strasse, String plz, String ort, String letztebestellung, String letztewerbeaktion) {
        this.p_kunden_nr = p_kunden_nr;
        this.status = status;
        this.zahlung = zahlung;
        this.vname = vname;
        this.nname = nname;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.letztebestellung = letztebestellung;
        this.letztewerbeaktion = letztewerbeaktion;
    }
}
