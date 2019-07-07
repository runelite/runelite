import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("h")
@Implements("WorldMapSectionType")
public enum WorldMapSectionType implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   field1100(1, (byte)0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   field1101(0, (byte)1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   field1102(3, (byte)2),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   field1103(2, (byte)3);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("n")
   static int[] field1104;
   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 738759853
   )
   @Export("type")
   final int type;
   @ObfuscatedName("u")
   @Export("id")
   final byte id;

   private WorldMapSectionType(int var3, byte var4) {
      this.type = var3;
      this.id = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("m")
   public static String method252(long var0) {
      class211.field1126.setTime(new Date(var0));
      int var2 = class211.field1126.get(7);
      int var3 = class211.field1126.get(5);
      int var4 = class211.field1126.get(2);
      int var5 = class211.field1126.get(1);
      int var6 = class211.field1126.get(11);
      int var7 = class211.field1126.get(12);
      int var8 = class211.field1126.get(13);
      return class211.field1125[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class211.field1124[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "2102950996"
   )
   @Export("sortWorlds")
   static void sortWorlds(int primaryMode, boolean primaryReversed, int secondaryMode, boolean secondaryReversed) {
      if (ItemContainer.worlds != null) {
         class3.doWorldSorting(0, ItemContainer.worlds.length - 1, primaryMode, primaryReversed, secondaryMode, secondaryReversed);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-1520594673"
   )
   static int method253(int var0, Script var1, boolean var2) {
      Widget var3 = var2 ? WorldMapIcon1.field1030 : GrandExchangeOfferAgeComparator.field1111;
      if (var0 == ScriptOpcodes.CC_GETX) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.x;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETY) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.y;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETWIDTH) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.width;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETHEIGHT) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.height;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETHIDE) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETLAYER) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1187868759"
   )
   static void method254() {
      if (class60.worldMap0 != null) {
         class60.worldMap0.method366(SoundSystem.plane, (Canvas.localPlayer.x >> 7) + class50.baseX, (Canvas.localPlayer.y >> 7) + GraphicsObject.baseY, false);
         class60.worldMap0.loadCache();
      }

   }
}
