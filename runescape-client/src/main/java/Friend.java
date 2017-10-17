import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("bu")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   static Font field827;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 1662848585
   )
   static int field819;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1441617225
   )
   @Export("world")
   int world;
   @ObfuscatedName("q")
   boolean field823;
   @ObfuscatedName("s")
   boolean field825;
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("k")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 588292223
   )
   @Export("rank")
   int rank;

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-70"
   )
   static void method1135(int var0) {
      Client.field1126 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      if(class19.method142() == 1) {
         PendingSpawn.clientInstance.method872(765, 503);
      } else {
         PendingSpawn.clientInstance.method872(7680, 2160);
      }

      if(Client.gameState >= 25) {
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_RESIZE_CLIENT_FRAME);
         Client.secretPacketBuffer1.putByte(class19.method142());
         Client.secretPacketBuffer1.putShort(class60.canvasWidth);
         Client.secretPacketBuffer1.putShort(class48.canvasHeight);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "-1366937058"
   )
   static int method1133(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class81.intStack[--class81.intStackSize];
         var4 = PacketBuffer.method3528(var3);
      } else {
         var4 = var2?class81.field1341:class81.field1340;
      }

      if(var0 == 1000) {
         class81.intStackSize -= 4;
         var4.originalX = class81.intStack[class81.intStackSize];
         var4.originalY = class81.intStack[class81.intStackSize + 1];
         var4.field2645 = class81.intStack[class81.intStackSize + 2];
         var4.field2664 = class81.intStack[class81.intStackSize + 3];
         class25.method172(var4);
         PendingSpawn.clientInstance.method1312(var4);
         if(var3 != -1 && var4.type == 0) {
            BaseVarType.method17(class177.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class81.intStackSize -= 4;
         var4.originalWidth = class81.intStack[class81.intStackSize];
         var4.field2670 = class81.intStack[class81.intStackSize + 1];
         var4.field2665 = class81.intStack[class81.intStackSize + 2];
         var4.buttonType = class81.intStack[class81.intStackSize + 3];
         class25.method172(var4);
         PendingSpawn.clientInstance.method1312(var4);
         if(var3 != -1 && var4.type == 0) {
            BaseVarType.method17(class177.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class81.intStack[--class81.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class25.method172(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2791 = class81.intStack[--class81.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2792 = class81.intStack[--class81.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method1137() {
      for(int var0 = 0; var0 < Client.field1154; ++var0) {
         --Client.field1157[var0];
         if(Client.field1157[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(BaseVarType.field34, Client.field1155[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.field1157[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.field1157[var0] < 0) {
               int var2;
               if(Client.field1158[var0] != 0) {
                  int var3 = (Client.field1158[var0] & 255) * 128;
                  int var4 = Client.field1158[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - AbstractByteBuffer.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field1158[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - AbstractByteBuffer.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     Client.field1157[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field1114 / var3;
               } else {
                  var2 = Client.field942;
               }

               if(var2 > 0) {
                  class105 var10 = var9.method2011().method2053(Renderable.field2113);
                  class115 var11 = class115.method2201(var10, 100, var2);
                  var11.method2346(Client.field1156[var0] - 1);
                  CombatInfoListHolder.field1364.method1979(var11);
               }

               Client.field1157[var0] = -100;
            }
         } else {
            --Client.field1154;

            for(int var1 = var0; var1 < Client.field1154; ++var1) {
               Client.field1155[var1] = Client.field1155[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.field1156[var1] = Client.field1156[var1 + 1];
               Client.field1157[var1] = Client.field1157[var1 + 1];
               Client.field1158[var1] = Client.field1158[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1151) {
         boolean var12;
         if(class203.field2521 != 0) {
            var12 = true;
         } else {
            var12 = class203.field2523.method3870();
         }

         if(!var12) {
            if(Client.field976 != 0 && Client.field1086 != -1) {
               IndexFile.method3094(class268.indexTrack1, Client.field1086, 0, Client.field976, false);
            }

            Client.field1151 = false;
         }
      }

   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)Lke;",
      garbageValue = "-1401715633"
   )
   static RenderOverview method1134() {
      return GameObject.renderOverview;
   }
}
