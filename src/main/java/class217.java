import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hd")
final class class217 implements Comparator {
   @ObfuscatedName("w")
   int method3979(class214 var1, class214 var2) {
      return var1.field3156.field3173 < var2.field3156.field3173?-1:(var2.field3156.field3173 == var1.field3156.field3173?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3979((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
