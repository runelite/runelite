import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class39 {
   @ObfuscatedName("t")
   public static class139 field800;
   @ObfuscatedName("l")
   static final BigInteger field801 = new BigInteger("8f9a0e34a0c2c934a4751a0a00c8916081b54fb3bcd1d4a97c5be89c82488b3856a9616ecfed36cff3ade683965b08392dd05a03ffd89523d9736f0f7d71936522b1499ea9d41792b87e15ff450672698d7a15c228ba67a1cda5b56fbc2fd567e0533e46f40f1a586d21ba79dddeaade4f91daa9f571eadbf032106415df761f", 16);
   @ObfuscatedName("b")
   static final BigInteger field802 = new BigInteger("10001", 16);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILclass119;LCollisionData;I)Z",
      garbageValue = "-2109893212"
   )
   static final boolean method811(int var0, int var1, class119 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class118.field1839[var6][var7] = 99;
      class118.field1837[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class118.field1843[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class118.field1844[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class118.field1843[var11];
         var5 = class118.field1844[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2360(1, var4, var5, var3)) {
            class118.field1841 = var4;
            class118.field1840 = var5;
            return true;
         }

         int var15 = class118.field1837[var16][var17] + 1;
         if(var16 > 0 && class118.field1839[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class118.field1843[var18] = var4 - 1;
            class118.field1844[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1839[var16 - 1][var17] = 2;
            class118.field1837[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class118.field1839[var16 + 1][var17] == 0 && (var12[1 + var13][var14] & 19136896) == 0) {
            class118.field1843[var18] = var4 + 1;
            class118.field1844[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1839[var16 + 1][var17] = 8;
            class118.field1837[1 + var16][var17] = var15;
         }

         if(var17 > 0 && class118.field1839[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1843[var18] = var4;
            class118.field1844[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class118.field1839[var16][var17 - 1] = 1;
            class118.field1837[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class118.field1839[var16][1 + var17] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class118.field1843[var18] = var4;
            class118.field1844[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class118.field1839[var16][1 + var17] = 4;
            class118.field1837[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class118.field1839[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1843[var18] = var4 - 1;
            class118.field1844[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class118.field1839[var16 - 1][var17 - 1] = 3;
            class118.field1837[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class118.field1839[1 + var16][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1843[var18] = var4 + 1;
            class118.field1844[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1839[var16 + 1][var17 - 1] = 9;
            class118.field1837[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class118.field1839[var16 - 1][1 + var17] == 0 && (var12[var13 - 1][1 + var14] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class118.field1843[var18] = var4 - 1;
            class118.field1844[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class118.field1839[var16 - 1][var17 + 1] = 6;
            class118.field1837[var16 - 1][1 + var17] = var15;
         }

         if(var16 < 127 && var17 < 127 && class118.field1839[1 + var16][1 + var17] == 0 && (var12[var13 + 1][1 + var14] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class118.field1843[var18] = 1 + var4;
            class118.field1844[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class118.field1839[1 + var16][var17 + 1] = 12;
            class118.field1837[var16 + 1][1 + var17] = var15;
         }
      }

      class118.field1841 = var4;
      class118.field1840 = var5;
      return false;
   }

   class39() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;IB)Lclass142;",
      garbageValue = "52"
   )
   static class142 method812(class182 var0, int var1) {
      byte[] var2 = var0.method3353(var1);
      return null == var2?null:new class142(var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "-924654862"
   )
   public static void method813(class182 var0, class182 var1, class182 var2, class182 var3) {
      class215.field3175 = var0;
      Widget.field2188 = var1;
      Widget.field2189 = var2;
      class227.field3248 = var3;
      Widget.widgets = new Widget[class215.field3175.method3392()][];
      Widget.validInterfaces = new boolean[class215.field3175.method3392()];
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1257242751"
   )
   static final void method814(boolean var0) {
      int var1 = Client.widgetRoot;
      int var2 = class2.field21;
      int var3 = class20.field216;
      if(class159.method3142(var1)) {
         class20.method210(Widget.widgets[var1], -1, var2, var3, var0);
      }

   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "106"
   )
   static void method815(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class140.method2681(var0.parentId);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class2.field21;
         var3 = class20.field216;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class15.method190(var0, var2, var3, false);
      class94.method1974(var0, var2, var3);
   }
}
