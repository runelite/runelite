import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class84 {
   @ObfuscatedName("j")
   static final BigInteger field1262;
   @ObfuscatedName("a")
   static final BigInteger field1263;

   static {
      field1262 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1263 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILcd;ZB)I",
      garbageValue = "2"
   )
   static int method1839(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if(var0 == 3400) {
         class80.intStackSize -= 2;
         var3 = class80.intStack[class80.intStackSize];
         var4 = class80.intStack[class80.intStackSize + 1];
         Enum var5 = Script.method1999(var3);
         if(var5.valType != 's') {
            ;
         }

         for(var6 = 0; var6 < var5.size; ++var6) {
            if(var4 == var5.keys[var6]) {
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var5.stringVals[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var5.defaultString;
         }

         return 1;
      } else if(var0 != 3408) {
         if(var0 == 3411) {
            var3 = class80.intStack[--class80.intStackSize];
            Enum var10 = Script.method1999(var3);
            class80.intStack[++class80.intStackSize - 1] = var10.method4728();
            return 1;
         } else {
            return 2;
         }
      } else {
         class80.intStackSize -= 4;
         var3 = class80.intStack[class80.intStackSize];
         var4 = class80.intStack[class80.intStackSize + 1];
         int var9 = class80.intStack[class80.intStackSize + 2];
         var6 = class80.intStack[class80.intStackSize + 3];
         Enum var7 = Script.method1999(var9);
         if(var3 == var7.keyType && var4 == var7.valType) {
            for(int var8 = 0; var8 < var7.size; ++var8) {
               if(var6 == var7.keys[var8]) {
                  if(var4 == 115) {
                     class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var7.stringVals[var8];
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = var7.intVals[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var7.defaultString;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var7.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "null";
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(Lgd;I)V",
      garbageValue = "-92797440"
   )
   static final void method1840(PacketBuffer var0) {
      for(int var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
         int var2 = Client.pendingNpcFlagsIndices[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = var0.readUnsignedByte();
         int var5;
         int var6;
         int var7;
         int var8;
         if((var4 & 32) != 0) {
            var5 = var0.method3432();
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
                  var3.method1579(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = var0.readUnsignedByte();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  if(var9 != 32767) {
                     var10 = var0.getUSmart();
                     var11 = var0.readUnsignedByteNegate();
                     int var12 = var9 > 0?var0.readUnsignedByteNegate():var11;
                     var3.method1596(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1589(var8);
                  }
               }
            }
         }

         if((var4 & 2) != 0) {
            var3.overhead = var0.readString();
            var3.overheadTextCyclesRemaining = 100;
         }

         if((var4 & 8) != 0) {
            var5 = var0.readUnsignedShortOb1();
            if(var5 == 65535) {
               var5 = -1;
            }

            var6 = var0.method3432();
            if(var5 == var3.animation && var5 != -1) {
               var7 = CacheFile.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field1123 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1133 = 0;
               }

               if(var7 == 2) {
                  var3.field1133 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || CacheFile.getAnimation(var5).forcedPriority >= CacheFile.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field1123 = 0;
               var3.actionAnimationDisable = var6;
               var3.field1133 = 0;
               var3.field1156 = var3.queueSize;
            }
         }

         if((var4 & 1) != 0) {
            var3.interacting = var0.readUnsignedShortOb1();
            if(var3.interacting == 65535) {
               var3.interacting = -1;
            }
         }

         if((var4 & 64) != 0) {
            var3.composition = class230.getNpcDefinition(var0.readUnsignedShortOb1());
            var3.field1127 = var3.composition.field3611;
            var3.field1150 = var3.composition.field3634;
            var3.field1105 = var3.composition.field3632;
            var3.field1144 = var3.composition.field3629;
            var3.field1104 = var3.composition.field3606;
            var3.field1108 = var3.composition.field3636;
            var3.idlePoseAnimation = var3.composition.field3614;
            var3.field1106 = var3.composition.field3615;
            var3.field1149 = var3.composition.field3616;
         }

         if((var4 & 16) != 0) {
            var5 = var0.readUnsignedShortOb1();
            var6 = var0.readUnsignedShortOb1();
            var7 = var3.x - (var5 - WorldMapType1.baseX - WorldMapType1.baseX) * 64;
            var8 = var3.y - (var6 - class85.baseY - class85.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1125 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 4) != 0) {
            var3.graphic = var0.method3440();
            var5 = var0.method3452();
            var3.field1138 = var5 >> 16;
            var3.graphicsDelay = (var5 & 65535) + Client.gameCycle;
            var3.field1135 = 0;
            var3.field1131 = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.field1135 = -1;
            }

            if(var3.graphic == 65535) {
               var3.graphic = -1;
            }
         }
      }

   }
}
