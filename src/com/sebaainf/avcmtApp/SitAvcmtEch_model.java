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
    private ValueModel date_avcmt_ech_actuelAnnee;

    private SituationAvcmtEch situationAvcmtEch;

    public SitAvcmtEch_model(SituationAvcmtEch situationAvcmtEch) {
        super(situationAvcmtEch);
        this.situationAvcmtEch = situationAvcmtEch;
        initComponents();
    }

    private void initComponents() {

        echelon_actuel = this.getComponentModel(SituationAvcmtEch.PROPERTY_ECHELON_ACTUEL);
        old_reliq = this.getComponentModel(SituationAvcmtEch.PROPERTY_OLD_RELIQ);
        date_effet_old_reliq = this.getComponentModel(
                SituationAvcmtEch.PROPERTY_DATE_EFFET_OLD_RELIQ);
        date_avcmt_ech_actuelAnnee = this.getComponentModel(
                SituationAvcmtEch.PROPERTY_DATE_AVCMT_ECH_ACTUEL_ANNEE);

    }

    public ValueModel getEchelon_actuel() {

        return echelon_actuel;
    }

    public ValueModel getOld_reliq() {

        return old_reliq;
    }

    public ValueModel getDate_effet_old_reliq() {

        return date_effet_old_reliq;
    }

    public ValueModel getDate_avcmt_ech_actuelAnnee() {

        return date_avcmt_ech_actuelAnnee;
    }
}
