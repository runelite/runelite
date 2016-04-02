import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("d")
public final class class23 extends class208 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 255214945
   )
   int field588;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 722108429
   )
   int field589;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 44752971
   )
   int field590;
   @ObfuscatedName("m")
   class64 field591;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 946368923
   )
   int field592;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -88994709
   )
   int field593;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1681364379
   )
   int field594;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1679485225
   )
   int field595;
   @ObfuscatedName("j")
   class64 field596;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -838816465
   )
   int field597;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1871700593
   )
   int field598;
   @ObfuscatedName("y")
   int[] field599;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -225305135
   )
   int field600;
   @ObfuscatedName("e")
   static class199 field601 = new class199();
   @ObfuscatedName("r")
   class40 field602;

   @ObfuscatedName("i")
   static boolean method586(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3280(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class121.method2747(var3);
         return true;
      }
   }

   @ObfuscatedName("e")
   void method587() {
      int var1 = this.field588;
      class40 var2 = this.field602.method797();
      if(var2 != null) {
         this.field588 = var2.field943;
         this.field594 = var2.field935 * 128;
         this.field600 = var2.field937;
         this.field598 = var2.field946;
         this.field599 = var2.field947;
      } else {
         this.field588 = -1;
         this.field594 = 0;
         this.field600 = 0;
         this.field598 = 0;
         this.field599 = null;
      }

      if(var1 != this.field588 && this.field591 != null) {
         class135.field2074.method1146(this.field591);
         this.field591 = null;
      }

   }
}
