import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class36 {
   @ObfuscatedName("t")
   static final BigInteger field764;
   @ObfuscatedName("p")
   static final BigInteger field765;
   @ObfuscatedName("cd")
   static Font field766;
   @ObfuscatedName("u")
   public static int[] field772;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-896184116"
   )
   static int method747(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field489 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILclass119;LCollisionData;B)Z",
      garbageValue = "98"
   )
   public static final boolean method748(int var0, int var1, class119 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class118.field1845[var6][var7] = 99;
      class118.field1843[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class118.field1846[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class118.field1847[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class118.field1846[var11];
         var5 = class118.field1847[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2294(1, var4, var5, var3)) {
            class118.field1844 = var4;
            class118.field1842 = var5;
            return true;
         }

         int var15 = class118.field1843[var16][var17] + 1;
         if(var16 > 0 && class118.field1845[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class118.field1846[var18] = var4 - 1;
            class118.field1847[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 - 1][var17] = 2;
            class118.field1843[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class118.field1845[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class118.field1846[var18] = var4 + 1;
            class118.field1847[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 + 1][var17] = 8;
            class118.field1843[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class118.field1845[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1846[var18] = var4;
            class118.field1847[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16][var17 - 1] = 1;
            class118.field1843[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class118.field1845[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class118.field1846[var18] = var4;
            class118.field1847[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16][var17 + 1] = 4;
            class118.field1843[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class118.field1845[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1846[var18] = var4 - 1;
            class118.field1847[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 - 1][var17 - 1] = 3;
            class118.field1843[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class118.field1845[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1846[var18] = var4 + 1;
            class118.field1847[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 + 1][var17 - 1] = 9;
            class118.field1843[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class118.field1845[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class118.field1846[var18] = var4 - 1;
            class118.field1847[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 - 1][var17 + 1] = 6;
            class118.field1843[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class118.field1845[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class118.field1846[var18] = var4 + 1;
            class118.field1847[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 + 1][var17 + 1] = 12;
            class118.field1843[var16 + 1][var17 + 1] = var15;
         }
      }

      class118.field1844 = var4;
      class118.field1842 = var5;
      return false;
   }

   static {
      field764 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field765 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZB)V",
      garbageValue = "-99"
   )
   static final void method752(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            if(var6) {
               Client.field431 = Client.menuOptionCount;
            }

            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "23"
   )
   public static int method753(String var0) {
      return var0.length() + 1;
   }

   class36() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-636350175"
   )
   public static int method755(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
