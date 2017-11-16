import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class149 {
   @ObfuscatedName("b")
   final URL field2101;
   @ObfuscatedName("s")
   volatile boolean field2098;
   @ObfuscatedName("r")
   volatile byte[] field2100;

   class149(URL var1) {
      this.field2101 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1243830410"
   )
   public boolean method2916() {
      return this.field2098;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "2"
   )
   public byte[] method2919() {
      return this.field2100;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "127"
   )
   public static void method2915(String[] var0, short[] var1, int var2, int var3) {
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
         method2915(var0, var1, var2, var5 - 1);
         method2915(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-622487536"
   )
   public static boolean method2922(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }
}
