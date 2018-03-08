import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class21 {
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 1018042195
   )
   static int field316;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   static IndexDataBase field315;
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "585263029"
   )
   static int method168(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "1"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
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

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1381655254"
   )
   static void method173() {
      Client.field1072.method2067();
      Client.field1072.packetBuffer.offset = 0;
      Client.field1072.serverPacket = null;
      Client.field1072.field1463 = null;
      Client.field1072.field1457 = null;
      Client.field1072.field1465 = null;
      Client.field1072.packetLength = 0;
      Client.field1072.field1464 = 0;
      Client.field865 = 0;
      UnitPriceComparator.method130();
      Client.field1003 = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      WorldMapData.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field1188 = false;
         }
      }

      UrlRequester.method3085();
      class20.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1051[var0] = true;
      }

      PacketNode var2 = class33.method382(ClientPacket.field2427, Client.field1072.field1456);
      var2.packetBuffer.putByte(SoundTaskDataProvider.method838());
      var2.packetBuffer.putShort(WallObject.canvasWidth);
      var2.packetBuffer.putShort(GameEngine.canvasHeight);
      Client.field1072.method2073(var2);
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1713440619"
   )
   static final void method166(String var0, boolean var1) {
      if(Client.field963) {
         byte var2 = 4;
         int var3 = var2 + 6;
         int var4 = var2 + 6;
         int var5 = class178.font_p12full.method5491(var0, 250);
         int var6 = class178.font_p12full.method5498(var0, 250) * 13;
         Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 0);
         Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 16777215);
         class178.font_p12full.method5504(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
         GameCanvas.method846(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var2 + var6);
         if(var1) {
            KeyFocusListener.rasterProvider.drawFull(0, 0);
         } else {
            ItemContainer.method1148(var3, var4, var5, var6);
         }

      }
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(Lig;I)Ljava/lang/String;",
      garbageValue = "-664294595"
   )
   static String method172(Widget var0) {
      int var2 = GrandExchangeEvent.getWidgetConfig(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }
}
