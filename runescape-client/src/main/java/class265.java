import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
public class class265 {
   @ObfuscatedName("n")
   public static class165 field3670;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "1440612810"
   )
   public static String method4872(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var10 = var2 + var1;
         int var4 = 0;

         for(int var9 = var1; var9 < var10; ++var9) {
            CharSequence var8 = var0[var9];
            if(var8 == null) {
               var4 += 4;
            } else {
               var4 += var8.length();
            }
         }

         StringBuilder var5 = new StringBuilder(var4);

         for(int var6 = var1; var6 < var10; ++var6) {
            CharSequence var7 = var0[var6];
            if(var7 == null) {
               var5.append("null");
            } else {
               var5.append(var7);
            }
         }

         return var5.toString();
      }
   }
}
