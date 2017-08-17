import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("underlays")
   static NodeCache underlays;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("underlay_ref")
   static IndexDataBase underlay_ref;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1767930221
   )
   @Export("rgbColor")
   int rgbColor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 647397733
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -515530055
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1854527535
   )
   @Export("hueMultiplier")
   public int hueMultiplier;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 934877127
   )
   @Export("lightness")
   public int lightness;

   static {
      underlays = new NodeCache(64);
   }

   FloorUnderlayDefinition() {
      this.rgbColor = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "778818672"
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
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
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

      if(var16 > 0.5D) {
         this.hueMultiplier = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.hueMultiplier = (int)(var16 * var14 * 512.0D);
      }

      if(this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)((double)this.hueMultiplier * var12);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfb;IIB)V",
      garbageValue = "-87"
   )
   @Export("decode")
   void decode(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgbColor = var1.read24BitInt();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-938036590"
   )
   @Export("post")
   void post() {
      this.setHSL(this.rgbColor);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "-2131347926"
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lkd;I)Ljava/lang/String;",
      garbageValue = "-1564082992"
   )
   public static String method4398(CharSequence var0, class290 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && IndexDataBase.method4213(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && IndexDataBase.method4213(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= class208.method3878(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               if(ISAACCipher.method3455(var7)) {
                  char var8;
                  switch(var7) {
                  case ' ':
                  case '-':
                  case '_':
                  case ' ':
                     var8 = 95;
                     break;
                  case '#':
                  case '[':
                  case ']':
                     var8 = var7;
                     break;
                  case 'À':
                  case 'Á':
                  case 'Â':
                  case 'Ã':
                  case 'Ä':
                  case 'à':
                  case 'á':
                  case 'â':
                  case 'ã':
                  case 'ä':
                     var8 = 97;
                     break;
                  case 'Ç':
                  case 'ç':
                     var8 = 99;
                     break;
                  case 'È':
                  case 'É':
                  case 'Ê':
                  case 'Ë':
                  case 'è':
                  case 'é':
                  case 'ê':
                  case 'ë':
                     var8 = 101;
                     break;
                  case 'Í':
                  case 'Î':
                  case 'Ï':
                  case 'í':
                  case 'î':
                  case 'ï':
                     var8 = 105;
                     break;
                  case 'Ñ':
                  case 'ñ':
                     var8 = 110;
                     break;
                  case 'Ò':
                  case 'Ó':
                  case 'Ô':
                  case 'Õ':
                  case 'Ö':
                  case 'ò':
                  case 'ó':
                  case 'ô':
                  case 'õ':
                  case 'ö':
                     var8 = 111;
                     break;
                  case 'Ù':
                  case 'Ú':
                  case 'Û':
                  case 'Ü':
                  case 'ù':
                  case 'ú':
                  case 'û':
                  case 'ü':
                     var8 = 117;
                     break;
                  case 'ß':
                     var8 = 98;
                     break;
                  case 'ÿ':
                  case 'Ÿ':
                     var8 = 121;
                     break;
                  default:
                     var8 = Character.toLowerCase(var7);
                  }

                  if(var8 != 0) {
                     var5.append(var8);
                  }
               }
            }

            if(var5.length() == 0) {
               return null;
            } else {
               return var5.toString();
            }
         } else {
            return null;
         }
      }
   }
}
