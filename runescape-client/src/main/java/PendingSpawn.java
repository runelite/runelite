import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1051628215
   )
   public static int field1146;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -307529097
   )
   static int field1145;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("scrollbarSprites")
   static IndexedSprite[] scrollbarSprites;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 979197913
   )
   @Export("level")
   int level;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1073346127
   )
   @Export("type")
   int type;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -438486631
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -650060595
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -754109851
   )
   int field1137;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 121153031
   )
   int field1138;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1796400831
   )
   int field1134;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 96829491
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 291338857
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -641602395
   )
   int field1142;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2105868869
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1885525981
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Lfm;",
      garbageValue = "-115"
   )
   public static Timer method1581() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1396819319"
   )
   static int method1582(int var0, Script var1, boolean var2) {
      Widget var3 = class3.getWidget(class81.intStack[--SceneTilePaint.intStackSize]);
      if(var0 == 2800) {
         int[] var4 = class81.intStack;
         int var5 = ++SceneTilePaint.intStackSize - 1;
         int var7 = class45.getWidgetClickMask(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.opBase == null) {
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
            } else {
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = var3.opBase;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class81.intStack[--SceneTilePaint.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class81.scriptStringStack[++World.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
