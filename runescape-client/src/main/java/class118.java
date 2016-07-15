import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class118 {
   @ObfuscatedName("r")
   @Export("worldList")
   static class27[] field2032;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 1894964914727603657L
   )
   static long field2034;
   @ObfuscatedName("hj")
   @Export("localPlayer")
   static class2 field2035;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 8989142048524275583L
   )
   static long field2037;

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1153991323"
   )
   static final void method2536(int var0) {
      class132.method2934();

      for(class24 var4 = (class24)class24.field628.method3899(); null != var4; var4 = (class24)class24.field628.method3918()) {
         if(null != var4.field632) {
            var4.method582();
         }
      }

      int var1 = class113.method2510(var0).field1231;
      if(var1 != 0) {
         int var2 = class179.field2944[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class94.method2206(0.9D);
               ((class98)class94.field1646).method2264(0.9D);
            }

            if(var2 == 2) {
               class94.method2206(0.8D);
               ((class98)class94.field1646).method2264(0.8D);
            }

            if(var2 == 3) {
               class94.method2206(0.7D);
               ((class98)class94.field1646).method2264(0.7D);
            }

            if(var2 == 4) {
               class94.method2206(0.6D);
               ((class98)class94.field1646).method2264(0.6D);
            }

            class55.field1179.method3835();
         }

         if(var1 == 3) {
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

            if(client.field354 != var3) {
               if(client.field354 == 0 && client.field533 != -1) {
                  class127.method2904(class109.field1948, client.field533, 0, var3, false);
                  client.field411 = false;
               } else if(var3 == 0) {
                  class90.method2176();
                  client.field411 = false;
               } else {
                  class85.method1985(var3);
               }

               client.field354 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               client.field376 = 127;
            }

            if(var2 == 1) {
               client.field376 = 96;
            }

            if(var2 == 2) {
               client.field376 = 64;
            }

            if(var2 == 3) {
               client.field376 = 32;
            }

            if(var2 == 4) {
               client.field376 = 0;
            }
         }

         if(var1 == 5) {
            client.field433 = var2;
         }

         if(var1 == 6) {
            client.field456 = var2;
         }

         if(var1 == 9) {
            client.field394 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               client.field536 = 127;
            }

            if(var2 == 1) {
               client.field536 = 96;
            }

            if(var2 == 2) {
               client.field536 = 64;
            }

            if(var2 == 3) {
               client.field536 = 32;
            }

            if(var2 == 4) {
               client.field536 = 0;
            }
         }

         if(var1 == 17) {
            client.field462 = var2 & '\uffff';
         }

         if(var1 == 18) {
            client.field320 = (class21)class25.method585(class13.method152(), var2);
            if(client.field320 == null) {
               client.field320 = class21.field597;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               client.field425 = -1;
            } else {
               client.field425 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            client.field321 = (class21)class25.method585(class13.method152(), var2);
            if(null == client.field321) {
               client.field321 = class21.field597;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   public static void method2540() {
      class51.field1123.method3835();
      class51.field1124.method3835();
      class51.field1125.method3835();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1956939341"
   )
   public static void method2541() {
      class143 var0 = class143.field2194;
      synchronized(class143.field2194) {
         class143.field2199 = class143.field2196;
         class143.field2198 = class143.field2197;
         class143.field2201 = class143.field2211;
         class143.field2208 = class143.field2206;
         class143.field2207 = class143.field2203;
         class143.field2213 = class143.field2204;
         class143.field2209 = class143.field2205;
         class143.field2206 = 0;
      }
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Z",
      garbageValue = "-22960"
   )
   static boolean method2542(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class17.method167(var0, client.field296);

         for(int var2 = 0; var2 < client.field346; ++var2) {
            class7 var3 = client.field560[var2];
            if(var1.equalsIgnoreCase(class17.method167(var3.field141, client.field296))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class17.method167(var3.field131, client.field296))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-1596759262"
   )
   @Export("addMenuEntry")
   static final void method2543(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field540) {
         if(client.field435 < 500) {
            client.field440[client.field435] = var0;
            client.field441[client.field435] = var1;
            client.field438[client.field435] = var2;
            client.field303[client.field435] = var3;
            client.field436[client.field435] = var4;
            client.field437[client.field435] = var5;
            ++client.field435;
         }

      }
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1773025049"
   )
   static final void method2544(int var0, int var1, int var2, boolean var3) {
      if(class10.method112(var0)) {
         class125.method2871(class176.field2811[var0], -1, var1, var2, var3);
      }
   }
}
