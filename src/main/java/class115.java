import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class115 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 4019001290620603617L
   )
   static long field1991;

   @ObfuscatedName("s")
   static void method2447(class25 var0) {
      if(var0.method635() != client.field300) {
         client.field300 = var0.method635();
         class40.method864(var0.method635());
      }

      class107.field1891 = var0.field649;
      client.field296 = var0.field650;
      client.field503 = var0.field647;
      class21.field592 = client.field299 == 0?'ꩊ':var0.field650 + '鱀';
      class18.field267 = client.field299 == 0?443:var0.field650 + '썐';
      class93.field1607 = class21.field592;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIILclass86;[Lclass108;I)V",
      garbageValue = "2037158590"
   )
   static final void method2448(byte[] var0, int var1, int var2, class86 var3, class108[] var4) {
      class119 var5 = new class119(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method2571();
         if(0 == var7) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method2571();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.method2506();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var2 + var10;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if(2 == (class5.field109[1][var16][var17] & 2)) {
                  var18 = var12 - 1;
               }

               class108 var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class122.method2778(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-1069484411"
   )
   public static void method2449(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2449(var0, var1, var2, var5 - 1);
         method2449(var0, var1, 1 + var5, var3);
      }

   }
}
