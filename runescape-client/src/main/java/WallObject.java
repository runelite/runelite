import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1706154965
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 455590419
   )
   @Export("config")
   int config;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1612427993
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1307075903
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -820667805
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -374113805
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2139522617
   )
   @Export("orientationB")
   int orientationB;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }
}
