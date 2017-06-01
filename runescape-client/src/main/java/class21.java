import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class21 {
   @ObfuscatedName("ar")
   static int[] field327;
   @ObfuscatedName("ao")
   static SpritePixels[] field332;
   @ObfuscatedName("i")
   static boolean field334;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-2070628474"
   )
   public static void method138(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "432071929"
   )
   static final int method139(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class61.tileHeights[var5][var3 + 1][var4] * var6 + class61.tileHeights[var5][var3][var4] * (128 - var6) >> 7;
         int var9 = var6 * class61.tileHeights[var5][var3 + 1][var4 + 1] + (128 - var6) * class61.tileHeights[var5][var3][var4 + 1] >> 7;
         return var7 * var9 + (128 - var7) * var8 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)LMessageNode;",
      garbageValue = "869547207"
   )
   static MessageNode method140(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var2.method1860(var1);
   }
}
