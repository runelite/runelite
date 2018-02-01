import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("World")
public class World {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 346681645
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1028183091
   )
   static int field1176;
   @ObfuscatedName("r")
   static int[] field1171;
   @ObfuscatedName("m")
   static int[] field1173;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -730407965
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1925927231
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1034719463
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("v")
   @Export("address")
   String address;
   @ObfuscatedName("n")
   @Export("activity")
   String activity;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1569629871
   )
   @Export("location")
   int location;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -656060853
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1176 = 0;
      field1171 = new int[]{1, 1, 1, 1};
      field1173 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "10221"
   )
   boolean method1608() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2068319035"
   )
   boolean method1609() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1724826342"
   )
   boolean method1610() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1561325175"
   )
   boolean method1611() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "26"
   )
   boolean method1645() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1997065093"
   )
   boolean method1621() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[Lit;",
      garbageValue = "116"
   )
   public static class239[] method1637() {
      return new class239[]{class239.field3227, class239.field3226, class239.field3228, class239.field3234, class239.field3232, class239.field3231, class239.field3229, class239.field3233};
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1098542507"
   )
   static int method1644() {
      return Client.isResized?2:1;
   }
}
