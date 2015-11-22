package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
public class class126 {
   @ObfuscatedName("s")
   static class80 field2035;

   @ObfuscatedName("w")
   public static String method2858(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(0 == var3) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class103.method2327(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(46 != var5 && var5 != 63 && 33 != var5) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("bq")
   static final void method2859(boolean var0) {
      while(true) {
         if(client.field320.method2788(client.field289) >= 27) {
            int var1 = client.field320.method2786(15);
            if(32767 != var1) {
               boolean var2 = false;
               if(null == client.field313[var1]) {
                  client.field313[var1] = new class34();
                  var2 = true;
               }

               class34 var3 = client.field313[var1];
               client.field315[++client.field314 - 1] = var1;
               var3.field799 = client.field286;
               int var4 = client.field320.method2786(1);
               int var5 = client.field320.method2786(1);
               if(1 == var5) {
                  client.field317[++client.field444 - 1] = var1;
               }

               int var6;
               if(var0) {
                  var6 = client.field320.method2786(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = client.field320.method2786(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               int var7 = client.field405[client.field320.method2786(3)];
               if(var2) {
                  var3.field848 = var3.field800 = var7;
               }

               var3.field761 = class22.method618(client.field320.method2786(14));
               int var8;
               if(var0) {
                  var8 = client.field320.method2786(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = client.field320.method2786(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               var3.field802 = var3.field761.field871;
               var3.field850 = var3.field761.field894;
               if(0 == var3.field850) {
                  var3.field800 = 0;
               }

               var3.field806 = var3.field761.field877 * -1;
               var3.field807 = var3.field761.field904 * -1;
               var3.field822 = var3.field761.field896 * -1;
               var3.field818 = var3.field761.field880 * -1;
               var3.field803 = var3.field761.field872 * -1;
               var3.field804 = var3.field761.field866 * -1;
               var3.field849 = var3.field761.field867;
               var3.method757(var8 + class0.field12.field809[0], class0.field12.field816[0] + var6, 1 == var4);
               continue;
            }
         }

         client.field320.method2800();
         return;
      }
   }
}
