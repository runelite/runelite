import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -160820647
   )
   public int field2788;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1909207397
   )
   public int field2789;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2031230541
   )
   int field2790 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 318091349
   )
   public int field2791;
   @ObfuscatedName("k")
   public static class182 field2792;
   @ObfuscatedName("y")
   public static NodeCache field2794 = new NodeCache(64);
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -1960299599
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1061726509
   )
   public int field2796;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = -8245324628046427169L
   )
   static long field2799;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1528381903"
   )
   public void method3476() {
      this.method3481(this.field2790);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "1"
   )
   void method3477(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2790 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-4402"
   )
   void method3481(int var1) {
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

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field2789 = (int)(var14 * 256.0D);
      this.field2788 = (int)(var16 * 256.0D);
      if(this.field2789 < 0) {
         this.field2789 = 0;
      } else if(this.field2789 > 255) {
         this.field2789 = 255;
      }

      if(this.field2788 < 0) {
         this.field2788 = 0;
      } else if(this.field2788 > 255) {
         this.field2788 = 255;
      }

      if(var16 > 0.5D) {
         this.field2796 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field2796 = (int)(512.0D * var16 * var14);
      }

      if(this.field2796 < 1) {
         this.field2796 = 1;
      }

      this.field2791 = (int)(var12 * (double)this.field2796);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1275303705"
   )
   public void method3487(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3477(var1, var3, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-202288423"
   )
   public static void method3489(class182 var0) {
      class188.field2765 = var0;
   }
}
