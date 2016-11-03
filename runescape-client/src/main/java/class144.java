import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class144 extends class136 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1789483981
   )
   int field2212 = 1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -926324063
   )
   int field2213 = 256;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1604983185
   )
   int field2214;
   @ObfuscatedName("k")
   long[] field2215 = new long[10];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 765576343
   )
   int field2216 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -3525118699899993857L
   )
   long field2217 = class169.method3276();
   @ObfuscatedName("ps")
   static class163 field2218;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-355225866"
   )
   void vmethod3139() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2215[var1] = 0L;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1507060313"
   )
   int vmethod3137(int var1, int var2) {
      int var3 = this.field2213;
      int var4 = this.field2212;
      this.field2213 = 300;
      this.field2212 = 1;
      this.field2217 = class169.method3276();
      if(this.field2215[this.field2214] == 0L) {
         this.field2213 = var3;
         this.field2212 = var4;
      } else if(this.field2217 > this.field2215[this.field2214]) {
         this.field2213 = (int)((long)(var1 * 2560) / (this.field2217 - this.field2215[this.field2214]));
      }

      if(this.field2213 < 25) {
         this.field2213 = 25;
      }

      if(this.field2213 > 256) {
         this.field2213 = 256;
         this.field2212 = (int)((long)var1 - (this.field2217 - this.field2215[this.field2214]) / 10L);
      }

      if(this.field2212 > var1) {
         this.field2212 = var1;
      }

      this.field2215[this.field2214] = this.field2217;
      this.field2214 = (this.field2214 + 1) % 10;
      int var5;
      if(this.field2212 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2215[var5]) {
               this.field2215[var5] += (long)this.field2212;
            }
         }
      }

      if(this.field2212 < var2) {
         this.field2212 = var2;
      }

      class127.method2846((long)this.field2212);

      for(var5 = 0; this.field2216 < 256; this.field2216 += this.field2213) {
         ++var5;
      }

      this.field2216 &= 255;
      return var5;
   }

   class144() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2215[var1] = this.field2217;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-1228509460"
   )
   public static String method3011(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class168.field2705[var6 - 128];
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-1885903937"
   )
   public static Widget method3012(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(null == Widget.widgets[var1] || null == Widget.widgets[var1][var2]) {
         boolean var3 = class85.method1938(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-33"
   )
   static String method3013(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "147309936"
   )
   static void method3014() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "1"
   )
   static final String method3015(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + method3013('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + method3013(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + method3013(16776960) + var1 + "</col>");
   }
}
