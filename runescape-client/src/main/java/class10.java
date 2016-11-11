import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class10 extends class110 {
   @ObfuscatedName("ah")
   static class149 field181;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-215812910"
   )
   public boolean vmethod2413(int var1, int var2, int var3, CollisionData var4) {
      return super.field1932 == var2 && super.field1933 == var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-2069631422"
   )
   public static File method130(String var0) {
      if(!class138.field2133) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class138.field2132.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(Frames.field1829, var0);
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
                  class138.field2132.put(var0, var2);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2065313273"
   )
   static void method133(int var0) {
      if(var0 != -1) {
         if(class14.method172(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(null != var3.field2883) {
                  class0 var4 = new class0();
                  var4.field13 = var3;
                  var4.field8 = var3.field2883;
                  ChatLineBuffer.method634(var4, 2000000);
               }
            }

         }
      }
   }
}
