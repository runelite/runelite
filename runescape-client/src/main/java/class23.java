import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public final class class23 extends class208 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1592695951
   )
   int field597;
   @ObfuscatedName("c")
   class64 field598;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1343544391
   )
   int field599;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 581832617
   )
   int field600;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2038509597
   )
   int field601;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -176054521
   )
   int field602;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1387471625
   )
   int field603;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1046726867
   )
   int field604;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1723849057
   )
   int field606;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1310063553
   )
   int field607;
   @ObfuscatedName("t")
   int[] field608;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -279566363
   )
   int field609;
   @ObfuscatedName("m")
   class64 field610;
   @ObfuscatedName("r")
   class40 field611;
   @ObfuscatedName("j")
   static class199 field615 = new class199();

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-547539382"
   )
   void method573() {
      int var1 = this.field604;
      class40 var2 = this.field611.method783();
      if(var2 != null) {
         this.field604 = var2.field936;
         this.field603 = var2.field969 * 128;
         this.field597 = var2.field940;
         this.field607 = var2.field968;
         this.field608 = var2.field972;
      } else {
         this.field604 = -1;
         this.field603 = 0;
         this.field597 = 0;
         this.field607 = 0;
         this.field608 = null;
      }

      if(var1 != this.field604 && null != this.field598) {
         class114.field1978.method1117(this.field598);
         this.field598 = null;
      }

   }
}
