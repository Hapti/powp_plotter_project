package edu.iis.powp.gui;

import edu.iis.client.plottermagic.ClientPlotter;
import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.adapter.LinePlotterAdapter;
import edu.iis.powp.adapter.PlotterDrawerAdapter;
import edu.iis.powp.app.Application;
import edu.iis.powp.events.predefine.SelectTestFigure2OptionListener;
import edu.iis.powp.events.predefine.SelectTestFigureOptionListener;
import edu.iis.powp.features.DrawerFeature;
import edu.kis.powp.drawer.shape.LineFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPlotSoftPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String BASIC_LINE_DRIVER_LABEL = "BASIC LINE PLOTTER SIMULATION";
	private static final String DOTTED_LINE_DRIVER_LABEL = "DOTTED LINE PLOTTER SIMULATION";
	private static final String SPECIAL_LINE_DRIVER_LABEL = "SPECIAL LINE PLOTTER SIMULATION";

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureOptionListener selectTestFigureOptionListener = new SelectTestFigureOptionListener(
				application.getDriverManager());
		SelectTestFigure2OptionListener selectTestFigureOptionListener2 = new SelectTestFigure2OptionListener(
				application.getDriverManager());

		application.addTest("Figure Joe 1", selectTestFigureOptionListener);

		application.addTest("Figure Joe 2", selectTestFigureOptionListener2);
	}

	/**
	 * Setup driver manager, and set default IPlotter for application.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupDrivers(Application application) {
		IPlotter clientPlotter = new ClientPlotter();
		application.addDriver("Client Plotter", clientPlotter);
		application.getDriverManager().setCurrentPlotter(clientPlotter);

		IPlotter plotter = new PlotterDrawerAdapter(DrawerFeature.getDrawerController());
		application.addDriver("Plotter simulator", plotter);

		IPlotter basicLinePlotter = new LinePlotterAdapter(DrawerFeature.getDrawerController(),
				LineFactory.getBasicLine(), BASIC_LINE_DRIVER_LABEL);
		application.addDriver("Basic line plotter simulator", basicLinePlotter);

		IPlotter dottedLinePlotter = new LinePlotterAdapter(DrawerFeature.getDrawerController(),
				LineFactory.getDottedLine(), DOTTED_LINE_DRIVER_LABEL);
		application.addDriver("Dotted line plotter simulator", dottedLinePlotter);

		IPlotter specialLinePlotter = new LinePlotterAdapter(DrawerFeature.getDrawerController(),
				LineFactory.getSpecialLine(), SPECIAL_LINE_DRIVER_LABEL);
		application.addDriver("Special line plotter simulator", specialLinePlotter);

		application.updateDriverInfo();
	}

//	/**
//	 * Auxiliary routines to enable using Buggy Simulator.
//	 *
//	 * @param application
//	 *            Application context.
//	 */
// adds new, unnecessary window and menu items.
//	private static void setupDefaultDrawerVisibilityManagement(Application application) {
//		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
//		application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
//				new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
//		defaultDrawerWindow.setVisible(true);
//	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupLogger(Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// using Java 8 lambda instead of old-fashioned "new Runnable"
		EventQueue.invokeLater(() -> {
            Application app = new Application();
            DrawerFeature.setupDrawerPlugin(app);

            //adds new window
            //setupDefaultDrawerVisibilityManagement(app);

            setupDrivers(app);
            setupPresetTests(app);
            setupLogger(app);

            app.setVisibility(true);
        });
	}

}
