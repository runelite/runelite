import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
final class class222 implements Comparator {
   public int compare(Object var1, Object var2) {
      return this.method4076((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "-3"
   )
   int method4076(class217 var1, class217 var2) {
      return var1.field3197 < var2.field3197?-1:(var1.field3197 == var2.field3197?0:1);
   }
}
