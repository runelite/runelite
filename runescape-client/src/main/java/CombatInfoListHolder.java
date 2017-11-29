import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   @Export("timer")
   protected static Timer timer;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedSignature(
      signature = "(Lis;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-72"
   )
   void method1729(int var1, int var2, int var3, int var4) {
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
         CombatInfoList.method3721(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.last().unlink();
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lcd;",
      garbageValue = "1793260989"
   )
   CombatInfo1 method1732(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.last();
      if(var2 != null && var2.cycle <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.previous(); var3 != null && var3.cycle <= var1; var3 = (CombatInfo1)this.combatInfo1.previous()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3440 + var2.cycle + var2.int2 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1295560947"
   )
   boolean method1731() {
      return this.combatInfo1.isEmpty();
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1654379339"
   )
   static void method1730(int var0, int var1) {
      if(Client.field1113 != 0 && var0 != -1) {
         Buffer.method3318(class35.indexTrack2, var0, 0, Client.field1113, false);
         Client.field1095 = true;
      }

   }
}
