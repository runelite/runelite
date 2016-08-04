import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class180 {
   @ObfuscatedName("h")
   public static int[] field2962;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "37"
   )
   public static File method3614(String var0) {
      if(!class138.field2138) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class138.field2144.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class138.field2137, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class138.field2144.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIIZI)V",
      garbageValue = "835158225"
   )
   public static void method3615(class170 var0, int var1, int var2, int var3, boolean var4) {
      class186.field3010 = 1;
      class111.field1970 = var0;
      class140.field2184 = var1;
      class186.field3009 = var2;
      class11.field176 = var3;
      class37.field814 = var4;
      class144.field2222 = 10000;
   }
}
