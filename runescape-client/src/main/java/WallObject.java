import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1026439337
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 250389927
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1224481941
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -42744479
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1583577277
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1451217133
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2102429845
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }
}
