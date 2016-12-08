import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class148 {
   @ObfuscatedName("o")
   static boolean field2045;
   @ObfuscatedName("af")
   static boolean field2047;

   static {
      new HashMap();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)[LSpritePixels;",
      garbageValue = "1376107623"
   )
   static SpritePixels[] method2698() {
      SpritePixels[] var0 = new SpritePixels[class225.field3218];

      for(int var1 = 0; var1 < class225.field3218; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.field3208 = class204.field3077;
         var2.field3209 = class225.field3216;
         var2.field3203 = class211.field3125[var1];
         var2.field3211 = class225.field3217[var1];
         var2.width = FaceNormal.field1557[var1];
         var2.height = FileOnDisk.field1199[var1];
         int var3 = var2.width * var2.height;
         byte[] var4 = XGrandExchangeOffer.field36[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class225.field3215[var4[var5] & 255];
         }
      }

      class176.method3182();
      return var0;
   }
}
