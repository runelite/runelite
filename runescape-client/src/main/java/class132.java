import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public final class class132 {
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = -1218371803
   )
   static int field2102;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -131779075
   )
   protected static int field2109;

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1409213543"
   )
   static void method2934() {
      for(class3 var0 = (class3)client.field455.method3867(); var0 != null; var0 = (class3)client.field455.method3868()) {
         int var1 = var0.field60;
         if(class10.method112(var1)) {
            boolean var2 = true;
            class176[] var3 = class176.field2811[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2793;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3161;
               class176 var5 = class19.method212(var4);
               if(var5 != null) {
                  class51.method1124(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1267456455"
   )
   public static void method2935() {
      class41.field920.method3835();
      class41.field918.method3835();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "755743114"
   )
   static void method2936(int var0, int var1, int var2) {
      if(client.field376 != 0 && var1 != 0 && client.field535 < 50) {
         client.field370[client.field535] = var0;
         client.field539[client.field535] = var1;
         client.field449[client.field535] = var2;
         client.field494[client.field535] = null;
         client.field291[client.field535] = 0;
         ++client.field535;
      }

   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "126"
   )
   static final void method2937(String var0, boolean var1) {
      if(var0 != null) {
         if((client.field346 < 100 || client.field418 == 1) && client.field346 < 400) {
            String var2 = class17.method167(var0, client.field296);
            if(null != var2) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < client.field346; ++var3) {
                  class7 var4 = client.field560[var3];
                  var5 = class17.method167(var4.field141, client.field296);
                  if(var5 != null && var5.equals(var2)) {
                     class25.method586(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(null != var4.field131) {
                     var6 = class17.method167(var4.field131, client.field296);
                     if(null != var6 && var6.equals(var2)) {
                        class25.method586(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < client.field511; ++var3) {
                  class17 var7 = client.field564[var3];
                  var5 = class17.method167(var7.field253, client.field296);
                  if(null != var5 && var5.equals(var2)) {
                     class25.method586(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(null != var7.field257) {
                     var6 = class17.method167(var7.field257, client.field296);
                     if(var6 != null && var6.equals(var2)) {
                        class25.method586(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class17.method167(class118.field2035.field52, client.field296).equals(var2)) {
                  class25.method586(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  client.field336.method2854(41);
                  client.field336.method2795(class29.method650(var0));
                  client.field336.method2601(var0);
               }
            }
         } else {
            class25.method586(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIIIII)V",
      garbageValue = "1077664454"
   )
   static final void method2938(class39 var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod787()) {
         if(var0 instanceof class36) {
            class41 var6 = ((class36)var0).field825;
            if(var6.field948 != null) {
               var6 = var6.method824();
            }

            if(var6 == null) {
               return;
            }
         }

         int var74 = class34.field804;
         int[] var7 = class34.field807;
         int var8 = 3;
         int var14;
         int var21;
         if(!var0.field875.method3934()) {
            class55.method1222(var0, var0.field855 + 15);

            for(class26 var9 = (class26)var0.field875.method3938(); null != var9; var9 = (class26)var0.field875.method3940()) {
               class20 var10 = var9.method589(client.field567);
               if(var10 == null) {
                  if(var9.method599()) {
                     var9.method4000();
                  }
               } else {
                  class49 var11 = var9.field667;
                  class81 var12 = var11.method1054();
                  class81 var13 = var11.method1055();
                  if(var12 != null && null != var13) {
                     var14 = var13.field1466;
                  } else if(var1 < var74) {
                     var14 = 30;
                  } else {
                     class41 var76 = ((class36)var0).field825;
                     var14 = var76.field927;
                  }

                  int var15 = 255;
                  boolean var16 = true;
                  int var17 = client.field567 - var10.field588;
                  int var18 = var14 * var10.field584 / 255;
                  int var19;
                  int var20;
                  int var88;
                  if(var10.field590 > var17) {
                     var19 = var11.field1103 == 0?0:var11.field1103 * (var17 / var11.field1103);
                     var20 = var10.field582 * var14 / 255;
                     var88 = var20 + var19 * (var18 - var20) / var10.field590;
                  } else {
                     var88 = var18;
                     var19 = var11.field1104 + var10.field590 - var17;
                     if(var11.field1101 >= 0) {
                        var15 = (var19 << 8) / (var11.field1104 - var11.field1101);
                     }
                  }

                  if(var10.field584 > 0 && var88 < 2) {
                     var88 = 2;
                  }

                  var19 = var2 + client.field401 - (var14 >> 1);
                  var20 = client.field322 + var3 - var8;
                  if(var12 != null && var13 != null) {
                     var21 = var12.field1467;
                     var8 += var21;
                     if(var15 >= 0 && var15 < 255) {
                        var12.method1807(var19, var20, var15);
                        class82.method1884(var19, var20, var88 + var19, var21 + var20);
                        var13.method1807(var19, var20, var15);
                     } else {
                        var12.method1873(var19, var20);
                        class82.method1884(var19, var20, var19 + var88, var20 + var21);
                        var13.method1873(var19, var20);
                     }

                     class82.method1934(var2, var3, var4 + var2, var5 + var3);
                     var8 += 2;
                  } else {
                     if(client.field401 > -1) {
                        class82.method1911(var19, var20, var88, 5, '\uff00');
                        class82.method1911(var88 + var19, var20, var14 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var74) {
            class2 var85 = (class2)var0;
            if(var85.field51) {
               return;
            }

            if(var85.field31 != -1 || var85.field44 != -1) {
               class55.method1222(var0, var0.field855 + 15);
               if(client.field401 > -1) {
                  if(var85.field31 != -1) {
                     class101.field1747[var85.field31].method1873(var2 + client.field401 - 12, client.field322 + var3 - var8);
                     var8 += 25;
                  }

                  if(var85.field44 != -1) {
                     class19.field274[var85.field44].method1873(client.field401 + var2 - 12, client.field322 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && client.field294 == 10 && client.field313 == var7[var1]) {
               class55.method1222(var0, 15 + var0.field855);
               if(client.field401 > -1) {
                  class184.field2977[1].method1873(client.field401 + var2 - 12, client.field322 + var3 - var8);
               }
            }
         } else {
            class41 var86 = ((class36)var0).field825;
            if(null != var86.field948) {
               var86 = var86.method824();
            }

            if(var86.field946 >= 0 && var86.field946 < class19.field274.length) {
               class55.method1222(var0, var0.field855 + 15);
               if(client.field401 > -1) {
                  class19.field274[var86.field946].method1873(client.field401 + var2 - 12, var3 + client.field322 - 30);
               }
            }

            if(client.field294 == 1 && client.field312 == client.field333[var1 - var74] && client.field567 % 20 < 10) {
               class55.method1222(var0, var0.field855 + 15);
               if(client.field401 > -1) {
                  class184.field2977[0].method1873(var2 + client.field401 - 12, client.field322 + var3 - 28);
               }
            }
         }

         if(null != var0.field873 && (var1 >= var74 || !var0.field897 && (client.field513 == 4 || !var0.field864 && (client.field513 == 0 || client.field513 == 3 || client.field513 == 1 && class75.method1669(((class2)var0).field52, false))))) {
            class55.method1222(var0, var0.field855);
            if(client.field401 > -1 && client.field389 < client.field534) {
               client.field391[client.field389] = class146.field2233.method4179(var0.field873) / 2;
               client.field393[client.field389] = class146.field2233.field3242;
               client.field410[client.field389] = client.field401;
               client.field392[client.field389] = client.field322;
               client.field480[client.field389] = var0.field867;
               client.field453[client.field389] = var0.field868;
               client.field397[client.field389] = var0.field866;
               client.field398[client.field389] = var0.field873;
               ++client.field389;
            }
         }

         for(int var80 = 0; var80 < 4; ++var80) {
            int var81 = var0.field872[var80];
            int var82 = var0.field870[var80];
            class51 var87 = null;
            int var75 = 0;
            if(var82 >= 0) {
               if(var81 <= client.field567) {
                  continue;
               }

               var87 = class56.method1223(var0.field870[var80]);
               var75 = var87.field1129;
            } else if(var81 < 0) {
               continue;
            }

            var14 = var0.field901[var80];
            class51 var90 = null;
            if(var14 >= 0) {
               var90 = class56.method1223(var14);
            }

            if(var81 - var75 <= client.field567) {
               if(null == var87) {
                  var0.field872[var80] = -1;
               } else {
                  class55.method1222(var0, var0.field855 / 2);
                  if(client.field401 > -1) {
                     if(var80 == 1) {
                        client.field322 -= 20;
                     }

                     if(var80 == 2) {
                        client.field401 -= 15;
                        client.field322 -= 10;
                     }

                     if(var80 == 3) {
                        client.field401 += 15;
                        client.field322 -= 10;
                     }

                     class81 var79 = null;
                     class81 var78 = null;
                     class81 var83 = null;
                     class81 var77 = null;
                     var21 = 0;
                     int var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     class81 var29 = null;
                     class81 var30 = null;
                     class81 var31 = null;
                     class81 var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var79 = var87.method1091();
                     int var42;
                     if(var79 != null) {
                        var21 = var79.field1466;
                        var42 = var79.field1467;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var79.field1468;
                     }

                     var78 = var87.method1109();
                     if(var78 != null) {
                        var22 = var78.field1466;
                        var42 = var78.field1467;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var78.field1468;
                     }

                     var83 = var87.method1093();
                     if(var83 != null) {
                        var23 = var83.field1466;
                        var42 = var83.field1467;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var83.field1468;
                     }

                     var77 = var87.method1116();
                     if(null != var77) {
                        var24 = var77.field1466;
                        var42 = var77.field1467;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var77.field1468;
                     }

                     if(var90 != null) {
                        var29 = var90.method1091();
                        if(var29 != null) {
                           var33 = var29.field1466;
                           var42 = var29.field1467;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.field1468;
                        }

                        var30 = var90.method1109();
                        if(var30 != null) {
                           var34 = var30.field1466;
                           var42 = var30.field1467;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.field1468;
                        }

                        var31 = var90.method1093();
                        if(var31 != null) {
                           var35 = var31.field1466;
                           var42 = var31.field1467;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.field1468;
                        }

                        var32 = var90.method1116();
                        if(null != var32) {
                           var36 = var32.field1466;
                           var42 = var32.field1467;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.field1468;
                        }
                     }

                     class227 var84 = var87.method1095();
                     if(var84 == null) {
                        var84 = class164.field2683;
                     }

                     class227 var43;
                     if(var90 != null) {
                        var43 = var90.method1095();
                        if(var43 == null) {
                           var43 = class164.field2683;
                        }
                     } else {
                        var43 = class164.field2683;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method1090(var0.field871[var80]);
                     int var89 = var84.method4179(var44);
                     if(var90 != null) {
                        var45 = var90.method1090(var0.field874[var80]);
                        var47 = var43.method4179(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var83 == null && null == var77) {
                           var48 = 1;
                        } else {
                           var48 = 1 + var89 / var22;
                        }
                     }

                     if(null != var90 && var34 > 0) {
                        if(null == var31 && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = 1 + var47 / var34;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var48 * var22;
                        var50 += var55;
                        var54 += (var55 - var89) / 2;
                     } else {
                        var50 += var89;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var90 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var49 * var34;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.field872[var80] - client.field567;
                     int var62 = var87.field1121 - var61 * var87.field1121 / var87.field1129;
                     int var63 = var87.field1122 * var61 / var87.field1129 + -var87.field1122;
                     int var64 = var2 + client.field401 - (var50 >> 1) + var62;
                     int var65 = client.field322 + var3 - 12 + var63;
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = 15 + var65 + var87.field1139;
                     int var69 = var68 - var84.field3236;
                     int var70 = var68 + var84.field3237;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var90 != null) {
                        var71 = var90.field1139 + var65 + 15;
                        var72 = var71 - var43.field3236;
                        var73 = var43.field3237 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field1120 >= 0) {
                        var72 = (var61 << 8) / (var87.field1129 - var87.field1120);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(null != var79) {
                           var79.method1807(var51 + var64 - var25, var65, var72);
                        }

                        if(var83 != null) {
                           var83.method1807(var52 + var64 - var27, var65, var72);
                        }

                        if(null != var78) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var78.method1807(var22 * var73 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(null != var77) {
                           var77.method1807(var64 + var55 - var28, var65, var72);
                        }

                        var84.method4113(var44, var54 + var64, var68, var87.field1128, 0, var72);
                        if(null != var90) {
                           if(null != var29) {
                              var29.method1807(var64 + var56 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method1807(var57 + var64 - var39, var65, var72);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1807(var64 + var58 - var38 + var34 * var73, var65, var72);
                              }
                           }

                           if(null != var32) {
                              var32.method1807(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4113(var45, var64 + var60, var71, var90.field1128, 0, var72);
                        }
                     } else {
                        if(null != var79) {
                           var79.method1873(var64 + var51 - var25, var65);
                        }

                        if(null != var83) {
                           var83.method1873(var52 + var64 - var27, var65);
                        }

                        if(var78 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var78.method1873(var64 + var53 - var26 + var22 * var73, var65);
                           }
                        }

                        if(null != var77) {
                           var77.method1873(var55 + var64 - var28, var65);
                        }

                        var84.method4177(var44, var64 + var54, var68, var87.field1128 | -16777216, 0);
                        if(var90 != null) {
                           if(null != var29) {
                              var29.method1873(var64 + var56 - var37, var65);
                           }

                           if(null != var31) {
                              var31.method1873(var64 + var57 - var39, var65);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1873(var64 + var58 - var38 + var34 * var73, var65);
                              }
                           }

                           if(null != var32) {
                              var32.method1873(var59 + var64 - var40, var65);
                           }

                           var43.method4177(var45, var60 + var64, var71, var90.field1128 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
