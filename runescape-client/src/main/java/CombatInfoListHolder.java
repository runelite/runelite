import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("h")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("p")
   @Export("combatInfo1")
   CombatInfoList combatInfo1 = new CombatInfoList();
   @ObfuscatedName("r")
   public static short[] field782;
   @ObfuscatedName("q")
   static class182 field784;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "1697876566"
   )
   public static void method788(class182 var0) {
      class195.field2859 = var0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1681844780"
   )
   void method789(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2420(); null != var7; var7 = (CombatInfo1)this.combatInfo1.method2415()) {
         ++var6;
         if(var7.field687 == var1) {
            var7.method638(var1, var2, var3, var4);
            return;
         }

         if(var7.field687 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method2422(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method2429(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2420().unlink();
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "1440649719"
   )
   CombatInfo1 method790(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2420();
      if(var2 != null && var2.field687 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2415(); var3 != null && var3.field687 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2415()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field687 + var2.field688 + this.combatInfo2.field2838 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "95"
   )
   boolean method791() {
      return this.combatInfo1.method2421();
   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   static final void method797(boolean var0) {
      Player.method246(Client.widgetRoot, class32.field758, class47.field950, var0);
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1024196132"
   )
   static final boolean method798(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field358 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field432.method3183(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field432.method3172(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field432.method3173(false);
         }

         if(var1 == 325) {
            Client.field432.method3173(true);
         }

         if(var1 == 326) {
            Client.field348.method3073(210);
            Client.field432.method3190(Client.field348);
            return true;
         } else {
            return false;
         }
      }
   }
}
