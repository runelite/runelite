import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public final class class24 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 133632753
   )
   int field611;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -252956517
   )
   int field613;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -24220281
   )
   int field614;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 438548563
   )
   int field615;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 527745021
   )
   int field616;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -949506797
   )
   int field617;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1849561453
   )
   int field618;
   @ObfuscatedName("c")
   class67 field619;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2116768247
   )
   int field620;
   @ObfuscatedName("h")
   int[] field622;
   @ObfuscatedName("ei")
   static ModIcon[] field623;
   @ObfuscatedName("u")
   class67 field624;
   @ObfuscatedName("x")
   ObjectComposition field625;
   @ObfuscatedName("f")
   static Deque field626 = new Deque();
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 808786279
   )
   int field627;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -626167141
   )
   int field628;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1473680023"
   )
   void method595() {
      int var1 = this.field618;
      ObjectComposition var2 = this.field625.getImpostor();
      if(var2 != null) {
         this.field618 = var2.field965;
         this.field617 = var2.field966 * 128;
         this.field628 = var2.field973;
         this.field620 = var2.field968;
         this.field622 = var2.field969;
      } else {
         this.field618 = -1;
         this.field617 = 0;
         this.field628 = 0;
         this.field620 = 0;
         this.field622 = null;
      }

      if(this.field618 != var1 && null != this.field619) {
         WidgetNode.field59.method1173(this.field619);
         this.field619 = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass171;IIIBZI)V",
      garbageValue = "-51375281"
   )
   static void method602(class171 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class175 var8 = (class175)class174.field2751.method3849(var6);
      if(null == var8) {
         var8 = (class175)class174.field2753.method3849(var6);
         if(var8 == null) {
            var8 = (class175)class174.field2756.method3849(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3968();
                  class174.field2751.method3850(var8, var6);
                  --class174.field2769;
                  ++class174.field2748;
               }

            } else {
               if(!var5) {
                  var8 = (class175)class174.field2760.method3849(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class175();
               var8.field2776 = var0;
               var8.field2774 = var3;
               var8.field2775 = var4;
               if(var5) {
                  class174.field2751.method3850(var8, var6);
                  ++class174.field2748;
               } else {
                  class174.field2758.method3954(var8);
                  class174.field2756.method3850(var8, var6);
                  ++class174.field2769;
               }

            }
         }
      }
   }
}
