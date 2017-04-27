import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public abstract class class109 {
   @ObfuscatedName("bu")
   static ModIcon[] field1735;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1755590105
   )
   static int field1736;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-86"
   )
   public abstract void vmethod2062();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "29"
   )
   abstract int vmethod2063(int var1, int var2);

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "19065"
   )
   static void method2065(int var0) {
      Client.field487 = new class38();
      Client.field487.field788 = Client.menuActionParams0[var0];
      Client.field487.field786 = Client.menuActionParams1[var0];
      Client.field487.field785 = Client.menuTypes[var0];
      Client.field487.field787 = Client.menuIdentifiers[var0];
      Client.field487.field784 = Client.menuOptions[var0];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIIS)Ljava/lang/String;",
      garbageValue = "-23220"
   )
   public static String method2067(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class210.field3134[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Lclass220;",
      garbageValue = "-994155115"
   )
   static class220[] method2068() {
      return new class220[]{class220.field3202, class220.field3200, class220.field3199};
   }
}
