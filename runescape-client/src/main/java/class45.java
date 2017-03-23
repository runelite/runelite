import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class45 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2044718647
   )
   static int field919 = 0;
   @ObfuscatedName("c")
   static byte[] field921 = new byte[2048];
   @ObfuscatedName("w")
   static Buffer[] field923 = new Buffer[2048];
   @ObfuscatedName("u")
   static int[] field925 = new int[2048];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 591215673
   )
   static int field926 = 0;
   @ObfuscatedName("g")
   static int[] field927 = new int[2048];
   @ObfuscatedName("y")
   static int[] field928 = new int[2048];
   @ObfuscatedName("e")
   static int[] field929 = new int[2048];
   @ObfuscatedName("q")
   static int[] field930 = new int[2048];
   @ObfuscatedName("l")
   static int[] field932 = new int[2048];
   @ObfuscatedName("s")
   static Buffer field933 = new Buffer(new byte[5000]);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1898094731
   )
   static int field934 = 0;
   @ObfuscatedName("d")
   static byte[] field935 = new byte[2048];

   class45() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1280360851"
   )
   static void method910() {
      Client.secretCipherBuffer1.putOpcode(230);
      Client.secretCipherBuffer1.putByte(class13.method196());
      Client.secretCipherBuffer1.putShort(class108.field1748);
      Client.secretCipherBuffer1.putShort(class145.field2018);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1253334565"
   )
   static final void method914(boolean var0) {
      for(int var1 = 0; var1 < Client.field351; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field570[var1]];
         int var3 = 536870912 + (Client.field570[var1] << 14);
         if(var2 != null && var2.vmethod782() && var0 == var2.composition.isVisible && var2.composition.method3711()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field672 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field534 == Client.field373[var4][var5]) {
                     continue;
                  }

                  Client.field373[var4][var5] = Client.field534;
               }

               if(!var2.composition.field3035) {
                  var3 -= Integer.MIN_VALUE;
               }

               Friend.region.method1765(class31.plane, var2.x, var2.y, class1.method21(var2.field672 * 64 - 64 + var2.x, var2.y + (var2.field672 * 64 - 64), class31.plane), var2.field672 * 64 - 64 + 60, var2, var2.angle, var3, var2.field628);
            }
         }
      }

   }
}
