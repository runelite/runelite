import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1013870927
   )
   public int field2805;
   @ObfuscatedName("g")
   static NodeCache field2806 = new NodeCache(64);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 182922753
   )
   int field2807 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -807520663
   )
   public int field2808;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -9928891
   )
   public int field2809;
   @ObfuscatedName("p")
   static class182 field2811;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 263207037
   )
   public int field2812;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "541325293"
   )
   void method3466(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2807 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "597230797"
   )
   void method3467(int var1) {
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
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field2809 = (int)(256.0D * var14);
      this.field2805 = (int)(256.0D * var16);
      if(this.field2809 < 0) {
         this.field2809 = 0;
      } else if(this.field2809 > 255) {
         this.field2809 = 255;
      }

      if(this.field2805 < 0) {
         this.field2805 = 0;
      } else if(this.field2805 > 255) {
         this.field2805 = 255;
      }

      if(var16 > 0.5D) {
         this.field2812 = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.field2812 = (int)(512.0D * var16 * var14);
      }

      if(this.field2812 < 1) {
         this.field2812 = 1;
      }

      this.field2808 = (int)(var12 * (double)this.field2812);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "14"
   )
   void method3476(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3466(var1, var3, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-63"
   )
   void method3477() {
      this.method3467(this.field2807);
   }
}
