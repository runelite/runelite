import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("SecureRandomCallable")
public class SecureRandomCallable implements Callable {
   @ObfuscatedName("g")
   @Export("indexedSpriteHeights")
   static int[] indexedSpriteHeights;

   @Export("call")
   @ObfuscatedName("call")
   public Object call() {
      return AttackOption.method2034();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BB)Laq;",
      garbageValue = "64"
   )
   static class27 method1145(byte[] var0) {
      return var0 == null?new class27():new class27(class27.method438(var0).pixels);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lix;",
      garbageValue = "0"
   )
   public static VarpDefinition method1140(int var0) {
      VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarpDefinition.__ix_m.takeRecord(16, var0);
         var1 = new VarpDefinition();
         if(var2 != null) {
            var1.read(new Buffer(var2));
         }

         VarpDefinition.VarpDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(IIII)Lbx;",
      garbageValue = "329127611"
   )
   static final WidgetGroupParent method1143(int var0, int var1, int var2) {
      WidgetGroupParent var3 = new WidgetGroupParent();
      var3.group = var1;
      var3.type = var2;
      Client.widgetGroupParents.put(var3, (long)var0);
      DevicePcmPlayerProvider.method845(var1);
      Widget var4 = Huffman.getWidget(var0);
      class22.method295(var4);
      if(Client.__client_mo != null) {
         class22.method295(Client.__client_mo);
         Client.__client_mo = null;
      }

      int var5;
      int var6;
      for(var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
         if(WorldMapManager.method672(Client.menuOpcodes[var5])) {
            if(var5 < Client.menuOptionsCount - 1) {
               for(var6 = var5; var6 < Client.menuOptionsCount - 1; ++var6) {
                  Client.menuActions[var6] = Client.menuActions[var6 + 1];
                  Client.menuTargetNames[var6] = Client.menuTargetNames[var6 + 1];
                  Client.menuOpcodes[var6] = Client.menuOpcodes[var6 + 1];
                  Client.menuArguments0[var6] = Client.menuArguments0[var6 + 1];
                  Client.menuArguments1[var6] = Client.menuArguments1[var6 + 1];
                  Client.menuArguments2[var6] = Client.menuArguments2[var6 + 1];
                  Client.menuShiftClick[var6] = Client.menuShiftClick[var6 + 1];
               }
            }

            --var5;
            --Client.menuOptionsCount;
         }
      }

      var5 = class214.menuWidth / 2 + class25.menuX;
      var6 = GameShell.menuY;
      int var7 = class2.fontBold12.stringWidth("Choose Option");

      int var8;
      for(var8 = 0; var8 < Client.menuOptionsCount; ++var8) {
         Font var9 = class2.fontBold12;
         String var10;
         if(var8 < 0) {
            var10 = "";
         } else if(Client.menuTargetNames[var8].length() > 0) {
            var10 = Client.menuActions[var8] + " " + Client.menuTargetNames[var8];
         } else {
            var10 = Client.menuActions[var8];
         }

         int var11 = var9.stringWidth(var10);
         if(var11 > var7) {
            var7 = var11;
         }
      }

      var7 += 8;
      var8 = Client.menuOptionsCount * 15 + 22;
      int var12 = var5 - var7 / 2;
      if(var12 + var7 > SoundCache.canvasWidth) {
         var12 = SoundCache.canvasWidth - var7;
      }

      if(var12 < 0) {
         var12 = 0;
      }

      int var13 = var6;
      if(var8 + var6 > Huffman.canvasHeight) {
         var13 = Huffman.canvasHeight - var8;
      }

      if(var13 < 0) {
         var13 = 0;
      }

      class25.menuX = var12;
      GameShell.menuY = var13;
      class214.menuWidth = var7;
      AbstractWorldMapIcon.menuHeight = Client.menuOptionsCount * 15 + 22;
      class39.revalidateWidgetScroll(Widget.widgets[var0 >> 16], var4, false);
      WorldMapSection3.runWidgetOnLoadListener(var1);
      if(Client.rootWidgetGroup != -1) {
         GrandExchangeEvents.method74(Client.rootWidgetGroup, 1);
      }

      return var3;
   }
}
