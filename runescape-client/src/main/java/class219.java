import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
final class class219 implements Comparator {
   @ObfuscatedName("w")
   @Export("validInterfaces")
   public static boolean[] field3209;
   @ObfuscatedName("g")
   @Export("worldList")
   static class27[] field3210;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "105"
   )
   int method4035(class217 var1, class217 var2) {
      return var1.field3198.field3220 < var2.field3198.field3220?-1:(var1.field3198.field3220 == var2.field3198.field3220?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4035((class217)var1, (class217)var2);
   }
}
