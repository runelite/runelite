import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("World")
public class World {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Lbq;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 179057345
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1888432395
   )
   static int field1210;
   @ObfuscatedName("s")
   static int[] field1211;
   @ObfuscatedName("p")
   static int[] field1209;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   @Export("listFetcher")
   static UrlRequest listFetcher;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1726897895
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1491163597
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -917981355
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("i")
   @Export("address")
   String address;
   @ObfuscatedName("u")
   @Export("activity")
   String activity;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 113733003
   )
   @Export("location")
   int location;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -802537259
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1210 = 0;
      field1211 = new int[]{1, 1, 1, 1};
      field1209 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "369553371"
   )
   boolean method1653() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-99"
   )
   boolean method1654() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "805712621"
   )
   boolean method1655() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-20"
   )
   boolean method1672() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1144687089"
   )
   boolean method1657() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-720869592"
   )
   boolean method1682() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1684714069"
   )
   static void method1656() {
      if(class90.field1343) {
         class90.field1356 = null;
         class19.field328 = null;
         class90.runeSprites = null;
         class90.field1338 = null;
         class90.field1340 = null;
         class90.logoSprite = null;
         ChatLineBuffer.titlemuteSprite = null;
         class7.field235 = null;
         class90.field1342 = null;
         GraphicsObject.field1281 = null;
         ScriptEvent.slFlagSprites = null;
         class170.slArrowSprites = null;
         class178.slStarSprites = null;
         IndexStoreActionHandler.field3390 = null;
         ScriptState.field755 = null;
         class297.field3826 = null;
         BoundingBox3DDrawMode.field271 = null;
         class289.field3775 = null;
         TotalQuantityComparator.field299 = null;
         class177.field2277 = null;
         class1.field11 = null;
         class308.field3866 = null;
         class229.field2694 = 1;
         class229.field2687 = null;
         class229.field2691 = -1;
         AttackOption.field1331 = -1;
         class229.field2692 = 0;
         class37.field506 = false;
         class284.field3699 = 2;
         class36.sendConInfo(true);
         class90.field1343 = false;
      }
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "([BIB)V",
      garbageValue = "-101"
   )
   static void method1688(byte[] var0, int var1) {
      if(Client.field889 == null) {
         Client.field889 = new byte[24];
      }

      class205.method3933(var0, var1, Client.field889, 0, 24);
   }
}
