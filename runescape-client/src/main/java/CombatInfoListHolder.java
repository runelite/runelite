import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("px")
   static class1 field749;
   @ObfuscatedName("f")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("k")
   @Export("combatInfo1")
   CombatInfoList combatInfo1 = new CombatInfoList();
   @ObfuscatedName("m")
   static String field756;
   @ObfuscatedName("n")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2034109120"
   )
   void method666(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2326(); null != var7; var7 = (CombatInfo1)this.combatInfo1.method2327()) {
         ++var6;
         if(var7.field661 == var1) {
            var7.method588(var1, var2, var3, var4);
            return;
         }

         if(var7.field661 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.combatInfo1.method2329(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method2332(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2326().unlink();
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1820087139"
   )
   boolean method667() {
      return this.combatInfo1.method2328();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "1375948331"
   )
   CombatInfo1 method672(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2326();
      if(var2 != null && var2.field661 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2327(); var3 != null && var3.field661 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2327()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field2841 + var2.field661 + var2.field664 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "255"
   )
   static final void method674() {
      Client.field294.method2976(105);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2313(); null != var0; var0 = (WidgetNode)Client.componentTable.method2321()) {
         if(var0.field180 == 0 || var0.field180 == 3) {
            class26.method560(var0, true);
         }
      }

      if(Client.field450 != null) {
         class94.method1890(Client.field450);
         Client.field450 = null;
      }

   }
}
