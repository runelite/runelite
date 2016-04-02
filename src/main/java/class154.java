import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class154 implements class112 {
   @ObfuscatedName("f")
   public static final class154 field2272 = new class154("game3", "Game 3", 2);
   @ObfuscatedName("e")
   public static final class154 field2273 = new class154("runescape", "RuneScape", 0);
   @ObfuscatedName("s")
   public static final class154 field2274 = new class154("game4", "Game 4", 3);
   @ObfuscatedName("w")
   public static final class154 field2275 = new class154("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("p")
   public static final class154 field2276 = new class154("game5", "Game 5", 4);
   @ObfuscatedName("h")
   public static final class154 field2277 = new class154("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("g")
   public final String field2278;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -339641739
   )
   final int field2279;

   @ObfuscatedName("w")
   public int vmethod3172() {
      return this.field2279;
   }

   class154(String var1, String var2, int var3) {
      this.field2278 = var1;
      this.field2279 = var3;
   }

   @ObfuscatedName("dv")
   static class173 method3162(class173 var0) {
      class173 var1 = class135.method2869(var0);
      if(null == var1) {
         var1 = var0.field2830;
      }

      return var1;
   }

   @ObfuscatedName("e")
   public static final boolean method3163(String var0, String var1, String var2, String var3) {
      return null != var0 && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "9"
   )
   static final void method3164(boolean var0) {
      for(int var1 = 0; var1 < client.field317; ++var1) {
         class34 var2 = client.field316[client.field318[var1]];
         int var3 = (client.field318[var1] << 14) + 536870912;
         if(var2 != null && var2.vmethod744() && var0 == var2.field755.field881 && var2.field755.method763()) {
            int var4 = var2.field804 >> 7;
            int var5 = var2.field814 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field792 == 1 && 64 == (var2.field804 & 127) && (var2.field814 & 127) == 64) {
                  if(client.field384 == client.field369[var4][var5]) {
                     continue;
                  }

                  client.field369[var4][var5] = client.field384;
               }

               if(!var2.field755.field891) {
                  var3 -= Integer.MIN_VALUE;
               }

               class151.field2250.method1937(class48.field1063, var2.field804, var2.field814, class59.method1263(var2.field804 + (var2.field792 * 64 - 64), var2.field792 * 64 - 64 + var2.field814, class48.field1063), 60 + (var2.field792 * 64 - 64), var2, var2.field790, var3, var2.field791);
            }
         }
      }

   }

   @ObfuscatedName("n")
   public static boolean method3165(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:8364 == var0 || var0 == 338 || var0 == 8212 || 339 == var0 || var0 == 376);
   }
}
