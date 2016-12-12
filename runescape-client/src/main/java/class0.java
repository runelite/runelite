import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
final class class0 implements Comparator {
   @ObfuscatedName("ag")
   static ModIcon[] field2;
   @ObfuscatedName("nk")
   static class51 field3;
   @ObfuscatedName("w")
   public static short[] field4;
   @ObfuscatedName("bl")
   static class184 field7;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "721675515"
   )
   int method1(class2 var1, class2 var2) {
      return var1.field23 < var2.field23?-1:(var1.field23 == var2.field23?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1((class2)var1, (class2)var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   static void method2() {
      try {
         File var0 = new File(class39.field805, "random.dat");
         int var2;
         if(var0.exists()) {
            class104.field1668 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label37:
            for(int var1 = 0; var1 < class157.field2123.length; ++var1) {
               for(var2 = 0; var2 < MessageNode.field231.length; ++var2) {
                  File var3 = new File(MessageNode.field231[var2] + class157.field2123[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class104.field1668 = new class72(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label37;
                  }
               }
            }
         }

         if(class104.field1668 == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class104.field1668 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1434850997"
   )
   public static void method6() {
      try {
         if(class138.field1914 == 1) {
            int var0 = class138.field1913.method2571();
            if(var0 > 0 && class138.field1913.method2460()) {
               var0 -= class138.field1916;
               if(var0 < 0) {
                  var0 = 0;
               }

               class138.field1913.method2470(var0);
               return;
            }

            class138.field1913.method2466();
            class138.field1913.method2464();
            if(null != class145.field2014) {
               class138.field1914 = 2;
            } else {
               class138.field1914 = 0;
            }

            class138.field1917 = null;
            class112.field1760 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class138.field1913.method2466();
         class138.field1914 = 0;
         class138.field1917 = null;
         class112.field1760 = null;
         class145.field2014 = null;
      }

   }
}
