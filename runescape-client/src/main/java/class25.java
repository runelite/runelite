import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class25 {
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 1222582905
   )
   static int field373;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 426545695
   )
   int field374;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      longValue = 4575816343425306825L
   )
   static long field375;
   @ObfuscatedName("p")
   Coordinates field379;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "-29"
   )
   static File method205(String var0) {
      if(!class157.field2270) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class157.field2265.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class157.field2268, var0);
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
                  class157.field2265.put(var0, var2);
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-273128582"
   )
   public static final boolean method206() {
      class50 var0 = class50.keyboard;
      synchronized(class50.keyboard) {
         if(class50.field633 == class50.field632) {
            return false;
         } else {
            class82.field1337 = class50.field634[class50.field632];
            class39.field535 = class50.field628[class50.field632];
            class50.field632 = class50.field632 + 1 & 127;
            return true;
         }
      }
   }

   class25(int var1, Coordinates var2) {
      this.field374 = var1;
      this.field379 = var2;
   }
}
