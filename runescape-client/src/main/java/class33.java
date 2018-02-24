import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class33 {
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = -579582923
   )
   static int field435;
   @ObfuscatedName("aa")
   static GarbageCollectorMXBean field430;
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("slArrowSprites")
   static IndexedSprite[] slArrowSprites;
   @ObfuscatedName("b")
   String field431;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -574925645
   )
   int field436;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1281147685
   )
   int field432;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   Size field433;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILn;)V"
   )
   class33(String var1, int var2, int var3, Size var4) {
      this.field431 = var1;
      this.field436 = var2;
      this.field432 = var3;
      this.field433 = var4;
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1885914111"
   )
   static final void method375() {
      int var0 = class157.field2116 * 128 + 64;
      int var1 = Client.field1038 * 128 + 64;
      int var2 = WorldMapType1.getTileHeight(var0, var1, class230.plane) - class224.field2650;
      if(class39.cameraX < var0) {
         class39.cameraX = (var0 - class39.cameraX) * DynamicObject.field1425 / 1000 + class39.cameraX + Script.field1412;
         if(class39.cameraX > var0) {
            class39.cameraX = var0;
         }
      }

      if(class39.cameraX > var0) {
         class39.cameraX -= DynamicObject.field1425 * (class39.cameraX - var0) / 1000 + Script.field1412;
         if(class39.cameraX < var0) {
            class39.cameraX = var0;
         }
      }

      if(class159.cameraZ < var2) {
         class159.cameraZ = (var2 - class159.cameraZ) * DynamicObject.field1425 / 1000 + class159.cameraZ + Script.field1412;
         if(class159.cameraZ > var2) {
            class159.cameraZ = var2;
         }
      }

      if(class159.cameraZ > var2) {
         class159.cameraZ -= DynamicObject.field1425 * (class159.cameraZ - var2) / 1000 + Script.field1412;
         if(class159.cameraZ < var2) {
            class159.cameraZ = var2;
         }
      }

      if(CombatInfo1.cameraY < var1) {
         CombatInfo1.cameraY = (var1 - CombatInfo1.cameraY) * DynamicObject.field1425 / 1000 + CombatInfo1.cameraY + Script.field1412;
         if(CombatInfo1.cameraY > var1) {
            CombatInfo1.cameraY = var1;
         }
      }

      if(CombatInfo1.cameraY > var1) {
         CombatInfo1.cameraY -= DynamicObject.field1425 * (CombatInfo1.cameraY - var1) / 1000 + Script.field1412;
         if(CombatInfo1.cameraY < var1) {
            CombatInfo1.cameraY = var1;
         }
      }

      var0 = class131.field1879 * 128 + 64;
      var1 = class304.field3804 * 128 + 64;
      var2 = WorldMapType1.getTileHeight(var0, var1, class230.plane) - AbstractSoundSystem.field1524;
      int var3 = var0 - class39.cameraX;
      int var4 = var2 - class159.cameraZ;
      int var5 = var1 - CombatInfo1.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(DecorativeObject.cameraPitchCopy < var7) {
         DecorativeObject.cameraPitchCopy = (var7 - DecorativeObject.cameraPitchCopy) * MouseRecorder.field759 / 1000 + DecorativeObject.cameraPitchCopy + field435;
         if(DecorativeObject.cameraPitchCopy > var7) {
            DecorativeObject.cameraPitchCopy = var7;
         }
      }

      if(DecorativeObject.cameraPitchCopy > var7) {
         DecorativeObject.cameraPitchCopy -= MouseRecorder.field759 * (DecorativeObject.cameraPitchCopy - var7) / 1000 + field435;
         if(DecorativeObject.cameraPitchCopy < var7) {
            DecorativeObject.cameraPitchCopy = var7;
         }
      }

      int var9 = var8 - class60.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class60.cameraYaw = var9 * MouseRecorder.field759 / 1000 + class60.cameraYaw + field435;
         class60.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class60.cameraYaw -= field435 + -var9 * MouseRecorder.field759 / 1000;
         class60.cameraYaw &= 2047;
      }

      int var10 = var8 - class60.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class60.cameraYaw = var8;
      }

   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(ZLgu;B)V",
      garbageValue = "-13"
   )
   @Hook("onNpcUpdate")
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      while(true) {
         if(var1.bitsAvail(Client.field863.packetLength) >= 27) {
            int var2 = var1.getBits(15);
            if(var2 != 32767) {
               boolean var3 = false;
               if(Client.cachedNPCs[var2] == null) {
                  Client.cachedNPCs[var2] = new NPC();
                  var3 = true;
               }

               NPC var4 = Client.cachedNPCs[var2];
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               var4.npcCycle = Client.gameCycle;
               int var5;
               if(var0) {
                  var5 = var1.getBits(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = var1.getBits(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               var4.composition = Tile.getNpcDefinition(var1.getBits(14));
               int var6 = Client.field993[var1.getBits(3)];
               if(var3) {
                  var4.orientation = var4.angle = var6;
               }

               int var7;
               if(var0) {
                  var7 = var1.getBits(8);
                  if(var7 > 127) {
                     var7 -= 256;
                  }
               } else {
                  var7 = var1.getBits(5);
                  if(var7 > 15) {
                     var7 -= 32;
                  }
               }

               int var8 = var1.getBits(1);
               if(var8 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               }

               int var9 = var1.getBits(1);
               var4.field1098 = var4.composition.field3661;
               var4.field1147 = var4.composition.field3628;
               if(var4.field1147 == 0) {
                  var4.angle = 0;
               }

               var4.field1102 = var4.composition.field3648;
               var4.field1099 = var4.composition.field3642;
               var4.field1130 = var4.composition.field3641;
               var4.field1105 = var4.composition.field3639;
               var4.idlePoseAnimation = var4.composition.field3636;
               var4.field1100 = var4.composition.field3637;
               var4.field1101 = var4.composition.field3638;
               var4.method1835(OwnWorldComparator.localPlayer.pathX[0] + var5, OwnWorldComparator.localPlayer.pathY[0] + var7, var9 == 1);
               continue;
            }
         }

         var1.byteAccess();
         return;
      }
   }
}
