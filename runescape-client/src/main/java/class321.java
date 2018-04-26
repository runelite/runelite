import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lq")
public class class321 implements Comparator {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -251296815
   )
   public static int field3940;
   @ObfuscatedName("g")
   final boolean field3941;

   public class321(boolean var1) {
      this.field3941 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkg;Lkg;I)I",
      garbageValue = "2028177392"
   )
   int method5743(Nameable var1, Nameable var2) {
      return this.field3941?var1.vmethod5501(var2):var2.vmethod5501(var1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method5743((Nameable)var1, (Nameable)var2);
   }
}
