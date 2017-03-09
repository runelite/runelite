import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("d")
   @Export("rank")
   byte rank;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -197045039
   )
   @Export("world")
   int world;
   @ObfuscatedName("s")
   static int[][][] field300;
   @ObfuscatedName("k")
   static class178 field301;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1177841761
   )
   public static int field302;
   @ObfuscatedName("x")
   @Export("username")
   String username;
   @ObfuscatedName("j")
   String field304;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[BLclass116;I)V",
      garbageValue = "-1559437826"
   )
   static void method275(int var0, byte[] var1, class116 var2) {
      class180 var3 = new class180();
      var3.field2690 = 0;
      var3.hash = (long)var0;
      var3.field2681 = var1;
      var3.field2683 = var2;
      Deque var4 = class183.field2719;
      synchronized(class183.field2719) {
         class183.field2719.method2458(var3);
      }

      class99.method2006();
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-14"
   )
   static final void method276(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field439 && var0 != class31.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = Friend.region.method1920(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = Friend.region.method1922(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = Friend.region.method1785(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = Friend.region.method1782(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = Friend.region.method1783(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               Friend.region.method1771(var0, var2, var3);
               var12 = class195.getObjectDefinition(var34);
               if(var12.field2911 != 0) {
                  Client.collisionMaps[var0].method2295(var2, var3, var35, var36, var12.field2920);
               }
            }

            if(var1 == 1) {
               Friend.region.method1772(var0, var2, var3);
            }

            if(var1 == 2) {
               Friend.region.method1773(var0, var2, var3);
               var12 = class195.getObjectDefinition(var34);
               if(var12.sizeX + var2 > 103 || var12.sizeX + var3 > 103 || var12.sizeY + var2 > 103 || var12.sizeY + var3 > 103) {
                  return;
               }

               if(var12.field2911 != 0) {
                  Client.collisionMaps[var0].method2294(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field2920);
               }
            }

            if(var1 == 3) {
               Friend.region.method1784(var0, var2, var3);
               var12 = class195.getObjectDefinition(var34);
               if(var12.field2911 == 1) {
                  Client.collisionMaps[var0].method2298(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class10.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = Friend.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class195.getObjectDefinition(var4);
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
               var18 = (1 + var15 >> 1) + var2;
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var3 + var16 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = (var16 + 1 >> 1) + var3;
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class10.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var18][var19] + var21[var17][var19] + var21[var17][var20] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = (var4 << 14) + var2 + (var3 << 7) + 1073741824;
            if(var14.field2913 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var14.field2919 == 1) {
               var26 += 256;
            }

            Object var32;
            if(var6 == 22) {
               if(var14.animationId == -1 && null == var14.impostorIds) {
                  var32 = var14.method3654(22, var5, var21, var23, var22, var24);
               } else {
                  var32 = new class49(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var32, var25, var26);
               if(var14.field2911 == 1) {
                  var13.method2320(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && null == var14.impostorIds) {
                     var32 = var14.method3654(var6, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1834(var0, var2, var3, var22, 1, 1, (Renderable)var32, 0, var25, var26);
                  if(var14.field2911 != 0) {
                     var13.method2292(var2, var3, var15, var16, var14.field2920);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && null == var14.impostorIds) {
                     var32 = var14.method3654(0, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1762(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field127[var5], 0, var25, var26);
                  if(var14.field2911 != 0) {
                     var13.method2291(var2, var3, var6, var5, var14.field2920);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var32 = var14.method3654(1, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1762(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field117[var5], 0, var25, var26);
                  if(var14.field2911 != 0) {
                     var13.method2291(var2, var3, var6, var5, var14.field2920);
                  }
               } else {
                  int var27;
                  Object var29;
                  if(var6 == 2) {
                     var27 = 1 + var5 & 3;
                     Object var33;
                     if(var14.animationId == -1 && null == var14.impostorIds) {
                        var33 = var14.method3654(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method3654(2, var27, var21, var23, var22, var24);
                     } else {
                        var33 = new class49(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new class49(var4, 2, var27, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1762(var0, var2, var3, var22, (Renderable)var33, (Renderable)var29, class10.field127[var5], class10.field127[var27], var25, var26);
                     if(var14.field2911 != 0) {
                        var13.method2291(var2, var3, var6, var5, var14.field2920);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var32 = var14.method3654(3, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1762(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field117[var5], 0, var25, var26);
                     if(var14.field2911 != 0) {
                        var13.method2291(var2, var3, var6, var5, var14.field2920);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && null == var14.impostorIds) {
                        var32 = var14.method3654(var6, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1834(var0, var2, var3, var22, 1, 1, (Renderable)var32, 0, var25, var26);
                     if(var14.field2911 != 0) {
                        var13.method2292(var2, var3, var15, var16, var14.field2920);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var32 = var14.method3654(4, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1849(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field127[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var27 = 16;
                        var28 = var37.method1920(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = class195.getObjectDefinition(var28 >> 14 & 32767).field2918;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method3654(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1849(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class10.field127[var5], 0, var27 * class10.field118[var5], class10.field123[var5] * var27, var25, var26);
                     } else if(var6 == 6) {
                        var27 = 8;
                        var28 = var37.method1920(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = class195.getObjectDefinition(var28 >> 14 & 32767).field2918 / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method3654(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, 4 + var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1849(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, class10.field120[var5] * var27, var27 * class10.field109[var5], var25, var26);
                     } else if(var6 == 7) {
                        var28 = var5 + 2 & 3;
                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var32 = var14.method3654(4, var28 + 4, var21, var23, var22, var24);
                        } else {
                           var32 = new class49(var4, 4, var28 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1849(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var27 = 8;
                        var28 = var37.method1920(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = class195.getObjectDefinition(var28 >> 14 & 32767).field2918 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var29 = var14.method3654(4, 4 + var5, var21, var23, var22, var24);
                           var30 = var14.method3654(4, 4 + var31, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, 4 + var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new class49(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1849(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, class10.field120[var5] * var27, class10.field109[var5] * var27, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var32 = var14.method3654(10, var5, var21, var23, var22, var24);
               } else {
                  var32 = new class49(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(null != var32) {
                  var37.method1834(var0, var2, var3, var22, var15, var16, (Renderable)var32, var6 == 11?256:0, var25, var26);
               }

               if(var14.field2911 != 0) {
                  var13.method2292(var2, var3, var15, var16, var14.field2920);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-913835345"
   )
   public static char method277(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZB)Z",
      garbageValue = "115"
   )
   public static boolean method278(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }
}
