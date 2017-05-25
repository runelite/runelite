import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class149 implements class178 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1824268637
   )
   public final int field2177;
   @ObfuscatedName("cp")
   static boolean field2178;
   @ObfuscatedName("u")
   public static final class149 field2179;
   @ObfuscatedName("q")
   public static final class149 field2180;
   @ObfuscatedName("i")
   public static final class149 field2181;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -101145565
   )
   final int field2182;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 1799407197
   )
   static int field2183;
   @ObfuscatedName("h")
   public static final class149 field2186;

   static {
      field2181 = new class149(3, 0);
      field2186 = new class149(1, 1);
      field2179 = new class149(0, 2);
      field2180 = new class149(2, 3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.field2182;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Lclass254;",
      garbageValue = "47"
   )
   public static class254 method2942(int var0) {
      class254 var1 = (class254)class254.field3416.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3409.getConfigData(32, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4544(new Buffer(var2));
         }

         class254.field3416.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-652682008"
   )
   static boolean method2945(Widget var0) {
      if(Client.field1060) {
         if(class43.method626(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class149(int var1, int var2) {
      this.field2177 = var1;
      this.field2182 = var2;
   }
}
