import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("overlays")
   static NodeCache overlays;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 637255609
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1993736555
   )
   @Export("color")
   public int color;
   @ObfuscatedName("x")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1373008539
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1246866179
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 163955931
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -574170681
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -519117301
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1451040001
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2051098771
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfb;IIB)V",
      garbageValue = "-7"
   )
   void method4703(Buffer var1, int var2, int var3) {
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-9563"
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
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(256.0D * var12);
      this.saturation = (int)(var14 * 256.0D);
      this.lightness = (int)(var16 * 256.0D);
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-230067737"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;IB)V",
      garbageValue = "106"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4703(var1, var3, var2);
      }
   }
}
