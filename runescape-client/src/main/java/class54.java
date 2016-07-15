import java.awt.Image;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class54 extends class207 {
   @ObfuscatedName("l")
   public static class196 field1165 = new class196(64);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -870286455
   )
   public int field1168 = 0;
   @ObfuscatedName("e")
   public static class170 field1169;
   @ObfuscatedName("g")
   public static boolean field1170;
   @ObfuscatedName("qh")
   protected static Image field1171;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "987942792"
   )
   public static File method1142(String var0) {
      if(!class138.field2135) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class138.field2138.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class134.field2118, var0);
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
                  class138.field2138.put(var0, var2);
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "874850637"
   )
   void method1144(class122 var1, int var2) {
      if(var2 == 2) {
         this.field1168 = var1.method2612();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-124"
   )
   public static boolean method1150(int var0, int var1) {
      return (var0 >> 1 + var1 & 1) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lclass23;",
      garbageValue = "1763052990"
   )
   static class23 method1158(int var0) {
      class23 var1 = (class23)class23.field613.method3834((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class0.field11.method3340(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class23();
            class122 var3 = new class122(var2);
            var3.field2061 = var3.field2054.length - 12;
            int var4 = var3.method2614();
            var1.field614 = var3.method2612();
            var1.field615 = var3.method2612();
            var1.field616 = var3.method2612();
            var1.field617 = var3.method2612();
            var3.field2061 = 0;
            var3.method2620();
            var1.field611 = new int[var4];
            var1.field612 = new int[var4];
            var1.field620 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field2061 < var3.field2054.length - 12; var1.field611[var5++] = var6) {
               var6 = var3.method2612();
               if(var6 == 3) {
                  var1.field620[var5] = var3.method2617();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field612[var5] = var3.method2614();
               } else {
                  var1.field612[var5] = var3.method2610();
               }
            }

            class23.field613.method3836(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "-108"
   )
   public void method1159(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method1144(var1, var2);
      }
   }
}
