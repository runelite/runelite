import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class36 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   static final class36 field476;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   static final class36 field477;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Ljw;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1720990817
   )
   final int field478;

   static {
      field476 = new class36(0);
      field477 = new class36(1);
   }

   class36(int var1) {
      this.field478 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lio;",
      garbageValue = "-46"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3310.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1159714396"
   )
   static final void method501(boolean var0) {
      Client.field1006 = 0;
      Client.pendingNpcFlagsCount = 0;
      class21.method147();
      class7.method34(var0);

      int var1;
      int var2;
      for(var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
         var2 = Client.pendingNpcFlagsIndices[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = Client.secretPacketBuffer2.readUnsignedByte();
         if((var4 & 64) != 0) {
            var3.composition = class60.getNpcDefinition(Client.secretPacketBuffer2.readByteOb1());
            var3.field1216 = var3.composition.field3535;
            var3.field1242 = var3.composition.field3558;
            var3.field1197 = var3.composition.field3541;
            var3.field1205 = var3.composition.field3538;
            var3.field1249 = var3.composition.field3543;
            var3.field1200 = var3.composition.field3544;
            var3.idlePoseAnimation = var3.composition.field3563;
            var3.field1195 = var3.composition.field3539;
            var3.field1196 = var3.composition.field3531;
         }

         int var5;
         if((var4 & 4) != 0) {
            var3.graphic = Client.secretPacketBuffer2.readByteOb1();
            var5 = Client.secretPacketBuffer2.method3244();
            var3.field1230 = var5 >> 16;
            var3.graphicsDelay = (var5 & '\uffff') + Client.gameCycle;
            var3.field1227 = 0;
            var3.field1228 = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.field1227 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 32) != 0) {
            var3.overhead = Client.secretPacketBuffer2.readString();
            var3.field1213 = 100;
         }

         int var6;
         int var7;
         if((var4 & 8) != 0) {
            var5 = Client.secretPacketBuffer2.method3236();
            if(var5 == '\uffff') {
               var5 = -1;
            }

            var6 = Client.secretPacketBuffer2.method3295();
            if(var5 == var3.animation && var5 != -1) {
               var7 = class40.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field1223 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1218 = 0;
               }

               if(var7 == 2) {
                  var3.field1218 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || class40.getAnimation(var5).forcedPriority >= class40.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field1223 = 0;
               var3.actionAnimationDisable = var6;
               var3.field1218 = 0;
               var3.field1248 = var3.queueSize;
            }
         }

         int var8;
         if((var4 & 16) != 0) {
            var5 = Client.secretPacketBuffer2.method3230();
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
                  var3.method1548(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = Client.secretPacketBuffer2.readUnsignedByte();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = Client.secretPacketBuffer2.getUSmart();
                  var9 = Client.secretPacketBuffer2.getUSmart();
                  if(var9 != 32767) {
                     var10 = Client.secretPacketBuffer2.getUSmart();
                     var11 = Client.secretPacketBuffer2.readUnsignedByte();
                     int var12 = var9 > 0?Client.secretPacketBuffer2.readUnsignedByte():var11;
                     var3.method1537(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1539(var8);
                  }
               }
            }
         }

         if((var4 & 1) != 0) {
            var5 = Client.secretPacketBuffer2.method3236();
            var6 = Client.secretPacketBuffer2.method3236();
            var7 = var3.x - (var5 - class33.baseX - class33.baseX) * 64;
            var8 = var3.y - (var6 - class17.baseY - class17.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1209 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 2) != 0) {
            var3.interacting = Client.secretPacketBuffer2.readByteOb1();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }
      }

      for(var1 = 0; var1 < Client.field1006; ++var1) {
         var2 = Client.field1007[var1];
         if(Client.cachedNPCs[var2].field1238 != Client.gameCycle) {
            Client.cachedNPCs[var2].composition = null;
            Client.cachedNPCs[var2] = null;
         }
      }

      if(Client.packetLength != Client.secretPacketBuffer2.offset) {
         throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
      } else {
         for(var1 = 0; var1 < Client.field932; ++var1) {
            if(Client.cachedNPCs[Client.npcIndices[var1]] == null) {
               throw new RuntimeException(var1 + "," + Client.field932);
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "-219936819"
   )
   static int method503(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = WallObject.method2901(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class214.field2615:class73.field851;
      }

      String var4 = class83.scriptStringStack[--Timer.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var6 = class83.intStack[--class83.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class83.intStack[--class83.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var8[var7] = class83.scriptStringStack[--Timer.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class83.intStack[--class83.intStackSize]);
         }
      }

      var7 = class83.intStack[--class83.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2711 = var8;
      } else if(var0 == 1401) {
         var3.field2714 = var8;
      } else if(var0 == 1402) {
         var3.field2690 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2718 = var8;
      } else if(var0 == 1406) {
         var3.field2721 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2729 = var8;
      } else if(var0 == 1410) {
         var3.field2719 = var8;
      } else if(var0 == 1411) {
         var3.field2707 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2720 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2731 = var8;
      } else if(var0 == 1419) {
         var3.field2732 = var8;
      } else if(var0 == 1420) {
         var3.field2677 = var8;
      } else if(var0 == 1421) {
         var3.field2631 = var8;
      } else if(var0 == 1422) {
         var3.field2705 = var8;
      } else if(var0 == 1423) {
         var3.field2685 = var8;
      } else if(var0 == 1424) {
         var3.field2645 = var8;
      } else if(var0 == 1425) {
         var3.field2762 = var8;
      } else if(var0 == 1426) {
         var3.field2740 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2741 = var8;
      }

      var3.field2745 = true;
      return 1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2037324535"
   )
   public static boolean method500(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
