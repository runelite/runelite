import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("World")
public class class25 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2076214963
   )
   static int field627 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2110543773
   )
   static int field633 = 0;
   @ObfuscatedName("x")
   @Export("worldList")
   static class25[] field635;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -849353309
   )
   @Export("id")
   int field636;
   @ObfuscatedName("z")
   @Export("address")
   String field637;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 559524617
   )
   @Export("playerCount")
   int field638;
   @ObfuscatedName("l")
   static int[] field639 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1511044617
   )
   @Export("mask")
   int field640;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1096924553
   )
   @Export("location")
   int field641;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 878178793
   )
   @Export("index")
   int field642;
   @ObfuscatedName("cu")
   public static char field644;
   @ObfuscatedName("k")
   @Export("activity")
   String field646;
   @ObfuscatedName("c")
   static int[] field647 = new int[]{1, 1, 1, 1};

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "90"
   )
   boolean method594() {
      return (8 & this.field640) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "127"
   )
   boolean method599() {
      return (2 & this.field640) != 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-10"
   )
   boolean method600() {
      return (33554432 & this.field640) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "115"
   )
   boolean method611() {
      return (4 & this.field640) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "64310159"
   )
   boolean method614() {
      return (536870912 & this.field640) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "551256162"
   )
   boolean method627() {
      return (1 & this.field640) != 0;
   }
}
