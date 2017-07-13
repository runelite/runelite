import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("j")
   @Export("overlays")
   public static NodeCache overlays;
   @ObfuscatedName("a")
   @Export("overlay_ref")
   static IndexDataBase overlay_ref;
   @ObfuscatedName("pi")
   static class116 field3593;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1224117751
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -623009937
   )
   @Export("color")
   public int color;
   @ObfuscatedName("v")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1923327763
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1281091563
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -354024675
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 772868029
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1967949049
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -924098289
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1441899805
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "80"
   )
   void method4599(Buffer var1, int var2, int var3) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2020674854"
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
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-56"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "647325151"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4599(var1, var3, var2);
      }
   }
}
