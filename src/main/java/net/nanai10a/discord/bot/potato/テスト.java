package net.nanai10a.discord.bot.potato;

import java.time.ZonedDateTime;

public class テスト{
	
	public static void main(String[] args) {
		System.out.println(args);
		//出力:[Ljava.lang.String;@2401f4c3
		
		//instanceof演算子のテスト
		E instance = new E();
		
		if (instance instanceof A) {System.out.println("1");}
		if (instance instanceof B) {System.out.println("2");}
		if (instance instanceof C) {System.out.println("3");}
		if (instance instanceof D) {System.out.println("4");}
		if (instance instanceof E) {System.out.println("5");}
		//結果は"すべて出力される"→ひ孫クラス以下でもtrueが返される
		
		ZonedDateTime time = ZonedDateTime.now();
		System.out.println(time);
		
		System.out.println(Time.getDotwTime());
		
	}

}

class A {}
class B extends A {}
class C extends B {}
class D extends C {}
class E extends D {}