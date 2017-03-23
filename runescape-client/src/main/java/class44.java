import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
final class class44 implements Comparator {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1873195065
   )
   public static int field918;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   public int compare(Object var1, Object var2) {
      return this.method881((class2)var1, (class2)var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-445811925"
   )
   int method881(class2 var1, class2 var2) {
      if(var1.field26 == var2.field26) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field26 == Client.world) {
               return -1;
            }

            if(Client.world == var2.field26) {
               return 1;
            }
         }

         return var1.field26 < var2.field26?-1:1;
      }
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1289996283"
   )
   public static void method884(boolean var0) {
      if(null != class185.field2748) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class185.field2748.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class185.field2748.method2115();
            } catch (Exception var3) {
               ;
            }

            ++class185.field2758;
            class185.field2748 = null;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-564104197"
   )
   static void method889(int var0) {
      if(var0 != -1) {
         if(method892(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(null != var3.field2256) {
                  class18 var4 = new class18();
                  var4.field223 = var3;
                  var4.field232 = var3.field2256;
                  Player.method271(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;ZLFont;I)V",
      garbageValue = "1921240862"
   )
   public static void method891(class182 var0, class182 var1, boolean var2, Font var3) {
      ItemComposition.field2975 = var0;
      ItemComposition.field2951 = var1;
      class47.isMembersWorld = var2;
      class105.field1737 = ItemComposition.field2975.method3316(10);
      class25.field610 = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1865350513"
   )
   public static boolean method892(int var0) {
      if(NPC.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2269.method3309(var0)) {
         return false;
      } else {
         int var1 = Widget.field2269.method3316(var0);
         if(var1 == 0) {
            NPC.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == Widget.widgets[var0][var2]) {
                  byte[] var3 = Widget.field2269.getConfigData(var0, var2);
                  if(null != var3) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3222(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3220(new Buffer(var3));
                     }
                  }
               }
            }

            NPC.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
