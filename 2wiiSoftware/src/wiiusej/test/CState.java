package wiiusej.test;



/**
 * Class that reflects what stage of calibration the user is on, used as a state
 * machine such that other functions may act appropriately depending on the
 * calibration state, such as displaying instructions, or turning on/off certain
 * buttons.
 * 
 * @author Eddie
 *
 */
public class CState {
	
	// list of strings for display
	static String doneCalib = "Calibration for this point is complete. Please press the " +
			"\"Capture Next Point\" button to begin calibration for the next point.";
	
	static String beginText = "This textbox will display instructions to guide you in system setup and reports the system's status.\n\n" +
			"Click on the \"Start Calibration\" button to begin the calibration process!\n\n" +
			"Instructions on how to calibrate the system will be displayed here.\n\n";
	
	// list of strings related to wiimote orientation
	
	static String wiimoteLeft = "Wiimotes are currently placed at the top and left hand side of the map.\n\n";
	static String wiimoteRight = "Wiimotes are currently placed at the top and right hand side of the map.\n\n";
	static String wiimoteChange = "This can be changed with the \"Change Wiimote Orientation\" button.\n\n";
	
	// Strings related to system status needing calibration
	static String sysDoneCaliText = "System Status: Calibrated!\n\n" +
			"Do not move the wiimotes until the end of operation.\n\n";

	static String sysDisConnText = "System Status: Needs re-calibration\n\n" +
			"At least one wiimote has been disconnected and calibration is lost.\n\n" +
			"Session has been automatically saved and terminated. Please start a new" +
			"session.\n\n";
	
	static String sysBeginCaliText = "System Status: Needs Calibration\n\n" +
			"It is recommended that if you are left handed, you should switch the orientation " +
			"of the wiimotes to be on the right hand side of the map.\n\n";;
			
	// Strings related to confirmation of re-calibration or clear drawing here
	static String confirmClearText = "System Status: Calibrated!\n\n" +
			"NEED CONFIRMATION TEXT HERE";
	
	static String confirmCaliText = "System Status: Calibrated!\n\n" +
			"NEED CONFIRMATION TEXT HERE";
			// TODO confirmation message somehow"

	/**
	 * possible states for which point we are calibrating and where the wiimotes
	 * are
	 */
	protected enum calibrationState {
		
		// complete, ready to use statae
		DONE(sysDoneCaliText, -1, false, false, false, null),

		// wiimote on right position
		RIGHTBMF(doneCalib, 7, false, false, false, DONE),
		RIGHTBMT("Activate the IR pen over the midpoint on the bottom edge of the map and lightly swivel at that location", 7, true, false, true, RIGHTBMF), 
		RIGHTBRF(doneCalib, 6, false, false, true, RIGHTBMT), 
		RIGHTBRT("Activate the IR pen over the bottom right of the corner of the map and lightly swivel at that location", 6, true, false, true, RIGHTBRF), 
		RIGHTMRF(doneCalib, 5, false, false, true, RIGHTBRT), 
		RIGHTMRT("Activate the IR pen over the midpoint on the right edge of the map and lightly swivel at that location", 5, true, false, true, RIGHTMRF), 
		RIGHTTRF(doneCalib, 4, false, false, true, RIGHTMRT), 
		RIGHTTRT("Activate the IR pen over the top right corner of the map and lightly swivel at that location", 4, true, false, true, RIGHTTRF), 
		RIGHTTMF(doneCalib, 3, false, false, true, RIGHTTRT),
		RIGHTTMT("Activate the IR pen over the midpoint on the top edge of the map and lightly swivel at that location", 3, true, false, true, RIGHTTMF),
		RIGHTTLF(doneCalib, 2, false, false, true, RIGHTTMT), 
		RIGHTTLT("Activate the IR pen over the top left corner of the map and lightly swivel at that location", 2, true, false, true, RIGHTTLF), 
		RIGHTMLF(doneCalib, 1, false, false, true, RIGHTTLT),
		RIGHTMLT("Activate the IR pen over the midpoint of the left edge of the map and lightly swivel at that location", 1, true, false, true, RIGHTMLF), 
		RIGHTBLF(doneCalib, 0, false, false, true, RIGHTMLT),
		RIGHTBLT("Activate the IR pen over the bottom left corner of the map and lightly swivel at that location", 0, true, false, true,  RIGHTBLF),

