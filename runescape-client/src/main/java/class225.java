import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class225 {
   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1567594961"
   )
   static final void method3982() {
      Client.secretPacketBuffer2.bitAccess();
      int var0 = Client.secretPacketBuffer2.getBits(8);
      int var1;
      if(var0 < Client.field953) {
         for(var1 = var0; var1 < Client.field953; ++var1) {
            Client.field1028[++Client.field1027 - 1] = Client.npcIndices[var1];
         }
      }

      if(var0 > Client.field953) {
         throw new RuntimeException("");
      } else {
         Client.field953 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.npcIndices[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.secretPacketBuffer2.getBits(1);
            if(var4 == 0) {
               Client.npcIndices[++Client.field953 - 1] = var2;
               var3.field1258 = Client.gameCycle;
            } else {
               int var5 = Client.secretPacketBuffer2.getBits(2);
               if(var5 == 0) {
                  Client.npcIndices[++Client.field953 - 1] = var2;
                  var3.field1258 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.npcIndices[++Client.field953 - 1] = var2;
                     var3.field1258 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1633(var6, (byte)1);
                     var7 = Client.secretPacketBuffer2.getBits(1);
                     if(var7 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.npcIndices[++Client.field953 - 1] = var2;
                     var3.field1258 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1633(var6, (byte)2);
                     var7 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1633(var7, (byte)2);
                     int var8 = Client.secretPacketBuffer2.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field1028[++Client.field1027 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2023787431"
   )
   public static void method3980(boolean var0) {
      if(var0 != IndexFile.isMembersWorld) {
         class169.method3060();
         IndexFile.isMembersWorld = var0;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "722538314"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
