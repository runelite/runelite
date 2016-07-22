import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
final class class216 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4022((class217)var1, (class217)var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "1586808837"
   )
   int method4022(class217 var1, class217 var2) {
      return var1.method4031().compareTo(var2.method4031());
   }
}
