import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class162 {
   @ObfuscatedName("l")
   public static int[] field2279;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1502145357
   )
   public static int field2280;
   @ObfuscatedName("u")
   public static int[][] field2281;
   @ObfuscatedName("q")
   public static int[][] field2282;
   @ObfuscatedName("p")
   public static int[] field2284;

   static {
      field2281 = new int[128][128];
      field2282 = new int[128][128];
      field2284 = new int[4096];
      field2279 = new int[4096];
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "847572382"
   )
   static final void method3106(boolean var0) {
      Client.field1158 = 0;
      Client.field930 = 0;
      class69.method1107();

      int var1;
      NPC var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      while(Client.secretPacketBuffer2.method3468(Client.packetLength) >= 27) {
         var1 = Client.secretPacketBuffer2.method3470(15);
         if(var1 == 32767) {
            break;
         }

         boolean var2 = false;
         if(Client.cachedNPCs[var1] == null) {
            Client.cachedNPCs[var1] = new NPC();
            var2 = true;
         }

         var3 = Client.cachedNPCs[var1];
         Client.field1013[++Client.field928 - 1] = var1;
         var3.field1245 = Client.gameCycle;
         var4 = Client.secretPacketBuffer2.method3470(1);
         if(var0) {
            var5 = Client.secretPacketBuffer2.method3470(8);
            if(var5 > 127) {
               var5 -= 256;
            }
         } else {
            var5 = Client.secretPacketBuffer2.method3470(5);
            if(var5 > 15) {
               var5 -= 32;
            }
         }

         var6 = Client.field1018[Client.secretPacketBuffer2.method3470(3)];
         if(var2) {
            var3.field1247 = var3.angle = var6;
         }

         var3.composition = class220.getNpcDefinition(Client.secretPacketBuffer2.method3470(14));
         if(var0) {
            var7 = Client.secretPacketBuffer2.method3470(8);
            if(var7 > 127) {
               var7 -= 256;
            }
         } else {
            var7 = Client.secretPacketBuffer2.method3470(5);
            if(var7 > 15) {
               var7 -= 32;
            }
         }

         var8 = Client.secretPacketBuffer2.method3470(1);
         if(var8 == 1) {
            Client.field931[++Client.field930 - 1] = var1;
         }

         var3.field1202 = var3.composition.field3548;
         var3.field1209 = var3.composition.field3571;
         if(var3.field1209 == 0) {
            var3.angle = 0;
         }

         var3.field1227 = var3.composition.field3554;
         var3.field1251 = var3.composition.field3555;
         var3.field1208 = var3.composition.field3556;
         var3.field1226 = var3.composition.field3545;
         var3.idlePoseAnimation = var3.composition.field3560;
         var3.field1204 = var3.composition.field3573;
         var3.field1205 = var3.composition.field3553;
         var3.method1712(var5 + XGrandExchangeOffer.localPlayer.pathX[0], XGrandExchangeOffer.localPlayer.pathY[0] + var7, var4 == 1);
      }

      Client.secretPacketBuffer2.method3466();

      int var13;
      for(var1 = 0; var1 < Client.field930; ++var1) {
         var13 = Client.field931[var1];
         var3 = Client.cachedNPCs[var13];
         var4 = Client.secretPacketBuffer2.readUnsignedByte();
         if((var4 & 2) != 0) {
            var3.interacting = Client.secretPacketBuffer2.method3189();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 64) != 0) {
            var3.graphic = Client.secretPacketBuffer2.readUnsignedShort();
            var5 = Client.secretPacketBuffer2.method3310();
            var3.field1239 = var5 >> 16;
            var3.field1206 = Client.gameCycle + (var5 & '\uffff');
            var3.field1228 = 0;
            var3.field1237 = 0;
            if(var3.field1206 > Client.gameCycle) {
               var3.field1228 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 8) != 0) {
            var5 = Client.secretPacketBuffer2.method3245();
            var6 = Client.secretPacketBuffer2.method3189();
            var7 = var3.x - (var5 - class166.baseX - class166.baseX) * 64;
            var8 = var3.y - (var6 - class146.baseY - class146.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1230 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 1) != 0) {
            var5 = Client.secretPacketBuffer2.readUnsignedShort();
            if(var5 == '\uffff') {
               var5 = -1;
            }

            var6 = Client.secretPacketBuffer2.method3260();
            if(var3.animation == var5 && var5 != -1) {
               var7 = class165.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field1220 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1234 = 0;
               }

               if(var7 == 2) {
                  var3.field1234 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || class165.getAnimation(var5).forcedPriority >= class165.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field1220 = 0;
               var3.actionAnimationDisable = var6;
               var3.field1234 = 0;
               var3.field1236 = var3.field1252;
            }
         }

         if((var4 & 16) != 0) {
            var5 = Client.secretPacketBuffer2.method3305();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = Client.secretPacketBuffer2.method3212();
                  if(var7 == 32767) {
                     var7 = Client.secretPacketBuffer2.method3212();
                     var9 = Client.secretPacketBuffer2.method3212();
                     var8 = Client.secretPacketBuffer2.method3212();
                     var10 = Client.secretPacketBuffer2.method3212();
                  } else if(var7 != 32766) {
                     var9 = Client.secretPacketBuffer2.method3212();
                  } else {
                     var7 = -1;
                  }

                  var11 = Client.secretPacketBuffer2.method3212();
                  var3.method1525(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = Client.secretPacketBuffer2.method3260();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = Client.secretPacketBuffer2.method3212();
                  var9 = Client.secretPacketBuffer2.method3212();
                  if(var9 != 32767) {
                     var10 = Client.secretPacketBuffer2.method3212();
                     var11 = Client.secretPacketBuffer2.method3260();
                     int var12 = var9 > 0?Client.secretPacketBuffer2.method3227():var11;
                     var3.method1526(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1527(var8);
                  }
               }
            }
         }

         if((var4 & 4) != 0) {
            var3.composition = class220.getNpcDefinition(Client.secretPacketBuffer2.method3245());
            var3.field1202 = var3.composition.field3548;
            var3.field1209 = var3.composition.field3571;
            var3.field1227 = var3.composition.field3554;
            var3.field1251 = var3.composition.field3555;
            var3.field1208 = var3.composition.field3556;
            var3.field1226 = var3.composition.field3545;
            var3.idlePoseAnimation = var3.composition.field3560;
            var3.field1204 = var3.composition.field3573;
            var3.field1205 = var3.composition.field3553;
         }

         if((var4 & 32) != 0) {
            var3.overhead = Client.secretPacketBuffer2.readString();
            var3.field1214 = 100;
         }
      }

      for(var1 = 0; var1 < Client.field1158; ++var1) {
         var13 = Client.field1087[var1];
         if(Client.gameCycle != Client.cachedNPCs[var13].field1245) {
            Client.cachedNPCs[var13].composition = null;
            Client.cachedNPCs[var13] = null;
         }
      }

      if(Client.packetLength != Client.secretPacketBuffer2.offset) {
         throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
      } else {
         for(var1 = 0; var1 < Client.field928; ++var1) {
            if(Client.cachedNPCs[Client.field1013[var1]] == null) {
               throw new RuntimeException(var1 + "," + Client.field928);
            }
         }

      }
   }
}
