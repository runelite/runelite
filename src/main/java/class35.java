import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ay")
@Implements("MessageNode")
public class class35 extends class204 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 734728103
   )
   int field759;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1573990479
   )
   int field760;
   @ObfuscatedName("s")
   String field761;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 669339457
   )
   public static int field762;
   @ObfuscatedName("h")
   @Export("value")
   String field763;
   @ObfuscatedName("u")
   static String field765;
   @ObfuscatedName("p")
   @Export("sender")
   String field767;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -452434233
   )
   @Export("type")
   int field768;

   @ObfuscatedName("e")
   void method728(int var1, String var2, String var3, String var4) {
      this.field760 = class10.method135();
      this.field759 = client.field289;
      this.field768 = var1;
      this.field761 = var2;
      this.field767 = var3;
      this.field763 = var4;
   }

   class35(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field170 - 1;
      this.field760 = var5;
      this.field759 = client.field289;
      this.field768 = var1;
      this.field761 = var2;
      this.field767 = var3;
      this.field763 = var4;
   }

   @ObfuscatedName("bg")
   static class107 method730(int var0, int var1) {
      client.field310.field1864 = var0;
      client.field310.field1853 = var1;
      client.field310.field1855 = 1;
      client.field310.field1862 = 1;
      return client.field310;
   }

   @ObfuscatedName("e")
   public static class112 method731(class112[] var0, int var1) {
      class112[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class112 var4 = var2[var3];
         if(var1 == var4.vmethod3172()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("w")
   public static class52 method732(int var0) {
      class52 var1 = (class52)class52.field1135.method3754((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class52.field1134.method3280(16, var0);
         var1 = new class52();
         if(var2 != null) {
            var1.method1064(new class119(var2));
         }

         class52.field1135.method3756(var1, (long)var0);
         return var1;
      }
   }
}
