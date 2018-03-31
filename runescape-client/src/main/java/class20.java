import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class20 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1701648215
   )
   public static int field319;
   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IS)Lbk;",
      garbageValue = "-13006"
   )
   static MessageNode method170(int var0) {
      return (MessageNode)class95.messages.get((long)var0);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Llq;I)V",
      garbageValue = "1209692311"
   )
   static final void method169(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < BaseVarType.field30.length; ++var2) {
         BaseVarType.field30[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         BaseVarType.field30[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class5.field34[var5] = (BaseVarType.field30[var5 + 128] + BaseVarType.field30[var5 - 128] + BaseVarType.field30[var5 + 1] + BaseVarType.field30[var5 - 1]) / 4;
            }
         }

         int[] var8 = BaseVarType.field30;
         BaseVarType.field30 = class5.field34;
         class5.field34 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.width; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  BaseVarType.field30[var7] = 0;
               }
            }
         }
      }

   }
}
