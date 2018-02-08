import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("w")
   @Export("audioHighMemory")
   protected static boolean audioHighMemory;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -384100837
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1262475693
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -203450663
   )
   @Export("health")
   int health;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1737028501
   )
   @Export("int2")
   int int2;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "27"
   )
   @Export("set")
   void set(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;I)I",
      garbageValue = "-713330115"
   )
   static int method1616(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.tryLoadRecordByNames("title.jpg", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("logo", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("titlebox", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("titlebutton", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("runes", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("title_mute", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,2", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,4", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,6", "")) {
         ++var2;
      }

      var1.tryLoadRecordByNames("sl_back", "");
      var1.tryLoadRecordByNames("sl_flags", "");
      var1.tryLoadRecordByNames("sl_arrows", "");
      var1.tryLoadRecordByNames("sl_stars", "");
      var1.tryLoadRecordByNames("sl_button", "");
      return var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "116"
   )
   static void method1618() {
      FileOnDisk var0 = null;

      try {
         var0 = VertexNormal.getPreferencesFile("", AbstractSoundSystem.field1553.name, true);
         Buffer var1 = WorldComparator.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILcf;ZB)I",
      garbageValue = "-64"
   )
   static int method1619(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class216.getWidget(class80.intStack[--class80.intStackSize]);
      } else {
         var3 = var2?class94.field1418:ItemLayer.field1668;
      }

      class33.method341(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class80.intStack[--class80.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = GroundObject.localPlayer.composition.method4385();
            return 1;
         } else {
            return 2;
         }
      } else {
         class80.intStackSize -= 2;
         int var4 = class80.intStack[class80.intStackSize];
         int var5 = class80.intStack[class80.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = ItemContainer.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2777 = var6.offsetX2d;
         var3.field2864 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2862 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2862 = 1;
         } else {
            var3.field2862 = 2;
         }

         if(var3.field2809 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2809;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }
}
