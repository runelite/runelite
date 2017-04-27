import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public class class108 {
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 1473731053
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("ed")
   static SpritePixels[] field1726;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -1873101123
   )
   static int field1727;
   @ObfuscatedName("p")
   static class180 field1728;
   @ObfuscatedName("r")
   public static boolean field1729;
   @ObfuscatedName("rl")
   protected static String field1730;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 1317198511
   )
   @Export("cameraPitch")
   static int cameraPitch;

   class108() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass232;B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public static String method2059(CharSequence var0, class232 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class26.method579(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class26.method579(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= CombatInfoListHolder.method732(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               if(class200.method3637(var7)) {
                  char var8 = class119.method2298(var7);
                  if(var8 != 0) {
                     var5.append(var8);
                  }
               }
            }

            if(var5.length() == 0) {
               return null;
            } else {
               return var5.toString();
            }
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "824493198"
   )
   static final void method2060(boolean var0) {
      for(int var1 = 0; var1 < Client.field321; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field350[var1]];
         int var3 = (Client.field350[var1] << 14) + 536870912;
         if(var2 != null && var2.vmethod737() && var0 == var2.composition.isVisible && var2.composition.method3802()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field603 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field309 == Client.field497[var4][var5]) {
                     continue;
                  }

                  Client.field497[var4][var5] = Client.field309;
               }

               if(!var2.composition.field3061) {
                  var3 -= Integer.MIN_VALUE;
               }

               class172.region.method1732(Client.plane, var2.x, var2.y, CombatInfo1.method600(var2.field603 * 64 - 64 + var2.x, var2.y + (var2.field603 * 64 - 64), Client.plane), var2.field603 * 64 - 64 + 60, var2, var2.angle, var3, var2.field602);
            }
         }
      }

   }
}
