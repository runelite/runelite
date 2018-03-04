import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ll")
public class class321 implements Comparator {
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      longValue = -4084382720702439395L
   )
   static long field3929;
   @ObfuscatedName("d")
   final boolean field3931;

   public class321(boolean var1) {
      this.field3931 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkm;Lkm;I)I",
      garbageValue = "420109663"
   )
   int method5738(Nameable var1, Nameable var2) {
      return this.field3931?var1.vmethod5558(var2):var2.vmethod5558(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method5738((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
