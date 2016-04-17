import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public final class class87 {
   @ObfuscatedName("r")
   public class85 field1528;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -749221417
   )
   int field1529;
   @ObfuscatedName("k")
   public class85 field1530;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -898079111
   )
   int field1531;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 708886149
   )
   int field1532;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 586872453
   )
   int field1533;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1606567189
   )
   public int field1534 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1160799877
   )
   int field1535;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -292790141
   )
   int field1536 = 0;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -619910185
   )
   static int field1538;
   @ObfuscatedName("ez")
   static class78 field1539;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "7207"
   )
   static final void method2160(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class5.field94[var0][var1 + var3][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.field94[var0][var1][var3 + var2] = class5.field94[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.field94[var0][var3 + var1][var2] = class5.field94[var0][var1 + var3][var2 - 1];
         }
      }

      if(var1 > 0 && class5.field94[var0][var1 - 1][var2] != 0) {
         class5.field94[var0][var1][var2] = class5.field94[var0][var1 - 1][var2];
      } else if(var2 > 0 && 0 != class5.field94[var0][var1][var2 - 1]) {
         class5.field94[var0][var1][var2] = class5.field94[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && 0 != class5.field94[var0][var1 - 1][var2 - 1]) {
         class5.field94[var0][var1][var2] = class5.field94[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZS)Z",
      garbageValue = "1"
   )
   public static boolean method2161(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         var0.delete();
         return true;
      } catch (Exception var4) {
         return false;
      }
   }
}
