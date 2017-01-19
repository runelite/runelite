import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("c")
   static NodeCache field2812 = new NodeCache(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1372172281
   )
   int field2813 = 0;
   @ObfuscatedName("s")
   public static class182 field2814;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 161943995
   )
   public int field2815;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -603536765
   )
   public int field2816;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1902915329
   )
   public int field2817;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -632171143
   )
   public int field2819;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-534873620"
   )
   void method3367() {
      this.method3370(this.field2813);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "677770661"
   )
   void method3368(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2813 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-43"
   )
   void method3370(int var1) {
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
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field2815 = (int)(256.0D * var14);
      this.field2816 = (int)(var16 * 256.0D);
      if(this.field2815 < 0) {
         this.field2815 = 0;
      } else if(this.field2815 > 255) {
         this.field2815 = 255;
      }

      if(this.field2816 < 0) {
         this.field2816 = 0;
      } else if(this.field2816 > 255) {
         this.field2816 = 255;
      }

      if(var16 > 0.5D) {
         this.field2817 = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.field2817 = (int)(512.0D * var14 * var16);
      }

      if(this.field2817 < 1) {
         this.field2817 = 1;
      }

      this.field2819 = (int)(var12 * (double)this.field2817);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "2"
   )
   static SpritePixels method3373() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class225.field3218;
      var0.maxHeight = class225.field3219;
      var0.offsetX = class181.field2710[0];
      var0.offsetY = class225.field3220[0];
      var0.width = class119.field1865[0];
      var0.height = class109.field1742[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class44.field888[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class225.field3217[var2[var3] & 255];
      }

      class30.method648();
      return var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1037325591"
   )
   void method3377(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3368(var1, var3, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   public static void method3381() {
      Sequence.field3059.reset();
      Sequence.field3060.reset();
   }
}
