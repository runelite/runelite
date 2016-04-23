import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
final class class213 implements Comparator {
   @ObfuscatedName("x")
   public static class167 field3155;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "366535408"
   )
   int method3906(class214 var1, class214 var2) {
      return var1.method3920().compareTo(var2.method3920());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3906((class214)var1, (class214)var2);
   }
}
