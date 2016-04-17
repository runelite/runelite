import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
final class class219 implements Comparator {
   @ObfuscatedName("a")
   static class167 field3168;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;B)I",
      garbageValue = "0"
   )
   int method4064(class214 var1, class214 var2) {
      return var1.field3155 < var2.field3155?-1:(var2.field3155 == var1.field3155?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4064((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "-2096635859"
   )
   static boolean method4065(class173 var0) {
      if(client.field462) {
         if(class31.method776(var0) != 0) {
            return false;
         }

         if(0 == var0.field2824) {
            return false;
         }
      }

      return var0.field2778;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "50"
   )
   static void method4071(int var0) {
      if(var0 != -1) {
         if(class9.method161(var0)) {
            class173[] var1 = class173.field2886[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class173 var3 = var1[var2];
               if(var3.field2839 != null) {
                  class0 var4 = new class0();
                  var4.field2 = var3;
                  var4.field4 = var3.field2839;
                  class168.method3449(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "941730487"
   )
   static void method4073(int var0, int var1) {
      client.field338.method2873(65);
      client.field338.method2655(var0);
      client.field338.method2634(var1);
   }
}
