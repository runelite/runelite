import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1031608189
   )
   @Export("level")
   int level;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -587480805
   )
   @Export("type")
   int type;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1686624871
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1573427283
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1747233771
   )
   int field1135;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -446255805
   )
   int field1136;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -188175585
   )
   int field1134;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1025640105
   )
   @Export("id")
   int id;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 896075543
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1891694031
   )
   int field1140;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1332479551
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2044547841
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lhk;",
      garbageValue = "-112"
   )
   public static Widget method1612(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(class243.widgets[var1] == null || class243.widgets[var1][var2] == null) {
         boolean var3 = CombatInfoListHolder.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return class243.widgets[var1][var2];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "192696260"
   )
   static final void method1610(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class61.field738[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lfv;J)V"
   )
   static void method1613(Buffer var0, long var1) {
      var1 /= 10L;
      if(var1 < 0L) {
         var1 = 0L;
      } else if(var1 > 65535L) {
         var1 = 65535L;
      }

      var0.putShort((int)var1);
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1978063415"
   )
   static final void method1611() {
      PacketBuffer var0 = Client.field952.field1469;
      var0.bitAccess();
      int var1 = var0.getBits(8);
      int var2;
      if(var1 < Client.npcIndexesCount) {
         for(var2 = var1; var2 < Client.npcIndexesCount; ++var2) {
            Client.field973[++Client.field972 - 1] = Client.npcIndices[var2];
         }
      }

      if(var1 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.npcIndices[var2];
            NPC var4 = Client.cachedNPCs[var3];
            int var5 = var0.getBits(1);
            if(var5 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
               var4.field1192 = Client.gameCycle;
            } else {
               int var6 = var0.getBits(2);
               if(var6 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                  var4.field1192 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
               } else {
                  int var7;
                  int var8;
                  if(var6 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                     var4.field1192 = Client.gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1781(var7, (byte)1);
                     var8 = var0.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                     var4.field1192 = Client.gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1781(var7, (byte)2);
                     var8 = var0.getBits(3);
                     var4.method1781(var8, (byte)2);
                     int var9 = var0.getBits(1);
                     if(var9 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 3) {
                     Client.field973[++Client.field972 - 1] = var3;
                  }
               }
            }
         }

      }
   }
}
