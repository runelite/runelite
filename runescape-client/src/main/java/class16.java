import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class16 extends class131 {
   @ObfuscatedName("d")
   String field180;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -352571313
   )
   int field181 = (int)(class0.method11() / 1000L);
   @ObfuscatedName("h")
   short field182;
   @ObfuscatedName("ml")
   static SpritePixels field183;
   @ObfuscatedName("ny")
   static class51 field184;
   @ObfuscatedName("ru")
   protected static String field186;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 22663889
   )
   static int field187;

   class16(String var1, int var2) {
      this.field180 = var1;
      this.field182 = (short)var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IZI)LFrames;",
      garbageValue = "-579231378"
   )
   public static Frames method185(class182 var0, class182 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3312(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3365(var2, var5[var6]);
         if(null == var7) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3365(var8, 0);
            if(null == var9) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1964432721"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class110.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-72"
   )
   static final void method187(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field308 && WallObject.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class48.region.method1773(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class48.region.method1811(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class48.region.method1878(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class48.region.method1776(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class48.region.method1777(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class48.region.method1764(var0, var2, var3);
               var12 = class187.getObjectDefinition(var34);
               if(var12.field2943 != 0) {
                  Client.collisionMaps[var0].method2312(var2, var3, var35, var36, var12.field2911);
               }
            }

            if(var1 == 1) {
               class48.region.method1765(var0, var2, var3);
            }

            if(var1 == 2) {
               class48.region.method1843(var0, var2, var3);
               var12 = class187.getObjectDefinition(var34);
               if(var12.sizeX + var2 > 103 || var12.sizeX + var3 > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.field2943 != 0) {
                  Client.collisionMaps[var0].method2305(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field2911);
               }
            }

            if(var1 == 3) {
               class48.region.method1767(var0, var2, var3);
               var12 = class187.getObjectDefinition(var34);
               if(var12.field2943 == 1) {
                  Client.collisionMaps[var0].method2321(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class10.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class48.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class187.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.sizeX;
               var16 = var14.sizeY;
            } else {
               var15 = var14.sizeY;
               var16 = var14.sizeX;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = var2 + (var15 + 1 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = (var16 + 1 >> 1) + var3;
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class10.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var18][var19] + var21[var17][var19] >> 2;
            int var23 = (var15 << 6) + (var2 << 7);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = (var4 << 14) + (var3 << 7) + var2 + 1073741824;
            if(var14.field2912 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var14.field2932 == 1) {
               var26 += 256;
            }

            Object var32;
            if(var6 == 22) {
               if(var14.animationId == -1 && null == var14.impostorIds) {
                  var32 = var14.method3653(22, var5, var21, var23, var22, var24);
               } else {
                  var32 = new class49(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var32, var25, var26);
               if(var14.field2943 == 1) {
                  var13.method2310(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && null == var14.impostorIds) {
                     var32 = var14.method3653(var6, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1757(var0, var2, var3, var22, 1, 1, (Renderable)var32, 0, var25, var26);
                  if(var14.field2943 != 0) {
                     var13.method2331(var2, var3, var15, var16, var14.field2911);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var32 = var14.method3653(0, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1890(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field103[var5], 0, var25, var26);
                  if(var14.field2943 != 0) {
                     var13.method2307(var2, var3, var6, var5, var14.field2911);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && null == var14.impostorIds) {
                     var32 = var14.method3653(1, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1890(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field104[var5], 0, var25, var26);
                  if(var14.field2943 != 0) {
                     var13.method2307(var2, var3, var6, var5, var14.field2911);
                  }
               } else {
                  int var27;
                  Object var29;
                  if(var6 == 2) {
                     var27 = var5 + 1 & 3;
                     Object var28;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var28 = var14.method3653(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method3653(2, var27, var21, var23, var22, var24);
                     } else {
                        var28 = new class49(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new class49(var4, 2, var27, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1890(var0, var2, var3, var22, (Renderable)var28, (Renderable)var29, class10.field103[var5], class10.field103[var27], var25, var26);
                     if(var14.field2943 != 0) {
                        var13.method2307(var2, var3, var6, var5, var14.field2911);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && null == var14.impostorIds) {
                        var32 = var14.method3653(3, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1890(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field104[var5], 0, var25, var26);
                     if(var14.field2943 != 0) {
                        var13.method2307(var2, var3, var6, var5, var14.field2911);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var32 = var14.method3653(var6, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1757(var0, var2, var3, var22, 1, 1, (Renderable)var32, 0, var25, var26);
                     if(var14.field2943 != 0) {
                        var13.method2331(var2, var3, var15, var16, var14.field2911);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && null == var14.impostorIds) {
                        var32 = var14.method3653(4, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1756(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field103[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var33;
                     if(var6 == 5) {
                        var27 = 16;
                        var33 = var37.method1773(var0, var2, var3);
                        if(var33 != 0) {
                           var27 = class187.getObjectDefinition(var33 >> 14 & 32767).field2917;
                        }

                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var29 = var14.method3653(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1756(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class10.field103[var5], 0, class10.field105[var5] * var27, class10.field106[var5] * var27, var25, var26);
                     } else if(var6 == 6) {
                        var27 = 8;
                        var33 = var37.method1773(var0, var2, var3);
                        if(var33 != 0) {
                           var27 = class187.getObjectDefinition(var33 >> 14 & 32767).field2917 / 2;
                        }

                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var29 = var14.method3653(4, 4 + var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, 4 + var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1756(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var27 * class10.field97[var5], var27 * class10.field108[var5], var25, var26);
                     } else if(var6 == 7) {
                        var33 = 2 + var5 & 3;
                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var32 = var14.method3653(4, var33 + 4, var21, var23, var22, var24);
                        } else {
                           var32 = new class49(var4, 4, var33 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1756(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, 256, var33, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var27 = 8;
                        var33 = var37.method1773(var0, var2, var3);
                        if(var33 != 0) {
                           var27 = class187.getObjectDefinition(var33 >> 14 & 32767).field2917 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method3653(4, 4 + var5, var21, var23, var22, var24);
                           var30 = var14.method3653(4, 4 + var31, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, 4 + var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new class49(var4, 4, 4 + var31, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1756(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, class10.field97[var5] * var27, class10.field108[var5] * var27, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var32 = var14.method3653(10, var5, var21, var23, var22, var24);
               } else {
                  var32 = new class49(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(null != var32) {
                  var37.method1757(var0, var2, var3, var22, var15, var16, (Renderable)var32, var6 == 11?256:0, var25, var26);
               }

               if(var14.field2943 != 0) {
                  var13.method2331(var2, var3, var15, var16, var14.field2911);
               }
            }
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "1"
   )
   static final byte[] method188(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.method2965();
      if(var3 >= 0 && (class182.field2726 == 0 || var3 <= class182.field2726)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method3010(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2965();
            if(var4 < 0 || class182.field2726 != 0 && var4 > class182.field2726) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class147.method2769(var5, var4, var0, var3, 9);
               } else {
                  class182.field2720.method2763(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
