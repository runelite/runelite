import java.awt.Graphics;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("XItemContainer")
public class class15 extends class211 {
   @ObfuscatedName("iu")
   static class176 field197;
   @ObfuscatedName("e")
   @Export("stackSizes")
   int[] field199 = new int[]{0};
   @ObfuscatedName("ck")
   static class227 field201;
   @ObfuscatedName("m")
   @Export("itemContainers")
   static class199 field204 = new class199(32);
   @ObfuscatedName("w")
   @Export("itemIds")
   int[] field206 = new int[]{-1};

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-64"
   )
   static final int method163(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.field78[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class5.field77[var5][var3][var4] * (128 - var6) + class5.field77[var5][1 + var3][var4] * var6 >> 7;
         int var9 = class5.field77[var5][var3][var4 + 1] * (128 - var6) + class5.field77[var5][1 + var3][var4 + 1] * var6 >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "673339281"
   )
   public static File method173(String var0) {
      if(!class138.field2136) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class138.field2140.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class138.field2135, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class138.field2140.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "314228102"
   )
   static final void method175(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = 6 + var2;
      int var5 = field201.method4096(var0, 250);
      int var6 = field201.method4180(var0, 250) * 13;
      class82.method1880(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      class82.method1878(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 16777215);
      field201.method4106(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class7.method101(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class112.field1965.getGraphics();
            class78.field1454.vmethod1959(var7, 0, 0);
         } catch (Exception var8) {
            class112.field1965.repaint();
         }
      } else {
         class38.method767(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IZZZB)Lclass171;",
      garbageValue = "16"
   )
   static class171 method177(int var0, boolean var1, boolean var2, boolean var3) {
      class137 var4 = null;
      if(class152.field2290 != null) {
         var4 = new class137(var0, class152.field2290, class99.field1702[var0], 1000000);
      }

      return new class171(var4, class217.field3196, var0, var1, var2, var3);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1948870022"
   )
   static final void method178() {
      if(null != class38.field829) {
         class38.field829.method3050();
         class38.field829 = null;
      }

      class97.method2249();
      class5.field91.method1999();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field331[var0].method2479();
      }

      System.gc();
      class186.field3004 = 1;
      class128.field2089 = null;
      class105.field1834 = -1;
      class186.field3009 = -1;
      class40.field903 = 0;
      class133.field2111 = false;
      class186.field3010 = 2;
      client.field443 = -1;
      client.field532 = false;
      class26.method611();
      class171.method3414(10);
   }
}
