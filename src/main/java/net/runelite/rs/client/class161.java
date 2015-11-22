package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fn")
public final class class161 {
   @ObfuscatedName("j")
   static final char[] field2628 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -1440649607
   )
   static int field2629;
   @ObfuscatedName("o")
   static class13 field2632;

   @ObfuscatedName("l")
   static final void method3228() {
      class85.field1499 = false;
      client.field527 = false;
   }

   @ObfuscatedName("co")
   static final boolean method3232(class172 var0) {
      if(null == var0.field2845) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2845.length; ++var1) {
            int var2 = client.method586(var0, var1);
            int var3 = var0.field2758[var1];
            if(var0.field2845[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(3 == var0.field2845[var1]) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2845[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("u")
   static int method3233(int var0) {
      class35 var1 = (class35)class11.field166.method3851((long)var0);
      return null == var1?-1:(class11.field172.field3088 == var1.field3093?-1:((class35)var1.field3093).field769);
   }
}
