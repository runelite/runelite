import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("ClassInfo")
public class ClassInfo extends Node {
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
   Field[] fields;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -979840383
   )
   int field3182;
   @ObfuscatedName("k")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("u")
   @Export("args")
   byte[][][] args;

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

      int var4 = GameEngine.method3242(var0).field1234;
      if(var4 != 0) {
         int var2 = class179.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               class94.method2225(0.9D);
               ((TextureProvider)class94.field1658).method2258(0.9D);
            }

            if(var2 == 2) {
               class94.method2225(0.8D);
               ((TextureProvider)class94.field1658).method2258(0.8D);
            }

            if(var2 == 3) {
               class94.method2225(0.7D);
               ((TextureProvider)class94.field1658).method2258(0.7D);
            }

            if(var2 == 4) {
               class94.method2225(0.6D);
               ((TextureProvider)class94.field1658).method2258(0.6D);
            }

            Projectile.method106();
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

            if(var3 != Client.field294) {
               if(Client.field294 == 0 && Client.field457 != -1) {
                  class180.method3615(class188.field3051, Client.field457, 0, var3, false);
                  Client.field533 = false;
               } else if(var3 == 0) {
                  class49.method1056();
                  Client.field533 = false;
               } else if(class186.field3010 != 0) {
                  class11.field176 = var3;
               } else {
                  class59.field1266.method3750(var3);
               }

               Client.field294 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field403 = 127;
            }

            if(var2 == 1) {
               Client.field403 = 96;
            }

            if(var2 == 2) {
               Client.field403 = 64;
            }

            if(var2 == 3) {
               Client.field403 = 32;
            }

            if(var2 == 4) {
               Client.field403 = 0;
            }
         }

         if(var4 == 5) {
            Client.field412 = var2;
         }

         if(var4 == 6) {
            Client.field455 = var2;
         }

         if(var4 == 9) {
            Client.field446 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field535 = 127;
            }

            if(var2 == 1) {
               Client.field535 = 96;
            }

            if(var2 == 2) {
               Client.field535 = 64;
            }

            if(var2 == 3) {
               Client.field535 = 32;
            }

            if(var2 == 4) {
               Client.field535 = 0;
            }
         }

         if(var4 == 17) {
            Client.field555 = var2 & '\uffff';
         }

         if(var4 == 18) {
            Client.field292 = (class21)class85.method1971(class12.method166(), var2);
            if(Client.field292 == null) {
               Client.field292 = class21.field590;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field425 = -1;
            } else {
               Client.field425 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            Client.field420 = (class21)class85.method1971(class12.method166(), var2);
            if(Client.field420 == null) {
               Client.field420 = class21.field590;
            }
         }
      }

   }
}
