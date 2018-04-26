import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class151 extends class297 {
   @ObfuscatedName("g")
   final boolean field2115;

   public class151(boolean var1) {
      this.field2115 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;B)I",
      garbageValue = "0"
   )
   int method3198(ChatPlayer var1, ChatPlayer var2) {
      if(Client.world == var1.world) {
         if(var2.world != Client.world) {
            return this.field2115?-1:1;
         }
      } else if(var2.world == Client.world) {
         return this.field2115?1:-1;
      }

      return this.method5341(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3198((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "675179245"
   )
   public static File method3201(String var0) {
      if(!class170.field2209) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class170.field2211.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class170.field2210, var0);
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
                  class170.field2211.put(var0, var2);
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
}
