import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class215 extends class118 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   class211 field2669;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   Deque field2668;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   class101 field2667;

   @ObfuscatedSignature(
      signature = "(Lhj;)V"
   )
   class215(class211 var1) {
      this.field2668 = new Deque();
      this.field2667 = new class101();
      this.field2669 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lhp;[IIIIB)V",
      garbageValue = "2"
   )
   void method3928(class212 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2669.field2609[var1.field2624] & 4) != 0 && var1.field2640 < 0) {
         int var6 = this.field2669.field2614[var1.field2624] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2644) / var6;
            if(var7 > var4) {
               var1.field2644 += var4 * var6;
               break;
            }

            var1.field2642.vmethod3926(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2644 += var7 * var6 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class116 var10 = var1.field2642;
            if(this.field2669.field2612[var1.field2624] == 0) {
               var1.field2642 = class116.method2132(var1.field2626, var10.method2147(), var10.method2153(), var10.method2247());
            } else {
               var1.field2642 = class116.method2132(var1.field2626, var10.method2147(), 0, var10.method2247());
               this.field2669.method3751(var1, var1.field2625.field2661[var1.field2629] < 0);
               var1.field2642.method2264(var8, var10.method2153());
            }

            if(var1.field2625.field2661[var1.field2629] < 0) {
               var1.field2642.method2191(-1);
            }

            var10.method2170(var8);
            var10.vmethod3926(var2, var3, var5 - var3);
            if(var10.method2180()) {
               this.field2667.method1914(var10);
            }
         }
      }

      var1.field2642.vmethod3926(var2, var3, var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lhp;II)V",
      garbageValue = "1567953534"
   )
   void method3929(class212 var1, int var2) {
      if((this.field2669.field2609[var1.field2624] & 4) != 0 && var1.field2640 < 0) {
         int var3 = this.field2669.field2614[var1.field2624] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2644) / var3;
         var1.field2644 = var3 * var2 + var1.field2644 & 1048575;
         if(var4 <= var2) {
            if(this.field2669.field2612[var1.field2624] == 0) {
               var1.field2642 = class116.method2132(var1.field2626, var1.field2642.method2147(), var1.field2642.method2153(), var1.field2642.method2247());
            } else {
               var1.field2642 = class116.method2132(var1.field2626, var1.field2642.method2147(), 0, var1.field2642.method2247());
               this.field2669.method3751(var1, var1.field2625.field2661[var1.field2629] < 0);
            }

            if(var1.field2625.field2661[var1.field2629] < 0) {
               var1.field2642.method2191(-1);
            }

            var2 = var1.field2644 / var3;
         }
      }

      var1.field2642.vmethod3927(var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class118 vmethod3931() {
      class212 var1 = (class212)this.field2668.getFront();
      return (class118)(var1 == null?null:(var1.field2642 != null?var1.field2642:this.vmethod3946()));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class118 vmethod3946() {
      class212 var1;
      do {
         var1 = (class212)this.field2668.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2642 == null);

      return var1.field2642;
   }

   @ObfuscatedName("t")
   protected int vmethod3925() {
      return 0;
   }

   @ObfuscatedName("k")
   protected void vmethod3926(int[] var1, int var2, int var3) {
      this.field2667.vmethod3926(var1, var2, var3);

      for(class212 var6 = (class212)this.field2668.getFront(); var6 != null; var6 = (class212)this.field2668.getNext()) {
         if(!this.field2669.method3773(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2638) {
                  this.method3928(var6, var1, var4, var5, var5 + var4);
                  var6.field2638 -= var5;
                  break;
               }

               this.method3928(var6, var1, var4, var6.field2638, var5 + var4);
               var4 += var6.field2638;
               var5 -= var6.field2638;
            } while(!this.field2669.method3774(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("d")
   protected void vmethod3927(int var1) {
      this.field2667.vmethod3927(var1);

      for(class212 var3 = (class212)this.field2668.getFront(); var3 != null; var3 = (class212)this.field2668.getNext()) {
         if(!this.field2669.method3773(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2638) {
                  this.method3929(var3, var2);
                  var3.field2638 -= var2;
                  break;
               }

               this.method3929(var3, var3.field2638);
               var2 -= var3.field2638;
            } while(!this.field2669.method3774(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "-1862636386"
   )
   static final boolean method3924(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label68:
      while(true) {
         int var6 = var4.getUSmart();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.getUSmart();
               if(var9 == 0) {
                  continue label68;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = ClientPacket.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.lowMemory || var15.field3486 != 0 || var15.interactType == 1 || var15.field3524) {
                     if(!var15.method4547()) {
                        ++Client.field914;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.getUSmart();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }
}
