import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("er")
public class class153 implements class111 {
   @ObfuscatedName("r")
   static final class153 field2267 = new class153("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("y")
   static final class153 field2268 = new class153("game5", "Game 5", 4);
   @ObfuscatedName("s")
   static final class153 field2269 = new class153("game4", "Game 4", 3);
   @ObfuscatedName("e")
   public static final class153 field2271 = new class153("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("g")
   public final String field2272;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2063905735
   )
   final int field2273;
   @ObfuscatedName("f")
   static final class153 field2275 = new class153("game3", "Game 3", 2);
   @ObfuscatedName("a")
   static final class153 field2276 = new class153("runescape", "RuneScape", 0);

   @ObfuscatedName("r")
   public static boolean method3164(int var0) {
      return 0 != (var0 >> 21 & 1);
   }

   class153(String var1, String var2, int var3) {
      this.field2272 = var1;
      this.field2273 = var3;
   }

   @ObfuscatedName("aj")
   static final int method3171() {
      if(class89.field1548.field131) {
         return class48.field1078;
      } else {
         int var0 = class4.method52(class44.field1037, class17.field254, class48.field1078);
         return var0 - class30.field713 < 800 && 0 != (class5.field90[class48.field1078][class44.field1037 >> 7][class17.field254 >> 7] & 4)?class48.field1078:3;
      }
   }

   @ObfuscatedName("a")
   public int vmethod3184() {
      return this.field2273;
   }
}
