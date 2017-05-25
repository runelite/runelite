import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class157 {
   @ObfuscatedName("h")
   static File field2234;
   @ObfuscatedName("u")
   static Hashtable field2235;
   @ObfuscatedName("i")
   static boolean field2236;

   static {
      field2236 = false;
      field2235 = new Hashtable(16);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "49"
   )
   static int method3020(int var0, int var1) {
      Overlay var2 = class96.method1819(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.field3580 >= 0) {
         return var2.field3580 | -16777216;
      } else if(var2.texture >= 0) {
         int var3 = class166.method3133(class136.field2017.vmethod2918(var2.texture), 96);
         return class136.colorPalette[var3] | -16777216;
      } else if(var2.color == 16711935) {
         return var1;
      } else {
         int var4 = var2.hue;
         int var5 = var2.saturation;
         int var6 = var2.lightness;
         if(var6 > 179) {
            var5 /= 2;
         }

         if(var6 > 192) {
            var5 /= 2;
         }

         if(var6 > 217) {
            var5 /= 2;
         }

         if(var6 > 243) {
            var5 /= 2;
         }

         int var7 = (var4 / 4 << 10) + (var5 / 32 << 7) + var6 / 2;
         int var8 = class166.method3133(var7, 96);
         return class136.colorPalette[var8] | -16777216;
      }
   }
}
