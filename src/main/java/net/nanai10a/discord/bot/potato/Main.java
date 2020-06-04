package net.nanai10a.discord.bot.potato;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

class Main {
	
	//static final String TwoMeatToken = "";
		//static final String PotatoToken = ""; 
		static final String Token = "";
	
	public static void main(String[] args) {
		System.out.println(Time.getLogTime() + "System was Started.");
		
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel","DEBUG");
		
		Object wait = new Object();
		
		new Thread( () -> {
			synchronized(wait) {
				JDA Potato = null;
				try {
					Potato = JDABuilder.createDefault(Main.Token)
							.enableIntents(GatewayIntent.GUILD_MEMBERS)
							.addEventListeners(new ChimeMain())
							.build();
				} catch (LoginException e) {
					e.printStackTrace();
				}
				try {
					Potato.awaitReady();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Time.getLogTime() + "ChimeMain has finished Initialization.");
				
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread ( () -> {
			synchronized(wait) {
				JDA Potato = null;
				try {
					Potato = JDABuilder.createDefault(Main.Token)
							.enableIntents(GatewayIntent.GUILD_MEMBERS)
							.addEventListeners(new ChimeStop())
							.build();
				} catch (LoginException e) {
					e.printStackTrace();
				}
				try {
					Potato.awaitReady();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Time.getLogTime() + "ChimeStop has finished Initialization.");
				
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread( () -> {
			synchronized(wait) {
				JDA Potato = null;
				try {
					Potato = JDABuilder.createDefault(Main.Token)
							.enableIntents(GatewayIntent.GUILD_MEMBERS)
							.addEventListeners(new ChimeNotification())
							.build();
				} catch (LoginException e) {
					e.printStackTrace();
				}
				try {
					Potato.awaitReady();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Time.getLogTime() + "ChimeNotification has finished Initialization.");
				
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}














/*
 * 結構書き直しが必要。というか設計しましょう。
 */

/*
 * 
 * Discordの履歴を読み返しましょう。
 * 多スレッド処理を実装します。
 * 並列処理しないと2つの作業ができません。(作業中にコマンドを受け取る)
 * 頑張って。(脳死した私より)
 * ↓
 * 了解。(帰ってきた私)
 * 
 */
//ログ出力は個人設定として作っておく
//DEBUGは裏の情報がまぁ出るくらいだけど、TRACEは取得した情報全部吐いてる…
//↓はDEBUGに設定するやつ(TRACE>DEBUG)
//煩いので指定なしで(INFO)
//System.setProperty("org.slf4j.simpleLogger.defaultLogLevel","DEBUG");
/*JDA Potato = JDABuilder.createDefault(Token)
		.enableIntents(GatewayIntent.GUILD_MEMBERS)
		.addEventListeners(new Message(), *//*new ReactionMesseage(),*//* new Chime(), new ChimeStop())
		.build();
Potato.awaitReady();
if (Potato instanceof JDA) {
	System.out.println(Time.getLogTime() + "Potato has finished Initialization.");
	
	/*
	 * 
	 * こっから他スレッドの準備をする
	 * 
	 */