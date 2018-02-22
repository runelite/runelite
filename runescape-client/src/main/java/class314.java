import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
public class class314 implements Comparator {
   @ObfuscatedName("b")
   final boolean field3859;

   public class314(boolean var1) {
      this.field3859 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljw;Ljw;I)I",
      garbageValue = "-1651235647"
   )
   int method5637(Nameable var1, Nameable var2) {
      return this.field3859?var1.method5183().method5360(var2.method5183()):var2.method5183().method5360(var1.method5183());
   }

   public int compare(Object var1, Object var2) {
      return this.method5637((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
