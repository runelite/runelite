import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class182 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 2497395099011537047L
   )
   static long field2505;

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(Lgd;I)V",
      garbageValue = "472158902"
   )
   static final void method3419(PacketBuffer var0) {
      for(int var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
         int var2 = Client.pendingNpcFlagsIndices[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = var0.readUnsignedByte();
         int var5;
         int var6;
         int var7;
         int var8;
         if((var4 & 32) != 0) {
            var5 = var0.method3290();
            var6 = var0.method3290();
            var7 = var3.x - (var5 - class13.baseX - class13.baseX) * 64;
            var8 = var3.y - (var6 - ClanMember.baseY - ClanMember.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1172 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 8) != 0) {
            var3.composition = class211.getNpcDefinition(var0.method3290());
            var3.field1148 = var3.composition.field3606;
            var3.field1197 = var3.composition.field3616;
            var3.field1152 = var3.composition.field3624;
            var3.field1153 = var3.composition.field3603;
            var3.field1154 = var3.composition.field3614;
            var3.field1155 = var3.composition.field3622;
            var3.idlePoseAnimation = var3.composition.field3609;
            var3.field1150 = var3.composition.field3629;
            var3.field1171 = var3.composition.field3633;
         }

         if((var4 & 4) != 0) {
            var5 = var0.method3290();
            if(var5 == 65535) {
               var5 = -1;
            }

            var6 = var0.method3214();
            if(var5 == var3.animation && var5 != -1) {
               var7 = class90.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field1144 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1188 = 0;
               }

               if(var7 == 2) {
                  var3.field1188 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || class90.getAnimation(var5).forcedPriority >= class90.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field1144 = 0;
               var3.actionAnimationDisable = var6;
               var3.field1188 = 0;
               var3.field1203 = var3.queueSize;
            }
         }

         if((var4 & 16) != 0) {
            var5 = var0.method3214();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = var0.getUSmart();
                  if(var7 == 32767) {
                     var7 = var0.getUSmart();
                     var9 = var0.getUSmart();
                     var8 = var0.getUSmart();
                     var10 = var0.getUSmart();
                  } else if(var7 != 32766) {
                     var9 = var0.getUSmart();
                  } else {
                     var7 = -1;
                  }

                  var11 = var0.getUSmart();
                  var3.method1501(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = var0.method3214();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  if(var9 != 32767) {
                     var10 = var0.getUSmart();
                     var11 = var0.method3214();
                     int var12 = var9 > 0?var0.readUnsignedShortOb1():var11;
                     var3.method1511(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1495(var8);
                  }
               }
            }
         }

         if((var4 & 64) != 0) {
            var3.overhead = var0.readString();
            var3.field1201 = 100;
         }

         if((var4 & 1) != 0) {
            var3.graphic = var0.method3290();
            var5 = var0.method3232();
            var3.field1185 = var5 >> 16;
            var3.graphicsDelay = (var5 & 65535) + Client.gameCycle;
            var3.field1190 = 0;
            var3.field1183 = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.field1190 = -1;
            }

            if(var3.graphic == 65535) {
               var3.graphic = -1;
            }
         }

         if((var4 & 2) != 0) {
            var3.interacting = var0.readUnsignedShort();
            if(var3.interacting == 65535) {
               var3.interacting = -1;
            }
         }
      }

   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "255"
   )
   static final void method3418(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1050; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1053[var4] = true;
         }
      }

   }
}
