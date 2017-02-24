import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public final class class25 extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1224342177
   )
   int field593;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -266692221
   )
   int field594;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 207369143
   )
   int field595;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1103754015
   )
   int field596;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -941224435
   )
   int field597;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1728346071
   )
   int field598;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1199660027
   )
   int field599;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -370710961
   )
   int field600;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -710901079
   )
   int field601;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1745813553
   )
   int field602 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1708764225
   )
   int field603 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -580603477
   )
   int field608;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1669735667"
   )
   static void method605() {
      try {
         File var0 = new File(class104.field1699, "random.dat");
         int var2;
         if(var0.exists()) {
            class104.field1692 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < class104.field1697.length; ++var1) {
               for(var2 = 0; var2 < class72.field1191.length; ++var2) {
                  File var3 = new File(class72.field1191[var2] + class104.field1697[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class104.field1692 = new class72(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(class104.field1692 == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class104.field1692 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }
}
