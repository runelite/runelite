import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("World")
public class World {
   @ObfuscatedName("s")
   static int[] field1265;
   @ObfuscatedName("o")
   @Export("activity")
   String activity;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1601404905
   )
   static int field1267;
   @ObfuscatedName("p")
   static int[] field1269;
   @ObfuscatedName("l")
   static int[] field1270;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -233045949
   )
   @Export("location")
   int location;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1643201497
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1798757137
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2095509811
   )
   static int field1274;
   @ObfuscatedName("x")
   @Export("address")
   String address;
   @ObfuscatedName("g")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 286418449
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1012938461
   )
   @Export("index")
   int index;
   @ObfuscatedName("a")
   @Export("worldServersDownload")
   static class77 worldServersDownload;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1994888237"
   )
   boolean method1549() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "23"
   )
   boolean method1551() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2123704527"
   )
   boolean method1552() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "16777215"
   )
   boolean method1554() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-1"
   )
   boolean method1555() {
      return (33554432 & this.mask) != 0;
   }

   static {
      field1267 = 0;
      field1274 = 0;
      field1269 = new int[]{1, 1, 1, 1};
      field1270 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-18"
   )
   boolean method1581() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "303645101"
   )
   static void method1589() {
      if(class92.field1427) {
         class92.field1417 = null;
         class92.field1425 = null;
         class29.field419 = null;
         class92.field1429 = null;
         class269.field3672 = null;
         class268.field3670 = null;
         class89.field1392 = null;
         class92.field1420 = null;
         class56.field676 = null;
         RSSocket.field2257 = null;
         Buffer.field2378 = null;
         class45.field584 = null;
         class100.field1544 = null;
         class38.field518 = null;
         field1265 = null;
         class24.field365 = null;
         class2.field10 = null;
         class30.field430 = null;
         class30.field437 = null;
         Preferences.field1289 = null;
         class5.field33 = null;
         GroundObject.field1847 = null;
         class203.field2498 = 1;
         Varbit.field3380 = null;
         class169.field2325 = -1;
         class203.field2499 = -1;
         class203.field2500 = 0;
         class203.field2495 = false;
         class203.field2501 = 2;
         class91.method1753(true);
         class92.field1427 = false;
      }
   }
}
