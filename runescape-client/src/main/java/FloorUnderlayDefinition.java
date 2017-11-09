import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("underlay_ref")
   public static IndexDataBase underlay_ref;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("underlays")
   static NodeCache underlays;
   @ObfuscatedName("y")
   static int[] field3399;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -527868175
   )
   @Export("rgbColor")
   int rgbColor;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1697975217
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1408999013
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1807127125
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -307868515
   )
   @Export("hueMultiplier")
   public int hueMultiplier;

   static {
      underlays = new NodeCache(64);
   }

   FloorUnderlayDefinition() {
      this.rgbColor = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2031854317"
   )
   @Export("post")
   void post() {
      this.setHSL(this.rgbColor);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "-641119795"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfv;III)V",
      garbageValue = "-1252471479"
   )
   @Export("decode")
   void decode(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgbColor = var1.read24BitInt();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1603428512"
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
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
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

      if(var16 > 0.5D) {
         this.hueMultiplier = (int)(var14 * (1.0D - var16) * 512.0D);
      } else {
         this.hueMultiplier = (int)(var16 * var14 * 512.0D);
      }

      if(this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)((double)this.hueMultiplier * var12);
   }
}
