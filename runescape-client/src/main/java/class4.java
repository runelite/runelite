import java.io.IOException;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class4 {
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -926053843
   )
   static int field72;
   @ObfuscatedName("g")
   static final BigInteger field73 = new BigInteger("933b301ae163f99ef4c9c2e7f60f1b818dcd3bef2024fb767d39fc4c02e356c1dbb66645a53e3aefc1604d08f4c7dd6cd1e95d6fa7dbebd63e9c98dc5c21fae2202e34cd6cb0eeb9616c78e4966f9cf02292d56a7f71a66e075fc38ae6f601b0640358e0f4ff9153dd9ca8481c59812299941e5090b91e503c2836bab93ed5e5", 16);
   @ObfuscatedName("mh")
   @Export("clanMembers")
   static class25[] field74;
   @ObfuscatedName("l")
   static final BigInteger field76 = new BigInteger("10001", 16);

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   static void method44() {
      int var0 = class189.field3056;
      int var1 = class39.field892;
      if(class78.field1450 < var0) {
         var0 = class78.field1450;
      }

      if(class144.field2220 < var1) {
         var1 = class144.field2220;
      }

      if(null != class136.field2123) {
         try {
            class135.method2991(client.field477, "resize", new Object[]{Integer.valueOf(class53.method1139())});
         } catch (Throwable var3) {
            ;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Lclass8;",
      garbageValue = "79"
   )
   static class8 method45() {
      class230 var0 = null;
      class8 var1 = new class8();

      try {
         var0 = class114.method2540("", client.field298.field2346, false);
         byte[] var2 = new byte[(int)var0.method4273()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method4274(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new class8(new class122(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4283();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-178407864"
   )
   static final void method46(String var0, boolean var1) {
      if(var0 != null) {
         if((client.field565 < 100 || client.field418 == 1) && client.field565 < 400) {
            String var2 = class156.method3300(var0, client.field518);
            if(null != var2) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < client.field565; ++var3) {
                  class7 var4 = client.field566[var3];
                  var5 = class156.method3300(var4.field132, client.field518);
                  if(var5 != null && var5.equals(var2)) {
                     class78.method1721(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(null != var4.field131) {
                     var6 = class156.method3300(var4.field131, client.field518);
                     if(var6 != null && var6.equals(var2)) {
                        class78.method1721(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < client.field391; ++var3) {
                  class17 var7 = client.field456[var3];
                  var5 = class156.method3300(var7.field250, client.field518);
                  if(null != var5 && var5.equals(var2)) {
                     class78.method1721(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(null != var7.field246) {
                     var6 = class156.method3300(var7.field246, client.field518);
                     if(var6 != null && var6.equals(var2)) {
                        class78.method1721(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class156.method3300(class3.field65.field58, client.field518).equals(var2)) {
                  class78.method1721(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  client.field337.method2903(93);
                  client.field337.method2783(class54.method1165(var0));
                  client.field337.method2703(var0);
               }
            }
         } else {
            class78.method1721(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)Lclass81;",
      garbageValue = "1733204283"
   )
   public static class81 method47(class170 var0, String var1, String var2) {
      int var3 = var0.method3410(var1);
      int var4 = var0.method3459(var3, var2);
      return class32.method699(var0, var3, var4);
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(Lclass176;B)Ljava/lang/String;",
      garbageValue = "-15"
   )
   static String method48(class176 var0) {
      return class215.method4089(class2.method39(var0)) == 0?null:(null != var0.field2835 && var0.field2835.trim().length() != 0?var0.field2835:null);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)Z",
      garbageValue = "-268789609"
   )
   public static boolean method49(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3411(var1, var2);
      if(null == var3) {
         return false;
      } else {
         class2.method28(var3);
         return true;
      }
   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZS)V",
      garbageValue = "-16101"
   )
   static void method50(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class55.field1180; ++var4) {
         class55 var5 = class1.method14(var4);
         if((!var1 || var5.field1224) && var5.field1178 == -1 && var5.field1183.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class78.field1452 = -1;
               class8.field151 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class8.field151 = var2;
      class110.field1954 = 0;
      class78.field1452 = var3;
      String[] var8 = new String[class78.field1452];

      for(int var9 = 0; var9 < class78.field1452; ++var9) {
         var8[var9] = class1.method14(var2[var9]).field1183;
      }

      class12.method172(var8, class8.field151);
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([Lclass176;IIIIIIII)V",
      garbageValue = "2090838217"
   )
   static final void method51(class176[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class176 var9 = var0[var8];
         if(null != var9 && (!var9.field2855 || var9.field2910 == 0 || var9.field2817 || class2.method39(var9) != 0 || client.field397 == var9 || var9.field2811 == 1338) && var9.field2826 == var1 && (!var9.field2855 || !class9.method132(var9))) {
            int var10 = var6 + var9.field2820;
            int var11 = var9.field2821 + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.field2910 == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.field2910 == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var9.field2822 + var10;
               var19 = var11 + var9.field2823;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var9.field2822 + var10;
               var17 = var11 + var9.field2823;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(client.field466 == var9) {
               client.field474 = true;
               client.field347 = var10;
               client.field476 = var11;
            }

            if(!var9.field2855 || var12 < var14 && var13 < var15) {
               var16 = class143.field2206;
               var17 = class143.field2209;
               if(class143.field2217 != 0) {
                  var16 = class143.field2215;
                  var17 = class143.field2216;
               }

               int var20;
               int var21;
               int var22;
               int var23;
               int var24;
               int var27;
               if(var9.field2811 == 1337) {
                  if(!client.field304 && !client.field434 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(client.field439 == 0 && !client.field448) {
                        class107.method2394("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var20 = 0; var20 < class108.field1931; ++var20) {
                        var21 = class108.field1876[var20];
                        var22 = var21 & 127;
                        var23 = var21 >> 7 & 127;
                        var24 = var21 >> 29 & 3;
                        int var25 = var21 >> 14 & 32767;
                        if(var21 != var19) {
                           var19 = var21;
                           if(var24 == 2 && class136.field2126.method2081(class99.field1701, var22, var23, var21) >= 0) {
                              class42 var50 = class160.method3312(var25);
                              if(null != var50.field986) {
                                 var50 = var50.method847();
                              }

                              if(null == var50) {
                                 continue;
                              }

                              if(client.field439 == 1) {
                                 class107.method2394("Use", client.field447 + " " + "->" + " " + class16.method205('\uffff') + var50.field955, 1, var21, var22, var23);
                              } else if(client.field448) {
                                 if((class27.field675 & 4) == 4) {
                                    class107.method2394(client.field306, client.field452 + " " + "->" + " " + class16.method205('\uffff') + var50.field955, 2, var21, var22, var23);
                                 }
                              } else {
                                 String[] var36 = var50.field972;
                                 if(client.field464) {
                                    var36 = class19.method241(var36);
                                 }

                                 if(null != var36) {
                                    for(int var60 = 4; var60 >= 0; --var60) {
                                       if(var36[var60] != null) {
                                          short var29 = 0;
                                          if(var60 == 0) {
                                             var29 = 3;
                                          }

                                          if(var60 == 1) {
                                             var29 = 4;
                                          }

                                          if(var60 == 2) {
                                             var29 = 5;
                                          }

                                          if(var60 == 3) {
                                             var29 = 6;
                                          }

                                          if(var60 == 4) {
                                             var29 = 1001;
                                          }

                                          class107.method2394(var36[var60], class16.method205('\uffff') + var50.field955, var29, var21, var22, var23);
                                       }
                                    }
                                 }

                                 class107.method2394("Examine", class16.method205('\uffff') + var50.field955, 1002, var50.field952 << 14, var22, var23);
                              }
                           }

                           class36 var28;
                           class2 var39;
                           int[] var51;
                           int var56;
                           if(var24 == 1) {
                              class36 var52 = client.field332[var25];
                              if(null == var52) {
                                 continue;
                              }

                              if(var52.field803.field913 == 1 && (var52.field875 & 127) == 64 && (var52.field832 & 127) == 64) {
                                 for(var27 = 0; var27 < client.field486; ++var27) {
                                    var28 = client.field332[client.field334[var27]];
                                    if(var28 != null && var52 != var28 && var28.field803.field913 == 1 && var52.field875 == var28.field875 && var28.field832 == var52.field832) {
                                       class93.method2163(var28.field803, client.field334[var27], var22, var23);
                                    }
                                 }

                                 var27 = class34.field783;
                                 var51 = class34.field784;

                                 for(var56 = 0; var56 < var27; ++var56) {
                                    var39 = client.field302[var51[var56]];
                                    if(var39 != null && var39.field875 == var52.field875 && var39.field832 == var52.field832) {
                                       class101.method2288(var39, var51[var56], var22, var23);
                                    }
                                 }
                              }

                              class93.method2163(var52.field803, var25, var22, var23);
                           }

                           if(var24 == 0) {
                              class2 var54 = client.field302[var25];
                              if(var54 == null) {
                                 continue;
                              }

                              if((var54.field875 & 127) == 64 && (var54.field832 & 127) == 64) {
                                 for(var27 = 0; var27 < client.field486; ++var27) {
                                    var28 = client.field332[client.field334[var27]];
                                    if(var28 != null && var28.field803.field913 == 1 && var28.field875 == var54.field875 && var54.field832 == var28.field832) {
                                       class93.method2163(var28.field803, client.field334[var27], var22, var23);
                                    }
                                 }

                                 var27 = class34.field783;
                                 var51 = class34.field784;

                                 for(var56 = 0; var56 < var27; ++var56) {
                                    var39 = client.field302[var51[var56]];
                                    if(var39 != null && var54 != var39 && var39.field875 == var54.field875 && var39.field832 == var54.field832) {
                                       class101.method2288(var39, var51[var56], var22, var23);
                                    }
                                 }
                              }

                              if(client.field425 != var25) {
                                 class101.method2288(var54, var25, var22, var23);
                              } else {
                                 var18 = var21;
                              }
                           }

                           if(var24 == 3) {
                              class202 var55 = client.field426[class99.field1701][var22][var23];
                              if(var55 != null) {
                                 for(class30 var59 = (class30)var55.method3969(); var59 != null; var59 = (class30)var55.method3971()) {
                                    class55 var53 = class1.method14(var59.field714);
                                    if(client.field439 == 1) {
                                       class107.method2394("Use", client.field447 + " " + "->" + " " + class16.method205(16748608) + var53.field1183, 16, var59.field714, var22, var23);
                                    } else if(client.field448) {
                                       if((class27.field675 & 1) == 1) {
                                          class107.method2394(client.field306, client.field452 + " " + "->" + " " + class16.method205(16748608) + var53.field1183, 17, var59.field714, var22, var23);
                                       }
                                    } else {
                                       String[] var41 = var53.field1200;
                                       if(client.field464) {
                                          var41 = class19.method241(var41);
                                       }

                                       for(int var30 = 4; var30 >= 0; --var30) {
                                          if(null != var41 && null != var41[var30]) {
                                             byte var31 = 0;
                                             if(var30 == 0) {
                                                var31 = 18;
                                             }

                                             if(var30 == 1) {
                                                var31 = 19;
                                             }

                                             if(var30 == 2) {
                                                var31 = 20;
                                             }

                                             if(var30 == 3) {
                                                var31 = 21;
                                             }

                                             if(var30 == 4) {
                                                var31 = 22;
                                             }

                                             class107.method2394(var41[var30], class16.method205(16748608) + var53.field1183, var31, var59.field714, var22, var23);
                                          } else if(var30 == 2) {
                                             class107.method2394("Take", class16.method205(16748608) + var53.field1183, 20, var59.field714, var22, var23);
                                          }
                                       }

                                       class107.method2394("Examine", class16.method205(16748608) + var53.field1183, 1004, var59.field714, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var20 = var18 & 127;
                        var21 = var18 >> 7 & 127;
                        class2 var62 = client.field302[client.field425];
                        class101.method2288(var62, client.field425, var20, var21);
                     }
                  }
               } else if(var9.field2811 == 1338) {
                  class128.method2955(var9, var10, var11);
               } else {
                  boolean var45;
                  if(!client.field434 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var18 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2810 == 1) {
                        class107.method2394(var9.field2880, "", 24, 0, 0, var9.field2807);
                     }

                     String var42;
                     if(var9.field2810 == 2 && !client.field448) {
                        var42 = method48(var9);
                        if(null != var42) {
                           class107.method2394(var42, class16.method205('\uff00') + var9.field2809, 25, 0, -1, var9.field2807);
                        }
                     }

                     if(var9.field2810 == 3) {
                        class107.method2394("Close", "", 26, 0, 0, var9.field2807);
                     }

                     if(var9.field2810 == 4) {
                        class107.method2394(var9.field2880, "", 28, 0, 0, var9.field2807);
                     }

                     if(var9.field2810 == 5) {
                        class107.method2394(var9.field2880, "", 29, 0, 0, var9.field2807);
                     }

                     if(var9.field2810 == 6 && client.field376 == null) {
                        class107.method2394(var9.field2880, "", 30, 0, -1, var9.field2807);
                     }

                     if(var9.field2910 == 2) {
                        var20 = 0;

                        for(var21 = 0; var21 < var9.field2823; ++var21) {
                           for(var22 = 0; var22 < var9.field2822; ++var22) {
                              var23 = var22 * (var9.field2873 + 32);
                              var24 = (32 + var9.field2874) * var21;
                              if(var20 < 20) {
                                 var23 += var9.field2875[var20];
                                 var24 += var9.field2876[var20];
                              }

                              if(var18 >= var23 && var19 >= var24 && var18 < var23 + 32 && var19 < var24 + 32) {
                                 client.field484 = var20;
                                 class132.field2104 = var9;
                                 if(var9.field2905[var20] > 0) {
                                    class55 var38 = class1.method14(var9.field2905[var20] - 1);
                                    if(client.field439 == 1 && class126.method2929(class2.method39(var9))) {
                                       if(class97.field1688 != var9.field2807 || class23.field618 != var20) {
                                          class107.method2394("Use", client.field447 + " " + "->" + " " + class16.method205(16748608) + var38.field1183, 31, var38.field1184, var20, var9.field2807);
                                       }
                                    } else if(client.field448 && class126.method2929(class2.method39(var9))) {
                                       if((class27.field675 & 16) == 16) {
                                          class107.method2394(client.field306, client.field452 + " " + "->" + " " + class16.method205(16748608) + var38.field1183, 32, var38.field1184, var20, var9.field2807);
                                       }
                                    } else {
                                       String[] var26 = var38.field1181;
                                       if(client.field464) {
                                          var26 = class19.method241(var26);
                                       }

                                       byte var32;
                                       if(class126.method2929(class2.method39(var9))) {
                                          for(var27 = 4; var27 >= 3; --var27) {
                                             if(var26 != null && var26[var27] != null) {
                                                if(var27 == 3) {
                                                   var32 = 36;
                                                } else {
                                                   var32 = 37;
                                                }

                                                class107.method2394(var26[var27], class16.method205(16748608) + var38.field1183, var32, var38.field1184, var20, var9.field2807);
                                             } else if(var27 == 4) {
                                                class107.method2394("Drop", class16.method205(16748608) + var38.field1183, 37, var38.field1184, var20, var9.field2807);
                                             }
                                          }
                                       }

                                       if(class51.method1117(class2.method39(var9))) {
                                          class107.method2394("Use", class16.method205(16748608) + var38.field1183, 38, var38.field1184, var20, var9.field2807);
                                       }

                                       if(class126.method2929(class2.method39(var9)) && null != var26) {
                                          for(var27 = 2; var27 >= 0; --var27) {
                                             if(var26[var27] != null) {
                                                var32 = 0;
                                                if(var27 == 0) {
                                                   var32 = 33;
                                                }

                                                if(var27 == 1) {
                                                   var32 = 34;
                                                }

                                                if(var27 == 2) {
                                                   var32 = 35;
                                                }

                                                class107.method2394(var26[var27], class16.method205(16748608) + var38.field1183, var32, var38.field1184, var20, var9.field2807);
                                             }
                                          }
                                       }

                                       var26 = var9.field2878;
                                       if(client.field464) {
                                          var26 = class19.method241(var26);
                                       }

                                       if(var26 != null) {
                                          for(var27 = 4; var27 >= 0; --var27) {
                                             if(null != var26[var27]) {
                                                var32 = 0;
                                                if(var27 == 0) {
                                                   var32 = 39;
                                                }

                                                if(var27 == 1) {
                                                   var32 = 40;
                                                }

                                                if(var27 == 2) {
                                                   var32 = 41;
                                                }

                                                if(var27 == 3) {
                                                   var32 = 42;
                                                }

                                                if(var27 == 4) {
                                                   var32 = 43;
                                                }

                                                class107.method2394(var26[var27], class16.method205(16748608) + var38.field1183, var32, var38.field1184, var20, var9.field2807);
                                             }
                                          }
                                       }

                                       class107.method2394("Examine", class16.method205(16748608) + var38.field1183, 1005, var38.field1184, var20, var9.field2807);
                                    }
                                 }
                              }

                              ++var20;
                           }
                        }
                     }

                     if(var9.field2855) {
                        if(client.field448) {
                           var21 = class2.method39(var9);
                           var45 = (var21 >> 21 & 1) != 0;
                           if(var45 && (class27.field675 & 32) == 32) {
                              class107.method2394(client.field306, client.field452 + " " + "->" + " " + var9.field2902, 58, 0, var9.field2813, var9.field2807);
                           }
                        } else {
                           for(var20 = 9; var20 >= 5; --var20) {
                              var23 = class2.method39(var9);
                              boolean var48 = (var23 >> 1 + var20 & 1) != 0;
                              String var33;
                              if(!var48 && var9.field2907 == null) {
                                 var33 = null;
                              } else if(null != var9.field2915 && var9.field2915.length > var20 && null != var9.field2915[var20] && var9.field2915[var20].trim().length() != 0) {
                                 var33 = var9.field2915[var20];
                              } else {
                                 var33 = null;
                              }

                              if(var33 != null) {
                                 class107.method2394(var33, var9.field2902, 1007, 1 + var20, var9.field2813, var9.field2807);
                              }
                           }

                           var42 = method48(var9);
                           if(null != var42) {
                              class107.method2394(var42, var9.field2902, 25, 0, var9.field2813, var9.field2807);
                           }

                           for(var21 = 4; var21 >= 0; --var21) {
                              var24 = class2.method39(var9);
                              boolean var49 = (var24 >> 1 + var21 & 1) != 0;
                              String var40;
                              if(!var49 && null == var9.field2907) {
                                 var40 = null;
                              } else if(null != var9.field2915 && var9.field2915.length > var21 && null != var9.field2915[var21] && var9.field2915[var21].trim().length() != 0) {
                                 var40 = var9.field2915[var21];
                              } else {
                                 var40 = null;
                              }

                              if(null != var40) {
                                 class107.method2394(var40, var9.field2902, 57, var21 + 1, var9.field2813, var9.field2807);
                              }
                           }

                           if(class128.method2956(class2.method39(var9))) {
                              class107.method2394("Continue", "", 30, 0, var9.field2813, var9.field2807);
                           }
                        }
                     }
                  }

                  if(var9.field2910 == 0) {
                     if(!var9.field2855 && class9.method132(var9) && var9 != class11.field177) {
                        continue;
                     }

                     method51(var0, var9.field2807, var12, var13, var14, var15, var10 - var9.field2864, var11 - var9.field2850);
                     if(null != var9.field2931) {
                        method51(var9.field2931, var9.field2807, var12, var13, var14, var15, var10 - var9.field2864, var11 - var9.field2850);
                     }

                     class3 var34 = (class3)client.field475.method3936((long)var9.field2807);
                     if(null != var34) {
                        if(var34.field60 == 0 && class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15 && !client.field434 && !client.field471) {
                           for(class0 var35 = (class0)client.field353.method3980(); null != var35; var35 = (class0)client.field353.method3970()) {
                              if(var35.field1) {
                                 var35.method4067();
                                 var35.field2.field2932 = false;
                              }
                           }

                           if(class188.field3055 == 0) {
                              client.field466 = null;
                              client.field397 = null;
                           }

                           if(!client.field434) {
                              client.field440[0] = "Cancel";
                              client.field510[0] = "";
                              client.field438[0] = 1006;
                              client.field368 = 1;
                           }
                        }

                        var19 = var34.field70;
                        if(class14.method179(var19)) {
                           method51(class176.field2836[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2855) {
                     class0 var57;
                     if(!var9.field2940) {
                        if(var9.field2913 && class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15) {
                           for(var57 = (class0)client.field353.method3980(); null != var57; var57 = (class0)client.field353.method3970()) {
                              if(var57.field1 && var57.field2.field2838 == var57.field8) {
                                 var57.method4067();
                              }
                           }
                        }
                     } else if(class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15) {
                        for(var57 = (class0)client.field353.method3980(); null != var57; var57 = (class0)client.field353.method3970()) {
                           if(var57.field1) {
                              var57.method4067();
                              var57.field2.field2932 = false;
                           }
                        }

                        if(class188.field3055 == 0) {
                           client.field466 = null;
                           client.field397 = null;
                        }

                        if(!client.field434) {
                           client.field440[0] = "Cancel";
                           client.field510[0] = "";
                           client.field438[0] = 1006;
                           client.field368 = 1;
                        }
                     }

                     boolean var44;
                     if(class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15) {
                        var44 = true;
                     } else {
                        var44 = false;
                     }

                     boolean var46 = false;
                     if((class143.field2207 == 1 || !class214.field3188 && class143.field2207 == 4) && var44) {
                        var46 = true;
                     }

                     var45 = false;
                     if((class143.field2217 == 1 || !class214.field3188 && class143.field2217 == 4) && class143.field2215 >= var12 && class143.field2216 >= var13 && class143.field2215 < var14 && class143.field2216 < var15) {
                        var45 = true;
                     }

                     if(var45) {
                        class13.method175(var9, class143.field2215 - var10, class143.field2216 - var11);
                     }

                     if(client.field466 != null && var9 != client.field466 && var44) {
                        var22 = class2.method39(var9);
                        boolean var47 = (var22 >> 20 & 1) != 0;
                        if(var47) {
                           client.field470 = var9;
                        }
                     }

                     if(var9 == client.field397) {
                        client.field346 = true;
                        client.field543 = var10;
                        client.field295 = var11;
                     }

                     if(var9.field2817) {
                        class0 var58;
                        if(var44 && client.field491 != 0 && null != var9.field2838) {
                           var58 = new class0();
                           var58.field1 = true;
                           var58.field2 = var9;
                           var58.field4 = client.field491;
                           var58.field8 = var9.field2838;
                           client.field353.method3963(var58);
                        }

                        if(client.field466 != null || class23.field614 != null || client.field434) {
                           var45 = false;
                           var46 = false;
                           var44 = false;
                        }

                        if(!var9.field2887 && var45) {
                           var9.field2887 = true;
                           if(null != var9.field2889) {
                              var58 = new class0();
                              var58.field1 = true;
                              var58.field2 = var9;
                              var58.field5 = class143.field2215 - var10;
                              var58.field4 = class143.field2216 - var11;
                              var58.field8 = var9.field2889;
                              client.field353.method3963(var58);
                           }
                        }

                        if(var9.field2887 && var46 && var9.field2890 != null) {
                           var58 = new class0();
                           var58.field1 = true;
                           var58.field2 = var9;
                           var58.field5 = class143.field2206 - var10;
                           var58.field4 = class143.field2209 - var11;
                           var58.field8 = var9.field2890;
                           client.field353.method3963(var58);
                        }

                        if(var9.field2887 && !var46) {
                           var9.field2887 = false;
                           if(null != var9.field2891) {
                              var58 = new class0();
                              var58.field1 = true;
                              var58.field2 = var9;
                              var58.field5 = class143.field2206 - var10;
                              var58.field4 = class143.field2209 - var11;
                              var58.field8 = var9.field2891;
                              client.field494.method3963(var58);
                           }
                        }

                        if(var46 && null != var9.field2828) {
                           var58 = new class0();
                           var58.field1 = true;
                           var58.field2 = var9;
                           var58.field5 = class143.field2206 - var10;
                           var58.field4 = class143.field2209 - var11;
                           var58.field8 = var9.field2828;
                           client.field353.method3963(var58);
                        }

                        if(!var9.field2932 && var44) {
                           var9.field2932 = true;
                           if(var9.field2893 != null) {
                              var58 = new class0();
                              var58.field1 = true;
                              var58.field2 = var9;
                              var58.field5 = class143.field2206 - var10;
                              var58.field4 = class143.field2209 - var11;
                              var58.field8 = var9.field2893;
                              client.field353.method3963(var58);
                           }
                        }

                        if(var9.field2932 && var44 && null != var9.field2894) {
                           var58 = new class0();
                           var58.field1 = true;
                           var58.field2 = var9;
                           var58.field5 = class143.field2206 - var10;
                           var58.field4 = class143.field2209 - var11;
                           var58.field8 = var9.field2894;
                           client.field353.method3963(var58);
                        }

                        if(var9.field2932 && !var44) {
                           var9.field2932 = false;
                           if(var9.field2895 != null) {
                              var58 = new class0();
                              var58.field1 = true;
                              var58.field2 = var9;
                              var58.field5 = class143.field2206 - var10;
                              var58.field4 = class143.field2209 - var11;
                              var58.field8 = var9.field2895;
                              client.field494.method3963(var58);
                           }
                        }

                        if(var9.field2881 != null) {
                           var58 = new class0();
                           var58.field2 = var9;
                           var58.field8 = var9.field2881;
                           client.field335.method3963(var58);
                        }

                        class0 var37;
                        if(var9.field2833 != null && client.field366 > var9.field2935) {
                           if(var9.field2901 != null && client.field366 - var9.field2935 <= 32) {
                              label1380:
                              for(var21 = var9.field2935; var21 < client.field366; ++var21) {
                                 var22 = client.field479[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2901.length; ++var23) {
                                    if(var22 == var9.field2901[var23]) {
                                       var37 = new class0();
                                       var37.field2 = var9;
                                       var37.field8 = var9.field2833;
                                       client.field353.method3963(var37);
                                       break label1380;
                                    }
                                 }
                              }
                           } else {
                              var58 = new class0();
                              var58.field2 = var9;
                              var58.field8 = var9.field2833;
                              client.field353.method3963(var58);
                           }

                           var9.field2935 = client.field366;
                        }

                        if(null != var9.field2906 && client.field482 > var9.field2936) {
                           if(null != var9.field2805 && client.field482 - var9.field2936 <= 32) {
                              label1356:
                              for(var21 = var9.field2936; var21 < client.field482; ++var21) {
                                 var22 = client.field481[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2805.length; ++var23) {
                                    if(var9.field2805[var23] == var22) {
                                       var37 = new class0();
                                       var37.field2 = var9;
                                       var37.field8 = var9.field2906;
                                       client.field353.method3963(var37);
                                       break label1356;
                                    }
                                 }
                              }
                           } else {
                              var58 = new class0();
                              var58.field2 = var9;
                              var58.field8 = var9.field2906;
                              client.field353.method3963(var58);
                           }

                           var9.field2936 = client.field482;
                        }

                        if(null != var9.field2904 && client.field328 > var9.field2937) {
                           if(var9.field2871 != null && client.field328 - var9.field2937 <= 32) {
                              label1332:
                              for(var21 = var9.field2937; var21 < client.field328; ++var21) {
                                 var22 = client.field483[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2871.length; ++var23) {
                                    if(var22 == var9.field2871[var23]) {
                                       var37 = new class0();
                                       var37.field2 = var9;
                                       var37.field8 = var9.field2904;
                                       client.field353.method3963(var37);
                                       break label1332;
                                    }
                                 }
                              }
                           } else {
                              var58 = new class0();
                              var58.field2 = var9;
                              var58.field8 = var9.field2904;
                              client.field353.method3963(var58);
                           }

                           var9.field2937 = client.field328;
                        }

                        if(client.field485 > var9.field2934 && null != var9.field2870) {
                           var58 = new class0();
                           var58.field2 = var9;
                           var58.field8 = var9.field2870;
                           client.field353.method3963(var58);
                        }

                        if(client.field385 > var9.field2934 && var9.field2911 != null) {
                           var58 = new class0();
                           var58.field2 = var9;
                           var58.field8 = var9.field2911;
                           client.field353.method3963(var58);
                        }

                        if(client.field487 > var9.field2934 && var9.field2912 != null) {
                           var58 = new class0();
                           var58.field2 = var9;
                           var58.field8 = var9.field2912;
                           client.field353.method3963(var58);
                        }

                        if(client.field488 > var9.field2934 && null != var9.field2900) {
                           var58 = new class0();
                           var58.field2 = var9;
                           var58.field8 = var9.field2900;
                           client.field353.method3963(var58);
                        }

                        if(client.field416 > var9.field2934 && var9.field2918 != null) {
                           var58 = new class0();
                           var58.field2 = var9;
                           var58.field8 = var9.field2918;
                           client.field353.method3963(var58);
                        }

                        if(client.field490 > var9.field2934 && null != var9.field2903) {
                           var58 = new class0();
                           var58.field2 = var9;
                           var58.field8 = var9.field2903;
                           client.field353.method3963(var58);
                        }

                        var9.field2934 = client.field478;
                        if(var9.field2858 != null) {
                           for(var21 = 0; var21 < client.field318; ++var21) {
                              class0 var61 = new class0();
                              var61.field2 = var9;
                              var61.field3 = client.field512[var21];
                              var61.field9 = client.field473[var21];
                              var61.field8 = var9.field2858;
                              client.field353.method3963(var61);
                           }
                        }
                     }
                  }

                  if(!var9.field2855 && null == client.field466 && class23.field614 == null && !client.field434) {
                     if((var9.field2896 >= 0 || var9.field2834 != 0) && class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15) {
                        if(var9.field2896 >= 0) {
                           class11.field177 = var0[var9.field2896];
                        } else {
                           class11.field177 = var9;
                        }
                     }

                     if(var9.field2910 == 8 && class143.field2206 >= var12 && class143.field2209 >= var13 && class143.field2206 < var14 && class143.field2209 < var15) {
                        class19.field278 = var9;
                     }

                     if(var9.field2831 > var9.field2823) {
                        class36.method778(var9, var10 + var9.field2822, var11, var9.field2823, var9.field2831, class143.field2206, class143.field2209);
                     }
                  }
               }
            }
         }
      }

   }
}
