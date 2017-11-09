import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("overlay_ref")
   static IndexDataBase overlay_ref;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("overlays")
   public static NodeCache overlays;
   @ObfuscatedName("o")
   static int[] field3653;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 56606915
   )
   @Export("color")
   public int color;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1839858901
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("v")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -826619153
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -607948989
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -542252285
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 248746657
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -766129939
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -319455885
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -403035349
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-67"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfv;IB)V",
      garbageValue = "-61"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4856(var1, var3, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfv;III)V",
      garbageValue = "-136553761"
   )
   void method4856(Buffer var1, int var2, int var3) {
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
      signature = "(II)V",
      garbageValue = "-75026598"
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
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgi;S)I",
      garbageValue = "144"
   )
   static int method4853(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }
}
