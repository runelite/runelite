import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dj")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("e")
   public static IndexDataBase field1876;
   @ObfuscatedName("t")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1729518895
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -556975977
   )
   @Export("x")
   int x;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 296556157
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1265403133
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1268514035
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
}
