import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("underlay_ref")
   public static IndexDataBase underlay_ref;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("underlays")
   static NodeCache underlays;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1882661743
   )
   @Export("rgbColor")
   int rgbColor;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1784433545
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 167744801
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -272353301
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -982635371
   )
   @Export("hueMultiplier")
   public int hueMultiplier;

   static {
      underlays = new NodeCache(64);
   }

   FloorUnderlayDefinition() {
      this.rgbColor = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3532"
   )
   @Export("post")
   void post() {
      this.setHSL(this.rgbColor);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "91986373"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgh;III)V",
      garbageValue = "-2104836165"
   )
   @Export("decode")
   void decode(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgbColor = var1.read24BitInt();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-11"
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
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "455051354"
   )
   static void method4509(boolean var0) {
      class91.loginMessage1 = "";
      class91.loginMessage2 = "Enter your username/email & password.";
      class91.loginMessage3 = "";
      class91.loginIndex = 2;
      if(var0) {
         class91.password = "";
      }

      class231.method4201();
      MouseInput.method959();
   }
}
