import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
public final class class270 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 103337941
   )
   static int field3685;

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1449217304"
   )
   static final void method4974(boolean var0) {
      Client.field1036 = 0;
      Client.pendingNpcFlagsCount = 0;
      class37.method493();
      class23.method164(var0);

      int var1;
      int var2;
      for(var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
         var2 = Client.pendingNpcFlagsIndices[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = Client.secretPacketBuffer2.readUnsignedByte();
         int var5;
         if((var4 & 4) != 0) {
            var3.graphic = Client.secretPacketBuffer2.method3299();
            var5 = Client.secretPacketBuffer2.method3326();
            var3.field1214 = var5 >> 16;
            var3.graphicsDelay = (var5 & '\uffff') + Client.gameCycle;
            var3.field1249 = 0;
            var3.field1246 = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.field1249 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 1) != 0) {
            var3.composition = class72.getNpcDefinition(Client.secretPacketBuffer2.method3274());
            var3.field1211 = var3.composition.field3559;
            var3.field1265 = var3.composition.field3582;
            var3.field1215 = var3.composition.field3565;
            var3.field1260 = var3.composition.field3581;
            var3.field1217 = var3.composition.field3567;
            var3.field1218 = var3.composition.field3568;
            var3.idlePoseAnimation = var3.composition.field3557;
            var3.field1266 = var3.composition.field3566;
            var3.field1213 = var3.composition.field3564;
         }

         int var6;
         int var7;
         if((var4 & 8) != 0) {
            var5 = Client.secretPacketBuffer2.readUnsignedShort();
            if(var5 == '\uffff') {
               var5 = -1;
            }

            var6 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            if(var5 == var3.animation && var5 != -1) {
               var7 = class204.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field1207 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1243 = 0;
               }

               if(var7 == 2) {
                  var3.field1243 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || class204.getAnimation(var5).forcedPriority >= class204.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field1207 = 0;
               var3.actionAnimationDisable = var6;
               var3.field1243 = 0;
               var3.field1241 = var3.queueSize;
            }
         }

         int var8;
         if((var4 & 32) != 0) {
            var5 = Client.secretPacketBuffer2.method3272();
            var6 = Client.secretPacketBuffer2.method3274();
            var7 = var3.x - (var5 - WallObject.baseX - WallObject.baseX) * 64;
            var8 = var3.y - (var6 - Varcs.baseY - Varcs.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1235 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 16) != 0) {
            var3.interacting = Client.secretPacketBuffer2.method3274();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 2) != 0) {
            var3.overhead = Client.secretPacketBuffer2.readString();
            var3.field1223 = 100;
         }

         if((var4 & 64) != 0) {
            var5 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = Client.secretPacketBuffer2.getUSmart();
                  if(var7 == 32767) {
                     var7 = Client.secretPacketBuffer2.getUSmart();
                     var9 = Client.secretPacketBuffer2.getUSmart();
                     var8 = Client.secretPacketBuffer2.getUSmart();
                     var10 = Client.secretPacketBuffer2.getUSmart();
                  } else if(var7 != 32766) {
                     var9 = Client.secretPacketBuffer2.getUSmart();
                  } else {
                     var7 = -1;
                  }

                  var11 = Client.secretPacketBuffer2.getUSmart();
                  var3.method1590(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = Client.secretPacketBuffer2.getUSmart();
                  var9 = Client.secretPacketBuffer2.getUSmart();
                  if(var9 != 32767) {
                     var10 = Client.secretPacketBuffer2.getUSmart();
                     var11 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                     int var12 = var9 > 0?Client.secretPacketBuffer2.method3265():var11;
                     var3.method1600(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1591(var8);
                  }
               }
            }
         }
      }

      for(var1 = 0; var1 < Client.field1036; ++var1) {
         var2 = Client.field1037[var1];
         if(Client.cachedNPCs[var2].field1256 != Client.gameCycle) {
            Client.cachedNPCs[var2].composition = null;
            Client.cachedNPCs[var2] = null;
         }
      }

      if(Client.packetLength != Client.secretPacketBuffer2.offset) {
         throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
      } else {
         for(var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
            if(Client.cachedNPCs[Client.npcIndices[var1]] == null) {
               throw new RuntimeException(var1 + "," + Client.npcIndexesCount);
            }
         }

      }
   }
}
