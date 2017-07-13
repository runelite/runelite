import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class73 extends class163 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1551947391
   )
   public static int field861;
   @ObfuscatedName("z")
   static int[] field864;
   @ObfuscatedName("fs")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "1809467862"
   )
   public boolean vmethod3052(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2308 && var3 == super.field2311;
   }
}
