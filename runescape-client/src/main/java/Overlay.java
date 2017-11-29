import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("overlay_ref")
   static IndexDataBase overlay_ref;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("overlays")
   public static NodeCache overlays;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -649763911
   )
   @Export("color")
   public int color;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -459779691
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("v")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2046764839
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 965512459
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 576400787
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -213505657
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1417683265
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -290785351
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -967785639
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
      garbageValue = "-446056410"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfr;IB)V",
      garbageValue = "6"
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfr;IIB)V",
      garbageValue = "-125"
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-75"
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
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
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
}
