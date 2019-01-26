package edu.iis.powp.events.predefine;

import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.ComplexCommandFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestTriangleFigureOptionListener implements ActionListener {
    private DriverManager driverManager;

    public SelectTestTriangleFigureOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ComplexCommandFactory.drawTriangle(-100, 50, -25, -100, 50, 50).execute(driverManager.getCurrentPlotter());
    }
}