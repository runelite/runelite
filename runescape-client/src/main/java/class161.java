import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class161 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1912438385"
   )
   public static void method3160() {
      while(true) {
         Deque var1 = class173.field2760;
         class172 var0;
         synchronized(class173.field2760) {
            var0 = (class172)class173.field2761.method3806();
         }

         if(null == var0) {
            return;
         }

         var0.field2751.method3337(var0.field2750, (int)var0.hash, var0.field2757, false);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;IIB)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method3161(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var8 = var1 + var2;
         int var4 = 0;

         for(int var5 = var1; var5 < var8; ++var5) {
            CharSequence var9 = var0[var5];
            if(var9 == null) {
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
