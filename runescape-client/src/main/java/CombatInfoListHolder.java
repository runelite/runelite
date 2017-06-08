import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("j")
   @Export("combatInfo1")
   CombatInfoList combatInfo1;
   @ObfuscatedName("i")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1481870567"
   )
   void method1658(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3571(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3573()) {
         ++var6;
         if(var1 == var7.field1293) {
            var7.method1517(var1, var2, var3, var4);
            return;
         }

         if(var7.field1293 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3576(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3585(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3571().unlink();
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)LCombatInfo1;",
      garbageValue = "-119"
   )
   CombatInfo1 method1660(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3571();
      if(var2 != null && var2.field1293 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3573(); var3 != null && var3.field1293 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3573()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3370 + var2.field1293 + var2.field1291 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1667704433"
   )
   boolean method1661() {
      return this.combatInfo1.method3568();
   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lclass240;",
      garbageValue = "1957328525"
   )
   public static class240 method1664(int var0) {
      class240 var1 = (class240)class240.field3284.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class240.field3283.getConfigData(5, var0);
         var1 = new class240();
         if(var2 != null) {
            var1.method4291(new Buffer(var2));
         }

         class240.field3284.put(var1, (long)var0);
         return var1;
      }
   }
}
