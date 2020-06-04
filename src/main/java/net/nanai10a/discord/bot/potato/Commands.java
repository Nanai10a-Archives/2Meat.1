package net.nanai10a.discord.bot.potato;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

class Commands extends Command{
	
	public Commands() {
		this.name = "test";
		this.help = "テスト:こんにちは、[Authorname]さん! を返信する。";
	}
	
	@Override
	public void execute(CommandEvent event) {
		event.reply("こんにちは、" + event.getAuthor().getName() + "さん!");
	}
}
