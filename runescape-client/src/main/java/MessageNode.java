import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1469915221
   )
   static int field549;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 728143065
   )
   static int field545;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 752906733
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1104949363
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 730027175
   )
   @Export("type")
   int type;
   @ObfuscatedName("b")
   @Export("name")
   String name;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   Name field540;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   class289 field541;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   class289 field551;
   @ObfuscatedName("x")
   @Export("sender")
   String sender;
   @ObfuscatedName("j")
   @Export("value")
   String value;

   @Hook(
      value = "setMessage",
      end = true
   )
   MessageNode(int var1, String var2, String var3, String var4) {
      this.field541 = class289.field3652;
      this.field551 = class289.field3652;
      int var5 = ++class83.field1208 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1101();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1484040489"
   )
   @Export("setMessage")
   @Hook(
      value = "setMessage",
      end = true
   )
   void setMessage(int var1, String var2, String var3, String var4) {
      int var5 = ++class83.field1208 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1101();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "910932872"
   )
   void method1095() {
      this.field541 = class289.field3652;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-116601790"
   )
   final boolean method1096() {
      if(this.field541 == class289.field3652) {
         this.method1109();
      }

      return this.field541 == class289.field3651;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "295077887"
   )
   void method1109() {
      this.field541 = CacheFile.friendManager.friendContainer.isMember(this.field540)?class289.field3651:class289.field3650;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method1098() {
      this.field551 = class289.field3652;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "14"
   )
   final boolean method1099() {
      if(this.field551 == class289.field3652) {
         this.method1100();
      }

      return this.field551 == class289.field3651;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-98"
   )
   void method1100() {
      this.field551 = CacheFile.friendManager.ignoreContainer.isMember(this.field540)?class289.field3651:class289.field3650;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1378703733"
   )
   final void method1101() {
      if(this.name != null) {
         this.field540 = new Name(class9.method97(this.name), WorldMapDecoration.loginType);
      } else {
         this.field540 = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-22422"
   )
   static final void method1105() {
      short var0 = 256;
      int var1;
      if(class78.field1114 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class78.field1114 > 768) {
               class45.field376[var1] = WorldMapManager.method559(WorldComparator.field4[var1], class81.field1178[var1], 1024 - class78.field1114);
            } else if(class78.field1114 > 256) {
               class45.field376[var1] = class81.field1178[var1];
            } else {
               class45.field376[var1] = WorldMapManager.method559(class81.field1178[var1], WorldComparator.field4[var1], 256 - class78.field1114);
            }
         }
      } else if(class78.field1138 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class78.field1138 > 768) {
               class45.field376[var1] = WorldMapManager.method559(WorldComparator.field4[var1], DynamicObject.field1228[var1], 1024 - class78.field1138);
            } else if(class78.field1138 > 256) {
               class45.field376[var1] = DynamicObject.field1228[var1];
            } else {
               class45.field376[var1] = WorldMapManager.method559(DynamicObject.field1228[var1], WorldComparator.field4[var1], 256 - class78.field1138);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class45.field376[var1] = WorldComparator.field4[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class78.field1104, 9, class78.field1104 + 128, var0 + 7);
      class78.field1107.method5893(class78.field1104, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = class50.rasterProvider.width * 9 + class78.field1104;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class78.field1128[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class297.field3701[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class45.field376[var7];
               var10 = class50.rasterProvider.pixels[var2];
               class50.rasterProvider.pixels[var2++] = (var8 * (var7 & 65280) + var9 * (var10 & 65280) & 16711680) + ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class50.rasterProvider.width - 128;
      }

      Rasterizer2D.setDrawRegion(class78.field1104 + 765 - 128, 9, class78.field1104 + 765, var0 + 7);
      class24.field224.method5893(class78.field1104 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = class50.rasterProvider.width * 9 + class78.field1104 + 637 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class78.field1128[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class297.field3701[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class45.field376[var7];
               var10 = class50.rasterProvider.pixels[var2];
               class50.rasterProvider.pixels[var2++] = (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class50.rasterProvider.width - var5 - var4;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcs;ZS)I",
      garbageValue = "-11807"
   )
   static int method1118(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3200) {
         class45.intStackSize -= 3;
         var3 = class69.intStack[class45.intStackSize];
         int var4 = class69.intStack[class45.intStackSize + 1];
         int var5 = class69.intStack[class45.intStackSize + 2];
         if(Client.field768 != 0 && var4 != 0 && Client.queuedSoundEffectCount < 50) {
            Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var3;
            Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var4;
            Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var5;
            Client.audioEffects[Client.queuedSoundEffectCount] = null;
            Client.soundLocations[Client.queuedSoundEffectCount] = 0;
            ++Client.queuedSoundEffectCount;
         }

         return 1;
      } else if(var0 != 3201) {
         if(var0 == 3202) {
            class45.intStackSize -= 2;
            FloorUnderlayDefinition.method4879(class69.intStack[class45.intStackSize], class69.intStack[class45.intStackSize + 1]);
            return 1;
         } else {
            return 2;
         }
      } else {
         var3 = class69.intStack[--class45.intStackSize];
         if(var3 == -1 && !Client.field825) {
            class37.method721();
         } else if(var3 != -1 && var3 != Client.field824 && Client.field693 != 0 && !Client.field825) {
            ClientPacket.method3459(2, MouseInput.indexTrack1, var3, 0, Client.field693, false);
         }

         Client.field824 = var3;
         return 1;
      }
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "1845437737"
   )
   static final void method1117(class171 var0) {
      PacketBuffer var1 = Client.field739.packetBuffer;
      int var3;
      int var5;
      int var6;
      Item var7;
      int var37;
      int var38;
      if(class171.field2267 == var0) {
         var37 = var1.readUnsignedShort();
         var3 = var1.readUnsignedShortOb1();
         var38 = (var3 >> 4 & 7) + field545;
         var5 = (var3 & 7) + Script.field1219;
         var6 = var1.readUnsignedShort();
         if(var38 >= 0 && var5 >= 0 && var38 < 104 && var5 < 104) {
            var7 = new Item();
            var7.id = var37;
            var7.quantity = var6;
            if(Client.groundItemDeque[class192.plane][var38][var5] == null) {
               Client.groundItemDeque[class192.plane][var38][var5] = new Deque();
            }

            Client.groundItemDeque[class192.plane][var38][var5].addFront(var7);
            class171.groundItemSpawned(var38, var5);
         }

      } else {
         byte var2;
         int var8;
         int var9;
         int var11;
         int var13;
         int var14;
         int var31;
         if(class171.field2274 == var0) {
            var2 = var1.method3702();
            var3 = var1.readUnsignedShort();
            byte var4 = var1.readByte();
            var5 = var1.method3553();
            var6 = (var5 >> 4 & 7) + field545;
            var31 = (var5 & 7) + Script.field1219;
            var8 = var1.method3784();
            var9 = var1.method3562();
            byte var10 = var1.method3765();
            var11 = var1.readUnsignedShort();
            byte var12 = var1.method3600();
            var13 = var1.readUnsignedByte();
            var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = Client.field653[var14];
            Player var17;
            if(var9 == Client.localInteractingIndex) {
               var17 = MilliTimer.localPlayer;
            } else {
               var17 = Client.cachedPlayers[var9];
            }

            if(var17 != null) {
               ObjectComposition var18 = SoundTaskDataProvider.getObjectDefinition(var8);
               int var19;
               int var20;
               if(var15 != 1 && var15 != 3) {
                  var19 = var18.width;
                  var20 = var18.length;
               } else {
                  var19 = var18.length;
                  var20 = var18.width;
               }

               int var21 = var6 + (var19 >> 1);
               int var22 = var6 + (var19 + 1 >> 1);
               int var23 = var31 + (var20 >> 1);
               int var24 = var31 + (var20 + 1 >> 1);
               int[][] var25 = class50.tileHeights[class192.plane];
               int var26 = var25[var21][var23] + var25[var22][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
               int var27 = (var6 << 7) + (var19 << 6);
               int var28 = (var31 << 7) + (var20 << 6);
               Model var29 = var18.method5052(var14, var15, var25, var27, var26, var28);
               if(var29 != null) {
                  class222.method4447(class192.plane, var6, var31, var16, -1, 0, 0, var11 + 1, var3 + 1);
                  var17.animationCycleStart = var11 + Client.gameCycle;
                  var17.animationCycleEnd = var3 + Client.gameCycle;
                  var17.model = var29;
                  var17.field571 = var6 * 128 + var19 * 64;
                  var17.field582 = var31 * 128 + var20 * 64;
                  var17.field562 = var26;
                  byte var30;
                  if(var10 > var12) {
                     var30 = var10;
                     var10 = var12;
                     var12 = var30;
                  }

                  if(var2 > var4) {
                     var30 = var2;
                     var2 = var4;
                     var4 = var30;
                  }

                  var17.field568 = var10 + var6;
                  var17.field577 = var12 + var6;
                  var17.field573 = var31 + var2;
                  var17.field578 = var31 + var4;
               }
            }
         }

         if(class171.field2269 == var0) {
            var37 = var1.readUnsignedByte();
            var3 = (var37 >> 4 & 7) + field545;
            var38 = (var37 & 7) + Script.field1219;
            var5 = var1.method3553();
            var6 = var5 >> 2;
            var31 = var5 & 3;
            var8 = Client.field653[var6];
            if(var3 >= 0 && var38 >= 0 && var3 < 104 && var38 < 104) {
               class222.method4447(class192.plane, var3, var38, var8, -1, var6, var31, 0, -1);
            }

         } else if(class171.field2272 == var0) {
            var37 = var1.method3784();
            var3 = var1.method3597();
            var38 = (var3 >> 4 & 7) + field545;
            var5 = (var3 & 7) + Script.field1219;
            if(var38 >= 0 && var5 >= 0 && var38 < 104 && var5 < 104) {
               Deque var32 = Client.groundItemDeque[class192.plane][var38][var5];
               if(var32 != null) {
                  for(var7 = (Item)var32.getFront(); var7 != null; var7 = (Item)var32.getNext()) {
                     if((var37 & 32767) == var7.id) {
                        var7.unlink();
                        break;
                     }
                  }

                  if(var32.getFront() == null) {
                     Client.groundItemDeque[class192.plane][var38][var5] = null;
                  }

                  class171.groundItemSpawned(var38, var5);
               }
            }

         } else {
            int var39;
            if(class171.field2276 == var0) {
               var37 = var1.method3597();
               var3 = var1.method3597();
               var38 = var3 >> 4 & 15;
               var5 = var3 & 7;
               var6 = var1.readUnsignedShort();
               var31 = var1.method3553();
               var8 = (var31 >> 4 & 7) + field545;
               var9 = (var31 & 7) + Script.field1219;
               if(var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
                  var39 = var38 + 1;
                  if(MilliTimer.localPlayer.pathX[0] >= var8 - var39 && MilliTimer.localPlayer.pathX[0] <= var8 + var39 && MilliTimer.localPlayer.pathY[0] >= var9 - var39 && MilliTimer.localPlayer.pathY[0] <= var39 + var9 && Client.field827 != 0 && var5 > 0 && Client.queuedSoundEffectCount < 50) {
                     Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var6;
                     Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var5;
                     Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var37;
                     Client.audioEffects[Client.queuedSoundEffectCount] = null;
                     Client.soundLocations[Client.queuedSoundEffectCount] = var38 + (var9 << 8) + (var8 << 16);
                     ++Client.queuedSoundEffectCount;
                  }
               }
            }

            if(class171.field2271 == var0) {
               var2 = var1.method3765();
               var3 = var1.readUnsignedByte();
               var38 = var1.method3609();
               var5 = var1.method3676();
               var6 = var1.readUnsignedByte() * 4;
               var31 = var1.method3676();
               var8 = var1.method3553() * 4;
               var9 = var1.method3597();
               var39 = (var9 >> 4 & 7) + field545;
               var11 = (var9 & 7) + Script.field1219;
               int var40 = var1.method3553();
               byte var41 = var1.method3765();
               var14 = var1.readUnsignedShort();
               var13 = var41 + var39;
               var37 = var2 + var11;
               if(var39 >= 0 && var11 >= 0 && var39 < 104 && var11 < 104 && var13 >= 0 && var37 >= 0 && var13 < 104 && var37 < 104 && var14 != 65535) {
                  var39 = var39 * 128 + 64;
                  var11 = var11 * 128 + 64;
                  var13 = var13 * 128 + 64;
                  var37 = var37 * 128 + 64;
                  Projectile var33 = new Projectile(var14, class192.plane, var39, var11, class264.getTileHeight(var39, var11, class192.plane) - var8, var31 + Client.gameCycle, var5 + Client.gameCycle, var40, var3, var38, var6);
                  var33.moveProjectile(var13, var37, class264.getTileHeight(var13, var37, class192.plane) - var6, var31 + Client.gameCycle);
                  Client.projectiles.addFront(var33);
               }

            } else if(class171.field2275 == var0) {
               var37 = var1.readUnsignedByte();
               var3 = (var37 >> 4 & 7) + field545;
               var38 = (var37 & 7) + Script.field1219;
               var5 = var1.readUnsignedShort();
               var6 = var1.method3553();
               var31 = var6 >> 2;
               var8 = var6 & 3;
               var9 = Client.field653[var31];
               if(var3 >= 0 && var38 >= 0 && var3 < 104 && var38 < 104) {
                  class222.method4447(class192.plane, var3, var38, var9, var5, var31, var8, 0, -1);
               }

            } else if(class171.field2270 == var0) {
               var37 = var1.readUnsignedShortOb1();
               var3 = (var37 >> 4 & 7) + field545;
               var38 = (var37 & 7) + Script.field1219;
               var5 = var1.method3784();
               var6 = var1.readUnsignedShortOb1();
               var31 = var6 >> 2;
               var8 = var6 & 3;
               var9 = Client.field653[var31];
               if(var3 >= 0 && var38 >= 0 && var3 < 103 && var38 < 103) {
                  if(var9 == 0) {
                     WallObject var34 = ScriptEvent.region.method3049(class192.plane, var3, var38);
                     if(var34 != null) {
                        var11 = class8.method93(var34.hash);
                        if(var31 == 2) {
                           var34.renderable1 = new DynamicObject(var11, 2, var8 + 4, class192.plane, var3, var38, var5, false, var34.renderable1);
                           var34.renderable2 = new DynamicObject(var11, 2, var8 + 1 & 3, class192.plane, var3, var38, var5, false, var34.renderable2);
                        } else {
                           var34.renderable1 = new DynamicObject(var11, var31, var8, class192.plane, var3, var38, var5, false, var34.renderable1);
                        }
                     }
                  }

                  if(var9 == 1) {
                     DecorativeObject var42 = ScriptEvent.region.method2924(class192.plane, var3, var38);
                     if(var42 != null) {
                        var11 = class8.method93(var42.hash);
                        if(var31 != 4 && var31 != 5) {
                           if(var31 == 6) {
                              var42.renderable1 = new DynamicObject(var11, 4, var8 + 4, class192.plane, var3, var38, var5, false, var42.renderable1);
                           } else if(var31 == 7) {
                              var42.renderable1 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, class192.plane, var3, var38, var5, false, var42.renderable1);
                           } else if(var31 == 8) {
                              var42.renderable1 = new DynamicObject(var11, 4, var8 + 4, class192.plane, var3, var38, var5, false, var42.renderable1);
                              var42.renderable2 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, class192.plane, var3, var38, var5, false, var42.renderable2);
                           }
                        } else {
                           var42.renderable1 = new DynamicObject(var11, 4, var8, class192.plane, var3, var38, var5, false, var42.renderable1);
                        }
                     }
                  }

                  if(var9 == 2) {
                     GameObject var43 = ScriptEvent.region.method2925(class192.plane, var3, var38);
                     if(var31 == 11) {
                        var31 = 10;
                     }

                     if(var43 != null) {
                        var43.renderable = new DynamicObject(class8.method93(var43.hash), var31, var8, class192.plane, var3, var38, var5, false, var43.renderable);
                     }
                  }

                  if(var9 == 3) {
                     GroundObject var44 = ScriptEvent.region.getFloorDecoration(class192.plane, var3, var38);
                     if(var44 != null) {
                        var44.renderable = new DynamicObject(class8.method93(var44.hash), 22, var8, class192.plane, var3, var38, var5, false, var44.renderable);
                     }
                  }
               }

            } else if(class171.field2268 == var0) {
               var37 = var1.method3597();
               var3 = (var37 >> 4 & 7) + field545;
               var38 = (var37 & 7) + Script.field1219;
               var5 = var1.method3676();
               var6 = var1.readUnsignedShort();
               var31 = var1.readUnsignedShortOb1();
               if(var3 >= 0 && var38 >= 0 && var3 < 104 && var38 < 104) {
                  var3 = var3 * 128 + 64;
                  var38 = var38 * 128 + 64;
                  GraphicsObject var45 = new GraphicsObject(var5, class192.plane, var3, var38, class264.getTileHeight(var3, var38, class192.plane) - var31, var6, Client.gameCycle);
                  Client.graphicsObjectDeque.addFront(var45);
               }

            } else if(class171.field2273 == var0) {
               var37 = var1.method3784();
               var3 = var1.method3562();
               var38 = var1.readUnsignedByte();
               var5 = (var38 >> 4 & 7) + field545;
               var6 = (var38 & 7) + Script.field1219;
               var31 = var1.readUnsignedShort();
               if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                  Deque var35 = Client.groundItemDeque[class192.plane][var5][var6];
                  if(var35 != null) {
                     for(Item var36 = (Item)var35.getFront(); var36 != null; var36 = (Item)var35.getNext()) {
                        if((var3 & 32767) == var36.id && var31 == var36.quantity) {
                           var36.quantity = var37;
                           break;
                        }
                     }

                     class171.groundItemSpawned(var5, var6);
                  }
               }

            }
         }
      }
   }
}
