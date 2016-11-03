import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
final class class216 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3976((class217)var1, (class217)var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-1322277096"
   )
   int method3976(class217 var1, class217 var2) {
      return var1.method3984().compareTo(var2.method3984());
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2011581367"
   )
   static void method3980() {
      FileOnDisk var0 = null;

      try {
         var0 = class116.method2507("", Client.field280.field2328, true);
         Buffer var1 = class130.field2102.method100();
         var0.method4145(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4146();
         }
      } catch (Exception var2) {
         ;
      }

   }
}
