import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class33 {
   @ObfuscatedName("p")
   static final class33 field771 = new class33();
   @ObfuscatedName("s")
   static final class33 field773 = new class33();
   @ObfuscatedName("j")
   static final class33 field774 = new class33();
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = -398883691
   )
   static int field777;
   @ObfuscatedName("x")
   static final class33 field778 = new class33();
   @ObfuscatedName("mc")
   static byte field779;

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-19794"
   )
   static final boolean method692(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = client.field422[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return 1007 == var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-2127055375"
   )
   public static File method693(String var0) {
      if(!class135.field2101) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class135.field2096.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class135.field2099, var0);
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
                  class135.field2096.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var6) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1955308531"
   )
   public static boolean method694(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
