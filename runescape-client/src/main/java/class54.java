import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class54 {
   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass210;I)V",
      garbageValue = "428502607"
   )
   static final void method787(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      if(var4 != null) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class136.SINE[var6];
            int var9 = class136.COSINE[var6];
            var8 = var8 * 256 / (Client.mapScaleDelta + 256);
            var9 = var9 * 256 / (Client.mapScaleDelta + 256);
            int var10 = var2 * var9 + var8 * var3 >> 16;
            int var11 = var9 * var3 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method5152(var5.field2591 / 2 + var10 - var4.maxWidth / 2, var5.field2590 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2591, var5.field2590, var5.field2587, var5.field2589);
            } else {
               var4.method5207(var0 + var5.field2591 / 2 + var10 - var4.maxWidth / 2, var5.field2590 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-639033340"
   )
   static final void method789(int var0) {
      if(class14.method75(var0)) {
         Widget[] var1 = class90.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2773 = 0;
               var3.field2765 = 0;
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Lclass251;",
      garbageValue = "71"
   )
   public static class251 method790(int var0) {
      class251 var1 = (class251)class251.field3382.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class251.field3386.getConfigData(11, var0);
         var1 = new class251();
         if(var2 != null) {
            var1.method4493(new Buffer(var2));
         }

         var1.method4503();
         class251.field3382.put(var1, (long)var0);
         return var1;
      }
   }
}
