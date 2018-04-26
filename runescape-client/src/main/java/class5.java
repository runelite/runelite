import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
final class class5 implements class0 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lce;",
      garbageValue = "1058170261"
   )
   static Preferences method17() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = BaseVarType.getPreferencesFile("", TotalQuantityComparator.field296.name, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new Preferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "798971723"
   )
   static void method15() {
      Client.field911.method2133();
      Client.field911.packetBuffer.offset = 0;
      Client.field911.serverPacket = null;
      Client.field911.field1467 = null;
      Client.field911.field1468 = null;
      Client.field911.field1458 = null;
      Client.field911.packetLength = 0;
      Client.field911.field1465 = 0;
      Client.field869 = 0;
      class3.method6();
      Client.field1082 = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      class265.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field1167 = false;
         }
      }

      ItemContainer.itemContainers = new HashTable(32);
      class55.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1055[var0] = true;
      }

      DState.method3580();
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "-10"
   )
   static final void method16(String var0, boolean var1) {
      if(Client.field964) {
         byte var2 = 4;
         int var3 = var2 + 6;
         int var4 = var2 + 6;
         int var5 = class249.font_p12full.method5567(var0, 250);
         int var6 = class249.font_p12full.method5564(var0, 250) * 13;
         Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
         Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 16777215);
         class249.font_p12full.method5574(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
         class22.method177(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2);
         if(var1) {
            GrandExchangeOffer.rasterProvider.drawFull(0, 0);
         } else {
            int var7 = var3;
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;

            for(int var11 = 0; var11 < Client.widgetCount; ++var11) {
               if(Client.widgetBoundsWidth[var11] + Client.widgetPositionX[var11] > var7 && Client.widgetPositionX[var11] < var7 + var9 && Client.widgetBoundsHeight[var11] + Client.widgetPositionY[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
                  Client.field1056[var11] = true;
               }
            }
         }

      }
   }
}
