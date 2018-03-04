import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class203 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "-1716387842"
   )
   public static String method3927(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var8 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var8; ++var5) {
            CharSequence var6 = var0[var5];
            if(var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var9 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var8; ++var10) {
            CharSequence var7 = var0[var10];
            if(var7 == null) {
               var9.append("null");
            } else {
               var9.append(var7);
            }
         }

         return var9.toString();
      }
   }
}
