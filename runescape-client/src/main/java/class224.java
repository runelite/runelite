import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class224 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-723614655"
   )
   public static File method4202(String var0) {
      if(!class158.field2169) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class158.field2168.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class158.field2167, var0);
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
                  class158.field2168.put(var0, var2);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lik;Ljava/lang/String;Ljava/lang/String;I)Lkd;",
      garbageValue = "790725539"
   )
   public static SpritePixels method4213(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class21.method176(var0, var3, var4);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "-1758263913"
   )
   public static String method4211(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var0 < 0) {
            return Integer.toString(var0, var1);
         } else {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = '+';

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
