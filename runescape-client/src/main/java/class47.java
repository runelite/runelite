import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class47 {
   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field564;
   @ObfuscatedName("az")
   protected static String field567;
   @ObfuscatedName("m")
   static int[] field566;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1088218201
   )
   public int field568;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public Coordinates field565;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public Coordinates field569;

   @ObfuscatedSignature(
      signature = "(ILhy;Lhy;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field568 = var1;
      this.field565 = var2;
      this.field569 = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lig;",
      garbageValue = "890939420"
   )
   public static class244 method710(int var0) {
      class244 var1 = (class244)class244.field3303.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class270.field3668.getConfigData(15, var0);
         var1 = new class244();
         if(var2 != null) {
            var1.method4300(new Buffer(var2));
         }

         class244.field3303.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
      garbageValue = "1095664410"
   )
   static final void method711(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            Client.field1013[Client.menuOptionCount] = var6;
            ++Client.menuOptionCount;
         }

      }
   }
}
