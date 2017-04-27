import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
final class class6 implements Comparator {
   @ObfuscatedName("ns")
   static class57 field56;
   @ObfuscatedName("d")
   static IndexDataBase field57;

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2082807321"
   )
   static final void method78() {
      for(class25 var0 = (class25)Client.field415.method2828(); var0 != null; var0 = (class25)Client.field415.method2830()) {
         if(var0.field582 > 0) {
            --var0.field582;
         }

         if(var0.field582 == 0) {
            if(var0.field575 < 0 || class15.method189(var0.field575, var0.field576)) {
               class166.method3137(var0.field579, var0.field572, var0.field573, var0.field574, var0.field575, var0.field585, var0.field576);
               var0.unlink();
            }
         } else {
            if(var0.field581 > 0) {
               --var0.field581;
            }

            if(var0.field581 == 0 && var0.field573 >= 1 && var0.field574 >= 1 && var0.field573 <= 102 && var0.field574 <= 102 && (var0.field577 < 0 || class15.method189(var0.field577, var0.field580))) {
               class166.method3137(var0.field579, var0.field572, var0.field573, var0.field574, var0.field577, var0.field578, var0.field580);
               var0.field581 = -1;
               if(var0.field577 == var0.field575 && var0.field575 == -1) {
                  var0.unlink();
               } else if(var0.field577 == var0.field575 && var0.field585 == var0.field578 && var0.field576 == var0.field580) {
                  var0.unlink();
               }
            }
         }
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method83((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "2025575360"
   )
   int method83(class2 var1, class2 var2) {
      return var1.method25().compareTo(var2.method25());
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1003"
   )
   static final void method88() {
      int var0;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(class112.method2112(var0)) {
            class85.method1715(class133.widgets[var0], -1);
         }
      }

      for(var0 = 0; var0 < Client.field490; ++var0) {
         if(Client.field368[var0]) {
            Client.field491[var0] = true;
         }

         Client.field452[var0] = Client.field368[var0];
         Client.field368[var0] = false;
      }

      Client.field385 = Client.gameCycle;
      Client.field433 = -1;
      Client.field546 = -1;
      class9.field83 = null;
      if(Client.widgetRoot != -1) {
         Client.field490 = 0;
         class210.method4010(Client.widgetRoot, 0, 0, class187.field2760, IndexDataBase.field2726, 0, 0, -1);
      }

      Rasterizer2D.method4082();
      if(!Client.isMenuOpen) {
         if(Client.field433 != -1) {
            Frames.method1911(Client.field433, Client.field546);
         }
      } else {
         var0 = Player.menuX;
         int var1 = class1.menuY;
         int var2 = MessageNode.menuWidth;
         int var3 = class201.menuHeight;
         int var4 = 6116423;
         Rasterizer2D.method4089(var0, var1, var2, var3, var4);
         Rasterizer2D.method4089(var0 + 1, var1 + 1, var2 - 2, 16, 0);
         Rasterizer2D.method4095(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
         TextureProvider.field1192.method3914("Choose Option", var0 + 3, var1 + 14, var4, -1);
         int var5 = class115.field1805;
         int var6 = class115.field1806;

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
            var8 = var1 + 31 + (Client.menuOptionCount - 1 - var7) * 15;
            var9 = 16777215;
            if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
               var9 = 16776960;
            }

            TextureProvider.field1192.method3914(class13.method179(var7), var0 + 3, var8, var9, 0);
         }

         var7 = Player.menuX;
         var8 = class1.menuY;
         var9 = MessageNode.menuWidth;
         int var10 = class201.menuHeight;

         for(int var11 = 0; var11 < Client.field490; ++var11) {
            if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var7 && Client.widgetPositionX[var11] < var7 + var9 && Client.widgetPositionY[var11] + Client.widgetBoundsHeight[var11] > var8 && Client.widgetPositionY[var11] < var8 + var10) {
               Client.field491[var11] = true;
            }
         }
      }

      if(Client.field382 == 3) {
         for(var0 = 0; var0 < Client.field490; ++var0) {
            if(Client.field452[var0]) {
               Rasterizer2D.method4101(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field491[var0]) {
               Rasterizer2D.method4101(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      class172.method3254(Client.plane, class22.localPlayer.x, class22.localPlayer.y, Client.field358);
      Client.field358 = 0;
   }
}
