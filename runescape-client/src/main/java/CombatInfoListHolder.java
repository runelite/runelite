import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field1378;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;

   @ObfuscatedSignature(
      signature = "(Liu;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1956457780"
   )
   void method1688(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3642(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3644()) {
         ++var6;
         if(var7.field1295 == var1) {
            var7.method1546(var1, var2, var3, var4);
            return;
         }

         if(var7.field1295 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3639(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3640(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3642().unlink();
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Lcj;",
      garbageValue = "4"
   )
   CombatInfo1 method1690(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3642();
      if(var2 != null && var2.field1295 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3644(); var3 != null && var3.field1295 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3644()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3373 + var2.field1294 + var2.field1295 > var1) {
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
      signature = "(I)Z",
      garbageValue = "1881744533"
   )
   boolean method1691() {
      return this.combatInfo1.method3645();
   }
}
