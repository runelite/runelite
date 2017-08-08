import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class169 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   static Track1 field2322;

   static {
      new HashMap();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgw;ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-4"
   )
   static String method3148(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BB)Ljava/lang/String;",
      garbageValue = "12"
   )
   public static String method3149(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class270.field3665[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class270.field3665[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class270.field3665[(var6 & 15) << 2 | var7 >>> 6]).append(class270.field3665[var7 & 63]);
            } else {
               var3.append(class270.field3665[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class270.field3665[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }
}
