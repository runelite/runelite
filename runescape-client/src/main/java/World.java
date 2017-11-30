import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("World")
public class World {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2073723129
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1724680161
   )
   static int field1196;
   @ObfuscatedName("f")
   static int[] field1197;
   @ObfuscatedName("g")
   static int[] field1203;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -404484463
   )
   @Export("id")
   int id;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1198421041
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2015743543
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("n")
   @Export("address")
   String address;
   @ObfuscatedName("y")
   @Export("activity")
   String activity;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 614439421
   )
   @Export("location")
   int location;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1567307001
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1196 = 0;
      field1197 = new int[]{1, 1, 1, 1};
      field1203 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2143679429"
   )
   boolean method1518() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "649347417"
   )
   boolean method1494() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-48"
   )
   boolean method1495() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2028000626"
   )
   boolean method1496() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1868845426"
   )
   boolean method1497() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-279717715"
   )
   boolean method1498() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("a")
   public static final void method1500(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            Coordinates.method4079(var0 - 1L);
            Coordinates.method4079(1L);
         } else {
            Coordinates.method4079(var0);
         }

      }
   }
}
