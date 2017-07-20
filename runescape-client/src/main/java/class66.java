import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class66 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lbc;"
   )
   static final class66 field810;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lbc;"
   )
   static final class66 field808;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lbc;"
   )
   static final class66 field811;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lbc;"
   )
   static final class66 field809;
   @ObfuscatedName("fo")
   static int[] field807;

   static {
      field810 = new class66();
      field808 = new class66();
      field811 = new class66();
      field809 = new class66();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Liu;",
      garbageValue = "1847990125"
   )
   public static class243 method1041(int var0) {
      class243 var1 = (class243)class243.field3287.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class243.field3286.getConfigData(19, var0);
         var1 = new class243();
         if(var2 != null) {
            var1.method4206(new Buffer(var2));
         }

         class243.field3287.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "2125551955"
   )
   static void method1042(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
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
         method1042(var0, var1, var2, var5 - 1);
         method1042(var0, var1, var5 + 1, var3);
      }

   }
}
