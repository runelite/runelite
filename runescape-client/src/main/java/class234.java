import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
public class class234 extends TaskDataNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   class230 field2770;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   Deque field2771;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   class100 field2772;

   @ObfuscatedSignature(
      signature = "(Lhl;)V"
   )
   class234(class230 var1) {
      this.field2771 = new Deque();
      this.field2772 = new class100();
      this.field2770 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lhk;[IIIII)V",
      garbageValue = "-1596323793"
   )
   void method4460(class231 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2770.field2709[var1.field2734] & 4) != 0 && var1.field2738 < 0) {
         int var6 = this.field2770.field2714[var1.field2734] / KeyFocusListener.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2744) / var6;
            if(var7 > var4) {
               var1.field2744 += var4 * var6;
               break;
            }

            var1.field2742.vmethod4435(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2744 += var6 * var7 - 1048576;
            int var8 = KeyFocusListener.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class115 var10 = var1.field2742;
            if(this.field2770.field2704[var1.field2734] == 0) {
               var1.field2742 = class115.method2465(var1.field2725, var10.method2490(), var10.method2370(), var10.method2445());
            } else {
               var1.field2742 = class115.method2465(var1.field2725, var10.method2490(), 0, var10.method2445());
               this.field2770.method4283(var1, var1.field2733.field2761[var1.field2729] < 0);
               var1.field2742.method2375(var8, var10.method2370());
            }

            if(var1.field2733.field2761[var1.field2729] < 0) {
               var1.field2742.method2366(-1);
            }

            var10.method2421(var8);
            var10.vmethod4435(var2, var3, var5 - var3);
            if(var10.method2381()) {
               this.field2772.method2103(var10);
            }
         }
      }

      var1.field2742.vmethod4435(var2, var3, var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lhk;II)V",
      garbageValue = "1969784954"
   )
   void method4455(class231 var1, int var2) {
      if((this.field2770.field2709[var1.field2734] & 4) != 0 && var1.field2738 < 0) {
         int var3 = this.field2770.field2714[var1.field2734] / KeyFocusListener.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2744) / var3;
         var1.field2744 = var3 * var2 + var1.field2744 & 1048575;
         if(var4 <= var2) {
            if(this.field2770.field2704[var1.field2734] == 0) {
               var1.field2742 = class115.method2465(var1.field2725, var1.field2742.method2490(), var1.field2742.method2370(), var1.field2742.method2445());
            } else {
               var1.field2742 = class115.method2465(var1.field2725, var1.field2742.method2490(), 0, var1.field2742.method2445());
               this.field2770.method4283(var1, var1.field2733.field2761[var1.field2729] < 0);
            }

            if(var1.field2733.field2761[var1.field2729] < 0) {
               var1.field2742.method2366(-1);
            }

            var2 = var1.field2744 / var3;
         }
      }

      var1.field2742.vmethod4436(var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "()Ldt;"
   )
   protected TaskDataNode vmethod4438() {
      class231 var1 = (class231)this.field2771.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2742 != null?var1.field2742:this.vmethod4433()));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Ldt;"
   )
   protected TaskDataNode vmethod4433() {
      class231 var1;
      do {
         var1 = (class231)this.field2771.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2742 == null);

      return var1.field2742;
   }

   @ObfuscatedName("s")
   protected int vmethod4443() {
      return 0;
   }

   @ObfuscatedName("x")
   protected void vmethod4435(int[] var1, int var2, int var3) {
      this.field2772.vmethod4435(var1, var2, var3);

      for(class231 var6 = (class231)this.field2771.getFront(); var6 != null; var6 = (class231)this.field2771.getNext()) {
         if(!this.field2770.method4340(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2743) {
                  this.method4460(var6, var1, var4, var5, var5 + var4);
                  var6.field2743 -= var5;
                  break;
               }

               this.method4460(var6, var1, var4, var6.field2743, var5 + var4);
               var4 += var6.field2743;
               var5 -= var6.field2743;
            } while(!this.field2770.method4332(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("t")
   protected void vmethod4436(int var1) {
      this.field2772.vmethod4436(var1);

      for(class231 var3 = (class231)this.field2771.getFront(); var3 != null; var3 = (class231)this.field2771.getNext()) {
         if(!this.field2770.method4340(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2743) {
                  this.method4455(var3, var2);
                  var3.field2743 -= var2;
                  break;
               }

               this.method4455(var3, var3.field2743);
               var2 -= var3.field2743;
            } while(!this.field2770.method4332(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-125"
   )
   static final void method4461(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var12 * var9 - var5 * var11 >> 16;
         var10 = var11 * var9 + var12 * var5 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var11 * var10 + var8 * var12 >> 16;
         var10 = var10 * var12 - var8 * var11 >> 16;
         var8 = var13;
      }

      Resampler.cameraX = var0 - var8;
      class49.cameraZ = var1 - var9;
      class31.cameraY = var2 - var10;
      GameCanvas.cameraPitch = var3;
      IndexDataBase.cameraYaw = var4;
      if(Client.field927 == 1 && Client.rights >= 2 && Client.gameCycle % 50 == 0 && (WorldMapType1.field443 >> 7 != TotalQuantityComparator.localPlayer.x >> 7 || class171.field2218 >> 7 != TotalQuantityComparator.localPlayer.y >> 7)) {
         var11 = TotalQuantityComparator.localPlayer.field844;
         var12 = (WorldMapType1.field443 >> 7) + WorldMapType1.baseX;
         var13 = (class171.field2218 >> 7) + Enum.baseY;
         class3.method8(var12, var13, var11, true);
      }

   }
}
