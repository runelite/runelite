import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class190 extends Node {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1689515557
   )
   int field3054;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1046289433
   )
   int field3055;
   @ObfuscatedName("n")
   class65 field3056;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1635328799
   )
   int field3057;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -759418023
   )
   int field3058;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1148680201
   )
   int field3059;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1267127447
   )
   int field3060;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 325994145
   )
   int field3061;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1121659379
   )
   int field3062;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 152350873
   )
   int field3063;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -604112349
   )
   int field3064;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1947257313
   )
   int field3065;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1130193969
   )
   int field3066;
   @ObfuscatedName("q")
   class67 field3067;
   @ObfuscatedName("t")
   class188 field3068;
   @ObfuscatedName("e")
   class184 field3069;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1688950645
   )
   int field3070;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -272232417
   )
   int field3071;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 470399217
   )
   int field3073;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -874003367
   )
   int field3074;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2028663585
   )
   int field3075;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-48"
   )
   void method3804() {
      this.field3069 = null;
      this.field3056 = null;
      this.field3068 = null;
      this.field3067 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1246911236"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      DecorativeObject.addChatMessage(var0, var1, var2, (String)null);
   }
}
