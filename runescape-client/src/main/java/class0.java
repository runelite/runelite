import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class0 extends class208 {
   @ObfuscatedName("i")
   boolean field1;
   @ObfuscatedName("g")
   class173 field2;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -621026279
   )
   int field4;
   @ObfuscatedName("t")
   Object[] field5;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1592010491
   )
   int field6;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2119271147
   )
   int field7;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1753246443
   )
   int field8;
   @ObfuscatedName("l")
   String field9;
   @ObfuscatedName("f")
   class173 field10;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      longValue = -8614666510861636871L
   )
   static long field11;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1253641219
   )
   int field12;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2139422161
   )
   int field17;

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1354731999"
   )
   static final void method0() {
      class20.method547(client.field455);
      ++class1.field28;
      if(client.field427 && client.field416) {
         int var0 = class140.field2192;
         int var1 = class140.field2189;
         var0 -= client.field491;
         var1 -= client.field348;
         if(var0 < client.field279) {
            var0 = client.field279;
         }

         if(client.field455.field2791 + var0 > client.field456.field2791 + client.field279) {
            var0 = client.field456.field2791 + client.field279 - client.field455.field2791;
         }

         if(var1 < client.field408) {
            var1 = client.field408;
         }

         if(var1 + client.field455.field2792 > client.field456.field2792 + client.field408) {
            var1 = client.field456.field2792 + client.field408 - client.field455.field2792;
         }

         int var2 = var0 - client.field503;
         int var3 = var1 - client.field465;
         int var4 = client.field455.field2852;
         if(class1.field28 > client.field455.field2831 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            client.field513 = true;
         }

         int var5 = var0 - client.field279 + client.field456.field2835;
         int var6 = var1 - client.field408 + client.field456.field2861;
         class0 var7;
         if(client.field455.field2790 != null && client.field513) {
            var7 = new class0();
            var7.field2 = client.field455;
            var7.field6 = var5;
            var7.field4 = var6;
            var7.field5 = client.field455.field2790;
            class171.method3363(var7);
         }

         if(class140.field2178 == 0) {
            if(client.field513) {
               if(client.field455.field2866 != null) {
                  var7 = new class0();
                  var7.field2 = client.field455;
                  var7.field6 = var5;
                  var7.field4 = var6;
                  var7.field10 = client.field459;
                  var7.field5 = client.field455.field2866;
                  class171.method3363(var7);
               }

               if(client.field459 != null) {
                  class173 var8 = client.field455;
                  int var9 = class29.method649(class138.method2906(var8));
                  if(var9 == 0) {
                     var7 = null;
                  } else {
                     int var10 = 0;

                     while(true) {
                        if(var10 >= var9) {
                           break;
                        }

                        var8 = class170.method3344(var8.field2795);
                        if(var8 == null) {
                           var7 = null;
                           break;
                        }

                        ++var10;
                     }
                  }
               }
            } else if((client.field422 == 1 || class89.method2048(client.field294 - 1)) && client.field294 > 2) {
               class18.method173(client.field491 + client.field503, client.field348 + client.field465);
            } else if(client.field294 > 0) {
               class31.method678(client.field491 + client.field503, client.field465 + client.field348);
            }

            client.field455 = null;
         }

      } else {
         if(class1.field28 > 1) {
            client.field455 = null;
         }

      }
   }
}
