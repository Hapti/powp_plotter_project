package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.IPlotter;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;

/**
 * Plotter adapter to drawer with several bugs.
 */
public class LinePlotterAdapter implements IPlotter {

	private DrawPanelController drawPanelController;
	private int startX = 0, startY = 0;
	private ILine line;
	private String label;

	public LinePlotterAdapter(DrawPanelController drawPanelController, ILine line, String label) {
		this.drawPanelController = drawPanelController;
		this.line = line;
		this.label = label;
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void drawTo(int x, int y) {
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);

		setPosition(x, y);

		drawPanelController.drawLine(line);
	}

	@Override
	public String toString() {
		return label;
	}
}
