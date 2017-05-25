import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
final class class17 implements Comparator {
   @ObfuscatedName("cf")
   static IndexData field311;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "1814902777"
   )
   int method115(class14 var1, class14 var2) {
      return var1.field286.price < var2.field286.price?-1:(var2.field286.price == var1.field286.price?0:1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   static void method119(int var0) {
      if(var0 != -1) {
         if(class14.method75(var0)) {
            Widget[] var1 = class90.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2716 != null) {
                  class69 var4 = new class69();
                  var4.field816 = var3;
                  var4.field826 = var3.field2716;
                  class48.method739(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1273165098"
   )
   static void method121() {
      if(class41.loadWorlds()) {
         class92.worldSelectShown = true;
      }

   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method115((class14)var1, (class14)var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1378071965"
   )
   public static int method124(int var0) {
      var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = (var0 >>> 4) + var0 & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1376125434"
   )
   public static void method125() {
      try {
         if(class203.field2498 == 1) {
            int var0 = class36.field501.method3755();
            if(var0 > 0 && class36.field501.method3825()) {
               var0 -= class203.field2501;
               if(var0 < 0) {
                  var0 = 0;
               }

               class36.field501.method3754(var0);
               return;
            }

            class36.field501.method3801();
            class36.field501.method3758();
            if(Varbit.field3380 != null) {
               class203.field2498 = 2;
            } else {
               class203.field2498 = 0;
            }

            class203.field2497 = null;
            Varbit.field3377 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class36.field501.method3801();
         class203.field2498 = 0;
         class203.field2497 = null;
         Varbit.field3377 = null;
         Varbit.field3380 = null;
      }

   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "167129304"
   )
   static final void method126(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class134.field1989.field1284 = !class134.field1989.field1284;
         GroundObject.method2523();
         if(class134.field1989.field1284) {
            GameObject.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            GameObject.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.field905 = !Client.field905;
      }

      if(var0.equalsIgnoreCase("clickbox")) {
         Model.field1969 = !Model.field1969;
         GameObject.sendGameMessage(99, "", "Clickbox Mode: " + (Model.field1969?"AABB":"Legacy"));
      }

      if(Client.field1057 >= 2) {
         if(var0.equalsIgnoreCase("aabb")) {
            if(!class7.field236) {
               class7.field236 = true;
               class7.field231 = class11.field263;
               GameObject.sendGameMessage(99, "", "AABB boxes: All");
            } else if(class11.field263 == class7.field231) {
               class7.field236 = true;
               class7.field231 = class11.field267;
               GameObject.sendGameMessage(99, "", "AABB boxes: Mouse Over");
            } else {
               class7.field236 = false;
               GameObject.sendGameMessage(99, "", "AABB boxes: Off");
            }
         }

         if(var0.equalsIgnoreCase("legacyboxes")) {
            class7.field228 = !class7.field228;
            GameObject.sendGameMessage(99, "", "Show legacy boxes: " + class7.field228);
         }

         if(var0.equalsIgnoreCase("geotests")) {
            class7.field230 = !class7.field230;
            GameObject.sendGameMessage(99, "", "Show geometry tests: " + class7.field230);
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.field905 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.field905 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            if(Client.field986 > 0) {
               class84.method1695();
            } else {
               class12.setGameState(40);
               class98.field1523 = XGrandExchangeOffer.rssocket;
               XGrandExchangeOffer.rssocket = null;
            }
         }

         if(var0.equalsIgnoreCase("errortest") && Client.field926 == 2) {
            throw new RuntimeException();
         }
      }

      Client.secretPacketBuffer1.putOpcode(66);
      Client.secretPacketBuffer1.putByte(var0.length() + 1);
      Client.secretPacketBuffer1.method3191(var0);
   }
}
