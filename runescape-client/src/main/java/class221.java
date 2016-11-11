import java.io.File;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
final class class221 implements Comparator {
   @ObfuscatedName("g")
   static File field3219;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 6283781607779967307L
   )
   static long field3220;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "1310926135"
   )
   int method4006(class217 var1, class217 var2) {
      return var1.field3207 < var2.field3207?-1:(var1.field3207 == var2.field3207?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4006((class217)var1, (class217)var2);
   }
}
