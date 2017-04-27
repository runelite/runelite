import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("bk")
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -1882013251
   )
   static int field1174;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -9051046450171518019L
   )
   @Export("position")
   long position;
   @ObfuscatedName("d")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -2312879698182260947L
   )
   @Export("length")
   long length;

   @ObfuscatedName("d")
   final void method1423(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "2146439638"
   )
   public final void method1424(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2065499094"
   )
   public final void method1425() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2037619757"
   )
   public static void method1426() {
      class189.field2784.reset();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1838454379"
   )
   public final int method1427(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method1425();
      }

   }

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1336475526"
   )
   public final long method1438() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "35"
   )
   static void method1441(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class128.method2364(var0.parentId);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class187.field2760;
         var3 = IndexDataBase.field2726;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class5.method63(var0, var2, var3, false);
      class161.method3028(var0, var2, var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public static boolean method1443(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-402939849"
   )
   static final void method1445(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1445(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2773((long)var3.id);
               if(var4 != null) {
                  Client.method572(var4.id, var1);
               }
            }

            class18 var5;
            if(var1 == 0 && var3.field2314 != null) {
               var5 = new class18();
               var5.field189 = var3;
               var5.field196 = var3.field2314;
               Script.method910(var5, 200000);
            }

            if(var1 == 1 && var3.field2315 != null) {
               if(var3.index >= 0) {
                  Widget var6 = class128.method2364(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var6.children[var3.index] != var3) {
                     continue;
                  }
               }

               var5 = new class18();
               var5.field189 = var3;
               var5.field196 = var3.field2315;
               Script.method910(var5, 200000);
            }
         }
      }

   }
}
