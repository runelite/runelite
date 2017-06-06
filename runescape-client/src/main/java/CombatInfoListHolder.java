import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("e")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("v")
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)LCombatInfo1;",
      garbageValue = "102"
   )
   CombatInfo1 method1673(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3530();
      if(var2 != null && var2.field1306 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3540(); var3 != null && var3.field1306 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3540()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3370 + var2.field1309 + var2.field1306 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-882485061"
   )
   boolean method1674() {
      return this.combatInfo1.method3538();
   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "110"
   )
   void method1680(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3530(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3540()) {
         ++var6;
         if(var7.field1306 == var1) {
            var7.method1536(var1, var2, var3, var4);
            return;
         }

         if(var7.field1306 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3532(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3539(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3530().unlink();
         }

      }
   }
}
