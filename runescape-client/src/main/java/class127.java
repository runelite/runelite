import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class127 {
   @ObfuscatedName("de")
   static byte[][] field2086;

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1842591018"
   )
   static final void method2930(int var0) {
      int[] var1 = class23.field619.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 24628 + (103 - var3) * 2048;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class5.tileSettings[var0][var5][var3] & 24) == 0) {
               class136.region.method2025(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class5.tileSettings[1 + var0][var5][var3] & 8) != 0) {
               class136.region.method2025(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class23.field619.method1796();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class5.tileSettings[var0][var6][var5] & 24) == 0) {
               class54.method1154(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class5.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class54.method1154(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field524 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class136.region.method2014(VertexNormal.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class160.getObjectDefinition(var7).field957;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var11 = Client.collisionMaps[VertexNormal.plane].flags;

                     for(int var12 = 0; var12 < 10; ++var12) {
                        int var13 = (int)(Math.random() * 4.0D);
                        if(var13 == 0 && var9 > 0 && var9 > var5 - 3 && (var11[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var13 == 1 && var9 < 103 && var9 < 3 + var5 && (var11[1 + var9][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var13 == 2 && var10 > 0 && var10 > var6 - 3 && (var11[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var13 == 3 && var10 < 103 && var10 < 3 + var6 && (var11[var9][var10 + 1] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field453[Client.field524] = class50.field1121[var8];
                  Client.field525[Client.field524] = var9;
                  Client.field526[Client.field524] = var10;
                  ++Client.field524;
               }
            }
         }
      }

      class54.bufferProvider.method1787();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "800805525"
   )
   public static int method2935(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if(var7 == 8218) {
               var3[var4 + var6] = -126;
            } else if(var7 == 402) {
               var3[var4 + var6] = -125;
            } else if(var7 == 8222) {
               var3[var6 + var4] = -124;
            } else if(var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if(var7 == 8224) {
               var3[var4 + var6] = -122;
            } else if(var7 == 8225) {
               var3[var6 + var4] = -121;
            } else if(var7 == 710) {
               var3[var4 + var6] = -120;
            } else if(var7 == 8240) {
               var3[var6 + var4] = -119;
            } else if(var7 == 352) {
               var3[var4 + var6] = -118;
            } else if(var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if(var7 == 338) {
               var3[var6 + var4] = -116;
            } else if(var7 == 381) {
               var3[var4 + var6] = -114;
            } else if(var7 == 8216) {
               var3[var4 + var6] = -111;
            } else if(var7 == 8217) {
               var3[var6 + var4] = -110;
            } else if(var7 == 8220) {
               var3[var4 + var6] = -109;
            } else if(var7 == 8221) {
               var3[var4 + var6] = -108;
            } else if(var7 == 8226) {
               var3[var6 + var4] = -107;
            } else if(var7 == 8211) {
               var3[var4 + var6] = -106;
            } else if(var7 == 8212) {
               var3[var4 + var6] = -105;
            } else if(var7 == 732) {
               var3[var4 + var6] = -104;
            } else if(var7 == 8482) {
               var3[var4 + var6] = -103;
            } else if(var7 == 353) {
               var3[var6 + var4] = -102;
            } else if(var7 == 8250) {
               var3[var6 + var4] = -101;
            } else if(var7 == 339) {
               var3[var6 + var4] = -100;
            } else if(var7 == 382) {
               var3[var6 + var4] = -98;
            } else if(var7 == 376) {
               var3[var4 + var6] = -97;
            } else {
               var3[var4 + var6] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1713170913"
   )
   static final int method2936(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class5.tileHeights[var5][1 + var3][var4] * var6 + class5.tileHeights[var5][var3][var4] * (128 - var6) >> 7;
         int var9 = class5.tileHeights[var5][var3][1 + var4] * (128 - var6) + class5.tileHeights[var5][var3 + 1][1 + var4] * var6 >> 7;
         return var8 * (128 - var7) + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }
}
