import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class165 {
   @ObfuscatedName("m")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("b")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -2127008499
   )
   static int field2174;
   @ObfuscatedName("o")
   public static int[] field2176 = new int[32];
   @ObfuscatedName("mh")
   static byte field2177;
   @ObfuscatedName("ad")
   static class184 field2178;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2176[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)Z",
      garbageValue = "-286500366"
   )
   static boolean method3058(class159 var0, int var1) {
      int var2 = var0.method2986(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2986(1) != 0) {
            method3058(var0, var1);
         }

         var3 = var0.method2986(6);
         var4 = var0.method2986(6);
         boolean var12 = var0.method2986(1) == 1;
         if(var12) {
            class45.field909[++class45.field904 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var11 = Client.cachedPlayers[var1] = new Player();
            var11.field273 = var1;
            if(null != class45.field917[var1]) {
               var11.method210(class45.field917[var1]);
            }

            var11.field655 = class45.field906[var1];
            var11.interacting = class45.field913[var1];
            var7 = class45.field897[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var11.field661[0] = class45.field916[var1];
            var11.field256 = (byte)var8;
            var11.method213((var9 << 6) + var3 - class107.baseX, (var10 << 6) + var4 - XClanMember.baseY);
            var11.field271 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2986(2);
         var4 = class45.field897[var1];
         class45.field897[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method2986(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class45.field897[var1];
            var7 = (var6 >> 28) + var4 & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field897[var1] = (var8 << 14) + (var7 << 28) + var9;
            return false;
         } else {
            var3 = var0.method2986(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class45.field897[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var6 + var7 & 255;
            class45.field897[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }
}
