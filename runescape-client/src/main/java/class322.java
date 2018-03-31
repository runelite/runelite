import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
public class class322 implements Comparator {
   @ObfuscatedName("c")
   final boolean field3934;

   public class322(boolean var1) {
      this.field3934 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "-989864560"
   )
   int method5683(Nameable var1, Nameable var2) {
      return this.field3934?var1.method5260().method5441(var2.method5260()):var2.method5260().method5441(var1.method5260());
   }

   public int compare(Object var1, Object var2) {
      return this.method5683((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
