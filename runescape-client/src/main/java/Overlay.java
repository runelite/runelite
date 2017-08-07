import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("overlays")
   static NodeCache overlays;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("overlay_ref")
   public static IndexDataBase overlay_ref;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 299125737
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 973465423
   )
   @Export("color")
   public int color;
   @ObfuscatedName("w")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -615751681
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1581633647
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1462002179
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 880213161
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1874253453
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 11570875
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -233227827
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfh;III)V",
      garbageValue = "1023473377"
   )
   void method4699(Buffer var1, int var2, int var3) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
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

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2007879943"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;IB)V",
      garbageValue = "19"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4699(var1, var3, var2);
      }
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(Lbe;B)V",
      garbageValue = "29"
   )
   static final void method4710(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class84.region.method2736(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class84.region.method2737(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class84.region.method2738(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class84.region.method2739(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class84.region.method2740(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1189 = var2;
      var0.field1191 = var3;
      var0.field1202 = var4;
   }
}
