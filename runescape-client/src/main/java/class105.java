import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("FrameMap")
public class class105 extends class211 {
   @ObfuscatedName("ao")
   static class149 field1834;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 980036715
   )
   int field1835;
   @ObfuscatedName("r")
   int[] field1836;
   @ObfuscatedName("e")
   int[][] field1837;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1945579641
   )
   int field1838;
   @ObfuscatedName("b")
   public static short[][] field1840;
   @ObfuscatedName("bx")
   @Export("host")
   static String field1842;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2084806892"
   )
   public static void method2383() {
      try {
         File var0 = new File(class3.field67, "random.dat");
         int var2;
         if(var0.exists()) {
            class152.field2301 = new class231(new class230(var0, "rw", 25L), 24, 0);
         } else {
            label39:
            for(int var1 = 0; var1 < class130.field2100.length; ++var1) {
               for(var2 = 0; var2 < class152.field2292.length; ++var2) {
                  File var3 = new File(class152.field2292[var2] + class130.field2100[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class152.field2301 = new class231(new class230(var3, "rw", 25L), 24, 0);
                     break label39;
                  }
               }
            }
         }

         if(null == class152.field2301) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class152.field2301 = new class231(new class230(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZB)V",
      garbageValue = "-80"
   )
   public static void method2384(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class141.field2193.startsWith("win")) {
            class136.method3002(var0, 0);
         } else if(class141.field2193.startsWith("mac")) {
            class14.method178(var0, 1, "openjs");
         } else {
            class14.method178(var0, 2, "openjs");
         }
      } else {
         class14.method178(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass46;",
      garbageValue = "-656056331"
   )
   @Export("getKitDefinition")
   public static class46 method2385(int var0) {
      class46 var1 = (class46)class46.field1063.method3905((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class46.field1055.method3411(3, var0);
         var1 = new class46();
         if(null != var2) {
            var1.method987(new class122(var2));
         }

         class46.field1063.method3907(var1, (long)var0);
         return var1;
      }
   }

   class105(int var1, byte[] var2) {
      this.field1838 = var1;
      class122 var3 = new class122(var2);
      this.field1835 = var3.method2633();
      this.field1836 = new int[this.field1835];
      this.field1837 = new int[this.field1835][];

      int var4;
      for(var4 = 0; var4 < this.field1835; ++var4) {
         this.field1836[var4] = var3.method2633();
      }

      for(var4 = 0; var4 < this.field1835; ++var4) {
         this.field1837[var4] = new int[var3.method2633()];
      }

      for(var4 = 0; var4 < this.field1835; ++var4) {
         for(int var5 = 0; var5 < this.field1837[var4].length; ++var5) {
            this.field1837[var4][var5] = var3.method2633();
         }
      }

   }
}
