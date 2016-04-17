import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("Renderable")
public abstract class class85 extends class204 {
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1359015165
   )
   @Export("modelHeight")
   public int field1465 = 1000;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1720106348"
   )
   protected class105 vmethod1999() {
      return null;
   }

   @ObfuscatedName("at")
   void vmethod2455(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class105 var10 = this.vmethod1999();
      if(null != var10) {
         this.field1465 = var10.field1465;
         var10.vmethod2455(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "4"
   )
   public static void method2004(boolean var0) {
      if(class51.field1117 != var0) {
         class4.method53();
         class51.field1117 = var0;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "0"
   )
   static String method2005(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class161.field2637[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[1 + var4] & 255;
            var3.append(class161.field2637[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[2 + var4] & 255;
               var3.append(class161.field2637[(var6 & 15) << 2 | var7 >>> 6]).append(class161.field2637[var7 & 63]);
            } else {
               var3.append(class161.field2637[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class161.field2637[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(Lclass30;III)V",
      garbageValue = "-1220836674"
   )
   static final void method2006(class30 var0, int var1, int var2) {
      class4.method56(var0.field712, var0.field711, var0.field721, var0.field720, var0.field714, var0.field714, var1, var2);
   }
}
