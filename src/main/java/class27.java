import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class27 {
   @ObfuscatedName("w")
   class35[] field651 = new class35[100];
   @ObfuscatedName("k")
   static class18 field652;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1767104731
   )
   int field653;
   @ObfuscatedName("b")
   static int[] field655;
   @ObfuscatedName("z")
   static int[] field656;
   @ObfuscatedName("bj")
   static class168 field659;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   static final void method635() {
      if(class46.field1040 != null) {
         class46.field1040.method2982();
         class46.field1040 = null;
      }

      class5.method90();
      class151.field2250.method1926();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field338[var0].method2407();
      }

      System.gc();
      class4.method44(2);
      client.field516 = -1;
      client.field427 = false;

      for(class23 var1 = (class23)class23.field601.method3825(); var1 != null; var1 = (class23)class23.field601.method3827()) {
         if(null != var1.field591) {
            class135.field2074.method1146(var1.field591);
            var1.field591 = null;
         }

         if(null != var1.field596) {
            class135.field2074.method1146(var1.field596);
            var1.field596 = null;
         }
      }

      class23.field601.method3819();
      class141.method2971(10);
   }

   @ObfuscatedName("e")
   class35 method636(int var1, String var2, String var3, String var4) {
      class35 var5 = this.field651[99];

      for(int var6 = this.field653; var6 > 0; --var6) {
         if(var6 != 100) {
            this.field651[var6] = this.field651[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new class35(var1, var2, var4, var3);
      } else {
         var5.method3913();
         var5.method3891();
         var5.method728(var1, var2, var4, var3);
      }

      this.field651[0] = var5;
      if(this.field653 < 100) {
         ++this.field653;
      }

      return var5;
   }

   @ObfuscatedName("w")
   class35 method637(int var1) {
      return var1 >= 0 && var1 < this.field653?this.field651[var1]:null;
   }

   @ObfuscatedName("f")
   int method638() {
      return this.field653;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIIILclass86;Lclass108;S)V",
      garbageValue = "4107"
   )
   static final void method644(int var0, int var1, int var2, int var3, int var4, int var5, int var6, class86 var7, class108 var8) {
      class40 var9 = class26.method633(var4);
      int var10;
      int var11;
      if(1 != var5 && 3 != var5) {
         var10 = var9.field908;
         var11 = var9.field915;
      } else {
         var10 = var9.field915;
         var11 = var9.field908;
      }

      int var12;
      int var13;
      if(var2 + var10 <= 104) {
         var12 = var2 + (var10 >> 1);
         var13 = (1 + var10 >> 1) + var2;
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var11 + var3 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = (var11 + 1 >> 1) + var3;
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class5.field90[var1];
      int var17 = var16[var13][var15] + var16[var13][var14] + var16[var12][var14] + var16[var12][var15] >> 2;
      int var18 = (var10 << 6) + (var2 << 7);
      int var19 = (var11 << 6) + (var3 << 7);
      int var20 = var2 + (var3 << 7) + (var4 << 14) + 1073741824;
      if(var9.field922 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = var6 + (var5 << 6);
      if(1 == var9.field948) {
         var21 += 256;
      }

      Object var22;
      if(22 == var6) {
         if(var9.field938 == -1 && null == var9.field923) {
            var22 = var9.method799(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new class12(var4, 22, var5, var1, var2, var3, var9.field938, true, (class85)null);
         }

         var7.method1929(var0, var2, var3, var17, (class85)var22, var20, var21);
         if(var9.field924 == 1) {
            var8.method2411(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(-1 == var9.field938 && var9.field923 == null) {
               var22 = var9.method799(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, var6, var5, var1, var2, var3, var9.field938, true, (class85)null);
            }

            var7.method1936(var0, var2, var3, var17, 1, 1, (class85)var22, 0, var20, var21);
            if(0 != var9.field924) {
               var8.method2409(var2, var3, var10, var11, var9.field917);
            }

         } else if(var6 == 0) {
            if(-1 == var9.field938 && var9.field923 == null) {
               var22 = var9.method799(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, 0, var5, var1, var2, var3, var9.field938, true, (class85)null);
            }

            var7.method2027(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field85[var5], 0, var20, var21);
            if(0 != var9.field924) {
               var8.method2412(var2, var3, var6, var5, var9.field917);
            }

         } else if(1 == var6) {
            if(var9.field938 == -1 && null == var9.field923) {
               var22 = var9.method799(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, 1, var5, var1, var2, var3, var9.field938, true, (class85)null);
            }

            var7.method2027(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field96[var5], 0, var20, var21);
            if(var9.field924 != 0) {
               var8.method2412(var2, var3, var6, var5, var9.field917);
            }

         } else {
            Object var24;
            int var27;
            if(2 == var6) {
               var27 = var5 + 1 & 3;
               Object var28;
               if(var9.field938 == -1 && null == var9.field923) {
                  var28 = var9.method799(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method799(2, var27, var16, var18, var17, var19);
               } else {
                  var28 = new class12(var4, 2, var5 + 4, var1, var2, var3, var9.field938, true, (class85)null);
                  var24 = new class12(var4, 2, var27, var1, var2, var3, var9.field938, true, (class85)null);
               }

               var7.method2027(var0, var2, var3, var17, (class85)var28, (class85)var24, class5.field85[var5], class5.field85[var27], var20, var21);
               if(var9.field924 != 0) {
                  var8.method2412(var2, var3, var6, var5, var9.field917);
               }

            } else if(3 == var6) {
               if(var9.field938 == -1 && null == var9.field923) {
                  var22 = var9.method799(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, 3, var5, var1, var2, var3, var9.field938, true, (class85)null);
               }

               var7.method2027(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field96[var5], 0, var20, var21);
               if(0 != var9.field924) {
                  var8.method2412(var2, var3, var6, var5, var9.field917);
               }

            } else if(var6 == 9) {
               if(-1 == var9.field938 && var9.field923 == null) {
                  var22 = var9.method799(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, var6, var5, var1, var2, var3, var9.field938, true, (class85)null);
               }

               var7.method1936(var0, var2, var3, var17, 1, 1, (class85)var22, 0, var20, var21);
               if(0 != var9.field924) {
                  var8.method2409(var2, var3, var10, var11, var9.field917);
               }

            } else if(var6 == 4) {
               if(-1 == var9.field938 && var9.field923 == null) {
                  var22 = var9.method799(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, 4, var5, var1, var2, var3, var9.field938, true, (class85)null);
               }

               var7.method1935(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field85[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var27 = 16;
                  var23 = var7.method1952(var0, var2, var3);
                  if(0 != var23) {
                     var27 = class26.method633(var23 >> 14 & 32767).field945;
                  }

                  if(var9.field938 == -1 && null == var9.field923) {
                     var24 = var9.method799(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5, var1, var2, var3, var9.field938, true, (class85)null);
                  }

                  var7.method1935(var0, var2, var3, var17, (class85)var24, (class85)null, class5.field85[var5], 0, class5.field87[var5] * var27, var27 * class5.field88[var5], var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var23 = var7.method1952(var0, var2, var3);
                  if(0 != var23) {
                     var27 = class26.method633(var23 >> 14 & 32767).field945 / 2;
                  }

                  if(-1 == var9.field938 && null == var9.field923) {
                     var24 = var9.method799(4, 4 + var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, 4 + var5, var1, var2, var3, var9.field938, true, (class85)null);
                  }

                  var7.method1935(var0, var2, var3, var17, (class85)var24, (class85)null, 256, var5, class5.field89[var5] * var27, var27 * class5.field83[var5], var20, var21);
               } else if(7 == var6) {
                  var23 = var5 + 2 & 3;
                  if(-1 == var9.field938 && var9.field923 == null) {
                     var22 = var9.method799(4, var23 + 4, var16, var18, var17, var19);
                  } else {
                     var22 = new class12(var4, 4, 4 + var23, var1, var2, var3, var9.field938, true, (class85)null);
                  }

                  var7.method1935(var0, var2, var3, var17, (class85)var22, (class85)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var23 = var7.method1952(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class26.method633(var23 >> 14 & 32767).field945 / 2;
                  }

                  int var26 = 2 + var5 & 3;
                  Object var25;
                  if(var9.field938 == -1 && var9.field923 == null) {
                     var24 = var9.method799(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method799(4, 4 + var26, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5 + 4, var1, var2, var3, var9.field938, true, (class85)null);
                     var25 = new class12(var4, 4, var26 + 4, var1, var2, var3, var9.field938, true, (class85)null);
                  }

                  var7.method1935(var0, var2, var3, var17, (class85)var24, (class85)var25, 256, var5, var27 * class5.field89[var5], var27 * class5.field83[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.field938 == -1 && var9.field923 == null) {
            var22 = var9.method799(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new class12(var4, 10, var5, var1, var2, var3, var9.field938, true, (class85)null);
         }

         if(null != var22) {
            var7.method1936(var0, var2, var3, var17, var10, var11, (class85)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.field924 != 0) {
            var8.method2409(var2, var3, var10, var11, var9.field917);
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-18586"
   )
   static void method645() {
      client.field290 = -1L;
      client.field293 = -1;
      class32.field728.field196 = 0;
      class113.field1948 = true;
      client.field312 = true;
      client.field504 = -1L;
      class211.field3129 = new class202();
      client.field321.field1976 = 0;
      client.field323.field1976 = 0;
      client.field325 = -1;
      client.field328 = -1;
      client.field329 = -1;
      client.field419 = -1;
      client.field326 = 0;
      client.field430 = 0;
      client.field472 = 0;
      client.field297 = 0;
      client.field420 = 0;
      client.field331 = false;
      class2.method39(0);
      class11.field172.clear();
      class11.field171.method3810();
      class11.field173.method3856();
      class11.field170 = 0;
      client.field431 = 0;
      client.field433 = false;
      client.field383 = 0;
      client.field343 = (int)(Math.random() * 100.0D) - 50;
      client.field345 = (int)(Math.random() * 110.0D) - 55;
      client.field525 = (int)(Math.random() * 80.0D) - 40;
      client.field350 = (int)(Math.random() * 120.0D) - 60;
      client.field352 = (int)(Math.random() * 30.0D) - 20;
      client.field368 = (int)(Math.random() * 20.0D) - 10 & 2047;
      client.field514 = 0;
      client.field507 = -1;
      client.field432 = 0;
      client.field513 = 0;
      client.field454 = class20.field569;
      client.field488 = class20.field569;
      client.field317 = 0;
      class32.field731 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class32.field729[var0] = null;
         class32.field730[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         client.field387[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         client.field316[var0] = null;
      }

      client.field409 = -1;
      client.field412.method3819();
      client.field413.method3819();

      int var2;
      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(var2 = 0; var2 < 104; ++var2) {
               client.field410[var0][var1][var2] = null;
            }
         }
      }

      client.field411 = new class199();
      client.field382 = 0;
      client.field545 = 0;
      client.field549 = 0;

      for(var0 = 0; var0 < class226.field3210; ++var0) {
         class52 var3 = class35.method732(var0);
         if(var3 != null) {
            class176.field2905[var0] = 0;
            class176.field2903[var0] = 0;
         }
      }

      class125.field2027.method198();
      client.field327 = -1;
      if(client.field438 != -1) {
         var0 = client.field438;
         if(var0 != -1 && class173.field2745[var0]) {
            class173.field2746.method3267(var0);
            if(class173.field2837[var0] != null) {
               boolean var4 = true;

               for(var2 = 0; var2 < class173.field2837[var0].length; ++var2) {
                  if(class173.field2837[var0][var2] != null) {
                     if(class173.field2837[var0][var2].field2757 != 2) {
                        class173.field2837[var0][var2] = null;
                     } else {
                        var4 = false;
                     }
                  }
               }

               if(var4) {
                  class173.field2837[var0] = null;
               }

               class173.field2745[var0] = false;
            }
         }
      }

      for(class3 var5 = (class3)client.field439.method3794(); var5 != null; var5 = (class3)client.field439.method3791()) {
         class110.method2446(var5, true);
      }

      client.field438 = -1;
      client.field439 = new class196(8);
      client.field442 = null;
      client.field331 = false;
      client.field420 = 0;
      client.field551.method3493((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         client.field406[var0] = null;
         client.field407[var0] = false;
      }

      class15.field216 = new class196(32);
      client.field288 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         client.field483[var0] = true;
      }

      class17.method183();
      client.field505 = null;
      class26.field644 = 0;
      class90.field1542 = null;

      for(var0 = 0; var0 < 8; ++var0) {
         client.field554[var0] = new class220();
      }

      class10.field168 = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([Lclass25;II[I[II)V",
      garbageValue = "-1780552219"
   )
   static void method647(class25[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         class25 var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].field627;
                     var12 = var8.field627;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field622;
                     var12 = var8.field622;
                     if(var11 == -1 && 1 == var4[var10]) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(3 == var3[var10]) {
                     var11 = var0[var6].method628()?1:0;
                     var12 = var8.method628()?1:0;
                  } else {
                     var11 = var0[var6].field620;
                     var12 = var8.field620;
                  }

                  if(var11 != var12) {
                     if((1 != var4[var10] || var11 <= var12) && (0 != var4[var10] || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(3 == var10) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].field627;
                     var12 = var8.field627;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].field622;
                     var12 = var8.field622;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(-1 == var12 && 1 == var4[var10]) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method628()?1:0;
                     var12 = var8.method628()?1:0;
                  } else {
                     var11 = var0[var5].field620;
                     var12 = var8.field620;
                  }

                  if(var11 != var12) {
                     if((1 != var4[var10] || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               class25 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method647(var0, var1, var6, var3, var4);
         method647(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("g")
   public static int method648(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class160.method3187(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("m")
   public static String method649(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "878912100"
   )
   static final void method650(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field465; ++var4) {
         if(client.field354[var4] + client.field486[var4] > var0 && client.field486[var4] < var0 + var2 && client.field489[var4] + client.field487[var4] > var1 && client.field487[var4] < var1 + var3) {
            client.field483[var4] = true;
         }
      }

   }
}
