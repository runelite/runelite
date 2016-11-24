import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class118 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1680871925
   )
   static int field1837;
   @ObfuscatedName("m")
   static int[][] field1839 = new int[128][128];
   @ObfuscatedName("p")
   static int[] field1840 = new int[4096];
   @ObfuscatedName("h")
   static int[][] field1842 = new int[128][128];
   @ObfuscatedName("g")
   static int[] field1843 = new int[4096];

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "504103768"
   )
   static final int method2338(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "997154296"
   )
   public static FileOnDisk method2341(String var0, String var1, boolean var2) {
      File var3 = new File(class104.field1676, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class103.field1671 == 33) {
         var4 = "_rc";
      } else if(class103.field1671 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(Ignore.field211, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }
}
