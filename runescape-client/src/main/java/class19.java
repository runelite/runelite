import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
final class class19 implements Comparator {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ly;Ly;I)I",
      garbageValue = "1885066010"
   )
   int method144(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field278 < var2.field278?-1:(var2.field278 == var1.field278?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method144((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }
}
