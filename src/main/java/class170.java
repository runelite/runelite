import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class170 implements Runnable {
   @ObfuscatedName("c")
   static Object field2705 = new Object();
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1130206189
   )
   static int field2706 = 0;
   @ObfuscatedName("a")
   static class199 field2707 = new class199();
   @ObfuscatedName("w")
   static class199 field2711 = new class199();

   public void run() {
      try {
         while(true) {
            class199 var2 = field2707;
            class169 var1;
            synchronized(field2707) {
               var1 = (class169)field2707.method3926();
            }

            Object var14;
            if(null != var1) {
               if(0 == var1.field2698) {
                  var1.field2699.method2977((int)var1.field3125, var1.field2695, var1.field2695.length);
                  var2 = field2707;
                  synchronized(field2707) {
                     var1.method3998();
                  }
               } else if(var1.field2698 == 1) {
                  var1.field2695 = var1.field2699.method2979((int)var1.field3125);
                  var2 = field2707;
                  synchronized(field2707) {
                     field2711.method3900(var1);
                  }
               }

               var14 = field2705;
               synchronized(field2705) {
                  if(field2706 <= 1) {
                     field2706 = 0;
                     field2705.notifyAll();
                     return;
                  }

                  field2706 = 600;
               }
            } else {
               class4.method55(100L);
               var14 = field2705;
               synchronized(field2705) {
                  if(field2706 <= 1) {
                     field2706 = 0;
                     field2705.notifyAll();
                     return;
                  }

                  --field2706;
               }
            }
         }
      } catch (Exception var13) {
         class22.method655((String)null, var13);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2"
   )
   public static void method3462(int var0) {
      class183.field2967 = 1;
      class114.field1965 = null;
      class183.field2963 = -1;
      class183.field2968 = -1;
      class183.field2966 = 0;
      class90.field1568 = false;
      class59.field1228 = var0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;ZB)V",
      garbageValue = "78"
   )
   public static void method3467(class167 var0, class167 var1, boolean var2) {
      class226.field3214 = var0;
      class222.field3182 = var1;
      class40.field934 = var2;
   }
}
