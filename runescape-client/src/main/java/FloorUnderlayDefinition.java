import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("underlay_ref")
   public static IndexDataBase underlay_ref;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("underlays")
   public static NodeCache underlays;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1619995955
   )
   @Export("rgbColor")
   int rgbColor;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1104889863
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2067748845
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1965078895
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1313824053
   )
   @Export("hueMultiplier")
   public int hueMultiplier;

   static {
      underlays = new NodeCache(64);
   }

   FloorUnderlayDefinition() {
      this.rgbColor = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "59"
   )
   @Export("post")
   void post() {
      this.setHSL(this.rgbColor);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "308583790"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgy;III)V",
      garbageValue = "-925497502"
   )
   @Export("decode")
   void decode(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgbColor = var1.read24BitInt();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "278586674"
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
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
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
         this.hueMultiplier = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.hueMultiplier = (int)(var16 * var14 * 512.0D);
      }

      if(this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)((double)this.hueMultiplier * var12);
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "769791385"
   )
   static boolean method4758(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }
}
