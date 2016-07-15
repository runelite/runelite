import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class157 implements class115 {
   @ObfuscatedName("l")
   static final class157 field2329 = new class157("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -905310169
   )
   final int field2330;
   @ObfuscatedName("r")
   static final class157 field2331 = new class157("game5", "Game 5", 4);
   @ObfuscatedName("c")
   static final class157 field2332 = new class157("game3", "Game 3", 2);
   @ObfuscatedName("e")
   static final class157 field2333 = new class157("runescape", "RuneScape", 0);
   @ObfuscatedName("a")
   public static final class157 field2334 = new class157("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("b")
   public final String field2335;
   @ObfuscatedName("h")
   static final class157 field2336 = new class157("game4", "Game 4", 3);
   @ObfuscatedName("o")
   public static short[] field2340;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 210987965
   )
   @Export("cameraY")
   static int field2342;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2010364784"
   )
   public int vmethod3262() {
      return this.field2330;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass215;I)I",
      garbageValue = "991479016"
   )
   static final int method3247(class215 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3188) {
         case 7:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "1"
   )
   static final void method3254(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class105.method2370(var0, var1, class50.field1119) - var2;
         var0 -= class85.field1500;
         var3 -= class41.field955;
         var1 -= field2342;
         int var4 = class94.field1655[class98.field1694];
         int var5 = class94.field1653[class98.field1694];
         int var6 = class94.field1655[class99.field1703];
         int var7 = class94.field1653[class99.field1703];
         int var8 = var7 * var0 + var1 * var6 >> 16;
         var1 = var1 * var7 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var1 * var4 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            client.field401 = client.field559 / 2 + var0 * client.field561 / var1;
            client.field322 = client.field562 / 2 + client.field561 * var8 / var1;
         } else {
            client.field401 = -1;
            client.field322 = -1;
         }

      } else {
         client.field401 = -1;
         client.field322 = -1;
      }
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class157(String var1, String var2, int var3) {
      this.field2335 = var1;
      this.field2330 = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1521876210"
   )
   public static int method3255(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "65"
   )
   static int method3256(int var0) {
      class37 var1 = (class37)class11.field188.method3882((long)var0);
      return var1 == null?-1:(var1.field3151 == class11.field184.field3146?-1:((class37)var1.field3151).field833);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lclass39;I)V",
      garbageValue = "-1608522386"
   )
   static final void method3257(class39 var0) {
      var0.field853 = false;
      class44 var3;
      if(var0.field900 != -1) {
         var3 = class13.method153(var0.field900);
         if(null != var3 && null != var3.field1023) {
            ++var0.field881;
            if(var0.field880 < var3.field1023.length && var0.field881 > var3.field1025[var0.field880]) {
               var0.field881 = 1;
               ++var0.field880;
               class151.method3216(var3, var0.field880, var0.field896, var0.field879);
            }

            if(var0.field880 >= var3.field1023.length) {
               var0.field881 = 0;
               var0.field880 = 0;
               class151.method3216(var3, var0.field880, var0.field896, var0.field879);
            }
         } else {
            var0.field900 = -1;
         }
      }

      if(var0.field887 != -1 && client.field567 >= var0.field869) {
         if(var0.field888 < 0) {
            var0.field888 = 0;
         }

         int var1 = class151.method3217(var0.field887).field1047;
         if(var1 != -1) {
            class44 var2 = class13.method153(var1);
            if(null != var2 && var2.field1023 != null) {
               ++var0.field882;
               if(var0.field888 < var2.field1023.length && var0.field882 > var2.field1025[var0.field888]) {
                  var0.field882 = 1;
                  ++var0.field888;
                  class151.method3216(var2, var0.field888, var0.field896, var0.field879);
               }

               if(var0.field888 >= var2.field1023.length && (var0.field888 < 0 || var0.field888 >= var2.field1023.length)) {
                  var0.field887 = -1;
               }
            } else {
               var0.field887 = -1;
            }
         } else {
            var0.field887 = -1;
         }
      }

      if(var0.field890 != -1 && var0.field904 <= 1) {
         var3 = class13.method153(var0.field890);
         if(var3.field1034 == 1 && var0.field909 > 0 && var0.field883 <= client.field567 && var0.field859 < client.field567) {
            var0.field904 = 1;
            return;
         }
      }

      if(var0.field890 != -1 && var0.field904 == 0) {
         var3 = class13.method153(var0.field890);
         if(var3 != null && null != var3.field1023) {
            ++var0.field884;
            if(var0.field865 < var3.field1023.length && var0.field884 > var3.field1025[var0.field865]) {
               var0.field884 = 1;
               ++var0.field865;
               class151.method3216(var3, var0.field865, var0.field896, var0.field879);
            }

            if(var0.field865 >= var3.field1023.length) {
               var0.field865 -= var3.field1027;
               ++var0.field886;
               if(var0.field886 >= var3.field1033) {
                  var0.field890 = -1;
               } else if(var0.field865 >= 0 && var0.field865 < var3.field1023.length) {
                  class151.method3216(var3, var0.field865, var0.field896, var0.field879);
               } else {
                  var0.field890 = -1;
               }
            }

            var0.field853 = var3.field1029;
         } else {
            var0.field890 = -1;
         }
      }

      if(var0.field904 > 0) {
         --var0.field904;
      }

   }
}
