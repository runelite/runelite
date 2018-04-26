import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1863012989
   )
   static int field1233;
   @ObfuscatedName("b")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("z")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -497544043
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("l")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("s")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("y")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1233 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      this.method1764(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgg;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1233) {
            if(var1.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if(var2 > 1) {
               this.muted = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.screenType = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.rememberedUsername = var1.getNullString();
            }

            if(var2 > 5) {
               this.hideUsername = var1.method3605();
            }
         } else {
            this.method1764(true);
         }
      } else {
         this.method1764(true);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "16"
   )
   void method1764(boolean var1) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)Lgg;",
      garbageValue = "2876"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1233);
      var1.putByte(this.hideRoofs?1:0);
      var1.putByte(this.muted?1:0);
      var1.putByte(this.screenType);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      var1.putString(this.rememberedUsername != null?this.rememberedUsername:"");
      var1.writeBooleanAsByte(this.hideUsername);
      return var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1430852055"
   )
   public static void method1768(int var0) {
      if(class229.field2694 != 0) {
         AttackOption.field1334 = var0;
      } else {
         class38.field507.method4324(var0);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "249396908"
   )
   public static byte[] method1778() {
      byte[] var0 = new byte[24];

      try {
         class167.randomDat.seek(0L);
         class167.randomDat.read(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgl;IB)Z",
      garbageValue = "45"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class93.field1413[++class93.field1414 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.playerId = var1;
            if(class93.field1404[var1] != null) {
               var6.decodeApperance(class93.field1404[var1]);
            }

            var6.orientation = class93.Players_orientations[var1];
            var6.interacting = class93.Players_targetIndices[var1];
            var7 = class93.Players_regions[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.pathTraversed[0] = class93.field1416[var1];
            var6.field831 = (byte)var8;
            var6.method1250((var9 << 13) + var3 - ClientPacket.baseX, (var10 << 13) + var4 - MapIconReference.baseY);
            var6.field840 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class93.Players_regions[var1];
         class93.Players_regions[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class93.Players_regions[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class93.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class93.Players_regions[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class93.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1614945536"
   )
   static final void method1780(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != ScriptVarType.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = GameSocket.region.getWallObjectHash(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = GameSocket.region.method3067(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = GameSocket.region.method2974(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = GameSocket.region.getGroundObjectHash(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = GameSocket.region.getObjectFlags(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               GameSocket.region.removeBoundaryObject(var0, var2, var3);
               var12 = class80.getObjectDefinition(var34);
               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var35, var36, var12.blocksProjectile);
               }
            }

            if(var1 == 1) {
               GameSocket.region.removeWallDecoration(var0, var2, var3);
            }

            if(var1 == 2) {
               GameSocket.region.method3024(var0, var2, var3);
               var12 = class80.getObjectDefinition(var34);
               if(var2 + var12.width > 103 || var3 + var12.width > 103 || var2 + var12.length > 103 || var3 + var12.length > 103) {
                  return;
               }

               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.width, var12.length, var36, var12.blocksProjectile);
               }
            }

            if(var1 == 3) {
               GameSocket.region.removeFloorDecoration(var0, var2, var3);
               var12 = class80.getObjectDefinition(var34);
               if(var12.clipType == 1) {
                  Client.collisionMaps[var0].method3467(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class62.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = GameSocket.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class80.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.width;
               var16 = var14.length;
            } else {
               var15 = var14.length;
               var16 = var14.width;
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
            if(var3 + var16 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = var3 + (var16 + 1 >> 1);
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class62.tileHeights[var11];
            int var22 = var21[var17][var20] + var21[var17][var19] + var21[var18][var19] + var21[var18][var20] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
            if(var14.int1 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.supportItems == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method5083(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.clipType == 1) {
                  var13.method3472(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method5083(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2957(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.clipType != 0) {
                     var13.addObject(var2, var3, var15, var16, var14.blocksProjectile);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method5083(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class62.field727[var5], 0, var25, var26);
                  if(var14.clipType != 0) {
                     var13.method3462(var2, var3, var6, var5, var14.blocksProjectile);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method5083(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class62.field728[var5], 0, var25, var26);
                  if(var14.clipType != 0) {
                     var13.method3462(var2, var3, var6, var5, var14.blocksProjectile);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = var5 + 1 & 3;
                     Object var28;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var28 = var14.method5083(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method5083(2, var32, var21, var23, var22, var24);
                     } else {
                        var28 = new DynamicObject(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var4, 2, var32, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var28, (Renderable)var29, class62.field727[var5], class62.field727[var32], var25, var26);
                     if(var14.clipType != 0) {
                        var13.method3462(var2, var3, var6, var5, var14.blocksProjectile);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method5083(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class62.field728[var5], 0, var25, var26);
                     if(var14.clipType != 0) {
                        var13.method3462(var2, var3, var6, var5, var14.blocksProjectile);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method5083(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2957(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.clipType != 0) {
                        var13.addObject(var2, var3, var15, var16, var14.blocksProjectile);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method5083(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class62.field727[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var33;
                     if(var6 == 5) {
                        var32 = 16;
                        var33 = var37.getWallObjectHash(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class80.getObjectDefinition(var33 >> 14 & 32767).decorDisplacement;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method5083(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class62.field727[var5], 0, var32 * class62.field731[var5], var32 * class62.field721[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var33 = var37.getWallObjectHash(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class80.getObjectDefinition(var33 >> 14 & 32767).decorDisplacement / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method5083(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class62.field726[var5], var32 * class62.field729[var5], var25, var26);
                     } else if(var6 == 7) {
                        var33 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var27 = var14.method5083(4, var33 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new DynamicObject(var4, 4, var33 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var33, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var33 = var37.getWallObjectHash(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class80.getObjectDefinition(var33 >> 14 & 32767).decorDisplacement / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method5083(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method5083(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new DynamicObject(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, var32 * class62.field726[var5], var32 * class62.field729[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method5083(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method2957(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.clipType != 0) {
                  var13.addObject(var2, var3, var15, var16, var14.blocksProjectile);
               }
            }
         }
      }

   }
}
