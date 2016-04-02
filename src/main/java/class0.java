import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class0 extends class208 {
   @ObfuscatedName("w")
   boolean field0;
   @ObfuscatedName("f")
   class173 field2;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1382700925
   )
   int field3;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1394121189
   )
   int field4;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1423735111
   )
   int field5;
   @ObfuscatedName("g")
   class173 field6;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 51585699
   )
   int field7;
   @ObfuscatedName("l")
   static String field8;
   @ObfuscatedName("k")
   String field9;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 853361417
   )
   int field10;
   @ObfuscatedName("e")
   Object[] field11;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 267390873
   )
   @Export("cameraZ")
   static int field12;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1314496523
   )
   int field16;
   @ObfuscatedName("ms")
   static byte field17;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2054969986"
   )
   static final void method0(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class5.field90[var0][var1 + var3][var2 + var4] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.field90[var0][var1][var2 + var3] = class5.field90[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.field90[var0][var1 + var3][var2] = class5.field90[var0][var1 + var3][var2 - 1];
         }
      }

      if(var1 > 0 && class5.field90[var0][var1 - 1][var2] != 0) {
         class5.field90[var0][var1][var2] = class5.field90[var0][var1 - 1][var2];
      } else if(var2 > 0 && class5.field90[var0][var1][var2 - 1] != 0) {
         class5.field90[var0][var1][var2] = class5.field90[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class5.field90[var0][var1 - 1][var2 - 1] != 0) {
         class5.field90[var0][var1][var2] = class5.field90[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass86;Lclass108;B)V",
      garbageValue = "10"
   )
   static final void method1(int var0, int var1, int var2, int var3, int var4, int var5, class86 var6, class108 var7) {
      if(!client.field285 || (class5.field80[0][var1][var2] & 2) != 0 || (class5.field80[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field81) {
            class5.field81 = var0;
         }

         class40 var8 = class26.method633(var3);
         int var9;
         int var10;
         if(1 != var4 && var4 != 3) {
            var9 = var8.field908;
            var10 = var8.field915;
         } else {
            var9 = var8.field915;
            var10 = var8.field908;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (1 + var9 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var2 + var10 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = (var10 + 1 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class5.field90[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = var1 + (var2 << 7) + (var3 << 14) + 1073741824;
         if(var8.field922 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(1 == var8.field948) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method823()) {
            class23 var21 = new class23();
            var21.field589 = var0;
            var21.field590 = var1 * 128;
            var21.field597 = var2 * 128;
            var22 = var8.field908;
            var23 = var8.field915;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.field915;
               var23 = var8.field908;
            }

            var21.field592 = (var22 + var1) * 128;
            var21.field593 = (var23 + var2) * 128;
            var21.field588 = var8.field943;
            var21.field594 = var8.field935 * 128;
            var21.field600 = var8.field937;
            var21.field598 = var8.field946;
            var21.field599 = var8.field947;
            if(var8.field923 != null) {
               var21.field602 = var8;
               var21.method587();
            }

            class23.field601.method3834(var21);
            if(null != var21.field599) {
               var21.field595 = var21.field600 + (int)(Math.random() * (double)(var21.field598 - var21.field600));
            }
         }

         Object var26;
         if(22 == var5) {
            if(!client.field285 || var8.field922 != 0 || var8.field924 == 1 || var8.field940) {
               if(var8.field938 == -1 && var8.field923 == null) {
                  var26 = var8.method793(22, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 22, var4, var0, var1, var2, var8.field938, true, (class85)null);
               }

               var6.method1929(var0, var1, var2, var16, (class85)var26, var19, var20);
               if(var8.field924 == 1 && null != var7) {
                  var7.method2411(var1, var2);
               }

            }
         } else if(10 != var5 && 11 != var5) {
            if(var5 >= 12) {
               if(-1 == var8.field938 && null == var8.field923) {
                  var26 = var8.method793(var5, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field938, true, (class85)null);
               }

               var6.method1936(var0, var1, var2, var16, 1, 1, (class85)var26, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class4.field74[var0][var1][var2] |= 2340;
               }

               if(0 != var8.field924 && var7 != null) {
                  var7.method2409(var1, var2, var9, var10, var8.field917);
               }

            } else if(0 == var5) {
               if(-1 == var8.field938 && null == var8.field923) {
                  var26 = var8.method793(0, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 0, var4, var0, var1, var2, var8.field938, true, (class85)null);
               }

               var6.method2027(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field85[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field930) {
                     class5.field98[var0][var1][var2] = 50;
                     class5.field98[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.field921) {
                     class4.field74[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field930) {
                     class5.field98[var0][var1][var2 + 1] = 50;
                     class5.field98[var0][1 + var1][1 + var2] = 50;
                  }

                  if(var8.field921) {
                     class4.field74[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(2 == var4) {
                  if(var8.field930) {
                     class5.field98[var0][1 + var1][var2] = 50;
                     class5.field98[var0][var1 + 1][1 + var2] = 50;
                  }

                  if(var8.field921) {
                     class4.field74[var0][1 + var1][var2] |= 585;
                  }
               } else if(3 == var4) {
                  if(var8.field930) {
                     class5.field98[var0][var1][var2] = 50;
                     class5.field98[var0][1 + var1][var2] = 50;
                  }

                  if(var8.field921) {
                     class4.field74[var0][var1][var2] |= 1170;
                  }
               }

               if(0 != var8.field924 && null != var7) {
                  var7.method2412(var1, var2, var5, var4, var8.field917);
               }

               if(var8.field945 != 16) {
                  var6.method2083(var0, var1, var2, var8.field945);
               }

            } else if(var5 == 1) {
               if(-1 == var8.field938 && var8.field923 == null) {
                  var26 = var8.method793(1, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 1, var4, var0, var1, var2, var8.field938, true, (class85)null);
               }

               var6.method2027(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field96[var4], 0, var19, var20);
               if(var8.field930) {
                  if(0 == var4) {
                     class5.field98[var0][var1][1 + var2] = 50;
                  } else if(1 == var4) {
                     class5.field98[var0][var1 + 1][1 + var2] = 50;
                  } else if(var4 == 2) {
                     class5.field98[var0][1 + var1][var2] = 50;
                  } else if(3 == var4) {
                     class5.field98[var0][var1][var2] = 50;
                  }
               }

               if(var8.field924 != 0 && var7 != null) {
                  var7.method2412(var1, var2, var5, var4, var8.field917);
               }

            } else {
               int var27;
               Object var28;
               if(var5 == 2) {
                  var27 = 1 + var4 & 3;
                  Object var30;
                  if(var8.field938 == -1 && var8.field923 == null) {
                     var30 = var8.method793(2, var4 + 4, var15, var17, var16, var18);
                     var28 = var8.method793(2, var27, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 2, var4 + 4, var0, var1, var2, var8.field938, true, (class85)null);
                     var28 = new class12(var3, 2, var27, var0, var1, var2, var8.field938, true, (class85)null);
                  }

                  var6.method2027(var0, var1, var2, var16, (class85)var30, (class85)var28, class5.field85[var4], class5.field85[var27], var19, var20);
                  if(var8.field921) {
                     if(0 == var4) {
                        class4.field74[var0][var1][var2] |= 585;
                        class4.field74[var0][var1][var2 + 1] |= 1170;
                     } else if(1 == var4) {
                        class4.field74[var0][var1][var2 + 1] |= 1170;
                        class4.field74[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class4.field74[var0][var1 + 1][var2] |= 585;
                        class4.field74[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class4.field74[var0][var1][var2] |= 1170;
                        class4.field74[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field924 != 0 && null != var7) {
                     var7.method2412(var1, var2, var5, var4, var8.field917);
                  }

                  if(16 != var8.field945) {
                     var6.method2083(var0, var1, var2, var8.field945);
                  }

               } else if(var5 == 3) {
                  if(-1 == var8.field938 && null == var8.field923) {
                     var26 = var8.method793(3, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 3, var4, var0, var1, var2, var8.field938, true, (class85)null);
                  }

                  var6.method2027(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field96[var4], 0, var19, var20);
                  if(var8.field930) {
                     if(0 == var4) {
                        class5.field98[var0][var1][var2 + 1] = 50;
                     } else if(1 == var4) {
                        class5.field98[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class5.field98[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class5.field98[var0][var1][var2] = 50;
                     }
                  }

                  if(0 != var8.field924 && null != var7) {
                     var7.method2412(var1, var2, var5, var4, var8.field917);
                  }

               } else if(9 == var5) {
                  if(var8.field938 == -1 && var8.field923 == null) {
                     var26 = var8.method793(var5, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field938, true, (class85)null);
                  }

                  var6.method1936(var0, var1, var2, var16, 1, 1, (class85)var26, 0, var19, var20);
                  if(0 != var8.field924 && null != var7) {
                     var7.method2409(var1, var2, var9, var10, var8.field917);
                  }

                  if(var8.field945 != 16) {
                     var6.method2083(var0, var1, var2, var8.field945);
                  }

               } else if(4 == var5) {
                  if(-1 == var8.field938 && var8.field923 == null) {
                     var26 = var8.method793(4, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field938, true, (class85)null);
                  }

                  var6.method1935(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field85[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var27 = 16;
                  var22 = var6.method1952(var0, var1, var2);
                  if(0 != var22) {
                     var27 = class26.method633(var22 >> 14 & 32767).field945;
                  }

                  if(var8.field938 == -1 && null == var8.field923) {
                     var28 = var8.method793(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, var4, var0, var1, var2, var8.field938, true, (class85)null);
                  }

                  var6.method1935(var0, var1, var2, var16, (class85)var28, (class85)null, class5.field85[var4], 0, class5.field87[var4] * var27, class5.field88[var4] * var27, var19, var20);
               } else if(6 == var5) {
                  var27 = 8;
                  var22 = var6.method1952(var0, var1, var2);
                  if(0 != var22) {
                     var27 = class26.method633(var22 >> 14 & 32767).field945 / 2;
                  }

                  if(-1 == var8.field938 && null == var8.field923) {
                     var28 = var8.method793(4, 4 + var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field938, true, (class85)null);
                  }

                  var6.method1935(var0, var1, var2, var16, (class85)var28, (class85)null, 256, var4, class5.field89[var4] * var27, class5.field83[var4] * var27, var19, var20);
               } else if(var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if(-1 == var8.field938 && null == var8.field923) {
                     var26 = var8.method793(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, 4 + var22, var0, var1, var2, var8.field938, true, (class85)null);
                  }

                  var6.method1935(var0, var1, var2, var16, (class85)var26, (class85)null, 256, var22, 0, 0, var19, var20);
               } else if(8 == var5) {
                  var27 = 8;
                  var22 = var6.method1952(var0, var1, var2);
                  if(0 != var22) {
                     var27 = class26.method633(var22 >> 14 & 32767).field945 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var29;
                  if(var8.field938 == -1 && var8.field923 == null) {
                     var28 = var8.method793(4, var4 + 4, var15, var17, var16, var18);
                     var29 = var8.method793(4, 4 + var25, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field938, true, (class85)null);
                     var29 = new class12(var3, 4, 4 + var25, var0, var1, var2, var8.field938, true, (class85)null);
                  }

                  var6.method1935(var0, var1, var2, var16, (class85)var28, (class85)var29, 256, var4, class5.field89[var4] * var27, var27 * class5.field83[var4], var19, var20);
               }
            }
         } else {
            if(var8.field938 == -1 && var8.field923 == null) {
               var26 = var8.method793(10, var4, var15, var17, var16, var18);
            } else {
               var26 = new class12(var3, 10, var4, var0, var1, var2, var8.field938, true, (class85)null);
            }

            if(null != var26 && var6.method1936(var0, var1, var2, var16, var9, var10, (class85)var26, 11 == var5?256:0, var19, var20) && var8.field930) {
               var22 = 15;
               if(var26 instanceof class105) {
                  var22 = ((class105)var26).method2327() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class5.field98[var0][var1 + var23][var2 + var24]) {
                        class5.field98[var0][var1 + var23][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.field924 != 0 && var7 != null) {
               var7.method2409(var1, var2, var9, var10, var8.field917);
            }

         }
      }
   }

   @ObfuscatedName("p")
   public static boolean method2(int var0) {
      return 0 != (var0 >> 28 & 1);
   }

   @ObfuscatedName("a")
   public static boolean method3(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass42;IIII)V",
      garbageValue = "-555361440"
   )
   static void method4(class42 var0, int var1, int var2, int var3) {
      if(client.field383 < 50 && 0 != client.field519) {
         if(null != var0.field969 && var1 < var0.field969.length) {
            int var4 = var0.field969[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field521[client.field383] = var5;
               client.field522[client.field383] = var6;
               client.field523[client.field383] = 0;
               client.field444[client.field383] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field446[client.field383] = (var8 << 16) + (var9 << 8) + var7;
               ++client.field383;
            }
         }
      }
   }
}
