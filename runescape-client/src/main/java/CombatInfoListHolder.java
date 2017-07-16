import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   static class262 field1362;
   @ObfuscatedName("fk")
   @Export("landRegionFielIds")
   static int[] landRegionFielIds;
   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "[Ljt;"
   )
   static SpritePixels[] field1359;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;

   @ObfuscatedSignature(
      signature = "(Liq;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1331404843"
   )
   void method1652(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3558(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3560()) {
         ++var6;
         if(var7.field1282 == var1) {
            var7.method1516(var1, var2, var3, var4);
            return;
         }

         if(var7.field1282 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3555(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3556(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3558().unlink();
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Lcs;",
      garbageValue = "1"
   )
   CombatInfo1 method1651(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3558();
      if(var2 != null && var2.field1282 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3560(); var3 != null && var3.field1282 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3560()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3372 + var2.field1282 + var2.field1275 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "11674"
   )
   boolean method1660() {
      return this.combatInfo1.method3575();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1891591874"
   )
   static final void method1662(int var0) {
      class134.field1988[++class134.field1995 - 1] = var0;
   }
}
