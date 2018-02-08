import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class39 {
   @ObfuscatedName("n")
   @Export("osName")
   static String osName;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -501456673
   )
   public final int field514;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   public final Coordinates field509;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   public final Coordinates field504;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1263533095
   )
   final int field503;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 943683257
   )
   final int field505;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   final class33 field511;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1697407025
   )
   int field506;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -341979863
   )
   int field507;

   @ObfuscatedSignature(
      signature = "(ILhv;Lhv;Lax;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field514 = var1;
      this.field504 = var2;
      this.field509 = var3;
      this.field511 = var4;
      Area var5 = Area.mapAreaType[this.field514];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field503 = var6.width;
         this.field505 = var6.height;
      } else {
         this.field503 = 0;
         this.field505 = 0;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1763503489"
   )
   boolean method519(int var1, int var2) {
      return this.method520(var1, var2)?true:this.method521(var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "0"
   )
   boolean method520(int var1, int var2) {
      Area var3 = Area.mapAreaType[this.field514];
      switch(var3.field3384.field3621) {
      case 0:
         if(var1 >= this.field506 - this.field503 / 2 && var1 <= this.field503 / 2 + this.field506) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field506 && var1 < this.field506 + this.field503) {
            break;
         }

         return false;
      case 2:
         if(var1 <= this.field506 - this.field503 || var1 > this.field506) {
            return false;
         }
      }

      switch(var3.field3375.field3362) {
      case 0:
         if(var2 >= this.field507 - this.field505 / 2 && var2 <= this.field505 / 2 + this.field507) {
            break;
         }

         return false;
      case 1:
         if(var2 <= this.field507 - this.field505 || var2 > this.field507) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field507 || var2 >= this.field507 + this.field505) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-123"
   )
   boolean method521(int var1, int var2) {
      return this.field511 == null?false:(var1 >= this.field506 - this.field511.field442 / 2 && var1 <= this.field511.field442 / 2 + this.field506?var2 >= this.field507 && var2 <= this.field511.field443 + this.field507:false);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIIILec;Lfb;I)V",
      garbageValue = "1311559535"
   )
   static final void method527(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = class219.getObjectDefinition(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.width;
         var11 = var9.length;
      } else {
         var10 = var9.length;
         var11 = var9.width;
      }

      int var12;
      int var13;
      if(var10 + var2 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = var2 + (var10 + 1 >> 1);
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var3 + var11 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = var3 + (var11 + 1 >> 1);
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class62.tileHeights[var1];
      int var17 = var16[var13][var15] + var16[var12][var14] + var16[var13][var14] + var16[var12][var15] >> 2;
      int var18 = (var2 << 7) + (var10 << 6);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
      if(var9.int1 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.supportItems == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4922(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new DynamicObject(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var22, var20, var21);
         if(var9.clipType == 1) {
            var8.method3352(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4922(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2914(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.clipType != 0) {
               var8.addObject(var2, var3, var10, var11, var9.blocksProjectile);
            }

         } else if(var6 == 0) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4922(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class62.field729[var5], 0, var20, var21);
            if(var9.clipType != 0) {
               var8.method3380(var2, var3, var6, var5, var9.blocksProjectile);
            }

         } else if(var6 == 1) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4922(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class62.field728[var5], 0, var20, var21);
            if(var9.clipType != 0) {
               var8.method3380(var2, var3, var6, var5, var9.blocksProjectile);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = var5 + 1 & 3;
               Object var23;
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var23 = var9.method4922(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method4922(2, var27, var16, var18, var17, var19);
               } else {
                  var23 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  var24 = new DynamicObject(var4, 2, var27, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var23, (Renderable)var24, class62.field729[var5], class62.field729[var27], var20, var21);
               if(var9.clipType != 0) {
                  var8.method3380(var2, var3, var6, var5, var9.blocksProjectile);
               }

            } else if(var6 == 3) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4922(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class62.field728[var5], 0, var20, var21);
               if(var9.clipType != 0) {
                  var8.method3380(var2, var3, var6, var5, var9.blocksProjectile);
               }

            } else if(var6 == 9) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4922(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2914(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.clipType != 0) {
                  var8.addObject(var2, var3, var10, var11, var9.blocksProjectile);
               }

            } else if(var6 == 4) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4922(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class62.field729[var5], 0, 0, 0, var20, var21);
            } else {
               int var28;
               if(var6 == 5) {
                  var27 = 16;
                  var28 = var7.method2930(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = class219.getObjectDefinition(var28 >> 14 & 32767).decorDisplacement;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4922(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class62.field729[var5], 0, var27 * class62.field731[var5], var27 * class62.field732[var5], var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var28 = var7.method2930(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = class219.getObjectDefinition(var28 >> 14 & 32767).decorDisplacement / 2;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4922(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var27 * class62.field738[var5], var27 * class62.field733[var5], var20, var21);
               } else if(var6 == 7) {
                  var28 = var5 + 2 & 3;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var22 = var9.method4922(4, var28 + 4, var16, var18, var17, var19);
                  } else {
                     var22 = new DynamicObject(var4, 4, var28 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var28, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var28 = var7.method2930(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = class219.getObjectDefinition(var28 >> 14 & 32767).decorDisplacement / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4922(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method4922(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                     var25 = new DynamicObject(var4, 4, var26 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var27 * class62.field738[var5], var27 * class62.field733[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4922(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new DynamicObject(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         if(var22 != null) {
            var7.method2914(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.clipType != 0) {
            var8.addObject(var2, var3, var10, var11, var9.blocksProjectile);
         }

      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "522352742"
   )
   static final void method523(String var0, int var1) {
      PacketNode var2 = Script.method2025(ClientPacket.field2319, Client.field937.field1454);
      var2.packetBuffer.putByte(FrameMap.getLength(var0) + 1);
      var2.packetBuffer.method3535(var1);
      var2.packetBuffer.putString(var0);
      Client.field937.method2044(var2);
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(Lfq;S)V",
      garbageValue = "-6871"
   )
   static final void method528(class173 var0) {
      PacketBuffer var1 = Client.field937.packetBuffer;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var37;
      if(class173.field2428 == var0) {
         var37 = var1.readUnsignedByteNegate();
         var3 = var1.method3506();
         var4 = var3 >> 2;
         var5 = var3 & 3;
         var6 = Client.field898[var4];
         var7 = var1.method3536();
         var8 = (var7 >> 4 & 7) + WorldMapType3.field371;
         var9 = (var7 & 7) + class153.field2114;
         if(var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
            GraphicsObject.method1837(class60.plane, var8, var9, var6, var37, var4, var5, 0, -1);
         }

      } else {
         int var10;
         int var12;
         byte var14;
         if(class173.field2434 == var0) {
            byte var2 = var1.method3540();
            var3 = var1.method3538();
            var4 = (var3 >> 4 & 7) + WorldMapType3.field371;
            var5 = (var3 & 7) + class153.field2114;
            var6 = var1.readUnsignedByte();
            var7 = var6 >> 2;
            var8 = var6 & 3;
            var9 = Client.field898[var7];
            var10 = var1.method3547();
            byte var11 = var1.method3540();
            var12 = var1.readUnsignedByteNegate();
            byte var13 = var1.method3539();
            var14 = var1.method3540();
            int var15 = var1.readUnsignedShort();
            int var16 = var1.method3547();
            Player var17;
            if(var16 == Client.localInteractingIndex) {
               var17 = GroundObject.localPlayer;
            } else {
               var17 = Client.cachedPlayers[var16];
            }

            if(var17 != null) {
               ObjectComposition var18 = class219.getObjectDefinition(var15);
               int var19;
               int var20;
               if(var8 != 1 && var8 != 3) {
                  var19 = var18.width;
                  var20 = var18.length;
               } else {
                  var19 = var18.length;
                  var20 = var18.width;
               }

               int var21 = var4 + (var19 >> 1);
               int var22 = var4 + (var19 + 1 >> 1);
               int var23 = var5 + (var20 >> 1);
               int var24 = var5 + (var20 + 1 >> 1);
               int[][] var25 = class62.tileHeights[class60.plane];
               int var26 = var25[var21][var24] + var25[var21][var23] + var25[var22][var23] + var25[var22][var24] >> 2;
               int var27 = (var4 << 7) + (var19 << 6);
               int var28 = (var5 << 7) + (var20 << 6);
               Model var29 = var18.method4922(var7, var8, var25, var27, var26, var28);
               if(var29 != null) {
                  GraphicsObject.method1837(class60.plane, var4, var5, var9, -1, 0, 0, var10 + 1, var12 + 1);
                  var17.animationCycleStart = var10 + Client.gameCycle;
                  var17.animationCycleEnd = var12 + Client.gameCycle;
                  var17.model = var29;
                  var17.field816 = var4 * 128 + var19 * 64;
                  var17.field807 = var5 * 128 + var20 * 64;
                  var17.field817 = var26;
                  byte var30;
                  if(var2 > var14) {
                     var30 = var2;
                     var2 = var14;
                     var14 = var30;
                  }

                  if(var11 > var13) {
                     var30 = var11;
                     var11 = var13;
                     var13 = var30;
                  }

                  var17.field820 = var4 + var2;
                  var17.field815 = var14 + var4;
                  var17.field821 = var5 + var11;
                  var17.field812 = var13 + var5;
               }
            }
         }

         if(class173.field2433 == var0) {
            var37 = var1.method3506();
            var3 = (var37 >> 4 & 7) + WorldMapType3.field371;
            var4 = (var37 & 7) + class153.field2114;
            var5 = var1.readUnsignedShort();
            var6 = var1.method3547();
            var7 = var1.method3538();
            if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
               var3 = var3 * 128 + 64;
               var4 = var4 * 128 + 64;
               GraphicsObject var42 = new GraphicsObject(var5, class60.plane, var3, var4, MessageNode.getTileHeight(var3, var4, class60.plane) - var7, var6, Client.gameCycle);
               Client.graphicsObjectDeque.addFront(var42);
            }

         } else {
            int var39;
            if(class173.field2425 == var0) {
               var37 = var1.method3547();
               var3 = var1.method3506() * 4;
               var4 = var1.method3538();
               var5 = (var4 >> 4 & 7) + WorldMapType3.field371;
               var6 = (var4 & 7) + class153.field2114;
               byte var38 = var1.readByte();
               var8 = var1.method3536();
               var9 = var1.method3550();
               var10 = var1.method3506();
               var39 = var1.method3506() * 4;
               var12 = var1.readUnsignedShortOb1();
               int var40 = var1.method3547();
               var14 = var1.method3540();
               int var41 = var14 + var5;
               var7 = var38 + var6;
               if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104 && var41 >= 0 && var7 >= 0 && var41 < 104 && var7 < 104 && var40 != 65535) {
                  var5 = var5 * 128 + 64;
                  var6 = var6 * 128 + 64;
                  var41 = var41 * 128 + 64;
                  var7 = var7 * 128 + 64;
                  Projectile var32 = new Projectile(var40, class60.plane, var5, var6, MessageNode.getTileHeight(var5, var6, class60.plane) - var39, var12 + Client.gameCycle, var37 + Client.gameCycle, var8, var10, var9, var3);
                  var32.moveProjectile(var41, var7, MessageNode.getTileHeight(var41, var7, class60.plane) - var3, var12 + Client.gameCycle);
                  Client.projectiles.addFront(var32);
               }

            } else {
               if(class173.field2430 == var0) {
                  var37 = var1.method3547();
                  var3 = var1.method3538();
                  var4 = var1.method3506();
                  var5 = (var4 >> 4 & 7) + WorldMapType3.field371;
                  var6 = (var4 & 7) + class153.field2114;
                  var7 = var1.method3536();
                  var8 = var7 >> 4 & 15;
                  var9 = var7 & 7;
                  if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                     var10 = var8 + 1;
                     if(GroundObject.localPlayer.pathX[0] >= var5 - var10 && GroundObject.localPlayer.pathX[0] <= var10 + var5 && GroundObject.localPlayer.pathY[0] >= var6 - var10 && GroundObject.localPlayer.pathY[0] <= var6 + var10 && Client.field878 != 0 && var9 > 0 && Client.queuedSoundEffectCount < 50) {
                        Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var37;
                        Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var9;
                        Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var3;
                        Client.audioEffects[Client.queuedSoundEffectCount] = null;
                        Client.soundLocations[Client.queuedSoundEffectCount] = var8 + (var6 << 8) + (var5 << 16);
                        ++Client.queuedSoundEffectCount;
                     }
                  }
               }

               if(class173.field2426 == var0) {
                  var37 = var1.readUnsignedShortOb1();
                  var3 = var1.method3536();
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = Client.field898[var4];
                  var7 = var1.readUnsignedByte();
                  var8 = (var7 >> 4 & 7) + WorldMapType3.field371;
                  var9 = (var7 & 7) + class153.field2114;
                  if(var8 >= 0 && var9 >= 0 && var8 < 103 && var9 < 103) {
                     if(var6 == 0) {
                        WallObject var33 = TotalQuantityComparator.region.method2926(class60.plane, var8, var9);
                        if(var33 != null) {
                           var39 = var33.hash >> 14 & 32767;
                           if(var4 == 2) {
                              var33.renderable1 = new DynamicObject(var39, 2, var5 + 4, class60.plane, var8, var9, var37, false, var33.renderable1);
                              var33.renderable2 = new DynamicObject(var39, 2, var5 + 1 & 3, class60.plane, var8, var9, var37, false, var33.renderable2);
                           } else {
                              var33.renderable1 = new DynamicObject(var39, var4, var5, class60.plane, var8, var9, var37, false, var33.renderable1);
                           }
                        }
                     }

                     if(var6 == 1) {
                        DecorativeObject var43 = TotalQuantityComparator.region.method2927(class60.plane, var8, var9);
                        if(var43 != null) {
                           var39 = var43.hash >> 14 & 32767;
                           if(var4 != 4 && var4 != 5) {
                              if(var4 == 6) {
                                 var43.renderable1 = new DynamicObject(var39, 4, var5 + 4, class60.plane, var8, var9, var37, false, var43.renderable1);
                              } else if(var4 == 7) {
                                 var43.renderable1 = new DynamicObject(var39, 4, (var5 + 2 & 3) + 4, class60.plane, var8, var9, var37, false, var43.renderable1);
                              } else if(var4 == 8) {
                                 var43.renderable1 = new DynamicObject(var39, 4, var5 + 4, class60.plane, var8, var9, var37, false, var43.renderable1);
                                 var43.renderable2 = new DynamicObject(var39, 4, (var5 + 2 & 3) + 4, class60.plane, var8, var9, var37, false, var43.renderable2);
                              }
                           } else {
                              var43.renderable1 = new DynamicObject(var39, 4, var5, class60.plane, var8, var9, var37, false, var43.renderable1);
                           }
                        }
                     }

                     if(var6 == 2) {
                        GameObject var44 = TotalQuantityComparator.region.method2904(class60.plane, var8, var9);
                        if(var4 == 11) {
                           var4 = 10;
                        }

                        if(var44 != null) {
                           var44.renderable = new DynamicObject(var44.hash >> 14 & 32767, var4, var5, class60.plane, var8, var9, var37, false, var44.renderable);
                        }
                     }

                     if(var6 == 3) {
                        GroundObject var45 = TotalQuantityComparator.region.getFloorDecoration(class60.plane, var8, var9);
                        if(var45 != null) {
                           var45.renderable = new DynamicObject(var45.hash >> 14 & 32767, 22, var5, class60.plane, var8, var9, var37, false, var45.renderable);
                        }
                     }
                  }

               } else if(class173.field2431 == var0) {
                  var37 = var1.method3536();
                  var3 = (var37 >> 4 & 7) + WorldMapType3.field371;
                  var4 = (var37 & 7) + class153.field2114;
                  var5 = var1.readUnsignedByte();
                  var6 = var5 >> 2;
                  var7 = var5 & 3;
                  var8 = Client.field898[var6];
                  if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                     GraphicsObject.method1837(class60.plane, var3, var4, var8, -1, var6, var7, 0, -1);
                  }

               } else {
                  Item var35;
                  if(class173.field2432 == var0) {
                     var37 = var1.method3547();
                     var3 = var1.readUnsignedByte();
                     var4 = (var3 >> 4 & 7) + WorldMapType3.field371;
                     var5 = (var3 & 7) + class153.field2114;
                     if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                        Deque var34 = Client.groundItemDeque[class60.plane][var4][var5];
                        if(var34 != null) {
                           for(var35 = (Item)var34.getFront(); var35 != null; var35 = (Item)var34.getNext()) {
                              if((var37 & 32767) == var35.id) {
                                 var35.unlink();
                                 break;
                              }
                           }

                           if(var34.getFront() == null) {
                              Client.groundItemDeque[class60.plane][var4][var5] = null;
                           }

                           TotalQuantityComparator.groundItemSpawned(var4, var5);
                        }
                     }

                  } else if(class173.field2429 == var0) {
                     var37 = var1.readUnsignedByteNegate();
                     var3 = var1.method3538();
                     var4 = (var3 >> 4 & 7) + WorldMapType3.field371;
                     var5 = (var3 & 7) + class153.field2114;
                     var6 = var1.readUnsignedByteNegate();
                     if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                        var35 = new Item();
                        var35.id = var37;
                        var35.quantity = var6;
                        if(Client.groundItemDeque[class60.plane][var4][var5] == null) {
                           Client.groundItemDeque[class60.plane][var4][var5] = new Deque();
                        }

                        Client.groundItemDeque[class60.plane][var4][var5].addFront(var35);
                        TotalQuantityComparator.groundItemSpawned(var4, var5);
                     }

                  } else if(class173.field2427 == var0) {
                     var37 = var1.method3547();
                     var3 = var1.method3536();
                     var4 = (var3 >> 4 & 7) + WorldMapType3.field371;
                     var5 = (var3 & 7) + class153.field2114;
                     var6 = var1.readUnsignedShort();
                     var7 = var1.readUnsignedShort();
                     if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                        Deque var31 = Client.groundItemDeque[class60.plane][var4][var5];
                        if(var31 != null) {
                           for(Item var36 = (Item)var31.getFront(); var36 != null; var36 = (Item)var31.getNext()) {
                              if((var7 & 32767) == var36.id && var6 == var36.quantity) {
                                 var36.quantity = var37;
                                 break;
                              }
                           }

                           TotalQuantityComparator.groundItemSpawned(var4, var5);
                        }
                     }

                  }
               }
            }
         }
      }
   }
}
