import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("ClassInfo")
public class class213 extends class211 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1404142695
   )
   int field3177;
   @ObfuscatedName("s")
   int[] field3178;
   @ObfuscatedName("r")
   int[] field3179;
   @ObfuscatedName("e")
   int[] field3180;
   @ObfuscatedName("h")
   @Export("fields")
   Field[] field3181;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -979840383
   )
   int field3182;
   @ObfuscatedName("k")
   @Export("methods")
   Method[] field3183;
   @ObfuscatedName("u")
   @Export("args")
   byte[][][] field3184;

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "392132640"
   )
   static final void method4080(int var0) {
      class9.method125();

      for(class24 var1 = (class24)class24.field630.method3980(); null != var1; var1 = (class24)class24.field630.method3970()) {
         if(null != var1.field634) {
            var1.method603();
         }
      }

      int var4 = class147.method3242(var0).field1234;
      if(var4 != 0) {
         int var2 = class179.field2958[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               class94.method2225(0.9D);
               ((class98)class94.field1658).method2258(0.9D);
            }

            if(var2 == 2) {
               class94.method2225(0.8D);
               ((class98)class94.field1658).method2258(0.8D);
            }

            if(var2 == 3) {
               class94.method2225(0.7D);
               ((class98)class94.field1658).method2258(0.7D);
            }

            if(var2 == 4) {
               class94.method2225(0.6D);
               ((class98)class94.field1658).method2258(0.6D);
            }

            class6.method106();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != client.field294) {
               if(client.field294 == 0 && client.field457 != -1) {
                  class180.method3615(class188.field3051, client.field457, 0, var3, false);
                  client.field533 = false;
               } else if(var3 == 0) {
                  class49.method1056();
                  client.field533 = false;
               } else if(class186.field3010 != 0) {
                  class11.field176 = var3;
               } else {
                  class59.field1266.method3750(var3);
               }

               client.field294 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               client.field403 = 127;
            }

            if(var2 == 1) {
               client.field403 = 96;
            }

            if(var2 == 2) {
               client.field403 = 64;
            }

            if(var2 == 3) {
               client.field403 = 32;
            }

            if(var2 == 4) {
               client.field403 = 0;
            }
         }

         if(var4 == 5) {
            client.field412 = var2;
         }

         if(var4 == 6) {
            client.field455 = var2;
         }

         if(var4 == 9) {
            client.field446 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               client.field535 = 127;
            }

            if(var2 == 1) {
               client.field535 = 96;
            }

            if(var2 == 2) {
               client.field535 = 64;
            }

            if(var2 == 3) {
               client.field535 = 32;
            }

            if(var2 == 4) {
               client.field535 = 0;
            }
         }

         if(var4 == 17) {
            client.field555 = var2 & '\uffff';
         }

         if(var4 == 18) {
            client.field292 = (class21)class85.method1971(class12.method166(), var2);
            if(client.field292 == null) {
               client.field292 = class21.field590;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               client.field425 = -1;
            } else {
               client.field425 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            client.field420 = (class21)class85.method1971(class12.method166(), var2);
            if(client.field420 == null) {
               client.field420 = class21.field590;
            }
         }

      }
   }
}
