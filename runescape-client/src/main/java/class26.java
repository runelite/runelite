import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class26 extends Node {
   @ObfuscatedName("v")
   class49 field645;
   @ObfuscatedName("gl")
   static Widget field650;
   @ObfuscatedName("r")
   class205 field651 = new class205();
   @ObfuscatedName("z")
   static byte[][][] field653;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "327150290"
   )
   boolean method607() {
      return this.field651.method3909();
   }

   class26(class49 var1) {
      this.field645 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "60"
   )
   void method609(int var1, int var2, int var3, int var4) {
      class20 var5 = null;
      int var6 = 0;

      for(class20 var7 = (class20)this.field651.method3901(); var7 != null; var7 = (class20)this.field651.method3903()) {
         ++var6;
         if(var7.field569 == var1) {
            var7.method559(var1, var2, var3, var4);
            return;
         }

         if(var7.field569 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.field651.method3917(new class20(var1, var2, var3, var4));
         }

      } else {
         class205.method3900(new class20(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.field651.method3901().unlink();
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass20;",
      garbageValue = "-2097554543"
   )
   class20 method612(int var1) {
      class20 var2 = (class20)this.field651.method3901();
      if(var2 != null && var2.field569 <= var1) {
         for(class20 var3 = (class20)this.field651.method3903(); null != var3 && var3.field569 <= var1; var3 = (class20)this.field651.method3903()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field572 + var2.field569 + this.field645.field1100 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZI)V",
      garbageValue = "-915042827"
   )
   public static void method617(class170 var0, class170 var1, boolean var2) {
      ObjectComposition.field948 = var0;
      ObjectComposition.field949 = var1;
      ObjectComposition.field993 = var2;
   }
}
