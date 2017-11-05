import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("w")
   @Export("component")
   Component component;

   RSCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZZI)Ljo;",
      garbageValue = "-960172217"
   )
   static IndexedSprite method776(boolean var0, boolean var1) {
      return var0?(var1?class90.field1419:class29.field430):(var1?class90.field1418:class90.field1417);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16711680"
   )
   static void method769() {
      class96.chatLineMap.clear();
      class96.field1516.clear();
      class96.field1517.method3757();
      class96.field1515 = 0;
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1964638179"
   )
   static final void method775() {
      Client.secretPacketBuffer2.bitAccess();
      int var0 = Client.secretPacketBuffer2.getBits(8);
      int var1;
      if(var0 < Client.npcIndexesCount) {
         for(var1 = var0; var1 < Client.npcIndexesCount; ++var1) {
            Client.field1038[++Client.field1037 - 1] = Client.npcIndices[var1];
         }
      }

      if(var0 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.npcIndices[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.secretPacketBuffer2.getBits(1);
            if(var4 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               var3.field1255 = Client.gameCycle;
            } else {
               int var5 = Client.secretPacketBuffer2.getBits(2);
               if(var5 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
                  var3.field1255 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
                     var3.field1255 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1701(var6, (byte)1);
                     var7 = Client.secretPacketBuffer2.getBits(1);
                     if(var7 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
                     var3.field1255 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1701(var6, (byte)2);
                     var7 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1701(var7, (byte)2);
                     int var8 = Client.secretPacketBuffer2.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field1038[++Client.field1037 - 1] = var2;
                  }
               }
            }
         }

      }
   }
}
