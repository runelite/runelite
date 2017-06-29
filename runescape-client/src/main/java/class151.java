import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class151 extends class158 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1338212991
   )
   int field2222;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 425198859
   )
   static int field2223;
   @ObfuscatedName("i")
   long[] field2224;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -328335958128952751L
   )
   long field2225;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1293963245
   )
   int field2226;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1935282031
   )
   int field2227;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -391261729
   )
   int field2228;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-85"
   )
   public void vmethod2965() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2224[var1] = 0L;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-70"
   )
   public int vmethod2964(int var1, int var2) {
      int var3 = this.field2226;
      int var4 = this.field2222;
      this.field2226 = 300;
      this.field2222 = 1;
      this.field2225 = class172.method3128();
      if(0L == this.field2224[this.field2227]) {
         this.field2226 = var3;
         this.field2222 = var4;
      } else if(this.field2225 > this.field2224[this.field2227]) {
         this.field2226 = (int)((long)(var1 * 2560) / (this.field2225 - this.field2224[this.field2227]));
      }

      if(this.field2226 < 25) {
         this.field2226 = 25;
      }

      if(this.field2226 > 256) {
         this.field2226 = 256;
         this.field2222 = (int)((long)var1 - (this.field2225 - this.field2224[this.field2227]) / 10L);
      }

      if(this.field2222 > var1) {
         this.field2222 = var1;
      }

      this.field2224[this.field2227] = this.field2225;
      this.field2227 = (this.field2227 + 1) % 10;
      int var5;
      if(this.field2222 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2224[var5]) {
               this.field2224[var5] += (long)this.field2222;
            }
         }
      }

      if(this.field2222 < var2) {
         this.field2222 = var2;
      }

      XItemContainer.method1113((long)this.field2222);

      for(var5 = 0; this.field2228 < 256; this.field2228 += this.field2226) {
         ++var5;
      }

      this.field2228 &= 255;
      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;S)V",
      garbageValue = "6282"
   )
   public static void method2912(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   public class151() {
      this.field2224 = new long[10];
      this.field2226 = 256;
      this.field2222 = 1;
      this.field2228 = 0;
      this.field2225 = class172.method3128();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2224[var1] = this.field2225;
      }

   }
}
