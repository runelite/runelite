import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class50 extends class204 {
   @ObfuscatedName("w")
   static class193 field1075 = new class193(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1785653205
   )
   public int field1076 = 0;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -418296927
   )
   static int field1077;

   @ObfuscatedName("w")
   void method1004(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(var2 == 0) {
            return;
         }

         this.method1007(var1, var2);
      }
   }

   @ObfuscatedName("e")
   public static String method1005(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && 46 != var4 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(32 == var4) {
               var2.append('+');
            } else {
               byte var5 = class160.method3187(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("f")
   void method1007(class119 var1, int var2) {
      if(2 == var2) {
         this.field1076 = var1.method2700();
      }

   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2040949078"
   )
   static final void method1012(int var0) {
      class13.method165();

      for(class23 var1 = (class23)class23.field601.method3825(); var1 != null; var1 = (class23)class23.field601.method3827()) {
         if(var1.field602 != null) {
            var1.method587();
         }
      }

      int var4 = class35.method732(var0).field1140;
      if(0 != var4) {
         int var2 = class176.field2903[var0];
         if(1 == var4) {
            if(var2 == 1) {
               class91.method2109(0.9D);
               ((class95)class91.field1569).method2187(0.9D);
            }

            if(2 == var2) {
               class91.method2109(0.8D);
               ((class95)class91.field1569).method2187(0.8D);
            }

            if(3 == var2) {
               class91.method2109(0.7D);
               ((class95)class91.field1569).method2187(0.7D);
            }

            if(4 == var2) {
               class91.method2109(0.6D);
               ((class95)class91.field1569).method2187(0.6D);
            }

            class43.method904();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(1 == var2) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(3 == var2) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(client.field515 != var3) {
               if(0 == client.field515 && -1 != client.field516) {
                  class99.method2218(class24.field611, client.field516, 0, var3, false);
                  client.field427 = false;
               } else if(var3 == 0) {
                  class39.method785();
                  client.field427 = false;
               } else if(class183.field2958 != 0) {
                  class96.field1611 = var3;
               } else {
                  class183.field2957.method3588(var3);
               }

               client.field515 = var3;
            }
         }

         if(4 == var4) {
            if(var2 == 0) {
               client.field396 = 127;
            }

            if(1 == var2) {
               client.field396 = 96;
            }

            if(2 == var2) {
               client.field396 = 64;
            }

            if(var2 == 3) {
               client.field396 = 32;
            }

            if(var2 == 4) {
               client.field396 = 0;
            }
         }

         if(var4 == 5) {
            client.field417 = var2;
         }

         if(var4 == 6) {
            client.field440 = var2;
         }

         if(9 == var4) {
            client.field441 = var2;
         }

         if(10 == var4) {
            if(var2 == 0) {
               client.field519 = 127;
            }

            if(var2 == 1) {
               client.field519 = 96;
            }

            if(2 == var2) {
               client.field519 = 64;
            }

            if(3 == var2) {
               client.field519 = 32;
            }

            if(4 == var2) {
               client.field519 = 0;
            }
         }

         if(17 == var4) {
            client.field327 = var2 & '\uffff';
         }

         if(18 == var4) {
            client.field454 = (class20)class35.method731(class48.method994(), var2);
            if(client.field454 == null) {
               client.field454 = class20.field564;
            }
         }

         if(var4 == 19) {
            if(-1 == var2) {
               client.field409 = -1;
            } else {
               client.field409 = var2 & 2047;
            }
         }

         if(22 == var4) {
            client.field488 = (class20)class35.method731(class48.method994(), var2);
            if(null == client.field488) {
               client.field488 = class20.field564;
            }
         }

      }
   }

   @ObfuscatedName("s")
   static class35 method1013(int var0, int var1) {
      class27 var2 = (class27)class11.field172.get(Integer.valueOf(var0));
      return var2.method637(var1);
   }

   @ObfuscatedName("p")
   public static void method1014() {
      class52.field1135.method3760();
   }
}
