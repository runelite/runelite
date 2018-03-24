import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lc")
public class class322 implements Comparator {
   @ObfuscatedName("t")
   final boolean field3940;

   public class322(boolean var1) {
      this.field3940 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;I)I",
      garbageValue = "1543223173"
   )
   int method5655(Nameable var1, Nameable var2) {
      return this.field3940?var1.method5246().method5420(var2.method5246()):var2.method5246().method5420(var1.method5246());
   }

   public int compare(Object var1, Object var2) {
      return this.method5655((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
