import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class179 {
   @ObfuscatedName("q")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("f")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("k")
   static int[] field2953 = new int[32];

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2953[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "216218601"
   )
   static final WidgetNode method3480(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field57 = var2;
      Client.componentTable.method3822(var3, (long)var0);
      ItemLayer.method2271(var1);
      Widget var4 = class144.method3012(var0);
      class166.method3253(var4);
      if(Client.field361 != null) {
         class166.method3253(Client.field361);
         Client.field361 = null;
      }

      class117.method2510();
      Projectile.method93(Widget.widgets[var0 >> 16], var4, false);
      class8.method112(var1);
      if(Client.widgetRoot != -1) {
         class158.method3191(Client.widgetRoot, 1);
      }

      return var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILclass110;LCollisionData;I)Z",
      garbageValue = "-443501089"
   )
   public static final boolean method3481(int var0, int var1, class110 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class109.field1924[var6][var7] = 99;
      class109.field1927[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class109.field1928[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class109.field1929[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class109.field1928[var11];
         var5 = class109.field1929[var11];
         var11 = 1 + var11 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2444(1, var4, var5, var3)) {
            class214.field3184 = var4;
            class109.field1934 = var5;
            return true;
         }

         int var15 = class109.field1927[var16][var17] + 1;
         if(var16 > 0 && class109.field1924[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class109.field1928[var18] = var4 - 1;
            class109.field1929[var18] = var5;
            var18 = var18 + 1 & 4095;
            class109.field1924[var16 - 1][var17] = 2;
            class109.field1927[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class109.field1924[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class109.field1928[var18] = 1 + var4;
            class109.field1929[var18] = var5;
            var18 = var18 + 1 & 4095;
            class109.field1924[var16 + 1][var17] = 8;
            class109.field1927[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class109.field1924[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1928[var18] = var4;
            class109.field1929[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1924[var16][var17 - 1] = 1;
            class109.field1927[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class109.field1924[var16][1 + var17] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class109.field1928[var18] = var4;
            class109.field1929[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class109.field1924[var16][1 + var17] = 4;
            class109.field1927[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && class109.field1924[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1928[var18] = var4 - 1;
            class109.field1929[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1924[var16 - 1][var17 - 1] = 3;
            class109.field1927[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class109.field1924[var16 + 1][var17 - 1] == 0 && (var12[1 + var13][var14 - 1] & 19136899) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1928[var18] = var4 + 1;
            class109.field1929[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1924[1 + var16][var17 - 1] = 9;
            class109.field1927[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class109.field1924[var16 - 1][1 + var17] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class109.field1928[var18] = var4 - 1;
            class109.field1929[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class109.field1924[var16 - 1][var17 + 1] = 6;
            class109.field1927[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class109.field1924[1 + var16][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class109.field1928[var18] = var4 + 1;
            class109.field1929[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class109.field1924[1 + var16][var17 + 1] = 12;
            class109.field1927[1 + var16][1 + var17] = var15;
         }
      }

      class214.field3184 = var4;
      class109.field1934 = var5;
      return false;
   }
}
