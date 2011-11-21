package com.bsp.app.tekstsat;

import java.util.Calendar;

public class SatKonverter {
	private Calendar kalendar;
	
	public SatKonverter() {
		kalendar = Calendar.getInstance();
	}
	
	private String VratiSat()
	{
		int sat = kalendar.get(Calendar.HOUR);
		
		switch (sat) {
		case 1:
		case 13:
			return "JEDAN";
		case 2:
		case 14:
			return "DVA";
		case 3:
		case 15:
			return "TRI";
		case 4:
		case 16:
			return "ÈETIRI";
		case 5:
		case 17:
			return "PET";
		case 6:
		case 18:
			return "ŠEST";
		case 7:
		case 19:
			return "SEDAM";
		case 8:
		case 20:
			return "OSAM";
		case 9:
		case 21:
			return "DEVET";
		case 10:
		case 22:
			return "DESET";
		case 11:
		case 23:
			return "JEDANAEST";
		case 12:
		case 24:
		case 0:
			return "DVANAEST";
		default:
			return "null";
		}
	}
	
	public String VratiMinutu()
	{
		int minuta = kalendar.get(Calendar.MINUTE);
		String[] niz = 
		{ 
				"JEDNA", "DVIJE", 
				"TRI", "ÈETIRI", 
				"PET", "ŠEST",
				"SEDAM", "OSAM", "DEVET"
		};
		
		switch (minuta) {
		case 1:
			return niz[0];
		case 2:
			return niz[1];
		case 3:
			return niz[2];
		case 4:
			return niz[3];
		case 5:
			return niz[4];
		case 6:
			return niz[5];
		case 7:
			return niz[6];
		case 8:
			return niz[7];			
		case 9:
			return niz[8];
		case 10:
			return "DESET";
		case 11:
			return "JEDANAEST";			
		case 12:
			return "DVANAEST";
		case 13:
			return "TRINAEST";
		case 14:
			return "ÈETRNAEST";
		case 15:
			return "PETNAEST";
		case 16:
			return "ŠESTNAEST";
		case 17:
			return "SEDAMNAEST";
		case 18:
			return "ŠEST";			
		case 19:
			return "DEVETNAEST";
		case 20:
			return "DVADESET";
		case 21:
			return "DVADESET" + niz[0];
		case 22:
			return "DVADESET" + niz[1];
		case 23:
			return "DVADESET" + niz[2];
		case 24:
			return "DVADESET" + niz[3];
		case 25:
			return "DVADESET" + niz[4];
		case 26:
			return "DVADESET" + niz[5];
		case 27:
			return "DVADESET" + niz[6];
		case 28:
			return "DVADESET" + niz[7];
		case 29:
			return "DVADESET" + niz[8];
		case 30:
			return "TRIDESET";
		case 31:
			return "TRIDESET" + niz[0];
		case 32:
			return "TRIDESET" + niz[1];
		case 33:
			return "TRIDESET" + niz[2];
		case 34:
			return "TRIDESET" + niz[3];
		case 35:
			return "TRIDESET" + niz[4];
		case 36:
			return "TRIDESET" + niz[5];
		case 37:
			return "TRIDESET" + niz[6];
		case 38:
			return "TRIDESET" + niz[7];
		case 39:
			return "TRIDESET" + niz[8];
		case 40:
			return "ÈETRDESET";
		case 41:
			return "ÈETRDESET" + niz[0];		
		case 42:
			return "ÈETRDESET" + niz[1];
		case 43:
			return "ÈETRDESET" + niz[2];
		case 44:
			return "ÈETRDESET" + niz[3];
		case 45:
			return "ÈETRDESET" + niz[4];
		case 46:
			return "ÈETRDESET" + niz[5];
		case 47:
			return "ÈETRDESET" + niz[6];
		case 48:
			return "ÈETRDESET" + niz[7];
		case 49:
			return "ÈETRDESET" + niz[8];			
		case 50:
			return "PEDESET";
		case 51:
			return "PEDESET" + niz[0];		
		case 52:
			return "PEDESET" + niz[1];
		case 53:
			return "PEDESET" + niz[2];
		case 54:
			return "PEDESET" + niz[3];
		case 55:
			return "PEDESET" + niz[4];
		case 56:
			return "PEDESET" + niz[5];
		case 57:
			return "PEDESET" + niz[6];
		case 58:
			return "PEDESET" + niz[7];
		case 59:
			return "PEDESET" + niz[8];				
			
		default:
			return "";
		}		
		
	}
	
	public String VratiDane()
	{
		int danUSedmici = kalendar.get(Calendar.DAY_OF_WEEK);
		
		String sDani = "";
		
		switch (danUSedmici) {
		case 1:
			sDani = "NEDELJA";
			break;
		case 2:
			sDani = "PONEDELJAK";
			break;
		case 3:
			sDani = "UTORAK";
			break;
		case 4:
			sDani = "SRIJEDA";
			break;
		case 5:
			sDani = "ÈETVRTAK";
			break;
		case 6:
			sDani = "PETAK";
			break;
		default:
			break;
		}
		
		return sDani;
	}
	
	public String VratiSate()
	{
		String sSati = "";
		
		if (VratiSat() == "") {
			sSati = VratiSat();
		}else{
			sSati = VratiSat() + " i \n" + VratiMinutu();	
		}			
				
		return sSati;
	}
	
	public String VratiMjesece()
	{
		int mjesec = kalendar.get(Calendar.MONTH);
		
		String sMjesec = "";
		
		switch (mjesec) {
		case 0:
			sMjesec = "JANUAR";
			break;
		case 1:
			sMjesec = "FEBRUAR";
			break;
		case 2:
			sMjesec = "MART";
			break;			
		case 3:
			sMjesec = "APRIL";
			break;			
		case 4:
			sMjesec = "MAJ";
			break;
		case 5:
			sMjesec = "JUNI";
			break;
		case 6:
			sMjesec = "JULI";
			break;			
		case 7:
			sMjesec = "AVGUST";
			break;
		case 8:
			sMjesec = "SEPTEMBAR";
			break;
		case 9:
			sMjesec = "OKTOBAR";
			break;
		case 10:
			sMjesec = "NOVEMBAR";
			break;			
		case 11:
			sMjesec = "DECEMBAR";
			break;
		default:
			break;
		}
		
		return sMjesec;
	}
	
	public String VratiGodinu()
	{
		int godina = kalendar.get(Calendar.YEAR);
		return String.valueOf(godina);
	}
	
	public String VratiDanUGod()
	{
		int dug = kalendar.get(Calendar.DAY_OF_YEAR);
		return String.valueOf(dug);
	}
	
	public String VratiSedmicuUGod()
	{
		int sug = kalendar.get(Calendar.WEEK_OF_YEAR);
		return String.valueOf(sug);
	}
	
}
