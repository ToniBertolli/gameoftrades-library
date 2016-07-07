package io.gameoftrades.debug;

import java.util.List;
import java.util.Map;

import io.gameoftrades.model.kaart.Coordinaat;
import io.gameoftrades.model.kaart.Kaart;
import io.gameoftrades.model.kaart.Pad;
import io.gameoftrades.model.kaart.Stad;
import io.gameoftrades.model.markt.Handelsplan;
import io.gameoftrades.model.markt.actie.HandelsPositie;

/**
 * Implementatie van de Debugger interface die niets doet.
 * Dit is handig als je niet wilt debuggen :-)
 */
public class DummyDebugger implements Debugger {

    @Override
    public void debugCoordinaten(Kaart kaart, List<Coordinaat> c) {
    }

    @Override
    public void debugCoordinaten(Kaart kaart, Map<Coordinaat, ?> map, boolean highlight) {
    }

    @Override
    public void debugPad(Kaart kaart, Coordinaat start, Pad pad) {
    }

    @Override
    public void debugRaster(Kaart kaart, Integer[][] raster) {
    }

    @Override
    public void debugSteden(Kaart kaart, List<Stad> steden) {
    }

    @Override
    public PlanControl speelPlanAf(Handelsplan plan, HandelsPositie initieel) {
        return new PlanControl() {

            @Override
            public void nextStep() {
            }

            @Override
            public boolean hasNextStep() {
                return false;
            }
        };
    }

}
