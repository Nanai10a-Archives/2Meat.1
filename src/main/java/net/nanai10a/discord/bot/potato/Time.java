package net.nanai10a.discord.bot.potato;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class Time {
	
	private static final DateTimeFormatter formatShort = DateTimeFormatter.ofPattern("HH:mm:ss");
	private static final DateTimeFormatter formatDotw = DateTimeFormatter.ofPattern("EEEE");
	private static final DateTimeFormatter formatZone = DateTimeFormatter.ofPattern("zzzz");
	private static final DateTimeFormatter formatLong = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnnnnnnnn");
	
	static String getTime() {
		ZonedDateTime time = ZonedDateTime.now();
		String fmtime = time.format(formatShort);
		return fmtime;
	}
	static String getDotwTime() {
		ZonedDateTime time = ZonedDateTime.now();
		String fmtime = time.format(formatShort);
		String fmdotw = time.format(formatDotw);
		String DotwTime = fmdotw + "," + fmtime;
		return DotwTime;
	}
	static String getLogTime() {
		ZonedDateTime time = ZonedDateTime.now();
		String fmtime = time.format(formatLong);
		String fmzone = time.format(formatZone);
		String LogTime = "[ " + fmzone + " ]" + " " + fmtime + " | ";
		return LogTime;
	}
}
