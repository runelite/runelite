import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class137 {
   @ObfuscatedName("c")
   byte[] field1908;
   @ObfuscatedName("cr")
   static Font field1909;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1572266383
   )
   int field1910;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1314513865
   )
   int field1911;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -19506519
   )
   int field1912;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -336707389
   )
   int field1913;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1992976661
   )
   int field1914;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 715956353
   )
   int field1915;
   @ObfuscatedName("s")
   byte[] field1916;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1047343577
   )
   int field1917;
   @ObfuscatedName("dg")
   static byte[][] field1918;
   @ObfuscatedName("ec")
   static ModIcon[] field1920;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;B)Ljava/lang/String;",
      garbageValue = "-117"
   )
   public static String method2397(CharSequence var0, class228 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class185.method3298(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class185.method3298(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= Friend.method153(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else {
                  boolean var9 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                  if(var9) {
                     var8 = true;
                  } else {
                     char[] var10 = class204.field3084;
                     int var11 = 0;

                     label120:
                     while(true) {
                        char var12;
                        if(var11 >= var10.length) {
                           var10 = class204.field3083;

                           for(var11 = 0; var11 < var10.length; ++var11) {
                              var12 = var10[var11];
                              if(var12 == var7) {
                                 var8 = true;
                                 break label120;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var12 = var10[var11];
                        if(var12 == var7) {
                           var8 = true;
                           break;
                        }

                        ++var11;
                     }
                  }
               }

               if(var8) {
                  char var14;
                  switch(var7) {
                  case ' ':
                  case '-':
                  case '_':
                  case ' ':
                     var14 = 95;
                     break;
                  case '#':
                  case '[':
                  case ']':
                     var14 = var7;
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
                     var14 = 97;
                     break;
                  case 'Ç':
                  case 'ç':
                     var14 = 99;
                     break;
                  case 'È':
                  case 'É':
                  case 'Ê':
                  case 'Ë':
                  case 'è':
                  case 'é':
                  case 'ê':
                  case 'ë':
                     var14 = 101;
                     break;
                  case 'Í':
                  case 'Î':
                  case 'Ï':
                  case 'í':
                  case 'î':
                  case 'ï':
                     var14 = 105;
                     break;
                  case 'Ñ':
                  case 'ñ':
                     var14 = 110;
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
                     var14 = 111;
                     break;
                  case 'Ù':
                  case 'Ú':
                  case 'Û':
                  case 'Ü':
                  case 'ù':
                  case 'ú':
                  case 'û':
                  case 'ü':
                     var14 = 117;
                     break;
                  case 'ß':
                     var14 = 98;
                     break;
                  case 'ÿ':
                  case 'Ÿ':
                     var14 = 121;
                     break;
                  default:
                     var14 = Character.toLowerCase(var7);
                  }

                  if(var14 != 0) {
                     var5.append(var14);
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIIS)V",
      garbageValue = "180"
   )
   static final void method2398(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class10.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class10.tileHeights[0][var2];
                  int var11 = 932731 + var2 + var4;
                  int var12 = var5 + var3 + 556238;
                  int var13 = class138.method2411(var11 + '넵', var12 + 91923, 4) - 128 + (class138.method2411(10294 + var11, '鎽' + var12, 2) - 128 >> 1) + (class138.method2411(var11, var12, 1) - 128 >> 2);
                  var13 = (int)(0.3D * (double)var13) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = 8 * -var13;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 8 * var14;
               }
               break;
            }

            if(var7 <= 49) {
               class10.overlayIds[var1][var2][var3] = var0.readByte();
               class20.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class10.overlayRotations[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class10.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               ChatLineBuffer.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }
}
