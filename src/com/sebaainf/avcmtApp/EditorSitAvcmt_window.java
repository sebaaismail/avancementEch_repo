package com.sebaainf.avcmtApp;

import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;
import com.jgoodies.forms.layout.LayoutMap;
import com.jgoodies.validation.ValidationResultModel;
import com.jgoodies.validation.util.DefaultValidationResultModel;
import com.jgoodies.validation.view.ValidationResultViewFactory;
import com.sebaainf.ismUtils.IsmAbstractJFrame;
import com.sebaainf.ismUtils.IsmComponentFactory;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * Created by ${sebaainf.com} on 28/11/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class EditorSitAvcmt_window extends IsmAbstractJFrame {


    private ValidationResultModel validationResultModel = new DefaultValidationResultModel();
    private JComponent messageLabel = ValidationResultViewFactory.createReportList(validationResultModel);

    private SitAvcmtEch_model sitModel;
    private JTextField nom_prenom;
    private JComboBox echelon_actuel;
    public JDatePickerImpl date_nomination;


    //todo biding array
    public JTextField reliq_annees = new JTextField("00");
    public JTextField reliq_mois = new JTextField("00");
    public JTextField reliq_jours = new JTextField("00");
    public JLabel dureeLabel = new JLabel("03 سنوات       ");
    public JLabel reliqLabel = new JLabel("باقي الخبرة المهنية من آخر ترقية :");
    public JLabel dateNominLabel = new JLabel("تاريخ التعيين :");

    public JDatePickerImpl date_avcmt_old_ech;
    public JDatePickerImpl date_ref_avcmt_echCetteAnnee;
    public JDatePickerImpl date_effet_old_reliq;

    private JComboBox dureeComboBox;
    private JButton calculerButton;
    private Double nDuree = 3.0;

    /**
     *
     * @param sitModel
     */
    public EditorSitAvcmt_window(SitAvcmtEch_model sitModel) {

        this.sitModel = sitModel;
        initComponents();
        configContent();

    }
    @Override
    protected JComponent buildContent() {

        nom_prenom.setPreferredSize(date_nomination.getPreferredSize());
        reliq_annees.setColumns(2);
        reliq_mois.setColumns(2);
        reliq_jours.setColumns(2);


        //setting border
        for(JComponent comp:getListComponents()) {
            if (!comp.getClass().getSimpleName().equals("JDatePickerImpl"))
                comp.setBorder(BorderFactory.createEtchedBorder());
        }
        LayoutMap.getRoot().columnPut("label_ar", "left:pref");
        int nbCol =15;

        JPanel pan = FormBuilder.create()
                //.debug(true)
                .columns("$label_ar, $lcgap, pref, $lcgap , $label_ar, $lcgap, pref, $lcgap," +
                        "$label_ar, $lcgap, pref, $lcgap, pref, $lcgap, pref, $lcgap, pref")
                .rows("pref, $lgap, pref, $lgap, pref, $lgap, pref, $lgap," +
                        " pref ,$lgap , p, $lgap, p, $lgap, p, $lgap, p, $lgap, p")//for mention Zone
                //.columnGroups(new int[][]{{1, 5}})
                .padding(Paddings.DLU9)

                .add("الإسم واللقب : ").xy(nbCol+2, 1)
                .add(nom_prenom).xy(nbCol, 1)
                .add("الدرجة الحالية :").xy(nbCol+2, 3)
                .add(echelon_actuel).xy(nbCol, 3)

                .add(dateNominLabel).xy(nbCol+2, 5)
                .add(date_nomination).xy(nbCol, 5)
                .add("مرجع الترقية في الدرجة لهته السنة :").xy(nbCol+2, 7)
                .add(date_ref_avcmt_echCetteAnnee).xy(nbCol, 7)


                .add(reliqLabel).xy(nbCol+2, 9)
                //.add(reliq_annees).xy(5, 5)

                .add(reliq_annees).xy(nbCol-2, 11)
                .add("سنة").xy(nbCol-4, 11)

                .add(reliq_mois).xy(nbCol-6, 11)
                .add("شهر").xy(nbCol-8, 11)

                .add(reliq_jours).xy(nbCol-10, 11)
                .add("يوم").xy(nbCol-12, 11)


                .add("تاريخ السريان :").xy(nbCol+2, 13)
                .add(date_effet_old_reliq).xy(nbCol, 13)

                .add("المدة :").xy(nbCol+2, 15)
                .add(dureeComboBox).xy(nbCol, 15)
                .add(dureeLabel).xy(nbCol-2, 15)

                .add(calculerButton).xy(nbCol, 17)
                .build();
        return new JScrollPane(pan);



    }

    @Override
    protected void initComponents() {

        try {
            ((SituationAvcmtEch)this.sitModel.getBean()).setDate_ref_avcmt_echCetteAnnee(
                    new SimpleDateFormat("dd/MM/yyyy")
                            .parse("31/12/2015"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.calculerButton = new JButton();
        calculerButton.setText("حساب الترقية في الدرجة");
        //Vector<Integer> vec = new Vector<>();
        //ArrayList col = new ArrayList();
         //{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        //vec.addAll(col);

        reliq_annees.setEnabled(false);
        reliq_mois.setEnabled(false);
        reliq_jours.setEnabled(false);

        echelon_actuel = new JComboBox();
        echelon_actuel.addItem(0);
        echelon_actuel.addItem(1);
        echelon_actuel.addItem(2);
        echelon_actuel.addItem(3);
        echelon_actuel.addItem(4);
        echelon_actuel.addItem(5);
        echelon_actuel.addItem(6);
        echelon_actuel.addItem(7);
        echelon_actuel.addItem(8);
        echelon_actuel.addItem(9);
        echelon_actuel.addItem(10);
        echelon_actuel.addItem(11);
        echelon_actuel.addItem(12);

        dureeComboBox = new JComboBox();
        dureeComboBox.addItem("الدنيا");
        dureeComboBox.addItem("المتوسطة");
        dureeComboBox.addItem("القصوى");
        dureeComboBox.setSelectedItem("المتوسطة");

        date_nomination = IsmComponentFactory.createDatePickerImpl(
                sitModel, SituationAvcmtEch.PROPERTY_DATE_NOMINATION);

        date_avcmt_old_ech = IsmComponentFactory.createDatePickerImpl(sitModel,
                SituationAvcmtEch.PROPERTY_DATE_AVCMT_OLD_ECH);

        date_effet_old_reliq = IsmComponentFactory.createDatePickerImpl(
        sitModel, SituationAvcmtEch.PROPERTY_DATE_EFFET_OLD_RELIQ);

        date_ref_avcmt_echCetteAnnee = IsmComponentFactory.createDatePickerImpl(
        sitModel, SituationAvcmtEch.PROPERTY_DATE_REF_AVCMT_ECH_CETTE_ANNEE);




        nom_prenom = IsmComponentFactory.createArabTextField(
                sitModel.getModel(SituationAvcmtEch.PROPERTY_NOM_PRENOM));

        dureeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (dureeComboBox.getSelectedIndex()==0) {
                    dureeLabel.setText("سنتان ونصف      ");
                    nDuree = 2.5;
;
                } else if (dureeComboBox.getSelectedIndex()==1) {
                    dureeLabel.setText("03 سنوات         ");
                    nDuree = 3.0;

                } else {
                    dureeLabel.setText("03 سنوات ونصف");
                    nDuree = 3.5;
                }


            }
        });

        echelon_actuel.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (echelon_actuel.getSelectedIndex() == 0) {
                    reliq_annees.setEnabled(false);
                    reliq_mois.setEnabled(false);
                    reliq_jours.setEnabled(false);
                    date_nomination.getJFormattedTextField().setEnabled(true);
                    //Button of datePicker
                    date_nomination.getComponent(1).setEnabled(true);
                    dateNominLabel.setEnabled(true);
                    reliqLabel.setEnabled(false);
                } else {
                    reliq_annees.setEnabled(true);
                    reliq_mois.setEnabled(true);
                    reliq_jours.setEnabled(true);
                    date_nomination.getJFormattedTextField().setEnabled(false);
                    date_nomination.getComponent(1).setEnabled(false);
                    dateNominLabel.setEnabled(false);
                    reliqLabel.setEnabled(true);

                }
            }
        });

        calculerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                SituationAvcmtEch sit = (SituationAvcmtEch) sitModel.getBean();

                sit.setEchelon_actuel(echelon_actuel.getSelectedIndex());

                if (echelon_actuel.getSelectedIndex() > 0) {
                    int[] oldRel = new int[3];
                    oldRel[0]= Integer.valueOf(reliq_annees.getText());
                    oldRel[1]= Integer.valueOf(reliq_mois.getText());
                    oldRel[2]= Integer.valueOf(reliq_jours.getText());
                    sit.setOld_reliq(oldRel);

                }

                sit.avcmtEch(nDuree);

            }
        });

    }

    @Override
    public ArrayList<JComponent> getListComponents() {


        ArrayList<JComponent> list = new ArrayList<JComponent>();
        list.add(nom_prenom);
        list.add(echelon_actuel);
        list.add(date_avcmt_old_ech);
        list.add(date_effet_old_reliq);
        list.add(date_nomination);
        list.add(date_ref_avcmt_echCetteAnnee);
        list.add(reliq_annees);
        list.add(reliq_mois);
        list.add(reliq_jours);

        list.add(dureeComboBox);
        list.add(dureeLabel);

        list.add(calculerButton);

        return list;
    }
}
