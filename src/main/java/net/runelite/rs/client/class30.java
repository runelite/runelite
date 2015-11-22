package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ai")
public class class30 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1335665773
   )
   int field680;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -499352561
   )
   int field681;
   @ObfuscatedName("u")
   String field683;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2089683503
   )
   int field686;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1501921919
   )
   int field688;

   @ObfuscatedName("s")
   static class102 method712(int var0) {
      class102 var1 = (class102)class42.field972.method3808((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         class166 var3 = class141.field2161;
         class166 var4 = class42.field974;
         boolean var5 = true;
         int[] var6 = var3.method3321(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3318(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3318(var9, 0);
               if(null == var10) {
                  var5 = false;
               }
            }
         }

         class102 var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new class102(var3, var4, var0, false);
            } catch (Exception var11) {
               var2 = null;
            }
         }

         if(var2 != null) {
            class42.field972.method3805(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("f")
   public static boolean method713(int var0) {
      return (var0 >> 20 & 1) != 0;
   }
}
