import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("x")
   @Export("blendedHue")
   static int[] blendedHue;
   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "[Ljo;"
   )
   static IndexedSprite[] field1360;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedSignature(
      signature = "(Lio;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "100"
   )
   void method1680(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3655(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3677()) {
         ++var6;
         if(var7.field1275 == var1) {
            var7.method1543(var1, var2, var3, var4);
            return;
         }

         if(var7.field1275 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3652(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3680(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3655().unlink();
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lbu;",
      garbageValue = "-2096616607"
   )
   CombatInfo1 method1685(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3655();
      if(var2 != null && var2.field1275 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3677(); var3 != null && var3.field1275 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3677()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3368 + var2.field1275 + var2.field1272 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "751634212"
   )
   boolean method1679() {
      return this.combatInfo1.method3658();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-693463450"
   )
   static final boolean method1681() {
      return class132.field1988;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lip;IIIZI)V",
      garbageValue = "47346113"
   )
   public static void method1691(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class203.field2500 = 1;
      class87.field1392 = var0;
      class203.field2502 = var1;
      class203.field2505 = var2;
      class10.field268 = var3;
      DynamicObject.field1539 = var4;
      class36.field523 = 10000;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-84990278"
   )
   public static String method1692(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lco;I)V",
      garbageValue = "746408263"
   )
   static void method1686(World var0) {
      if(var0.method1546() != Client.isMembers) {
         Client.isMembers = var0.method1546();
         boolean var1 = var0.method1546();
         if(var1 != ItemComposition.isMembersWorld) {
            class208.method3989();
            ItemComposition.isMembersWorld = var1;
         }
      }

      class35.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      Frames.field2120 = Client.socketType == 0?43594:var0.id + 40000;
      Signlink.field2230 = Client.socketType == 0?443:var0.id + 50000;
      class51.myWorldPort = Frames.field2120;
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "100"
   )
   static final void method1689(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4731()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1221 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1017[var4][var5] == Client.field1018) {
                     continue;
                  }

                  Client.field1017[var4][var5] = Client.field1018;
               }

               if(!var2.composition.field3582) {
                  var3 -= Integer.MIN_VALUE;
               }

               class3.region.method2718(class46.plane, var2.x, var2.y, class41.getTileHeight(var2.field1221 * 64 - 64 + var2.x, var2.field1221 * 64 - 64 + var2.y, class46.plane), var2.field1221 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1212);
            }
         }
      }

   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   static void method1688() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3637(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3638()) {
         int var1 = var0.id;
         if(WorldMapData.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = class215.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = ItemLayer.method2454(var4);
               if(var5 != null) {
                  class45.method647(var5);
               }
            }
         }
      }

   }
}
