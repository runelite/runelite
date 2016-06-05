import java.awt.Component;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public abstract class class131 {
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 689288173
   )
   static int field2077;
   @ObfuscatedName("lz")
   static class130 field2079;
   @ObfuscatedName("g")
   static class80 field2081;
   @ObfuscatedName("ib")
   static class173 field2082;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2083947646"
   )
   public abstract void vmethod3072(Component var1);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "0"
   )
   public abstract void vmethod3075(Component var1);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-66"
   )
   public abstract int vmethod3074();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "0"
   )
   public static boolean method2810(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1625377943"
   )
   public static final boolean method2811() {
      class137 var0 = class137.field2137;
      synchronized(class137.field2137) {
         if(class137.field2150 == class137.field2139) {
            return false;
         } else {
            class137.field2142 = class137.field2147[class137.field2150];
            class24.field625 = class137.field2126[class137.field2150];
            class137.field2150 = 1 + class137.field2150 & 127;
            return true;
         }
      }
   }
}
