import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1465975205
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 775897375
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1530199991
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1076621313
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1753048791
   )
   @Export("x")
   int x;

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1658773319"
   )
   static void method1547(int var0, int var1, int var2) {
      if(Client.field518 != 0 && var1 != 0 && Client.field461 < 50) {
         Client.field473[Client.field461] = var0;
         Client.field522[Client.field461] = var1;
         Client.field533[Client.field461] = var2;
         Client.field400[Client.field461] = null;
         Client.field524[Client.field461] = 0;
         ++Client.field461;
      }

   }
}
