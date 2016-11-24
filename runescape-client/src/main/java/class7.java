import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class7 implements Comparator {
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = -1226832285
   )
   static int field60;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 1657407241
   )
   protected static int field63;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -1906301599
   )
   static int field65;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "-3"
   )
   int method93(class2 var1, class2 var2) {
      return var1.field15 < var2.field15?-1:(var2.field15 == var1.field15?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method93((class2)var1, (class2)var2);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-127"
   )
   static final void method94(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         Tile.field1343.field691 = !Tile.field1343.field691;
         class3.method42();
         if(Tile.field1343.field691) {
            class10.method120(99, "", "Roofs are now all hidden");
         } else {
            class10.method120(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.field563 = !Client.field563;
      }

      if(Client.field503 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            Client.field563 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.field563 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            if(Client.field405 > 0) {
               GameEngine.method2223();
            } else {
               class186.setGameState(40);
               WidgetNode.field176 = FileOnDisk.field1183;
               FileOnDisk.field1183 = null;
            }
         }

         if(var0.equalsIgnoreCase("errortest") && Client.field443 == 2) {
            throw new RuntimeException();
         }
      }

      Client.field330.method3234(146);
      Client.field330.method2975(var0.length() + 1);
      Client.field330.method2981(var0);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "539135187"
   )
   public static void method102(boolean var0) {
      if(class185.field2761 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2975(var0?2:3);
            var1.method2977(0);
            class185.field2761.method2107(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class185.field2761.method2121();
            } catch (Exception var3) {
               ;
            }

            ++class185.field2763;
            class185.field2761 = null;
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1886668828"
   )
   static void method103(int var0) {
      if(var0 != -1) {
         if(class60.method1127(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2163 != null) {
                  class18 var4 = new class18();
                  var4.field192 = var3;
                  var4.field196 = var3.field2163;
                  class164.method3225(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1966768906"
   )
   static void method104(int var0, int var1) {
      Client.field330.method3234(127);
      Client.field330.method3022(var1);
      Client.field330.method3034(var0);
   }
}
