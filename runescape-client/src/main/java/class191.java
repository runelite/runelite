import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class191 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 548756743
   )
   public int field2808;
   @ObfuscatedName("e")
   public static NodeCache field2809 = new NodeCache(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -958126143
   )
   int field2810 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1013301707
   )
   public int field2811;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1305027589
   )
   public int field2812;
   @ObfuscatedName("i")
   public static class182 field2813;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1091809369
   )
   public int field2815;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "832677498"
   )
   void method3422(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2810 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "30"
   )
   void method3423(int var1) {
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
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field2812 = (int)(256.0D * var14);
      this.field2815 = (int)(var16 * 256.0D);
      if(this.field2812 < 0) {
         this.field2812 = 0;
      } else if(this.field2812 > 255) {
         this.field2812 = 255;
      }

      if(this.field2815 < 0) {
         this.field2815 = 0;
      } else if(this.field2815 > 255) {
         this.field2815 = 255;
      }

      if(var16 > 0.5D) {
         this.field2808 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field2808 = (int)(var14 * var16 * 512.0D);
      }

      if(this.field2808 < 1) {
         this.field2808 = 1;
      }

      this.field2811 = (int)(var12 * (double)this.field2808);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "775861855"
   )
   void method3429(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3422(var1, var3, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)LWidget;",
      garbageValue = "65"
   )
   public static Widget method3433(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = class212.method3870(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1966695795"
   )
   void method3434() {
      this.method3423(this.field2810);
   }
}
