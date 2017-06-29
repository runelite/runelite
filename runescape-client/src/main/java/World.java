import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("World")
public class World {
   @ObfuscatedName("s")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1589696071
   )
   static int field1309;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2098490881
   )
   static int field1310;
   @ObfuscatedName("k")
   @Export("worldServersDownload")
   static class77 worldServersDownload;
   @ObfuscatedName("j")
   static int[] field1312;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 917448495
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1604665787
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1375983603
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("l")
   @Export("address")
   String address;
   @ObfuscatedName("y")
   static int[] field1318;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -615678529
   )
   @Export("location")
   int location;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1727811119
   )
   @Export("index")
   int index;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 440944993
   )
   static int field1321;
   @ObfuscatedName("ea")
   static Font field1322;
   @ObfuscatedName("c")
   @Export("activity")
   String activity;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "41"
   )
   boolean method1565() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1169534180"
   )
   boolean method1566() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1069686959"
   )
   boolean method1567() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "732834487"
   )
   public static int method1568(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "10"
   )
   boolean method1569() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1964107651"
   )
   boolean method1571() {
      return (33554432 & this.mask) != 0;
   }

   static {
      field1309 = 0;
      field1310 = 0;
      field1318 = new int[]{1, 1, 1, 1};
      field1312 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-282428090"
   )
   boolean method1577() {
      return (536870912 & this.mask) != 0;
   }
}
