import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aq")
public class class26 {
   @ObfuscatedName("ec")
   static class78[] field630;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = 1729931565
   )
   static int field644;

   @ObfuscatedName("w")
   public static class40 method633(int var0) {
      class40 var1 = (class40)class40.field928.method3754((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class40.field899.method3280(6, var0);
         var1 = new class40();
         var1.field906 = var0;
         if(null != var2) {
            var1.method789(new class119(var2));
         }

         var1.method788();
         if(var1.field914) {
            var1.field924 = 0;
            var1.field917 = false;
         }

         class40.field928.method3756(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   public static String method634(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 65 && var7 <= 90) {
            var3 += (long)(var7 + 1 - 65);
         } else if(var7 >= 97 && var7 <= 122) {
            var3 += (long)(1 + var7 - 97);
         } else if(var7 >= 48 && var7 <= 57) {
            var3 += (long)(27 + var7 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var3 % 37L && 0L != var3) {
         var3 /= 37L;
      }

      String var8 = class159.method3171(var3);
      if(var8 == null) {
         var8 = "";
      }

      return var8;
   }
}
