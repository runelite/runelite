package net.runelite.rs.client;
import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ee")
public abstract class class130 {
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 471238365
   )
   static int field2065;

   @ObfuscatedName("j")
   static final boolean method2762(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else if(class101.method2245(var0)) {
         return true;
      } else {
         char[] var1 = class163.field2659;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var3 == var0) {
               return true;
            }
         }

         var1 = class163.field2661;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("j")
   public abstract void vmethod3060(Component var1);

   @ObfuscatedName("l")
   public abstract void vmethod3057(Component var1);

   @ObfuscatedName("a")
   public abstract int vmethod3058();

   @ObfuscatedName("cx")
   static String method2774(String var0, class172 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class218.method3920(class141.method2926(var1, var2 - 1)) + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var6 = "";
            if(null != class226.field3208) {
               int var5 = class226.field3208.field2224;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var6 = var4;
               if(null != class226.field3208.field2223) {
                  var6 = (String)class226.field3208.field2223;
               }
            }

            var0 = var0.substring(0, var2) + var6 + var0.substring(4 + var2);
         }
      }

      return var0;
   }
}
