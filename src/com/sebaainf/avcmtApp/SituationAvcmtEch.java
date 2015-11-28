package com.sebaainf.avcmtApp;

import com.jgoodies.common.bean.Bean;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * class that hold a situation of one employ : les entrees
 * Created by user on 14/09/2015.
 */
public class SituationAvcmtEch extends Bean {


    private int echelon_actuel = 0;

    private int[] old_reliq ={0, 0, 0}; // AA MM JJ


    private Date date_effet_old_reliq;
    private Date date_avcmt_ech_actuelAnnee;

    public static final String PROPERTY_ECHELON_ACTUEL = "echelon_actuel";
    public static final String PROPERTY_OLD_RELIQ = "old_reliq";
    public static final String PROPERTY_DATE_EFFET_OLD_RELIQ = "date_effet_old_reliq";
    public static final String PROPERTY_DATE_AVCMT_ECH_ACTUEL_ANNEE = "date_avcmt_ech_actuelAnnee";

    public int getEchelon_actuel() {

        return echelon_actuel;
    }

    public void setEchelon_actuel(int echelon_actuel) {

        this.echelon_actuel = echelon_actuel;
    }

    public int[] getOld_reliq() {

        return old_reliq;
    }

    public void setOld_reliq(int[] old_reliq) {

        this.old_reliq = old_reliq;
    }

    public Date getDate_effet_old_reliq() {

        return date_effet_old_reliq;
    }

    public void setDate_effet_old_reliq(Date date_effet_old_reliq) {

        this.date_effet_old_reliq = date_effet_old_reliq;
    }

    public Date getDate_avcmt_ech_actuelAnnee() {

        return date_avcmt_ech_actuelAnnee;
    }

    public void setDate_avcmt_ech_actuelAnnee(Date date_avcmt_ech_actuelAnnee) {

        this.date_avcmt_ech_actuelAnnee = date_avcmt_ech_actuelAnnee;
    }

    public void avcmtEch(double duree) {


        Calendar today = Calendar.getInstance();

        Calendar cal_r = Calendar.getInstance();
        cal_r.add(Calendar.DAY_OF_YEAR, (int) (365.25*(this.getOld_reliq()[0]))); //years
        cal_r.add(Calendar.DAY_OF_YEAR, (int) (30.43*(this.getOld_reliq()[1]))); //months
        cal_r.add(Calendar.DAY_OF_YEAR, this.getOld_reliq()[2]);                 //days

        long reliq = cal_r.getTimeInMillis() - today.getTimeInMillis();

        Calendar cal_d = Calendar.getInstance();
        cal_d.add(Calendar.DAY_OF_YEAR, (int) (365.25*duree));
        //c.add(Calendar.MONTH, 6);
        long dureeInMillis = cal_d.getTimeInMillis() - today.getTimeInMillis();

        //long duree = TimeUnit.DAYS.toMillis((long) (365*2.5));


        String str = DurationFormatUtils.formatPeriod(this.getDate_effet_old_reliq().getTime()+ dureeInMillis,
                this.getDate_avcmt_ech_actuelAnnee().getTime()+reliq, "yy a MM 'm' dd j");
        System.out.println(str);

    }
}
