package net.runelite.rs.client;

import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eh")
public class class148 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 920973357
   )
   public static int field2215;
   @ObfuscatedName("s")
   public static class227 field2220 = null;
   @ObfuscatedName("w")
   public static class227 field2221 = null;
   @ObfuscatedName("e")
   public static class227 field2222 = null;
   @ObfuscatedName("u")
   public static File field2226;

   @ObfuscatedName("dh")
   static final boolean method3181(class172 var0) {
      int var1 = var0.field2738;
      if(205 == var1) {
         client.field400 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field547.method3538(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field547.method3544(var2, 1 == var3);
         }

         if(var1 == 324) {
            client.field547.method3540(false);
         }

         if(325 == var1) {
            client.field547.method3540(true);
         }

         if(326 == var1) {
            client.field318.method2785(207);
            client.field547.method3541(client.field318);
            return true;
         } else {
            return false;
         }
      }
   }
}
