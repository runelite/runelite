import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("x")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("q")
   @Export("combatInfo1")
   CombatInfoList combatInfo1 = new CombatInfoList();
   @ObfuscatedName("m")
   static int[] field747;
   @ObfuscatedName("gn")
   static Widget field751;
   @ObfuscatedName("nj")
   static class51 field753;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "507712054"
   )
   void method686(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2381(); null != var7; var7 = (CombatInfo1)this.combatInfo1.method2389()) {
         ++var6;
         if(var1 == var7.field661) {
            var7.method604(var1, var2, var3, var4);
            return;
         }

         if(var7.field661 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method2384(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method2380(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2381().unlink();
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1214990264"
   )
   boolean method687() {
      return this.combatInfo1.method2383();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)LCombatInfo1;",
      garbageValue = "10"
   )
   CombatInfo1 method688(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2381();
      if(var2 != null && var2.field661 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2389(); var3 != null && var3.field661 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2389()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field661 + var2.field656 + this.combatInfo2.field2835 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "353272854"
   )
   public static String method689(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var9 = var2 + var1;
         int var4 = 0;

         for(int var8 = var1; var8 < var9; ++var8) {
            CharSequence var10 = var0[var8];
            if(var10 == null) {
               var4 += 4;
            } else {
               var4 += var10.length();
            }
         }

         StringBuilder var5 = new StringBuilder(var4);

         for(int var6 = var1; var6 < var9; ++var6) {
            CharSequence var7 = var0[var6];
            if(null == var7) {
               var5.append("null");
            } else {
               var5.append(var7);
            }
         }

         return var5.toString();
      }
   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "507024814"
   )
   static final int method694(int var0, int var1) {
      int var2 = class22.method213(var0 + '넵', 91923 + var1, 4) - 128 + (class22.method213(var0 + 10294, '鎽' + var1, 2) - 128 >> 1) + (class22.method213(var0, var1, 1) - 128 >> 2);
      var2 = (int)(0.3D * (double)var2) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "883534738"
   )
   public static void method695(class182 var0, class182 var1) {
      NPCComposition.field3017 = var0;
      NPCComposition.field2994 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lclass177;",
      garbageValue = "-969816803"
   )
   public static class177[] method696() {
      return new class177[]{class177.field2660, class177.field2656, class177.field2669, class177.field2661, class177.field2659, class177.field2658};
   }
}
