import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class170 implements Runnable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -801960781
   )
   static int field2736 = 0;
   @ObfuscatedName("i")
   static class199 field2737 = new class199();
   @ObfuscatedName("t")
   static class199 field2738 = new class199();
   @ObfuscatedName("h")
   static Object field2739 = new Object();

   public void run() {
      try {
         while(true) {
            class199 var2 = field2738;
            class169 var1;
            synchronized(field2738) {
               var1 = (class169)field2738.method3797();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2733 == 0) {
                  var1.field2732.method2831((int)var1.field3125, var1.field2731, var1.field2731.length);
                  var2 = field2738;
                  synchronized(field2738) {
                     var1.method3870();
                  }
               } else if(var1.field2733 == 1) {
                  var1.field2731 = var1.field2732.method2833((int)var1.field3125);
                  var2 = field2738;
                  synchronized(field2738) {
                     field2737.method3771(var1);
                  }
               }

               var14 = field2739;
               synchronized(field2739) {
                  if(field2736 <= 1) {
                     field2736 = 0;
                     field2739.notifyAll();
                     return;
                  }

                  field2736 = 600;
               }
            } else {
               class45.method926(100L);
               var14 = field2739;
               synchronized(field2739) {
                  if(field2736 <= 1) {
                     field2736 = 0;
                     field2739.notifyAll();
                     return;
                  }

                  --field2736;
               }
            }
         }
      } catch (Exception var13) {
         class30.method654((String)null, var13);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Lclass173;",
      garbageValue = "-1702951195"
   )
   public static class173 method3344(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(null == class216.field3168[var1] || class216.field3168[var1][var2] == null) {
         boolean var3 = class173.method3380(var1);
         if(!var3) {
            return null;
         }
      }

      return class216.field3168[var1][var2];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)[Lclass82;",
      garbageValue = "19"
   )
   public static class82[] method3345() {
      return new class82[]{class82.field1434, class82.field1433, class82.field1439, class82.field1437, class82.field1432};
   }
}
