import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class21 implements class115 {
   @ObfuscatedName("bc")
   static class171 field598;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -177890585
   )
   final int field599;
   @ObfuscatedName("e")
   static final class21 field600 = new class21(2);
   @ObfuscatedName("h")
   static final class21 field601 = new class21(1);
   @ObfuscatedName("i")
   static final class21 field606 = new class21(0);
   @ObfuscatedName("g")
   static final class21 field607 = new class21(3);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-970198235"
   )
   public int vmethod3197() {
      return this.field599;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class21(int var1) {
      this.field599 = var1;
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "1687821666"
   )
   static void method541(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2809 == 0) {
         var0.width = var0.field2813;
      } else if(var0.field2809 == 1) {
         var0.width = var1 - var0.field2813;
      } else if(var0.field2809 == 2) {
         var0.width = var0.field2813 * var1 >> 14;
      }

      if(var0.field2810 == 0) {
         var0.height = var0.field2814;
      } else if(var0.field2810 == 1) {
         var0.height = var2 - var0.field2814;
      } else if(var0.field2810 == 2) {
         var0.height = var0.field2814 * var2 >> 14;
      }

      if(var0.field2809 == 4) {
         var0.width = var0.field2897 * var0.height / var0.field2820;
      }

      if(var0.field2810 == 4) {
         var0.height = var0.field2820 * var0.width / var0.field2897;
      }

      if(Client.field470 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field535 = var0;
      }

      if(var3 && null != var0.field2911 && (var0.width != var4 || var0.height != var5)) {
         class0 var6 = new class0();
         var6.field13 = var0;
         var6.field8 = var0.field2911;
         Client.field522.method3865(var6);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-922634258"
   )
   static final void method544(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field304 || (class5.tileSettings[0][var1][var2] & 2) != 0 || (class5.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field86) {
            class5.field86 = var0;
         }

         ObjectComposition var8 = class9.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field959;
            var10 = var8.field960;
         } else {
            var9 = var8.field960;
            var10 = var8.field959;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = var1 + (1 + var9 >> 1);
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
            var14 = 1 + var2;
         }

         int[][] var15 = class5.tileHeights[var0];
         int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + (var2 << 7) + var1 + (var3 << 14);
         if(var8.field963 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field984 == 1) {
            var20 += 256;
         }

         if(var8.method849()) {
            Item.method653(var0, var1, var2, var8, var4);
         }

         Object var26;
         if(var5 == 22) {
            if(!Client.field304 || var8.field963 != 0 || var8.field961 == 1 || var8.field982) {
               if(var8.field955 == -1 && var8.impostorIds == null) {
                  var26 = var8.method844(22, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 22, var4, var0, var1, var2, var8.field955, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var26, var19, var20);
               if(var8.field961 == 1 && null != var7) {
                  var7.method2423(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field955 == -1 && var8.impostorIds == null) {
                     var26 = var8.method844(var5, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field955, true, (Renderable)null);
                  }

                  var6.method1962(var0, var1, var2, var16, 1, 1, (Renderable)var26, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class5.field107[var0][var1][var2] |= 2340;
                  }

                  if(var8.field961 != 0 && null != var7) {
                     var7.method2420(var1, var2, var9, var10, var8.field962);
                  }

               } else if(var5 == 0) {
                  if(var8.field955 == -1 && null == var8.impostorIds) {
                     var26 = var8.method844(0, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 0, var4, var0, var1, var2, var8.field955, true, (Renderable)null);
                  }

                  var6.method1960(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, class5.field105[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field975) {
                        class35.field801[var0][var1][var2] = 50;
                        class35.field801[var0][var1][1 + var2] = 50;
                     }

                     if(var8.field966) {
                        class5.field107[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field975) {
                        class35.field801[var0][var1][1 + var2] = 50;
                        class35.field801[var0][var1 + 1][1 + var2] = 50;
                     }

                     if(var8.field966) {
                        class5.field107[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field975) {
                        class35.field801[var0][1 + var1][var2] = 50;
                        class35.field801[var0][var1 + 1][1 + var2] = 50;
                     }

                     if(var8.field966) {
                        class5.field107[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field975) {
                        class35.field801[var0][var1][var2] = 50;
                        class35.field801[var0][1 + var1][var2] = 50;
                     }

                     if(var8.field966) {
                        class5.field107[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field961 != 0 && null != var7) {
                     var7.method2439(var1, var2, var5, var4, var8.field962);
                  }

                  if(var8.field944 != 16) {
                     var6.method2113(var0, var1, var2, var8.field944);
                  }

               } else if(var5 == 1) {
                  if(var8.field955 == -1 && null == var8.impostorIds) {
                     var26 = var8.method844(1, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 1, var4, var0, var1, var2, var8.field955, true, (Renderable)null);
                  }

                  var6.method1960(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, class5.field97[var4], 0, var19, var20);
                  if(var8.field975) {
                     if(var4 == 0) {
                        class35.field801[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class35.field801[var0][1 + var1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class35.field801[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class35.field801[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field961 != 0 && var7 != null) {
                     var7.method2439(var1, var2, var5, var4, var8.field962);
                  }

               } else {
                  int var21;
                  Object var23;
                  if(var5 == 2) {
                     var21 = 1 + var4 & 3;
                     Object var27;
                     if(var8.field955 == -1 && null == var8.impostorIds) {
                        var27 = var8.method844(2, var4 + 4, var15, var17, var16, var18);
                        var23 = var8.method844(2, var21, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field955, true, (Renderable)null);
                        var23 = new class12(var3, 2, var21, var0, var1, var2, var8.field955, true, (Renderable)null);
                     }

                     var6.method1960(var0, var1, var2, var16, (Renderable)var27, (Renderable)var23, class5.field105[var4], class5.field105[var21], var19, var20);
                     if(var8.field966) {
                        if(var4 == 0) {
                           class5.field107[var0][var1][var2] |= 585;
                           class5.field107[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class5.field107[var0][var1][1 + var2] |= 1170;
                           class5.field107[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class5.field107[var0][var1 + 1][var2] |= 585;
                           class5.field107[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class5.field107[var0][var1][var2] |= 1170;
                           class5.field107[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field961 != 0 && null != var7) {
                        var7.method2439(var1, var2, var5, var4, var8.field962);
                     }

                     if(var8.field944 != 16) {
                        var6.method2113(var0, var1, var2, var8.field944);
                     }

                  } else if(var5 == 3) {
                     if(var8.field955 == -1 && null == var8.impostorIds) {
                        var26 = var8.method844(3, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 3, var4, var0, var1, var2, var8.field955, true, (Renderable)null);
                     }

                     var6.method1960(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, class5.field97[var4], 0, var19, var20);
                     if(var8.field975) {
                        if(var4 == 0) {
                           class35.field801[var0][var1][1 + var2] = 50;
                        } else if(var4 == 1) {
                           class35.field801[var0][1 + var1][1 + var2] = 50;
                        } else if(var4 == 2) {
                           class35.field801[var0][1 + var1][var2] = 50;
                        } else if(var4 == 3) {
                           class35.field801[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field961 != 0 && var7 != null) {
                        var7.method2439(var1, var2, var5, var4, var8.field962);
                     }

                  } else if(var5 == 9) {
                     if(var8.field955 == -1 && var8.impostorIds == null) {
                        var26 = var8.method844(var5, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field955, true, (Renderable)null);
                     }

                     var6.method1962(var0, var1, var2, var16, 1, 1, (Renderable)var26, 0, var19, var20);
                     if(var8.field961 != 0 && var7 != null) {
                        var7.method2420(var1, var2, var9, var10, var8.field962);
                     }

                     if(var8.field944 != 16) {
                        var6.method2113(var0, var1, var2, var8.field944);
                     }

                  } else if(var5 == 4) {
                     if(var8.field955 == -1 && var8.impostorIds == null) {
                        var26 = var8.method844(4, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field955, true, (Renderable)null);
                     }

                     var6.method1961(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, class5.field105[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var21 = 16;
                     var22 = var6.method1978(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class9.getObjectDefinition(var22 >> 14 & 32767).field944;
                     }

                     if(var8.field955 == -1 && var8.impostorIds == null) {
                        var23 = var8.method844(4, var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, var4, var0, var1, var2, var8.field955, true, (Renderable)null);
                     }

                     var6.method1961(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, class5.field105[var4], 0, class5.field98[var4] * var21, var21 * class5.field99[var4], var19, var20);
                  } else if(var5 == 6) {
                     var21 = 8;
                     var22 = var6.method1978(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class9.getObjectDefinition(var22 >> 14 & 32767).field944 / 2;
                     }

                     if(var8.field955 == -1 && null == var8.impostorIds) {
                        var23 = var8.method844(4, 4 + var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field955, true, (Renderable)null);
                     }

                     var6.method1961(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, 256, var4, class5.field100[var4] * var21, var21 * class5.field101[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = 2 + var4 & 3;
                     if(var8.field955 == -1 && null == var8.impostorIds) {
                        var26 = var8.method844(4, 4 + var22, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, var22 + 4, var0, var1, var2, var8.field955, true, (Renderable)null);
                     }

                     var6.method1961(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var21 = 8;
                     var22 = var6.method1978(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class9.getObjectDefinition(var22 >> 14 & 32767).field944 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.field955 == -1 && null == var8.impostorIds) {
                        var23 = var8.method844(4, 4 + var4, var15, var17, var16, var18);
                        var29 = var8.method844(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field955, true, (Renderable)null);
                        var29 = new class12(var3, 4, var25 + 4, var0, var1, var2, var8.field955, true, (Renderable)null);
                     }

                     var6.method1961(var0, var1, var2, var16, (Renderable)var23, (Renderable)var29, 256, var4, var21 * class5.field100[var4], class5.field101[var4] * var21, var19, var20);
                  }
               }
            } else {
               if(var8.field955 == -1 && null == var8.impostorIds) {
                  var26 = var8.method844(10, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 10, var4, var0, var1, var2, var8.field955, true, (Renderable)null);
               }

               if(var26 != null && var6.method1962(var0, var1, var2, var16, var9, var10, (Renderable)var26, var5 == 11?256:0, var19, var20) && var8.field975) {
                  var22 = 15;
                  if(var26 instanceof Model) {
                     var22 = ((Model)var26).method2337() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var28 = 0; var28 <= var9; ++var28) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class35.field801[var0][var1 + var28][var24 + var2]) {
                           class35.field801[var0][var1 + var28][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field961 != 0 && var7 != null) {
                  var7.method2420(var1, var2, var9, var10, var8.field962);
               }

            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass69;B)V",
      garbageValue = "0"
   )
   static final void method545(class69 var0) {
      var0.field1320 = false;
      if(var0.field1317 != null) {
         var0.field1317.field1316 = 0;
      }

      for(class69 var1 = var0.vmethod3756(); var1 != null; var1 = var0.vmethod3744()) {
         method545(var1);
      }

   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "1358801441"
   )
   static final void method546(String var0, int var1) {
      Client.field378.method2801(36);
      Client.field378.method2529(method547(var0) + 1);
      Client.field378.method2529(var1);
      Client.field378.method2535(var0);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-121"
   )
   public static int method547(String var0) {
      return var0.length() + 1;
   }
}
