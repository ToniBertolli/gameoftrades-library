package io.gameoftrades.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.gameoftrades.model.markt.actie.HandelsPositie;

/**
 * Toont de huidige HandelsPositie.
 */
public class HandelsPositiePanel extends JPanel implements HandelsPositieListener {

    public static class LabelValue extends JPanel {
        private JLabel value;
        public LabelValue(String label) {
            super(new BorderLayout());
            JLabel lbl = new JLabel(label);
            lbl.setMinimumSize(new Dimension(160, 20));
            lbl.setPreferredSize(new Dimension(160, 20));
            this.add(lbl, BorderLayout.WEST);
            value = new JLabel();
            this.add(value, BorderLayout.CENTER);
        }

        public void setValue(String v) {
            value.setText(v);
        }
    }

    private LabelValue coordinaat = new LabelValue("Coordinaat:");
    private LabelValue kapitaal = new LabelValue("Kapitaal:");
    private LabelValue maxActie = new LabelValue("Actie:");
    private LabelValue ruimte = new LabelValue("Ruimte:");
    private LabelValue stad = new LabelValue("Stad:");
    private LabelValue voorraad = new LabelValue("Voorraad:");

    private LabelValue totaalSteden = new LabelValue("Totaal Steden:");
    private LabelValue uniekeGoederen = new LabelValue("Unieke Goederen:");
    private LabelValue totaalRuimte = new LabelValue("Totaal Ruimte:");

    public HandelsPositiePanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("HandelsPositie"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(420, 240));
        add(maxActie);
        add(kapitaal);
        add(stad);
        add(coordinaat);
        add(ruimte);
        add(voorraad);
        add(new JLabel(" "));
        add(totaalSteden);
        add(uniekeGoederen);
        add(totaalRuimte);
    }

    public void setHandelsPositie(HandelsPositie pos) {
        coordinaat.setValue(String.valueOf(pos.getCoordinaat()));
        kapitaal.setValue(pos.getKapitaal() + " (" + pos.getTotaalWinst() + ")");
        maxActie.setValue(pos.getTotaalActie() + "/" + pos.getMaxActie());
        ruimte.setValue(String.valueOf(pos.getRuimte()));
        stad.setValue(pos.getStad() != null ? String.valueOf(pos.getStad()) : "--");
        voorraad.setValue(String.valueOf(pos.getVoorraad()));
        totaalSteden.setValue(String.valueOf(pos.getBezochteSteden().size()));
        uniekeGoederen.setValue(String.valueOf(pos.getUniekeGoederen()));
        totaalRuimte.setValue(String.valueOf(pos.getTotaalGebruikteRuimte()));
    }

}
