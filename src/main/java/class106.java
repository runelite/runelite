import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public class class106 {
   @ObfuscatedName("n")
   static int[] field1849 = new int[4096];
   @ObfuscatedName("m")
   static int[][] field1850 = new int[128][128];
   @ObfuscatedName("c")
   static int[] field1853 = new int[4096];
   @ObfuscatedName("z")
   static int[][] field1855 = new int[128][128];

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)Lclass227;",
      garbageValue = "-53"
   )
   public static class227 method2367(String var0, String var1, boolean var2) {
      File var3 = new File(class149.field2213, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class227 var10 = new class227(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class149.field2219 == 33) {
         var4 = "_rc";
      } else if(class149.field2219 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class89.field1529, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class227 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class227(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class227(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "218231518"
   )
   public static boolean method2372(int var0) {
      return 0 != (var0 >> 21 & 1);
   }
}
