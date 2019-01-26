package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.AbstractPlotter;
import edu.iis.client.plottermagic.IPlotter;

public class PlotterAdapterFromAbstract extends AbstractPlotter {
    private IPlotter plotter;

    public PlotterAdapterFromAbstract(IPlotter iPlotter) {
        super(0, 0);
        this.plotter = iPlotter;
    }

    @Override
    public void drawTo(int x, int y)
    {
        this.plotter.drawTo(x, y);
        super.setPosition(x, y);
    }

    @Override
    public String toString()
    {
        return "PlotterAdapterFromAbstract";
    }
}
