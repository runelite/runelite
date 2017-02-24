import java.io.File;
import java.io.RandomAccessFile;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
final class class7 implements Comparator {
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 588779829
   )
   public static int field72;

   public int compare(Object var1, Object var2) {
      return this.method82((class2)var1, (class2)var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1267838367"
   )
   int method82(class2 var1, class2 var2) {
      return var1.field25 < var2.field25?-1:(var1.field25 == var2.field25?0:1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-1606409164"
   )
   static boolean method84(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1837043687"
   )
   static final void method91() {
      if(null != class167.field2189) {
         class167.field2189.method1111();
      }

      if(null != class44.field914) {
         class44.field914.method1111();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-644665947"
   )
   static final int method92(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class84.field1462[var2 * 1024 / var3] >> 1;
      return (var4 * var1 >> 16) + ((65536 - var4) * var0 >> 16);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2145552860"
   )
   static void method93(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field698[var5]) {
            var2[var4] = World.field698[var5];
            var3[var4] = World.field697[var5];
            ++var4;
         }
      }

      World.field698 = var2;
      World.field697 = var3;
      class5.method66(World.worldList, 0, World.worldList.length - 1, World.field698, World.field697);
   }
}
