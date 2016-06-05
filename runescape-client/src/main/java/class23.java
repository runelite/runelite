import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public final class class23 extends class208 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1111102543
   )
   int field595;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1883645015
   )
   int field596;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1746597933
   )
   int field597;
   @ObfuscatedName("r")
   class40 field598;
   @ObfuscatedName("t")
   static class199 field599 = new class199();
   @ObfuscatedName("b")
   class64 field600;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1964093495
   )
   int field601;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -798309053
   )
   int field602;
   @ObfuscatedName("y")
   class64 field603;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -886708133
   )
   int field604;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 677977655
   )
   int field605;
   @ObfuscatedName("k")
   int[] field606;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1544500007
   )
   int field607;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -905402911
   )
   int field609;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1971655855
   )
   int field612;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-126"
   )
   void method564() {
      int var1 = this.field602;
      class40 var2 = this.field598.method798();
      if(null != var2) {
         this.field602 = var2.field958;
         this.field601 = var2.field959 * 128;
         this.field597 = var2.field960;
         this.field604 = var2.field961 * 1392302051;
         this.field606 = var2.field962;
      } else {
         this.field602 = -1;
         this.field601 = 0;
         this.field597 = 0;
         this.field604 = 0;
         this.field606 = null;
      }

      if(var1 != this.field602 && this.field603 != null) {
         class129.field2065.method1092(this.field603);
         this.field603 = null;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lclass66;S)V",
      garbageValue = "-13612"
   )
   static final void method571(class66 var0) {
      var0.field1270 = false;
      if(var0.field1267 != null) {
         var0.field1267.field1266 = 0;
      }

      for(class66 var1 = var0.vmethod3695(); var1 != null; var1 = var0.vmethod3677()) {
         method571(var1);
      }

   }
}
