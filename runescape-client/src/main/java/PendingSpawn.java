import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1514761805
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -867495879
   )
   @Export("hitpoints")
   int hitpoints;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1638947401
   )
   @Export("level")
   int level;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 933472239
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 688588045
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 254753761
   )
   @Export("type")
   int type;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1691008641
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 728175919
   )
   int field1202;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1187795245
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1545939539
   )
   int field1204;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 379511305
   )
   int field1199;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1937424391
   )
   int field1198;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1528066450"
   )
   static final void method1523(int var0, int var1) {
      if(WorldMapData.loadWidget(var0)) {
         FileOnDisk.method2424(class215.widgets[var0], var1);
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(ILhg;ZI)V",
      garbageValue = "758013774"
   )
   static void method1524(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = Ignore.method1102().method5319(var0);
      int var4 = class66.localPlayer.field908;
      int var5 = (class66.localPlayer.x >> 7) + class22.baseX;
      int var6 = (class66.localPlayer.y >> 7) + class273.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      Ignore.method1102().method5309(var3, var7, var1, var2);
   }
}
