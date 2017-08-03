import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;

   @ObfuscatedSignature(
      signature = "(Lir;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-646248903"
   )
   void method1688(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3581(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3576()) {
         ++var6;
         if(var7.field1257 == var1) {
            var7.method1555(var1, var2, var3, var4);
            return;
         }

         if(var7.field1257 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3590(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3579(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3581().unlink();
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lcl;",
      garbageValue = "1093401651"
   )
   CombatInfo1 method1695(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3581();
      if(var2 != null && var2.field1257 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3576(); var3 != null && var3.field1257 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3576()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3343 + var2.field1257 + var2.field1253 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-9"
   )
   boolean method1690() {
      return this.combatInfo1.method3584();
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1710320691"
   )
   static void method1687(int var0, int var1) {
      if(Client.field1119 != 0 && var0 != -1) {
         class177.method3419(class3.indexTrack2, var0, 0, Client.field1119, false);
         Client.field1121 = true;
      }

   }
}
