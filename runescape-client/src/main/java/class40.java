import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class40 implements class158 {
   @ObfuscatedName("e")
   static final class40 field814 = new class40(1);
   @ObfuscatedName("k")
   static final class40 field815 = new class40(3);
   @ObfuscatedName("f")
   static final class40 field816 = new class40(2);
   @ObfuscatedName("i")
   static final class40 field817 = new class40(0);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 510980077
   )
   final int field818;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 994042525
   )
   static int field819;
   @ObfuscatedName("cp")
   static class208 field821;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field818 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "-40"
   )
   static File method714(String var0) {
      if(!class107.field1711) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1714.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class107.field1717, var0);
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
                  class107.field1714.put(var0, var2);
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass159;B)I",
      garbageValue = "-3"
   )
   static int method717(class159 var0) {
      int var1 = var0.method2978(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2978(5);
      } else if(var1 == 2) {
         var2 = var0.method2978(8);
      } else {
         var2 = var0.method2978(11);
      }

      return var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2056039019"
   )
   public int vmethod3974() {
      return this.field818;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "71071460"
   )
   public static boolean method719(int var0) {
      return (var0 >> 28 & 1) != 0;
   }
}
