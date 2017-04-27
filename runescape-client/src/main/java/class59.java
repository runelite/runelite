import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class59 implements Runnable {
   @ObfuscatedName("d")
   volatile class57[] field1061 = new class57[2];

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            class57 var2 = this.field1061[var1];
            if(var2 != null) {
               var2.method1078();
            }
         }
      } catch (Exception var4) {
         class173.method3259((String)null, var4);
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
      garbageValue = "14"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class36.method752(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "-134250005"
   )
   static final void method1138(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class94.field1580.length; ++var2) {
         class94.field1580[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class94.field1580[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class32.field729[var5] = (class94.field1580[var5 + 128] + class94.field1580[var5 - 128] + class94.field1580[var5 - 1] + class94.field1580[var5 + 1]) / 4;
            }
         }

         int[] var8 = class94.field1580;
         class94.field1580 = class32.field729;
         class32.field729 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + 16 + var0.offsetX;
                  int var6 = var0.offsetY + var3 + 16;
                  int var7 = var5 + (var6 << 7);
                  class94.field1580[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)LFileOnDisk;",
      garbageValue = "-91"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class104.field1676, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class16.field176 == 33) {
         var4 = "_rc";
      } else if(class16.field176 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class20.field216, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1833531824"
   )
   public static int method1140(int var0) {
      Varbit var1 = class161.method3027(var0);
      int var2 = var1.configId;
      int var3 = var1.leastSignificantBit;
      int var4 = var1.mostSignificantBit;
      int var5 = class167.field2175[var4 - var3];
      return class167.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LRSSocket;ZB)V",
      garbageValue = "79"
   )
   public static void method1141(RSSocket var0, boolean var1) {
      if(class187.field2759 != null) {
         try {
            class187.field2759.method2093();
         } catch (Exception var6) {
            ;
         }

         class187.field2759 = null;
      }

      class187.field2759 = var0;
      class112.method2101(var1);
      class187.field2763.offset = 0;
      class199.field2881 = null;
      class187.field2751 = null;
      class187.field2765 = 0;

      while(true) {
         class183 var2 = (class183)class187.field2756.method2776();
         if(var2 == null) {
            while(true) {
               var2 = (class183)class187.field2761.method2776();
               if(var2 == null) {
                  if(class187.field2764 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.putByte(4);
                        var7.putByte(class187.field2764);
                        var7.putShort(0);
                        class187.field2759.queueForWrite(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class187.field2759.method2093();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class187.field2770;
                        class187.field2759 = null;
                     }
                  }

                  class187.field2752 = 0;
                  class187.field2753 = class72.method1421();
                  return;
               }

               class187.field2758.method2714(var2);
               class187.field2771.method2774(var2, var2.hash);
               ++class187.field2767;
               --class187.field2762;
            }
         }

         class187.field2772.method2774(var2, var2.hash);
         ++class187.field2755;
         --class187.field2768;
      }
   }
}
