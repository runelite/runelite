import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
final class class17 implements Comparator {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "1008984827"
   )
   int method139(class14 var1, class14 var2) {
      return var1.field288.price < var2.field288.price?-1:(var1.field288.price == var2.field288.price?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method139((class14)var1, (class14)var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2050596995"
   )
   public static void method145() {
      if(class50.keyboard != null) {
         class50 var0 = class50.keyboard;
         synchronized(class50.keyboard) {
            class50.keyboard = null;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "64"
   )
   static final boolean method146(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }
}
