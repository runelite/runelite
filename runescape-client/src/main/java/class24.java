import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class24 {
   @ObfuscatedName("c")
   public static final class24 field350;
   @ObfuscatedName("v")
   final String field351;
   @ObfuscatedName("e")
   public static final class24 field352;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1907369177
   )
   static int field353;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -6113973
   )
   final int field354;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -35910235
   )
   final int field355;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1109221653
   )
   final int field356;
   @ObfuscatedName("i")
   public static final class24 field357;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;III)V",
      garbageValue = "4"
   )
   class24(String var1, int var2, int var3, int var4) {
      this.field351 = var1;
      this.field354 = var2;
      this.field355 = var3;
      this.field356 = var4;
   }

   static {
      field357 = new class24("SMALL", 0, 0, 4);
      field350 = new class24("MEDIUM", 2, 1, 2);
      field352 = new class24("LARGE", 1, 2, 0);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "80"
   )
   static final byte[] method163(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 >= 0 && (IndexDataBase.field3215 == 0 || var3 <= IndexDataBase.field3215)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.readBytes(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.readInt();
            if(var4 >= 0 && (IndexDataBase.field3215 == 0 || var4 <= IndexDataBase.field3215)) {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class167.method3102(var5, var4, var0, var3, 9);
               } else {
                  IndexDataBase.field3227.method3081(var1, var5);
               }

               return var5;
            } else {
               throw new RuntimeException();
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[Lclass24;",
      garbageValue = "-309867679"
   )
   static class24[] method164() {
      return new class24[]{field350, field352, field357};
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(FB)Z",
      garbageValue = "-79"
   )
   boolean method166(float var1) {
      return var1 >= (float)this.field356;
   }
}
