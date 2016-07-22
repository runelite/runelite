import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
final class class222 implements Comparator {
   @ObfuscatedName("eo")
   static class81 field3215;

   public int compare(Object var1, Object var2) {
      return this.method4059((class217)var1, (class217)var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "7"
   )
   int method4059(class217 var1, class217 var2) {
      return var1.field3201 < var2.field3201?-1:(var1.field3201 == var2.field3201?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
