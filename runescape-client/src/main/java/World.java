import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("World")
public class World {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1441135927
   )
   @Export("index")
   int index;
   @ObfuscatedName("f")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("g")
   static int[] field674 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1543643073
   )
   static int field675 = 0;
   @ObfuscatedName("l")
   static int[] field676 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 911079867
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -667360259
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1923340923
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("e")
   @Export("address")
   String address;
   @ObfuscatedName("v")
   @Export("activity")
   String activity;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -111847025
   )
   @Export("location")
   int location;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2009384227
   )
   static int field684 = 0;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "644053701"
   )
   boolean method625() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-81"
   )
   boolean method628() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "50"
   )
   boolean method631() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1728384831"
   )
   boolean method636() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "44"
   )
   boolean method637() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "2"
   )
   boolean method646() {
      return (536870912 & this.mask) != 0;
   }
}
