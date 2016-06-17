import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class114 {
   @ObfuscatedName("am")
   static class143 field1949;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -1339706987
   )
   static int field1950;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-1892080063"
   )
   static File method2452(String var0) {
      if(!class135.field2071) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class135.field2065.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class135.field2062, var0);
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
                  class135.field2065.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(null != var3) {
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
}
