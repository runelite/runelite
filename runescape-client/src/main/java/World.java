import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("World")
public class World {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 89290177
   )
   @Export("index")
   int index;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1039387333
   )
   static int field672 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1160984473
   )
   static int field673 = 0;
   @ObfuscatedName("q")
   static int[] field674 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1810942875
   )
   @Export("location")
   int location;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -415118299
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -639847853
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("w")
   static int[] field678 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("c")
   @Export("address")
   String address;
   @ObfuscatedName("m")
   @Export("activity")
   String activity;
   @ObfuscatedName("mp")
   static byte field683;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 750938385
   )
   @Export("id")
   int id;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-101"
   )
   boolean method591() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "95"
   )
   boolean method592() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-712487879"
   )
   boolean method593() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "928432529"
   )
   boolean method595() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "948815824"
   )
   boolean method596() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1893532728"
   )
   boolean method620() {
      return (8 & this.mask) != 0;
   }
}
