import net.runelite.mapping.Export;
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
   @Export("getFrames")
   static class103 method2777(int var0) {
      class103 var1 = (class103)class42.field982.method3743((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         class167 var2 = class90.field1568;
         class167 var3 = class42.field983;
         boolean var4 = true;
         int[] var5 = var2.method3281(var0);

         for(int var6 = 0; var6 < var5.length; ++var6) {
            byte[] var7 = var2.method3283(var0, var5[var6]);
            if(var7 == null) {
               var4 = false;
            } else {
               int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
               byte[] var9 = var3.method3283(var8, 0);
               if(var9 == null) {
                  var4 = false;
               }
            }
         }

         class103 var11;
         if(!var4) {
            var11 = null;
         } else {
            try {
               var11 = new class103(var2, var3, var0, false);
            } catch (Exception var10) {
               var11 = null;
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "2123583412"
   )
   public static String method2781(byte[] var0) {
      int var1 = var0.length;
      StringBuilder var2 = new StringBuilder();

      for(int var3 = 0; var3 < var1 + 0; var3 += 3) {
         int var4 = var0[var3] & 255;
         var2.append(class161.field2650[var4 >>> 2]);
         if(var3 < var1 - 1) {
            int var5 = var0[var3 + 1] & 255;
            var2.append(class161.field2650[(var4 & 3) << 4 | var5 >>> 4]);
            if(var3 < var1 - 2) {
               int var6 = var0[var3 + 2] & 255;
               var2.append(class161.field2650[(var5 & 15) << 2 | var6 >>> 6]).append(class161.field2650[var6 & 63]);
            } else {
               var2.append(class161.field2650[(var5 & 15) << 2]).append("=");
            }
         } else {
            var2.append(class161.field2650[(var4 & 3) << 4]).append("==");
         }
      }

      String var7 = var2.toString();
      return var7;
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
