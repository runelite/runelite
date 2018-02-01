import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("overlay_ref")
   public static IndexDataBase overlay_ref;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("overlays")
   public static NodeCache overlays;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1181177553
   )
   @Export("color")
   public int color;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1594759351
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("j")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2075441539
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1729927029
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1413205473
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -257064049
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -321047931
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1126686797
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1122977825
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
      garbageValue = "11"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "-805548802"
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgj;III)V",
      garbageValue = "1825322766"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-616519125"
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
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
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

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1879848765"
   )
   public static void method4939() {
      class262.field3445.reset();
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "([Lho;IB)V",
      garbageValue = "-52"
   )
   static final void method4945(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method4945(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(class213.loadWidget(var5)) {
                     method4945(FileRequest.widgets[var5], var1);
                  }
               }
            }

            ScriptEvent var6;
            if(var1 == 0 && var3.field2821 != null) {
               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.objs = var3.field2821;
               class87.method1851(var6);
            }

            if(var1 == 1 && var3.field2771 != null) {
               if(var3.index >= 0) {
                  Widget var7 = class35.getWidget(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var3 != var7.children[var3.index]) {
                     continue;
                  }
               }

               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.objs = var3.field2771;
               class87.method1851(var6);
            }
         }
      }

   }
}
