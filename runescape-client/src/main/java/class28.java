import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("Item")
public final class class28 extends class85 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -608800141
   )
   @Export("quantity")
   int field681;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2117377441
   )
   @Export("id")
   int field682;
   @ObfuscatedName("l")
   static class80[] field684;
   @ObfuscatedName("d")
   public static int[] field690;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)Lclass105;",
      garbageValue = "1006"
   )
   protected final class105 vmethod1968() {
      return class141.method3001(this.field682).method1112(this.field681);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-65126864"
   )
   public static void method693(int var0, int var1) {
      class47 var2 = class36.method783(var0);
      int var3 = var2.field1083;
      int var4 = var2.field1079;
      int var5 = var2.field1080;
      int var6 = class176.field2904[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class176.field2905[var3] = class176.field2905[var3] & ~var6 | var1 << var4 & var6;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Lclass44;",
      garbageValue = "13"
   )
   @Export("getKitDefinition")
   public static class44 method697(int var0) {
      class44 var1 = (class44)class44.field1047.method3797((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class44.field1051.method3286(3, var0);
         var1 = new class44();
         if(null != var2) {
            var1.method956(new class119(var2));
         }

         class44.field1047.method3788(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(III)Lclass107;",
      garbageValue = "1147565647"
   )
   static class107 method698(int var0, int var1) {
      client.field567.field1886 = var0;
      client.field567.field1881 = var1;
      client.field567.field1885 = 1;
      client.field567.field1883 = 1;
      return client.field567;
   }
}
