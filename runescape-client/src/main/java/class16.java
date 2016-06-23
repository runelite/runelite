import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public final class class16 extends class208 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1291583769
   )
   int field231;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -540758113
   )
   int field232 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1563032963
   )
   int field233;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1024809105
   )
   int field235;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1785558303
   )
   int field236;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1355047387
   )
   int field237;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1321159867
   )
   int field238;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1666171137
   )
   int field239 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1500102495
   )
   int field240;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1160288253
   )
   int field241;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -663646029
   )
   int field242;
   @ObfuscatedName("dl")
   @Export("mapRegions")
   static int[] field243;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1241750651
   )
   int field244;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "-1348944766"
   )
   public static void method192(String[] var0, short[] var1) {
      class21.method608(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "2035038956"
   )
   public static File method193(String var0) {
      if(!class135.field2088) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class135.field2083.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class135.field2085, var0);
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
                  class135.field2083.put(var0, var2);
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

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1294194700"
   )
   static final void method194() {
      for(class29 var0 = (class29)client.field423.method3852(); null != var0; var0 = (class29)client.field423.method3857()) {
         if(var0.field694 == class14.field212 && !var0.field701) {
            if(client.field301 >= var0.field693) {
               var0.method700(client.field366);
               if(var0.field701) {
                  var0.method3946();
               } else {
                  class129.field2056.method1986(var0.field694, var0.field695, var0.field692, var0.field697, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.method3946();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "-229276009"
   )
   public static void method195(class167 var0) {
      class47.field1078 = var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;Lclass167;Lclass184;I)Z",
      garbageValue = "1601694081"
   )
   public static boolean method196(class167 var0, class167 var1, class167 var2, class184 var3) {
      class183.field2958 = var0;
      class183.field2952 = var1;
      class183.field2954 = var2;
      class183.field2955 = var3;
      return true;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILclass134;Lclass168;B)V",
      garbageValue = "-113"
   )
   static void method197(int var0, class134 var1, class168 var2) {
      class169 var3 = new class169();
      var3.field2697 = 1;
      var3.field3115 = (long)var0;
      var3.field2698 = var1;
      var3.field2699 = var2;
      class199 var4 = class170.field2707;
      synchronized(class170.field2707) {
         class170.field2707.method3877(var3);
      }

      Object var9 = class170.field2705;
      synchronized(class170.field2705) {
         if(class170.field2702 == 0) {
            class7.field136.method2903(new class170(), 5);
         }

         class170.field2702 = 600;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lclass8;",
      garbageValue = "868935391"
   )
   static class8 method198() {
      class227 var0 = null;
      class8 var1 = new class8();

      try {
         var0 = class41.method896("", class137.field2130.field2280, false);
         byte[] var2 = new byte[(int)var0.method4150()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method4146(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new class8(new class119(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4149();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }
}
