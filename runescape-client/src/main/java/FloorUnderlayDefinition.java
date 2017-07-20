import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("underlays")
   static NodeCache underlays;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("underlay_ref")
   public static IndexDataBase underlay_ref;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -724744521
   )
   @Export("rgbColor")
   int rgbColor;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 587211791
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -757898747
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -621108363
   )
   @Export("hueMultiplier")
   public int hueMultiplier;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1613302181
   )
   @Export("lightness")
   public int lightness;

   static {
      underlays = new NodeCache(64);
   }

   FloorUnderlayDefinition() {
      this.rgbColor = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1472811703"
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
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
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

      if(var16 > 0.5D) {
         this.hueMultiplier = (int)(512.0D * (1.0D - var16) * var14);
      } else {
         this.hueMultiplier = (int)(512.0D * var16 * var14);
      }

      if(this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)((double)this.hueMultiplier * var12);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;IIB)V",
      garbageValue = "99"
   )
   @Export("decode")
   void decode(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgbColor = var1.read24BitInt();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-529554719"
   )
   @Export("post")
   void post() {
      this.setHSL(this.rgbColor);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-457182655"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.decode(var1, var3, var2);
      }
   }
}
