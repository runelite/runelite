import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public class class103 extends class204 {
   @ObfuscatedName("j")
   class88[] field1755;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 920824201
   )
   static int field1756;

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-1133350157"
   )
   static final void method2276(String var0, int var1) {
      client.field318.method2735(142);
      client.field318.method2503(class116.method2447(var0) + 1);
      client.field318.method2601(var1);
      client.field318.method2491(var0);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1948266579"
   )
   public boolean method2277(int var1) {
      return this.field1755[var1].field1528;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IS)Z",
      garbageValue = "3"
   )
   static boolean method2280(String var0, int var1) {
      return class29.method657(var0, var1, "openjs");
   }

   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IZ)V",
      garbageValue = "0"
   )
   public class103(class167 var1, class167 var2, int var3, boolean var4) {
      class199 var5 = new class199();
      int var6 = var1.method3227(var3);
      this.field1755 = new class88[var6];
      int[] var7 = var1.method3226(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3217(var3, var7[var8]);
         class102 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class102 var12 = (class102)var5.method3784(); null != var12; var12 = (class102)var5.method3777()) {
            if(var11 == var12.field1747) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13 = var2.method3223(var11, 0);
            var10 = new class102(var11, var13);
            var5.method3779(var10);
         }

         this.field1755[var7[var8]] = new class88(var9, var10);
      }

   }
}
