import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("OverlayDefinition")
public class OverlayDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__jf_m")
   public static AbstractIndexCache __jf_m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("__jf_f")
   public static EvictingDualNodeHashTable __jf_f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -111851793
   )
   @Export("rgb")
   public int rgb;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 733377225
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("o")
   @Export("__o")
   public boolean __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 528865753
   )
   @Export("rgb2")
   public int rgb2;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2013422835
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1719896767
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -624223733
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -122393061
   )
   @Export("hue2")
   public int hue2;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1514187401
   )
   @Export("saturation2")
   public int saturation2;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 127639041
   )
   @Export("lightness2")
   public int lightness2;

   static {
      __jf_f = new EvictingDualNodeHashTable(64);
   }

   public OverlayDefinition() {
      this.rgb = 0;
      this.texture = -1;
      this.__o = true;
      this.rgb2 = -1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "867788548"
   )
   @Export("init")
   public void init() {
      if(this.rgb2 != -1) {
         this.setHsl(this.rgb2);
         this.hue2 = this.hue;
         this.saturation2 = this.saturation;
         this.lightness2 = this.lightness;
      }

      this.setHsl(this.rgb);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-424203051"
   )
   @Export("read")
   public void read(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.readNext(var1, var3, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;III)V",
      garbageValue = "2094105763"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgb = var1.readMedium();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.__o = false;
      } else if(var2 == 7) {
         this.rgb2 = var1.readMedium();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "489697731"
   )
   @Export("setHsl")
   void setHsl(int var1) {
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

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Lho;IIB)V",
      garbageValue = "30"
   )
   @Export("alignWidgetPosition")
   static void alignWidgetPosition(Widget var0, int var1, int var2) {
      if(var0.xAlignment == 0) {
         var0.x = var0.rawX;
      } else if(var0.xAlignment == 1) {
         var0.x = var0.rawX + (var1 - var0.width) / 2;
      } else if(var0.xAlignment == 2) {
         var0.x = var1 - var0.width - var0.rawX;
      } else if(var0.xAlignment == 3) {
         var0.x = var0.rawX * var1 >> 14;
      } else if(var0.xAlignment == 4) {
         var0.x = (var0.rawX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.x = var1 - var0.width - (var0.rawX * var1 >> 14);
      }

      if(var0.yAlignment == 0) {
         var0.y = var0.rawY;
      } else if(var0.yAlignment == 1) {
         var0.y = (var2 - var0.height) / 2 + var0.rawY;
      } else if(var0.yAlignment == 2) {
         var0.y = var2 - var0.height - var0.rawY;
      } else if(var0.yAlignment == 3) {
         var0.y = var2 * var0.rawY >> 14;
      } else if(var0.yAlignment == 4) {
         var0.y = (var2 * var0.rawY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.y = var2 - var0.height - (var2 * var0.rawY >> 14);
      }

   }
}
