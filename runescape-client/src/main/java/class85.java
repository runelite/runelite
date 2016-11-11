import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class85 implements class115 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -587473253
   )
   final int field1481;
   @ObfuscatedName("h")
   static final class85 field1482 = new class85(1, 1);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1037180279
   )
   public final int field1483;
   @ObfuscatedName("g")
   static final class85 field1484 = new class85(3, 3);
   @ObfuscatedName("n")
   static final class85 field1485 = new class85(4, 4);
   @ObfuscatedName("i")
   public static final class85 field1486 = new class85(0, 0);
   @ObfuscatedName("e")
   static final class85 field1487 = new class85(2, 2);

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class85(int var1, int var2) {
      this.field1483 = var1;
      this.field1481 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1244217671"
   )
   public static boolean method1918(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-970198235"
   )
   public int vmethod3197() {
      return this.field1481;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZB)Z",
      garbageValue = "35"
   )
   public static boolean method1924(File var0, boolean var1) {
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

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "16"
   )
   static final void method1925(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         SecondaryBufferProvider.menuAction(var1, var2, var3, var4, var5, var6, class143.field2211, class143.field2212);
      }
   }
}
