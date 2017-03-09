import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class32 {
   @ObfuscatedName("c")
   static int[] field748;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -299539561
   )
   static int field749;
   @ObfuscatedName("h")
   static int[][] field750 = new int[5][5000];
   @ObfuscatedName("w")
   static int[] field751 = new int[5];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1756221891
   )
   static int field752;
   @ObfuscatedName("g")
   @Export("scriptStringStack")
   static String[] scriptStringStack = new String[1000];
   @ObfuscatedName("v")
   static Widget field754;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -318029525
   )
   @Export("scriptStackCount")
   static int scriptStackCount = 0;
   @ObfuscatedName("u")
   static int[] field756 = new int[1000];
   @ObfuscatedName("s")
   static Calendar field757 = Calendar.getInstance();
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -298908517
   )
   static int field759 = 0;
   @ObfuscatedName("r")
   static final String[] field761 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("q")
   @Export("scriptStack")
   static ScriptState[] scriptStack = new ScriptState[50];

   class32() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "1474627882"
   )
   static final void method751(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field439 || (class10.tileSettings[0][var1][var2] & 2) != 0 || (class10.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class10.field107) {
            class10.field107 = var0;
         }

         ObjectComposition var8 = class195.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.sizeX;
            var10 = var8.sizeY;
         } else {
            var9 = var8.sizeY;
            var10 = var8.sizeX;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = var1 + (1 + var9 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var2 + var10 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (1 + var10 >> 1);
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class10.tileHeights[var0];
         int var16 = var15[var12][var13] + var15[var11][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = var1 + (var2 << 7) + (var3 << 14) + 1073741824;
         if(var8.field2913 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field2919 == 1) {
            var20 += 256;
         }

         if(var8.method3623()) {
            class13.method194(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field439 || var8.field2913 != 0 || var8.field2911 == 1 || var8.field2932) {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var21 = var8.method3618(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field2911 == 1 && var7 != null) {
                  var7.method2320(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method3618(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1834(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     XClanMember.field300[var0][var1][var2] |= 2340;
                  }

                  if(var8.field2911 != 0 && var7 != null) {
                     var7.method2292(var1, var2, var9, var10, var8.field2920);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method3618(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1762(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field127[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field2925) {
                        class10.field111[var0][var1][var2] = 50;
                        class10.field111[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.field2916) {
                        XClanMember.field300[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field2925) {
                        class10.field111[var0][var1][var2 + 1] = 50;
                        class10.field111[var0][var1 + 1][1 + var2] = 50;
                     }

                     if(var8.field2916) {
                        XClanMember.field300[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field2925) {
                        class10.field111[var0][1 + var1][var2] = 50;
                        class10.field111[var0][var1 + 1][1 + var2] = 50;
                     }

                     if(var8.field2916) {
                        XClanMember.field300[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field2925) {
                        class10.field111[var0][var1][var2] = 50;
                        class10.field111[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field2916) {
                        XClanMember.field300[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field2911 != 0 && null != var7) {
                     var7.method2291(var1, var2, var5, var4, var8.field2920);
                  }

                  if(var8.field2918 != 16) {
                     var6.method1874(var0, var1, var2, var8.field2918);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var21 = var8.method3618(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1762(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field117[var4], 0, var19, var20);
                  if(var8.field2925) {
                     if(var4 == 0) {
                        class10.field111[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class10.field111[var0][1 + var1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class10.field111[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class10.field111[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2911 != 0 && null != var7) {
                     var7.method2291(var1, var2, var5, var4, var8.field2920);
                  }

               } else {
                  Object var23;
                  int var27;
                  if(var5 == 2) {
                     var27 = 1 + var4 & 3;
                     Object var28;
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var28 = var8.method3618(2, var4 + 4, var15, var17, var16, var18);
                        var23 = var8.method3618(2, var27, var15, var17, var16, var18);
                     } else {
                        var28 = new class49(var3, 2, 4 + var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var23 = new class49(var3, 2, var27, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1762(var0, var1, var2, var16, (Renderable)var28, (Renderable)var23, class10.field127[var4], class10.field127[var27], var19, var20);
                     if(var8.field2916) {
                        if(var4 == 0) {
                           XClanMember.field300[var0][var1][var2] |= 585;
                           XClanMember.field300[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           XClanMember.field300[var0][var1][1 + var2] |= 1170;
                           XClanMember.field300[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           XClanMember.field300[var0][var1 + 1][var2] |= 585;
                           XClanMember.field300[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           XClanMember.field300[var0][var1][var2] |= 1170;
                           XClanMember.field300[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field2911 != 0 && var7 != null) {
                        var7.method2291(var1, var2, var5, var4, var8.field2920);
                     }

                     if(var8.field2918 != 16) {
                        var6.method1874(var0, var1, var2, var8.field2918);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3618(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1762(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field117[var4], 0, var19, var20);
                     if(var8.field2925) {
                        if(var4 == 0) {
                           class10.field111[var0][var1][1 + var2] = 50;
                        } else if(var4 == 1) {
                           class10.field111[var0][1 + var1][1 + var2] = 50;
                        } else if(var4 == 2) {
                           class10.field111[var0][1 + var1][var2] = 50;
                        } else if(var4 == 3) {
                           class10.field111[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field2911 != 0 && var7 != null) {
                        var7.method2291(var1, var2, var5, var4, var8.field2920);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3618(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1834(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field2911 != 0 && null != var7) {
                        var7.method2292(var1, var2, var9, var10, var8.field2920);
                     }

                     if(var8.field2918 != 16) {
                        var6.method1874(var0, var1, var2, var8.field2918);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var21 = var8.method3618(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1849(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field127[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var27 = 16;
                     var22 = var6.method1920(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class195.getObjectDefinition(var22 >> 14 & 32767).field2918;
                     }

                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var23 = var8.method3618(4, var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1849(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, class10.field127[var4], 0, class10.field118[var4] * var27, class10.field123[var4] * var27, var19, var20);
                  } else if(var5 == 6) {
                     var27 = 8;
                     var22 = var6.method1920(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class195.getObjectDefinition(var22 >> 14 & 32767).field2918 / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var23 = var8.method3618(4, 4 + var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1849(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, 256, var4, class10.field120[var4] * var27, var27 * class10.field109[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3618(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1849(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var27 = 8;
                     var22 = var6.method1920(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class195.getObjectDefinition(var22 >> 14 & 32767).field2918 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var23 = var8.method3618(4, var4 + 4, var15, var17, var16, var18);
                        var29 = var8.method3618(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var23 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var29 = new class49(var3, 4, 4 + var25, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1849(var0, var1, var2, var16, (Renderable)var23, (Renderable)var29, 256, var4, class10.field120[var4] * var27, var27 * class10.field109[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var21 = var8.method3618(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(null != var21 && var6.method1834(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field2925) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method1619() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var26 = 0; var26 <= var9; ++var26) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class10.field111[var0][var26 + var1][var2 + var24]) {
                           class10.field111[var0][var1 + var26][var2 + var24] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field2911 != 0 && var7 != null) {
                  var7.method2292(var1, var2, var9, var10, var8.field2920);
               }

            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "273509759"
   )
   static final int method752(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + var2 * (var1 & '\uff00') & 16711680) + (var3 * (var0 & 16711935) + var2 * (var1 & 16711935) & -16711936) >> 8;
   }
}
