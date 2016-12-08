import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
final class class44 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;S)I",
      garbageValue = "4095"
   )
   int method782(class2 var1, class2 var2) {
      if(var2.field17 == var1.field17) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field17) {
               return -1;
            }

            if(Client.world == var2.field17) {
               return 1;
            }
         }

         return var1.field17 < var2.field17?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method782((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "-1040425173"
   )
   static final void method783(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         method792(var2);
      }

      class107.method1992(var2);
      Widget var4 = class174.method3178(var3);
      if(var4 != null) {
         class97.method1886(var4);
      }

      Frames.method1850();
      if(Client.widgetRoot != -1) {
         XGrandExchangeOffer.method45(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "-34"
   )
   static final boolean method791(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field340 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field495.method3071(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field495.method3065(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field495.method3062(false);
         }

         if(var1 == 325) {
            Client.field495.method3062(true);
         }

         if(var1 == 326) {
            Client.field330.method2967(100);
            Client.field495.method3070(Client.field330);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public static void method792(int var0) {
      if(var0 != -1) {
         if(class88.validInterfaces[var0]) {
            Ignore.field216.method3215(var0);
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

               class88.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "611615923"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3049.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         class182 var3 = Sequence.field3057;
         class182 var4 = Sequence.field3061;
         boolean var5 = true;
         int[] var6 = var3.method3212(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3209(var0, var6[var7]);
            if(null == var8) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3209(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(var2 != null) {
            Sequence.field3049.put(var2, (long)var0);
         }

         return var2;
      }
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }
}
