import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedSignature(
      signature = "(Liv;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "7713"
   )
   void method1644(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3611(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3613()) {
         ++var6;
         if(var7.field1207 == var1) {
            var7.method1514(var1, var2, var3, var4);
            return;
         }

         if(var7.field1207 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3608(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3609(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3611().unlink();
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Lce;",
      garbageValue = "-5"
   )
   CombatInfo1 method1650(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3611();
      if(var2 != null && var2.field1207 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3613(); var3 != null && var3.field1207 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3613()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3411 + var2.field1210 + var2.field1207 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "316622366"
   )
   boolean method1646() {
      return this.combatInfo1.method3614();
   }
}
