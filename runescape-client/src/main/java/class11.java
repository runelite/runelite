import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class11 {
   @ObfuscatedName("x")
   int[] field104;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -157282217
   )
   int field105 = -1;
   @ObfuscatedName("q")
   String[] field107;
   @ObfuscatedName("px")
   static class230 field108;
   @ObfuscatedName("p")
   class48 field109;
   @ObfuscatedName("dg")
   static int[] field110;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "-53"
   )
   static File method158(String var0) {
      if(!class107.field1731) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1732.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class107.field1726, var0);
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
                  class107.field1732.put(var0, var2);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method159() {
      try {
         File var0 = new File(ChatLineBuffer.field971, "random.dat");
         int var2;
         if(var0.exists()) {
            class104.field1683 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < class174.field2633.length; ++var1) {
               for(var2 = 0; var2 < class60.field1084.length; ++var2) {
                  File var3 = new File(class60.field1084[var2] + class174.field2633[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class104.field1683 = new class72(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(null == class104.field1683) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class104.field1683 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }
}
