package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class190 {
   @ObfuscatedName("i")
   public static final boolean method3703() {
      class136 var0 = class136.field2113;
      synchronized(class136.field2113) {
         if(class136.field2129 == class136.field2131) {
            return false;
         } else {
            class3.field70 = class136.field2126[class136.field2129];
            class18.field254 = class136.field2125[class136.field2129];
            class136.field2129 = 1 + class136.field2129 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("df")
   static final void method3704(String var0) {
      if(!var0.equals("")) {
         client.field329.method2686(20);
         client.field329.method2438(class36.method742(var0));
         client.field329.method2444(var0);
      }
   }

   @ObfuscatedName("n")
   public static String method3705(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(2 == var3 || Character.isUpperCase(var5)) {
            var5 = class29.method661(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
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
}
