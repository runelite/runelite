package net.runelite.rs.client;

import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ey")
public class class141 {
   @ObfuscatedName("m")
   static class166 field2161;

   @ObfuscatedName("s")
   static byte[] method3018(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("f")
   static class8 method3020() {
      class226 var0 = null;
      class8 var1 = new class8();

      try {
         var0 = class75.method1666("", class168.field2687.field2275, false);
         byte[] var2 = new byte[(int)var0.method4176()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method4177(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new class8(new class118(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(null != var0) {
            var0.method4183();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }
}
