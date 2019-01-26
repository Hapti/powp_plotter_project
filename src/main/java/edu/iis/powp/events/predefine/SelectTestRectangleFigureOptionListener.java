package edu.iis.powp.events.predefine;

import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.ComplexCommandFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestRectangleFigureOptionListener implements ActionListener {
    private DriverManager driverManager;

    public SelectTestRectangleFigureOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ComplexCommandFactory.drawRectangle(-80, -50, 100, 200).execute(driverManager.getCurrentPlotter());
    }
}