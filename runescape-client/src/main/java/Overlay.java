import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("overlays")
   static NodeCache overlays;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("overlay_ref")
   static IndexDataBase overlay_ref;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1283836339
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1097205427
   )
   @Export("color")
   public int color;
   @ObfuscatedName("q")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 744145829
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1227358129
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 129401975
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 845149713
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 113415595
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1601706513
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 752589427
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
      signature = "(Lfg;III)V",
      garbageValue = "969751690"
   )
   void method4771(Buffer var1, int var2, int var3) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "782993082"
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
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1260444866"
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "-613105267"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4771(var1, var3, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1534544112"
   )
   static int method4776() {
      return ++class96.field1510 - 1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1939606464"
   )
   static final void method4778(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      ScriptVarType.method19(var7, var9, var8, var10, -49088);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1865294034"
   )
   public static boolean method4773(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
