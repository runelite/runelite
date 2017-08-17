import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class91 {
   @ObfuscatedName("j")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;
   @ObfuscatedName("h")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -186876765
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 669871315
   )
   public static int field1417;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1338916401
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("a3ec4738cfccaae5958718f5369c4e442195a4f385729be09e0482c2cfbc9f149467f93e4d65ae01584e2acef9e26d22019470fb4ec9b1217867f2a208dfb8de5bb8373b361b0e6368f52f2ccb7372cd95d7322242ccc5b39a7ecb27d3df432a5f69bada1a1fc5af8e81247240c37b889512977bcc9f78cf328aab52b67a0af9", 16);
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "99870016"
   )
   static final void method1724(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1129; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1112[var4] = true;
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "862750773"
   )
   public static void method1725() {
      Varbit.varbits.reset();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILfe;Lfc;I)Z",
      garbageValue = "-419985251"
   )
   public static final boolean method1726(int var0, int var1, class164 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class163.field2307[var6][var7] = 99;
      class163.field2308[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class163.field2310[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class163.field2311[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class163.field2310[var11];
         var5 = class163.field2311[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3088(1, var4, var5, var3)) {
            class164.field2316 = var4;
            class163.field2309 = var5;
            return true;
         }

         int var15 = class163.field2308[var16][var17] + 1;
         if(var16 > 0 && class163.field2307[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class163.field2310[var18] = var4 - 1;
            class163.field2311[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 - 1][var17] = 2;
            class163.field2308[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class163.field2307[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class163.field2310[var18] = var4 + 1;
            class163.field2311[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 + 1][var17] = 8;
            class163.field2308[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class163.field2307[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class163.field2310[var18] = var4;
            class163.field2311[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16][var17 - 1] = 1;
            class163.field2308[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class163.field2307[var16][var17 + 1] == 0 && 0 == (var12[var13][var14 + 1] & 19136800)) {
            class163.field2310[var18] = var4;
            class163.field2311[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16][var17 + 1] = 4;
            class163.field2308[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class163.field2307[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class163.field2310[var18] = var4 - 1;
            class163.field2311[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 - 1][var17 - 1] = 3;
            class163.field2308[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && 0 == class163.field2307[var16 + 1][var17 - 1] && 0 == (var12[var13 + 1][var14 - 1] & 19136899) && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class163.field2310[var18] = var4 + 1;
            class163.field2311[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 + 1][var17 - 1] = 9;
            class163.field2308[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class163.field2307[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class163.field2310[var18] = var4 - 1;
            class163.field2311[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 - 1][var17 + 1] = 6;
            class163.field2308[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class163.field2307[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && 0 == (var12[var13][var14 + 1] & 19136800)) {
            class163.field2310[var18] = var4 + 1;
            class163.field2311[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 + 1][var17 + 1] = 12;
            class163.field2308[var16 + 1][var17 + 1] = var15;
         }
      }

      class164.field2316 = var4;
      class163.field2309 = var5;
      return false;
   }
}
