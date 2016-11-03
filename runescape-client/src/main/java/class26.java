import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class26 extends Node {
   @ObfuscatedName("c")
   class205 field628 = new class205();
   @ObfuscatedName("f")
   class49 field629;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 178108875
   )
   static int field630;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -1954542249
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("y")
   static int[] field634;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -564883689
   )
   static int field635;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = 1839421085
   )
   static int field636;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lclass56;",
      garbageValue = "-1297004405"
   )
   public static class56 method606(int var0) {
      class56 var1 = (class56)class56.field1221.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class56.field1225.method3305(16, var0);
         var1 = new class56();
         if(var2 != null) {
            var1.method1165(new Buffer(var2));
         }

         class56.field1221.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "116"
   )
   boolean method609() {
      return this.field628.method3897();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-469226572"
   )
   static final int method613(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + (789221 + var2 * var2 * 15731) * var2 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1477543751"
   )
   void method615(int var1, int var2, int var3, int var4) {
      class20 var5 = null;
      int var6 = 0;

      for(class20 var7 = (class20)this.field628.method3893(); null != var7; var7 = (class20)this.field628.method3913()) {
         ++var6;
         if(var7.field566 == var1) {
            var7.method567(var1, var2, var3, var4);
            return;
         }

         if(var7.field566 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.field628.method3902(new class20(var1, var2, var3, var4));
         }

      } else {
         class205.method3887(new class20(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.field628.method3893().unlink();
         }

      }
   }

   class26(class49 var1) {
      this.field629 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Lclass20;",
      garbageValue = "-2"
   )
   class20 method619(int var1) {
      class20 var2 = (class20)this.field628.method3893();
      if(var2 != null && var2.field566 <= var1) {
         for(class20 var3 = (class20)this.field628.method3913(); var3 != null && var3.field566 <= var1; var3 = (class20)this.field628.method3913()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field567 + var2.field566 + this.field629.field1094 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }
}
