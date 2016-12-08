import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("m")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 481307097
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1544660437
   )
   @Export("world")
   int world;
   @ObfuscatedName("v")
   boolean field154;
   @ObfuscatedName("u")
   static class228 field155;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      longValue = -1446386515909283143L
   )
   static long field156;
   @ObfuscatedName("o")
   @Export("name")
   String name;
   @ObfuscatedName("h")
   boolean field159;
   @ObfuscatedName("bo")
   static class184 field160;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIB)Z",
      garbageValue = "6"
   )
   public static boolean method170(class182 var0, int var1, int var2) {
      byte[] var3 = var0.method3203(var1, var2);
      if(null == var3) {
         return false;
      } else {
         class2.method29(var3);
         return true;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-491670510"
   )
   public static void method171(String[] var0, short[] var1, int var2, int var3) {
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
         method171(var0, var1, var2, var5 - 1);
         method171(var0, var1, 1 + var5, var3);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1312797069"
   )
   public static int method172(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-127"
   )
   static final void method173(int var0, int var1, int var2, int var3) {
      if(Client.field476 == 1) {
         class8.field63[Client.field396 / 100].method4048(Client.field500 - 8, Client.field395 - 8);
      }

      if(Client.field476 == 2) {
         class8.field63[4 + Client.field396 / 100].method4048(Client.field500 - 8, Client.field395 - 8);
      }

      class187.method3356();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1814218919"
   )
   public static int method174(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }
}
