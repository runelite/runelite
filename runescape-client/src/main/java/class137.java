import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public final class class137 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1246027909
   )
   int field2054;
   @ObfuscatedName("pa")
   static class116 field2055;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1658266229
   )
   int field2056;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -306839795
   )
   int field2057;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -296669527
   )
   int field2058;
   @ObfuscatedName("y")
   boolean field2059;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1346202821
   )
   int field2060;
   @ObfuscatedName("u")
   static int[] field2061;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1807308501
   )
   int field2062;

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class137(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field2059 = true;
      this.field2062 = var1;
      this.field2058 = var2;
      this.field2056 = var3;
      this.field2057 = var4;
      this.field2054 = var5;
      this.field2060 = var6;
      this.field2059 = var7;
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1429818739"
   )
   static final boolean method2672(Widget var0) {
      if(var0.field2756 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2756.length; ++var1) {
            int var2 = IndexFile.method3012(var0, var1);
            int var3 = var0.field2678[var1];
            if(var0.field2756[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2756[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2756[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
