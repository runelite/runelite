import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public final class class125 extends Buffer {
   @ObfuscatedName("g")
   class126 field2087;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2059450581
   )
   int field2088;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -1290438763
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("m")
   static final int[] field2093 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "-33"
   )
   public void method2782(int[] var1) {
      this.field2087 = new class126(var1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class125(int var1) {
      super(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1853914779"
   )
   public static void method2783() {
      try {
         File var0 = new File(class228.field3259, "random.dat");
         int var2;
         if(var0.exists()) {
            class152.field2299 = new class231(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < class124.field2082.length; ++var1) {
               for(var2 = 0; var2 < class129.field2120.length; ++var2) {
                  File var3 = new File(class129.field2120[var2] + class124.field2082[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class152.field2299 = new class231(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(null == class152.field2299) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class152.field2299 = new class231(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "31"
   )
   public void method2784() {
      this.field2088 = super.offset * 8;
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "10"
   )
   public int method2787(int var1) {
      return var1 * 8 - this.field2088;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-106"
   )
   public static boolean method2790() {
      try {
         if(class186.field3016 == 2) {
            if(class154.field2324 == null) {
               class154.field2324 = class183.method3551(class186.field3017, class186.field3019, class186.field3022);
               if(class154.field2324 == null) {
                  return false;
               }
            }

            if(null == class186.field3021) {
               class186.field3021 = new class62(class186.field3012, class186.field3013);
            }

            if(class186.field3015.method3675(class154.field2324, class186.field3018, class186.field3021, 22050)) {
               class186.field3015.method3674();
               class186.field3015.method3642(class177.field2951);
               class186.field3015.method3635(class154.field2324, class186.field3020);
               class186.field3016 = 0;
               class154.field2324 = null;
               class186.field3021 = null;
               class186.field3017 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class186.field3015.method3671();
         class186.field3016 = 0;
         class154.field2324 = null;
         class186.field3021 = null;
         class186.field3017 = null;
      }

      return false;
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-795843976"
   )
   public int method2792(int var1) {
      int var2 = this.field2088 >> 3;
      int var3 = 8 - (this.field2088 & 7);
      int var4 = 0;

      for(this.field2088 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2093[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.payload[var2] & field2093[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2093[var1];
      }

      return var4;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1335505531"
   )
   public int method2793() {
      return super.payload[++super.offset - 1] - this.field2087.method2812() & 255;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1075376936"
   )
   public void method2801(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2087.method2812());
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "68"
   )
   public void method2805() {
      super.offset = (7 + this.field2088) / 8;
   }
}
