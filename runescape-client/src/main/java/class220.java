import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
final class class220 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-857432982"
   )
   int method4040(class217 var1, class217 var2) {
      return var1.field3198.field3217 < var2.field3198.field3217?-1:(var1.field3198.field3217 == var2.field3198.field3217?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4040((class217)var1, (class217)var2);
   }
}
