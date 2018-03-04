import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("FriendManager")
public class FriendManager {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   final JagexLoginType field1234;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   public final class304 field1235;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   public final class298 field1233;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1505993811
   )
   int field1238;

   @ObfuscatedSignature(
      signature = "(Llt;)V"
   )
   FriendManager(JagexLoginType var1) {
      this.field1238 = 0;
      this.field1234 = var1;
      this.field1235 = new class304(var1);
      this.field1233 = new class298(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-209798031"
   )
   boolean method1701() {
      return this.field1238 == 2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1639637801"
   )
   final void method1703() {
      this.field1238 = 1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1351268420"
   )
   final void method1711(Buffer var1, int var2) {
      this.field1235.method5516(var1, var2);
      this.field1238 = 2;
      BoundingBox3DDrawMode.method62();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "974276823"
   )
   final void method1704() {
      for(class308 var1 = (class308)this.field1235.field3849.method4174(); var1 != null; var1 = (class308)this.field1235.field3849.method4180()) {
         if((long)var1.field3865 < PendingSpawn.currentTimeMs() / 1000L - 5L) {
            if(var1.field3864 > 0) {
               class19.sendGameMessage(5, "", var1.field3863 + " has logged in.");
            }

            if(var1.field3864 == 0) {
               class19.sendGameMessage(5, "", var1.field3863 + " has logged out.");
            }

            var1.method4183();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "86"
   )
   final void method1749() {
      this.field1238 = 0;
      this.field1235.method5409();
      this.field1233.method5409();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lko;ZI)Z",
      garbageValue = "-802765089"
   )
   @Export("isFriended")
   final boolean isFriended(Name var1, boolean var2) {
      return var1 == null?false:(var1.equals(TotalQuantityComparator.localPlayer.name)?true:this.field1235.method5519(var1, var2));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lko;B)Z",
      garbageValue = "46"
   )
   final boolean method1707(Name var1) {
      return var1 == null?false:this.field1233.isMember(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1942536742"
   )
   final void method1731(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1234);
         if(var2.method5533()) {
            if(this.method1715()) {
               MessageNode.method1111();
            } else if(TotalQuantityComparator.localPlayer.name.equals(var2)) {
               class1.method3();
            } else if(this.isFriended(var2, false)) {
               GroundObject.method2739(var1);
            } else if(this.method1707(var2)) {
               class243.method4617("Please remove " + var1 + " from your ignore list first");
            } else {
               GrandExchangeEvent.method91(var1);
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-20"
   )
   final boolean method1715() {
      return this.field1235.method5411() || this.field1235.getCount() >= 200 && Client.field968 != 1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "53"
   )
   final void method1710(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1234);
         if(var2.method5533()) {
            if(this.method1737()) {
               class243.method4617("Your ignore list is full. Max of 100 for free users, and 400 for members");
            } else if(TotalQuantityComparator.localPlayer.name.equals(var2)) {
               DynamicObject.method2059();
            } else if(this.method1707(var2)) {
               SceneTilePaint.method2930(var1);
            } else if(this.isFriended(var2, false)) {
               class3.method10(var1);
            } else {
               PacketNode var3 = class31.method285(ClientPacket.field2411, Client.field899.field1470);
               var3.packetBuffer.putByte(class29.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field899.method2082(var3);
            }
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1984811422"
   )
   final boolean method1737() {
      return this.field1233.method5411() || this.field1233.getCount() >= 100 && Client.field968 != 1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1057390498"
   )
   final void method1712(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1234);
         if(var2.method5533()) {
            if(this.field1235.method5416(var2)) {
               Size.method187();
               PacketNode var3 = class31.method285(ClientPacket.field2377, Client.field899.field1470);
               var3.packetBuffer.putByte(class29.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field899.method2082(var3);
            }

            BoundingBox3DDrawMode.method62();
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-661711740"
   )
   final void method1713(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1234);
         if(var2.method5533()) {
            if(this.field1233.method5416(var2)) {
               Size.method187();
               PacketNode var3 = class31.method285(ClientPacket.field2384, Client.field899.field1470);
               var3.packetBuffer.putByte(class29.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field899.method2082(var3);
            }

            class36.method502();
         }
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lko;B)Z",
      garbageValue = "-115"
   )
   final boolean method1717(Name var1) {
      Friend var2 = (Friend)this.field1235.method5452(var1);
      return var2 != null && var2.method5503();
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-74"
   )
   static final int method1722() {
      if(class55.preferences.hideRoofs) {
         return class36.plane;
      } else {
         int var0 = 3;
         if(GameCanvas.cameraPitch < 310) {
            int var1;
            int var2;
            if(Client.field927 == 1) {
               var1 = WorldMapType1.field443 >> 7;
               var2 = class171.field2218 >> 7;
            } else {
               var1 = TotalQuantityComparator.localPlayer.x >> 7;
               var2 = TotalQuantityComparator.localPlayer.y >> 7;
            }

            int var3 = Resampler.cameraX >> 7;
            int var4 = class31.cameraY >> 7;
            if(var3 < 0 || var4 < 0 || var3 >= 104 || var4 >= 104) {
               return class36.plane;
            }

            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class36.plane;
            }

            if((class62.tileSettings[class36.plane][var3][var4] & 4) != 0) {
               var0 = class36.plane;
            }

            int var5;
            if(var1 > var3) {
               var5 = var1 - var3;
            } else {
               var5 = var3 - var1;
            }

            int var6;
            if(var2 > var4) {
               var6 = var2 - var4;
            } else {
               var6 = var4 - var2;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = 32768;

               while(var3 != var1) {
                  if(var3 < var1) {
                     ++var3;
                  } else if(var3 > var1) {
                     --var3;
                  }

                  if((class62.tileSettings[class36.plane][var3][var4] & 4) != 0) {
                     var0 = class36.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var4 < var2) {
                        ++var4;
                     } else if(var4 > var2) {
                        --var4;
                     }

                     if((class62.tileSettings[class36.plane][var3][var4] & 4) != 0) {
                        var0 = class36.plane;
                     }
                  }
               }
            } else if(var6 > 0) {
               var7 = var5 * 65536 / var6;
               var8 = 32768;

               while(var2 != var4) {
                  if(var4 < var2) {
                     ++var4;
                  } else if(var4 > var2) {
                     --var4;
                  }

                  if((class62.tileSettings[class36.plane][var3][var4] & 4) != 0) {
                     var0 = class36.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var3 < var1) {
                        ++var3;
                     } else if(var3 > var1) {
                        --var3;
                     }

                     if((class62.tileSettings[class36.plane][var3][var4] & 4) != 0) {
                        var0 = class36.plane;
                     }
                  }
               }
            }
         }

         if(TotalQuantityComparator.localPlayer.x >= 0 && TotalQuantityComparator.localPlayer.y >= 0 && TotalQuantityComparator.localPlayer.x < 13312 && TotalQuantityComparator.localPlayer.y < 13312) {
            if((class62.tileSettings[class36.plane][TotalQuantityComparator.localPlayer.x >> 7][TotalQuantityComparator.localPlayer.y >> 7] & 4) != 0) {
               var0 = class36.plane;
            }

            return var0;
         } else {
            return class36.plane;
         }
      }
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(ZLgb;I)V",
      garbageValue = "818498915"
   )
   static final void method1768(boolean var0, PacketBuffer var1) {
      Client.field998 = 0;
      Client.pendingNpcFlagsCount = 0;
      OwnWorldComparator.method1192();
      class1.updateNpcs(var0, var1);

      int var2;
      int var3;
      for(var2 = 0; var2 < Client.pendingNpcFlagsCount; ++var2) {
         var3 = Client.pendingNpcFlagsIndices[var2];
         NPC var4 = Client.cachedNPCs[var3];
         int var5 = var1.readUnsignedByte();
         if((var5 & 4) != 0) {
            var4.interacting = var1.method3618();
            if(var4.interacting == 65535) {
               var4.interacting = -1;
            }
         }

         int var6;
         int var7;
         int var8;
         int var9;
         if((var5 & 8) != 0) {
            var6 = var1.method3610();
            int var10;
            int var11;
            int var12;
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var8 = var1.getUSmart();
                  if(var8 == 32767) {
                     var8 = var1.getUSmart();
                     var10 = var1.getUSmart();
                     var9 = var1.getUSmart();
                     var11 = var1.getUSmart();
                  } else if(var8 != 32766) {
                     var10 = var1.getUSmart();
                  } else {
                     var8 = -1;
                  }

                  var12 = var1.getUSmart();
                  var4.method1630(var8, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var7 = var1.readUnsignedByte();
            if(var7 > 0) {
               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var1.getUSmart();
                  var10 = var1.getUSmart();
                  if(var10 != 32767) {
                     var11 = var1.getUSmart();
                     var12 = var1.method3609();
                     int var13 = var10 > 0?var1.method3610():var12;
                     var4.method1631(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var4.method1632(var9);
                  }
               }
            }
         }

         if((var5 & 32) != 0) {
            var6 = var1.readUnsignedShortOb1();
            var7 = var1.readUnsignedShort();
            var8 = var4.x - (var6 - WorldMapType1.baseX - WorldMapType1.baseX) * 64;
            var9 = var4.y - (var7 - Enum.baseY - Enum.baseY) * 64;
            if(var8 != 0 || var9 != 0) {
               var4.field1142 = (int)(Math.atan2((double)var8, (double)var9) * 325.949D) & 2047;
            }
         }

         if((var5 & 1) != 0) {
            var4.composition = class255.getNpcDefinition(var1.method3618());
            var4.field1193 = var4.composition.field3709;
            var4.field1183 = var4.composition.field3722;
            var4.field1163 = var4.composition.field3731;
            var4.field1139 = var4.composition.field3728;
            var4.field1149 = var4.composition.field3717;
            var4.field1147 = var4.composition.field3734;
            var4.idlePoseAnimation = var4.composition.field3712;
            var4.field1145 = var4.composition.field3713;
            var4.field1148 = var4.composition.field3714;
         }

         if((var5 & 2) != 0) {
            var6 = var1.method3618();
            if(var6 == 65535) {
               var6 = -1;
            }

            var7 = var1.method3583();
            if(var6 == var4.animation && var6 != -1) {
               var8 = class270.getAnimation(var6).replyMode;
               if(var8 == 1) {
                  var4.actionFrame = 0;
                  var4.field1173 = 0;
                  var4.actionAnimationDisable = var7;
                  var4.field1175 = 0;
               }

               if(var8 == 2) {
                  var4.field1175 = 0;
               }
            } else if(var6 == -1 || var4.animation == -1 || class270.getAnimation(var6).forcedPriority >= class270.getAnimation(var4.animation).forcedPriority) {
               var4.animation = var6;
               var4.actionFrame = 0;
               var4.field1173 = 0;
               var4.actionAnimationDisable = var7;
               var4.field1175 = 0;
               var4.field1198 = var4.queueSize;
            }
         }

         if((var5 & 64) != 0) {
            var4.graphic = var1.method3620();
            var6 = var1.readInt();
            var4.field1157 = var6 >> 16;
            var4.graphicsDelay = (var6 & 65535) + Client.gameCycle;
            var4.field1177 = 0;
            var4.field1178 = 0;
            if(var4.graphicsDelay > Client.gameCycle) {
               var4.field1177 = -1;
            }

            if(var4.graphic == 65535) {
               var4.graphic = -1;
            }
         }

         if((var5 & 16) != 0) {
            var4.overhead = var1.readString();
            var4.overheadTextCyclesRemaining = 100;
         }
      }

      for(var2 = 0; var2 < Client.field998; ++var2) {
         var3 = Client.field972[var2];
         if(Client.cachedNPCs[var3].npcCycle != Client.gameCycle) {
            Client.cachedNPCs[var3].composition = null;
            Client.cachedNPCs[var3] = null;
         }
      }

      if(var1.offset != Client.field899.packetLength) {
         throw new RuntimeException(var1.offset + "," + Client.field899.packetLength);
      } else {
         for(var2 = 0; var2 < Client.npcIndexesCount; ++var2) {
            if(Client.cachedNPCs[Client.npcIndices[var2]] == null) {
               throw new RuntimeException(var2 + "," + Client.npcIndexesCount);
            }
         }

      }
   }
}
