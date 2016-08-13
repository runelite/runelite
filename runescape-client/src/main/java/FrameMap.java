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
public class FrameMap extends Node {
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
   static String host;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2084806892"
   )
   public static void method2383() {
      try {
         File var0 = new File(WidgetNode.field67, "random.dat");
         int var1;
         if(var0.exists()) {
            class152.field2301 = new class231(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label34:
            for(int var2 = 0; var2 < class130.field2100.length; ++var2) {
               for(var1 = 0; var1 < class152.field2292.length; ++var1) {
                  File var3 = new File(class152.field2292[var1] + class130.field2100[var2] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class152.field2301 = new class231(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label34;
                  }
               }
            }
         }

         if(null == class152.field2301) {
            RandomAccessFile var5 = new RandomAccessFile(var0, "rw");
            var1 = var5.read();
            var5.seek(0L);
            var5.write(var1);
            var5.seek(0L);
            var5.close();
            class152.field2301 = new class231(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var4) {
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
      signature = "(II)LKitDefinition;",
      garbageValue = "-656056331"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field1063.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field1055.method3411(3, var0);
         var1 = new KitDefinition();
         if(null != var2) {
            var1.method987(new Buffer(var2));
         }

         KitDefinition.field1063.put(var1, (long)var0);
         return var1;
      }
   }

   FrameMap(int var1, byte[] var2) {
      this.field1838 = var1;
      Buffer var3 = new Buffer(var2);
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
