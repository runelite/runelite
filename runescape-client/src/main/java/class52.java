import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class52 extends class204 {
   @ObfuscatedName("m")
   public static class193 field1141 = new class193(64);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1876791943
   )
   public static int field1142;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 2102026897
   )
   static int field1143;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -639771719
   )
   public int field1144 = 0;
   @ObfuscatedName("e")
   static int[] field1145;
   @ObfuscatedName("j")
   public static class167 field1149;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "2053967747"
   )
   void method1071(class119 var1) {
      while(true) {
         int var2 = var1.method2500();
         if(0 == var2) {
            return;
         }

         this.method1078(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1853396730"
   )
   void method1078(class119 var1, int var2) {
      if(5 == var2) {
         this.field1144 = var1.method2502();
      }

   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-85"
   )
   static final void method1079(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class107.method2374(var0)) {
         class28.field665 = null;
         class33.method707(class173.field2735[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(null != class28.field665) {
            class33.method707(class28.field665, -1412584499, var1, var2, var3, var4, class10.field160, class77.field1377, var7);
            class28.field665 = null;
         }

      } else {
         if(var7 != -1) {
            client.field478[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field478[var8] = true;
            }
         }

      }
   }
}
