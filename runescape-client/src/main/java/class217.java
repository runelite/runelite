import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
final class class217 implements Comparator {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;B)I",
      garbageValue = "-59"
   )
   int method3905(class214 var1, class214 var2) {
      return var1.field3157.field3176 < var2.field3157.field3176?-1:(var1.field3157.field3176 == var2.field3157.field3176?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3905((class214)var1, (class214)var2);
   }
}
