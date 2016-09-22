import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class62 {
   @ObfuscatedName("r")
   XHashTable field1285 = new XHashTable(256);
   @ObfuscatedName("d")
   class170 field1286;
   @ObfuscatedName("v")
   XHashTable field1287 = new XHashTable(256);
   @ObfuscatedName("bw")
   @Export("host")
   static String host;
   @ObfuscatedName("a")
   class170 field1291;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "791318905"
   )
   public class65 method1312(int var1, int[] var2) {
      if(this.field1286.method3320() == 1) {
         return this.method1318(0, var1, var2);
      } else if(this.field1286.method3319(var1) == 1) {
         return this.method1318(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "323162011"
   )
   public class65 method1314(int var1, int[] var2) {
      if(this.field1291.method3320() == 1) {
         return this.method1315(0, var1, var2);
      } else if(this.field1291.method3319(var1) == 1) {
         return this.method1315(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II[IS)Lclass65;",
      garbageValue = "6146"
   )
   class65 method1315(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class65 var7 = (class65)this.field1285.method3817(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class61 var8 = class61.method1309(this.field1291, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1299();
            this.field1285.method3823(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1305.length;
            }

            return var7;
         }
      }
   }

   public class62(class170 var1, class170 var2) {
      this.field1291 = var1;
      this.field1286 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "334182190"
   )
   class65 method1318(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class65 var7 = (class65)this.field1285.method3817(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class73 var8 = (class73)this.field1287.method3817(var5);
         if(null == var8) {
            var8 = class73.method1590(this.field1286, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1287.method3823(var8, var5);
         }

         var7 = var8.method1591(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1285.method3823(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "1727042523"
   )
   public static boolean method1320(File var0, boolean var1) {
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

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   static final void method1321() {
      Client.field323.method2801(194);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3820(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3827()) {
         if(var0.field61 == 0 || var0.field61 == 3) {
            TextureProvider.method2217(var0, true);
         }
      }

      if(Client.field444 != null) {
         class53.method1101(Client.field444);
         Client.field444 = null;
      }

   }
}
