import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljb;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedSignature(
      signature = "(Ljb;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "384907867"
   )
   void method1887(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.last(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.previous()) {
         ++var6;
         if(var7.cycle == var1) {
            var7.set(var1, var2, var3, var4);
            return;
         }

         if(var7.cycle <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.addLast(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3992(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.last().unlink();
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lbp;",
      garbageValue = "-1626141503"
   )
   CombatInfo1 method1881(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.last();
      if(var2 != null && var2.cycle <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.previous(); var3 != null && var3.cycle <= var1; var3 = (CombatInfo1)this.combatInfo1.previous()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3532 + var2.int2 + var2.cycle > var1) {
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
      garbageValue = "1384812962"
   )
   boolean method1882() {
      return this.combatInfo1.isEmpty();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lbd;",
      garbageValue = "1681226249"
   )
   static World method1879() {
      return World.field1211 < World.worldCount?World.worldList[++World.field1211 - 1]:null;
   }
}
