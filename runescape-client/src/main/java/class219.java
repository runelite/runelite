import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
final class class219 implements Comparator {
   @ObfuscatedName("a")
   static byte[][][] field3204;

   public int compare(Object var1, Object var2) {
      return this.method4052((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "0"
   )
   int method4052(class217 var1, class217 var2) {
      return var1.field3194.field3213 < var2.field3194.field3213?-1:(var2.field3194.field3213 == var1.field3194.field3213?0:1);
   }
}
