package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class76 {
   @ObfuscatedName("l")
   static int[] field1366;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1857783621
   )
   static int field1367;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 89131355
   )
   static int field1368;
   @ObfuscatedName("i")
   static int[] field1369;
   @ObfuscatedName("u")
   static int[] field1370;
   @ObfuscatedName("a")
   static int[] field1371;
   @ObfuscatedName("eb")
   static class78[] field1372;
   @ObfuscatedName("h")
   static int[] field1373;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -177783653
   )
   static int field1374;
   @ObfuscatedName("dw")
   static byte[][] field1377;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = -226844881
   )
   static int field1378;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1281513731
   )
   static int field1379;

   @ObfuscatedName("m")
   public static class46 method1696(int var0) {
      class46 var1 = (class46)class46.field1033.method3808((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class46.field1035.method3352(4, var0);
         var1 = new class46();
         if(null != var2) {
            var1.method1008(new class118(var2));
         }

         var1.method995();
         class46.field1033.method3805(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   static void method1697() {
      class31.field713 = class31.field713.trim();
      if(class31.field713.length() == 0) {
         class9.method143("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class153.method3201();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = class100.method2309(var1, class31.field713);
         }

         switch(var0) {
         case 2:
            class9.method143("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class31.field709 = 6;
            break;
         case 3:
            class9.method143("", "Error connecting to server.", "");
            break;
         case 4:
            class9.method143("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class9.method143("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class9.method143("", "Error connecting to server.", "");
            break;
         case 7:
            class9.method143("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("j")
   public static void method1698(class166 var0) {
      class49.field1076 = var0;
   }
}
