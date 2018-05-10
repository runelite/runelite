import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
@Implements("Ignore")
public class Ignore extends Nameable {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 776785653
   )
   static int field3645;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   static Track1 field3644;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1405632693
   )
   int field3646;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkj;I)I",
      garbageValue = "850817687"
   )
   int method5420(Ignore var1) {
      return this.field3646 - var1.field3646;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljn;I)I",
      garbageValue = "1707398523"
   )
   public int vmethod5482(Nameable var1) {
      return this.method5420((Ignore)var1);
   }

   public int compareTo(Object var1) {
      return this.method5420((Ignore)var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2039609224"
   )
   public static void method5431() {
      try {
         File var0 = new File(FaceNormal.userHome, "random.dat");
         int var2;
         if(var0.exists()) {
            class155.randomDat = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < class155.field1995.length; ++var1) {
               for(var2 = 0; var2 < class155.cacheLocations.length; ++var2) {
                  File var3 = new File(class155.cacheLocations[var2] + class155.field1995[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class155.randomDat = new CacheFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(class155.randomDat == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class155.randomDat = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }
}
