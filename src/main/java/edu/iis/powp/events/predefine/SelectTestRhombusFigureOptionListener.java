package edu.iis.powp.events.predefine;

import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.ComplexCommandFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestRhombusFigureOptionListener implements ActionListener {
    private DriverManager driverManager;

    public SelectTestRhombusFigureOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ComplexCommandFactory.drawRhombus(-200, -20, 400, 200).execute(driverManager.getCurrentPlotter());
    }
}