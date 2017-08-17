import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public final class class10 extends class9 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -845440721
   )
   final int field256;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -727931811
   )
   final int field255;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -974872513
   )
   final int field253;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1018888399
   )
   final int field257;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -688745201
   )
   final int field254;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -307958691
   )
   final int field259;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -925514625
   )
   final int field258;

   @ObfuscatedSignature(
      signature = "(Leo;IIII)V"
   )
   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field256 = var2 + var1.field1969 - var1.field1942;
      this.field253 = var3 + var1.field1959 - var1.field1962;
      this.field254 = var4 + var1.field1987 - var1.field1983;
      this.field255 = var2 + var1.field1942 + var1.field1969;
      this.field257 = var3 + var1.field1959 + var1.field1962;
      this.field259 = var4 + var1.field1983 + var1.field1987;
      this.field258 = var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1383927671"
   )
   final void vmethod47() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field256:this.field255;
         int var2 = (var4 & 2) == 0?this.field253:this.field257;
         int var3 = (var4 & 4) == 0?this.field254:this.field259;
         if((var4 & 1) == 0) {
            class19.method164(var1, var2, var3, this.field255, var2, var3, this.field258);
         }

         if((var4 & 2) == 0) {
            class19.method164(var1, var2, var3, var1, this.field257, var3, this.field258);
         }

         if((var4 & 4) == 0) {
            class19.method164(var1, var2, var3, var1, var2, this.field259, this.field258);
         }
      }

   }

   @ObfuscatedName("j")
   public static final void method51(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var8) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(Lcr;I)V",
      garbageValue = "-1923090662"
   )
   static final void method46(Actor var0) {
      if(var0.field1265 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1267 + 1 > PendingSpawn.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field1265 - var0.field1264;
         int var2 = Client.gameCycle - var0.field1264;
         int var3 = var0.field1219 * 64 + var0.field1260 * 128;
         int var4 = var0.field1262 * 128 + var0.field1219 * 64;
         int var5 = var0.field1219 * 64 + var0.field1271 * 128;
         int var6 = var0.field1263 * 128 + var0.field1219 * 64;
         var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
         var0.y = (var2 * var6 + var4 * (var1 - var2)) / var1;
      }

      var0.field1276 = 0;
      var0.orientation = var0.field1266;
      var0.angle = var0.orientation;
   }
}
