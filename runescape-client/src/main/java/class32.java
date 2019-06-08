import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class32 {
   @ObfuscatedName("u")
   @Export("__ay_u")
   static byte[][][] __ay_u;
   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("scrollBarSprites")
   static IndexedSprite[] scrollBarSprites;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "19"
   )
   static int method576(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = Huffman.getWidget(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
      } else {
         var3 = var2?WorldMapIcon1.__t_i:class12.__n_n;
      }

      class22.method295(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = Canvas.localPlayer.appearance.getChatHeadId();
            return 1;
         } else {
            return 2;
         }
      } else {
         class179.Interpreter_intStackSize -= 2;
         int var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         int var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemDefinition var6 = Skills.getItemDefinition(var4);
         var3.modelAngleX = var6.xan2d;
         var3.modelAngleY = var6.yan2d;
         var3.modelAngleZ = var6.zan2d;
         var3.modelOffsetX = var6.offsetX2d;
         var3.modelOffsetY = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.itemQuantityMode = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.itemQuantityMode = 1;
         } else {
            var3.itemQuantityMode = 2;
         }

         if(var3.__bf > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.__bf;
         } else if(var3.rawWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "972977798"
   )
   static void method578(int var0) {
      Login.loginIndex = 12;
      Login.__cu_aj = var0;
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2095576499"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] + var6 * Tiles.Tiles_heights[var5][var3 + 1][var4] >> 7;
         int var9 = Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] * var6 + Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
