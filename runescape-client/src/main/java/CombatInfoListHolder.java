import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("d")
   @Export("combatInfo1")
   CombatInfoList combatInfo1 = new CombatInfoList();
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 719089845
   )
   static int field781;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 811018727
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("gj")
   static Widget field784;
   @ObfuscatedName("c")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = -982768361
   )
   @Export("baseX")
   static int baseX;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-106"
   )
   void method766(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2411(); null != var7; var7 = (CombatInfo1)this.combatInfo1.method2423()) {
         ++var6;
         if(var1 == var7.field689) {
            var7.method623(var1, var2, var3, var4);
            return;
         }

         if(var7.field689 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.combatInfo1.method2415(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method2409(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2411().unlink();
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "-468279338"
   )
   CombatInfo1 method767(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2411();
      if(var2 != null && var2.field689 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2423(); var3 != null && var3.field689 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2423()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field2829 + var2.field689 + var2.field690 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "12"
   )
   boolean method768() {
      return this.combatInfo1.method2414();
   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "30"
   )
   static void method775(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1306701404"
   )
   static final boolean method776(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field365 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field576.method3161(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field576.method3162(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field576.method3164(false);
         }

         if(var1 == 325) {
            Client.field576.method3164(true);
         }

         if(var1 == 326) {
            Client.secretCipherBuffer1.putOpcode(23);
            Client.field576.method3174(Client.secretCipherBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)Ljava/lang/String;",
      garbageValue = "168659425"
   )
   static String method777(Buffer var0, int var1) {
      try {
         int var2 = var0.method3013();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class210.field3130.method2761(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class202.method3802(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
