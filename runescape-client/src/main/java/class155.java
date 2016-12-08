import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class155 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 1168537988852939307L
   )
   static long field2124;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -4803283728477328129L
   )
   static long field2127;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -611018479
   )
   static int field2128;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-946637247"
   )
   static final int method2931(int var0, int var1) {
      int var2 = 57 * var1 + var0;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "1007253899"
   )
   static boolean method2934(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class162.method3013(var0, Friend.field155);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class162.method3013(Client.friends[var3].name, Friend.field155)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class162.method3013(class5.localPlayer.name, Friend.field155))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)LSpritePixels;",
      garbageValue = "-1535379326"
   )
   public static SpritePixels method2935(class182 var0, String var1, String var2) {
      int var3 = var0.method3218(var1);
      int var4 = var0.method3219(var3, var2);
      return class152.method2709(var0, var3, var4);
   }
}
