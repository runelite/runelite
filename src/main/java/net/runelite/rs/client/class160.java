package net.runelite.rs.client;

import java.net.URL;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ft")
public class class160 {
   @ObfuscatedName("m")
   static char[] field2621;
   @ObfuscatedName("f")
   static int[] field2622;
   @ObfuscatedName("j")
   public static char[] field2624 = new char[64];
   @ObfuscatedName("is")
   static class30 field2625;

   @ObfuscatedName("j")
   static boolean method3226() {
      try {
         if(null == class25.field620) {
            class25.field620 = new class18(class25.field630, new URL(class12.field184));
         } else {
            byte[] var0 = class25.field620.method218();
            if(var0 != null) {
               class118 var1 = new class118(var0);
               class25.field616 = var1.method2538();
               class25.field615 = new class25[class25.field616];

               class25 var3;
               for(int var2 = 0; var2 < class25.field616; var3.field627 = var2++) {
                  var3 = class25.field615[var2] = new class25();
                  var3.field621 = var1.method2538();
                  var3.field622 = var1.method2541();
                  var3.field624 = var1.method2544();
                  var3.field633 = var1.method2544();
                  var3.field626 = var1.method2536();
                  var3.field629 = var1.method2539();
               }

               class101.method2310(class25.field615, 0, class25.field615.length - 1, class25.field619, class25.field632);
               class25.field620 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class25.field620 = null;
      }

      return false;
   }

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2624[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2624[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2624[var0] = (char)(48 + var0 - 52);
      }

      field2624[62] = 43;
      field2624[63] = 47;
      field2621 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2621[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2621[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2621[var0] = (char)(48 + var0 - 52);
      }

      field2621[62] = 42;
      field2621[63] = 45;
      field2622 = new int[128];

      for(var0 = 0; var0 < field2622.length; ++var0) {
         field2622[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2622[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2622[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2622[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field2622;
      field2622[43] = 62;
      var2[42] = 62;
      int[] var1 = field2622;
      field2622[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("j")
   public static int method3227(int var0) {
      class47 var1 = class25.method673(var0);
      int var2 = var1.field1050;
      int var3 = var1.field1048;
      int var4 = var1.field1057;
      int var5 = class175.field2885[var4 - var3];
      return class175.field2884[var2] >> var3 & var5;
   }
}
