import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
final class class213 implements Comparator {
   public int compare(Object var1, Object var2) {
      return this.method4026((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "-1586065363"
   )
   int method4026(class214 var1, class214 var2) {
      return var1.method4033().compareTo(var2.method4033());
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-12"
   )
   static void method4031() {
      class227 var0 = null;

      try {
         var0 = class11.method188("", class1.field21.field2280, true);
         class119 var1 = class134.field2078.method143();
         var0.method4201(var1.field1993, 0, var1.field1992);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method4202();
         }
      } catch (Exception var2) {
         ;
      }

   }
}
