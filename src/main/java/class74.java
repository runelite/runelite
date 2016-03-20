import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class74 {
   @ObfuscatedName("e")
   int[][] field1365;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 333058337
   )
   int field1366;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -230807433
   )
   int field1368;

   public class74(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class16.method204(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1366 = var1;
         this.field1368 = var2;
         this.field1365 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1365[var4];
            double var6 = (double)var4 / (double)var1 + 6.0D;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = ((double)var8 - var6) * 3.141592653589793D;
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("r")
   int method1627(int var1) {
      if(null != this.field1365) {
         var1 = (int)((long)var1 * (long)this.field1368 / (long)this.field1366);
      }

      return var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "2"
   )
   static final void method1628(boolean var0) {
      for(int var1 = 0; var1 < client.field331; ++var1) {
         class34 var2 = client.field358[client.field564[var1]];
         int var3 = (client.field564[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod755() && var2.field785.field903 == var0 && var2.field785.method775()) {
            int var4 = var2.field870 >> 7;
            int var5 = var2.field813 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(1 == var2.field816 && 64 == (var2.field870 & 127) && 64 == (var2.field813 & 127)) {
                  if(client.field398[var4][var5] == client.field399) {
                     continue;
                  }

                  client.field398[var4][var5] = client.field399;
               }

               if(!var2.field785.field889) {
                  var3 -= Integer.MIN_VALUE;
               }

               class77.field1396.method1968(class48.field1078, var2.field870, var2.field813, class4.method52(var2.field870 + (var2.field816 * 64 - 64), var2.field816 * 64 - 64 + var2.field813, class48.field1078), var2.field816 * 64 - 64 + 60, var2, var2.field814, var3, var2.field815);
            }
         }
      }

   }

   @ObfuscatedName("f")
   int method1631(int var1) {
      if(null != this.field1365) {
         var1 = (int)((long)this.field1368 * (long)var1 / (long)this.field1366) + 6;
      }

      return var1;
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   static final void method1635(int var0) {
      if(class103.method2303(var0)) {
         class172[] var1 = class172.field2850[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class172 var3 = var1[var2];
            if(null != var3) {
               var3.field2808 = 0;
               var3.field2864 = 0;
            }
         }

      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "([Lclass172;II)V",
      garbageValue = "-548944945"
   )
   static final void method1636(class172[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class172 var3 = var0[var2];
         if(var3 != null && var1 == var3.field2762 && (!var3.field2742 || !class112.method2447(var3))) {
            int var5;
            if(var3.field2764 == 0) {
               if(!var3.field2742 && class112.method2447(var3) && var3 != class188.field3039) {
                  continue;
               }

               method1636(var0, var3.field2800 * -1);
               if(var3.field2865 != null) {
                  method1636(var3.field2865, var3.field2800 * -1);
               }

               class3 var4 = (class3)client.field454.method3824((long)(var3.field2800 * -1));
               if(null != var4) {
                  var5 = var4.field56;
                  if(class103.method2303(var5)) {
                     method1636(class172.field2850[var5], -1);
                  }
               }
            }

            if(var3.field2764 == 6) {
               if(-1 != var3.field2788 || var3.field2789 != -1) {
                  boolean var7 = class92.method2181(var3);
                  if(var7) {
                     var5 = var3.field2789;
                  } else {
                     var5 = var3.field2788;
                  }

                  if(-1 != var5) {
                     class42 var6 = class134.method2875(var5);

                     for(var3.field2864 += client.field409; var3.field2864 > var6.field990[var3.field2808]; class36.method745(var3)) {
                        var3.field2864 -= var6.field990[var3.field2808];
                        ++var3.field2808;
                        if(var3.field2808 >= var6.field988.length) {
                           var3.field2808 -= var6.field1000 * -1;
                           if(var3.field2808 < 0 || var3.field2808 >= var6.field988.length) {
                              var3.field2808 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2797 != 0 && !var3.field2742) {
                  int var8 = var3.field2797 >> 16;
                  var5 = var3.field2797 << 16 >> 16;
                  var8 *= client.field409;
                  var5 *= client.field409;
                  var3.field2792 = var8 + var3.field2792 & 2047;
                  var3.field2802 = var5 + var3.field2802 & 2047;
                  class36.method745(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   public static class78[] method1637(class166 var0, String var1, String var2) {
      int var3 = var0.method3278(var1);
      int var4 = var0.method3328(var3, var2);
      class78[] var5;
      if(!class12.method176(var0, var3, var4)) {
         var5 = null;
      } else {
         class78[] var7 = new class78[class76.field1385];

         for(int var8 = 0; var8 < class76.field1385; ++var8) {
            class78 var9 = var7[var8] = new class78();
            var9.field1402 = class76.field1379;
            var9.field1403 = class76.field1381;
            var9.field1400 = class76.field1386[var8];
            var9.field1405 = class76.field1382[var8];
            var9.field1399 = class102.field1764[var8];
            var9.field1401 = class76.field1383[var8];
            int var10 = var9.field1401 * var9.field1399;
            byte[] var11 = class30.field708[var8];
            var9.field1397 = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.field1397[var12] = class115.field1968[var11[var12] & 255];
            }
         }

         class1.method7();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("a")
   byte[] method1638(byte[] var1) {
      if(null != this.field1365) {
         int var2 = (int)((long)var1.length * (long)this.field1368 / (long)this.field1366) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1365[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1368;
            var9 = var5 / this.field1366;
            var4 += var9;
            var5 -= var9 * this.field1366;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = '耀' + var3[var6] >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("cz")
   static final String method1639(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class51.method1090('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class51.method1090(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class51.method1090(16776960) + var1 + "</col>");
   }
}
