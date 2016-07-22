import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class26 extends class211 {
   @ObfuscatedName("e")
   class49 field635;
   @ObfuscatedName("o")
   class205 field638 = new class205();
   @ObfuscatedName("bx")
   static class83 field639;
   @ObfuscatedName("v")
   static class176 field640;

   class26(class49 var1) {
      this.field635 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-785169225"
   )
   public static boolean method600(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lclass20;",
      garbageValue = "468023987"
   )
   class20 method601(int var1) {
      class20 var2 = (class20)this.field638.method3921();
      if(null != var2 && var2.field565 <= var1) {
         for(class20 var3 = (class20)this.field638.method3936(); null != var3 && var3.field565 <= var1; var3 = (class20)this.field638.method3936()) {
            var2.method3990();
            var2 = var3;
         }

         if(var2.field558 + var2.field565 + this.field635.field1095 > var1) {
            return var2;
         } else {
            var2.method3990();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1130922725"
   )
   boolean method602() {
      return this.field638.method3924();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "315800041"
   )
   void method604(int var1, int var2, int var3, int var4) {
      class20 var5 = null;
      int var6 = 0;

      for(class20 var7 = (class20)this.field638.method3921(); var7 != null; var7 = (class20)this.field638.method3936()) {
         ++var6;
         if(var7.field565 == var1) {
            var7.method552(var1, var2, var3, var4);
            return;
         }

         if(var7.field565 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.field638.method3918(new class20(var1, var2, var3, var4));
         }

      } else {
         class205.method3923(new class20(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.field638.method3921().method3990();
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-101"
   )
   static void method611() {
      for(class24 var0 = (class24)class24.field624.method3882(); null != var0; var0 = (class24)class24.field624.method3891()) {
         if(var0.field609 != null) {
            class18.field254.method1228(var0.field609);
            var0.field609 = null;
         }

         if(var0.field614 != null) {
            class18.field254.method1228(var0.field614);
            var0.field614 = null;
         }
      }

      class24.field624.method3893();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1168627458"
   )
   static int method613(int var0, int var1) {
      class15 var2 = (class15)class15.field204.method3856((long)var0);
      if(null == var2) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.field199.length; ++var4) {
            if(var1 == var2.field206[var4]) {
               var3 += var2.field199[var4];
            }
         }

         return var3;
      }
   }
}
