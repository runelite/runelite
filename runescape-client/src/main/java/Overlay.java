import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1248867507
   )
   public int field3019;
   @ObfuscatedName("y")
   public static NodeCache field3020 = new NodeCache(64);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2146382999
   )
   @Export("color")
   public int color = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 968529147
   )
   @Export("texture")
   public int texture = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1933968691
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1911094299
   )
   public int field3024 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1730604227
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1476421681
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("w")
   @Export("isHidden")
   public boolean isHidden = true;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1618840615
   )
   public int field3028;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 618887425
   )
   public int field3029;
   @ObfuscatedName("k")
   public static class182 field3030;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1302056181"
   )
   public void method3735() {
      if(this.field3024 != -1) {
         this.method3736(this.field3024);
         this.field3019 = this.hue;
         this.field3028 = this.saturation;
         this.field3029 = this.lightness;
      }

      this.method3736(this.color);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-73"
   )
   void method3736(int var1) {
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
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "-43"
   )
   void method3737(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3024 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2001545091"
   )
   public void method3739(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3737(var1, var3, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Lclass30;",
      garbageValue = "1"
   )
   static class30 method3741() {
      FileOnDisk var0 = null;
      class30 var1 = new class30();

      try {
         var0 = Client.method610("", MessageNode.field229.field2675, false);
         byte[] var2 = new byte[(int)var0.method1420()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method1421(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new class30(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method1419();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;I)Ljava/lang/String;",
      garbageValue = "-306417532"
   )
   public static String method3751(CharSequence var0, class228 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var11 = var3 - var2;
         if(var11 >= 1) {
            byte var6;
            if(null == var1) {
               var6 = 12;
            } else {
               switch(var1.field3242) {
               case 2:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var11 <= var6) {
               StringBuilder var10 = new StringBuilder(var11);

               for(int var12 = var2; var12 < var3; ++var12) {
                  char var7 = var0.charAt(var12);
                  if(class153.method2863(var7)) {
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
                        var10.append(var8);
                     }
                  }
               }

               if(var10.length() == 0) {
                  return null;
               }

               return var10.toString();
            }
         }

         return null;
      }
   }
}
