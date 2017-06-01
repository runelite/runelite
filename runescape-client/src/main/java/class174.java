import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class174 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 762828263
   )
   static int field2415;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2047729463
   )
   static int field2417;
   @ObfuscatedName("y")
   static byte[][] field2418;
   @ObfuscatedName("b")
   static byte[][] field2419;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2082910641
   )
   static int field2420;
   @ObfuscatedName("v")
   static byte[][] field2421;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1054487972"
   )
   static synchronized byte[] method3349(int var0) {
      byte[] var1;
      if(var0 == 100 && field2420 > 0) {
         var1 = field2421[--field2420];
         field2421[field2420] = null;
         return var1;
      } else if(var0 == 5000 && field2415 > 0) {
         var1 = field2419[--field2415];
         field2419[field2415] = null;
         return var1;
      } else if(var0 == 30000 && field2417 > 0) {
         var1 = field2418[--field2417];
         field2418[field2417] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   static {
      field2420 = 0;
      field2415 = 0;
      field2417 = 0;
      field2421 = new byte[1000][];
      field2419 = new byte[250][];
      field2418 = new byte[50][];
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZB)V",
      garbageValue = "21"
   )
   static void method3351(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class251.method4435(var6, var2, var3, var4);
            RSSocket.method3006(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class236.method4216(var0, var6, var4);
            }
         }
      }

   }
}
