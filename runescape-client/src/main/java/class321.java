import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lr")
public class class321 implements Comparator {
   @ObfuscatedName("c")
   final boolean field3933;

   public class321(boolean var1) {
      this.field3933 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;B)I",
      garbageValue = "81"
   )
   int method5674(Nameable var1, Nameable var2) {
      return this.field3933?var1.vmethod5454(var2):var2.vmethod5454(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method5674((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
