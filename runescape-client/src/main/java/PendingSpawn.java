import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ba")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1413607325
   )
   @Export("level")
   int level;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1605801173
   )
   @Export("type")
   int type;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -648847431
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -618971971
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1381264453
   )
   int field1086;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1422644555
   )
   int field1084;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1337597503
   )
   int field1087;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1911054443
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1932966413
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1133220707
   )
   int field1091;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -449999493
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 535192139
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }
}
