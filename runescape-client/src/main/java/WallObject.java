import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("y")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1125256237
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1830937697
   )
   int field2144;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 619903679
   )
   int field2145;
   @ObfuscatedName("h")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 624100519
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 863334673
   )
   int field2149;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1562757691
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1743061051
   )
   @Export("floor")
   int floor;

   WallObject() {
      this.hash = 0;
      this.field2149 = 0;
   }
}
