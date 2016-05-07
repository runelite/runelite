import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class153 {
   @ObfuscatedName("d")
   public final String field2285;
   @ObfuscatedName("x")
   static final class153 field2286 = new class153("WIP", 2);
   @ObfuscatedName("p")
   static final class153 field2287 = new class153("RC", 1);
   @ObfuscatedName("j")
   static final class153 field2288 = new class153("BUILDLIVE", 3);
   @ObfuscatedName("s")
   static final class153 field2289 = new class153("LIVE", 0);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -129821817
   )
   public final int field2290;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "1"
   )
   static final void method3132(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = 6 + var2;
      int var5 = class181.field2945.method4023(var0, 250);
      int var6 = class181.field2945.method4000(var0, 250) * 13;
      class79.method1808(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      class79.method1779(var3 - var2, var4 - var2, var2 + var2 + var5, var6 + var2 + var2, 16777215);
      class181.field2945.method4005(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class4.method41(var3 - var2, var4 - var2, var2 + var2 + var5, var6 + var2 + var2);

      try {
         Graphics var7 = class122.field2024.getGraphics();
         class135.field2094.vmethod1857(var7, 0, 0);
      } catch (Exception var8) {
         class122.field2024.repaint();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1016758901"
   )
   static void method3134(int var0, int var1, int var2) {
      if(client.field519 != 0 && var1 != 0 && client.field521 < 50) {
         client.field537[client.field521] = var0;
         client.field523[client.field521] = var1;
         client.field524[client.field521] = var2;
         client.field526[client.field521] = null;
         client.field407[client.field521] = 0;
         ++client.field521;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILclass86;[Lclass108;I)V",
      garbageValue = "-2138217205"
   )
   static final void method3135(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class86 var8, class108[] var9) {
      class119 var10 = new class119(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2505();
         if(0 == var12) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2505();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.method2492();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < 8 + var6) {
               class40 var21 = class9.method120(var11);
               int var22 = var2 + class37.method733(var16 & 7, var15 & 7, var7, var21.field939, var21.field966, var20);
               int var23 = var3 + class158.method3149(var16 & 7, var15 & 7, var7, var21.field939, var21.field966, var20);
               if(var22 > 0 && var23 > 0 && var22 < 103 && var23 < 103) {
                  int var24 = var1;
                  if((class5.field90[1][var22][var23] & 2) == 2) {
                     var24 = var1 - 1;
                  }

                  class108 var25 = null;
                  if(var24 >= 0) {
                     var25 = var9[var24];
                  }

                  class161.method3164(var1, var22, var23, var11, var20 + var7 & 3, var19, var8, var25);
               }
            }
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class153(String var1, int var2) {
      this.field2285 = var1;
      this.field2290 = var2;
   }
}
