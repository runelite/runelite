import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class31 {
   @ObfuscatedName("nr")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   static class301 field415;
   @ObfuscatedName("t")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 935254351
   )
   static int field417;
   @ObfuscatedName("h")
   static int[] field413;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -1857097095
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 710613741
   )
   final int field412;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1643357209
   )
   final int field414;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 75270309
   )
   final int field411;

   class31(int var1, int var2, int var3) {
      this.field412 = var1;
      this.field414 = var2;
      this.field411 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2005662060"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class249.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class249.NetCache_socket.vmethod3192(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class249.NetCache_socket.vmethod3186();
            } catch (Exception var3) {
               ;
            }

            ++class249.field3337;
            class249.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Lho;",
      garbageValue = "-808855025"
   )
   @Export("getWidgetChild")
   public static Widget getWidgetChild(int var0, int var1) {
      Widget var2 = class35.getWidget(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2057841909"
   )
   public static void method288(boolean var0) {
      if(var0 != class255.isMembersWorld) {
         KeyFocusListener.method759();
         class255.isMembersWorld = var0;
      }

   }
}
