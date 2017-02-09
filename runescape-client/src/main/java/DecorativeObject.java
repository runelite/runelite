import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 902214613
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1216538467
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1606769689
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -428581447
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1520110451
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1989015177
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2031378505
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked = 0;
   @ObfuscatedName("d")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("n")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1404301829
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1715294221
   )
   @Export("floor")
   int floor;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILclass119;LCollisionData;S)Z",
      garbageValue = "-11141"
   )
   public static final boolean method1906(int var0, int var1, class119 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class118.field1838[var6][var7] = 99;
      class118.field1840[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class118.field1842[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class118.field1843[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class118.field1842[var11];
         var5 = class118.field1843[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2275(2, var4, var5, var3)) {
            class118.field1844 = var4;
            class105.field1722 = var5;
            return true;
         }

         int var15 = 1 + class118.field1840[var16][var17];
         if(var16 > 0 && class118.field1838[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][1 + var14] & 19136824) == 0) {
            class118.field1842[var18] = var4 - 1;
            class118.field1843[var18] = var5;
            var18 = 1 + var18 & 4095;
            class118.field1838[var16 - 1][var17] = 2;
            class118.field1840[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class118.field1838[1 + var16][var17] == 0 && (var12[2 + var13][var14] & 19136899) == 0 && (var12[2 + var13][1 + var14] & 19136992) == 0) {
            class118.field1842[var18] = var4 + 1;
            class118.field1843[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1838[var16 + 1][var17] = 8;
            class118.field1840[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class118.field1838[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[1 + var13][var14 - 1] & 19136899) == 0) {
            class118.field1842[var18] = var4;
            class118.field1843[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1838[var16][var17 - 1] = 1;
            class118.field1840[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class118.field1838[var16][1 + var17] == 0 && (var12[var13][2 + var14] & 19136824) == 0 && (var12[1 + var13][2 + var14] & 19136992) == 0) {
            class118.field1842[var18] = var4;
            class118.field1843[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class118.field1838[var16][1 + var17] = 4;
            class118.field1840[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class118.field1838[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class118.field1842[var18] = var4 - 1;
            class118.field1843[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class118.field1838[var16 - 1][var17 - 1] = 3;
            class118.field1840[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class118.field1838[var16 + 1][var17 - 1] == 0 && (var12[1 + var13][var14 - 1] & 19136911) == 0 && (var12[2 + var13][var14 - 1] & 19136899) == 0 && (var12[2 + var13][var14] & 19136995) == 0) {
            class118.field1842[var18] = var4 + 1;
            class118.field1843[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class118.field1838[1 + var16][var17 - 1] = 9;
            class118.field1840[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class118.field1838[var16 - 1][1 + var17] == 0 && (var12[var13 - 1][1 + var14] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class118.field1842[var18] = var4 - 1;
            class118.field1843[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class118.field1838[var16 - 1][var17 + 1] = 6;
            class118.field1840[var16 - 1][1 + var17] = var15;
         }

         if(var16 < 126 && var17 < 126 && class118.field1838[1 + var16][var17 + 1] == 0 && (var12[var13 + 1][2 + var14] & 19137016) == 0 && (var12[2 + var13][2 + var14] & 19136992) == 0 && (var12[2 + var13][1 + var14] & 19136995) == 0) {
            class118.field1842[var18] = var4 + 1;
            class118.field1843[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class118.field1838[var16 + 1][1 + var17] = 12;
            class118.field1840[var16 + 1][1 + var17] = var15;
         }
      }

      class118.field1844 = var4;
      class105.field1722 = var5;
      return false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-2114831228"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method904(var0, var1, var2, var3);
      class47.field925.method2296(var5, (long)var5.id);
      class47.field926.method2447(var5);
      Client.field469 = Client.field462;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass166;B)I",
      garbageValue = "42"
   )
   static int method1908(class166 var0) {
      int var1 = var0.method3176(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3176(5);
      } else if(var1 == 2) {
         var2 = var0.method3176(8);
      } else {
         var2 = var0.method3176(11);
      }

      return var2;
   }
}
