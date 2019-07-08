import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("u")
@Implements("GrandExchangeOfferWorldComparator")
final class GrandExchangeOfferWorldComparator implements Comparator {
   @ObfuscatedName("n")
   public static boolean field988;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "707844889"
   )
   @Export("compareTyped")
   int compareTyped(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world ? -1 : (var2.world == var1.world ? 0 : 1);
   }

   public int compare(Object var1, Object var2) {
      return this.compareTyped((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
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
      if (var0 == ScriptOpcodes.SOUND_SYNTH) {
         RouteStrategy.Interpreter_intStackSize -= 3;
         Ignored.queueSoundEffect(Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize], Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 2]);
         return 1;
      } else if (var0 == ScriptOpcodes.SOUND_SONG) {
         AbstractUserComparator.method5437(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
         return 1;
      } else if (var0 == ScriptOpcodes.SOUND_JINGLE) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         HealthBar.method1994(Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize], Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1]);
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
      for (int var1 = 0; var1 < Client.field173; ++var1) {
         int var2 = Client.field174[var1];
         NPC var3 = Client.npcs[var2];
         int var4 = var0.readUnsignedByte();
         if ((var4 & 1) != 0) {
            var3.targetIndex = var0.method65();
            if (var3.targetIndex == 65535) {
               var3.targetIndex = -1;
            }
         }

         int var5;
         int var6;
         int var7;
         int var8;
         if ((var4 & 64) != 0) {
            var5 = var0.method67();
            var6 = var0.method67();
            var7 = var3.x - (var5 - class50.baseX - class50.baseX) * 64;
            var8 = var3.y - (var6 - GraphicsObject.baseY - GraphicsObject.baseY) * 64;
            if (var7 != 0 || var8 != 0) {
               var3.field12 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if ((var4 & 32) != 0) {
            var5 = var0.readUnsignedShort();
            if (var5 == 65535) {
               var5 = -1;
            }

            var6 = var0.method59();
            if (var5 == var3.sequence && var5 != -1) {
               var7 = WorldMapAreaData.getSequenceDefinition(var5).field783;
               if (var7 == 1) {
                  var3.sequenceFrame = 0;
                  var3.sequenceFrameCycle = 0;
                  var3.sequenceDelay = var6;
                  var3.field13 = 0;
               }

               if (var7 == 2) {
                  var3.field13 = 0;
               }
            } else if (var5 == -1 || var3.sequence == -1 || WorldMapAreaData.getSequenceDefinition(var5).field779 >= WorldMapAreaData.getSequenceDefinition(var3.sequence).field779) {
               var3.sequence = var5;
               var3.sequenceFrame = 0;
               var3.sequenceFrameCycle = 0;
               var3.sequenceDelay = var6;
               var3.field13 = 0;
               var3.field25 = var3.pathLength;
            }
         }

         if ((var4 & 4) != 0) {
            var3.definition = ObjectDefinition.getNpcDefinition(var0.readUnsignedShort());
            var3.size = var3.definition.size;
            var3.field23 = var3.definition.field639;
            var3.walkSequence = var3.definition.walkSequence;
            var3.walkBackSequence = var3.definition.walkBackSequence;
            var3.walkLeftSequence = var3.definition.walkLeftSequence;
            var3.walkRightSequence = var3.definition.walkRightSequence;
            var3.readySequence = var3.definition.readySequence;
            var3.turnLeftSequence = var3.definition.turnLeftSequence;
            var3.turnRightSequence = var3.definition.turnRightSequence;
         }

         if ((var4 & 16) != 0) {
            var5 = var0.readUnsignedByteNegate();
            int var9;
            int var10;
            int var11;
            if (var5 > 0) {
               for (var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = var0.readUShortSmart();
                  if (var7 == 32767) {
                     var7 = var0.readUShortSmart();
                     var9 = var0.readUShortSmart();
                     var8 = var0.readUShortSmart();
                     var10 = var0.readUShortSmart();
                  } else if (var7 != 32766) {
                     var9 = var0.readUShortSmart();
                  } else {
                     var7 = -1;
                  }

                  var11 = var0.readUShortSmart();
                  var3.addHitSplat(var7, var9, var8, var10, Client.cycle, var11);
               }
            }

            var6 = var0.method58();
            if (var6 > 0) {
               for (var7 = 0; var7 < var6; ++var7) {
                  var8 = var0.readUShortSmart();
                  var9 = var0.readUShortSmart();
                  if (var9 != 32767) {
                     var10 = var0.readUShortSmart();
                     var11 = var0.readUnsignedByte();
                     int var12 = var9 > 0 ? var0.method59() : var11;
                     var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
                  } else {
                     var3.removeHealthBar(var8);
                  }
               }
            }
         }

         if ((var4 & 8) != 0) {
            var3.spotAnimation = var0.method65();
            var5 = var0.method72();
            var3.heightOffset = var5 >> 16;
            var3.field14 = (var5 & 65535) + Client.cycle;
            var3.spotAnimationFrame = 0;
            var3.spotAnimationFrameCycle = 0;
            if (var3.field14 > Client.cycle) {
               var3.spotAnimationFrame = -1;
            }

            if (var3.spotAnimation == 65535) {
               var3.spotAnimation = -1;
            }
         }

         if ((var4 & 2) != 0) {
            var3.overheadText = var0.readStringCp1252NullTerminated();
            var3.overheadTextCyclesRemaining = 100;
         }
      }

   }
}
