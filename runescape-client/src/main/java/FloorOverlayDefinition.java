import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("FloorOverlayDefinition")
public class FloorOverlayDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("FloorOverlayDefinition_archive")
   public static AbstractArchive FloorOverlayDefinition_archive;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("FloorOverlayDefinition_cached")
   public static EvictingDualNodeHashTable FloorOverlayDefinition_cached;
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
   public boolean field665;
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

   public FloorOverlayDefinition() {
      this.rgb = 0;
      this.texture = -1;
      this.field665 = true;
      this.rgb2 = -1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "867788548"
   )
   @Export("postDecode")
   public void postDecode() {
      if (this.rgb2 != -1) {
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
   @Export("decode")
   public void decode(Buffer var1, int var2) {
      while (true) {
         int var3 = var1.readUnsignedByte();
         if (var3 == 0) {
            return;
         }

         this.decodeNext(var1, var3, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;III)V",
      garbageValue = "2094105763"
   )
   @Export("decodeNext")
   void decodeNext(Buffer var1, int var2, int var3) {
      if (var2 == 1) {
         this.rgb = var1.readMedium();
      } else if (var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if (var2 == 5) {
         this.field665 = false;
      } else if (var2 == 7) {
         this.rgb2 = var1.readMedium();
      } else if (var2 == 8) {
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "489697731"
   )
   @Export("setHsl")
   void setHsl(int rgb) {
      double var2 = (double)(rgb >> 16 & 255) / 256.0D;
      double var4 = (double)(rgb >> 8 & 255) / 256.0D;
      double var6 = (double)(rgb & 255) / 256.0D;
      double var8 = var2;
      if (var4 < var2) {
         var8 = var4;
      }

      if (var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if (var4 > var2) {
         var10 = var4;
      }

      if (var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if (var8 != var10) {
         if (var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if (var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if (var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if (var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if (var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(var16 * 256.0D);
      if (this.saturation < 0) {
         this.saturation = 0;
      } else if (this.saturation > 255) {
         this.saturation = 255;
      }

      if (this.lightness < 0) {
         this.lightness = 0;
      } else if (this.lightness > 255) {
         this.lightness = 255;
      }

   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Lho;IIB)V",
      garbageValue = "30"
   )
   @Export("alignWidgetPosition")
   static void alignWidgetPosition(Widget component, int parentWidth, int parentHeight) {
      if (component.xAlignment == 0) {
         component.x = component.rawX;
      } else if (component.xAlignment == 1) {
         component.x = component.rawX + (parentWidth - component.width) / 2;
      } else if (component.xAlignment == 2) {
         component.x = parentWidth - component.width - component.rawX;
      } else if (component.xAlignment == 3) {
         component.x = component.rawX * parentWidth >> 14;
      } else if (component.xAlignment == 4) {
         component.x = (component.rawX * parentWidth >> 14) + (parentWidth - component.width) / 2;
      } else {
         component.x = parentWidth - component.width - (component.rawX * parentWidth >> 14);
      }

      if (component.yAlignment == 0) {
         component.y = component.rawY;
      } else if (component.yAlignment == 1) {
         component.y = (parentHeight - component.height) / 2 + component.rawY;
      } else if (component.yAlignment == 2) {
         component.y = parentHeight - component.height - component.rawY;
      } else if (component.yAlignment == 3) {
         component.y = parentHeight * component.rawY >> 14;
      } else if (component.yAlignment == 4) {
         component.y = (parentHeight * component.rawY >> 14) + (parentHeight - component.height) / 2;
      } else {
         component.y = parentHeight - component.height - (parentHeight * component.rawY >> 14);
      }

   }

   static {
      FloorOverlayDefinition_cached = new EvictingDualNodeHashTable(64);
   }
}
