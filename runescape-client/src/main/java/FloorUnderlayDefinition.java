import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1638645983
   )
   public int field2810;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1819871973
   )
   public int field2811;
   @ObfuscatedName("l")
   static NodeCache field2812 = new NodeCache(64);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2144254815
   )
   public int field2813;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1332323055
   )
   public int field2814;
   @ObfuscatedName("b")
   static class182 field2815;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -147388789
   )
   int field2816 = 0;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-636025927"
   )
   void method3550(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2816 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "98215435"
   )
   void method3551() {
      this.method3565(this.field2816);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1901802650"
   )
   void method3559(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3550(var1, var3, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1525450264"
   )
   void method3565(int var1) {
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
      this.field2814 = (int)(var14 * 256.0D);
      this.field2810 = (int)(256.0D * var16);
      if(this.field2814 < 0) {
         this.field2814 = 0;
      } else if(this.field2814 > 255) {
         this.field2814 = 255;
      }

      if(this.field2810 < 0) {
         this.field2810 = 0;
      } else if(this.field2810 > 255) {
         this.field2810 = 255;
      }

      if(var16 > 0.5D) {
         this.field2811 = (int)(var14 * (1.0D - var16) * 512.0D);
      } else {
         this.field2811 = (int)(var16 * var14 * 512.0D);
      }

      if(this.field2811 < 1) {
         this.field2811 = 1;
      }

      this.field2813 = (int)(var12 * (double)this.field2811);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   static void method3569() {
      Client.menuOptionCount = 0;
      Client.field432 = -1;
      Client.isMenuOpen = false;
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuOptionCount = 1;
   }
}
