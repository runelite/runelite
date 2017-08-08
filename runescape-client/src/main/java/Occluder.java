import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1696982837
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -622695179
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1388035847
   )
   @Export("type")
   int type;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1553340709
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2080141783
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 439699487
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2071800707
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1428854653
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -870399035
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -713526291
   )
   int field2137;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1936023033
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 762171611
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1912887507
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1111985889
   )
   int field2147;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 369130017
   )
   @Export("maxNormalY")
   int maxNormalY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 61504075
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -715996847
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1015254663
   )
   @Export("maxTIleX")
   int maxTIleX;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "73"
   )
   static void method2932(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[Lhb;",
      garbageValue = "-1521001446"
   )
   static BuildType[] method2933() {
      return new BuildType[]{BuildType.LIVE, BuildType.RC, BuildType.WIP, BuildType.BUILD_LIVE};
   }
}
