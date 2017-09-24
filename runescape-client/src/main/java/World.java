import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("World")
public class World {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -988849025
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1662797877
   )
   static int field1301;
   @ObfuscatedName("b")
   static int[] field1302;
   @ObfuscatedName("k")
   static int[] field1303;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lcp;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   static Task field1297;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 442704637
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2022377843
   )
   @Export("index")
   int index;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1516610333
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1321589381
   )
   @Export("id")
   int id;
   @ObfuscatedName("y")
   @Export("address")
   String address;
   @ObfuscatedName("v")
   @Export("activity")
   String activity;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1380991793
   )
   @Export("location")
   int location;

   static {
      worldCount = 0;
      field1301 = 0;
      field1302 = new int[]{1, 1, 1, 1};
      field1303 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2084643708"
   )
   boolean method1550() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-127"
   )
   boolean method1551() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "579502015"
   )
   boolean method1554() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-535982847"
   )
   boolean method1552() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-23"
   )
   boolean method1553() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2130023127"
   )
   boolean method1556() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1027042520"
   )
   public static String method1586(CharSequence var0) {
      String var1 = class252.method4440(class221.method4087(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }
}
