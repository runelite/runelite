import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("em")
public class class149 {
   @ObfuscatedName("s")
   static File field2226;
   @ObfuscatedName("n")
   public static class228 field2227 = null;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1539977601
   )
   static int field2228;
   @ObfuscatedName("i")
   public static class228[] field2230;
   @ObfuscatedName("m")
   static class228 field2232 = null;
   @ObfuscatedName("y")
   public static class228 field2234 = null;
   @ObfuscatedName("eo")
   static class80[] field2236;
   @ObfuscatedName("p")
   static File field2237;

   @ObfuscatedName("e")
   public static class48 method3131(int var0) {
      class48 var1 = (class48)class48.field1065.method3754((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class48.field1053.method3280(8, var0);
         var1 = new class48();
         if(var2 != null) {
            var1.method984(new class119(var2));
         }

         class48.field1065.method3756(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   public static boolean method3138() {
      return class183.field2958 != 0?true:class183.field2957.method3595();
   }
}
