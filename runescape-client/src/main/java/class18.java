import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
final class class18 implements Comparator {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "-665488501"
   )
   int method141(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method82().compareTo(var2.method82());
   }

   public int compare(Object var1, Object var2) {
      return this.method141((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lbo;",
      garbageValue = "1017268411"
   )
   static MessageNode method151(int var0) {
      return (MessageNode)class95.messages.get((long)var0);
   }
}
