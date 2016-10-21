import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class21 implements class115 {
   @ObfuscatedName("t")
   static final class21 field578 = new class21(3);
   @ObfuscatedName("e")
   static final class21 field579 = new class21(1);
   @ObfuscatedName("f")
   static final class21 field581 = new class21(0);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1271000407
   )
   final int field582;
   @ObfuscatedName("eh")
   static SpritePixels[] field584;
   @ObfuscatedName("bt")
   static class171 field585;
   @ObfuscatedName("n")
   static final class21 field586 = new class21(2);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "-1019015145"
   )
   static void method569(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class24 var5 = new class24();
      var5.field627 = var0;
      var5.field613 = var1 * 128;
      var5.field614 = var2 * 128;
      int var6 = var3.field936;
      int var7 = var3.field937;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field937;
         var7 = var3.field936;
      }

      var5.field615 = (var6 + var1) * 128;
      var5.field616 = (var2 + var7) * 128;
      var5.field618 = var3.field965;
      var5.field617 = var3.field966 * 128;
      var5.field628 = var3.field973;
      var5.field620 = var3.field968;
      var5.field622 = var3.field969;
      if(var3.impostorIds != null) {
         var5.field625 = var3;
         var5.method595();
      }

      class24.field626.method3886(var5);
      if(var5.field622 != null) {
         var5.field611 = var5.field628 + (int)(Math.random() * (double)(var5.field620 - var5.field628));
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class21(int var1) {
      this.field582 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-59"
   )
   static void method573() {
      for(class24 var0 = (class24)class24.field626.method3890(); null != var0; var0 = (class24)class24.field626.method3892()) {
         if(null != var0.field625) {
            var0.method595();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-864729888"
   )
   static void method574() {
      for(class24 var0 = (class24)class24.field626.method3890(); null != var0; var0 = (class24)class24.field626.method3892()) {
         if(null != var0.field619) {
            WidgetNode.field59.method1173(var0.field619);
            var0.field619 = null;
         }

         if(var0.field624 != null) {
            WidgetNode.field59.method1173(var0.field624);
            var0.field624 = null;
         }
      }

      class24.field626.method3885();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "50702266"
   )
   public int vmethod3196() {
      return this.field582;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass125;B)I",
      garbageValue = "-21"
   )
   static int method576(class125 var0) {
      int var1 = var0.method2771(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2771(5);
      } else if(var1 == 2) {
         var2 = var0.method2771(8);
      } else {
         var2 = var0.method2771(11);
      }

      return var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "285085673"
   )
   public static int method577(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
