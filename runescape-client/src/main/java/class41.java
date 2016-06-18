import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class41 extends class204 {
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -890932397
   )
   static int field951;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1726142009
   )
   int field952 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1982819181
   )
   public int field953;
   @ObfuscatedName("n")
   static int[] field954;
   @ObfuscatedName("g")
   public static class193 field955 = new class193(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1602046025
   )
   public int field956;
   @ObfuscatedName("l")
   static int[][] field957;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1631367599
   )
   public int field958;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1655770693
   )
   public int field960;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1707594858"
   )
   public void method847(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2514();
         if(var3 == 0) {
            return;
         }

         this.method848(var1, var3, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIB)V",
      garbageValue = "-81"
   )
   void method848(class119 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field952 = var1.method2518();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "84615137"
   )
   void method849(int var1) {
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

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field958 = (int)(256.0D * var14);
      this.field960 = (int)(256.0D * var16);
      if(this.field958 < 0) {
         this.field958 = 0;
      } else if(this.field958 > 255) {
         this.field958 = 255;
      }

      if(this.field960 < 0) {
         this.field960 = 0;
      } else if(this.field960 > 255) {
         this.field960 = 255;
      }

      if(var16 > 0.5D) {
         this.field956 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field956 = (int)(var16 * var14 * 512.0D);
      }

      if(this.field956 < 1) {
         this.field956 = 1;
      }

      this.field953 = (int)(var12 * (double)this.field956);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "452453342"
   )
   public void method855() {
      this.method849(this.field952);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIBI)V",
      garbageValue = "-2072227561"
   )
   static final void method861(class2 var0, int var1, int var2, byte var3) {
      int var4 = var0.field844[0];
      int var5 = var0.field831[0];
      int var6 = var0.method14();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.method14();
            client.field394.field1864 = var1;
            client.field394.field1861 = var2;
            client.field394.field1860 = 1;
            client.field394.field1862 = 1;
            class10 var9 = client.field394;
            class10 var10 = var9;
            class108 var11 = client.field291[var0.field47];
            int[] var12 = client.field567;
            int[] var13 = client.field469;

            int var14;
            int var15;
            for(var14 = 0; var14 < 128; ++var14) {
               for(var15 = 0; var15 < 128; ++var15) {
                  class106.field1853[var14][var15] = 0;
                  class106.field1851[var14][var15] = 99999999;
               }
            }

            int var16;
            int var17;
            byte var19;
            int var20;
            int var21;
            int var23;
            int var25;
            int var26;
            int var27;
            boolean var34;
            int var36;
            int var37;
            int var39;
            if(var8 == 1) {
               var16 = var4;
               var17 = var5;
               byte var18 = 64;
               var19 = 64;
               var20 = var4 - var18;
               var21 = var5 - var19;
               class106.field1853[var18][var19] = 99;
               class106.field1851[var18][var19] = 0;
               byte var22 = 0;
               var23 = 0;
               class106.field1856[var22] = var4;
               var39 = var22 + 1;
               class106.field1857[var22] = var5;
               int[][] var33 = var11.field1884;

               boolean var35;
               while(true) {
                  if(var23 == var39) {
                     class15.field219 = var16;
                     class45.field1023 = var17;
                     var35 = false;
                     break;
                  }

                  var16 = class106.field1856[var23];
                  var17 = class106.field1857[var23];
                  var23 = 1 + var23 & 4095;
                  var36 = var16 - var20;
                  var37 = var17 - var21;
                  var25 = var16 - var11.field1880;
                  var26 = var17 - var11.field1873;
                  if(var10.vmethod2385(1, var16, var17, var11)) {
                     class15.field219 = var16;
                     class45.field1023 = var17;
                     var35 = true;
                     break;
                  }

                  var27 = class106.field1851[var36][var37] + 1;
                  if(var36 > 0 && class106.field1853[var36 - 1][var37] == 0 && (var33[var25 - 1][var26] & 19136776) == 0) {
                     class106.field1856[var39] = var16 - 1;
                     class106.field1857[var39] = var17;
                     var39 = var39 + 1 & 4095;
                     class106.field1853[var36 - 1][var37] = 2;
                     class106.field1851[var36 - 1][var37] = var27;
                  }

                  if(var36 < 127 && class106.field1853[var36 + 1][var37] == 0 && (var33[1 + var25][var26] & 19136896) == 0) {
                     class106.field1856[var39] = var16 + 1;
                     class106.field1857[var39] = var17;
                     var39 = var39 + 1 & 4095;
                     class106.field1853[1 + var36][var37] = 8;
                     class106.field1851[var36 + 1][var37] = var27;
                  }

                  if(var37 > 0 && class106.field1853[var36][var37 - 1] == 0 && (var33[var25][var26 - 1] & 19136770) == 0) {
                     class106.field1856[var39] = var16;
                     class106.field1857[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class106.field1853[var36][var37 - 1] = 1;
                     class106.field1851[var36][var37 - 1] = var27;
                  }

                  if(var37 < 127 && class106.field1853[var36][var37 + 1] == 0 && (var33[var25][1 + var26] & 19136800) == 0) {
                     class106.field1856[var39] = var16;
                     class106.field1857[var39] = 1 + var17;
                     var39 = 1 + var39 & 4095;
                     class106.field1853[var36][1 + var37] = 4;
                     class106.field1851[var36][var37 + 1] = var27;
                  }

                  if(var36 > 0 && var37 > 0 && class106.field1853[var36 - 1][var37 - 1] == 0 && (var33[var25 - 1][var26 - 1] & 19136782) == 0 && (var33[var25 - 1][var26] & 19136776) == 0 && (var33[var25][var26 - 1] & 19136770) == 0) {
                     class106.field1856[var39] = var16 - 1;
                     class106.field1857[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class106.field1853[var36 - 1][var37 - 1] = 3;
                     class106.field1851[var36 - 1][var37 - 1] = var27;
                  }

                  if(var36 < 127 && var37 > 0 && class106.field1853[var36 + 1][var37 - 1] == 0 && (var33[1 + var25][var26 - 1] & 19136899) == 0 && (var33[var25 + 1][var26] & 19136896) == 0 && (var33[var25][var26 - 1] & 19136770) == 0) {
                     class106.field1856[var39] = var16 + 1;
                     class106.field1857[var39] = var17 - 1;
                     var39 = 1 + var39 & 4095;
                     class106.field1853[1 + var36][var37 - 1] = 9;
                     class106.field1851[var36 + 1][var37 - 1] = var27;
                  }

                  if(var36 > 0 && var37 < 127 && class106.field1853[var36 - 1][var37 + 1] == 0 && (var33[var25 - 1][var26 + 1] & 19136824) == 0 && (var33[var25 - 1][var26] & 19136776) == 0 && (var33[var25][1 + var26] & 19136800) == 0) {
                     class106.field1856[var39] = var16 - 1;
                     class106.field1857[var39] = 1 + var17;
                     var39 = 1 + var39 & 4095;
                     class106.field1853[var36 - 1][var37 + 1] = 6;
                     class106.field1851[var36 - 1][var37 + 1] = var27;
                  }

                  if(var36 < 127 && var37 < 127 && class106.field1853[var36 + 1][var37 + 1] == 0 && (var33[var25 + 1][var26 + 1] & 19136992) == 0 && (var33[var25 + 1][var26] & 19136896) == 0 && (var33[var25][var26 + 1] & 19136800) == 0) {
                     class106.field1856[var39] = 1 + var16;
                     class106.field1857[var39] = 1 + var17;
                     var39 = 1 + var39 & 4095;
                     class106.field1853[1 + var36][var37 + 1] = 12;
                     class106.field1851[var36 + 1][var37 + 1] = var27;
                  }
               }

               var34 = var35;
            } else if(var8 == 2) {
               var34 = class26.method637(var4, var5, var9, var11);
            } else {
               var34 = class32.method718(var4, var5, var8, var9, var11);
            }

            int var7;
            label424: {
               var15 = var4 - 64;
               var16 = var5 - 64;
               var17 = class15.field219;
               var36 = class45.field1023;
               if(!var34) {
                  var37 = Integer.MAX_VALUE;
                  var20 = Integer.MAX_VALUE;
                  byte var38 = 10;
                  var39 = var10.field1864;
                  var23 = var10.field1861;
                  int var24 = var10.field1860;
                  var25 = var10.field1862;

                  for(var26 = var39 - var38; var26 <= var38 + var39; ++var26) {
                     for(var27 = var23 - var38; var27 <= var38 + var23; ++var27) {
                        int var28 = var26 - var15;
                        int var29 = var27 - var16;
                        if(var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class106.field1851[var28][var29] < 100) {
                           int var30 = 0;
                           if(var26 < var39) {
                              var30 = var39 - var26;
                           } else if(var26 > var39 + var24 - 1) {
                              var30 = var26 - (var24 + var39 - 1);
                           }

                           int var31 = 0;
                           if(var27 < var23) {
                              var31 = var23 - var27;
                           } else if(var27 > var25 + var23 - 1) {
                              var31 = var27 - (var23 + var25 - 1);
                           }

                           int var32 = var31 * var31 + var30 * var30;
                           if(var32 < var37 || var37 == var32 && class106.field1851[var28][var29] < var20) {
                              var37 = var32;
                              var20 = class106.field1851[var28][var29];
                              var17 = var26;
                              var36 = var27;
                           }
                        }
                     }
                  }

                  if(var37 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label424;
                  }
               }

               if(var17 == var4 && var5 == var36) {
                  var7 = 0;
               } else {
                  var19 = 0;
                  class106.field1856[var19] = var17;
                  var37 = var19 + 1;
                  class106.field1857[var19] = var36;

                  for(var20 = var21 = class106.field1853[var17 - var15][var36 - var16]; var17 != var4 || var5 != var36; var20 = class106.field1853[var17 - var15][var36 - var16]) {
                     if(var20 != var21) {
                        var21 = var20;
                        class106.field1856[var37] = var17;
                        class106.field1857[var37++] = var36;
                     }

                     if((var20 & 2) != 0) {
                        ++var17;
                     } else if((var20 & 8) != 0) {
                        --var17;
                     }

                     if((var20 & 1) != 0) {
                        ++var36;
                     } else if((var20 & 4) != 0) {
                        --var36;
                     }
                  }

                  var39 = 0;

                  while(var37-- > 0) {
                     var12[var39] = class106.field1856[var37];
                     var13[var39++] = class106.field1857[var37];
                     if(var39 >= var12.length) {
                        break;
                     }
                  }

                  var7 = var39;
               }
            }

            var14 = var7;
            if(var7 >= 1) {
               for(var15 = 0; var15 < var14 - 1; ++var15) {
                  var0.method18(client.field567[var15], client.field469[var15], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1825292374"
   )
   public static int method863(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass8;",
      garbageValue = "1808837977"
   )
   static class8 method864() {
      class227 var0 = null;
      class8 var1 = new class8();

      try {
         var0 = class139.method2974("", client.field570.field2274, false);
         byte[] var2 = new byte[(int)var0.method4113()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method4118(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new class8(new class119(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(null != var0) {
            var0.method4116();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }
}
