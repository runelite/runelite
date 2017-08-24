import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("ClanMember")
public class ClanMember extends Node {
   @ObfuscatedName("i")
   @Export("username")
   String username;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2082212303
   )
   @Export("world")
   int world;
   @ObfuscatedName("j")
   String field932;
   @ObfuscatedName("r")
   @Export("rank")
   byte rank;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-32"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   public static void method1169() {
      class255.field3413.reset();
      class255.field3430.reset();
      class255.field3421.reset();
   }
}
