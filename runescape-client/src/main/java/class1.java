import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class1 {
   @ObfuscatedName("cp")
   static class227 field25;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -1317968367
   )
   static int field31;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "949111946"
   )
   public static void method4(Component var0) {
      var0.addMouseListener(class143.field2212);
      var0.addMouseMotionListener(class143.field2212);
      var0.addFocusListener(class143.field2212);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-67"
   )
   static final void method6() {
      class89.field1560 = false;
      client.field277 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass41;",
      garbageValue = "2065374889"
   )
   @Export("getNpcDefinition")
   public static class41 method7(int var0) {
      class41 var1 = (class41)class41.field925.method3817((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class41.field928.method3304(9, var0);
         var1 = new class41();
         var1.field908 = var0;
         if(var2 != null) {
            var1.method793(new class122(var2));
         }

         var1.method792();
         class41.field925.method3823(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "40"
   )
   static final void method8(String var0) {
      if(null != var0) {
         String var1 = class23.method579(var0, class134.field2117);
         if(null != var1) {
            for(int var2 = 0; var2 < client.field537; ++var2) {
               class17 var3 = client.field273[var2];
               String var4 = var3.field229;
               String var5 = class23.method579(var4, class134.field2117);
               if(class128.method2857(var0, var1, var4, var5)) {
                  --client.field537;

                  for(int var6 = var2; var6 < client.field537; ++var6) {
                     client.field273[var6] = client.field273[1 + var6];
                  }

                  client.field548 = client.field455;
                  client.field313.method2797(234);
                  client.field313.method2557(class77.method1679(var0));
                  client.field313.method2563(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(Lclass176;II)I",
      garbageValue = "-167424793"
   )
   static final int method9(class176 var0, int var1) {
      if(null != var0.field2907 && var1 < var0.field2907.length) {
         try {
            int[] var2 = var0.field2907[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = client.field407[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.field408[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = client.field469[var2[var4++]];
               }

               int var9;
               class176 var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class34.method720(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class4.method42(var11).field1196 || client.field276)) {
                     for(var12 = 0; var12 < var10.field2869.length; ++var12) {
                        if(var10.field2869[var12] == var11 + 1) {
                           var7 += var10.field2830[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class179.field2949[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class158.field2351[client.field408[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class179.field2949[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class114.field2010.field41;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class158.field2349[var9]) {
                        var7 += client.field408[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class34.method720(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class4.method42(var11).field1196 || client.field276)) {
                     for(var12 = 0; var12 < var10.field2869.length; ++var12) {
                        if(1 + var11 == var10.field2869[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = client.field435;
               }

               if(var6 == 12) {
                  var7 = client.field436;
               }

               if(var6 == 13) {
                  var9 = class179.field2949[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class12.method154(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class114.field2010.field864 >> 7) + class39.field838;
               }

               if(var6 == 19) {
                  var7 = class13.field184 + (class114.field2010.field831 >> 7);
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2137144897"
   )
   static final void method10() {
      client.field392 = 0;
      int var0 = class39.field838 + (class114.field2010.field864 >> 7);
      int var1 = (class114.field2010.field831 >> 7) + class13.field184;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         client.field392 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         client.field392 = 1;
      }

      if(client.field392 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         client.field392 = 0;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIILclass89;Lclass111;I)V",
      garbageValue = "1099707542"
   )
   static final void method11(int var0, int var1, int var2, int var3, int var4, int var5, int var6, class89 var7, class111 var8) {
      class42 var9 = class7.method100(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.field976;
         var11 = var9.field980;
      } else {
         var10 = var9.field980;
         var11 = var9.field976;
      }

      int var12;
      int var13;
      if(var10 + var2 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = (var10 + 1 >> 1) + var2;
      } else {
         var12 = var2;
         var13 = 1 + var2;
      }

      int var14;
      int var15;
      if(var11 + var3 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = var3 + (var11 + 1 >> 1);
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class5.field77[var1];
      int var17 = var16[var12][var14] + var16[var13][var14] + var16[var12][var15] + var16[var13][var15] >> 2;
      int var18 = (var10 << 6) + (var2 << 7);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
      if(var9.field974 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.field982 == 1) {
         var21 += 256;
      }

      Object var27;
      if(var6 == 22) {
         if(var9.field942 == -1 && null == var9.field983) {
            var27 = var9.method864(22, var5, var16, var18, var17, var19);
         } else {
            var27 = new class12(var4, 22, var5, var1, var2, var3, var9.field942, true, (class88)null);
         }

         var7.method2005(var0, var2, var3, var17, (class88)var27, var20, var21);
         if(var9.field959 == 1) {
            var8.method2471(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.field942 == -1 && null == var9.field983) {
               var27 = var9.method864(var6, var5, var16, var18, var17, var19);
            } else {
               var27 = new class12(var4, var6, var5, var1, var2, var3, var9.field942, true, (class88)null);
            }

            var7.method2039(var0, var2, var3, var17, 1, 1, (class88)var27, 0, var20, var21);
            if(var9.field959 != 0) {
               var8.method2451(var2, var3, var10, var11, var9.field960);
            }

         } else if(var6 == 0) {
            if(var9.field942 == -1 && null == var9.field983) {
               var27 = var9.method864(0, var5, var16, var18, var17, var19);
            } else {
               var27 = new class12(var4, 0, var5, var1, var2, var3, var9.field942, true, (class88)null);
            }

            var7.method2130(var0, var2, var3, var17, (class88)var27, (class88)null, class5.field82[var5], 0, var20, var21);
            if(var9.field959 != 0) {
               var8.method2452(var2, var3, var6, var5, var9.field960);
            }

         } else if(var6 == 1) {
            if(var9.field942 == -1 && var9.field983 == null) {
               var27 = var9.method864(1, var5, var16, var18, var17, var19);
            } else {
               var27 = new class12(var4, 1, var5, var1, var2, var3, var9.field942, true, (class88)null);
            }

            var7.method2130(var0, var2, var3, var17, (class88)var27, (class88)null, class5.field83[var5], 0, var20, var21);
            if(var9.field959 != 0) {
               var8.method2452(var2, var3, var6, var5, var9.field960);
            }

         } else {
            int var22;
            Object var24;
            if(var6 == 2) {
               var22 = var5 + 1 & 3;
               Object var28;
               if(var9.field942 == -1 && null == var9.field983) {
                  var28 = var9.method864(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method864(2, var22, var16, var18, var17, var19);
               } else {
                  var28 = new class12(var4, 2, var5 + 4, var1, var2, var3, var9.field942, true, (class88)null);
                  var24 = new class12(var4, 2, var22, var1, var2, var3, var9.field942, true, (class88)null);
               }

               var7.method2130(var0, var2, var3, var17, (class88)var28, (class88)var24, class5.field82[var5], class5.field82[var22], var20, var21);
               if(var9.field959 != 0) {
                  var8.method2452(var2, var3, var6, var5, var9.field960);
               }

            } else if(var6 == 3) {
               if(var9.field942 == -1 && var9.field983 == null) {
                  var27 = var9.method864(3, var5, var16, var18, var17, var19);
               } else {
                  var27 = new class12(var4, 3, var5, var1, var2, var3, var9.field942, true, (class88)null);
               }

               var7.method2130(var0, var2, var3, var17, (class88)var27, (class88)null, class5.field83[var5], 0, var20, var21);
               if(var9.field959 != 0) {
                  var8.method2452(var2, var3, var6, var5, var9.field960);
               }

            } else if(var6 == 9) {
               if(var9.field942 == -1 && var9.field983 == null) {
                  var27 = var9.method864(var6, var5, var16, var18, var17, var19);
               } else {
                  var27 = new class12(var4, var6, var5, var1, var2, var3, var9.field942, true, (class88)null);
               }

               var7.method2039(var0, var2, var3, var17, 1, 1, (class88)var27, 0, var20, var21);
               if(var9.field959 != 0) {
                  var8.method2451(var2, var3, var10, var11, var9.field960);
               }

            } else if(var6 == 4) {
               if(var9.field942 == -1 && null == var9.field983) {
                  var27 = var9.method864(4, var5, var16, var18, var17, var19);
               } else {
                  var27 = new class12(var4, 4, var5, var1, var2, var3, var9.field942, true, (class88)null);
               }

               var7.method2008(var0, var2, var3, var17, (class88)var27, (class88)null, class5.field82[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var22 = 16;
                  var23 = var7.method2025(var0, var2, var3);
                  if(var23 != 0) {
                     var22 = class7.method100(var23 >> 14 & 32767).field966;
                  }

                  if(var9.field942 == -1 && var9.field983 == null) {
                     var24 = var9.method864(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5, var1, var2, var3, var9.field942, true, (class88)null);
                  }

                  var7.method2008(var0, var2, var3, var17, (class88)var24, (class88)null, class5.field82[var5], 0, class5.field90[var5] * var22, var22 * class5.field84[var5], var20, var21);
               } else if(var6 == 6) {
                  var22 = 8;
                  var23 = var7.method2025(var0, var2, var3);
                  if(var23 != 0) {
                     var22 = class7.method100(var23 >> 14 & 32767).field966 / 2;
                  }

                  if(var9.field942 == -1 && null == var9.field983) {
                     var24 = var9.method864(4, 4 + var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, 4 + var5, var1, var2, var3, var9.field942, true, (class88)null);
                  }

                  var7.method2008(var0, var2, var3, var17, (class88)var24, (class88)null, 256, var5, var22 * class5.field86[var5], class5.field79[var5] * var22, var20, var21);
               } else if(var6 == 7) {
                  var23 = var5 + 2 & 3;
                  if(var9.field942 == -1 && var9.field983 == null) {
                     var27 = var9.method864(4, var23 + 4, var16, var18, var17, var19);
                  } else {
                     var27 = new class12(var4, 4, 4 + var23, var1, var2, var3, var9.field942, true, (class88)null);
                  }

                  var7.method2008(var0, var2, var3, var17, (class88)var27, (class88)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var22 = 8;
                  var23 = var7.method2025(var0, var2, var3);
                  if(var23 != 0) {
                     var22 = class7.method100(var23 >> 14 & 32767).field966 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.field942 == -1 && var9.field983 == null) {
                     var24 = var9.method864(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method864(4, 4 + var26, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, 4 + var5, var1, var2, var3, var9.field942, true, (class88)null);
                     var25 = new class12(var4, 4, var26 + 4, var1, var2, var3, var9.field942, true, (class88)null);
                  }

                  var7.method2008(var0, var2, var3, var17, (class88)var24, (class88)var25, 256, var5, var22 * class5.field86[var5], var22 * class5.field79[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.field942 == -1 && null == var9.field983) {
            var27 = var9.method864(10, var5, var16, var18, var17, var19);
         } else {
            var27 = new class12(var4, 10, var5, var1, var2, var3, var9.field942, true, (class88)null);
         }

         if(var27 != null) {
            var7.method2039(var0, var2, var3, var17, var10, var11, (class88)var27, var6 == 11?256:0, var20, var21);
         }

         if(var9.field959 != 0) {
            var8.method2451(var2, var3, var10, var11, var9.field960);
         }

      }
   }
}
