import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class186 extends CacheableNode {
   @ObfuscatedName("f")
   static IndexDataBase field2783;
   @ObfuscatedName("i")
   static NodeCache field2784 = new NodeCache(64);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2008732671
   )
   public int field2785 = 0;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-349523322"
   )
   void method3474(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2785 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "9005"
   )
   void method3478(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3474(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "-303716585"
   )
   public static int method3481(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }
}
