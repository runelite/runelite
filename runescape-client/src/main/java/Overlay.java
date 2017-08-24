import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("overlays")
   static NodeCache overlays;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("overlay_ref")
   public static IndexDataBase overlay_ref;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1813636565
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1820890655
   )
   @Export("color")
   public int color;
   @ObfuscatedName("o")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1583503347
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1125572509
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 833138627
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -615595771
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1182336367
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1831696769
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1495946199
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfp;III)V",
      garbageValue = "-1694964090"
   )
   void method4649(Buffer var1, int var2, int var3) {
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
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
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(256.0D * var12);
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1960315543"
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-859124669"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4649(var1, var3, var2);
      }
   }
}
