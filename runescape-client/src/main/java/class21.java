import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class21 {
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("ff")
   static int[][] field335;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;IIB)Lkd;",
      garbageValue = "-33"
   )
   public static SpritePixels method176(IndexDataBase var0, int var1, int var2) {
      if(!class72.method1184(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class295.field3850;
         var4.maxHeight = class295.field3851;
         var4.offsetX = class295.field3853[0];
         var4.offsetY = class37.offsetsY[0];
         var4.width = ItemContainer.field745[0];
         var4.height = class31.field428[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class295.spritePixels[0];
         var4.pixels = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.pixels[var7] = class295.field3852[var6[var7] & 255];
         }

         class276.method5044();
         return var4;
      }
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1276222641"
   )
   static String method175(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }
}
