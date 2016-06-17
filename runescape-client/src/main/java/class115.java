import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class115 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 4157140997523458881L
   )
   static long field1952;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -4287043515574911975L
   )
   static long field1956;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "18"
   )
   static final void method2453(class122 var0) {
      var0.method2792();
      int var1 = client.field430;
      class2 var2 = class153.field2262 = client.field410[var1] = new class2();
      var2.field48 = var1;
      int var3 = var0.method2784(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field844[0] = var5 - class4.field62;
      var2.field813 = (var2.field844[0] << 7) + (var2.method14() << 6);
      var2.field831[0] = var6 - class85.field1434;
      var2.field791 = (var2.field831[0] << 7) + (var2.method14() << 6);
      class144.field2193 = var2.field47 = var4;
      if(class32.field737[var1] != null) {
         var2.method13(class32.field737[var1]);
      }

      class32.field738 = 0;
      class32.field739[++class32.field738 - 1] = var1;
      class32.field748[var1] = 0;
      class32.field735 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2784(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class32.field741[var7] = (var9 << 28) + (var10 << 14) + var11;
            class32.field743[var7] = 0;
            class32.field744[var7] = -1;
            class32.field734[++class32.field735 - 1] = var7;
            class32.field748[var7] = 0;
         }
      }

      var0.method2785();
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-588921135"
   )
   static final void method2454() {
      client.field331.method2781(102);

      for(class3 var0 = (class3)client.field448.method3799(); null != var0; var0 = (class3)client.field448.method3800()) {
         if(var0.field54 == 0 || var0.field54 == 3) {
            class139.method2971(var0, true);
         }
      }

      if(client.field451 != null) {
         class4.method37(client.field451);
         client.field451 = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-12330"
   )
   static int method2455(int var0) {
      class35 var1 = (class35)class11.field169.method3808((long)var0);
      return null == var1?-1:(var1.field3104 == class11.field164.field3099?-1:((class35)var1.field3104).field769);
   }
}
