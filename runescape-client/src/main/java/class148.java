import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class148 implements Comparator {
   @ObfuscatedName("b")
   final boolean field2075;

   public class148(boolean var1) {
      this.field2075 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "2113592704"
   )
   int method3096(ChatPlayer var1, ChatPlayer var2) {
      return this.field2075?var1.field3718 - var2.field3718:var2.field3718 - var1.field3718;
   }

   public int compare(Object var1, Object var2) {
      return this.method3096((ChatPlayer)var1, (ChatPlayer)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
