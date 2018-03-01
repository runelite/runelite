import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -1840552905
   )
   static int field1289;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedSignature(
      signature = "(Ljc;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1903131180"
   )
   void method1848(int var1, int var2, int var3, int var4) {
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
         CombatInfoList.method4086(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.last().unlink();
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lbo;",
      garbageValue = "1852366583"
   )
   CombatInfo1 method1850(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.last();
      if(var2 != null && var2.cycle <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.previous(); var3 != null && var3.cycle <= var1; var3 = (CombatInfo1)this.combatInfo1.previous()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3525 + var2.int2 + var2.cycle > var1) {
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
      signature = "(I)Z",
      garbageValue = "35300551"
   )
   boolean method1851() {
      return this.combatInfo1.isEmpty();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "94"
   )
   public static int method1862(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1023329759"
   )
   public static boolean method1849(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(Lbh;B)V",
      garbageValue = "-22"
   )
   static final void method1860(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class86.region.method2994(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class86.region.method3034(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class86.region.method2944(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class86.region.method3084(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class86.region.getObjectFlags(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1128 = var2;
      var0.field1135 = var3;
      var0.field1129 = var4;
   }
}
