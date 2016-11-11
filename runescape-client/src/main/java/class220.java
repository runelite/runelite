import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
final class class220 implements Comparator {
   @ObfuscatedName("i")
   public static class170 field3215;
   @ObfuscatedName("qc")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "127"
   )
   int method3997(class217 var1, class217 var2) {
      return var1.field3205.price < var2.field3205.price?-1:(var1.field3205.price == var2.field3205.price?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3997((class217)var1, (class217)var2);
   }
}
