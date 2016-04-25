import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class154 implements class112 {
   @ObfuscatedName("m")
   static final class154 field2267 = new class154("game3", "Game 3", 2);
   @ObfuscatedName("h")
   static final class154 field2268 = new class154("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1937593959
   )
   final int field2269;
   @ObfuscatedName("z")
   static final class154 field2270 = new class154("game4", "Game 4", 3);
   @ObfuscatedName("x")
   static final class154 field2271 = new class154("game5", "Game 5", 4);
   @ObfuscatedName("e")
   public static final class154 field2272 = new class154("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("i")
   public final String field2273;
   @ObfuscatedName("j")
   static final class154 field2274 = new class154("runescape", "RuneScape", 0);
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 544897283
   )
   @Export("cameraPitch")
   static int field2276;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "1776018937"
   )
   static Class method3126(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "23"
   )
   public int vmethod3136() {
      return this.field2269;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class154(String var1, String var2, int var3) {
      this.field2273 = var1;
      this.field2269 = var3;
   }
}
