import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 95714405
   )
   @Export("level")
   int level;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1724493673
   )
   @Export("type")
   int type;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1709586751
   )
   @Export("x")
   int x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1761598365
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 358825331
   )
   int field1146;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1381981335
   )
   int field1144;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2020228435
   )
   int field1147;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1399791223
   )
   @Export("id")
   int id;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -734959189
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1997658261
   )
   int field1151;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1527742399
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1268965623
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(IIB)Ljava/lang/String;",
      garbageValue = "44"
   )
   static final String method1653(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class45.getColTags(16711680):(var2 < -6?class45.getColTags(16723968):(var2 < -3?class45.getColTags(16740352):(var2 < 0?class45.getColTags(16756736):(var2 > 9?class45.getColTags(65280):(var2 > 6?class45.getColTags(4259584):(var2 > 3?class45.getColTags(8453888):(var2 > 0?class45.getColTags(12648192):class45.getColTags(16776960))))))));
   }
}
