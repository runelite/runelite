import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class3 implements Comparator {
   @ObfuscatedName("c")
   static String field33;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = 1761298245
   )
   static int field34;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "79"
   )
   int method27(class2 var1, class2 var2) {
      return var1.field24.totalQuantity < var2.field24.totalQuantity?-1:(var1.field24.totalQuantity == var2.field24.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method27((class2)var1, (class2)var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-1314393958"
   )
   public static void method28(class182 var0) {
      class188.field2781 = var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-582185369"
   )
   public static void method33(Buffer var0) {
      byte[] var1 = new byte[24];

      try {
         class104.field1668.method1356(0L);
         class104.field1668.method1360(var1);

         int var2;
         for(var2 = 0; var2 < 24 && var1[var2] == 0; ++var2) {
            ;
         }

         if(var2 >= 24) {
            throw new IOException();
         }
      } catch (Exception var5) {
         for(int var3 = 0; var3 < 24; ++var3) {
            var1[var3] = -1;
         }
      }

      var0.method2753(var1, 0, 24);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1176714482"
   )
   public static int method34(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "-596304185"
   )
   public static void method36(class182 var0, class182 var1) {
      class231.field3280 = var0;
      KitDefinition.field2821 = var1;
      KitDefinition.field2817 = class231.field3280.method3220(3);
   }
}
