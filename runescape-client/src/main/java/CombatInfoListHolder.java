import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("ay")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;

   @ObfuscatedSignature(
      signature = "(Lik;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-55"
   )
   void method1621(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3513(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3527()) {
         ++var6;
         if(var7.field1276 == var1) {
            var7.method1499(var1, var2, var3, var4);
            return;
         }

         if(var7.field1276 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3523(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3511(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3513().unlink();
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Lcf;",
      garbageValue = "1750922639"
   )
   CombatInfo1 method1623(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3513();
      if(var2 != null && var2.field1276 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3527(); var3 != null && var3.field1276 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3527()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3346 + var2.field1276 + var2.field1277 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1690943983"
   )
   boolean method1629() {
      return this.combatInfo1.method3516();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "8"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class238.field3226 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class238.field3226.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class238.field3226.close();
            } catch (Exception var3) {
               ;
            }

            ++class238.field3241;
            class238.field3226 = null;
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1079819001"
   )
   public static boolean method1630(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
