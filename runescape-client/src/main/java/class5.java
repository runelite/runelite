import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
final class class5 implements class0 {
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = 3035185
   )
   static int field26;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 434855545
   )
   static int field28;
   @ObfuscatedName("n")
   static int[] field29;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1581477805
   )
   static int field30;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -938461925
   )
   static int field27;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILfj;Lfb;I)Z",
      garbageValue = "789467136"
   )
   static final boolean method15(int var0, int var1, int var2, class168 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class167.field2224[var7][var8] = 99;
      class167.field2222[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class167.field2219[var11] = var0;
      int var20 = var11 + 1;
      class167.field2225[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label306:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label283:
                     do {
                        if(var12 == var20) {
                           VarPlayerType.field3371 = var5;
                           class175.field2446 = var6;
                           return false;
                        }

                        var5 = class167.field2219[var12];
                        var6 = class167.field2225[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod3396(var2, var5, var6, var4)) {
                           VarPlayerType.field3371 = var5;
                           class175.field2446 = var6;
                           return true;
                        }

                        var16 = class167.field2222[var18][var19] + 1;
                        if(var18 > 0 && class167.field2224[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class167.field2219[var20] = var5 - 1;
                                 class167.field2225[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class167.field2224[var18 - 1][var19] = 2;
                                 class167.field2222[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class167.field2224[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class167.field2219[var20] = var5 + 1;
                                 class167.field2225[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class167.field2224[var18 + 1][var19] = 8;
                                 class167.field2222[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class167.field2224[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class167.field2219[var20] = var5;
                                 class167.field2225[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class167.field2224[var18][var19 - 1] = 1;
                                 class167.field2222[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class167.field2224[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class167.field2219[var20] = var5;
                                 class167.field2225[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class167.field2224[var18][var19 + 1] = 4;
                                 class167.field2222[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class167.field2224[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class167.field2219[var20] = var5 - 1;
                                 class167.field2225[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class167.field2224[var18 - 1][var19 - 1] = 3;
                                 class167.field2222[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class167.field2224[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class167.field2219[var20] = var5 + 1;
                                 class167.field2225[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class167.field2224[var18 + 1][var19 - 1] = 9;
                                 class167.field2222[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class167.field2224[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label283;
                              }
                           }

                           class167.field2219[var20] = var5 - 1;
                           class167.field2225[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class167.field2224[var18 - 1][var19 + 1] = 6;
                           class167.field2222[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class167.field2224[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label306;
               }
            }

            class167.field2219[var20] = var5 + 1;
            class167.field2225[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class167.field2224[var18 + 1][var19 + 1] = 12;
            class167.field2222[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1365506205"
   )
   public static int method13() {
      return KeyFocusListener.keyboardIdleTicks;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "([Lhs;Lhs;ZI)V",
      garbageValue = "-121295894"
   )
   static void method14(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class65.method1057(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class65.method1057(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         WallObject.method3112(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
