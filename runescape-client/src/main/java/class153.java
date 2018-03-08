import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class153 extends class297 {
   @ObfuscatedName("l")
   @Export("offsetsY")
   static int[] offsetsY;
   @ObfuscatedName("ch")
   @Export("middleMouseMovesCamera")
   static boolean middleMouseMovesCamera;
   @ObfuscatedName("t")
   final boolean field2112;

   public class153(boolean var1) {
      this.field2112 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;S)I",
      garbageValue = "15100"
   )
   int method3135(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2112?var1.field3842 - var2.field3842:var2.field3842 - var1.field3842):this.method5273(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3135((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "207807694"
   )
   public static boolean method3142(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1662595663"
   )
   public static int method3139() {
      return KeyFocusListener.keyboardIdleTicks;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1094569564"
   )
   public static void method3134() {
      try {
         if(class229.field2674 == 1) {
            int var0 = class229.field2673.method4198();
            if(var0 > 0 && class229.field2673.method4209()) {
               var0 -= class2.field13;
               if(var0 < 0) {
                  var0 = 0;
               }

               class229.field2673.method4220(var0);
               return;
            }

            class229.field2673.method4172();
            class229.field2673.method4238();
            if(class229.field2672 != null) {
               class229.field2674 = 2;
            } else {
               class229.field2674 = 0;
            }

            class178.field2258 = null;
            class270.field3481 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class229.field2673.method4172();
         class229.field2674 = 0;
         class178.field2258 = null;
         class270.field3481 = null;
         class229.field2672 = null;
      }

   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1558845220"
   )
   static final boolean method3144(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "25"
   )
   static void method3140(int var0, int var1) {
      class66.method1149(WorldMapDecoration.topContextMenuRow, var0, var1);
      WorldMapDecoration.topContextMenuRow = null;
   }
}
