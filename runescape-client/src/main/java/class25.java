import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class25 {
   @ObfuscatedName("mt")
   @ObfuscatedSignature(
      signature = "[Lhl;"
   )
   static Widget[] field226;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   static final class25 field227;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   static final class25 field233;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -256235113
   )
   static int field231;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -944658495
   )
   final int field228;

   static {
      field227 = new class25(0);
      field233 = new class25(1);
   }

   class25(int var1) {
      this.field228 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)[Lfq;",
      garbageValue = "-1170126190"
   )
   static LoginPacket[] method466() {
      return new LoginPacket[]{LoginPacket.field2259, LoginPacket.field2260, LoginPacket.field2261, LoginPacket.field2258};
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "2065007798"
   )
   static int method464(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class184.field2379:FriendManager.field996;
      if(var0 == 1700) {
         class69.intStack[++class45.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class69.intStack[++class45.intStackSize - 1] = var3.itemQuantity;
         } else {
            class69.intStack[++class45.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class69.intStack[++class45.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-2"
   )
   static final void method465(int var0) {
      if(GameCanvas.loadWidget(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2746 = 0;
               var3.field2718 = 0;
            }
         }

      }
   }
}
