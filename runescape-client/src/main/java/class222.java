import java.io.File;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
final class class222 implements Comparator {
   @ObfuscatedName("q")
   static File field3217;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "87"
   )
   int method4009(class217 var1, class217 var2) {
      return var1.field3197 < var2.field3197?-1:(var1.field3197 == var2.field3197?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4009((class217)var1, (class217)var2);
   }
}
