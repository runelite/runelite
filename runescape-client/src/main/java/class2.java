import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class2 implements class0 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   static IndexDataBase field15;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static IndexedSprite field13;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "861386005"
   )
   public static void method6(int var0) {
      class210.field2598 = 1;
      class3.field22 = null;
      class8.field237 = -1;
      class210.field2599 = -1;
      class111.field1588 = 0;
      class20.field322 = false;
      class164.field2216 = var0;
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(ZLgv;B)V",
      garbageValue = "66"
   )
   static final void method4(boolean var0, PacketBuffer var1) {
      Client.field932 = 0;
      Client.pendingNpcFlagsCount = 0;
      GrandExchangeOffer.method118();
      class46.method705(var0, var1);

      int var2;
      int var3;
      for(var2 = 0; var2 < Client.pendingNpcFlagsCount; ++var2) {
         var3 = Client.pendingNpcFlagsIndices[var2];
         NPC var4 = Client.cachedNPCs[var3];
         int var5 = var1.readUnsignedByte();
         if((var5 & 1) != 0) {
            var4.composition = class1.getNpcDefinition(var1.readUnsignedShortOb1());
            var4.field1147 = var4.composition.field3619;
            var4.field1199 = var4.composition.field3613;
            var4.field1154 = var4.composition.field3641;
            var4.field1155 = var4.composition.field3617;
            var4.field1156 = var4.composition.field3640;
            var4.field1157 = var4.composition.field3628;
            var4.idlePoseAnimation = var4.composition.field3622;
            var4.field1152 = var4.composition.field3623;
            var4.field1153 = var4.composition.field3624;
         }

         int var6;
         if((var5 & 16) != 0) {
            var4.graphic = var1.method3333();
            var6 = var1.readInt();
            var4.field1187 = var6 >> 16;
            var4.graphicsDelay = (var6 & 65535) + Client.gameCycle;
            var4.field1184 = 0;
            var4.field1185 = 0;
            if(var4.graphicsDelay > Client.gameCycle) {
               var4.field1184 = -1;
            }

            if(var4.graphic == 65535) {
               var4.graphic = -1;
            }
         }

         int var7;
         int var8;
         if((var5 & 4) != 0) {
            var6 = var1.method3333();
            if(var6 == 65535) {
               var6 = -1;
            }

            var7 = var1.method3457();
            if(var6 == var4.animation && var6 != -1) {
               var8 = class13.getAnimation(var6).replyMode;
               if(var8 == 1) {
                  var4.actionFrame = 0;
                  var4.field1180 = 0;
                  var4.actionAnimationDisable = var7;
                  var4.field1182 = 0;
               }

               if(var8 == 2) {
                  var4.field1182 = 0;
               }
            } else if(var6 == -1 || var4.animation == -1 || class13.getAnimation(var6).forcedPriority >= class13.getAnimation(var4.animation).forcedPriority) {
               var4.animation = var6;
               var4.actionFrame = 0;
               var4.field1180 = 0;
               var4.actionAnimationDisable = var7;
               var4.field1182 = 0;
               var4.field1159 = var4.queueSize;
            }
         }

         int var9;
         if((var5 & 8) != 0) {
            var6 = var1.method3422();
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
                  var4.method1580(var8, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var7 = var1.method3422();
            if(var7 > 0) {
               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var1.getUSmart();
                  var10 = var1.getUSmart();
                  if(var10 != 32767) {
                     var11 = var1.getUSmart();
                     var12 = var1.readUnsignedByte();
                     int var13 = var10 > 0?var1.readUnsignedByte():var12;
                     var4.method1578(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var4.method1579(var9);
                  }
               }
            }
         }

         if((var5 & 2) != 0) {
            var6 = var1.readUnsignedShort();
            var7 = var1.readUnsignedShortOb1();
            var8 = var4.x - (var6 - IndexDataBase.baseX - IndexDataBase.baseX) * 64;
            var9 = var4.y - (var7 - Occluder.baseY - Occluder.baseY) * 64;
            if(var8 != 0 || var9 != 0) {
               var4.field1174 = (int)(Math.atan2((double)var8, (double)var9) * 325.949D) & 2047;
            }
         }

         if((var5 & 64) != 0) {
            var4.overhead = var1.readString();
            var4.field1177 = 100;
         }

         if((var5 & 32) != 0) {
            var4.interacting = var1.method3333();
            if(var4.interacting == 65535) {
               var4.interacting = -1;
            }
         }
      }

      for(var2 = 0; var2 < Client.field932; ++var2) {
         var3 = Client.field978[var2];
         if(Client.cachedNPCs[var3].field1195 != Client.gameCycle) {
            Client.cachedNPCs[var3].composition = null;
            Client.cachedNPCs[var3] = null;
         }
      }

      if(var1.offset != Client.field916.packetLength) {
         throw new RuntimeException(var1.offset + "," + Client.field916.packetLength);
      } else {
         for(var2 = 0; var2 < Client.npcIndexesCount; ++var2) {
            if(Client.cachedNPCs[Client.npcIndices[var2]] == null) {
               throw new RuntimeException(var2 + "," + Client.npcIndexesCount);
            }
         }

      }
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "1275462078"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = GraphicsObject.method1726(var0, class236.field3239);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(GraphicsObject.method1726(Client.friends[var3].name, class236.field3239)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(GraphicsObject.method1726(class181.localPlayer.name, class236.field3239))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
