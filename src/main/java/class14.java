import java.awt.Component;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class14 {
   @ObfuscatedName("e")
   class22 field207;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -938208275
   )
   int field208 = -1;
   @ObfuscatedName("h")
   public static class167 field209;
   @ObfuscatedName("s")
   String[] field210;
   @ObfuscatedName("q")
   static int[] field212;
   @ObfuscatedName("da")
   static int[][] field213;
   @ObfuscatedName("f")
   int[] field214;

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-31443603"
   )
   static final void method167(boolean var0) {
      class11.method155();
      ++client.field347;
      if(client.field347 >= 50 || var0) {
         client.field347 = 0;
         if(!client.field332 && class46.field1040 != null) {
            client.field321.method2762(240);

            try {
               class46.field1040.method2983(client.field321.field1980, 0, client.field321.field1976);
               client.field321.field1976 = 0;
            } catch (IOException var2) {
               client.field332 = true;
            }
         }

      }
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1081512486"
   )
   static final void method168(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field411.method3825(); null != var10; var10 = (class16)client.field411.method3827()) {
         if(var10.field239 == var0 && var10.field226 == var1 && var2 == var10.field227 && var10.field225 == var3) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class16();
         var9.field239 = var0;
         var9.field225 = var3;
         var9.field226 = var1;
         var9.field227 = var2;
         class90.method2101(var9);
         client.field411.method3834(var9);
      }

      var9.field238 = var4;
      var9.field224 = var5;
      var9.field232 = var6;
      var9.field234 = var7;
      var9.field235 = var8;
   }

   @ObfuscatedName("az")
   public static class77 method169(int var0, int var1, Component var2) {
      try {
         class81 var3 = new class81();
         var3.vmethod1885(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         class75 var4 = new class75();
         var4.vmethod1885(var0, var1, var2);
         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "1308074787"
   )
   public static void method170(String[] var0, short[] var1, int var2, int var3) {
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
         method170(var0, var1, var2, var5 - 1);
         method170(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("e")
   public static boolean method171(int var0, int var1) {
      return (var0 >> 1 + var1 & 1) != 0;
   }

   @ObfuscatedName("n")
   static final int method172(int var0, int var1) {
      int var2 = class104.method2321(var0 - 1, var1 - 1) + class104.method2321(1 + var0, var1 - 1) + class104.method2321(var0 - 1, var1 + 1) + class104.method2321(1 + var0, var1 + 1);
      int var3 = class104.method2321(var0 - 1, var1) + class104.method2321(var0 + 1, var1) + class104.method2321(var0, var1 - 1) + class104.method2321(var0, 1 + var1);
      int var4 = class104.method2321(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }
}
