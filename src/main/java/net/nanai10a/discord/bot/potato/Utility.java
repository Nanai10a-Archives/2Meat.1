package net.nanai10a.discord.bot.potato;

class Utility {
	public static void Sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}