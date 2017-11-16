import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("me")
   @ObfuscatedSignature(
      signature = "Ljq;"
   )
   static class285 field3397;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("underlay_ref")
   static IndexDataBase underlay_ref;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("underlays")
   public static NodeCache underlays;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1170025503
   )
   @Export("rgbColor")
   int rgbColor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -478384559
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1017155977
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1920124869
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1283350245
   )
   @Export("hueMultiplier")
   public int hueMultiplier;

   static {
      underlays = new NodeCache(64);
   }

   FloorUnderlayDefinition() {
      this.rgbColor = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1039865813"
   )
   @Export("post")
   void post() {
      this.setHSL(this.rgbColor);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfs;IB)V",
      garbageValue = "31"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfs;III)V",
      garbageValue = "-1031407450"
   )
   @Export("decode")
   void decode(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgbColor = var1.read24BitInt();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1642231367"
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
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
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

      if(var16 > 0.5D) {
         this.hueMultiplier = (int)(var14 * (1.0D - var16) * 512.0D);
      } else {
         this.hueMultiplier = (int)(512.0D * var14 * var16);
      }

      if(this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)(var12 * (double)this.hueMultiplier);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;B)V",
      garbageValue = "5"
   )
   public static void method4353(IndexDataBase var0) {
      Enum.field3453 = var0;
   }
}
