import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public enum class235 implements class185 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   field3217(6, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   field3214(5, 1),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   field3216(1, 2),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   field3213(7, 3),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   field3215(3, 4),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   field3212(2, 5),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   field3218(4, 6),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   field3219(0, 7);

   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -215722611
   )
   public final int field3220;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1700971285
   )
   final int field3221;

   class235(int var3, int var4) {
      this.field3220 = var3;
      this.field3221 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field3221;
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "-1901096333"
   )
   static void method4095(Buffer var0) {
      if(Client.field983 != null) {
         var0.putBytes(Client.field983, 0, Client.field983.length);
      } else {
         byte[] var2 = new byte[24];

         try {
            class156.field2151.seek(0L);
            class156.field2151.read(var2);

            int var3;
            for(var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
               ;
            }

            if(var3 >= 24) {
               throw new IOException();
            }
         } catch (Exception var6) {
            for(int var4 = 0; var4 < 24; ++var4) {
               var2[var4] = -1;
            }
         }

         var0.putBytes(var2, 0, var2.length);
      }
   }
}
