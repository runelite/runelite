import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ai")
public class class30 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -88379047
   )
   int field706;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -54687597
   )
   int field708;
   @ObfuscatedName("t")
   String field709;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -666029405
   )
   int field710;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -1618328185
   )
   protected static int field711;
   @ObfuscatedName("ap")
   static class80[] field712;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 948389193
   )
   int field713;

   @ObfuscatedName("p")
   public static void method672() {
      try {
         File var0 = new File(class48.field1098, "random.dat");
         int var2;
         if(var0.exists()) {
            class149.field2252 = new class228(new class227(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < class111.field1967.length; ++var1) {
               for(var2 = 0; var2 < class72.field1361.length; ++var2) {
                  File var3 = new File(class72.field1361[var2] + class111.field1967[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class149.field2252 = new class228(new class227(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(null == class149.field2252) {
            RandomAccessFile var5 = new RandomAccessFile(var0, "rw");
            var2 = var5.read();
            var5.seek(0L);
            var5.write(var2);
            var5.seek(0L);
            var5.close();
            class149.field2252 = new class228(new class227(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var4) {
         ;
      }

   }

   @ObfuscatedName("j")
   static class78 method673() {
      class78 var0 = new class78();
      var0.field1401 = class76.field1387;
      var0.field1409 = class76.field1385;
      var0.field1404 = class76.field1392[0];
      var0.field1405 = class76.field1388[0];
      var0.field1402 = class76.field1389[0];
      var0.field1403 = class76.field1390[0];
      int var1 = var0.field1403 * var0.field1402;
      byte[] var2 = class10.field180[0];
      var0.field1406 = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.field1406[var3] = class76.field1391[var2[var3] & 255];
      }

      class21.method582();
      return var0;
   }
}
