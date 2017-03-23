import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class170 {
   class170() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;IIB)Ljava/lang/String;",
      garbageValue = "-89"
   )
   public static String method3303(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var8 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var8; ++var5) {
            CharSequence var9 = var0[var5];
            if(null == var9) {
               var4 += 4;
            } else {
               var4 += var9.length();
            }
         }

         StringBuilder var10 = new StringBuilder(var4);

         for(int var6 = var1; var6 < var8; ++var6) {
            CharSequence var7 = var0[var6];
            if(var7 == null) {
               var10.append("null");
            } else {
               var10.append(var7);
            }
         }

         return var10.toString();
      }
   }
}
