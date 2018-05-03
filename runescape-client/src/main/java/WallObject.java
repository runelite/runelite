import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1450973753
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 608095191
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1736257049
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1366493753
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1628836049
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1381078801
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1901388871
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }
}
