import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class219 extends TaskDataNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   RSAudioPlayer field2707;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   Deque field2708;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   AudioLinkedDeque field2710;

   @ObfuscatedSignature(
      signature = "(Lht;)V"
   )
   class219(RSAudioPlayer var1) {
      this.field2708 = new Deque();
      this.field2710 = new AudioLinkedDeque();
      this.field2707 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lhq;[IIIII)V",
      garbageValue = "-635251317"
   )
   void method4043(SoundTrackMetadata var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2707.field2642[var1.field2661] & 4) != 0 && var1.field2672 < 0) {
         int var6 = this.field2707.field2634[var1.field2661] / ScriptState.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2678) / var6;
            if(var7 > var4) {
               var1.field2678 += var4 * var6;
               break;
            }

            var1.field2670.vmethod4062(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2678 += var6 * var7 - 1048576;
            int var8 = ScriptState.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            SongMetadata var10 = var1.field2670;
            if(this.field2707.field2631[var1.field2661] == 0) {
               var1.field2670 = SongMetadata.method2112(var1.field2676, var10.method2127(), var10.method2118(), var10.method2119());
            } else {
               var1.field2670 = SongMetadata.method2112(var1.field2676, var10.method2127(), 0, var10.method2119());
               this.field2707.method3855(var1, var1.field2659.field2697[var1.field2663] < 0);
               var1.field2670.method2123(var8, var10.method2118());
            }

            if(var1.field2659.field2697[var1.field2663] < 0) {
               var1.field2670.method2114(-1);
            }

            var10.method2169(var8);
            var10.vmethod4062(var2, var3, var5 - var3);
            if(var10.method2129()) {
               this.field2710.method1885(var10);
            }
         }
      }

      var1.field2670.vmethod4062(var2, var3, var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lhq;II)V",
      garbageValue = "-1864688063"
   )
   void method4047(SoundTrackMetadata var1, int var2) {
      if((this.field2707.field2642[var1.field2661] & 4) != 0 && var1.field2672 < 0) {
         int var3 = this.field2707.field2634[var1.field2661] / ScriptState.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2678) / var3;
         var1.field2678 = var3 * var2 + var1.field2678 & 1048575;
         if(var4 <= var2) {
            if(this.field2707.field2631[var1.field2661] == 0) {
               var1.field2670 = SongMetadata.method2112(var1.field2676, var1.field2670.method2127(), var1.field2670.method2118(), var1.field2670.method2119());
            } else {
               var1.field2670 = SongMetadata.method2112(var1.field2676, var1.field2670.method2127(), 0, var1.field2670.method2119());
               this.field2707.method3855(var1, var1.field2659.field2697[var1.field2663] < 0);
            }

            if(var1.field2659.field2697[var1.field2663] < 0) {
               var1.field2670.method2114(-1);
            }

            var2 = var1.field2678 / var3;
         }
      }

      var1.field2670.vmethod4046(var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldy;"
   )
   protected TaskDataNode vmethod4041() {
      SoundTrackMetadata var1 = (SoundTrackMetadata)this.field2708.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2670 != null?var1.field2670:this.vmethod4040()));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldy;"
   )
   protected TaskDataNode vmethod4040() {
      SoundTrackMetadata var1;
      do {
         var1 = (SoundTrackMetadata)this.field2708.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2670 == null);

      return var1.field2670;
   }

   @ObfuscatedName("f")
   protected int vmethod4045() {
      return 0;
   }

   @ObfuscatedName("g")
   protected void vmethod4062(int[] var1, int var2, int var3) {
      this.field2710.vmethod4062(var1, var2, var3);

      for(SoundTrackMetadata var6 = (SoundTrackMetadata)this.field2708.getFront(); var6 != null; var6 = (SoundTrackMetadata)this.field2708.getNext()) {
         if(!this.field2707.method3953(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2677) {
                  this.method4043(var6, var1, var4, var5, var4 + var5);
                  var6.field2677 -= var5;
                  break;
               }

               this.method4043(var6, var1, var4, var6.field2677, var4 + var5);
               var4 += var6.field2677;
               var5 -= var6.field2677;
            } while(!this.field2707.method3877(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("c")
   protected void vmethod4046(int var1) {
      this.field2710.vmethod4046(var1);

      for(SoundTrackMetadata var3 = (SoundTrackMetadata)this.field2708.getFront(); var3 != null; var3 = (SoundTrackMetadata)this.field2708.getNext()) {
         if(!this.field2707.method3953(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2677) {
                  this.method4047(var3, var2);
                  var3.field2677 -= var2;
                  break;
               }

               this.method4047(var3, var3.field2677);
               var2 -= var3.field2677;
            } while(!this.field2707.method3877(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "15"
   )
   static void method4044(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = ItemContainer.worldList[var6];
         ItemContainer.worldList[var6] = ItemContainer.worldList[var1];
         ItemContainer.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(PendingSpawn.method1460(ItemContainer.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = ItemContainer.worldList[var9];
               ItemContainer.worldList[var9] = ItemContainer.worldList[var7];
               ItemContainer.worldList[var7++] = var10;
            }
         }

         ItemContainer.worldList[var1] = ItemContainer.worldList[var7];
         ItemContainer.worldList[var7] = var8;
         method4044(var0, var7 - 1, var2, var3, var4, var5);
         method4044(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
