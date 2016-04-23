import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class13 implements Runnable {
   @ObfuscatedName("h")
   Object field191 = new Object();
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1123976179
   )
   int field193 = 0;
   @ObfuscatedName("z")
   int[] field194 = new int[500];
   @ObfuscatedName("j")
   boolean field195 = true;
   @ObfuscatedName("x")
   int[] field196 = new int[500];

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1400881319"
   )
   static void method162(int var0) {
      if(client.field283 != var0) {
         if(0 == client.field283) {
            class142.field2156 = null;
            class124.field2009 = null;
            class77.field1372 = null;
         }

         if(var0 == 20 || 40 == var0 || 45 == var0) {
            client.field308 = 0;
            client.field293 = 0;
            client.field310 = 0;
         }

         if(20 != var0 && 40 != var0 && null != class18.field257) {
            class18.field257.method2964();
            class18.field257 = null;
         }

         if(client.field283 == 25) {
            client.field334 = 0;
            client.field330 = 0;
            client.field331 = 1;
            client.field332 = 0;
            client.field485 = 1;
         }

         if(5 != var0 && 10 != var0) {
            if(20 == var0) {
               class45.method948(class3.field66, client.field306, class178.field2917, true, 11 == client.field283?4:0);
            } else if(11 == var0) {
               class45.method948(class3.field66, client.field306, class178.field2917, false, 4);
            } else if(class31.field699) {
               class31.field731 = null;
               class31.field705 = null;
               class31.field697 = null;
               class186.field3010 = null;
               class31.field700 = null;
               class31.field701 = null;
               class138.field2111 = null;
               class77.field1379 = null;
               class1.field21 = null;
               class31.field718 = null;
               class3.field68 = null;
               class75.field1359 = null;
               class26.field642 = null;
               class10.field162 = null;
               class27.field647 = null;
               class214.field3157 = null;
               class82.field1412 = null;
               class35.field769 = null;
               class56.field1165 = null;
               class9.field152 = null;
               class5.field86 = null;
               class176.field2907 = null;
               class183.field2959 = 1;
               class76.field1370 = null;
               class183.field2960 = -1;
               class183.field2961 = -1;
               class183.field2957 = 0;
               class183.field2964 = false;
               class183.field2963 = 2;
               class5.method69(true);
               class31.field699 = false;
            }
         } else {
            class45.method948(class3.field66, client.field306, class178.field2917, true, 0);
         }

         client.field283 = var0;
      }
   }

   public void run() {
      for(; this.field195; class14.method170(50L)) {
         Object var1 = this.field191;
         synchronized(this.field191) {
            if(this.field193 < 500) {
               this.field194[this.field193] = class140.field2128;
               this.field196[this.field193] = class140.field2126;
               ++this.field193;
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-520827020"
   )
   static final void method165() {
      if(class14.field203 != null) {
         class14.field203.method1218();
      }

      if(null != class17.field244) {
         class17.field244.method1218();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "831973615"
   )
   static final int method166(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass167;IIB)Lclass78;",
      garbageValue = "36"
   )
   public static class78 method167(class167 var0, int var1, int var2) {
      if(!class31.method691(var0, var1, var2)) {
         return null;
      } else {
         class78 var4 = new class78();
         var4.field1387 = class76.field1364;
         var4.field1388 = class129.field2027;
         var4.field1385 = class76.field1366[0];
         var4.field1382 = class76.field1367[0];
         var4.field1383 = class52.field1145[0];
         var4.field1384 = class76.field1371[0];
         int var5 = var4.field1384 * var4.field1383;
         byte[] var6 = client.field557[0];
         var4.field1392 = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.field1392[var7] = class227.field3220[var6[var7] & 255];
         }

         class157.method3133();
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1171120567"
   )
   public static void method168() {
      if(null != class137.field2089) {
         class137 var0 = class137.field2089;
         synchronized(class137.field2089) {
            class137.field2089 = null;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1558853093"
   )
   static final int method169(int var0, int var1) {
      int var2 = class122.method2751(var0 - 1, var1 - 1) + class122.method2751(1 + var0, var1 - 1) + class122.method2751(var0 - 1, var1 + 1) + class122.method2751(var0 + 1, var1 + 1);
      int var3 = class122.method2751(var0 - 1, var1) + class122.method2751(1 + var0, var1) + class122.method2751(var0, var1 - 1) + class122.method2751(var0, var1 + 1);
      int var4 = class122.method2751(var0, var1);
      return var4 / 4 + var2 / 16 + var3 / 8;
   }
}
