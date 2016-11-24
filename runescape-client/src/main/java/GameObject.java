import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -798284263
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 106445167
   )
   @Export("height")
   int height;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 346045527
   )
   int field1607;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1354109553
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("r")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1510498863
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2075121531
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2022663835
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 413342319
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("gi")
   static Widget field1614;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1256878239
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1972867215
   )
   int field1616;
   @ObfuscatedName("bf")
   protected static FontMetrics field1617;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1236827843
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1547666659
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1889347051
   )
   @Export("x")
   int x;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "88"
   )
   public static void method1952() {
      if(class115.mouse != null) {
         class115 var0 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

   }
}
