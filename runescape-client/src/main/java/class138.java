import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class138 {
   @ObfuscatedName("w")
   static File field2135;
   @ObfuscatedName("m")
   static boolean field2136 = false;
   @ObfuscatedName("u")
   public static class62 field2137;
   @ObfuscatedName("e")
   static Hashtable field2140 = new Hashtable(16);
   @ObfuscatedName("j")
   static byte[][][] field2141;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-523926744"
   )
   static final void method2928() {
      int var0 = 64 + class50.field1113 * 128;
      int var1 = class7.field123 * 128 + 64;
      int var2 = class15.method163(var0, var1, class51.field1119) - class127.field2086;
      if(class9.field144 < var0) {
         class9.field144 += class20.field560 * (var0 - class9.field144) / 1000 + class19.field263;
         if(class9.field144 > var0) {
            class9.field144 = var0;
         }
      }

      if(class9.field144 > var0) {
         class9.field144 -= class19.field263 + class20.field560 * (class9.field144 - var0) / 1000;
         if(class9.field144 < var0) {
            class9.field144 = var0;
         }
      }

      if(class24.field622 < var2) {
         class24.field622 += class20.field560 * (var2 - class24.field622) / 1000 + class19.field263;
         if(class24.field622 > var2) {
            class24.field622 = var2;
         }
      }

      if(class24.field622 > var2) {
         class24.field622 -= class20.field560 * (class24.field622 - var2) / 1000 + class19.field263;
         if(class24.field622 < var2) {
            class24.field622 = var2;
         }
      }

      if(class59.field1256 < var1) {
         class59.field1256 += class19.field263 + class20.field560 * (var1 - class59.field1256) / 1000;
         if(class59.field1256 > var1) {
            class59.field1256 = var1;
         }
      }

      if(class59.field1256 > var1) {
         class59.field1256 -= class19.field263 + class20.field560 * (class59.field1256 - var1) / 1000;
         if(class59.field1256 < var1) {
            class59.field1256 = var1;
         }
      }

      var0 = class49.field1087 * 128 + 64;
      var1 = 64 + class16.field219 * 128;
      var2 = class15.method163(var0, var1, class51.field1119) - class22.field585;
      int var3 = var0 - class9.field144;
      int var4 = var2 - class24.field622;
      int var5 = var1 - class59.field1256;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class31.field717 < var7) {
         class31.field717 += class114.field2006 + (var7 - class31.field717) * class44.field1008 / 1000;
         if(class31.field717 > var7) {
            class31.field717 = var7;
         }
      }

      if(class31.field717 > var7) {
         class31.field717 -= class44.field1008 * (class31.field717 - var7) / 1000 + class114.field2006;
         if(class31.field717 < var7) {
            class31.field717 = var7;
         }
      }

      int var9 = var8 - class10.field155;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class10.field155 += var9 * class44.field1008 / 1000 + class114.field2006;
         class10.field155 &= 2047;
      }

      if(var9 < 0) {
         class10.field155 -= -var9 * class44.field1008 / 1000 + class114.field2006;
         class10.field155 &= 2047;
      }

      int var10 = var8 - class10.field155;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class10.field155 = var8;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1774529554"
   )
   static final boolean method2930(int var0, int var1) {
      class42 var2 = class7.method100(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method833(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass89;Lclass111;B)V",
      garbageValue = "-26"
   )
   static final void method2931(int var0, int var1, int var2, int var3, int var4, int var5, class89 var6, class111 var7) {
      if(!client.field277 || (class5.field78[0][var1][var2] & 2) != 0 || (class5.field78[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field87) {
            class5.field87 = var0;
         }

         class42 var8 = class7.method100(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field976;
            var10 = var8.field980;
         } else {
            var9 = var8.field980;
            var10 = var8.field976;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var2 + var10 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = (1 + var10 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class5.field77[var0];
         int var16 = var15[var12][var14] + var15[var11][var13] + var15[var12][var13] + var15[var11][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = 1073741824 + (var2 << 7) + var1 + (var3 << 14);
         if(var8.field974 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field982 == 1) {
            var20 += 256;
         }

         if(var8.method840()) {
            class101.method2279(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!client.field277 || var8.field974 != 0 || var8.field959 == 1 || var8.field971) {
               if(var8.field942 == -1 && null == var8.field983) {
                  var21 = var8.method835(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 22, var4, var0, var1, var2, var8.field942, true, (class88)null);
               }

               var6.method2005(var0, var1, var2, var16, (class88)var21, var19, var20);
               if(var8.field959 == 1 && var7 != null) {
                  var7.method2471(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field942 == -1 && null == var8.field983) {
                     var21 = var8.method835(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field942, true, (class88)null);
                  }

                  var6.method2039(var0, var1, var2, var16, 1, 1, (class88)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class33.field762[var0][var1][var2] |= 2340;
                  }

                  if(var8.field959 != 0 && null != var7) {
                     var7.method2451(var1, var2, var9, var10, var8.field960);
                  }

               } else if(var5 == 0) {
                  if(var8.field942 == -1 && var8.field983 == null) {
                     var21 = var8.method835(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 0, var4, var0, var1, var2, var8.field942, true, (class88)null);
                  }

                  var6.method2130(var0, var1, var2, var16, (class88)var21, (class88)null, class5.field82[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field984) {
                        class78.field1455[var0][var1][var2] = 50;
                        class78.field1455[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.field964) {
                        class33.field762[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field984) {
                        class78.field1455[var0][var1][1 + var2] = 50;
                        class78.field1455[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field964) {
                        class33.field762[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field984) {
                        class78.field1455[var0][1 + var1][var2] = 50;
                        class78.field1455[var0][1 + var1][var2 + 1] = 50;
                     }

                     if(var8.field964) {
                        class33.field762[var0][1 + var1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field984) {
                        class78.field1455[var0][var1][var2] = 50;
                        class78.field1455[var0][1 + var1][var2] = 50;
                     }

                     if(var8.field964) {
                        class33.field762[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field959 != 0 && null != var7) {
                     var7.method2452(var1, var2, var5, var4, var8.field960);
                  }

                  if(var8.field966 != 16) {
                     var6.method2015(var0, var1, var2, var8.field966);
                  }

               } else if(var5 == 1) {
                  if(var8.field942 == -1 && null == var8.field983) {
                     var21 = var8.method835(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 1, var4, var0, var1, var2, var8.field942, true, (class88)null);
                  }

                  var6.method2130(var0, var1, var2, var16, (class88)var21, (class88)null, class5.field83[var4], 0, var19, var20);
                  if(var8.field984) {
                     if(var4 == 0) {
                        class78.field1455[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class78.field1455[var0][1 + var1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class78.field1455[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class78.field1455[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field959 != 0 && null != var7) {
                     var7.method2452(var1, var2, var5, var4, var8.field960);
                  }

               } else {
                  Object var26;
                  int var27;
                  if(var5 == 2) {
                     var27 = 1 + var4 & 3;
                     Object var28;
                     if(var8.field942 == -1 && var8.field983 == null) {
                        var28 = var8.method835(2, var4 + 4, var15, var17, var16, var18);
                        var26 = var8.method835(2, var27, var15, var17, var16, var18);
                     } else {
                        var28 = new class12(var3, 2, var4 + 4, var0, var1, var2, var8.field942, true, (class88)null);
                        var26 = new class12(var3, 2, var27, var0, var1, var2, var8.field942, true, (class88)null);
                     }

                     var6.method2130(var0, var1, var2, var16, (class88)var28, (class88)var26, class5.field82[var4], class5.field82[var27], var19, var20);
                     if(var8.field964) {
                        if(var4 == 0) {
                           class33.field762[var0][var1][var2] |= 585;
                           class33.field762[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           class33.field762[var0][var1][var2 + 1] |= 1170;
                           class33.field762[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           class33.field762[var0][1 + var1][var2] |= 585;
                           class33.field762[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class33.field762[var0][var1][var2] |= 1170;
                           class33.field762[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field959 != 0 && null != var7) {
                        var7.method2452(var1, var2, var5, var4, var8.field960);
                     }

                     if(var8.field966 != 16) {
                        var6.method2015(var0, var1, var2, var8.field966);
                     }

                  } else if(var5 == 3) {
                     if(var8.field942 == -1 && null == var8.field983) {
                        var21 = var8.method835(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 3, var4, var0, var1, var2, var8.field942, true, (class88)null);
                     }

                     var6.method2130(var0, var1, var2, var16, (class88)var21, (class88)null, class5.field83[var4], 0, var19, var20);
                     if(var8.field984) {
                        if(var4 == 0) {
                           class78.field1455[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class78.field1455[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class78.field1455[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class78.field1455[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field959 != 0 && null != var7) {
                        var7.method2452(var1, var2, var5, var4, var8.field960);
                     }

                  } else if(var5 == 9) {
                     if(var8.field942 == -1 && var8.field983 == null) {
                        var21 = var8.method835(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field942, true, (class88)null);
                     }

                     var6.method2039(var0, var1, var2, var16, 1, 1, (class88)var21, 0, var19, var20);
                     if(var8.field959 != 0 && var7 != null) {
                        var7.method2451(var1, var2, var9, var10, var8.field960);
                     }

                     if(var8.field966 != 16) {
                        var6.method2015(var0, var1, var2, var8.field966);
                     }

                  } else if(var5 == 4) {
                     if(var8.field942 == -1 && null == var8.field983) {
                        var21 = var8.method835(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, var4, var0, var1, var2, var8.field942, true, (class88)null);
                     }

                     var6.method2008(var0, var1, var2, var16, (class88)var21, (class88)null, class5.field82[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var27 = 16;
                     var22 = var6.method2025(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class7.method100(var22 >> 14 & 32767).field966;
                     }

                     if(var8.field942 == -1 && var8.field983 == null) {
                        var26 = var8.method835(4, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field942, true, (class88)null);
                     }

                     var6.method2008(var0, var1, var2, var16, (class88)var26, (class88)null, class5.field82[var4], 0, class5.field90[var4] * var27, class5.field84[var4] * var27, var19, var20);
                  } else if(var5 == 6) {
                     var27 = 8;
                     var22 = var6.method2025(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class7.method100(var22 >> 14 & 32767).field966 / 2;
                     }

                     if(var8.field942 == -1 && var8.field983 == null) {
                        var26 = var8.method835(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field942, true, (class88)null);
                     }

                     var6.method2008(var0, var1, var2, var16, (class88)var26, (class88)null, 256, var4, class5.field86[var4] * var27, class5.field79[var4] * var27, var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.field942 == -1 && null == var8.field983) {
                        var21 = var8.method835(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, 4 + var22, var0, var1, var2, var8.field942, true, (class88)null);
                     }

                     var6.method2008(var0, var1, var2, var16, (class88)var21, (class88)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var27 = 8;
                     var22 = var6.method2025(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class7.method100(var22 >> 14 & 32767).field966 / 2;
                     }

                     int var25 = 2 + var4 & 3;
                     Object var29;
                     if(var8.field942 == -1 && null == var8.field983) {
                        var26 = var8.method835(4, 4 + var4, var15, var17, var16, var18);
                        var29 = var8.method835(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field942, true, (class88)null);
                        var29 = new class12(var3, 4, 4 + var25, var0, var1, var2, var8.field942, true, (class88)null);
                     }

                     var6.method2008(var0, var1, var2, var16, (class88)var26, (class88)var29, 256, var4, var27 * class5.field86[var4], var27 * class5.field79[var4], var19, var20);
                  }
               }
            } else {
               if(var8.field942 == -1 && null == var8.field983) {
                  var21 = var8.method835(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 10, var4, var0, var1, var2, var8.field942, true, (class88)null);
               }

               if(var21 != null && var6.method2039(var0, var1, var2, var16, var9, var10, (class88)var21, var5 == 11?256:0, var19, var20) && var8.field984) {
                  var22 = 15;
                  if(var21 instanceof class108) {
                     var22 = ((class108)var21).method2373() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class78.field1455[var0][var1 + var23][var24 + var2]) {
                           class78.field1455[var0][var23 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field959 != 0 && var7 != null) {
                  var7.method2451(var1, var2, var9, var10, var8.field960);
               }

            }
         }
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1235510828"
   )
   static final void method2932() {
      for(class6 var0 = (class6)client.field405.method3882(); var0 != null; var0 = (class6)client.field405.method3891()) {
         if(class51.field1119 == var0.field93 && client.field282 <= var0.field99) {
            if(client.field282 >= var0.field98) {
               if(var0.field102 > 0) {
                  class36 var1 = client.field308[var0.field102 - 1];
                  if(null != var1 && var1.field864 >= 0 && var1.field864 < 13312 && var1.field831 >= 0 && var1.field831 < 13312) {
                     var0.method80(var1.field864, var1.field831, class15.method163(var1.field864, var1.field831, var0.field93) - var0.field97, client.field282);
                  }
               }

               if(var0.field102 < 0) {
                  int var2 = -var0.field102 - 1;
                  class2 var3;
                  if(var2 == client.field551) {
                     var3 = class114.field2010;
                  } else {
                     var3 = client.field393[var2];
                  }

                  if(null != var3 && var3.field864 >= 0 && var3.field864 < 13312 && var3.field831 >= 0 && var3.field831 < 13312) {
                     var0.method80(var3.field864, var3.field831, class15.method163(var3.field864, var3.field831, var0.field93) - var0.field97, client.field282);
                  }
               }

               var0.method81(client.field329);
               class5.field91.method2010(class51.field1119, (int)var0.field104, (int)var0.field105, (int)var0.field117, 60, var0, var0.field94, -1, false);
            }
         } else {
            var0.method3990();
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)V",
      garbageValue = "-1967269901"
   )
   public static void method2933(class170 var0, class170 var1) {
      class45.field1040 = var0;
      class45.field1026 = var1;
   }
}
