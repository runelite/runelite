import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class175 extends class207 {
   @ObfuscatedName("e")
   public byte field2781;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -679134341
   )
   public int field2782;
   @ObfuscatedName("m")
   public class171 field2784;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1203698052"
   )
   public static void method3440(class170 var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3319(var1);
      int var6 = var0.method3368(var5, var2);
      class153.method3190(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIII)V",
      garbageValue = "-1957585048"
   )
   static final void method3441(class176 var0, int var1, int var2, int var3) {
      class178 var4 = var0.method3453(false);
      if(null != var4) {
         if(client.field506 < 3) {
            class222.field3215.method1811(var1, var2, var4.field2948, var4.field2938, 25, 25, client.field357, 256, var4.field2941, var4.field2940);
         } else {
            class82.method1892(var1, var2, 0, var4.field2941, var4.field2940);
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lclass45;",
      garbageValue = "-1473997447"
   )
   public static class45 method3442(int var0) {
      class45 var1 = (class45)class45.field1027.method3817((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class45.field1040.method3304(13, var0);
         var1 = new class45();
         var1.field1029 = var0;
         if(null != var2) {
            var1.method940(new class122(var2));
         }

         class45.field1027.method3823(var1, (long)var0);
         return var1;
      }
   }
}
