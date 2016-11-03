import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class35 {
   @ObfuscatedName("q")
   static final class35 field784 = new class35();
   @ObfuscatedName("c")
   static final class35 field785 = new class35();
   @ObfuscatedName("f")
   static final class35 field786 = new class35();
   @ObfuscatedName("k")
   static final class35 field788 = new class35();
   @ObfuscatedName("ah")
   static class171 field789;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;B)V",
      garbageValue = "42"
   )
   static final void method738(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field282 || (class5.tileSettings[0][var1][var2] & 2) != 0 || (class5.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field77) {
            class5.field77 = var0;
         }

         ObjectComposition var8 = Projectile.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field950;
            var10 = var8.field948;
         } else {
            var9 = var8.field948;
            var10 = var8.field950;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = (1 + var9 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class5.tileHeights[var0];
         int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + (var3 << 14) + var1 + (var2 << 7);
         if(var8.field982 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field940 == 1) {
            var20 += 256;
         }

         if(var8.method845()) {
            class9.method113(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field282 || var8.field982 != 0 || var8.field952 == 1 || var8.field973) {
               if(var8.field964 == -1 && null == var8.impostorIds) {
                  var21 = var8.method875(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 22, var4, var0, var1, var2, var8.field964, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field952 == 1 && null != var7) {
                  var7.method2453(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field964 == -1 && var8.impostorIds == null) {
                     var21 = var8.method875(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field964, true, (Renderable)null);
                  }

                  var6.method1971(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class5.field82[var0][var1][var2] |= 2340;
                  }

                  if(var8.field952 != 0 && var7 != null) {
                     var7.method2450(var1, var2, var9, var10, var8.field953);
                  }

               } else if(var5 == 0) {
                  if(var8.field964 == -1 && null == var8.impostorIds) {
                     var21 = var8.method875(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 0, var4, var0, var1, var2, var8.field964, true, (Renderable)null);
                  }

                  var6.method1962(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field83[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field971) {
                        class53.field1155[var0][var1][var2] = 50;
                        class53.field1155[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.field951) {
                        class5.field82[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field971) {
                        class53.field1155[var0][var1][var2 + 1] = 50;
                        class53.field1155[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field951) {
                        class5.field82[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field971) {
                        class53.field1155[var0][1 + var1][var2] = 50;
                        class53.field1155[var0][var1 + 1][1 + var2] = 50;
                     }

                     if(var8.field951) {
                        class5.field82[var0][1 + var1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field971) {
                        class53.field1155[var0][var1][var2] = 50;
                        class53.field1155[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field951) {
                        class5.field82[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field952 != 0 && null != var7) {
                     var7.method2449(var1, var2, var5, var4, var8.field953);
                  }

                  if(var8.field959 != 16) {
                     var6.method1977(var0, var1, var2, var8.field959);
                  }

               } else if(var5 == 1) {
                  if(var8.field964 == -1 && var8.impostorIds == null) {
                     var21 = var8.method875(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 1, var4, var0, var1, var2, var8.field964, true, (Renderable)null);
                  }

                  var6.method1962(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field84[var4], 0, var19, var20);
                  if(var8.field971) {
                     if(var4 == 0) {
                        class53.field1155[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class53.field1155[var0][var1 + 1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class53.field1155[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class53.field1155[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field952 != 0 && var7 != null) {
                     var7.method2449(var1, var2, var5, var4, var8.field953);
                  }

               } else {
                  Object var23;
                  int var26;
                  if(var5 == 2) {
                     var26 = var4 + 1 & 3;
                     Object var28;
                     if(var8.field964 == -1 && null == var8.impostorIds) {
                        var28 = var8.method875(2, 4 + var4, var15, var17, var16, var18);
                        var23 = var8.method875(2, var26, var15, var17, var16, var18);
                     } else {
                        var28 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field964, true, (Renderable)null);
                        var23 = new class12(var3, 2, var26, var0, var1, var2, var8.field964, true, (Renderable)null);
                     }

                     var6.method1962(var0, var1, var2, var16, (Renderable)var28, (Renderable)var23, class5.field83[var4], class5.field83[var26], var19, var20);
                     if(var8.field951) {
                        if(var4 == 0) {
                           class5.field82[var0][var1][var2] |= 585;
                           class5.field82[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           class5.field82[var0][var1][var2 + 1] |= 1170;
                           class5.field82[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           class5.field82[var0][1 + var1][var2] |= 585;
                           class5.field82[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class5.field82[var0][var1][var2] |= 1170;
                           class5.field82[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field952 != 0 && null != var7) {
                        var7.method2449(var1, var2, var5, var4, var8.field953);
                     }

                     if(var8.field959 != 16) {
                        var6.method1977(var0, var1, var2, var8.field959);
                     }

                  } else if(var5 == 3) {
                     if(var8.field964 == -1 && null == var8.impostorIds) {
                        var21 = var8.method875(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 3, var4, var0, var1, var2, var8.field964, true, (Renderable)null);
                     }

                     var6.method1962(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field84[var4], 0, var19, var20);
                     if(var8.field971) {
                        if(var4 == 0) {
                           class53.field1155[var0][var1][1 + var2] = 50;
                        } else if(var4 == 1) {
                           class53.field1155[var0][1 + var1][1 + var2] = 50;
                        } else if(var4 == 2) {
                           class53.field1155[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class53.field1155[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field952 != 0 && null != var7) {
                        var7.method2449(var1, var2, var5, var4, var8.field953);
                     }

                  } else if(var5 == 9) {
                     if(var8.field964 == -1 && null == var8.impostorIds) {
                        var21 = var8.method875(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field964, true, (Renderable)null);
                     }

                     var6.method1971(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field952 != 0 && null != var7) {
                        var7.method2450(var1, var2, var9, var10, var8.field953);
                     }

                     if(var8.field959 != 16) {
                        var6.method1977(var0, var1, var2, var8.field959);
                     }

                  } else if(var5 == 4) {
                     if(var8.field964 == -1 && null == var8.impostorIds) {
                        var21 = var8.method875(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, var4, var0, var1, var2, var8.field964, true, (Renderable)null);
                     }

                     var6.method1970(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field83[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.method1986(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = Projectile.getObjectDefinition(var22 >> 14 & 32767).field959;
                     }

                     if(var8.field964 == -1 && var8.impostorIds == null) {
                        var23 = var8.method875(4, var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, var4, var0, var1, var2, var8.field964, true, (Renderable)null);
                     }

                     var6.method1970(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, class5.field83[var4], 0, class5.field85[var4] * var26, class5.field79[var4] * var26, var19, var20);
                  } else if(var5 == 6) {
                     var26 = 8;
                     var22 = var6.method1986(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = Projectile.getObjectDefinition(var22 >> 14 & 32767).field959 / 2;
                     }

                     if(var8.field964 == -1 && null == var8.impostorIds) {
                        var23 = var8.method875(4, 4 + var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field964, true, (Renderable)null);
                     }

                     var6.method1970(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, 256, var4, var26 * class5.field95[var4], var26 * class5.field88[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = 2 + var4 & 3;
                     if(var8.field964 == -1 && var8.impostorIds == null) {
                        var21 = var8.method875(4, 4 + var22, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, 4 + var22, var0, var1, var2, var8.field964, true, (Renderable)null);
                     }

                     var6.method1970(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var26 = 8;
                     var22 = var6.method1986(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = Projectile.getObjectDefinition(var22 >> 14 & 32767).field959 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.field964 == -1 && var8.impostorIds == null) {
                        var23 = var8.method875(4, 4 + var4, var15, var17, var16, var18);
                        var29 = var8.method875(4, 4 + var25, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field964, true, (Renderable)null);
                        var29 = new class12(var3, 4, 4 + var25, var0, var1, var2, var8.field964, true, (Renderable)null);
                     }

                     var6.method1970(var0, var1, var2, var16, (Renderable)var23, (Renderable)var29, 256, var4, var26 * class5.field95[var4], var26 * class5.field88[var4], var19, var20);
                  }
               }
            } else {
               if(var8.field964 == -1 && null == var8.impostorIds) {
                  var21 = var8.method875(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 10, var4, var0, var1, var2, var8.field964, true, (Renderable)null);
               }

               if(null != var21 && var6.method1971(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field971) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method2419() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var27 = 0; var27 <= var9; ++var27) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class53.field1155[var0][var27 + var1][var2 + var24]) {
                           class53.field1155[var0][var1 + var27][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field952 != 0 && var7 != null) {
                  var7.method2450(var1, var2, var9, var10, var8.field953);
               }

            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lclass53;",
      garbageValue = "-1670956995"
   )
   public static class53 method739(int var0) {
      class53 var1 = (class53)class53.field1153.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class53.field1152.method3305(15, var0);
         var1 = new class53();
         if(null != var2) {
            var1.method1084(new Buffer(var2));
         }

         class53.field1153.put(var1, (long)var0);
         return var1;
      }
   }
}
