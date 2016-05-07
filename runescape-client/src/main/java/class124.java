import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public class class124 {
   @ObfuscatedName("r")
   public static class172 field2045;
   @ObfuscatedName("j")
   static String field2046;
   @ObfuscatedName("rq")
   protected static String field2047;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass103;",
      garbageValue = "1792718672"
   )
   static class103 method2777(int var0) {
      class103 var1 = (class103)class42.field982.method3743((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         class167 var3 = class90.field1568;
         class167 var4 = class42.field983;
         boolean var5 = true;
         int[] var6 = var3.method3281(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3283(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3283(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         class103 var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new class103(var3, var4, var0, false);
            } catch (Exception var11) {
               var2 = null;
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "2123583412"
   )
   public static String method2781(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class161.field2650[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class161.field2650[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class161.field2650[(var6 & 15) << 2 | var7 >>> 6]).append(class161.field2650[var7 & 63]);
            } else {
               var3.append(class161.field2650[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class161.field2650[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1763870863"
   )
   static int method2782(int var0) {
      class35 var1 = (class35)class11.field167.method3794((long)var0);
      return var1 == null?-1:(class11.field171.field3110 == var1.field3115?-1:((class35)var1.field3115).field789);
   }
}
