import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("le")
public class class313 implements Comparator {
   @ObfuscatedName("b")
   final boolean field3857;

   public class313(boolean var1) {
      this.field3857 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljw;Ljw;B)I",
      garbageValue = "2"
   )
   int method5628(Nameable var1, Nameable var2) {
      return this.field3857?var1.vmethod5385(var2):var2.vmethod5385(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method5628((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
