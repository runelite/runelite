import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("om")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("od")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   static class99 field1251;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 692934755
   )
   static int field1254;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedSignature(
      signature = "(Lij;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1900052677"
   )
   void method1807(int var1, int var2, int var3, int var4) {
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
         CombatInfoList.method3831(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.last().unlink();
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Lbj;",
      garbageValue = "79"
   )
   CombatInfo1 method1810(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.last();
      if(var2 != null && var2.cycle <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.previous(); var3 != null && var3.cycle <= var1; var3 = (CombatInfo1)this.combatInfo1.previous()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3429 + var2.int2 + var2.cycle > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "22"
   )
   boolean method1809() {
      return this.combatInfo1.isEmpty();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1785106699"
   )
   public static boolean method1818() {
      ClassInfo var0 = (ClassInfo)class304.classInfos.last();
      return var0 != null;
   }
}
