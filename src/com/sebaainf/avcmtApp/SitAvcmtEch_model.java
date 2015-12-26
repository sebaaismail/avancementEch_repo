package com.sebaainf.avcmtApp;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.value.ValueModel;

/**
 * Created by ${sebaainf.com} on 28/11/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class SitAvcmtEch_model extends PresentationModel {

    private ValueModel echelon_actuel;
    private ValueModel old_reliq;  // AA MM JJ


    private ValueModel date_effet_old_reliq;
    private ValueModel date_avcmt_ech_cetteAnnee;

    private ValueModel date_nomination;
    private ValueModel date_avcmt_old_ech;
    private ValueModel date_effet_avcmt_ech;

    private SituationAvcmtEch situationAvcmtEch;

    public SitAvcmtEch_model(SituationAvcmtEch situationAvcmtEch) {
        super(situationAvcmtEch);
        this.situationAvcmtEch = situationAvcmtEch;
        initComponents();
    }
    private void initComponents() {
        echelon_actuel = this.getComponentModel(SituationAvcmtEch.PROPERTY_ECHELON_ACTUEL);
        old_reliq = this.getComponentModel(SituationAvcmtEch.PROPERTY_OLD_RELIQ);

        date_nomination = this.getComponentModel(SituationAvcmtEch.PROPERTY_DATE_NOMINATION);
        date_avcmt_old_ech = this.getComponentModel(SituationAvcmtEch.PROPERTY_DATE_AVCMT_OLD_ECH);
        date_effet_old_reliq = this.getComponentModel(
                SituationAvcmtEch.PROPERTY_DATE_EFFET_OLD_RELIQ);
        date_avcmt_ech_cetteAnnee = this.getComponentModel(
                SituationAvcmtEch.PROPERTY_DATE_REF_AVCMT_ECH_CETTE_ANNEE);
    }

    public ValueModel getEchelon_actuel() {
        return echelon_actuel;
    }

    public ValueModel getOld_reliq() {

        return old_reliq;
    }

    public ValueModel getDate_nomination() {
        return date_nomination;
    }

    public ValueModel getDate_avcmt_old_ech() {
        return date_avcmt_old_ech;
    }

    public ValueModel getDate_effet_old_reliq() {

        return date_effet_old_reliq;
    }

    public ValueModel getDate_avcmt_ech_cetteAnnee() {

        return date_avcmt_ech_cetteAnnee;
    }

    public ValueModel getDate_effet_avcmt_ech() {
        return date_effet_avcmt_ech;
    }
}
