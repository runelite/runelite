import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 243997961
   )
   public static int field1389;
   @ObfuscatedName("t")
   @Export("combatInfo1")
   CombatInfoList combatInfo1;
   @ObfuscatedName("a")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-124"
   )
   void method1685(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3547(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3558()) {
         ++var6;
         if(var7.field1298 == var1) {
            var7.method1560(var1, var2, var3, var4);
            return;
         }

         if(var7.field1298 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3544(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3545(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3547().unlink();
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "1303756587"
   )
   CombatInfo1 method1686(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3547();
      if(var2 != null && var2.field1298 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3558(); var3 != null && var3.field1298 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3558()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3382 + var2.field1298 + var2.field1301 > var1) {
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
      garbageValue = "1897358739"
   )
   boolean method1688() {
      return this.combatInfo1.method3550();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "16478029"
   )
   public static String method1690(CharSequence var0) {
      String var1 = class56.method850(class37.method516(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }
}
