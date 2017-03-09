import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -741976071
   )
   public int field3041;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -741265141
   )
   @Export("color")
   public int color = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -346020261
   )
   @Export("texture")
   public int texture = -1;
   @ObfuscatedName("w")
   @Export("isHidden")
   public boolean isHidden = true;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -929496593
   )
   public int field3045 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 756915205
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1278520375
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -120931921
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1342061009
   )
   public int field3049;
   @ObfuscatedName("j")
   public static NodeCache field3050 = new NodeCache(64);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 98195399
   )
   public int field3051;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1752076945"
   )
   void method3743() {
      if(this.field3045 != -1) {
         this.method3745(this.field3045);
         this.field3049 = this.hue;
         this.field3051 = this.saturation;
         this.field3041 = this.lightness;
      }

      this.method3745(this.color);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1804253648"
   )
   void method3745(int var1) {
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

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
      this.saturation = (int)(256.0D * var14);
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-737775103"
   )
   void method3746(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3045 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1697647614"
   )
   void method3749(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3746(var1, var3, var2);
      }
   }
}
