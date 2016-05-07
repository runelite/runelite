import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class121 {
   @ObfuscatedName("d")
   static byte[][] field2011 = new byte[250][];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -431885243
   )
   static int field2012 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2039696303
   )
   static int field2013 = 0;
   @ObfuscatedName("x")
   static byte[][] field2014 = new byte[1000][];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 113019223
   )
   static int field2015 = 0;
   @ObfuscatedName("o")
   static class78 field2016;
   @ObfuscatedName("u")
   static byte[][] field2017 = new byte[50][];
   @ObfuscatedName("ph")
   static Clipboard field2019;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-553318945"
   )
   static final int method2728(int var0, int var1) {
      int var2 = 57 * var1 + var0;
      var2 ^= var2 << 13;
      int var3 = var2 * (15731 * var2 * var2 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "1"
   )
   public static int method2729(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(45 == var8) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IS)[B",
      garbageValue = "395"
   )
   static synchronized byte[] method2730(int var0) {
      byte[] var1;
      if(var0 == 100 && field2015 > 0) {
         var1 = field2014[--field2015];
         field2014[field2015] = null;
         return var1;
      } else if(var0 == 5000 && field2012 > 0) {
         var1 = field2011[--field2012];
         field2011[field2012] = null;
         return var1;
      } else if(var0 == 30000 && field2013 > 0) {
         var1 = field2017[--field2013];
         field2017[field2013] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(Lclass173;II)I",
      garbageValue = "164401714"
   )
   static final int method2733(class173 var0, int var1) {
      if(var0.field2809 != null && var1 < var0.field2809.length) {
         try {
            int[] var2 = var0.field2809[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = client.field399[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.field415[var2[var4++]];
               }

               if(3 == var6) {
                  var7 = client.field427[var2[var4++]];
               }

               int var9;
               class173 var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class29.method645(var9);
                  var11 = var2[var4++];
                  if(-1 != var11 && (!class9.method128(var11).field1129 || client.field447)) {
                     for(var12 = 0; var12 < var10.field2883.length; ++var12) {
                        if(1 + var11 == var10.field2883[var12]) {
                           var7 += var10.field2884[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class176.field2920[var2[var4++]];
               }

               if(6 == var6) {
                  var7 = class155.field2301[client.field415[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class176.field2920[var2[var4++]] * 100 / '뜛';
               }

               if(8 == var6) {
                  var7 = class106.field1881.field39;
               }

               if(9 == var6) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class155.field2302[var9]) {
                        var7 += client.field415[var9];
                     }
                  }
               }

               if(10 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class29.method645(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class9.method128(var11).field1129 || client.field447)) {
                     for(var12 = 0; var12 < var10.field2883.length; ++var12) {
                        if(var10.field2883[var12] == 1 + var11) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(11 == var6) {
                  var7 = client.field301;
               }

               if(var6 == 12) {
                  var7 = client.field437;
               }

               if(13 == var6) {
                  var9 = class176.field2920[var2[var4++]];
                  int var14 = var2[var4++];
                  var7 = 0 != (var9 & 1 << var14)?1:0;
               }

               if(14 == var6) {
                  var9 = var2[var4++];
                  var7 = class32.method691(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(16 == var6) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(18 == var6) {
                  var7 = (class106.field1881.field823 >> 7) + class22.field594;
               }

               if(var6 == 19) {
                  var7 = class114.field1981 + (class106.field1881.field813 >> 7);
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(0 == var8) {
                  if(0 == var5) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(2 == var5 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(3 == var5) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var13) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "42"
   )
   static String method2734(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1250368709"
   )
   static final int method2735(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
