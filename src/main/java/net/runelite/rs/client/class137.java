package net.runelite.rs.client;

import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("et")
public class class137 {
   @ObfuscatedName("j")
   static Applet field2116 = null;
   @ObfuscatedName("m")
   static String field2117 = null;

   @ObfuscatedName("j")
   public static boolean method2969(int var0) {
      return (var0 & 1) != 0;
   }

   @ObfuscatedName("j")
   static class22 method2972(int var0) {
      class22 var1 = (class22)class22.field577.method3808((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class5.field90.method3352(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class22();
            class118 var3 = new class118(var2);
            var3.field1981 = var3.field1980.length - 12;
            int var4 = var3.method2541();
            var1.field583 = var3.method2538();
            var1.field579 = var3.method2538();
            var1.field580 = var3.method2538();
            var1.field581 = var3.method2538();
            var3.field1981 = 0;
            var3.method2543();
            var1.field578 = new int[var4];
            var1.field576 = new int[var4];
            var1.field574 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field1981 < var3.field1980.length - 12; var1.field578[var5++] = var6) {
               var6 = var3.method2538();
               if(3 == var6) {
                  var1.field574[var5] = var3.method2544();
               } else if(var6 < 100 && 21 != var6 && var6 != 38 && 39 != var6) {
                  var1.field576[var5] = var3.method2541();
               } else {
                  var1.field576[var5] = var3.method2536();
               }
            }

            class22.field577.method3805(var1, (long)var0);
            return var1;
         }
      }
   }
}
