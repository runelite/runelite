import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("y")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("g")
   static int[] field206;
   @ObfuscatedName("k")
   @Export("name")
   String name;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZI)V",
      garbageValue = "1004106557"
   )
   static void method204(class184 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class181 var8 = (class181)class185.field2736.method2331(var6);
      if(null == var8) {
         var8 = (class181)class185.field2733.method2331(var6);
         if(var8 == null) {
            var8 = (class181)class185.field2741.method2331(var6);
            if(null != var8) {
               if(var5) {
                  var8.method2411();
                  class185.field2736.method2333(var8, var6);
                  --class185.field2731;
                  ++class185.field2732;
               }

            } else {
               if(!var5) {
                  var8 = (class181)class185.field2740.method2331(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2692 = var0;
               var8.field2687 = var3;
               var8.field2686 = var4;
               if(var5) {
                  class185.field2736.method2333(var8, var6);
                  ++class185.field2732;
               } else {
                  class185.field2729.method2282(var8);
                  class185.field2741.method2333(var8, var6);
                  ++class185.field2731;
               }

            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1265145590"
   )
   public static void method205(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            class156.field2213.method3286(var0);
            if(null != Widget.widgets[var0]) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(null != Widget.widgets[var0][var2]) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IZB)Ljava/lang/String;",
      garbageValue = "93"
   )
   public static String method206(int var0, boolean var1) {
      return var1 && var0 >= 0?class185.method3407(var0, 10, var1):Integer.toString(var0);
   }
}
