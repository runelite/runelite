import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("y")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("v")
   @Export("combatInfo1")
   CombatInfoList combatInfo1 = new CombatInfoList();
   @ObfuscatedName("em")
   static SpritePixels[] field758;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -1487648757
   )
   static int field759;
   @ObfuscatedName("g")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "-966566669"
   )
   static final void method778(class159 var0) {
      var0.method3165();
      int var1 = Client.localInteractingIndex;
      Player var2 = WidgetNode.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field250 = var1;
      int var3 = var0.method3147(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - Player.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method232() << 6);
      var2.pathY[0] = var6 - SecondaryBufferProvider.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method232() << 6);
      CollisionData.plane = var2.field261 = var4;
      if(null != class45.field911[var1]) {
         var2.method228(class45.field911[var1]);
      }

      class45.field916 = 0;
      class45.field913[++class45.field916 - 1] = var1;
      class45.field909[var1] = 0;
      class45.field914 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method3147(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class45.field912[var7] = var11 + (var10 << 14) + (var9 << 28);
            class45.field917[var7] = 0;
            class45.field910[var7] = -1;
            class45.field915[++class45.field914 - 1] = var7;
            class45.field909[var7] = 0;
         }
      }

      var0.method3148();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-62"
   )
   boolean method779() {
      return this.combatInfo1.method2460();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)LCombatInfo1;",
      garbageValue = "77"
   )
   CombatInfo1 method785(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2453();
      if(var2 != null && var2.field669 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2468(); null != var3 && var3.field669 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2468()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field2848 + var2.field668 + var2.field669 > var1) {
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
      signature = "(IIIIIII)I",
      garbageValue = "-1521435042"
   )
   public static int method787(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "14374"
   )
   void method788(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2453(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method2468()) {
         ++var6;
         if(var1 == var7.field669) {
            var7.method643(var1, var2, var3, var4);
            return;
         }

         if(var7.field669 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method2455(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method2456(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2453().unlink();
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1791635321"
   )
   public static boolean method789() {
      ClassInfo var0 = (ClassInfo)class227.field3246.method2453();
      return null != var0;
   }
}
