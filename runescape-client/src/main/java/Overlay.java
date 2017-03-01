import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1300921995
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1329169895
   )
   @Export("color")
   public int color = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -401014653
   )
   @Export("texture")
   public int texture = -1;
   @ObfuscatedName("n")
   public static NodeCache field3047 = new NodeCache(64);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -424159921
   )
   public int field3048 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -345461133
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1798179145
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = 1573003557
   )
   static int field3052;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 506431235
   )
   public int field3053;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 489860713
   )
   public int field3054;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1810846027
   )
   public int field3056;
   @ObfuscatedName("y")
   @Export("isHidden")
   public boolean isHidden = true;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public void method3800() {
      if(this.field3048 != -1) {
         this.method3802(this.field3048);
         this.field3056 = this.hue;
         this.field3053 = this.saturation;
         this.field3054 = this.lightness;
      }

      this.method3802(this.color);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "1"
   )
   public void method3801(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3813(var1, var3, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1663160074"
   )
   void method3802(int var1) {
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
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(256.0D * var12);
      this.saturation = (int)(var14 * 256.0D);
      this.lightness = (int)(256.0D * var16);
      if(this.saturation < 0) {
         this.saturation = 0;
      } else if(this.saturation > 255) {
         this.saturation = 255;
      }

      if(this.lightness < 0) {
         this.lightness = 0;
      } else if(this.lightness > 255) {
         this.lightness = 255;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "63"
   )
   void method3813(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3048 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }
}
