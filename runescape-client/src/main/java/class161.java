import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class161 {
   @ObfuscatedName("j")
   static char[] field2647;
   @ObfuscatedName("p")
   static int[] field2649;
   @ObfuscatedName("s")
   static char[] field2650 = new char[64];

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass86;Lclass108;I)V",
      garbageValue = "-705494666"
   )
   static final void method3164(int var0, int var1, int var2, int var3, int var4, int var5, class86 var6, class108 var7) {
      if(!client.field493 || (class5.field90[0][var1][var2] & 2) != 0 || 0 == (class5.field90[var0][var1][var2] & 16)) {
         if(var0 < class5.field81) {
            class5.field81 = var0;
         }

         class40 var8 = class9.method120(var3);
         int var9;
         int var10;
         if(1 != var4 && var4 != 3) {
            var9 = var8.field939;
            var10 = var8.field966;
         } else {
            var9 = var8.field966;
            var10 = var8.field939;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (1 + var9 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = (1 + var10 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class5.field93[var0];
         int var16 = var15[var12][var14] + var15[var12][var13] + var15[var11][var13] + var15[var11][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(0 == var8.field943) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(1 == var8.field964) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method784()) {
            class23 var21 = new class23();
            var21.field606 = var0;
            var21.field599 = var1 * 128;
            var21.field600 = var2 * 128;
            var22 = var8.field939;
            var23 = var8.field966;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.field966;
               var23 = var8.field939;
            }

            var21.field601 = (var1 + var22) * 128;
            var21.field602 = (var23 + var2) * 128;
            var21.field604 = var8.field936;
            var21.field603 = var8.field969 * 128;
            var21.field597 = var8.field940;
            var21.field607 = var8.field968;
            var21.field608 = var8.field972;
            if(null != var8.field965) {
               var21.field611 = var8;
               var21.method573();
            }

            class23.field615.method3807(var21);
            if(null != var21.field608) {
               var21.field609 = var21.field597 + (int)(Math.random() * (double)(var21.field607 - var21.field597));
            }
         }

         Object var26;
         if(var5 == 22) {
            if(!client.field493 || var8.field943 != 0 || 1 == var8.field941 || var8.field944) {
               if(var8.field955 == -1 && null == var8.field965) {
                  var26 = var8.method779(22, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 22, var4, var0, var1, var2, var8.field955, true, (class85)null);
               }

               var6.method2058(var0, var1, var2, var16, (class85)var26, var19, var20);
               if(var8.field941 == 1 && var7 != null) {
                  var7.method2390(var1, var2);
               }

            }
         } else if(var5 != 10 && 11 != var5) {
            if(var5 >= 12) {
               if(var8.field955 == -1 && var8.field965 == null) {
                  var26 = var8.method779(var5, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field955, true, (class85)null);
               }

               var6.method1905(var0, var1, var2, var16, 1, 1, (class85)var26, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && 13 != var5 && var0 > 0) {
                  class211.field3142[var0][var1][var2] |= 2340;
               }

               if(0 != var8.field941 && var7 != null) {
                  var7.method2377(var1, var2, var9, var10, var8.field963);
               }

            } else if(var5 == 0) {
               if(var8.field955 == -1 && var8.field965 == null) {
                  var26 = var8.method779(0, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 0, var4, var0, var1, var2, var8.field955, true, (class85)null);
               }

               var6.method1903(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field87[var4], 0, var19, var20);
               if(0 == var4) {
                  if(var8.field971) {
                     class5.field84[var0][var1][var2] = 50;
                     class5.field84[var0][var1][1 + var2] = 50;
                  }

                  if(var8.field970) {
                     class211.field3142[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field971) {
                     class5.field84[var0][var1][1 + var2] = 50;
                     class5.field84[var0][var1 + 1][1 + var2] = 50;
                  }

                  if(var8.field970) {
                     class211.field3142[var0][var1][1 + var2] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.field971) {
                     class5.field84[var0][var1 + 1][var2] = 50;
                     class5.field84[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field970) {
                     class211.field3142[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.field971) {
                     class5.field84[var0][var1][var2] = 50;
                     class5.field84[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.field970) {
                     class211.field3142[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field941 != 0 && null != var7) {
                  var7.method2376(var1, var2, var5, var4, var8.field963);
               }

               if(var8.field946 != 16) {
                  var6.method1911(var0, var1, var2, var8.field946);
               }

            } else if(var5 == 1) {
               if(var8.field955 == -1 && var8.field965 == null) {
                  var26 = var8.method779(1, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 1, var4, var0, var1, var2, var8.field955, true, (class85)null);
               }

               var6.method1903(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field88[var4], 0, var19, var20);
               if(var8.field971) {
                  if(0 == var4) {
                     class5.field84[var0][var1][var2 + 1] = 50;
                  } else if(1 == var4) {
                     class5.field84[var0][1 + var1][1 + var2] = 50;
                  } else if(var4 == 2) {
                     class5.field84[var0][1 + var1][var2] = 50;
                  } else if(3 == var4) {
                     class5.field84[var0][var1][var2] = 50;
                  }
               }

               if(0 != var8.field941 && var7 != null) {
                  var7.method2376(var1, var2, var5, var4, var8.field963);
               }

            } else {
               int var27;
               Object var28;
               if(2 == var5) {
                  var27 = 1 + var4 & 3;
                  Object var30;
                  if(-1 == var8.field955 && null == var8.field965) {
                     var30 = var8.method779(2, 4 + var4, var15, var17, var16, var18);
                     var28 = var8.method779(2, var27, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field955, true, (class85)null);
                     var28 = new class12(var3, 2, var27, var0, var1, var2, var8.field955, true, (class85)null);
                  }

                  var6.method1903(var0, var1, var2, var16, (class85)var30, (class85)var28, class5.field87[var4], class5.field87[var27], var19, var20);
                  if(var8.field970) {
                     if(0 == var4) {
                        class211.field3142[var0][var1][var2] |= 585;
                        class211.field3142[var0][var1][1 + var2] |= 1170;
                     } else if(1 == var4) {
                        class211.field3142[var0][var1][1 + var2] |= 1170;
                        class211.field3142[var0][1 + var1][var2] |= 585;
                     } else if(var4 == 2) {
                        class211.field3142[var0][var1 + 1][var2] |= 585;
                        class211.field3142[var0][var1][var2] |= 1170;
                     } else if(3 == var4) {
                        class211.field3142[var0][var1][var2] |= 1170;
                        class211.field3142[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field941 != 0 && var7 != null) {
                     var7.method2376(var1, var2, var5, var4, var8.field963);
                  }

                  if(var8.field946 != 16) {
                     var6.method1911(var0, var1, var2, var8.field946);
                  }

               } else if(3 == var5) {
                  if(-1 == var8.field955 && null == var8.field965) {
                     var26 = var8.method779(3, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 3, var4, var0, var1, var2, var8.field955, true, (class85)null);
                  }

                  var6.method1903(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field88[var4], 0, var19, var20);
                  if(var8.field971) {
                     if(var4 == 0) {
                        class5.field84[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class5.field84[var0][1 + var1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class5.field84[var0][1 + var1][var2] = 50;
                     } else if(3 == var4) {
                        class5.field84[var0][var1][var2] = 50;
                     }
                  }

                  if(0 != var8.field941 && null != var7) {
                     var7.method2376(var1, var2, var5, var4, var8.field963);
                  }

               } else if(var5 == 9) {
                  if(-1 == var8.field955 && null == var8.field965) {
                     var26 = var8.method779(var5, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field955, true, (class85)null);
                  }

                  var6.method1905(var0, var1, var2, var16, 1, 1, (class85)var26, 0, var19, var20);
                  if(0 != var8.field941 && var7 != null) {
                     var7.method2377(var1, var2, var9, var10, var8.field963);
                  }

                  if(16 != var8.field946) {
                     var6.method1911(var0, var1, var2, var8.field946);
                  }

               } else if(4 == var5) {
                  if(var8.field955 == -1 && null == var8.field965) {
                     var26 = var8.method779(4, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field955, true, (class85)null);
                  }

                  var6.method1904(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field87[var4], 0, 0, 0, var19, var20);
               } else if(5 == var5) {
                  var27 = 16;
                  var22 = var6.method1964(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class9.method120(var22 >> 14 & 32767).field946;
                  }

                  if(var8.field955 == -1 && null == var8.field965) {
                     var28 = var8.method779(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, var4, var0, var1, var2, var8.field955, true, (class85)null);
                  }

                  var6.method1904(var0, var1, var2, var16, (class85)var28, (class85)null, class5.field87[var4], 0, class5.field89[var4] * var27, var27 * class5.field85[var4], var19, var20);
               } else if(var5 == 6) {
                  var27 = 8;
                  var22 = var6.method1964(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class9.method120(var22 >> 14 & 32767).field946 / 2;
                  }

                  if(-1 == var8.field955 && var8.field965 == null) {
                     var28 = var8.method779(4, 4 + var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field955, true, (class85)null);
                  }

                  var6.method1904(var0, var1, var2, var16, (class85)var28, (class85)null, 256, var4, var27 * class5.field91[var4], var27 * class5.field92[var4], var19, var20);
               } else if(7 == var5) {
                  var22 = var4 + 2 & 3;
                  if(var8.field955 == -1 && var8.field965 == null) {
                     var26 = var8.method779(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, var22 + 4, var0, var1, var2, var8.field955, true, (class85)null);
                  }

                  var6.method1904(var0, var1, var2, var16, (class85)var26, (class85)null, 256, var22, 0, 0, var19, var20);
               } else if(8 == var5) {
                  var27 = 8;
                  var22 = var6.method1964(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class9.method120(var22 >> 14 & 32767).field946 / 2;
                  }

                  int var25 = 2 + var4 & 3;
                  Object var29;
                  if(var8.field955 == -1 && null == var8.field965) {
                     var28 = var8.method779(4, var4 + 4, var15, var17, var16, var18);
                     var29 = var8.method779(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field955, true, (class85)null);
                     var29 = new class12(var3, 4, 4 + var25, var0, var1, var2, var8.field955, true, (class85)null);
                  }

                  var6.method1904(var0, var1, var2, var16, (class85)var28, (class85)var29, 256, var4, class5.field91[var4] * var27, var27 * class5.field92[var4], var19, var20);
               }
            }
         } else {
            if(var8.field955 == -1 && null == var8.field965) {
               var26 = var8.method779(10, var4, var15, var17, var16, var18);
            } else {
               var26 = new class12(var3, 10, var4, var0, var1, var2, var8.field955, true, (class85)null);
            }

            if(null != var26 && var6.method1905(var0, var1, var2, var16, var9, var10, (class85)var26, var5 == 11?256:0, var19, var20) && var8.field971) {
               var22 = 15;
               if(var26 instanceof class105) {
                  var22 = ((class105)var26).method2289() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class5.field84[var0][var1 + var23][var2 + var24]) {
                        class5.field84[var0][var1 + var23][var2 + var24] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.field941 != 0 && var7 != null) {
               var7.method2377(var1, var2, var9, var10, var8.field963);
            }

         }
      }
   }

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2650[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2650[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2650[var0] = (char)(48 + var0 - 52);
      }

      field2650[62] = 43;
      field2650[63] = 47;
      field2647 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2647[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2647[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2647[var0] = (char)(48 + var0 - 52);
      }

      field2647[62] = 42;
      field2647[63] = 45;
      field2649 = new int[128];

      for(var0 = 0; var0 < field2649.length; ++var0) {
         field2649[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2649[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2649[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2649[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field2649;
      field2649[43] = 62;
      var2[42] = 62;
      int[] var1 = field2649;
      field2649[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILclass167;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "2"
   )
   public static void method3166(int var0, class167 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3253(var2);
      int var7 = var1.method3254(var6, var3);
      class183.field2973 = 1;
      class183.field2974 = var1;
      class221.field3184 = var6;
      class151.field2268 = var7;
      class183.field2971 = var4;
      class183.field2977 = var5;
      class183.field2976 = var0;
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIII)V",
      garbageValue = "2087867765"
   )
   static final void method3167(class39 var0, int var1, int var2, int var3) {
      if(client.field496 < 400) {
         if(null != var0.field921) {
            var0 = var0.method740();
         }

         if(null != var0) {
            if(var0.field915) {
               if(!var0.field896 || var1 == client.field445) {
                  String var4 = var0.field918;
                  if(0 != var0.field900) {
                     var4 = var4 + class10.method136(var0.field900, class106.field1881.field39) + " " + " (" + "level-" + var0.field900 + ")";
                  }

                  if(1 == client.field430) {
                     class14.method175("Use", client.field431 + " " + "->" + " " + class12.method163(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field432) {
                     if((class89.field1555 & 2) == 2) {
                        class14.method175(client.field435, client.field436 + " " + "->" + " " + class12.method163(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field902;
                     if(client.field448) {
                        var5 = class49.method976(var5);
                     }

                     int var6;
                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var7 = 0;
                              if(0 == var6) {
                                 var7 = 9;
                              }

                              if(var6 == 1) {
                                 var7 = 10;
                              }

                              if(var6 == 2) {
                                 var7 = 11;
                              }

                              if(3 == var6) {
                                 var7 = 12;
                              }

                              if(var6 == 4) {
                                 var7 = 13;
                              }

                              class14.method175(var5[var6], class12.method163(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(class20.field567 != client.field305) {
                                 if(class20.field565 == client.field305 || client.field305 == class20.field571 && var0.field900 > class106.field1881.field39) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(0 == var6) {
                                    var8 = var9 + 9;
                                 }

                                 if(1 == var6) {
                                    var8 = 10 + var9;
                                 }

                                 if(2 == var6) {
                                    var8 = var9 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(var6 == 4) {
                                    var8 = 13 + var9;
                                 }

                                 class14.method175(var5[var6], class12.method163(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class14.method175("Examine", class12.method163(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }
}
