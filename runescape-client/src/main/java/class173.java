import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class173 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass110;ZI)V",
      garbageValue = "-1397219629"
   )
   public static void method3181(class110 var0, boolean var1) {
      if(class185.field2750 != null) {
         try {
            class185.field2750.method2035();
         } catch (Exception var6) {
            ;
         }

         class185.field2750 = null;
      }

      class185.field2750 = var0;
      class185.method3360(var1);
      class185.field2752.offset = 0;
      class161.field2149 = null;
      class185.field2758 = null;
      class185.field2745 = 0;

      while(true) {
         class181 var2 = (class181)class185.field2749.method2313();
         if(null == var2) {
            while(true) {
               var2 = (class181)class185.field2754.method2313();
               if(var2 == null) {
                  if(class185.field2762 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.method2932(4);
                        var7.method2932(class185.field2762);
                        var7.method2746(0);
                        class185.field2750.method2032(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class185.field2750.method2035();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class185.field2764;
                        class185.field2750 = null;
                     }
                  }

                  class185.field2746 = 0;
                  class101.field1638 = class72.method1385();
                  return;
               }

               class185.field2751.method2259(var2);
               class185.field2757.method2312(var2, var2.hash);
               ++class185.field2753;
               --class185.field2763;
            }
         }

         class185.field2747.method2312(var2, var2.hash);
         ++class185.field2765;
         --class185.field2748;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-280654124"
   )
   static int method3182(int var0) {
      MessageNode var1 = (MessageNode)class47.field944.method2284((long)var0);
      return null == var1?-1:(var1.next == class47.field940.field1896?-1:((MessageNode)var1.next).id);
   }
}
