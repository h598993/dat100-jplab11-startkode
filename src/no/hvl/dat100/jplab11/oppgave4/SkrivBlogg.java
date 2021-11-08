package no.hvl.dat100.jplab11.oppgave4;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		try {
			PrintWriter skriver = new PrintWriter(new FileWriter(mappe + filnavn));

			skriver.print(samling.toString());
			skriver.close();

			System.out.println("Write operation finished");
			return true;

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Write operation failed");
			return false;
		}
	}
}
