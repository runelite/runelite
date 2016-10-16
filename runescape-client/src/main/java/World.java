import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("World")
public class World {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1826254181
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1454933887
   )
   static int field630 = 0;
   @ObfuscatedName("f")
   static int[] field632 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("k")
   static int[] field633 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("n")
   @Export("address")
   String address;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 889766177
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 93556909
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("d")
   @Export("activity")
   String activity;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -913157991
   )
   @Export("location")
   int location;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -882518053
   )
   @Export("index")
   int index;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1600861523
   )
   static int field641 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1119906789
   )
   static int field642;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "5"
   )
   boolean method607() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1713895486"
   )
   boolean method608() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-40"
   )
   boolean method609() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-38279347"
   )
   boolean method631() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "112163468"
   )
   boolean method642() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "18"
   )
   public static int method643(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "816073367"
   )
   boolean method648() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "128"
   )
   static void method653(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method3775((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method3776(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[1 + var1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-76"
   )
   static final void method654(int var0, int var1) {
      int var2 = class117.field2001.method4027("Choose Option");

      int var3;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         class227 var4 = class117.field2001;
         String var7;
         if(Client.menuTargets[var3].length() > 0) {
            var7 = Client.menuOptions[var3] + " " + Client.menuTargets[var3];
         } else {
            var7 = Client.menuOptions[var3];
         }

         int var6 = var4.method4027(var7);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      int var8 = var0 - var2 / 2;
      if(var2 + var8 > class50.field1069) {
         var8 = class50.field1069 - var2;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var5 = var1;
      if(var1 + var3 > class139.field2143) {
         var5 = class139.field2143 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Client.isMenuOpen = true;
      Client.menuX = var8;
      class54.menuY = var5;
      class129.menuWidth = var2;
      class192.menuHeight = Client.menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "71"
   )
   static final int method655(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var1 / 32 << 7) + (var0 / 4 << 10);
      return var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2013996833"
   )
   static int method657(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3775((long)var0);
      return null == var2?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }
}
