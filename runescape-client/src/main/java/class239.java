import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
public class class239 implements class178 {
   @ObfuscatedName("c")
   static final class239 field3271;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2060119023
   )
   final int field3272;
   @ObfuscatedName("i")
   static final class239 field3273;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 405362467
   )
   public final int field3274;
   @ObfuscatedName("e")
   static final class239 field3275;

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "-1313533942"
   )
   static void method4269(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1061 < 50 && Client.field1169 != 0) {
         if(var0.field3605 != null && var1 < var0.field3605.length) {
            int var4 = var0.field3605[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1171[Client.field1061] = var5;
               Client.field1018[Client.field1061] = var6;
               Client.field1028[Client.field1061] = 0;
               Client.field1008[Client.field1061] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field956[Client.field1061] = (var9 << 8) + (var8 << 16) + var7;
               ++Client.field1061;
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int vmethod5009() {
      return this.field3272;
   }

   static {
      field3273 = new class239(0, 0);
      field3271 = new class239(2, 1);
      field3275 = new class239(1, 2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-498017117"
   )
   public static int method4271(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class239(int var1, int var2) {
      this.field3274 = var1;
      this.field3272 = var2;
   }
}
