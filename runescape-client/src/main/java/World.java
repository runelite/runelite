import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("World")
public class World {
   @ObfuscatedName("g")
   static int[] field694 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 364466453
   )
   @Export("index")
   int index;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1901719289
   )
   static int field697 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1724902261
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 257836151
   )
   static int field700 = 0;
   @ObfuscatedName("y")
   @Export("worldServersDownload")
   static class26 worldServersDownload;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1360063007
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 422148257
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("l")
   @Export("address")
   String address;
   @ObfuscatedName("s")
   @Export("activity")
   String activity;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -60539599
   )
   @Export("location")
   int location;
   @ObfuscatedName("k")
   static int[] field708 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 1295098307
   )
   static int field709;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1239379816"
   )
   boolean method629() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "17"
   )
   boolean method631() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-99433545"
   )
   boolean method632() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2023797036"
   )
   boolean method638() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-414538839"
   )
   static boolean method647(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1344588821"
   )
   boolean method663() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-119166580"
   )
   static void method669() {
      for(class31 var0 = (class31)class31.field741.method2448(); null != var0; var0 = (class31)class31.field741.method2445()) {
         if(null != var0.field728) {
            class195.field2863.method993(var0.field728);
            var0.field728 = null;
         }

         if(null != var0.field740) {
            class195.field2863.method993(var0.field740);
            var0.field740 = null;
         }
      }

      class31.field741.method2442();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)LWidget;",
      garbageValue = "54"
   )
   public static Widget method670(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || null == Widget.widgets[var1][var2]) {
         boolean var3 = class44.method892(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "-292133969"
   )
   public static void method671(class182 var0, class182 var1) {
      KitDefinition.field2815 = var0;
      KitDefinition.field2820 = var1;
      class44.field918 = KitDefinition.field2815.method3316(3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1811605459"
   )
   static final int method672(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-677669485"
   )
   boolean method673() {
      return (1 & this.mask) != 0;
   }
}
