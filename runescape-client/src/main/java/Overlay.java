import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("overlays")
   public static NodeCache overlays;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -741125859
   )
   @Export("color")
   public int color;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1224286015
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("h")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -464175153
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1733241375
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 793249939
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1117264939
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -76575489
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -306354099
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -807011261
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-947711002"
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgc;IB)V",
      garbageValue = "62"
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgc;IIB)V",
      garbageValue = "0"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-316532057"
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

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(256.0D * var12);
      this.saturation = (int)(256.0D * var14);
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
}
