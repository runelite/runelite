import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class224 {
   @ObfuscatedName("ad")
   static int[] field2854;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lij;IIIBZB)V",
      garbageValue = "-62"
   )
   static void method4193(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class238.field3251.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class238.field3256.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class238.field3259.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class238.field3251.put(var8, var6);
                  --class238.field3254;
                  ++class238.field3255;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class238.field3261.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class238.field3251.put(var8, var6);
                  ++class238.field3255;
               } else {
                  class238.field3258.push(var8);
                  class238.field3259.put(var8, var6);
                  ++class238.field3254;
               }

            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "-881647233"
   )
   public static boolean method4196(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label83: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label83;
               }

               if(var7 == 43) {
                  break label83;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var4 * 10 + var9;
            if(var4 != var8 / 10) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }
}
