import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class63 implements Runnable {
   @ObfuscatedName("h")
   volatile boolean field1089 = false;
   @ObfuscatedName("s")
   class103 field1090;
   @ObfuscatedName("f")
   volatile boolean field1091 = false;
   @ObfuscatedName("c")
   volatile class57[] field1093 = new class57[2];
   @ObfuscatedName("ml")
   static SpritePixels field1094;

   public void run() {
      this.field1089 = true;

      try {
         while(!this.field1091) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class57 var2 = this.field1093[var1];
               if(null != var2) {
                  var2.method1033();
               }
            }

            Projectile.method757(10L);
            Item.method775(this.field1090, (Object)null);
         }
      } catch (Exception var7) {
         NPC.method695((String)null, var7);
      } finally {
         this.field1089 = false;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIS)I",
      garbageValue = "-13255"
   )
   static int method1104(int var0, int var1, int var2) {
      return (class10.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class10.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "1498514632"
   )
   static final void method1105(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field299 || (class10.tileSettings[0][var1][var2] & 2) != 0 || (class10.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class10.field91) {
            class10.field91 = var0;
         }

         ObjectComposition var8 = class143.getObjectDefinition(var3);
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

         int[][] var15 = class10.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + var1 + (var2 << 7) + (var3 << 14);
         if(var8.field2910 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field2939 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method3492()) {
            class31 var21 = new class31();
            var21.field704 = var0;
            var21.field705 = var1 * 128;
            var21.field715 = var2 * 128;
            var22 = var8.sizeX;
            var23 = var8.sizeY;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.sizeY;
               var23 = var8.sizeX;
            }

            var21.field706 = (var22 + var1) * 128;
            var21.field708 = (var23 + var2) * 128;
            var21.field707 = var8.ambientSoundId;
            var21.field710 = var8.field2944 * 128;
            var21.field712 = var8.field2945;
            var21.field713 = var8.field2946;
            var21.field709 = var8.field2937;
            if(null != var8.impostorIds) {
               var21.field717 = var8;
               var21.method653();
            }

            class31.field703.method2333(var21);
            if(null != var21.field709) {
               var21.field714 = var21.field712 + (int)(Math.random() * (double)(var21.field713 - var21.field712));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.field299 || var8.field2910 != 0 || var8.field2916 == 1 || var8.field2904) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method3486(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.field2916 == 1 && null != var7) {
                  var7.method2180(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var30 = var8.method3486(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method1810(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class161.field2152[var0][var1][var2] |= 2340;
               }

               if(var8.field2916 != 0 && var7 != null) {
                  var7.method2181(var1, var2, var9, var10, var8.field2933);
               }

            } else if(var5 == 0) {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var30 = var8.method3486(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method1700(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field100[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field2930) {
                     class162.field2157[var0][var1][var2] = 50;
                     class162.field2157[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.field2921) {
                     class161.field2152[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field2930) {
                     class162.field2157[var0][var1][1 + var2] = 50;
                     class162.field2157[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field2921) {
                     class161.field2152[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.field2930) {
                     class162.field2157[var0][1 + var1][var2] = 50;
                     class162.field2157[var0][1 + var1][1 + var2] = 50;
                  }

                  if(var8.field2921) {
                     class161.field2152[var0][1 + var1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.field2930) {
                     class162.field2157[var0][var1][var2] = 50;
                     class162.field2157[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.field2921) {
                     class161.field2152[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field2916 != 0 && null != var7) {
                  var7.method2185(var1, var2, var5, var4, var8.field2933);
               }

               if(var8.field2923 != 16) {
                  var6.method1674(var0, var1, var2, var8.field2923);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method3486(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method1700(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field101[var4], 0, var19, var20);
               if(var8.field2930) {
                  if(var4 == 0) {
                     class162.field2157[var0][var1][1 + var2] = 50;
                  } else if(var4 == 1) {
                     class162.field2157[var0][1 + var1][1 + var2] = 50;
                  } else if(var4 == 2) {
                     class162.field2157[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class162.field2157[var0][var1][var2] = 50;
                  }
               }

               if(var8.field2916 != 0 && var7 != null) {
                  var7.method2185(var1, var2, var5, var4, var8.field2933);
               }

            } else {
               int var27;
               Object var28;
               if(var5 == 2) {
                  var27 = var4 + 1 & 3;
                  Object var26;
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var26 = var8.method3486(2, var4 + 4, var15, var17, var16, var18);
                     var28 = var8.method3486(2, var27, var15, var17, var16, var18);
                  } else {
                     var26 = new class49(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var28 = new class49(var3, 2, var27, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1700(var0, var1, var2, var16, (Renderable)var26, (Renderable)var28, class10.field100[var4], class10.field100[var27], var19, var20);
                  if(var8.field2921) {
                     if(var4 == 0) {
                        class161.field2152[var0][var1][var2] |= 585;
                        class161.field2152[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class161.field2152[var0][var1][var2 + 1] |= 1170;
                        class161.field2152[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class161.field2152[var0][var1 + 1][var2] |= 585;
                        class161.field2152[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class161.field2152[var0][var1][var2] |= 1170;
                        class161.field2152[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field2916 != 0 && null != var7) {
                     var7.method2185(var1, var2, var5, var4, var8.field2933);
                  }

                  if(var8.field2923 != 16) {
                     var6.method1674(var0, var1, var2, var8.field2923);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method3486(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1700(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field101[var4], 0, var19, var20);
                  if(var8.field2930) {
                     if(var4 == 0) {
                        class162.field2157[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class162.field2157[var0][var1 + 1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class162.field2157[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class162.field2157[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2916 != 0 && null != var7) {
                     var7.method2185(var1, var2, var5, var4, var8.field2933);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var30 = var8.method3486(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1810(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.field2916 != 0 && var7 != null) {
                     var7.method2181(var1, var2, var9, var10, var8.field2933);
                  }

                  if(var8.field2923 != 16) {
                     var6.method1674(var0, var1, var2, var8.field2923);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method3486(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1667(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field100[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var27 = 16;
                  var22 = var6.method1684(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class143.getObjectDefinition(var22 >> 14 & 32767).field2923;
                  }

                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var28 = var8.method3486(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1667(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class10.field100[var4], 0, var27 * class10.field102[var4], class10.field103[var4] * var27, var19, var20);
               } else if(var5 == 6) {
                  var27 = 8;
                  var22 = var6.method1684(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class143.getObjectDefinition(var22 >> 14 & 32767).field2923 / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.method3486(4, 4 + var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1667(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, class10.field104[var4] * var27, var27 * class10.field98[var4], var19, var20);
               } else if(var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var30 = var8.method3486(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1667(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var27 = 8;
                  var22 = var6.method1684(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class143.getObjectDefinition(var22 >> 14 & 32767).field2923 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var29;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.method3486(4, 4 + var4, var15, var17, var16, var18);
                     var29 = var8.method3486(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new class49(var3, 4, 4 + var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var29 = new class49(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1667(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, class10.field104[var4] * var27, var27 * class10.field98[var4], var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.method3486(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new class49(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(null != var30 && var6.method1810(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.field2930) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method1569() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class162.field2157[var0][var23 + var1][var2 + var24]) {
                        class162.field2157[var0][var1 + var23][var2 + var24] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.field2916 != 0 && var7 != null) {
               var7.method2181(var1, var2, var9, var10, var8.field2933);
            }

         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CIB)C",
      garbageValue = "-12"
   )
   public static char method1106(char var0, int var1) {
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

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3329"
   )
   static void method1107() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(Client.method382(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[1 + var1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
