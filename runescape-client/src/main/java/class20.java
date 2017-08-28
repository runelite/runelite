import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class20 {
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static BufferProvider field342;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgi;III)I",
      garbageValue = "84467782"
   )
   static int method174(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILfk;Lfh;I)Z",
      garbageValue = "-1726180002"
   )
   static final boolean method177(int var0, int var1, class164 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class163.field2307[var6][var7] = 99;
      class163.field2310[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class163.field2306[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class163.field2312[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class163.field2306[var11];
         var5 = class163.field2312[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3145(2, var4, var5, var3)) {
            class89.field1418 = var4;
            class51.field671 = var5;
            return true;
         }

         int var15 = class163.field2310[var16][var17] + 1;
         if(var16 > 0 && class163.field2307[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class163.field2306[var18] = var4 - 1;
            class163.field2312[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 - 1][var17] = 2;
            class163.field2310[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class163.field2307[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && 0 == (var12[var13 + 2][var14 + 1] & 19136992)) {
            class163.field2306[var18] = var4 + 1;
            class163.field2312[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 + 1][var17] = 8;
            class163.field2310[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class163.field2307[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class163.field2306[var18] = var4;
            class163.field2312[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16][var17 - 1] = 1;
            class163.field2310[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class163.field2307[var16][var17 + 1] == 0 && 0 == (var12[var13][var14 + 2] & 19136824) && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class163.field2306[var18] = var4;
            class163.field2312[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16][var17 + 1] = 4;
            class163.field2310[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class163.field2307[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class163.field2306[var18] = var4 - 1;
            class163.field2312[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 - 1][var17 - 1] = 3;
            class163.field2310[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class163.field2307[var16 + 1][var17 - 1] == 0 && 0 == (var12[var13 + 1][var14 - 1] & 19136911) && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && 0 == (var12[var13 + 2][var14] & 19136995)) {
            class163.field2306[var18] = var4 + 1;
            class163.field2312[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 + 1][var17 - 1] = 9;
            class163.field2310[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class163.field2307[var16 - 1][var17 + 1] == 0 && 0 == (var12[var13 - 1][var14 + 1] & 19136830) && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class163.field2306[var18] = var4 - 1;
            class163.field2312[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 - 1][var17 + 1] = 6;
            class163.field2310[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class163.field2307[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && 0 == (var12[var13 + 2][var14 + 1] & 19136995)) {
            class163.field2306[var18] = var4 + 1;
            class163.field2312[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 + 1][var17 + 1] = 12;
            class163.field2310[var16 + 1][var17 + 1] = var15;
         }
      }

      class89.field1418 = var4;
      class51.field671 = var5;
      return false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "269228792"
   )
   static void method176() {
      FileOnDisk var0 = null;

      try {
         var0 = class163.getPreferencesFile("", class56.field695.field3199, true);
         Buffer var1 = Buffer.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method2374(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-121101587"
   )
   public static final boolean method175() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field657 == KeyFocusListener.field661) {
            return false;
         } else {
            class203.field2493 = KeyFocusListener.field656[KeyFocusListener.field657];
            WorldMapType1.field444 = KeyFocusListener.field655[KeyFocusListener.field657];
            KeyFocusListener.field657 = KeyFocusListener.field657 + 1 & 127;
            return true;
         }
      }
   }
}
