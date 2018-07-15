package io.gameoftrades.ui.overlay;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import io.gameoftrades.model.markt.actie.Actie;
import io.gameoftrades.model.markt.actie.BeweegActie;
import io.gameoftrades.model.markt.actie.HandelsPositie;
import io.gameoftrades.model.markt.actie.KoopActie;
import io.gameoftrades.model.markt.actie.NavigeerActie;
import io.gameoftrades.model.markt.actie.StopActie;
import io.gameoftrades.model.markt.actie.VerkoopActie;

public class HandelsActieOverlay implements Overlay {

    private static final Color PAD_KLEUR = new Color(250, 255, 250);
    private static final Color TOUR_KLEUR = new Color(40, 80, 255);
    private static final Color OVERLAY_KLEUR = new Color(240, 255, 240);

    private HandelsPositie startPos;
    private List<Actie> acties;

    public HandelsActieOverlay(HandelsPositie pos, List<Actie> acties) {
        this.startPos = pos;
        this.acties = acties == null ? null : new ArrayList<>(acties);
    }

    public void draw(Graphics2D g, Font font, int tilesize, int tilehalfwidth, int fontSize) {
        HandelsPositie pos = startPos;
        g.setStroke(new BasicStroke(tilesize / 16));
        int lx = pos.getCoordinaat().getX() * tilesize + tilehalfwidth;
        int ly = pos.getCoordinaat().getY() * tilesize + tilehalfwidth;
        for (Actie a : acties) {
            if (a.isMogelijk(pos)) {
                pos = a.voerUit(pos);
                int nx = pos.getCoordinaat().getX() * tilesize + tilehalfwidth;
                int ny = pos.getCoordinaat().getY() * tilesize + tilehalfwidth;
                if (a instanceof BeweegActie) {
                    g.setColor(TOUR_KLEUR);
                    g.drawLine(lx, ly, nx, ny);
                } else if (a instanceof NavigeerActie) {
                    g.setColor(PAD_KLEUR);
                    g.drawLine(lx, ly, nx, ny);
                } else if (a instanceof KoopActie) {
                    g.setColor(OVERLAY_KLEUR);
                    g.fillOval(nx - tilehalfwidth / 2, ny - tilehalfwidth / 2, tilehalfwidth, tilehalfwidth);
                } else if (a instanceof VerkoopActie) {
                    g.setColor(OVERLAY_KLEUR);
                    g.drawOval(nx - tilehalfwidth / 2, ny - tilehalfwidth / 2, tilehalfwidth, tilehalfwidth);
                } else if (a instanceof StopActie) {
                    g.setColor(Color.RED);
                    g.fillOval(nx - tilehalfwidth / 2, ny - tilehalfwidth / 2, tilehalfwidth, tilehalfwidth);
                    g.setColor(Color.WHITE);
                    g.fillRect(nx - (tilehalfwidth / 2 - 1), ny - 1, tilehalfwidth - 2, 3);
                }
                lx = nx;
                ly = ny;
            } else {
                g.setColor(Color.RED);
                g.fillRect(lx - tilehalfwidth / 2, ly - tilehalfwidth / 2, tilehalfwidth, tilehalfwidth);
            }
        }
    }

}
