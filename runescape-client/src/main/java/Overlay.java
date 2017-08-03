import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("overlays")
   public static NodeCache overlays;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("overlay_ref")
   static IndexDataBase overlay_ref;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1426499409
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -280996339
   )
   @Export("color")
   public int color;
   @ObfuscatedName("e")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1558970253
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -344229977
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 890431933
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2141163159
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1269563719
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1888026539
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2071820855
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfw;III)V",
      garbageValue = "-1473049480"
   )
   void method4661(Buffer var1, int var2, int var3) {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "445690403"
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
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1830444178"
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfw;IB)V",
      garbageValue = "39"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4661(var1, var3, var2);
      }
   }
}
