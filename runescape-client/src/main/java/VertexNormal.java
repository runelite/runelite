import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ck")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1505751437
   )
   @Export("z")
   int z;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1693441887
   )
   @Export("y")
   int y;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = -290052983
   )
   static int field1422;
   @ObfuscatedName("dc")
   static int[] field1423;
   @ObfuscatedName("hm")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 112959441
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1501445213
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   VertexNormal() {
   }
}
