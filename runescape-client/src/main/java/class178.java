import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fi")
public class class178 {
   @ObfuscatedName("q")
   @Export("directions")
   static int[][] directions;
   @ObfuscatedName("w")
   @Export("distances")
   static int[][] distances;
   @ObfuscatedName("l")
   @Export("bufferX")
   static int[] bufferX;
   @ObfuscatedName("e")
   @Export("bufferY")
   static int[] bufferY;

   static {
      directions = new int[128][128];
      distances = new int[128][128];
      bufferX = new int[4096];
      bufferY = new int[4096];
   }
}
