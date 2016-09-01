import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
final class class221 implements Comparator {
   @ObfuscatedName("r")
   public static class170 field3216;

   public int compare(Object var1, Object var2) {
      return this.method3997((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "37"
   )
   int method3997(class217 var1, class217 var2) {
      return var1.field3206 < var2.field3206?-1:(var2.field3206 == var1.field3206?0:1);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1821413466"
   )
   static void method4001() {
      Client.field323.method2818(136);
      Client.field323.method2715(class92.method2124());
      Client.field323.method2542(FaceNormal.field1499);
      Client.field323.method2542(class212.field3175);
   }
}
