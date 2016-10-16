import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class26 extends Node {
   @ObfuscatedName("y")
   class205 field617 = new class205();
   @ObfuscatedName("du")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("t")
   class49 field622;

   class26(class49 var1) {
      this.field622 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lclass20;",
      garbageValue = "-998664496"
   )
   class20 method594(int var1) {
      class20 var2 = (class20)this.field617.method3850();
      if(null != var2 && var2.field556 <= var1) {
         for(class20 var3 = (class20)this.field617.method3852(); var3 != null && var3.field556 <= var1; var3 = (class20)this.field617.method3852()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field556 + var2.field553 + this.field622.field1056 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1962334010"
   )
   boolean method595() {
      return this.field617.method3866();
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-31319"
   )
   static final void method600() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[1 + var1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[1 + var1];
               Client.menuTypes[1 + var1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
               Client.menuActionParams0[1 + var1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[1 + var1] = var4;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "45"
   )
   static void method604() {
      class34.field743 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class34.field742[var0] = null;
         class34.field741[var0] = 1;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1678565417"
   )
   void method605(int var1, int var2, int var3, int var4) {
      class20 var5 = null;
      int var6 = 0;

      for(class20 var7 = (class20)this.field617.method3850(); null != var7; var7 = (class20)this.field617.method3852()) {
         ++var6;
         if(var1 == var7.field556) {
            var7.method533(var1, var2, var3, var4);
            return;
         }

         if(var7.field556 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.field617.method3851(new class20(var1, var2, var3, var4));
         }

      } else {
         class205.method3846(new class20(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.field617.method3850().unlink();
         }

      }
   }
}
