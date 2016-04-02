import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hf")
final class class213 implements Comparator {
   @ObfuscatedName("e")
   public static class167 field3144;

   public int compare(Object var1, Object var2) {
      return this.method3938((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("e")
   int method3938(class214 var1, class214 var2) {
      return var1.method3939().compareTo(var2.method3939());
   }
}
