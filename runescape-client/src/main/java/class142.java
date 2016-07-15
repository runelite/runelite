import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("em")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class class142 extends Canvas {
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = -418805617
   )
   public static int field2191;
   @ObfuscatedName("e")
   Component field2193;

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIII)V",
      garbageValue = "-498422599"
   )
   static final void method3043(class176 var0, int var1, int var2, int var3) {
      class178 var4 = var0.method3493(false);
      if(var4 != null) {
         if(client.field531 < 3) {
            class170.field2729.method1812(var1, var2, var4.field2940, var4.field2938, 25, 25, client.field514, 256, var4.field2937, var4.field2939);
         } else {
            class82.method1886(var1, var2, 0, var4.field2937, var4.field2939);
         }

      }
   }

   public final void update(Graphics var1) {
      this.field2193.update(var1);
   }

   class142(Component var1) {
      this.field2193 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1923929553"
   )
   public static void method3047() {
      try {
         File var0 = new File(class12.field197, "random.dat");
         int var2;
         if(var0.exists()) {
            class152.field2283 = new class231(new class230(var0, "rw", 25L), 24, 0);
         } else {
            label37:
            for(int var1 = 0; var1 < class102.field1752.length; ++var1) {
               for(var2 = 0; var2 < class101.field1742.length; ++var2) {
                  File var3 = new File(class101.field1742[var2] + class102.field1752[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class152.field2283 = new class231(new class230(var3, "rw", 25L), 24, 0);
                     break label37;
                  }
               }
            }
         }

         if(class152.field2283 == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class152.field2283 = new class231(new class230(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   public final void paint(Graphics var1) {
      this.field2193.paint(var1);
   }
}
