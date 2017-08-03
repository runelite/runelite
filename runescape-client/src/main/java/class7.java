import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class7 {
   @ObfuscatedName("d")
   public static boolean field228;
   @ObfuscatedName("q")
   public static boolean field225;
   @ObfuscatedName("x")
   public static boolean field230;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   public static class11 field227;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static CombatInfoList field224;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = 1860046425
   )
   static int field226;
   @ObfuscatedName("ro")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;

   static {
      field228 = false;
      field225 = false;
      field230 = false;
      field227 = class11.field256;
      field224 = new CombatInfoList();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-69"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(XItemContainer.validInterfaces[var0]) {
         return true;
      } else if(!class67.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = class67.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            XItemContainer.validInterfaces[var0] = true;
            return true;
         } else {
            if(class170.widgets[var0] == null) {
               class170.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class170.widgets[var0][var2] == null) {
                  byte[] var3 = class67.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     class170.widgets[var0][var2] = new Widget();
                     class170.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class170.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        class170.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            XItemContainer.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "61757260"
   )
   static final int method38(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) + (var2 * (var1 & 16711935) + var3 * (var0 & 16711935) & -16711936) >> 8;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1938506975"
   )
   static final boolean method39(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else {
         boolean var1 = var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
         if(var1) {
            return true;
         } else {
            char[] var2 = class267.field3648;

            int var3;
            char var4;
            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            var2 = class267.field3649;

            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1934166363"
   )
   static final void method34(boolean var0) {
      while(true) {
         if(Client.secretPacketBuffer2.bitsAvail(Client.packetLength) >= 27) {
            int var1 = Client.secretPacketBuffer2.getBits(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.npcIndices[++Client.field932 - 1] = var1;
               var3.field1238 = Client.gameCycle;
               int var4;
               if(var0) {
                  var4 = Client.secretPacketBuffer2.getBits(8);
                  if(var4 > 127) {
                     var4 -= 256;
                  }
               } else {
                  var4 = Client.secretPacketBuffer2.getBits(5);
                  if(var4 > 15) {
                     var4 -= 32;
                  }
               }

               var3.composition = class60.getNpcDefinition(Client.secretPacketBuffer2.getBits(14));
               int var5 = Client.secretPacketBuffer2.getBits(1);
               if(var5 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var1;
               }

               int var6 = Client.secretPacketBuffer2.getBits(1);
               int var7;
               if(var0) {
                  var7 = Client.secretPacketBuffer2.getBits(8);
                  if(var7 > 127) {
                     var7 -= 256;
                  }
               } else {
                  var7 = Client.secretPacketBuffer2.getBits(5);
                  if(var7 > 15) {
                     var7 -= 32;
                  }
               }

               int var8 = Client.field1135[Client.secretPacketBuffer2.getBits(3)];
               if(var2) {
                  var3.orientation = var3.angle = var8;
               }

               var3.field1216 = var3.composition.field3535;
               var3.field1242 = var3.composition.field3558;
               if(var3.field1242 == 0) {
                  var3.angle = 0;
               }

               var3.field1197 = var3.composition.field3541;
               var3.field1205 = var3.composition.field3538;
               var3.field1249 = var3.composition.field3543;
               var3.field1200 = var3.composition.field3544;
               var3.idlePoseAnimation = var3.composition.field3563;
               var3.field1195 = var3.composition.field3539;
               var3.field1196 = var3.composition.field3531;
               var3.method1697(var4 + class224.localPlayer.pathX[0], var7 + class224.localPlayer.pathY[0], var6 == 1);
               continue;
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         return;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IZIZB)V",
      garbageValue = "100"
   )
   static void method35(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         class90.method1722(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }
}
