import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class181 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2121256601
   )
   static int field2500;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1642021861
   )
   static int field2499;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 669589245
   )
   static int field2498;
   @ObfuscatedName("g")
   static byte[][] field2501;
   @ObfuscatedName("x")
   static byte[][] field2502;
   @ObfuscatedName("f")
   static byte[][] field2503;
   @ObfuscatedName("t")
   public static int[] field2504;

   static {
      field2500 = 0;
      field2499 = 0;
      field2498 = 0;
      field2501 = new byte[1000][];
      field2502 = new byte[250][];
      field2503 = new byte[50][];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IZI)[B",
      garbageValue = "2068517718"
   )
   static synchronized byte[] method3406(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2500 > 0) {
         var2 = field2501[--field2500];
         field2501[field2500] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2499 > 0) {
         var2 = field2502[--field2499];
         field2502[field2499] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2498 > 0) {
         var2 = field2503[--field2498];
         field2503[field2498] = null;
         return var2;
      }

      if(class90.field1323 != null) {
         for(int var4 = 0; var4 < FrameMap.field1954.length; ++var4) {
            if(FrameMap.field1954[var4] != var0) {
               if(var0 < FrameMap.field1954[var4]) {
                  ;
               }
            } else if(field2504[var4] > 0) {
               byte[] var3 = class90.field1323[var4][--field2504[var4]];
               class90.field1323[var4][field2504[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(Lhx;I)V",
      garbageValue = "-2079441784"
   )
   static final void method3415(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1089 == -1) {
            Client.field1089 = var0.spriteId;
            Client.field874 = var0.field2749;
         }

         if(Client.field1119.isFemale) {
            var0.spriteId = Client.field1089;
         } else {
            var0.spriteId = Client.field874;
         }

      } else if(var1 == 325) {
         if(Client.field1089 == -1) {
            Client.field1089 = var0.spriteId;
            Client.field874 = var0.field2749;
         }

         if(Client.field1119.isFemale) {
            var0.spriteId = Client.field874;
         } else {
            var0.spriteId = Client.field1089;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
