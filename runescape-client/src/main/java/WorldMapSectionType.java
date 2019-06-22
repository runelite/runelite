import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("WorldMapSectionType")
public enum WorldMapSectionType implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   @Export("__h_m")
   __h_m(1, (byte)0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   @Export("__h_f")
   __h_f(0, (byte)1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   @Export("__h_q")
   __h_q(3, (byte)2),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   @Export("__h_w")
   __h_w(2, (byte)3);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("__h_e")
   static IndexedSprite __h_e;
   @ObfuscatedName("n")
   @Export("__h_n")
   static int[] __h_n;
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
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("m")
   public static String method252(long var0) {
      class211.__hg_q.setTime(new Date(var0));
      int var2 = class211.__hg_q.get(7);
      int var3 = class211.__hg_q.get(5);
      int var4 = class211.__hg_q.get(2);
      int var5 = class211.__hg_q.get(1);
      int var6 = class211.__hg_q.get(11);
      int var7 = class211.__hg_q.get(12);
      int var8 = class211.__hg_q.get(13);
      return class211.__hg_f[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class211.__hg_m[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "2102950996"
   )
   static void method248(int var0, boolean var1, int var2, boolean var3) {
      if(ItemContainer.worlds != null) {
         class3.method42(0, ItemContainer.worlds.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-1520594673"
   )
   static int method253(int var0, Script var1, boolean var2) {
      Widget var3 = var2?WorldMapIcon1.__t_i:class12.__n_n;
      if(var0 == 1500) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.x;
         return 1;
      } else if(var0 == 1501) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.y;
         return 1;
      } else if(var0 == 1502) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.parentId;
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
      if(class60.worldMap0 != null) {
         class60.worldMap0.__a_525(SoundSystem.plane, (Canvas.localPlayer.x >> 7) + class50.baseX, (Canvas.localPlayer.y >> 7) + GraphicsObject.baseY, false);
         class60.worldMap0.loadCache();
      }

   }
}
