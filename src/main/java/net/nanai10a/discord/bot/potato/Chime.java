package net.nanai10a.discord.bot.potato;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


/////----------------------------------------------------------------------------------------------------/////


class ChimeMain extends ListenerAdapter implements EventListener {
	static Object ChimeLockMain = new Object();
	static Object ChimeLockSub = new Object();
	static boolean started = false;
	static boolean received = false;
	String time;
	//金曜日,00:53:25
	String [] [] classTime = new String [5] [10]; {
		classTime [0] [0] = "月曜日,08:55";
		classTime [0] [2] = "月曜日,10:25";
		classTime [0] [4] = "月曜日,13:15";
		
		classTime [1] [0] = "火曜日,08:55";
		classTime [1] [2] = "火曜日,10:25";
		classTime [1] [4] = "火曜日,13:15";
		classTime [1] [6] = "火曜日,14:45";
		
		classTime [2] [0] = "水曜日,08:55";
		classTime [2] [2] = "水曜日,10:25";
		classTime [2] [4] = "水曜日,13:15";
		classTime [2] [6] = "水曜日,14:45";
		
		classTime [3] [0] = "木曜日,08:55";
		classTime [3] [2] = "木曜日,10:25";
		classTime [3] [4] = "木曜日,13:15";
		classTime [3] [6] = "木曜日,14:45";
		
		classTime [4] [0] = "金曜日,08:55";
		classTime [4] [2] = "金曜日,10:25";
		classTime [4] [4] = "金曜日,13:15";
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		synchronized (ChimeLockMain) {
			String message = event.getMessage().getContentRaw();
			MessageChannel channel = event.getChannel();
			if (!event.getAuthor().isBot() && !started && message.contains("chime!start")) {
				started = true;
				channel.sendMessage("Chime : チャイムを起動しました。" + System.lineSeparator() + "Chime : チャイムを終了させる時は、\"chime!leave\"と入力してください。" + System.lineSeparator() + "Chime : ※このチャイムは5分前の予鈴しか鳴りません").queue();;
				while (!received) {
					time = Time.getTime();
					
					/////--------------------------------------------------/////
					if (time.startsWith(classTime [0] [0])) {
						channel.sendMessage("Chime : 月曜日の1,2限目・英語AⅠ, 講義開始5分前をお知らせします。 ").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [0] [2])) {
						channel.sendMessage("Chime : 月曜日の3,4限目・基礎数学Ⅰ, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [0] [4])) {
						channel.sendMessage("Chime : 月曜日の5,6限目・保健体育Ⅰ, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
						
					/////--------------------------------------------------/////
					} else if (time.startsWith(classTime [1] [0])) {
						channel.sendMessage("Chime : 火曜日の1,2限目・ 物理Ⅰ, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [1] [2])) {
						channel.sendMessage("Chime : 火曜日の3,4限目・情報処理基礎, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [1] [4])) {
						channel.sendMessage("Chime : 火曜日の5,6限目・英語WⅠ, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [1] [6])) {
						channel.sendMessage("Chime : 火曜日の7,8限目・工学基礎Ⅰ, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
						
					/////--------------------------------------------------/////
					} else if (time.startsWith(classTime [2] [0])) {
						channel.sendMessage("Chime : 水曜日の1,2限目・基礎数学Ⅱ, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [2] [2])) {
						channel.sendMessage("Chime : 水曜日の3,4限目・工学基礎Ⅱ, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [2] [4])) {
						channel.sendMessage("Chime : 水曜日の5,6限目・地球と生命の科学, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [2] [6])) {
						channel.sendMessage("Chime : 水曜日の7,8限目・特活, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
						
					/////--------------------------------------------------/////
					} else if (time.startsWith(classTime [3] [0])) {
						channel.sendMessage("Chime : 木曜日の1,2限目・英語C, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [3] [2])) {
						channel.sendMessage("Chime : 木曜日の3,4限目・化学基礎, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [3] [4])) {
						channel.sendMessage("Chime : 木曜日の5,6限目・コンピュータ基礎演習, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [3] [6])) {
						channel.sendMessage("Chime : 木曜日の7,8限目・英語AⅠ, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
						
					/////--------------------------------------------------/////
					} else if (time.startsWith(classTime [4] [0])) {
						channel.sendMessage("Chime : 金曜日の1,2限目・国語Ⅰ, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [4] [2])) {
						channel.sendMessage("Chime : 金曜日の3,4限目・基礎数学Ⅱ, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
					} else if (time.startsWith(classTime [4] [4])) {
						channel.sendMessage("Chime : 金曜日の5,6限目・地理, 講義開始5分前をお知らせします。").queue();
						Utility.Sleep(70000);
						
					/////--------------------------------------------------/////
					}
				}
				started = false;
				received = false;
				channel.sendMessage("Chime : チャイムは終了しました。").queue();
			}
		}
	}
	
	@Override
	public void onReady(ReadyEvent event) {
		System.out.println(Time.getLogTime() + "Event : ChimeMain is Ready.");
	}
}


/////----------------------------------------------------------------------------------------------------/////


class ChimeStop extends ListenerAdapter implements EventListener {
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw();
		synchronized (ChimeMain.ChimeLockSub) {
			if (!event.getAuthor().isBot() && ChimeMain.started && message.contains("chime!leave")) {
				ChimeMain.received = true;
			}
		}
	}
	
	@Override
	public void onReady(ReadyEvent event) {
		System.out.println(Time.getLogTime() + "Event : ChimeStop is Ready.");
	}
}


/////----------------------------------------------------------------------------------------------------/////


class ChimeNotification extends ListenerAdapter implements EventListener {
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw();
		MessageChannel channel = event.getChannel();
		Utility.Sleep(300);
		synchronized (ChimeMain.ChimeLockSub) {
			if (!event.getAuthor().isBot() && ChimeMain.started && message.contains("chime!start")) {
				channel.sendMessage("Chime : チャイムは既に起動しています。").queue();
			} else if (!event.getAuthor().isBot() && !ChimeMain.started && message.contains("chime!leave")) {
				channel.sendMessage("Chime : チャイムは現在起動していません。").queue();
			}
		}
	}
	
	@Override
	public void onReady(ReadyEvent event) {
		System.out.println(Time.getLogTime() + "Event : ChimeNotification is Ready.");
	}
}


/////----------------------------------------------------------------------------------------------------/////

