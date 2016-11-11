import java.awt.Font;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("World")
public class World {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1136044339
   )
   static int field665 = 0;
   @ObfuscatedName("r")
   @Export("activity")
   String activity;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 52776781
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("l")
   static int[] field671 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("bp")
   static class171 field672;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -299393069
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -839169713
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("v")
   @Export("address")
   String address;
   @ObfuscatedName("j")
   @Export("worldServersDownload")
   static class18 worldServersDownload;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 434804219
   )
   @Export("location")
   int location;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -755185377
   )
   @Export("index")
   int index;
   @ObfuscatedName("m")
   static int[] field681 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("nb")
   static class59 field683;
   @ObfuscatedName("qp")
   protected static Font field684;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 107421481
   )
   static int field685 = 0;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "43"
   )
   public static boolean method592(int var0) {
      return (var0 & 1) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-101"
   )
   boolean method593() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-810858097"
   )
   boolean method596() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "796859781"
   )
   boolean method597() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1565217407"
   )
   boolean method598() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-8"
   )
   boolean method617() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1200800173"
   )
   boolean method622() {
      return (4 & this.mask) != 0;
   }
}
