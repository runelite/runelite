import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class138 {
   @ObfuscatedName("z")
   static File field2124;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -610743905
   )
   public static int field2126;
   @ObfuscatedName("t")
   static Hashtable field2130 = new Hashtable(16);
   @ObfuscatedName("s")
   static boolean field2132 = false;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Lclass52;",
      garbageValue = "-104"
   )
   public static class52 method2869(int var0) {
      class52 var1 = (class52)class52.field1103.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class222.field3215.method3272(8, var0);
         var1 = new class52();
         if(var2 != null) {
            var1.method1034(new Buffer(var2));
         }

         class52.field1103.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "413367269"
   )
   public static void method2872(Buffer var0, int var1) {
      if(null != class152.field2276) {
         try {
            class152.field2276.method4142(0L);
            class152.field2276.method4147(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }
}
