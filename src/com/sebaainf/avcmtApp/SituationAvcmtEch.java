package com.sebaainf.avcmtApp;

import com.jgoodies.common.bean.Bean;
import com.sebaainf.ismUtils.IsmPrintStream;
import org.joda.time.*;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * class that hold a situation of one employ : les entrees
 * Created by user on 14/09/2015.
 */
public class SituationAvcmtEch extends Bean {

    private int echelon_actuel = 0;
    private String nom_prenom = "";

    private int[] old_reliq ={0, 0, 0}; // AA MM JJ

    private Date date_effet_old_reliq;
    private Date date_ref_avcmt_echCetteAnnee;

    private Date date_nomination;
    private Date date_avcmt_old_ech;
    private Date date_effet_avcmt_ech;

    public static final String PROPERTY_NOM_PRENOM = "nom_prenom";
    public static final String PROPERTY_ECHELON_ACTUEL = "echelon_actuel";
    public static final String PROPERTY_OLD_RELIQ = "old_reliq";
    public static final String PROPERTY_DATE_EFFET_OLD_RELIQ = "date_effet_old_reliq";
    public static final String PROPERTY_DATE_REF_AVCMT_ECH_CETTE_ANNEE = "date_ref_avcmt_echCetteAnnee";
    public static final String PROPERTY_DATE_NOMINATION = "date_nomination";
    public static final String PROPERTY_DATE_AVCMT_OLD_ECH = "date_avcmt_old_ech";
    public static final String PROPERTY_DATE_EFFET_AVCMT_ECH = "date_effet_avcmt_ech";

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String newNom_prenom) {
        String oldNom_prenom = this.nom_prenom;
        this.nom_prenom = newNom_prenom;
        if (!oldNom_prenom.equals(newNom_prenom)) {
            firePropertyChange(SituationAvcmtEch.PROPERTY_NOM_PRENOM,
                    oldNom_prenom, newNom_prenom);
        }
    }

    public int getEchelon_actuel() {

        return echelon_actuel;
    }

    public void setEchelon_actuel(int newEchelon_actuel) {

        int oldEchelon_actuel = this.echelon_actuel;
        this.echelon_actuel = newEchelon_actuel;
        if (oldEchelon_actuel != newEchelon_actuel) {
            firePropertyChange(SituationAvcmtEch.PROPERTY_ECHELON_ACTUEL,
                    oldEchelon_actuel, newEchelon_actuel);
        }
    }

    public int[] getOld_reliq() {
        return old_reliq;
    }

    public void setOld_reliq(int[] newOld_reliq) {

        int[] oldOld_reliq = this.old_reliq;
        this.old_reliq = newOld_reliq;
        if (oldOld_reliq.equals(newOld_reliq)) {
            firePropertyChange(SituationAvcmtEch.PROPERTY_OLD_RELIQ,
                    oldOld_reliq, newOld_reliq);
        }
    }

    public Date getDate_effet_old_reliq() {
        return date_effet_old_reliq;
    }

    public void setDate_effet_old_reliq(Date newDate_effet_old_reliq) {

        Date oldDate_effet_old_reliq = this.date_effet_old_reliq;
        this.date_effet_old_reliq = newDate_effet_old_reliq;
        if (oldDate_effet_old_reliq != newDate_effet_old_reliq) {
            firePropertyChange(SituationAvcmtEch.PROPERTY_DATE_EFFET_OLD_RELIQ,
                    oldDate_effet_old_reliq, newDate_effet_old_reliq);
        }
    }

    public Date getDate_ref_avcmt_echCetteAnnee() {

        return date_ref_avcmt_echCetteAnnee;
    }

    public void setDate_ref_avcmt_echCetteAnnee(Date newDate_avcmt_ech_actuelAnnee) {

        Date oldDate_avcmt_ech_actuelAnnee = this.date_ref_avcmt_echCetteAnnee;
        this.date_ref_avcmt_echCetteAnnee = newDate_avcmt_ech_actuelAnnee;
        if (oldDate_avcmt_ech_actuelAnnee != newDate_avcmt_ech_actuelAnnee) {
            firePropertyChange(SituationAvcmtEch.PROPERTY_DATE_REF_AVCMT_ECH_CETTE_ANNEE,
                    oldDate_avcmt_ech_actuelAnnee, newDate_avcmt_ech_actuelAnnee);
        }
    }

    public Date getDate_nomination() {
        return date_nomination;
    }

    public void setDate_nomination(Date new_date_nomination) {
        Date old_date_nomination = this.date_nomination;
        this.date_nomination = new_date_nomination;
        if (old_date_nomination != new_date_nomination) {
            firePropertyChange(SituationAvcmtEch.PROPERTY_DATE_NOMINATION,
                    old_date_nomination, new_date_nomination);
        }
    }

    public Date getDate_avcmt_old_ech() {
        return date_avcmt_old_ech;
    }

    public void setDate_avcmt_old_ech(Date new_date_avcmt_old_ech) {
        Date old_date_avcmt_old_ech = this.date_avcmt_old_ech;
        this.date_avcmt_old_ech = new_date_avcmt_old_ech;
        if (old_date_avcmt_old_ech != new_date_avcmt_old_ech) {
            firePropertyChange(SituationAvcmtEch.PROPERTY_DATE_AVCMT_OLD_ECH,
                    old_date_avcmt_old_ech, new_date_avcmt_old_ech);
        }
    }

    public Date getDate_effet_avcmt_ech() {
        return date_effet_avcmt_ech;
    }

    public void setDate_effet_avcmt_ech(Date date_effet_avcmt_ech) {
        this.date_effet_avcmt_ech = date_effet_avcmt_ech;
    }

    public void avcmtEch(double duree) {


        Period period_duree,per_old_rel, per_new_rel;

        per_old_rel = Period.years(this.getOld_reliq()[0])
                .plusMonths(this.getOld_reliq()[1])
                .plusDays(this.getOld_reliq()[2]);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        long startMillis, endMillis;

        String textDuree = "المتوسطة", entrees1 ="", entrees2 ="";
        if (duree==2.5) {
            textDuree = "الدنيا";
            period_duree = Period.years(2).plusMonths(6);
        } else if (duree==3.5){
            textDuree = "القصوى";
            period_duree = Period.years(3).plusMonths(6);
        } else { //duree==3.0
            period_duree = Period.years(3);
            }

        per_new_rel = new Interval(new DateTime(this.getDate_effet_old_reliq()).toInstant(),
                new DateTime(this.getDate_ref_avcmt_echCetteAnnee()).toInstant()).toPeriod()


                .plus(per_old_rel).minus(period_duree);

        PeriodFormatter perFormatter = new PeriodFormatterBuilder()
                .printZeroAlways()
                .appendDays()

                .appendSuffix("jour", "jours")
                .appendSeparator(" ")
                .appendMonths()
                .appendSuffix("mois", "mois")
                .appendSeparator(" ")
                .appendYears()
                .appendSuffix("annee", "annees")
                .toFormatter();

//*

        IsmPrintStream.logging("--------------------------------------------------------");
        IsmPrintStream.logging(nom_prenom);
        String str = "عدم توفر شروط الترقية في الدرجة ";

        if (echelon_actuel > 0) {

            entrees1 += "\n echelon actuel : " + echelon_actuel
                    + " \n ancien reliquat : " + old_reliq[0] + " annee "
             + old_reliq[1] + " mois " + old_reliq[2] + " jours ";
            entrees2 = "\n depuis : " + dateFormat.format(date_effet_old_reliq);

        } else {

            entrees1 += "\n date de nomination : " + dateFormat.format(date_nomination);
        }

        //long duree = TimeUnit.DAYS.toMillis((long) (365*2.5));

            if(per_new_rel.getDays()>0 || per_new_rel.getMonths()>0
                    || per_new_rel.getYears()>0) {
                System.out.println("yes ismail");
                per_new_rel.plus(Days.days(1));
                String reliqStr = perFormatter.print(per_new_rel.normalizedStandard
                        (PeriodType.yearMonthDay()));
                System.out.println(reliqStr);
                System.out.println(perFormatter.print(per_old_rel.normalizedStandard
                        (PeriodType.yearMonthDay())));
                System.out.println(perFormatter.print(period_duree.normalizedStandard
                        (PeriodType.yearMonthDay())));

               DateTime dt = new DateTime(date_ref_avcmt_echCetteAnnee).minus(per_new_rel);

            this.setDate_effet_avcmt_ech(dt.toDate());
            str = entrees1;
            IsmPrintStream.logging(entrees1);
            IsmPrintStream.logging(entrees2);
            IsmPrintStream.logging("\nيُرقى الى الدرجة "+ (echelon_actuel+1)
                    + "  بالمدة"      + textDuree + " " );
            IsmPrintStream.logging( "\n ابتداءامن "
                    + dateFormat.format(date_effet_avcmt_ech)
                    + "\n ويحتفظ المعني بأقدمية قدرها :");
            str = reliqStr + " إلى غاية"
                    + dateFormat.format(date_ref_avcmt_echCetteAnnee);

        }

        JOptionPane.showMessageDialog(null,entrees1 + "/n" + entrees2 +
                "\nيُرقى الى الدرجة "+ (echelon_actuel +1)
                + "  بالمدة"      + textDuree + " "
        +  "\n ابتداءامن " + dateFormat.format(date_effet_avcmt_ech)
                + "\n ويحتفظ المعني بأقدمية قدرها :"
        + str);

        IsmPrintStream.logging(str);
        IsmPrintStream.logging("--------------------------------------------------------");
//*/

    }

    public static int[][] chabaka() {

        int[][] tab = new int[18][13];
        tab[1][0]= 200;
        tab[2][0]= 219;
        tab[3][0]= 240;
        tab[4][0]= 263;
        tab[5][0]= 288;
        tab[6][0]= 215;
        tab[7][0]= 348;
        tab[8][0]= 379;
        tab[9][0]= 418;
        tab[10][0]= 453;
        tab[11][0]= 498;
        tab[12][0]= 537;
        tab[13][0]= 578;
        tab[14][0]= 621;
        tab[15][0]= 666;
        tab[16][0]= 713;
        tab[17][0]= 762;

        for (int i=1;i<=17;i++) {
            for (int j=1;j<=12;j++) {
                switch (i) {
                    case 1: tab[i][j] = 10*j;
                    case 2: tab[i][j] = 11*j;
                    case 3: tab[i][j] = 12*j;
                    case 4: tab[i][j] = 13*j;
                    case 5: tab[i][j] = 14*j;
                    case 6: tab[i][j] = 16*j;
                    case 7: tab[i][j] = 17*j;
                    case 8: tab[i][j] = 19*j;
                    case 9: tab[i][j] = 21*j;
                    case 10: tab[i][j] = 23*j;
                    case 11: tab[i][j] = 25*j;
                    case 12: tab[i][j] = 27*j;
                    case 13: tab[i][j] = 29*j;
                    case 14: tab[i][j] = 31*j;
                    case 15: tab[i][j] = 33*j;
                    case 16: tab[i][j] = 36*j;
                    case 17: tab[i][j] = 38*j;


                }
            }

        }

        return tab;

    }
}