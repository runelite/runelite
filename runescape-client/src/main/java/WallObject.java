import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "Lcm;"
   )
   @Export("friendManager")
   public static FriendManager friendManager;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2078365009
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2010478009
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1193963097
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 26289205
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1592459735
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1633049955
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -826855037
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -652106925
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }
}
