package archive;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.nanai10a.discord.bot.potato.Main;

class Test {
	
	public static void main(String[] args) throws LoginException {
		JDA jda = new JDABuilder(Main.TOKEN2).build();
		JDABuilder builder = new JDABuilder(args[0]);
		
		// Disable parts of the cache
		builder.setDisabledCacheFlags(EnumSet.of(CacheFlag.ACTIVITY, CacheFlag.VOICE_STATE));
		// Enable the bulk delete event
		builder.setBulkDeleteSplittingEnabled(false);
		// Disable compression (not recommended)
		builder.setCompression(Compression.NONE);
		// Set activity (like "playing Something")
		builder.setActivity(Activity.watching("TV"));
		
		builder.build();
	}
	public void configureMemoryUsage(JDABuilder builder) {
	    // Disable cache for member activities (streaming/games/spotify)
	    builder.setDisabledCacheFlags(
	        EnumSet.of(CacheFlag.ACTIVITY)
	    );
	    // Disable user/member cache and related events
	    builder.setGuildSubscriptionsEnabled(false);
	    // Disable member chunking on startup (ignored if guild subscriptions are turned off)
	    builder.setChunkingFilter(ChunkingFilter.NONE);
	}
	public RestAction<Void> selfDestruct(MessageChannel channel, String content) {
	    Object scheduler;
		TimeUnit SECONDS;
		Object MINUTES;
		return channel.sendMessage("The following message will destroy itself in 1 minute!")
	        .delay(10, SECONDS, scheduler) // edit 10 seconds later
	        .flatMap((it) -> it.editMessage(content))
	        .delay(1, MINUTES, scheduler) // delete 1 minute later
	        .flatMap(Message::delete);
	}
}
