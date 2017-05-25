import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("u")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("gu")
   static SpritePixels[] field1347;
   @ObfuscatedName("q")
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2124701452"
   )
   void method1697(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3620(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3625()) {
         ++var6;
         if(var1 == var7.field1259) {
            var7.method1547(var1, var2, var3, var4);
            return;
         }

         if(var7.field1259 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3619(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3627(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3620().unlink();
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "-755406857"
   )
   CombatInfo1 method1699(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3620();
      if(var2 != null && var2.field1259 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3625(); var3 != null && var3.field1259 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3625()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field1259 + var2.field1261 + this.combatInfo2.field3359 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1707523715"
   )
   boolean method1703() {
      return this.combatInfo1.method3626();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "33"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class98.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method1896(var0, var1, var2, var3);
      class98.field1519.method3575(var5, (long)var5.id);
      class98.field1518.method3723(var5);
      Client.field1082 = Client.field1075;
   }
}
