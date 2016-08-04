import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class26 extends class211 {
   @ObfuscatedName("e")
   class205 field647 = new class205();
   @ObfuscatedName("a")
   static int[] field649;
   @ObfuscatedName("r")
   class49 field655;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "113"
   )
   public static int method616(CharSequence var0, int var1) {
      return class5.method91(var0, var1, true);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1340246204"
   )
   void method618(int var1, int var2, int var3, int var4) {
      class20 var5 = null;
      int var6 = 0;

      for(class20 var7 = (class20)this.field647.method4011(); null != var7; var7 = (class20)this.field647.method4013()) {
         ++var6;
         if(var7.field583 == var1) {
            var7.method571(var1, var2, var3, var4);
            return;
         }

         if(var7.field583 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.field647.method4009(new class20(var1, var2, var3, var4));
         }

      } else {
         class205.method4010(new class20(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.field647.method4011().method4067();
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-84"
   )
   boolean method619() {
      return this.field647.method4017();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "112"
   )
   static int method623(int var0, int var1) {
      class15 var2 = (class15)class15.field225.method3936((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.field224.length?var2.field224[var1]:0);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Lclass27;",
      garbageValue = "1475239927"
   )
   static class27 method625() {
      return class27.field664 < class27.field663?class27.field662[++class27.field664 - 1]:null;
   }

   class26(class49 var1) {
      this.field655 = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)Lclass83;",
      garbageValue = "-1549186505"
   )
   static class83 method626(class170 var0, int var1, int var2) {
      if(!class4.method49(var0, var1, var2)) {
         return null;
      } else {
         class83 var4 = new class83();
         var4.field1496 = class79.field1454;
         var4.field1502 = class79.field1456;
         var4.field1500 = class79.field1457[0];
         var4.field1501 = class180.field2962[0];
         var4.field1498 = class192.field3106[0];
         var4.field1503 = class79.field1458[0];
         var4.field1497 = class79.field1459;
         var4.field1499 = class145.field2236[0];
         class55.method1182();
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass20;",
      garbageValue = "-1874798932"
   )
   class20 method627(int var1) {
      class20 var2 = (class20)this.field647.method4011();
      if(var2 != null && var2.field583 <= var1) {
         for(class20 var3 = (class20)this.field647.method4013(); null != var3 && var3.field583 <= var1; var3 = (class20)this.field647.method4013()) {
            var2.method4067();
            var2 = var3;
         }

         if(var2.field577 + var2.field583 + this.field655.field1108 > var1) {
            return var2;
         } else {
            var2.method4067();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1019760893"
   )
   static final void method628(String var0) {
      if(null != class4.field74) {
         client.field337.method2903(103);
         client.field337.method2783(class54.method1165(var0));
         client.field337.method2703(var0);
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lclass39;II)V",
      garbageValue = "489785583"
   )
   static final void method629(class39 var0, int var1) {
      class35.method756(var0.field875, var0.field832, var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1471193617"
   )
   public static void method630() {
      class49.field1100.method3910();
      class49.field1115.method3910();
   }
}
