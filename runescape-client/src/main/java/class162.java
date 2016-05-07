import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public final class class162 {
   @ObfuscatedName("s")
   static final char[] field2652 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = 1876400471
   )
   static int field2657;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;B)V",
      garbageValue = "0"
   )
   public static void method3170(File var0, File var1) {
      try {
         class227 var2 = new class227(class114.field1977, "rw", 10000L);
         class119 var3 = new class119(500);
         var3.method2477(3);
         var3.method2477(null != var1?1:0);
         var3.method2485(var0.getPath());
         if(null != var1) {
            var3.method2485(var1.getPath());
         }

         var2.method4106(var3.field2007, 0, var3.field2005);
         var2.method4121();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }
}
