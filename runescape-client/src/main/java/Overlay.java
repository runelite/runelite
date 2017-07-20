import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("overlays")
   static NodeCache overlays;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("overlay_ref")
   public static IndexDataBase overlay_ref;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   static IndexData field3568;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1375991333
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 621808005
   )
   @Export("color")
   public int color;
   @ObfuscatedName("g")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -839152167
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 100474525
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1932887233
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1496644645
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 764464317
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 754327857
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -800728615
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;III)V",
      garbageValue = "1882436428"
   )
   void method4553(Buffer var1, int var2, int var3) {
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "56"
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
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "2126608060"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4553(var1, var3, var2);
      }
   }
}
