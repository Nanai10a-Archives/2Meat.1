package net.nanai10a.discord.bot.potato;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

class Message extends ListenerAdapter implements EventListener {
	 @Override
	 public void onMessageReceived(MessageReceivedEvent event) {
		 System.out.printf("[%s]: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
	 }
	@Override
	public void onReady(ReadyEvent event) {
		System.out.println(Time.getLogTime() + "Event : Message is Ready.");
	}
}

class ReactionMesseage extends ListenerAdapter implements EventListener {
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw();
		MessageChannel channel = event.getChannel();
		if (!event.getAuthor().isBot()) {
			if (message.contains("")) {
				channel.sendMessage("").queue();
			} else if (message.contains("")) {
				channel.sendMessage("").queue();
			} else if (message.contains("")) {
				channel.sendMessage("").queue();
			} else if (message.contains("")) {
				channel.sendMessage("").queue();
			} else if (message.contains("")) {
				channel.sendMessage("").queue();
			} else if (message.contains("")) {
				channel.sendMessage("").queue();
			} else if (message.contains("")) {
				channel.sendMessage("").queue();
			} else if (message.contains("")) {
				channel.sendMessage("").queue();
			}
		}
	}
	@Override
	public void onReady(ReadyEvent event) {
		System.out.println(Time.getLogTime() + "Event : ReactionMessage is Ready.");
	}
}