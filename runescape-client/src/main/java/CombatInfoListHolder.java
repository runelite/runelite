import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "[Ljr;"
   )
   static IndexedSprite[] field1372;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;

   @ObfuscatedSignature(
      signature = "(Lid;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1380404979"
   )
   void method1678(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3572(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3589()) {
         ++var6;
         if(var7.field1283 == var1) {
            var7.method1545(var1, var2, var3, var4);
            return;
         }

         if(var7.field1283 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3569(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3579(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3572().unlink();
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Lcf;",
      garbageValue = "-125"
   )
   CombatInfo1 method1680(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3572();
      if(var2 != null && var2.field1283 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3589(); var3 != null && var3.field1283 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3589()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3357 + var2.field1283 + var2.field1279 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1456998534"
   )
   boolean method1677() {
      return this.combatInfo1.method3567();
   }
}
