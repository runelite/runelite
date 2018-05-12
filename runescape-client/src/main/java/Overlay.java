import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("overlay_ref")
   public static IndexDataBase overlay_ref;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("overlays")
   static NodeCache overlays;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 501927119
   )
   @Export("color")
   public int color;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1646524769
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("f")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -921475837
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1998822279
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 798518713
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 951289099
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -139363617
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 762625637
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1916651771
   )
   @Export("otherLightness")
   public int otherLightness;

   static {
      overlays = new NodeCache(64);
   }

   Overlay() {
      this.color = 0;
      this.texture = -1;
      this.isHidden = true;
      this.otherRgbColor = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-48"
   )
   @Export("post")
   void post() {
      if(this.otherRgbColor != -1) {
         this.setHSL(this.otherRgbColor);
         this.otherHue = this.hue;
         this.otherSaturation = this.saturation;
         this.otherLightness = this.lightness;
      }

      this.setHSL(this.color);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-393961327"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.readNext(var1, var3, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgy;IIS)V",
      garbageValue = "-256"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.otherRgbColor = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1490003908"
   )
   @Export("setHSL")
   void setHSL(int var1) {
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
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
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
}
