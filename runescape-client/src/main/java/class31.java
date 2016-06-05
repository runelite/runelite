import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class31 {
   @ObfuscatedName("az")
   @Export("worldSelectShown")
   static boolean field702;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2028672653
   )
   static int field703 = 0;
   @ObfuscatedName("h")
   static class80 field704;
   @ObfuscatedName("f")
   static class78 field705;
   @ObfuscatedName("u")
   static int[] field707;
   @ObfuscatedName("an")
   static String field708;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1472058523
   )
   static int field709;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1678402001
   )
   static int field710;
   @ObfuscatedName("d")
   static class80[] field711;
   @ObfuscatedName("ak")
   @Export("loginMessage3")
   static String field712;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -821552681
   )
   static int field713;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1380700057
   )
   static int field714;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -2018124581
   )
   static int field715;
   @ObfuscatedName("t")
   static boolean field716;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1477361429
   )
   @Export("loginIndex")
   static int field717;
   @ObfuscatedName("aw")
   @Export("loginMessage1")
   static String field719;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1302567359
   )
   static int field720;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1337070897
   )
   @Export("loginWindowX")
   static int field721;
   @ObfuscatedName("ac")
   @Export("username")
   static String field722;
   @ObfuscatedName("ao")
   static String field723;
   @ObfuscatedName("aj")
   static class159 field724;
   @ObfuscatedName("aa")
   static boolean field725;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1885887227
   )
   @Export("loginIndex2")
   static int field726;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 657381805
   )
   static int field729;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -212046399
   )
   static int field730;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 827290933
   )
   static int field732;
   @ObfuscatedName("ap")
   @Export("loginMessage2")
   static String field734;
   @ObfuscatedName("aq")
   static String field735;

   static {
      field721 = field703 + 202;
      field707 = new int[256];
      field709 = 0;
      field710 = 0;
      field714 = 0;
      field729 = 0;
      field713 = 0;
      field720 = 0;
      field715 = 10;
      field735 = "";
      field717 = 0;
      field708 = "";
      field719 = "";
      field734 = "";
      field712 = "";
      field722 = "";
      field723 = "";
      field724 = class159.field2625;
      field725 = true;
      field726 = 0;
      field702 = false;
      field730 = -1;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1900778083"
   )
   static final void method675(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field485; ++var4) {
         if(client.field490[var4] + client.field535[var4] > var0 && client.field490[var4] < var0 + var2 && client.field436[var4] + client.field493[var4] > var1 && client.field436[var4] < var1 + var3) {
            client.field396[var4] = true;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1884902358"
   )
   public static boolean method676(char var0) {
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         return true;
      } else {
         if(var0 != 0) {
            char[] var1 = class165.field2696;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var3 == var0) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "239420497"
   )
   static final void method677(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class14.method147(var0, var1, class32.field754) - var2;
         var0 -= class9.field155;
         var3 -= class13.field205;
         var1 -= class4.field81;
         int var4 = class91.field1602[class138.field2164];
         int var5 = class91.field1603[class138.field2164];
         int var6 = class91.field1602[class19.field269];
         int var7 = class91.field1603[class19.field269];
         int var8 = var7 * var0 + var6 * var1 >> 16;
         var1 = var1 * var7 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var4 * var3 + var1 * var5 >> 16;
         if(var1 >= 50) {
            client.field389 = var0 * client.field548 / var1 + client.field414 / 2;
            client.field365 = var8 * client.field548 / var1 + client.field547 / 2;
         } else {
            client.field389 = -1;
            client.field365 = -1;
         }

      } else {
         client.field389 = -1;
         client.field365 = -1;
      }
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1443171739"
   )
   static void method678(int var0, int var1) {
      class51.method1046(client.field566, var0, var1);
      client.field566 = null;
   }
}
