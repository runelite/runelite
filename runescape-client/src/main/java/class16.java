import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("b")
public class class16 extends class131 {
   @ObfuscatedName("n")
   String field166;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -607753741
   )
   static int field168;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 863513489
   )
   int field169 = (int)(WallObject.method1985() / 1000L);
   @ObfuscatedName("eb")
   static SpritePixels[] field170;
   @ObfuscatedName("g")
   short field173;

   class16(String var1, int var2) {
      this.field166 = var1;
      this.field173 = (short)var2;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "2087004505"
   )
   static final void method194(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field392.method2503(); var10 != null; var10 = (class25)Client.field392.method2492()) {
         if(var0 == var10.field581 && var1 == var10.field577 && var2 == var10.field578 && var10.field585 == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class25();
         var9.field581 = var0;
         var9.field585 = var3;
         var9.field577 = var1;
         var9.field578 = var2;
         XClanMember.method260(var9);
         Client.field392.method2511(var9);
      }

      var9.field582 = var4;
      var9.field584 = var5;
      var9.field583 = var6;
      var9.field586 = var7;
      var9.field575 = var8;
   }

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "337220700"
   )
   static void method195(String var0) {
      Client.field303 = var0;

      try {
         String var1 = Client.field556.getParameter(class214.field3165.field3177);
         String var2 = Client.field556.getParameter(class214.field3175.field3177);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class97.method2027(WallObject.method1985() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         Client var4 = Client.field556;
         String var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var4).eval(var5);
      } catch (Throwable var6) {
         ;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1576309929"
   )
   public static final boolean method196() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1700 == class105.field1728) {
            return false;
         } else {
            class13.field131 = class105.field1704[class105.field1700];
            class1.field8 = class105.field1722[class105.field1700];
            class105.field1700 = class105.field1700 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILclass119;LCollisionData;I)Z",
      garbageValue = "1712477075"
   )
   public static final boolean method197(int var0, int var1, class119 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class118.field1851[var6][var7] = 99;
      class118.field1844[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class118.field1843[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class118.field1845[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class118.field1843[var11];
         var5 = class118.field1845[var11];
         var11 = 1 + var11 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2386(2, var4, var5, var3)) {
            class118.field1842 = var4;
            class118.field1846 = var5;
            return true;
         }

         int var15 = class118.field1844[var16][var17] + 1;
         if(var16 > 0 && class118.field1851[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][1 + var14] & 19136824) == 0) {
            class118.field1843[var18] = var4 - 1;
            class118.field1845[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1851[var16 - 1][var17] = 2;
            class118.field1844[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class118.field1851[1 + var16][var17] == 0 && (var12[2 + var13][var14] & 19136899) == 0 && (var12[2 + var13][1 + var14] & 19136992) == 0) {
            class118.field1843[var18] = var4 + 1;
            class118.field1845[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1851[1 + var16][var17] = 8;
            class118.field1844[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class118.field1851[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[1 + var13][var14 - 1] & 19136899) == 0) {
            class118.field1843[var18] = var4;
            class118.field1845[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1851[var16][var17 - 1] = 1;
            class118.field1844[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class118.field1851[var16][1 + var17] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][2 + var14] & 19136992) == 0) {
            class118.field1843[var18] = var4;
            class118.field1845[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class118.field1851[var16][var17 + 1] = 4;
            class118.field1844[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && class118.field1851[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class118.field1843[var18] = var4 - 1;
            class118.field1845[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1851[var16 - 1][var17 - 1] = 3;
            class118.field1844[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class118.field1851[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[2 + var13][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class118.field1843[var18] = 1 + var4;
            class118.field1845[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1851[var16 + 1][var17 - 1] = 9;
            class118.field1844[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class118.field1851[var16 - 1][1 + var17] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class118.field1843[var18] = var4 - 1;
            class118.field1845[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class118.field1851[var16 - 1][1 + var17] = 6;
            class118.field1844[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class118.field1851[1 + var16][var17 + 1] == 0 && (var12[var13 + 1][2 + var14] & 19137016) == 0 && (var12[2 + var13][2 + var14] & 19136992) == 0 && (var12[2 + var13][var14 + 1] & 19136995) == 0) {
            class118.field1843[var18] = var4 + 1;
            class118.field1845[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class118.field1851[var16 + 1][1 + var17] = 12;
            class118.field1844[1 + var16][var17 + 1] = var15;
         }
      }

      class118.field1842 = var4;
      class118.field1846 = var5;
      return false;
   }
}