		// wiimote on left position
		LEFTMRT(doneCalib, 7, true, false, false, DONE), 
		LEFTMRF("Activate the IR pen over the midpoint of the right edge of the map and lightly swivel at that location", 7, false, false, true, LEFTMRT), 
		LEFTTRF(doneCalib, 6, false, false, true,  LEFTMRF), 
		LEFTTRT("Activate the IR pen over the top right corner of the map and lightly swivel at that location", 6, true, false, true,  LEFTTRF), 
		LEFTTMF(doneCalib, 5, false, false, true,  LEFTTRT),
		LEFTTMT("Activate the IR pen over the midpoint of the top edge of the map and lightly swivel at that location", 5, true, false, true,  LEFTTMF), 
		LEFTTLF(doneCalib, 4, false,  false, true, LEFTTMT),
		LEFTTLT("Activate the IR pen over the top left corner of the map and lightly swivel at that location", 4, true,  false, true, LEFTTLF), 
		LEFTMLF(doneCalib, 3, false,  false, true, LEFTTLT), 
		LEFTMLT("Activate the IR pen over the midpoint of the left edge of the map and lightly swivel at that location", 3, true,  false, true, LEFTMLF), 
		LEFTBLF(doneCalib, 2, false,  false, true, LEFTMLT), 
		LEFTBLT("Activate the IR pen over the bottom left corner of the map and lightly swivel at that location", 2, true,  false, true, LEFTBLF), 
		LEFTBMF(doneCalib, 1, false,  false, true, LEFTBLT), 
		LEFTBMT("Activate the IR pen over the midpoint of the bottom edge of the map and lightly swivel at that location", 1, true,  false, true, LEFTBMF), 
		LEFTBRF(doneCalib, 0, false,  false, true, LEFTBMT),
		LEFTBRT("Activate the IR pen over the bottom right corner of the map and lightly swivel at that location", 0, true,  false, true, LEFTBRF),
		
		// setting up wiimote distance
		RIGHTWII2("setup of wiimote 2\n\n"+wiimoteRight, -1, false,  false, false, null),
		RIGHTWII1("setup of wiimote 1\n\n"+wiimoteRight, -1, false, false, false, RIGHTWII2),
		LEFTWII2("setup of wiimote 2\n\n"+wiimoteLeft, -1, false,  false, false, null),
		LEFTWII1("setup of wiimote 1\n\n"+wiimoteLeft, -1, false, false, false, LEFTWII2),
		
		// initial mode
		BEGINLEFT(beginText+wiimoteLeft+wiimoteChange, -1, false, true, false, LEFTWII1),
		BEGINRIGHT(beginText+wiimoteRight+wiimoteChange, -1, false, true, false, RIGHTWII1),
		
		// wiimote disconnected, must recalibrate
		DISCONN(sysDisConnText, -1, false, true, false, null),
		
		// state for asking confirmation before carrying out an action
		RECALICONFIRM(confirmCaliText, -1, false, false, false, null),
		CLEARCONFIRM(null, -1, false, false, false, null);

		String description;
		int calibMatrixPos ;
		boolean pollState;
		boolean lrAllow;
		boolean calibRelated;
		calibrationState nextPosition;
		
		/*
		 * Format of states:
		 * descriptive text, pollstate, next point
		 * 
		 * description: text description to be displayed at that state by the program
		 * calibMatrixPos: position in the calibration matrix; -1 if state is unrelated to calibration
		 * pollState: are we polling right now waiting for IR signal?
		 * lrAlow: do we allow L/R orientation switch of remotes? if yes, then true
		 * calibRelated: do we need to calibrate the 8 corners of the map right now? if yes, then true
		 * Next point: which is the next point to be calibrated; null if it cannot be determined in advance
		 */

		calibrationState(String t, int i, boolean s, boolean b, boolean c, calibrationState next) {
			description = t; 
			calibMatrixPos = i;
			pollState = s;
			lrAllow = b;
			calibRelated = c;
			nextPosition = next; 
		}
		
		String getDescription() {
			return description;
		}
		
		int getCalibMatrixPos() {
			return calibMatrixPos;
		}
		
		boolean getPollState() {
			return pollState;
		}
		
		boolean getCalib() {
			return calibRelated;
		}
		
		boolean getLRAllow() {
			return lrAllow;
		}
		
		calibrationState getNext() {
			return nextPosition;
		}
	}
	
	private static calibrationState calibrationState;
	
	// initial state is always on BEGIN
	@SuppressWarnings("static-access")
	public CState() {
		calibrationState = calibrationState.BEGINLEFT;
	}
	
	// getters and setters
	public calibrationState getCState() {
		return CState.calibrationState;
	}
	
	public static void setCState(calibrationState state) {
		CState.calibrationState = state;
	}
	
	public static int getCalibMatrixPos() {
		return calibrationState.getCalibMatrixPos();
	}
	
	public static String getDescription() {
		return calibrationState.getDescription();
	}
	
	public static boolean getPollState() {
		return calibrationState.getPollState();
	}
	
	public static boolean getCalib() {
		return calibrationState.getCalib();
	}
	
	public static boolean getLRAllow() {
		return calibrationState.getLRAllow();
	}
	
	public calibrationState getNext() {
		return calibrationState.getNext();
	}
	
}

