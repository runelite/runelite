import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public final class class31 extends Node {
   @ObfuscatedName("o")
   class66 field701;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1958313609
   )
   int field702;
   @ObfuscatedName("n")
   static Deque field703 = new Deque();
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1249363781
   )
   int field704;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 263856949
   )
   int field705;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 546050321
   )
   int field706;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -625798499
   )
   int field708;
   @ObfuscatedName("a")
   class66 field709;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -143365255
   )
   int field710;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 90144457
   )
   int field711;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1083865465
   )
   int field712;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -22410379
   )
   int field713;
   @ObfuscatedName("k")
   int[] field714;
   @ObfuscatedName("q")
   ObjectComposition field715;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2001664251
   )
   int field716;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1516262795"
   )
   void method707() {
      int var1 = this.field708;
      ObjectComposition var2 = this.field715.getImpostor();
      if(null != var2) {
         this.field708 = var2.ambientSoundId;
         this.field712 = var2.field2910 * 128;
         this.field710 = var2.field2907;
         this.field711 = var2.field2916;
         this.field714 = var2.field2946;
      } else {
         this.field708 = -1;
         this.field712 = 0;
         this.field710 = 0;
         this.field711 = 0;
         this.field714 = null;
      }

      if(this.field708 != var1 && this.field709 != null) {
         Client.field572.method1000(this.field709);
         this.field709 = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "8"
   )
   public static int method718(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
