import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class64 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 496221749
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("k")
   public static short[] field798;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = -1705892491
   )
   static int field812;

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "([Lhx;Lhx;ZI)V",
      garbageValue = "1450610938"
   )
   static void method1114(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class5.method11(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class5.method11(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class13.loadWidget(var6)) {
            class5.method11(class268.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method1113() {
      try {
         File var0 = new File(class156.userHome, "random.dat");
         int var2;
         if(var0.exists()) {
            class156.field2253 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label37:
            for(int var4 = 0; var4 < Huffman.field2323.length; ++var4) {
               for(var2 = 0; var2 < class139.cacheLocations.length; ++var2) {
                  File var3 = new File(class139.cacheLocations[var2] + Huffman.field2323[var4] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class156.field2253 = new CacheFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label37;
                  }
               }
            }
         }

         if(class156.field2253 == null) {
            RandomAccessFile var1 = new RandomAccessFile(var0, "rw");
            var2 = var1.read();
            var1.seek(0L);
            var1.write(var2);
            var1.seek(0L);
            var1.close();
            class156.field2253 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }
}
