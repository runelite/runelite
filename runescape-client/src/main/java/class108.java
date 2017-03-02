import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class108 {
   @ObfuscatedName("b")
   static class182 field1728;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "251898299"
   )
   static void method2095(String var0, String var1, String var2) {
      class41.loginMessage1 = var0;
      class41.loginMessage2 = var1;
      class41.loginMessage3 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-901785135"
   )
   public static void method2096() {
      Overlay.field3053.reset();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2095982511"
   )
   public static void method2097(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            class215.field3175.method3360(var0);
            if(Widget.widgets[var0] != null) {
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

   class108() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-52"
   )
   static final void method2098(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class159.method3142(var0)) {
         class195.method3638(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-124"
   )
   static final void method2099() {
      for(class25 var0 = (class25)Client.field467.method2472(); null != var0; var0 = (class25)Client.field467.method2479()) {
         if(var0.field581 > 0) {
            --var0.field581;
         }

         boolean var1;
         int var2;
         int var3;
         ObjectComposition var4;
         if(var0.field581 == 0) {
            if(var0.field574 >= 0) {
               var2 = var0.field574;
               var3 = var0.field576;
               var4 = class196.getObjectDefinition(var2);
               if(var3 == 11) {
                  var3 = 10;
               }

               if(var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method3717(var3);
               if(!var1) {
                  continue;
               }
            }

            ScriptState.method164(var0.field587, var0.field571, var0.field573, var0.field583, var0.field574, var0.field572, var0.field576);
            var0.unlink();
         } else {
            if(var0.field582 > 0) {
               --var0.field582;
            }

            if(var0.field582 == 0 && var0.field573 >= 1 && var0.field583 >= 1 && var0.field573 <= 102 && var0.field583 <= 102) {
               if(var0.field570 >= 0) {
                  var2 = var0.field570;
                  var3 = var0.field577;
                  var4 = class196.getObjectDefinition(var2);
                  if(var3 == 11) {
                     var3 = 10;
                  }

                  if(var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method3717(var3);
                  if(!var1) {
                     continue;
                  }
               }

               ScriptState.method164(var0.field587, var0.field571, var0.field573, var0.field583, var0.field570, var0.field578, var0.field577);
               var0.field582 = -1;
               if(var0.field574 == var0.field570 && var0.field574 == -1) {
                  var0.unlink();
               } else if(var0.field574 == var0.field570 && var0.field572 == var0.field578 && var0.field576 == var0.field577) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1134483855"
   )
   public static int method2100(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }
}
