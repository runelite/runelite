import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
final class class19 implements Comparator {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lk;Lk;I)I",
      garbageValue = "-123795030"
   )
   int method165(class14 var1, class14 var2) {
      return var1.field284 < var2.field284?-1:(var1.field284 == var2.field284?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method165((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
