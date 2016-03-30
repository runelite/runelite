import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public final class class162 {
   @ObfuscatedName("w")
   public static final char[] field2670 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-210006270"
   )
   static final void method3221() {
      class3.method43(false);
      client.field348 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class41.field987.length; ++var1) {
         if(-1 != class108.field1909[var1] && null == class41.field987[var1]) {
            class41.field987[var1] = class18.field271.method3335(class108.field1909[var1], 0);
            if(class41.field987[var1] == null) {
               var0 = false;
               ++client.field348;
            }
         }

         if(class140.field2180[var1] != -1 && null == class190.field3080[var1]) {
            class190.field3080[var1] = class18.field271.method3305(class140.field2180[var1], 0, class104.field1786[var1]);
            if(class190.field3080[var1] == null) {
               var0 = false;
               ++client.field348;
            }
         }
      }

      if(!var0) {
         client.field524 = 1;
      } else {
         client.field563 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class41.field987.length; ++var1) {
            byte[] var2 = class190.field3080[var1];
            if(null != var2) {
               var3 = (class101.field1756[var1] >> 8) * 64 - class41.field990;
               var4 = 64 * (class101.field1756[var1] & 255) - class2.field37;
               if(client.field354) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class140.method2947(var2, var3, var4);
            }
         }

         if(!var0) {
            client.field524 = 2;
         } else {
            if(client.field524 != 0) {
               class19.method228("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class59.method1272();
            class0.method1();
            class59.method1272();
            class3.field75.method2045();
            class59.method1272();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               client.field372[var1].method2394();
            }

            int var13;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var13 = 0; var13 < 104; ++var13) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class5.field109[var1][var13][var3] = 0;
                  }
               }
            }

            class59.method1272();
            class52.method1113();
            var1 = class41.field987.length;
            class10.method126();
            class3.method43(true);
            int var6;
            int var7;
            int var9;
            int var10;
            int var11;
            int var12;
            int var15;
            if(!client.field354) {
               byte[] var5;
               for(var13 = 0; var13 < var1; ++var13) {
                  var3 = 64 * (class101.field1756[var13] >> 8) - class41.field990;
                  var4 = (class101.field1756[var13] & 255) * 64 - class2.field37;
                  var5 = class41.field987[var13];
                  if(null != var5) {
                     class59.method1272();
                     var6 = class23.field625 * 8 - 48;
                     var7 = class82.field1429 * 8 - 48;
                     class108[] var8 = client.field372;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var10 + var3 > 0 && var3 + var10 < 103 && var4 + var11 > 0 && var4 + var11 < 103) {
                                 var8[var9].field1894[var3 + var10][var4 + var11] &= -16777217;
                              }
                           }
                        }
                     }

                     class119 var19 = new class119(var5);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var12 = 0; var12 < 64; ++var12) {
                              class152.method3178(var19, var10, var11 + var3, var4 + var12, var6, var7, 0);
                           }
                        }
                     }
                  }
               }

               for(var13 = 0; var13 < var1; ++var13) {
                  var3 = (class101.field1756[var13] >> 8) * 64 - class41.field990;
                  var4 = (class101.field1756[var13] & 255) * 64 - class2.field37;
                  var5 = class41.field987[var13];
                  if(var5 == null && class82.field1429 < 800) {
                     class59.method1272();
                     class33.method730(var3, var4, 64, 64);
                  }
               }

               class3.method43(true);

               for(var13 = 0; var13 < var1; ++var13) {
                  byte[] var14 = class190.field3080[var13];
                  if(null != var14) {
                     var4 = 64 * (class101.field1756[var13] >> 8) - class41.field990;
                     var15 = (class101.field1756[var13] & 255) * 64 - class2.field37;
                     class59.method1272();
                     class115.method2448(var14, var4, var15, class3.field75, client.field372);
                  }
               }
            }

            int var18;
            if(client.field354) {
               for(var13 = 0; var13 < 4; ++var13) {
                  class59.method1272();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var16 = false;
                        var6 = client.field446[var13][var3][var4];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var18 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var12 = 0; var12 < class101.field1756.length; ++var12) {
                              if(class101.field1756[var12] == var11 && null != class41.field987[var12]) {
                                 class28.method663(class41.field987[var12], var13, var3 * 8, 8 * var4, var7, 8 * (var9 & 7), 8 * (var10 & 7), var18, client.field372);
                                 var16 = true;
                                 break;
                              }
                           }
                        }

                        if(!var16) {
                           var7 = var13;
                           var18 = var3 * 8;
                           var9 = 8 * var4;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class5.field96[var7][var10 + var18][var11 + var9] = 0;
                              }
                           }

                           if(var18 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class5.field96[var7][var18][var9 + var10] = class5.field96[var7][var18 - 1][var10 + var9];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class5.field96[var7][var10 + var18][var9] = class5.field96[var7][var18 + var10][var9 - 1];
                              }
                           }

                           if(var18 > 0 && 0 != class5.field96[var7][var18 - 1][var9]) {
                              class5.field96[var7][var18][var9] = class5.field96[var7][var18 - 1][var9];
                           } else if(var9 > 0 && class5.field96[var7][var18][var9 - 1] != 0) {
                              class5.field96[var7][var18][var9] = class5.field96[var7][var18][var9 - 1];
                           } else if(var18 > 0 && var9 > 0 && class5.field96[var7][var18 - 1][var9 - 1] != 0) {
                              class5.field96[var7][var18][var9] = class5.field96[var7][var18 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var13 = 0; var13 < 13; ++var13) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = client.field446[0][var13][var3];
                     if(-1 == var4) {
                        class33.method730(8 * var13, var3 * 8, 8, 8);
                     }
                  }
               }

               class3.method43(true);

               for(var13 = 0; var13 < 4; ++var13) {
                  class59.method1272();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var15 = client.field446[var13][var3][var4];
                        if(var15 != -1) {
                           var6 = var15 >> 24 & 3;
                           var7 = var15 >> 1 & 3;
                           var18 = var15 >> 14 & 1023;
                           var9 = var15 >> 3 & 2047;
                           var10 = (var18 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class101.field1756.length; ++var11) {
                              if(var10 == class101.field1756[var11] && class190.field3080[var11] != null) {
                                 class187.method3760(class190.field3080[var11], var13, var3 * 8, 8 * var4, var6, (var18 & 7) * 8, (var9 & 7) * 8, var7, class3.field75, client.field372);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            class3.method43(true);
            class0.method1();
            class59.method1272();
            class95.method2185(class3.field75, client.field372);
            class3.method43(true);
            var13 = class5.field108;
            if(var13 > class82.field1437) {
               var13 = class82.field1437;
            }

            if(var13 < class82.field1437 - 1) {
               var13 = class82.field1437 - 1;
            }

            if(client.field413) {
               class3.field75.method1943(class5.field108);
            } else {
               class3.field75.method1943(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class122.method2760(var3, var4);
               }
            }

            class59.method1272();

            for(class16 var17 = (class16)client.field482.method3836(); null != var17; var17 = (class16)client.field482.method3841()) {
               if(-1 == var17.field247) {
                  var17.field246 = 0;
                  class20.method580(var17);
               } else {
                  var17.method3935();
               }
            }

            class40.field929.method3776();
            if(class33.field773 != null) {
               client.field318.method2757(45);
               client.field318.method2494(1057001181);
            }

            if(!client.field354) {
               var3 = (class23.field625 - 6) / 8;
               var4 = (6 + class23.field625) / 8;
               var15 = (class82.field1429 - 6) / 8;
               var6 = (class82.field1429 + 6) / 8;

               for(var7 = var3 - 1; var7 <= 1 + var4; ++var7) {
                  for(var18 = var15 - 1; var18 <= 1 + var6; ++var18) {
                     if(var7 < var3 || var7 > var4 || var18 < var15 || var18 > var6) {
                        class18.field271.method3297("m" + var7 + "_" + var18);
                        class18.field271.method3297("l" + var7 + "_" + var18);
                     }
                  }
               }
            }

            class138.method2937(30);
            class59.method1272();
            class34.field782 = (byte[][][])null;
            class5.field93 = (byte[][][])null;
            class137.field2147 = (byte[][][])null;
            class114.field1985 = (byte[][][])null;
            class3.field72 = (int[][][])null;
            class129.field2062 = (byte[][][])null;
            class5.field97 = (int[][])null;
            class5.field94 = null;
            class161.field2667 = null;
            class134.field2090 = null;
            class95.field1635 = null;
            class95.field1637 = null;
            client.field318.method2757(211);
            class27.field679.vmethod3139();

            for(var3 = 0; var3 < 32; ++var3) {
               class144.field2222[var3] = 0L;
            }

            for(var3 = 0; var3 < 32; ++var3) {
               class144.field2220[var3] = 0L;
            }

            class124.field2039 = 0;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass168;IIIBZB)V",
      garbageValue = "-23"
   )
   static void method3223(class168 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class172 var8 = (class172)class171.field2752.method3806(var6);
      if(var8 == null) {
         var8 = (class172)class171.field2749.method3806(var6);
         if(var8 == null) {
            var8 = (class172)class171.field2738.method3806(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3909();
                  class171.field2752.method3807(var8, var6);
                  --class171.field2740;
                  ++class171.field2739;
               }

            } else {
               if(!var5) {
                  var8 = (class172)class171.field2734.method3806(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class172();
               var8.field2755 = var0;
               var8.field2757 = var3;
               var8.field2756 = var4;
               if(var5) {
                  class171.field2752.method3807(var8, var6);
                  ++class171.field2739;
               } else {
                  class171.field2741.method3905(var8);
                  class171.field2738.method3807(var8, var6);
                  ++class171.field2740;
               }

            }
         }
      }
   }
}
