import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class149 implements Comparator {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static IndexedSprite field2106;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static IndexedSprite field2107;
   @ObfuscatedName("g")
   final boolean field2108;

   public class149(boolean var1) {
      this.field2108 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "1128295150"
   )
   int method3185(ChatPlayer var1, ChatPlayer var2) {
      return this.field2108?var1.field3851 - var2.field3851:var2.field3851 - var1.field3851;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3185((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
