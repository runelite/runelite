package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("w")
public class class20 implements class111 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1879738831
   )
   final int field575;
   @ObfuscatedName("l")
   static final class20 field576 = new class20(1);
   @ObfuscatedName("a")
   static final class20 field577 = new class20(2);
   @ObfuscatedName("j")
   static final class20 field578 = new class20(0);
   @ObfuscatedName("i")
   static final class20 field579 = new class20(3);
   @ObfuscatedName("r")
   public static class223 field580;

   @ObfuscatedName("i")
   public static int method560(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class29.method663(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("j")
   public int vmethod3121() {
      return this.field575;
   }

   @ObfuscatedName("b")
   static final int method563(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("i")
   public static void method567() {
      class47.field1066.method3720();
   }

   class20(int var1) {
      this.field575 = var1;
   }
}
