import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("MessageNode")
public class class37 extends class207 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 676138825
   )
   @Export("type")
   int field805;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 420119609
   )
   @Export("tick")
   int field806;
   @ObfuscatedName("s")
   @Export("value")
   String field807;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1163282247
   )
   @Export("id")
   int field808 = class18.method213();
   @ObfuscatedName("p")
   static int[] field809;
   @ObfuscatedName("e")
   @Export("name")
   String field810;
   @ObfuscatedName("h")
   @Export("sender")
   String field813;
   @ObfuscatedName("m")
   public static boolean field814;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -305526007
   )
   static int field817;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "10"
   )
   void method780(int var1, String var2, String var3, String var4) {
      this.field808 = class18.method213();
      this.field806 = client.field305;
      this.field805 = var1;
      this.field810 = var2;
      this.field813 = var3;
      this.field807 = var4;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "736617135"
   )
   static void method781(String var0, String var1, String var2) {
      class33.field748 = var0;
      class33.field762 = var1;
      class33.field755 = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "110"
   )
   static int method784(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ class122.field2057[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   class37(int var1, String var2, String var3, String var4) {
      this.field806 = client.field305;
      this.field805 = var1;
      this.field810 = var2;
      this.field813 = var3;
      this.field807 = var4;
   }
}
