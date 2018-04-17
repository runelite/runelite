import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
public class class322 implements Comparator {
   @ObfuscatedName("o")
   final boolean field3939;

   public class322(boolean var1) {
      this.field3939 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "1621135261"
   )
   int method5665(Nameable var1, Nameable var2) {
      return this.field3939?var1.method5271().method5430(var2.method5271()):var2.method5271().method5430(var1.method5271());
   }

   public int compare(Object var1, Object var2) {
      return this.method5665((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
