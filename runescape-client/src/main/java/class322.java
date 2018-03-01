import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lm")
public class class322 implements Comparator {
   @ObfuscatedName("d")
   final boolean field3932;

   public class322(boolean var1) {
      this.field3932 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkm;Lkm;B)I",
      garbageValue = "-22"
   )
   int method5750(Nameable var1, Nameable var2) {
      return this.field3932?var1.method5385().method5536(var2.method5385()):var2.method5385().method5536(var1.method5385());
   }

   public int compare(Object var1, Object var2) {
      return this.method5750((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
