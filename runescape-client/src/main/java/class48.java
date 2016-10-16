import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class48 extends CacheableNode {
   @ObfuscatedName("p")
   public boolean field1031 = true;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -397252641
   )
   public int field1032 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1924838987
   )
   public int field1034 = 0;
   @ObfuscatedName("z")
   public static NodeCache field1035 = new NodeCache(64);
   @ObfuscatedName("s")
   public static class170 field1036;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1057866801
   )
   public int field1037 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -314981847
   )
   public int field1038;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1423160287
   )
   public int field1039;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1222247465
   )
   public int field1040;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1694144775
   )
   public int field1041;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1222196921
   )
   public int field1042;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -199717945
   )
   public int field1044;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1063022809"
   )
   public void method953() {
      if(this.field1037 != -1) {
         this.method956(this.field1037);
         this.field1040 = this.field1044;
         this.field1041 = this.field1038;
         this.field1042 = this.field1039;
      }

      this.method956(this.field1034);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1828534248"
   )
   public void method954(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2481();
         if(var3 == 0) {
            return;
         }

         this.method955(var1, var3, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIS)V",
      garbageValue = "180"
   )
   void method955(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1034 = var1.method2485();
      } else if(var2 == 2) {
         this.field1032 = var1.method2481();
      } else if(var2 == 5) {
         this.field1031 = false;
      } else if(var2 == 7) {
         this.field1037 = var1.method2485();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-3"
   )
   void method956(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field1044 = (int)(256.0D * var12);
      this.field1038 = (int)(256.0D * var14);
      this.field1039 = (int)(256.0D * var16);
      if(this.field1038 < 0) {
         this.field1038 = 0;
      } else if(this.field1038 > 255) {
         this.field1038 = 255;
      }

      if(this.field1039 < 0) {
         this.field1039 = 0;
      } else if(this.field1039 > 255) {
         this.field1039 = 255;
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "24"
   )
   static final void method961(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field298; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field452[var4] = true;
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LActor;S)V",
      garbageValue = "640"
   )
   static final void method962(Actor var0) {
      if(var0.field848 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field835 + 1 > class4.getAnimation(var0.animation).field981[var0.actionFrame]) {
         int var1 = var0.field848 - var0.field847;
         int var2 = Client.gameCycle - var0.field847;
         int var3 = var0.field805 * 64 + var0.field843 * 128;
         int var4 = var0.field845 * 128 + var0.field805 * 64;
         int var5 = var0.field805 * 64 + var0.field844 * 128;
         int var6 = var0.field846 * 128 + var0.field805 * 64;
         var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
         var0.y = ((var1 - var2) * var4 + var2 * var6) / var1;
      }

      var0.field859 = 0;
      var0.field852 = var0.field849;
      var0.angle = var0.field852;
   }
}
