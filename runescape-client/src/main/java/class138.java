import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class138 {
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -991064737
   )
   static int field1925;
   @ObfuscatedName("g")
   public static class139 field1926;
   @ObfuscatedName("b")
   public static class182 field1927;
   @ObfuscatedName("m")
   public static class182 field1928;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1580580237
   )
   public static int field1929 = 0;
   @ObfuscatedName("v")
   public static class182 field1930;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -378261749
   )
   public static int field1931;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 45457943
   )
   public static int field1932;
   @ObfuscatedName("o")
   public static class182 field1934;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)LWidget;",
      garbageValue = "-42"
   )
   public static Widget method2419(int var0, int var1) {
      Widget var2 = class174.method3178(var0);
      return var1 == -1?var2:(null != var2 && null != var2.children && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "309645302"
   )
   static final int method2434(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class84.field1446[1024 * var2 / var3] >> 1;
      return (var4 * var1 >> 16) + ((65536 - var4) * var0 >> 16);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "442455256"
   )
   static boolean method2444(File var0, boolean var1) {
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

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "-1431826298"
   )
   static void method2445(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2214 == 0) {
         var0.width = var0.field2218;
      } else if(var0.field2214 == 1) {
         var0.width = var1 - var0.field2218;
      } else if(var0.field2214 == 2) {
         var0.width = var1 * var0.field2218 >> 14;
      }

      if(var0.field2253 == 0) {
         var0.height = var0.field2215;
      } else if(var0.field2253 == 1) {
         var0.height = var2 - var0.field2215;
      } else if(var0.field2253 == 2) {
         var0.height = var0.field2215 * var2 >> 14;
      }

      if(var0.field2214 == 4) {
         var0.width = var0.field2224 * var0.height / var0.field2232;
      }

      if(var0.field2253 == 4) {
         var0.height = var0.field2232 * var0.width / var0.field2224;
      }

      if(Client.field454 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field566 = var0;
      }

      if(var3 && null != var0.field2316 && (var4 != var0.width || var5 != var0.height)) {
         class18 var6 = new class18();
         var6.field193 = var0;
         var6.field203 = var0.field2316;
         Client.field483.method2361(var6);
      }

   }
}
