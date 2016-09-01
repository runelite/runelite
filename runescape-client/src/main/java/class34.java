import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class34 {
   @ObfuscatedName("l")
   static int[] field755 = new int[2048];
   @ObfuscatedName("j")
   static byte[] field757 = new byte[2048];
   @ObfuscatedName("z")
   static byte[] field758 = new byte[2048];
   @ObfuscatedName("i")
   static Buffer[] field759 = new Buffer[2048];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1139329305
   )
   static int field760 = 0;
   @ObfuscatedName("f")
   static int[] field761 = new int[2048];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -605669457
   )
   static int field762 = 0;
   @ObfuscatedName("p")
   static int[] field763 = new int[2048];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 309130739
   )
   static int field764 = 0;
   @ObfuscatedName("d")
   static int[] field765 = new int[2048];
   @ObfuscatedName("v")
   static int[] field766 = new int[2048];
   @ObfuscatedName("g")
   static Buffer field769 = new Buffer(new byte[5000]);
   @ObfuscatedName("t")
   static int[] field771 = new int[2048];

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "4"
   )
   static void method703(int var0, int var1, int var2, int var3) {
      Widget var4 = class166.method3265(var0, var1);
      if(null != var4 && null != var4.field2901) {
         class0 var5 = new class0();
         var5.field7 = var4;
         var5.field8 = var4.field2901;
         class158.method3201(var5, 200000);
      }

      Client.field436 = var3;
      Client.field404 = true;
      XClanMember.field626 = var0;
      Client.field482 = var1;
      class171.field2749 = var2;
      class75.method1606(var4);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "716609923"
   )
   static void method711(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field649[var5]) {
            var2[var4] = World.field649[var5];
            var3[var4] = World.field652[var5];
            ++var4;
         }
      }

      World.field649 = var2;
      World.field652 = var3;
      class116.method2498(class35.worldList, 0, class35.worldList.length - 1, World.field649, World.field652);
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "2113959270"
   )
   static boolean method712(Widget var0) {
      if(Client.field449) {
         if(class132.method2880(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-783686633"
   )
   public static synchronized long method713() {
      long var0 = System.currentTimeMillis();
      if(var0 < class118.field2035) {
         class118.field2032 += class118.field2035 - var0;
      }

      class118.field2035 = var0;
      return class118.field2032 + var0;
   }
}
