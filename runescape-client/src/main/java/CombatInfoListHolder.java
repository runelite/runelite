import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("b")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("g")
   @Export("combatInfo1")
   CombatInfoList combatInfo1 = new CombatInfoList();

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(III)Lclass119;",
      garbageValue = "-1259527072"
   )
   static class119 method678(int var0, int var1) {
      Client.field563.field1871 = var0;
      Client.field563.field1865 = var1;
      Client.field563.field1866 = 1;
      Client.field563.field1870 = 1;
      return Client.field563;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "1950392745"
   )
   CombatInfo1 method679(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2311();
      if(var2 != null && var2.field667 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2309(); null != var3 && var3.field667 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2309()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field2833 + var2.field668 + var2.field667 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "28"
   )
   boolean method680() {
      return this.combatInfo1.method2314();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1496259595"
   )
   void method684(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2311(); null != var7; var7 = (CombatInfo1)this.combatInfo1.method2309()) {
         ++var6;
         if(var7.field667 == var1) {
            var7.method591(var1, var2, var3, var4);
            return;
         }

         if(var7.field667 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method2313(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method2310(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2311().unlink();
         }

      }
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "33"
   )
   static void method688(int var0, int var1, int var2, int var3) {
      Widget var4 = class138.method2419(var0, var1);
      if(null != var4 && null != var4.field2298) {
         class18 var5 = new class18();
         var5.field193 = var4;
         var5.field203 = var4.field2298;
         class13.method165(var5);
      }

      Client.field441 = var3;
      Client.field439 = true;
      class155.field2128 = var0;
      Client.field385 = var1;
      class116.field1837 = var2;
      class97.method1886(var4);
   }
}
