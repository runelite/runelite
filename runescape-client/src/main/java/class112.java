import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public abstract class class112 {
   @ObfuscatedName("a")
   static Buffer field1766;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1384964371
   )
   static int field1767;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "25104"
   )
   public abstract int vmethod2133();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-141877539"
   )
   public abstract void vmethod2134(Component var1);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "605815837"
   )
   public abstract void vmethod2135(Component var1);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1381092403"
   )
   public static int method2145(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "1251470557"
   )
   static final String method2146(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class13.method182(16711680):(var2 < -6?class13.method182(16723968):(var2 < -3?class13.method182(16740352):(var2 < 0?class13.method182(16756736):(var2 > 9?class13.method182('\uff00'):(var2 > 6?class13.method182(4259584):(var2 > 3?class13.method182(8453888):(var2 > 0?class13.method182(12648192):class13.method182(16776960))))))));
   }
}
