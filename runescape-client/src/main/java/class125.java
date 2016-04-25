import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public abstract class class125 {
   @ObfuscatedName("h")
   static boolean field2015 = false;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1250119583"
   )
   abstract void vmethod2768(byte[] var1);

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "2069103428"
   )
   static final void method2769(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field453) {
         if(client.field415 < 500) {
            client.field420[client.field415] = var0;
            client.field290[client.field415] = var1;
            client.field418[client.field415] = var2;
            client.field502[client.field415] = var3;
            client.field385[client.field415] = var4;
            client.field417[client.field415] = var5;
            ++client.field415;
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "14"
   )
   abstract byte[] vmethod2773();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-661333089"
   )
   static final void method2780(class122 var0) {
      int var1 = 0;
      var0.method2736();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class32.field737; ++var2) {
         var3 = class32.field738[var2];
         if(0 == (class32.field734[var3] & 1)) {
            if(var1 > 0) {
               --var1;
               class32.field734[var3] = (byte)(class32.field734[var3] | 2);
            } else {
               var4 = var0.method2737(1);
               if(var4 == 0) {
                  var1 = class20.method557(var0);
                  class32.field734[var3] = (byte)(class32.field734[var3] | 2);
               } else {
                  class17.method188(var0, var3);
               }
            }
         }
      }

      var0.method2733();
      if(0 != var1) {
         throw new RuntimeException();
      } else {
         var0.method2736();

         for(var2 = 0; var2 < class32.field737; ++var2) {
            var3 = class32.field738[var2];
            if((class32.field734[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class32.field734[var3] = (byte)(class32.field734[var3] | 2);
               } else {
                  var4 = var0.method2737(1);
                  if(0 == var4) {
                     var1 = class20.method557(var0);
                     class32.field734[var3] = (byte)(class32.field734[var3] | 2);
                  } else {
                     class17.method188(var0, var3);
                  }
               }
            }
         }

         var0.method2733();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2736();

            for(var2 = 0; var2 < class32.field739; ++var2) {
               var3 = class32.field740[var2];
               if(0 != (class32.field734[var3] & 1)) {
                  if(var1 > 0) {
                     --var1;
                     class32.field734[var3] = (byte)(class32.field734[var3] | 2);
                  } else {
                     var4 = var0.method2737(1);
                     if(var4 == 0) {
                        var1 = class20.method557(var0);
                        class32.field734[var3] = (byte)(class32.field734[var3] | 2);
                     } else if(class84.method1892(var0, var3)) {
                        class32.field734[var3] = (byte)(class32.field734[var3] | 2);
                     }
                  }
               }
            }

            var0.method2733();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2736();

               for(var2 = 0; var2 < class32.field739; ++var2) {
                  var3 = class32.field740[var2];
                  if(0 == (class32.field734[var3] & 1)) {
                     if(var1 > 0) {
                        --var1;
                        class32.field734[var3] = (byte)(class32.field734[var3] | 2);
                     } else {
                        var4 = var0.method2737(1);
                        if(0 == var4) {
                           var1 = class20.method557(var0);
                           class32.field734[var3] = (byte)(class32.field734[var3] | 2);
                        } else if(class84.method1892(var0, var3)) {
                           class32.field734[var3] = (byte)(class32.field734[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2733();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class32.field737 = 0;
                  class32.field739 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class32.field734[var2] = (byte)(class32.field734[var2] >> 1);
                     class2 var5 = client.field396[var2];
                     if(var5 != null) {
                        class32.field738[++class32.field737 - 1] = var2;
                     } else {
                        class32.field740[++class32.field739 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }
}
