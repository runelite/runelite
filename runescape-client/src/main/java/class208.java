import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class208 extends class117 {
   @ObfuscatedName("g")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("v")
   @Export("spritePixels")
   public static byte[][] spritePixels;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   static SpritePixels field2603;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   class100 field2606;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   class204 field2600;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Deque field2601;

   @ObfuscatedSignature(
      signature = "(Lgy;)V"
   )
   class208(class204 var1) {
      this.field2601 = new Deque();
      this.field2606 = new class100();
      this.field2600 = var1;
   }

   @ObfuscatedName("v")
   protected void vmethod4004(int[] var1, int var2, int var3) {
      this.field2606.vmethod4004(var1, var2, var3);

      for(class205 var6 = (class205)this.field2601.getFront(); var6 != null; var6 = (class205)this.field2601.getNext()) {
         if(!this.field2600.method3831(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2575) {
                  this.method4000(var6, var1, var4, var5, var5 + var4);
                  var6.field2575 -= var5;
                  break;
               }

               this.method4000(var6, var1, var4, var6.field2575, var4 + var5);
               var4 += var6.field2575;
               var5 -= var6.field2575;
            } while(!this.field2600.method3832(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("y")
   protected void vmethod4023(int var1) {
      this.field2606.vmethod4023(var1);

      for(class205 var3 = (class205)this.field2601.getFront(); var3 != null; var3 = (class205)this.field2601.getNext()) {
         if(!this.field2600.method3831(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2575) {
                  this.method4027(var3, var2);
                  var3.field2575 -= var2;
                  break;
               }

               this.method4027(var3, var3.field2575);
               var2 -= var3.field2575;
            } while(!this.field2600.method3832(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected class117 vmethod4002() {
      class205 var1;
      do {
         var1 = (class205)this.field2601.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2570 == null);

      return var1.field2570;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgi;II)V",
      garbageValue = "-524975684"
   )
   void method4027(class205 var1, int var2) {
      if((this.field2600.field2539[var1.field2563] & 4) != 0 && var1.field2571 < 0) {
         int var3 = this.field2600.field2544[var1.field2563] / class31.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2577) / var3;
         var1.field2577 = var1.field2577 + var3 * var2 & 1048575;
         if(var4 <= var2) {
            if(this.field2600.field2540[var1.field2563] == 0) {
               var1.field2570 = class115.method2352(var1.field2559, var1.field2570.method2248(), var1.field2570.method2350(), var1.field2570.method2251());
            } else {
               var1.field2570 = class115.method2352(var1.field2559, var1.field2570.method2248(), 0, var1.field2570.method2251());
               this.field2600.method3809(var1, var1.field2558.field2594[var1.field2574] < 0);
            }

            if(var1.field2558.field2594[var1.field2574] < 0) {
               var1.field2570.method2346(-1);
            }

            var2 = var1.field2577 / var3;
         }
      }

      var1.field2570.vmethod4023(var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgi;[IIIIB)V",
      garbageValue = "123"
   )
   void method4000(class205 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2600.field2539[var1.field2563] & 4) != 0 && var1.field2571 < 0) {
         int var6 = this.field2600.field2544[var1.field2563] / class31.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2577) / var6;
            if(var7 > var4) {
               var1.field2577 += var4 * var6;
               break;
            }

            var1.field2570.vmethod4004(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2577 += var7 * var6 - 1048576;
            int var8 = class31.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class115 var10 = var1.field2570;
            if(this.field2600.field2540[var1.field2563] == 0) {
               var1.field2570 = class115.method2352(var1.field2559, var10.method2248(), var10.method2350(), var10.method2251());
            } else {
               var1.field2570 = class115.method2352(var1.field2559, var10.method2248(), 0, var10.method2251());
               this.field2600.method3809(var1, var1.field2558.field2594[var1.field2574] < 0);
               var1.field2570.method2213(var8, var10.method2350());
            }

            if(var1.field2558.field2594[var1.field2574] < 0) {
               var1.field2570.method2346(-1);
            }

            var10.method2198(var8);
            var10.vmethod4004(var2, var3, var5 - var3);
            if(var10.method2340()) {
               this.field2606.method1979(var10);
            }
         }
      }

      var1.field2570.vmethod4004(var2, var3, var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected class117 vmethod4025() {
      class205 var1 = (class205)this.field2601.getFront();
      return (class117)(var1 == null?null:(var1.field2570 != null?var1.field2570:this.vmethod4002()));
   }

   @ObfuscatedName("g")
   protected int vmethod4007() {
      return 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;B)V",
      garbageValue = "-1"
   )
   public static void method4010(IndexDataBase var0) {
      class252.field3397 = var0;
   }
}
