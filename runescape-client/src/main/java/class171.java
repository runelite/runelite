import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class171 {
   @ObfuscatedName("by")
   @Export("indexTextures")
   static IndexData indexTextures;

   class171() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LRSSocket;ZI)V",
      garbageValue = "-759398057"
   )
   public static void method3304(RSSocket var0, boolean var1) {
      if(class185.field2770 != null) {
         try {
            class185.field2770.method2113();
         } catch (Exception var7) {
            ;
         }

         class185.field2770 = null;
      }

      class185.field2770 = var0;
      class3.method19(var1);
      class185.field2773.offset = 0;
      class1.field14 = null;
      class185.field2775 = null;
      class185.field2776 = 0;

      while(true) {
         class181 var2 = (class181)class185.field2767.method2420();
         if(var2 == null) {
            while(true) {
               var2 = (class181)class185.field2772.method2420();
               if(var2 == null) {
                  if(class185.field2780 != 0) {
                     try {
                        Buffer var3 = new Buffer(4);
                        var3.putByte(4);
                        var3.putByte(class185.field2780);
                        var3.putShort(0);
                        class185.field2770.queueForWrite(var3.payload, 0, 4);
                     } catch (IOException var6) {
                        try {
                           class185.field2770.method2113();
                        } catch (Exception var5) {
                           ;
                        }

                        ++class185.field2782;
                        class185.field2770 = null;
                     }
                  }

                  class185.field2763 = 0;
                  class185.field2778 = class45.method867();
                  return;
               }

               class185.field2768.method2364(var2);
               class185.field2762.method2418(var2, var2.hash);
               ++class185.field2771;
               --class185.field2769;
            }
         }

         class185.field2765.method2418(var2, var2.hash);
         ++class185.field2774;
         --class185.field2766;
      }
   }
}
