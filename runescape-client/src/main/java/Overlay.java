import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("overlay_ref")
   public static IndexDataBase overlay_ref;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("overlays")
   public static NodeCache overlays;
   @ObfuscatedName("lk")
   @ObfuscatedSignature(
      signature = "[Lim;"
   )
   static Widget[] field3668;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1809396319
   )
   @Export("color")
   public int color;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1950445937
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("a")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1756379827
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1714402389
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2089730415
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 710033863
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1938146717
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2074025567
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -685968489
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "563432370"
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "2127662599"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.readNext(var1, var3, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgn;IIB)V",
      garbageValue = "9"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2, int var3) {
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2142645492"
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

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
      this.saturation = (int)(var14 * 256.0D);
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

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(Lim;Ljx;IIZI)V",
      garbageValue = "341193127"
   )
   static final void method5124(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         String var9 = BoundingBox3D.getColTags(16748608) + var1.name;
         int var11 = var1.id;
         int var13 = var0.id;
         if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var7;
            Client.menuTargets[Client.menuOptionCount] = var9;
            Client.menuTypes[Client.menuOptionCount] = var6;
            Client.menuIdentifiers[Client.menuOptionCount] = var11;
            Client.menuActionParams0[Client.menuOptionCount] = var2;
            Client.menuActionParams1[Client.menuOptionCount] = var13;
            Client.menuBooleanArray[Client.menuOptionCount] = var4;
            ++Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "386265616"
   )
   static void method5126(int var0) {
      for(IntegerNode var1 = (IntegerNode)Client.widgetFlags.first(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.next()) {
         if((var1.hash >> 48 & 65535L) == (long)var0) {
            var1.unlink();
         }
      }

   }
}
