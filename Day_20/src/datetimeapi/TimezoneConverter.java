package datetimeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimezoneConverter { 
	 public static void main(String[] args) { 
	  Scanner scanner = new Scanner(System.in); 
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
	 
	  System.out.println("Enter the date and time (yyyy-MM-dd HH:mm): "); 
	  String dateTimeInput = scanner.nextLine(); 
	  LocalDateTime dateTime = LocalDateTime.parse(dateTimeInput, formatter); 
	 
	  System.out.println("Enter the source timezone (e.g., Asia/Kolkata): "); 
	  String sourceZone = scanner.nextLine(); 
	  ZoneId sourceZoneId = ZoneId.of(sourceZone); 
	 
	  System.out.println("Enter the target timezone (e.g., America/New_York): "); 
	  String targetZone = scanner.nextLine(); 
	  ZoneId targetZoneId = ZoneId.of(targetZone); 
	 
	  ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(dateTime, 
	sourceZoneId); 
	ZonedDateTime targetZonedDateTime = 
	sourceZonedDateTime.withZoneSameInstant(targetZoneId); 
	System.out.println("Converted time: " + 
	targetZonedDateTime.format(formatter)); 
	scanner.close(); 
	} 
}

