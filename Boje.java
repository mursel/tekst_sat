package com.bsp.app.tekstsat;

import android.graphics.Color;

public class Boje {
		
	public static int VratiBoju(int pos)
	{
		switch (pos) {
		case 1:
			// magenta
			return Color.MAGENTA;
		case 2:
			// purple (ljubicasta)
			return Color.parseColor("#800080");
		case 3:
			// cijan
			return Color.CYAN;
		case 4:
			// zelena
			return Color.GREEN;
		case 5:
			// smedja
			return Color.parseColor("#964B00");	
		case 6:
			// ruzicasta
			return Color.parseColor("#FFC0CB");
		case 7:
			// orange
			return Color.parseColor("#FF7F00");
		case 8:
			// zuta
			return Color.YELLOW;
		case 9:
			// plava
			return Color.BLUE;
		case 10:
			// crvena
			return Color.RED;				
		default:
			break;
		}
		return Color.WHITE;
	}
}
