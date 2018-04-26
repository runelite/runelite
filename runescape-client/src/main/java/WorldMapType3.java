import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1008522173
   )
   int field388;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1262319407
   )
   int field376;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1157263975
   )
   int field377;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -870795315
   )
   int field378;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2112960235
   )
   int field379;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2010715961
   )
   int field387;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -491573351
   )
   int field381;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -433464889
   )
   int field382;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1618261401
   )
   int field383;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1748822665
   )
   int field384;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -109778451
   )
   int field375;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 386871891
   )
   int field386;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1377385983
   )
   int field390;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -89970333
   )
   int field380;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "1011910161"
   )
   public void vmethod763(WorldMapData var1) {
      if(var1.minX > this.field379) {
         var1.minX = this.field379;
      }

      if(var1.field448 < this.field379) {
         var1.field448 = this.field379;
      }

      if(var1.minY > this.field387) {
         var1.minY = this.field387;
      }

      if(var1.field450 < this.field387) {
         var1.field450 = this.field387;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "516050332"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field388 && var1 < this.field388 + this.field376?var2 >= (this.field377 << 6) + (this.field381 << 3) && var2 <= (this.field377 << 6) + (this.field383 << 3) + 7 && var3 >= (this.field378 << 6) + (this.field382 << 3) && var3 <= (this.field378 << 6) + (this.field384 << 3) + 7:false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2066198604"
   )
   public boolean vmethod766(int var1, int var2) {
      return var1 >= (this.field379 << 6) + (this.field375 << 3) && var1 <= (this.field379 << 6) + (this.field390 << 3) + 7 && var2 >= (this.field387 << 6) + (this.field386 << 3) && var2 <= (this.field387 << 6) + (this.field380 << 3) + 7;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "-3"
   )
   public int[] vmethod767(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field379 * 64 - this.field377 * 64 + var2 + (this.field375 * 8 - this.field381 * 8), var3 + (this.field387 * 64 - this.field378 * 64) + (this.field386 * 8 - this.field382 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)Lio;",
      garbageValue = "0"
   )
   public Coordinates vmethod768(int var1, int var2) {
      if(!this.vmethod766(var1, var2)) {
         return null;
      } else {
         int var3 = this.field377 * 64 - this.field379 * 64 + (this.field381 * 8 - this.field375 * 8) + var1;
         int var4 = this.field378 * 64 - this.field387 * 64 + var2 + (this.field382 * 8 - this.field386 * 8);
         return new Coordinates(this.field388, var3, var4);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgg;B)V",
      garbageValue = "67"
   )
   public void vmethod769(Buffer var1) {
      this.field388 = var1.readUnsignedByte();
      this.field376 = var1.readUnsignedByte();
      this.field377 = var1.readUnsignedShort();
      this.field381 = var1.readUnsignedByte();
      this.field383 = var1.readUnsignedByte();
      this.field378 = var1.readUnsignedShort();
      this.field382 = var1.readUnsignedByte();
      this.field384 = var1.readUnsignedByte();
      this.field379 = var1.readUnsignedShort();
      this.field375 = var1.readUnsignedByte();
      this.field390 = var1.readUnsignedByte();
      this.field387 = var1.readUnsignedShort();
      this.field386 = var1.readUnsignedByte();
      this.field380 = var1.readUnsignedByte();
      this.method200();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-11"
   )
   void method200() {
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIILeb;Lff;B)V",
      garbageValue = "-4"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class62.tileSettings[0][var1][var2] & 2) != 0 || (class62.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class62.field722) {
            class62.field722 = var0;
         }

         ObjectComposition var8 = class80.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.width;
            var10 = var8.length;
         } else {
            var9 = var8.length;
            var10 = var8.width;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class62.tileHeights[var0];
         int var16 = var15[var11][var14] + var15[var11][var13] + var15[var12][var13] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.int1 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.supportItems == 1) {
            var20 += 256;
         }

         if(var8.method5104()) {
            class177.method3494(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.int1 != 0 || var8.clipType == 1 || var8.obstructsGround) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.clipType == 1 && var7 != null) {
                  var7.method3472(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2957(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     BoundingBox3DDrawMode.field271[var0][var1][var2] |= 2340;
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class62.field727[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.clipped) {
                        WorldMapType2.field519[var0][var1][var2] = 50;
                        WorldMapType2.field519[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        BoundingBox3DDrawMode.field271[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.clipped) {
                        WorldMapType2.field519[var0][var1][var2 + 1] = 50;
                        WorldMapType2.field519[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        BoundingBox3DDrawMode.field271[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.clipped) {
                        WorldMapType2.field519[var0][var1 + 1][var2] = 50;
                        WorldMapType2.field519[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        BoundingBox3DDrawMode.field271[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.clipped) {
                        WorldMapType2.field519[var0][var1][var2] = 50;
                        WorldMapType2.field519[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.modelClipped) {
                        BoundingBox3DDrawMode.field271[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3462(var1, var2, var5, var4, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method3109(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class62.field728[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        WorldMapType2.field519[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        WorldMapType2.field519[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        WorldMapType2.field519[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        WorldMapType2.field519[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3462(var1, var2, var5, var4, var8.blocksProjectile);
                  }

               } else {
                  int var26;
                  Object var28;
                  if(var5 == 2) {
                     var26 = var4 + 1 & 3;
                     Object var27;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var27 = var8.getModel(2, var4 + 4, var15, var17, var16, var18);
                        var28 = var8.getModel(2, var26, var15, var17, var16, var18);
                     } else {
                        var27 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var28 = new DynamicObject(var3, 2, var26, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class62.field727[var4], class62.field727[var26], var19, var20);
                     if(var8.modelClipped) {
                        if(var4 == 0) {
                           BoundingBox3DDrawMode.field271[var0][var1][var2] |= 585;
                           BoundingBox3DDrawMode.field271[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           BoundingBox3DDrawMode.field271[var0][var1][1 + var2] |= 1170;
                           BoundingBox3DDrawMode.field271[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           BoundingBox3DDrawMode.field271[var0][var1 + 1][var2] |= 585;
                           BoundingBox3DDrawMode.field271[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           BoundingBox3DDrawMode.field271[var0][var1][var2] |= 1170;
                           BoundingBox3DDrawMode.field271[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.clipType != 0 && var7 != null) {
                        var7.method3462(var1, var2, var5, var4, var8.blocksProjectile);
                     }

                     if(var8.decorDisplacement != 16) {
                        var6.method3109(var0, var1, var2, var8.decorDisplacement);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class62.field728[var4], 0, var19, var20);
                     if(var8.clipped) {
                        if(var4 == 0) {
                           WorldMapType2.field519[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           WorldMapType2.field519[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           WorldMapType2.field519[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           WorldMapType2.field519[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.clipType != 0 && var7 != null) {
                        var7.method3462(var1, var2, var5, var4, var8.blocksProjectile);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2957(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.clipType != 0 && var7 != null) {
                        var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                     }

                     if(var8.decorDisplacement != 16) {
                        var6.method3109(var0, var1, var2, var8.decorDisplacement);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class62.field727[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.getWallObjectHash(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class80.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class62.field727[var4], 0, var26 * class62.field731[var4], var26 * class62.field721[var4], var19, var20);
                  } else if(var5 == 6) {
                     var26 = 8;
                     var22 = var6.getWallObjectHash(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class80.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class62.field726[var4], var26 * class62.field729[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var26 = 8;
                     var22 = var6.getWallObjectHash(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class80.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                        var29 = var8.getModel(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class62.field726[var4], var26 * class62.field729[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method2957(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.clipped) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method2789() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > WorldMapType2.field519[var0][var23 + var1][var24 + var2]) {
                           WorldMapType2.field519[var0][var23 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
               }

            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)V",
      garbageValue = "-70"
   )
   static final void method206(String var0, int var1) {
      PacketNode var2 = AbstractSoundSystem.method2350(ClientPacket.field2415, Client.field911.field1460);
      var2.packetBuffer.putByte(class95.getLength(var0) + 1);
      var2.packetBuffer.method3670(var1);
      var2.packetBuffer.putString(var0);
      Client.field911.method2135(var2);
   }
}
