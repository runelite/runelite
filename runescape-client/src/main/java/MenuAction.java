import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("MenuAction")
public class MenuAction {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -2062450631
   )
   @Export("selectedItemId")
   static int selectedItemId;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 305977315
   )
   @Export("argument1")
   int argument1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1764645917
   )
   @Export("argument2")
   int argument2;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1483856253
   )
   @Export("opcode")
   int opcode;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2057883817
   )
   @Export("argument0")
   int argument0;
   @ObfuscatedName("o")
   @Export("action")
   String action;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lir;Ljava/lang/String;Ljava/lang/String;B)Llq;",
      garbageValue = "0"
   )
   public static IndexedSprite method2025(AbstractIndexCache var0, String var1, String var2) {
      int var3 = var0.getArchiveId(var1);
      int var4 = var0.getRecordId(var3, var2);
      IndexedSprite var5;
      if(!SpriteMask.method4392(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = ServerPacket.method3663();
      }

      return var5;
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(Lbx;ZI)V",
      garbageValue = "1537219807"
   )
   @Export("closeWidgetGroup")
   static final void closeWidgetGroup(WidgetGroupParent var0, boolean var1) {
      int var2 = var0.group;
      int var3 = (int)var0.key;
      var0.remove();
      if(var1) {
         AbstractByteArrayCopier.method4023(var2);
      }

      for(IntegerNode var4 = (IntegerNode)Client.widgetClickMasks.first(); var4 != null; var4 = (IntegerNode)Client.widgetClickMasks.next()) {
         if((long)var2 == (var4.key >> 48 & 65535L)) {
            var4.remove();
         }
      }

      Widget var12 = Huffman.getWidget(var3);
      if(var12 != null) {
         class22.method295(var12);
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
      int var13 = var5 - var7 / 2;
      if(var7 + var13 > SoundCache.canvasWidth) {
         var13 = SoundCache.canvasWidth - var7;
      }

      if(var13 < 0) {
         var13 = 0;
      }

      int var14 = var6;
      if(var6 + var8 > Huffman.canvasHeight) {
         var14 = Huffman.canvasHeight - var8;
      }

      if(var14 < 0) {
         var14 = 0;
      }

      class25.menuX = var13;
      GameShell.menuY = var14;
      class214.menuWidth = var7;
      AbstractWorldMapIcon.menuHeight = Client.menuOptionsCount * 15 + 22;
      if(Client.rootWidgetGroup != -1) {
         GrandExchangeEvents.method74(Client.rootWidgetGroup, 1);
      }

   }
}
