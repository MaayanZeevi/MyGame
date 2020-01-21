package gameClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import gameUtils.Fruit;
import gameUtils.robot;

public class KML_Logger {

	/*
     * Open the file from a given string.
     */
	public static void openFile(String file_Name) {
		try {
			PrintWriter printWriter = new PrintWriter(new File(file_Name));

			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			sb.append("<kml xmlns=\"http://earth.google.com/kml/2.2\">\n");
			sb.append("<Document>\n");
			sb.append("<name>Points with TimeStamps</name>");//TODO



			sb.append("<Style id=\"robot\">\n");
			sb.append("<IconStyle>\n");
			sb.append("<Icon>\n");
			sb.append("<href>http://maps.google.com/mapfiles/kml/shapes/man.png</href>\n");
			sb.append("</Icon>\n");
			sb.append("<hotSpot x=\"32\" y=\"1\" xunits=\"pixels\" yunits=\"pixels\"/>\n");
			sb.append("</IconStyle>\n");
			sb.append("</Style>");


			sb.append("<Style id=\"fruit\">\n");
			sb.append("<IconStyle>\n");
			sb.append("<Icon>\n");
			sb.append("<href>http://maps.google.com/mapfiles/kml/shapes/dollar.png</href>\n");
			sb.append("</Icon>\n");
			sb.append("<hotSpot x=\"32\" y=\"1\" xunits=\"pixels\" yunits=\"pixels\"/>\n");
			sb.append("</IconStyle>\n");
			sb.append("</Style>");
			//robot


			printWriter.write(sb.toString());
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	/*
     * Add fruit  to the kml file
     */
	public static void addFruit(String Name, String Fruit) {


		Fruit temp = new Fruit(Fruit);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<Placemark>\n");
		stringBuilder.append("<TimeStamp>\n");
		stringBuilder.append("<when>" + java.time.LocalDateTime.now() + "</when>\n");
		stringBuilder.append("</TimeStamp>\n");
		stringBuilder.append("<styleUrl>#fruit</styleUrl>\n");
		stringBuilder.append("<Point>\n");
		stringBuilder.append("<coordinates>" + temp.location.toFile() + "</coordinates>\n");
		stringBuilder.append("</Point>\n");
		stringBuilder.append("</Placemark>\n");
		try {
			FileWriter fileWriter = new FileWriter(Name, true);

			fileWriter.append(stringBuilder.toString());
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
     * Add a robot to the kml file.
     */
	public static void addRobot(String file_Name, String robot) {
		robot temp = new robot(robot);
		StringBuilder sb = new StringBuilder();
		sb.append("<Placemark>\n");
		sb.append("<TimeStamp>\n");
		sb.append("<when>" + java.time.LocalDateTime.now() + "</when>\n");
		sb.append("</TimeStamp>\n");
		sb.append("<styleUrl>#robot</styleUrl>\n");
		sb.append("<Point>\n");
		sb.append("<coordinates>" + temp.location.toFile() + "</coordinates>\n");
		sb.append("</Point>\n");
		sb.append("</Placemark>\n");
		try {
			FileWriter fw = new FileWriter(file_Name, true);
			fw.append(sb.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
     * Closes the kml file with  file name.
     */
	public static void closeFile(String file_Name) {
		String end = "</Document>\n</kml>";
		try {
			FileWriter filWriter = new FileWriter(file_Name, true);
			filWriter.append(end);
			filWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}