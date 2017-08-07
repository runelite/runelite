import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class20 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -456785091
   )
   static int field326;
   @ObfuscatedName("u")
   @Export("blendedHue")
   static int[] blendedHue;

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1442912404"
   )
   static final void method156() {
      for(int var0 = 0; var0 < Client.pendingNpcFlagsCount; ++var0) {
         int var1 = Client.pendingNpcFlagsIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.secretPacketBuffer2.readUnsignedByte();
         int var4;
         int var5;
         int var6;
         int var7;
         if((var3 & 16) != 0) {
            var4 = Client.secretPacketBuffer2.readUnsignedShort();
            var5 = Client.secretPacketBuffer2.method3337();
            var6 = var2.x - (var4 - class25.baseX - class25.baseX) * 64;
            var7 = var2.y - (var5 - ScriptEvent.baseY - ScriptEvent.baseY) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field1205 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 64) != 0) {
            var4 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.secretPacketBuffer2.getUSmart();
                  if(var6 == 32767) {
                     var6 = Client.secretPacketBuffer2.getUSmart();
                     var8 = Client.secretPacketBuffer2.getUSmart();
                     var7 = Client.secretPacketBuffer2.getUSmart();
                     var9 = Client.secretPacketBuffer2.getUSmart();
                  } else if(var6 != 32766) {
                     var8 = Client.secretPacketBuffer2.getUSmart();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.secretPacketBuffer2.getUSmart();
                  var2.method1526(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.secretPacketBuffer2.method3202();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.secretPacketBuffer2.getUSmart();
                  var8 = Client.secretPacketBuffer2.getUSmart();
                  if(var8 != 32767) {
                     var9 = Client.secretPacketBuffer2.getUSmart();
                     var10 = Client.secretPacketBuffer2.method3203();
                     int var11 = var8 > 0?Client.secretPacketBuffer2.readUnsignedShortOb1():var10;
                     var2.method1529(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method1530(var7);
                  }
               }
            }
         }

         if((var3 & 4) != 0) {
            var2.composition = class19.getNpcDefinition(Client.secretPacketBuffer2.method3337());
            var2.field1254 = var2.composition.field3547;
            var2.field1229 = var2.composition.field3570;
            var2.field1241 = var2.composition.field3553;
            var2.field1214 = var2.composition.field3554;
            var2.field1249 = var2.composition.field3548;
            var2.field1211 = var2.composition.field3556;
            var2.idlePoseAnimation = var2.composition.field3550;
            var2.field1227 = var2.composition.field3551;
            var2.field1212 = var2.composition.field3546;
         }

         if((var3 & 2) != 0) {
            var2.graphic = Client.secretPacketBuffer2.readUnsignedShort();
            var4 = Client.secretPacketBuffer2.method3166();
            var2.field1265 = var4 >> 16;
            var2.graphicsDelay = (var4 & '\uffff') + Client.gameCycle;
            var2.field1209 = 0;
            var2.field1244 = 0;
            if(var2.graphicsDelay > Client.gameCycle) {
               var2.field1209 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         if((var3 & 32) != 0) {
            var2.overhead = Client.secretPacketBuffer2.readString();
            var2.field1221 = 100;
         }

         if((var3 & 8) != 0) {
            var2.interacting = Client.secretPacketBuffer2.method3213();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         if((var3 & 1) != 0) {
            var4 = Client.secretPacketBuffer2.readUnsignedShort();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            if(var4 == var2.animation && var4 != -1) {
               var6 = Ignore.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field1239 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field1246 = 0;
               }

               if(var6 == 2) {
                  var2.field1246 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || Ignore.getAnimation(var4).forcedPriority >= Ignore.getAnimation(var2.animation).forcedPriority) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field1239 = 0;
               var2.actionAnimationDisable = var5;
               var2.field1246 = 0;
               var2.field1264 = var2.queueSize;
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcc;ZB)I",
      garbageValue = "1"
   )
   static int method157(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         class84.intStack[++class84.intStackSize - 1] = Tile.method2512();
         return 1;
      } else {
         int var3;
         if(var0 == 5307) {
            var3 = class84.intStack[--class84.intStackSize];
            if(var3 == 1 || var3 == 2) {
               Client.field1115 = 0L;
               if(var3 >= 2) {
                  Client.isResized = true;
               } else {
                  Client.isResized = false;
               }

               if(Tile.method2512() == 1) {
                  class5.clientInstance.method838(765, 503);
               } else {
                  class5.clientInstance.method838(7680, 2160);
               }

               if(Client.gameState >= 25) {
                  XGrandExchangeOffer.method113();
               }
            }

            return 1;
         } else if(var0 == 5308) {
            class84.intStack[++class84.intStackSize - 1] = MilliTimer.preferences.screenType;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var3 = class84.intStack[--class84.intStackSize];
            if(var3 == 1 || var3 == 2) {
               MilliTimer.preferences.screenType = var3;
               Projectile.method1782();
            }

            return 1;
         }
      }
   }
}
