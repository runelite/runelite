import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class19 implements Comparator {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("NetCache_socket")
   public static class159 NetCache_socket;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lau;"
   )
   static class47 field316;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lq;Lq;I)I",
      garbageValue = "779999493"
   )
   int method144(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field277 < var2.field277?-1:(var2.field277 == var1.field277?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method144((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
