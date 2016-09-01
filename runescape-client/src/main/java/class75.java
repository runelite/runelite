import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class75 implements Runnable {
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 2070782949
   )
   static int field1391;
   @ObfuscatedName("r")
   volatile class59[] field1392 = new class59[2];
   @ObfuscatedName("j")
   volatile boolean field1393 = false;
   @ObfuscatedName("z")
   volatile boolean field1394 = false;
   @ObfuscatedName("x")
   class139 field1396;

   public void run() {
      this.field1394 = true;

      try {
         while(!this.field1393) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class59 var2 = this.field1392[var1];
               if(var2 != null) {
                  var2.method1215();
               }
            }

            class125.method2820(10L);
            class128.method2861(this.field1396, (Object)null);
         }
      } catch (Exception var7) {
         class107.method2357((String)null, var7);
      } finally {
         this.field1394 = false;
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-108"
   )
   static final void method1604() {
      for(class16 var0 = (class16)Client.field413.method3850(); var0 != null; var0 = (class16)Client.field413.method3852()) {
         if(var0.field241 > 0) {
            --var0.field241;
         }

         if(var0.field241 == 0) {
            if(var0.field234 < 0 || RSCanvas.method2985(var0.field234, var0.field236)) {
               XItemContainer.method183(var0.field243, var0.field231, var0.field244, var0.field235, var0.field234, var0.field232, var0.field236);
               var0.unlink();
            }
         } else {
            if(var0.field240 > 0) {
               --var0.field240;
            }

            if(var0.field240 == 0 && var0.field244 >= 1 && var0.field235 >= 1 && var0.field244 <= 102 && var0.field235 <= 102 && (var0.field233 < 0 || RSCanvas.method2985(var0.field233, var0.field239))) {
               XItemContainer.method183(var0.field243, var0.field231, var0.field244, var0.field235, var0.field233, var0.field238, var0.field239);
               var0.field240 = -1;
               if(var0.field234 == var0.field233 && var0.field234 == -1) {
                  var0.unlink();
               } else if(var0.field234 == var0.field233 && var0.field238 == var0.field232 && var0.field239 == var0.field236) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)V",
      garbageValue = "-659213357"
   )
   public static void method1605(class170 var0, class170 var1) {
      class45.field1019 = var0;
      class45.field1013 = var1;
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "0"
   )
   static void method1606(Widget var0) {
      if(Client.field483 == var0.field2817) {
         Client.field484[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "1874638910"
   )
   static final String[] method1607(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(null != var0 && null != var0[var2]) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
