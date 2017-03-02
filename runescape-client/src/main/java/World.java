import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("World")
public class World {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1647253093
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("k")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1584208063
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1363872097
   )
   static int field676 = 0;
   @ObfuscatedName("a")
   static int[] field677 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("f")
   static int[] field678 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1209451173
   )
   @Export("id")
   int id;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 840728307
   )
   static int field681 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1428931535
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("s")
   @Export("address")
   String address;
   @ObfuscatedName("o")
   @Export("activity")
   String activity;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1315254429
   )
   @Export("location")
   int location;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -116701293
   )
   @Export("index")
   int index;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2111450081"
   )
   boolean method648() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-1"
   )
   boolean method652() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-28440887"
   )
   boolean method653() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1914309758"
   )
   boolean method654() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "308815239"
   )
   boolean method664() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "93"
   )
   boolean method665() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-40"
   )
   public static void method681() {
      class39.field800.method2668();
      class138.field1915 = 1;
      class138.field1918 = null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "0"
   )
   static int method682(int var0, Script var1, boolean var2) {
      Widget var3 = class140.method2681(class32.field729[--class101.field1648]);
      if(var0 == 2500) {
         class32.field729[++class101.field1648 - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class32.field729[++class101.field1648 - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class32.field729[++class101.field1648 - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class32.field729[++class101.field1648 - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class32.field729[++class101.field1648 - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class32.field729[++class101.field1648 - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
