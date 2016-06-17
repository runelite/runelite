import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class48 extends class204 {
   @ObfuscatedName("qz")
   @Export("bufferProvider")
   public static class77 field1049;
   @ObfuscatedName("j")
   public char field1050;
   @ObfuscatedName("d")
   public char field1051;
   @ObfuscatedName("x")
   public String field1052 = "null";
   @ObfuscatedName("b")
   public static class167 field1053;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -458566945
   )
   public int field1054 = 0;
   @ObfuscatedName("c")
   public int[] field1055;
   @ObfuscatedName("l")
   public int[] field1056;
   @ObfuscatedName("u")
   public String[] field1057;
   @ObfuscatedName("g")
   public static class193 field1058 = new class193(64);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 494377785
   )
   public int field1059;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1719156678"
   )
   void method984(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1050 = (char)var1.method2514();
      } else if(var2 == 2) {
         this.field1051 = (char)var1.method2514();
      } else if(var2 == 3) {
         this.field1052 = var1.method2522();
      } else if(var2 == 4) {
         this.field1059 = var1.method2519();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1054 = var1.method2516();
            this.field1055 = new int[this.field1054];
            this.field1057 = new String[this.field1054];

            for(var3 = 0; var3 < this.field1054; ++var3) {
               this.field1055[var3] = var1.method2519();
               this.field1057[var3] = var1.method2522();
            }
         } else if(var2 == 6) {
            this.field1054 = var1.method2516();
            this.field1055 = new int[this.field1054];
            this.field1056 = new int[this.field1054];

            for(var3 = 0; var3 < this.field1054; ++var3) {
               this.field1055[var3] = var1.method2519();
               this.field1056[var3] = var1.method2519();
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "5"
   )
   public void method985(class119 var1) {
      while(true) {
         int var2 = var1.method2514();
         if(var2 == 0) {
            return;
         }

         this.method984(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2079768035"
   )
   public static boolean method989() {
      try {
         if(class183.field2953 == 2) {
            if(class0.field0 == null) {
               class0.field0 = class180.method3522(class50.field1075, class177.field2903, class183.field2951);
               if(class0.field0 == null) {
                  return false;
               }
            }

            if(class177.field2906 == null) {
               class177.field2906 = new class59(class183.field2957, class183.field2950);
            }

            if(class183.field2952.method3711(class0.field0, class183.field2958, class177.field2906, 22050)) {
               class183.field2952.method3626();
               class183.field2952.method3608(class181.field2929);
               class183.field2952.method3613(class0.field0, class183.field2956);
               class183.field2953 = 0;
               class0.field0 = null;
               class177.field2906 = null;
               class50.field1075 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class183.field2952.method3614();
         class183.field2953 = 0;
         class0.field0 = null;
         class177.field2906 = null;
         class50.field1075 = null;
      }

      return false;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1428784207"
   )
   static final void method990() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      class28 var29;
      if(client.field335 == 45) {
         var0 = client.field332.method2550();
         var1 = client.field332.method2548();
         var2 = client.field332.method2574();
         var3 = class39.field882 + (var2 >> 4 & 7);
         var4 = (var2 & 7) + class18.field264;
         if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
            var29 = new class28();
            var29.field672 = var0;
            var29.field671 = var1;
            if(client.field420[class144.field2193][var3][var4] == null) {
               client.field420[class144.field2193][var3][var4] = new class199();
            }

            client.field420[class144.field2193][var3][var4].method3819(var29);
            class93.method2171(var3, var4);
         }

      } else {
         int var5;
         int var6;
         int var9;
         int var31;
         int var35;
         if(client.field335 == 71) {
            var0 = client.field332.method2514();
            var1 = class39.field882 + (var0 >> 4 & 7);
            var2 = (var0 & 7) + class18.field264;
            var3 = var1 + client.field332.method2515();
            var4 = var2 + client.field332.method2515();
            var5 = client.field332.method2517();
            var6 = client.field332.method2516();
            var31 = client.field332.method2514() * 4;
            var35 = client.field332.method2514() * 4;
            var9 = client.field332.method2516();
            int var36 = client.field332.method2516();
            int var37 = client.field332.method2514();
            int var38 = client.field332.method2514();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
               var1 = 64 + 128 * var1;
               var2 = 64 + var2 * 128;
               var3 = var3 * 128 + 64;
               var4 = 64 + 128 * var4;
               class6 var32 = new class6(var6, class144.field2193, var1, var2, class108.method2413(var1, var2, class144.field2193) - var31, var9 + client.field296, client.field296 + var36, var37, var38, var5, var35);
               var32.method81(var3, var4, class108.method2413(var3, var4, class144.field2193) - var35, var9 + client.field296);
               client.field422.method3819(var32);
            }

         } else if(client.field335 == 232) {
            var0 = client.field332.method2542();
            var1 = (var0 >> 4 & 7) + class39.field882;
            var2 = class18.field264 + (var0 & 7);
            var3 = client.field332.method2514();
            var4 = var3 >> 2;
            var5 = var3 & 3;
            var6 = client.field369[var4];
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class162.method3211(class144.field2193, var1, var2, var6, -1, var4, var5, 0, -1);
            }

         } else {
            if(client.field335 == 127) {
               var0 = client.field332.method2542();
               var1 = var0 >> 2;
               var2 = var0 & 3;
               var3 = client.field369[var1];
               var4 = client.field332.method2661();
               var5 = client.field332.method2514();
               var6 = (var5 >> 4 & 7) + class39.field882;
               var31 = (var5 & 7) + class18.field264;
               byte var8 = client.field332.method2544();
               var9 = client.field332.method2550();
               byte var10 = client.field332.method2543();
               byte var11 = client.field332.method2543();
               byte var12 = client.field332.method2543();
               int var13 = client.field332.method2516();
               int var14 = client.field332.method2661();
               class2 var15;
               if(var4 == client.field430) {
                  var15 = class153.field2262;
               } else {
                  var15 = client.field410[var4];
               }

               if(var15 != null) {
                  class40 var16 = class172.method3399(var14);
                  int var17;
                  int var18;
                  if(var2 != 1 && var2 != 3) {
                     var17 = var16.field915;
                     var18 = var16.field904;
                  } else {
                     var17 = var16.field904;
                     var18 = var16.field915;
                  }

                  int var19 = (var17 >> 1) + var6;
                  int var20 = var6 + (var17 + 1 >> 1);
                  int var21 = (var18 >> 1) + var31;
                  int var22 = (var18 + 1 >> 1) + var31;
                  int[][] var23 = class5.field83[class144.field2193];
                  int var24 = var23[var19][var22] + var23[var19][var21] + var23[var20][var21] + var23[var20][var22] >> 2;
                  int var25 = (var17 << 6) + (var6 << 7);
                  int var26 = (var18 << 6) + (var31 << 7);
                  class105 var27 = var16.method801(var1, var2, var23, var25, var24, var26);
                  if(var27 != null) {
                     class162.method3211(class144.field2193, var6, var31, var3, -1, 0, 0, 1 + var13, var9 + 1);
                     var15.field34 = var13 + client.field296;
                     var15.field39 = client.field296 + var9;
                     var15.field25 = var27;
                     var15.field36 = 128 * var6 + 64 * var17;
                     var15.field38 = 128 * var31 + var18 * 64;
                     var15.field37 = var24;
                     byte var28;
                     if(var12 > var10) {
                        var28 = var12;
                        var12 = var10;
                        var10 = var28;
                     }

                     if(var11 > var8) {
                        var28 = var11;
                        var11 = var8;
                        var8 = var28;
                     }

                     var15.field46 = var12 + var6;
                     var15.field42 = var10 + var6;
                     var15.field41 = var11 + var31;
                     var15.field27 = var31 + var8;
                  }
               }
            }

            if(client.field335 == 77) {
               var0 = client.field332.method2516();
               var1 = client.field332.method2574();
               var2 = (var1 >> 4 & 7) + class39.field882;
               var3 = (var1 & 7) + class18.field264;
               if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                  class199 var30 = client.field420[class144.field2193][var2][var3];
                  if(var30 != null) {
                     for(var29 = (class28)var30.method3844(); var29 != null; var29 = (class28)var30.method3834()) {
                        if((var0 & 32767) == var29.field672) {
                           var29.method3916();
                           break;
                        }
                     }

                     if(var30.method3844() == null) {
                        client.field420[class144.field2193][var2][var3] = null;
                     }

                     class93.method2171(var2, var3);
                  }
               }

            } else {
               if(client.field335 == 136) {
                  var0 = client.field332.method2514();
                  var1 = (var0 >> 4 & 7) + class39.field882;
                  var2 = (var0 & 7) + class18.field264;
                  var3 = client.field332.method2516();
                  var4 = client.field332.method2514();
                  var5 = var4 >> 4 & 15;
                  var6 = var4 & 7;
                  var31 = client.field332.method2514();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var35 = var5 + 1;
                     if(class153.field2262.field844[0] >= var1 - var35 && class153.field2262.field844[0] <= var35 + var1 && class153.field2262.field831[0] >= var2 - var35 && class153.field2262.field831[0] <= var2 + var35 && client.field365 != 0 && var6 > 0 && client.field504 < 50) {
                        client.field530[client.field504] = var3;
                        client.field531[client.field504] = var6;
                        client.field532[client.field504] = var31;
                        client.field534[client.field504] = null;
                        client.field480[client.field504] = var5 + (var1 << 16) + (var2 << 8);
                        ++client.field504;
                     }
                  }
               }

               if(client.field335 == 197) {
                  var0 = client.field332.method2661();
                  var1 = client.field332.method2574();
                  var2 = (var1 >> 4 & 7) + class39.field882;
                  var3 = (var1 & 7) + class18.field264;
                  var4 = client.field332.method2514();
                  var5 = var4 >> 2;
                  var6 = var4 & 3;
                  var31 = client.field369[var5];
                  if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                     class162.method3211(class144.field2193, var2, var3, var31, var0, var5, var6, 0, -1);
                  }

               } else if(client.field335 == 222) {
                  var0 = client.field332.method2514();
                  var1 = class39.field882 + (var0 >> 4 & 7);
                  var2 = class18.field264 + (var0 & 7);
                  var3 = client.field332.method2516();
                  var4 = client.field332.method2516();
                  var5 = client.field332.method2516();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     class199 var42 = client.field420[class144.field2193][var1][var2];
                     if(var42 != null) {
                        for(class28 var7 = (class28)var42.method3844(); null != var7; var7 = (class28)var42.method3834()) {
                           if((var3 & 32767) == var7.field672 && var7.field671 == var4) {
                              var7.field671 = var5;
                              break;
                           }
                        }

                        class93.method2171(var1, var2);
                     }
                  }

               } else if(client.field335 == 35) {
                  var0 = client.field332.method2514();
                  var1 = class39.field882 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + class18.field264;
                  var3 = client.field332.method2516();
                  var4 = client.field332.method2514();
                  var5 = client.field332.method2516();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     class29 var34 = new class29(var3, class144.field2193, var1, var2, class108.method2413(var1, var2, class144.field2193) - var4, var5, client.field296);
                     client.field423.method3819(var34);
                  }

               } else if(client.field335 == 16) {
                  var0 = client.field332.method2542();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = client.field369[var1];
                  var4 = client.field332.method2540();
                  var5 = (var4 >> 4 & 7) + class39.field882;
                  var6 = (var4 & 7) + class18.field264;
                  var31 = client.field332.method2516();
                  if(var5 >= 0 && var6 >= 0 && var5 < 103 && var6 < 103) {
                     if(var3 == 0) {
                        class87 var33 = class150.field2230.method1973(class144.field2193, var5, var6);
                        if(null != var33) {
                           var9 = var33.field1506 >> 14 & 32767;
                           if(var1 == 2) {
                              var33.field1504 = new class12(var9, 2, 4 + var2, class144.field2193, var5, var6, var31, false, var33.field1504);
                              var33.field1501 = new class12(var9, 2, 1 + var2 & 3, class144.field2193, var5, var6, var31, false, var33.field1501);
                           } else {
                              var33.field1504 = new class12(var9, var1, var2, class144.field2193, var5, var6, var31, false, var33.field1504);
                           }
                        }
                     }

                     if(var3 == 1) {
                        class94 var39 = class150.field2230.method1948(class144.field2193, var5, var6);
                        if(null != var39) {
                           var9 = var39.field1584 >> 14 & 32767;
                           if(var1 != 4 && var1 != 5) {
                              if(var1 == 6) {
                                 var39.field1583 = new class12(var9, 4, var2 + 4, class144.field2193, var5, var6, var31, false, var39.field1583);
                              } else if(var1 == 7) {
                                 var39.field1583 = new class12(var9, 4, 4 + (var2 + 2 & 3), class144.field2193, var5, var6, var31, false, var39.field1583);
                              } else if(var1 == 8) {
                                 var39.field1583 = new class12(var9, 4, var2 + 4, class144.field2193, var5, var6, var31, false, var39.field1583);
                                 var39.field1579 = new class12(var9, 4, (2 + var2 & 3) + 4, class144.field2193, var5, var6, var31, false, var39.field1579);
                              }
                           } else {
                              var39.field1583 = new class12(var9, 4, var2, class144.field2193, var5, var6, var31, false, var39.field1583);
                           }
                        }
                     }

                     if(var3 == 2) {
                        class98 var40 = class150.field2230.method2010(class144.field2193, var5, var6);
                        if(var1 == 11) {
                           var1 = 10;
                        }

                        if(var40 != null) {
                           var40.field1632 = new class12(var40.field1640 >> 14 & 32767, var1, var2, class144.field2193, var5, var6, var31, false, var40.field1632);
                        }
                     }

                     if(var3 == 3) {
                        class93 var41 = class150.field2230.method1950(class144.field2193, var5, var6);
                        if(var41 != null) {
                           var41.field1568 = new class12(var41.field1569 >> 14 & 32767, 22, var2, class144.field2193, var5, var6, var31, false, var41.field1568);
                        }
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "117"
   )
   public static int method991(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = (var0 >>> 4) + var0 & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1233502089"
   )
   public static void method992(boolean var0) {
      if(var0 != class10.field157) {
         class37.method764();
         class10.field157 = var0;
      }

   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;B)V",
      garbageValue = "0"
   )
   static void method993(int var0, int var1, int var2, int var3, String var4) {
      class173 var5 = class165.method3247(var1, var2);
      if(var5 != null) {
         if(var5.field2848 != null) {
            class0 var6 = new class0();
            var6.field10 = var5;
            var6.field5 = var0;
            var6.field9 = var4;
            var6.field12 = var5.field2848;
            class90.method2092(var6, 200000);
         }

         boolean var10 = true;
         if(var5.field2768 > 0) {
            var10 = class8.method110(var5);
         }

         if(var10) {
            int var8 = class34.method734(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               if(var0 == 1) {
                  client.field331.method2781(191);
                  client.field331.method2502(var1);
                  client.field331.method2695(var2);
                  client.field331.method2695(var3);
               }

               if(var0 == 2) {
                  client.field331.method2781(8);
                  client.field331.method2502(var1);
                  client.field331.method2695(var2);
                  client.field331.method2695(var3);
               }

               if(var0 == 3) {
                  client.field331.method2781(247);
                  client.field331.method2502(var1);
                  client.field331.method2695(var2);
                  client.field331.method2695(var3);
               }

               if(var0 == 4) {
                  client.field331.method2781(77);
                  client.field331.method2502(var1);
                  client.field331.method2695(var2);
                  client.field331.method2695(var3);
               }

               if(var0 == 5) {
                  client.field331.method2781(209);
                  client.field331.method2502(var1);
                  client.field331.method2695(var2);
                  client.field331.method2695(var3);
               }

               if(var0 == 6) {
                  client.field331.method2781(106);
                  client.field331.method2502(var1);
                  client.field331.method2695(var2);
                  client.field331.method2695(var3);
               }

               if(var0 == 7) {
                  client.field331.method2781(213);
                  client.field331.method2502(var1);
                  client.field331.method2695(var2);
                  client.field331.method2695(var3);
               }

               if(var0 == 8) {
                  client.field331.method2781(155);
                  client.field331.method2502(var1);
                  client.field331.method2695(var2);
                  client.field331.method2695(var3);
               }

               if(var0 == 9) {
                  client.field331.method2781(19);
                  client.field331.method2502(var1);
                  client.field331.method2695(var2);
                  client.field331.method2695(var3);
               }

               if(var0 == 10) {
                  client.field331.method2781(65);
                  client.field331.method2502(var1);
                  client.field331.method2695(var2);
                  client.field331.method2695(var3);
               }

            }
         }
      }
   }
}
