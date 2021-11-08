package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		int tabellLengde = 0;
		File fil = new File(mappe + filnavn);
		try {
			
			Scanner scanner = new Scanner(fil);

			if (scanner.hasNextLine()) {
				tabellLengde = Integer.parseInt(scanner.nextLine());
			}

			Blogg blogg = new Blogg(tabellLengde);

			while (scanner.hasNextLine()) {
				String check = scanner.nextLine();
				if (check.equals(TEKST)) {
					int id = Integer.parseInt(scanner.nextLine());
					String bruker = scanner.nextLine();
					String dato = scanner.nextLine();
					int likes = Integer.parseInt(scanner.nextLine());
					String tekst = scanner.nextLine();

					Tekst text = new Tekst(id, bruker, dato, likes, tekst);
					blogg.leggTil(text);

				}
				if (check.equals(BILDE)) {
					int id = Integer.parseInt(scanner.nextLine());
					String bruker = scanner.nextLine();
					String dato = scanner.nextLine();
					int likes = Integer.parseInt(scanner.nextLine());
					String tekst = scanner.nextLine();
					String URL = scanner.nextLine();

					Bilde bilde = new Bilde(id, bruker, dato, likes, tekst, URL);
					blogg.leggTil(bilde);
				}

			}
			scanner.close();
			return blogg;

		} catch (FileNotFoundException e) {
			System.out.println("Kunne ikke finne angitt fil");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Kunne ikke finne angitt fil");
		}catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Det var et problem ved lesing av fil");
		}

		return null;
	}
}
