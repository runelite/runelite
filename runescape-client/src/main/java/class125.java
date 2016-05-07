import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public abstract class class125 {
   @ObfuscatedName("at")
   static class146 field2050;
   @ObfuscatedName("j")
   static boolean field2051 = false;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1305570300"
   )
   @Export("sendGameMessage")
   static void method2783(int var0, String var1, String var2) {
      class52.method1050(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1354385809"
   )
   abstract void vmethod2785(byte[] var1);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1672873160"
   )
   abstract byte[] vmethod2795();

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "([Lclass173;Lclass173;ZI)V",
      garbageValue = "-1770413234"
   )
   static void method2796(class173[] var0, class173 var1, boolean var2) {
      int var3 = var1.field2848 != 0?var1.field2848:var1.field2886;
      int var4 = var1.field2858 != 0?var1.field2858:var1.field2781;
      class191.method3737(var0, var1.field2826, var3, var4, var2);
      if(var1.field2847 != null) {
         class191.method3737(var1.field2847, var1.field2826, var3, var4, var2);
      }

      class3 var5 = (class3)client.field308.method3777((long)var1.field2826);
      if(var5 != null) {
         int var6 = var5.field69;
         if(class188.method3731(var6)) {
            class191.method3737(class217.field3171[var6], -1, var3, var4, var2);
         }
      }

      if(var1.field2887 == 1337) {
         ;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-7"
   )
   public static int method2797(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }
}
