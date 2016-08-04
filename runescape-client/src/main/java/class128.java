import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public abstract class class128 {
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -829227851
   )
   protected static int field2089;
   @ObfuscatedName("g")
   static boolean field2090 = false;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1831239624"
   )
   abstract byte[] vmethod2938();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-553316118"
   )
   public static void method2939() {
      try {
         class152.field2296.method4292();

         for(int var0 = 0; var0 < class152.field2298; ++var0) {
            class8.field152[var0].method4292();
         }

         class152.field2297.method4292();
         class152.field2301.method4292();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1484954424"
   )
   abstract void vmethod2940(byte[] var1);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[Lclass155;",
      garbageValue = "1888545501"
   )
   public static class155[] method2954() {
      return new class155[]{class155.field2322, class155.field2326, class155.field2323, class155.field2324, class155.field2328};
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass176;III)V",
      garbageValue = "-1497996566"
   )
   static final void method2955(class176 var0, int var1, int var2) {
      if(client.field530 == 0 || client.field530 == 3) {
         if(class143.field2217 == 1 || !class214.field3188 && class143.field2217 == 4) {
            class178 var3 = var0.method3557(true);
            if(null == var3) {
               return;
            }

            int var4 = class143.field2215 - var1;
            int var5 = class143.field2216 - var2;
            if(var3.method3599(var4, var5)) {
               var4 -= var3.field2953 / 2;
               var5 -= var3.field2950 / 2;
               int var6 = client.field365 + client.field399 & 2047;
               int var7 = class94.field1661[var6];
               int var8 = class94.field1662[var6];
               var7 = var7 * (client.field367 + 256) >> 8;
               var8 = var8 * (client.field367 + 256) >> 8;
               int var9 = var8 * var4 + var5 * var7 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = var9 + class3.field65.field875 >> 7;
               int var12 = class3.field65.field832 - var10 >> 7;
               client.field337.method2903(53);
               client.field337.method2783(18);
               client.field337.method2619(class21.field592 + var12);
               client.field337.method2668(class0.field11 + var11);
               client.field337.method2783(class140.field2171[82]?(class140.field2171[81]?2:1):0);
               client.field337.method2783(var4);
               client.field337.method2783(var5);
               client.field337.method2619(client.field399);
               client.field337.method2783(57);
               client.field337.method2783(client.field365);
               client.field337.method2783(client.field367);
               client.field337.method2783(89);
               client.field337.method2619(class3.field65.field875);
               client.field337.method2619(class3.field65.field832);
               client.field337.method2783(63);
               client.field371 = var11;
               client.field529 = var12;
            }
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "86"
   )
   public static boolean method2956(int var0) {
      return (var0 & 1) != 0;
   }
}
