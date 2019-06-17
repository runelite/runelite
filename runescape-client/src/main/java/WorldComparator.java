import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("n")
   @Export("__u_n")
   public static boolean __u_n;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "707844889"
   )
   @Export("__m_0")
   int __m_0(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.__m_0((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @Export("__equals_2")
   @ObfuscatedName("equals")
   public boolean __equals_2(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1032556606"
   )
   public static boolean method58(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "108"
   )
   static int method68(int var0, Script var1, boolean var2) {
      if(var0 == 3200) {
         class179.Interpreter_intStackSize -= 3;
         Ignored.queueSoundEffect(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2]);
         return 1;
      } else if(var0 == 3201) {
         AbstractUserComparator.method5437(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
         return 1;
      } else if(var0 == 3202) {
         class179.Interpreter_intStackSize -= 2;
         HealthBar.method1994(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(Lhx;B)V",
      garbageValue = "96"
   )
   static final void method67(PacketBuffer var0) {
      for(int var1 = 0; var1 < Client.__client_fw; ++var1) {
         int var2 = Client.__client_fg[var1];
         NPC var3 = Client.npcs[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 1) != 0) {
            var3.targetIndex = var0.__by_324();
            if(var3.targetIndex == 65535) {
               var3.targetIndex = -1;
            }
         }

         int var5;
         int var6;
         int var7;
         int var8;
         if((var4 & 64) != 0) {
            var5 = var0.__bm_326();
            var6 = var0.__bm_326();
            var7 = var3.x - (var5 - class50.baseX - class50.baseX) * 64;
            var8 = var3.y - (var6 - GraphicsObject.baseY - GraphicsObject.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.__bc = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 32) != 0) {
            var5 = var0.__ag_302();
            if(var5 == 65535) {
               var5 = -1;
            }

            var6 = var0.__bq_318();
            if(var5 == var3.sequence && var5 != -1) {
               var7 = WorldMapAreaData.getSequenceDefinition(var5).__t;
               if(var7 == 1) {
                  var3.sequenceFrame = 0;
                  var3.sequenceFrameCycle = 0;
                  var3.sequenceDelay = var6;
                  var3.__bj = 0;
               }

               if(var7 == 2) {
                  var3.__bj = 0;
               }
            } else if(var5 == -1 || var3.sequence == -1 || WorldMapAreaData.getSequenceDefinition(var5).__n >= WorldMapAreaData.getSequenceDefinition(var3.sequence).__n) {
               var3.sequence = var5;
               var3.sequenceFrame = 0;
               var3.sequenceFrameCycle = 0;
               var3.sequenceDelay = var6;
               var3.__bj = 0;
               var3.__ch = var3.pathLength;
            }
         }

         if((var4 & 4) != 0) {
            var3.definition = ObjectDefinition.getNpcDefinition(var0.__ag_302());
            var3.size = var3.definition.size;
            var3.__cj = var3.definition.__av;
            var3.walkSequence = var3.definition.walkSequence;
            var3.walkTurnSequence = var3.definition.walkTurnSequence;
            var3.walkTurnLeftSequence = var3.definition.walkTurnLeftSequence;
            var3.walkTurnRightSequence = var3.definition.walkTurnRightSequence;
            var3.idleSequence = var3.definition.idleSequence;
            var3.turnLeftSequence = var3.definition.turnLeftSequence;
            var3.turnRightSequence = var3.definition.turnRightSequence;
         }

         if((var4 & 16) != 0) {
            var5 = var0.readUnsignedByteNegate();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = var0.__ae_307();
                  if(var7 == 32767) {
                     var7 = var0.__ae_307();
                     var9 = var0.__ae_307();
                     var8 = var0.__ae_307();
                     var10 = var0.__ae_307();
                  } else if(var7 != 32766) {
                     var9 = var0.__ae_307();
                  } else {
                     var7 = -1;
                  }

                  var11 = var0.__ae_307();
                  var3.addHitSplat(var7, var9, var8, var10, Client.cycle, var11);
               }
            }

            var6 = var0.__bb_317();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var0.__ae_307();
                  var9 = var0.__ae_307();
                  if(var9 != 32767) {
                     var10 = var0.__ae_307();
                     var11 = var0.readUnsignedByte();
                     int var12 = var9 > 0?var0.__bq_318():var11;
                     var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
                  } else {
                     var3.removeHealthBar(var8);
                  }
               }
            }
         }

         if((var4 & 8) != 0) {
            var3.spotAnimation = var0.__by_324();
            var5 = var0.__bp_331();
            var3.heightOffset = var5 >> 16;
            var3.__bt = (var5 & 65535) + Client.cycle;
            var3.spotAnimationFrame = 0;
            var3.spotAnimationFrameCycle = 0;
            if(var3.__bt > Client.cycle) {
               var3.spotAnimationFrame = -1;
            }

            if(var3.spotAnimation == 65535) {
               var3.spotAnimation = -1;
            }
         }

         if((var4 & 2) != 0) {
            var3.overheadText = var0.readStringCp1252NullTerminated();
            var3.overheadTextCyclesRemaining = 100;
         }
      }

   }
}
