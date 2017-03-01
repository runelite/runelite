import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1685022305
   )
   public int field2811;
   @ObfuscatedName("x")
   public static class182 field2812;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -930052673
   )
   int field2813 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1994427877
   )
   public int field2814;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1362888793
   )
   public int field2815;
   @ObfuscatedName("n")
   public static NodeCache field2816 = new NodeCache(64);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1040726645
   )
   public int field2817;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1613290362"
   )
   public void method3548(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3552(var1, var3, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "209846897"
   )
   void method3550(int var1) {
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
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
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
      this.field2811 = (int)(256.0D * var14);
      this.field2814 = (int)(var16 * 256.0D);
      if(this.field2811 < 0) {
         this.field2811 = 0;
      } else if(this.field2811 > 255) {
         this.field2811 = 255;
      }

      if(this.field2814 < 0) {
         this.field2814 = 0;
      } else if(this.field2814 > 255) {
         this.field2814 = 255;
      }

      if(var16 > 0.5D) {
         this.field2817 = (int)(var14 * (1.0D - var16) * 512.0D);
      } else {
         this.field2817 = (int)(512.0D * var14 * var16);
      }

      if(this.field2817 < 1) {
         this.field2817 = 1;
      }

      this.field2815 = (int)(var12 * (double)this.field2817);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "354035414"
   )
   void method3552(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2813 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "65280"
   )
   public void method3553() {
      this.method3550(this.field2813);
   }
}
