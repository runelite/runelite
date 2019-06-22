import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
@Implements("ParamKeyDefinition")
public class ParamKeyDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__jb_m")
   public static AbstractIndexCache __jb_m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("ParamKeyDefinition_cached")
   static EvictingDualNodeHashTable ParamKeyDefinition_cached;
   @ObfuscatedName("q")
   @Export("type")
   char type;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1133042753
   )
   @Export("keyInt")
   public int keyInt;
   @ObfuscatedName("o")
   @Export("keyString")
   public String keyString;
   @ObfuscatedName("u")
   @Export("isMembersOnly")
   boolean isMembersOnly;

   ParamKeyDefinition() {
      this.isMembersOnly = true;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "121"
   )
   @Export("init")
   void init() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-975533635"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "1664350313"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.type = class14.method171(var1.readByte());
      } else if(var2 == 2) {
         this.keyInt = var1.readInt();
      } else if(var2 == 4) {
         this.isMembersOnly = false;
      } else if(var2 == 5) {
         this.keyString = var1.readStringCp1252NullTerminated();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1897943299"
   )
   @Export("isString")
   public boolean isString() {
      return this.type == 's';
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-904254947"
   )
   static final void method4933(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.isLowDetail && var0 != SoundSystem.plane) {
            return;
         }

         long var7 = 0L;
         boolean var9 = true;
         boolean var10 = false;
         boolean var11 = false;
         if(var1 == 0) {
            var7 = class65.scene.__ar_244(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class65.scene.__ac_245(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class65.scene.__ay_246(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class65.scene.getFloorDecorationTag(var0, var2, var3);
         }

         int var12;
         if(0L != var7) {
            var12 = class65.scene.getObjectFlags(var0, var2, var3, var7);
            int var13 = HitSplatDefinition.method4972(var7);
            int var14 = var12 & 31;
            int var15 = var12 >> 6 & 3;
            ObjectDefinition var16;
            if(var1 == 0) {
               class65.scene.removeBoundaryObject(var0, var2, var3);
               var16 = class50.getObjectDefinition(var13);
               if(var16.interactType != 0) {
                  Client.collisionMaps[var0].__g_288(var2, var3, var14, var15, var16.boolean1);
               }
            }

            if(var1 == 1) {
               class65.scene.removeWallDecoration(var0, var2, var3);
            }

            if(var1 == 2) {
               class65.scene.__c_242(var0, var2, var3);
               var16 = class50.getObjectDefinition(var13);
               if(var2 + var16.sizeX > 103 || var3 + var16.sizeX > 103 || var2 + var16.sizeY > 103 || var3 + var16.sizeY > 103) {
                  return;
               }

               if(var16.interactType != 0) {
                  Client.collisionMaps[var0].__l_289(var2, var3, var16.sizeX, var16.sizeY, var15, var16.boolean1);
               }
            }

            if(var1 == 3) {
               class65.scene.removeFloorDecoration(var0, var2, var3);
               var16 = class50.getObjectDefinition(var13);
               if(var16.interactType == 1) {
                  Client.collisionMaps[var0].__x_291(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var12 = var0;
            if(var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
               var12 = var0 + 1;
            }

            Scene var36 = class65.scene;
            CollisionMap var37 = Client.collisionMaps[var0];
            ObjectDefinition var38 = class50.getObjectDefinition(var4);
            int var17;
            int var39;
            if(var5 != 1 && var5 != 3) {
               var39 = var38.sizeX;
               var17 = var38.sizeY;
            } else {
               var39 = var38.sizeY;
               var17 = var38.sizeX;
            }

            int var18;
            int var19;
            if(var39 + var2 <= 104) {
               var18 = (var39 >> 1) + var2;
               var19 = var2 + (var39 + 1 >> 1);
            } else {
               var18 = var2;
               var19 = var2 + 1;
            }

            int var20;
            int var21;
            if(var3 + var17 <= 104) {
               var20 = var3 + (var17 >> 1);
               var21 = var3 + (var17 + 1 >> 1);
            } else {
               var20 = var3;
               var21 = var3 + 1;
            }

            int[][] var22 = Tiles.Tiles_heights[var12];
            int var23 = var22[var18][var21] + var22[var19][var20] + var22[var18][var20] + var22[var19][var21] >> 2;
            int var24 = (var2 << 7) + (var39 << 6);
            int var25 = (var3 << 7) + (var17 << 6);
            long var26 = FontName.method5637(var2, var3, 2, var38.int1 == 0, var4);
            int var28 = (var5 << 6) + var6;
            if(var38.int3 == 1) {
               var28 += 256;
            }

            Object var29;
            if(var6 == 22) {
               if(var38.animationId == -1 && var38.transforms == null) {
                  var29 = var38.getModel(22, var5, var22, var24, var23, var25);
               } else {
                  var29 = new DynamicObject(var4, 22, var5, var12, var2, var3, var38.animationId, true, (Entity)null);
               }

               var36.newFloorDecoration(var0, var2, var3, var23, (Entity)var29, var26, var28);
               if(var38.interactType == 1) {
                  var37.__o_286(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var38.animationId == -1 && var38.transforms == null) {
                     var29 = var38.getModel(var6, var5, var22, var24, var23, var25);
                  } else {
                     var29 = new DynamicObject(var4, var6, var5, var12, var2, var3, var38.animationId, true, (Entity)null);
                  }

                  var36.__d_238(var0, var2, var3, var23, 1, 1, (Entity)var29, 0, var26, var28);
                  if(var38.interactType != 0) {
                     var37.__q_284(var2, var3, var39, var17, var38.boolean1);
                  }
               } else if(var6 == 0) {
                  if(var38.animationId == -1 && var38.transforms == null) {
                     var29 = var38.getModel(0, var5, var22, var24, var23, var25);
                  } else {
                     var29 = new DynamicObject(var4, 0, var5, var12, var2, var3, var38.animationId, true, (Entity)null);
                  }

                  var36.newBoundaryObject(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.__bq_t[var5], 0, var26, var28);
                  if(var38.interactType != 0) {
                     var37.__f_283(var2, var3, var6, var5, var38.boolean1);
                  }
               } else if(var6 == 1) {
                  if(var38.animationId == -1 && var38.transforms == null) {
                     var29 = var38.getModel(1, var5, var22, var24, var23, var25);
                  } else {
                     var29 = new DynamicObject(var4, 1, var5, var12, var2, var3, var38.animationId, true, (Entity)null);
                  }

                  var36.newBoundaryObject(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.__bq_y[var5], 0, var26, var28);
                  if(var38.interactType != 0) {
                     var37.__f_283(var2, var3, var6, var5, var38.boolean1);
                  }
               } else {
                  int var30;
                  Object var31;
                  if(var6 == 2) {
                     var30 = var5 + 1 & 3;
                     Object var32;
                     if(var38.animationId == -1 && var38.transforms == null) {
                        var31 = var38.getModel(2, var5 + 4, var22, var24, var23, var25);
                        var32 = var38.getModel(2, var30, var22, var24, var23, var25);
                     } else {
                        var31 = new DynamicObject(var4, 2, var5 + 4, var12, var2, var3, var38.animationId, true, (Entity)null);
                        var32 = new DynamicObject(var4, 2, var30, var12, var2, var3, var38.animationId, true, (Entity)null);
                     }

                     var36.newBoundaryObject(var0, var2, var3, var23, (Entity)var31, (Entity)var32, Tiles.__bq_t[var5], Tiles.__bq_t[var30], var26, var28);
                     if(var38.interactType != 0) {
                        var37.__f_283(var2, var3, var6, var5, var38.boolean1);
                     }
                  } else if(var6 == 3) {
                     if(var38.animationId == -1 && var38.transforms == null) {
                        var29 = var38.getModel(3, var5, var22, var24, var23, var25);
                     } else {
                        var29 = new DynamicObject(var4, 3, var5, var12, var2, var3, var38.animationId, true, (Entity)null);
                     }

                     var36.newBoundaryObject(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.__bq_y[var5], 0, var26, var28);
                     if(var38.interactType != 0) {
                        var37.__f_283(var2, var3, var6, var5, var38.boolean1);
                     }
                  } else if(var6 == 9) {
                     if(var38.animationId == -1 && var38.transforms == null) {
                        var29 = var38.getModel(var6, var5, var22, var24, var23, var25);
                     } else {
                        var29 = new DynamicObject(var4, var6, var5, var12, var2, var3, var38.animationId, true, (Entity)null);
                     }

                     var36.__d_238(var0, var2, var3, var23, 1, 1, (Entity)var29, 0, var26, var28);
                     if(var38.interactType != 0) {
                        var37.__q_284(var2, var3, var39, var17, var38.boolean1);
                     }
                  } else if(var6 == 4) {
                     if(var38.animationId == -1 && var38.transforms == null) {
                        var29 = var38.getModel(4, var5, var22, var24, var23, var25);
                     } else {
                        var29 = new DynamicObject(var4, 4, var5, var12, var2, var3, var38.animationId, true, (Entity)null);
                     }

                     var36.newWallDecoration(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.__bq_t[var5], 0, 0, 0, var26, var28);
                  } else {
                     long var40;
                     if(var6 == 5) {
                        var30 = 16;
                        var40 = var36.__ar_244(var0, var2, var3);
                        if(var40 != 0L) {
                           var30 = class50.getObjectDefinition(HitSplatDefinition.method4972(var40)).int2;
                        }

                        if(var38.animationId == -1 && var38.transforms == null) {
                           var31 = var38.getModel(4, var5, var22, var24, var23, var25);
                        } else {
                           var31 = new DynamicObject(var4, 4, var5, var12, var2, var3, var38.animationId, true, (Entity)null);
                        }

                        var36.newWallDecoration(var0, var2, var3, var23, (Entity)var31, (Entity)null, Tiles.__bq_t[var5], 0, var30 * Tiles.__bq_h[var5], var30 * Tiles.__bq_b[var5], var26, var28);
                     } else if(var6 == 6) {
                        var30 = 8;
                        var40 = var36.__ar_244(var0, var2, var3);
                        if(var40 != 0L) {
                           var30 = class50.getObjectDefinition(HitSplatDefinition.method4972(var40)).int2 / 2;
                        }

                        if(var38.animationId == -1 && var38.transforms == null) {
                           var31 = var38.getModel(4, var5 + 4, var22, var24, var23, var25);
                        } else {
                           var31 = new DynamicObject(var4, 4, var5 + 4, var12, var2, var3, var38.animationId, true, (Entity)null);
                        }

                        var36.newWallDecoration(var0, var2, var3, var23, (Entity)var31, (Entity)null, 256, var5, var30 * Tiles.__bq_c[var5], var30 * Tiles.__bq_r[var5], var26, var28);
                     } else {
                        int var34;
                        if(var6 == 7) {
                           var34 = var5 + 2 & 3;
                           if(var38.animationId == -1 && var38.transforms == null) {
                              var29 = var38.getModel(4, var34 + 4, var22, var24, var23, var25);
                           } else {
                              var29 = new DynamicObject(var4, 4, var34 + 4, var12, var2, var3, var38.animationId, true, (Entity)null);
                           }

                           var36.newWallDecoration(var0, var2, var3, var23, (Entity)var29, (Entity)null, 256, var34, 0, 0, var26, var28);
                        } else if(var6 == 8) {
                           var30 = 8;
                           var40 = var36.__ar_244(var0, var2, var3);
                           if(var40 != 0L) {
                              var30 = class50.getObjectDefinition(HitSplatDefinition.method4972(var40)).int2 / 2;
                           }

                           var34 = var5 + 2 & 3;
                           Object var35;
                           if(var38.animationId == -1 && var38.transforms == null) {
                              var31 = var38.getModel(4, var5 + 4, var22, var24, var23, var25);
                              var35 = var38.getModel(4, var34 + 4, var22, var24, var23, var25);
                           } else {
                              var31 = new DynamicObject(var4, 4, var5 + 4, var12, var2, var3, var38.animationId, true, (Entity)null);
                              var35 = new DynamicObject(var4, 4, var34 + 4, var12, var2, var3, var38.animationId, true, (Entity)null);
                           }

                           var36.newWallDecoration(var0, var2, var3, var23, (Entity)var31, (Entity)var35, 256, var5, var30 * Tiles.__bq_c[var5], var30 * Tiles.__bq_r[var5], var26, var28);
                        }
                     }
                  }
               }
            } else {
               if(var38.animationId == -1 && var38.transforms == null) {
                  var29 = var38.getModel(10, var5, var22, var24, var23, var25);
               } else {
                  var29 = new DynamicObject(var4, 10, var5, var12, var2, var3, var38.animationId, true, (Entity)null);
               }

               if(var29 != null) {
                  var36.__d_238(var0, var2, var3, var23, var39, var17, (Entity)var29, var6 == 11?256:0, var26, var28);
               }

               if(var38.interactType != 0) {
                  var37.__q_284(var2, var3, var39, var17, var38.boolean1);
               }
            }
         }
      }

   }

   static {
      ParamKeyDefinition_cached = new EvictingDualNodeHashTable(64);
   }
}
