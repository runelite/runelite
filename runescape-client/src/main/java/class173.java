import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class173 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static final class173 field2445;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static final class173 field2437;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static final class173 field2438;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static final class173 field2436;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static final class173 field2440;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static final class173 field2442;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static final class173 field2447;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static final class173 field2443;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static final class173 field2444;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static final class173 field2439;

   static {
      field2445 = new class173(5);
      field2437 = new class173(4);
      field2438 = new class173(14);
      field2436 = new class173(5);
      field2440 = new class173(7);
      field2442 = new class173(3);
      field2447 = new class173(15);
      field2443 = new class173(2);
      field2444 = new class173(6);
      field2439 = new class173(4);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5"
   )
   class173(int var1) {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-2045674679"
   )
   public static int method3247(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Lck;",
      garbageValue = "1775957094"
   )
   static Preferences method3248() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = BoundingBox3D.getPreferencesFile("", class3.field18.name, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new Preferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }
}
