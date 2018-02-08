import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class class219 extends TaskDataNode {
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = 1721164447
   )
   static int field2699;
   @ObfuscatedName("h")
   public static int[] field2698;
   @ObfuscatedName("i")
   @Export("IndexStoreActionHandler_thread")
   static Thread IndexStoreActionHandler_thread;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   class215 field2694;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   Deque field2696;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   class101 field2695;

   @ObfuscatedSignature(
      signature = "(Lhw;)V"
   )
   class219(class215 var1) {
      this.field2696 = new Deque();
      this.field2695 = new class101();
      this.field2694 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lhh;[IIIII)V",
      garbageValue = "637905562"
   )
   void method4329(class216 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2694.field2627[var1.field2649] & 4) != 0 && var1.field2662 < 0) {
         int var6 = this.field2694.field2638[var1.field2649] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2668) / var6;
            if(var7 > var4) {
               var1.field2668 += var6 * var4;
               break;
            }

            var1.field2667.vmethod4314(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2668 += var7 * var6 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class116 var10 = var1.field2667;
            if(this.field2694.field2636[var1.field2649] == 0) {
               var1.field2667 = class116.method2385(var1.field2659, var10.method2400(), var10.method2391(), var10.method2399());
            } else {
               var1.field2667 = class116.method2385(var1.field2659, var10.method2400(), 0, var10.method2399());
               this.field2694.method4144(var1, var1.field2655.field2686[var1.field2653] < 0);
               var1.field2667.method2396(var8, var10.method2391());
            }

            if(var1.field2655.field2686[var1.field2653] < 0) {
               var1.field2667.method2387(-1);
            }

            var10.method2493(var8);
            var10.vmethod4314(var2, var3, var5 - var3);
            if(var10.method2539()) {
               this.field2695.method2129(var10);
            }
         }
      }

      var1.field2667.vmethod4314(var2, var3, var4);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lhh;IB)V",
      garbageValue = "-107"
   )
   void method4317(class216 var1, int var2) {
      if((this.field2694.field2627[var1.field2649] & 4) != 0 && var1.field2662 < 0) {
         int var3 = this.field2694.field2638[var1.field2649] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2668) / var3;
         var1.field2668 = var3 * var2 + var1.field2668 & 1048575;
         if(var4 <= var2) {
            if(this.field2694.field2636[var1.field2649] == 0) {
               var1.field2667 = class116.method2385(var1.field2659, var1.field2667.method2400(), var1.field2667.method2391(), var1.field2667.method2399());
            } else {
               var1.field2667 = class116.method2385(var1.field2659, var1.field2667.method2400(), 0, var1.field2667.method2399());
               this.field2694.method4144(var1, var1.field2655.field2686[var1.field2653] < 0);
            }

            if(var1.field2655.field2686[var1.field2653] < 0) {
               var1.field2667.method2387(-1);
            }

            var2 = var1.field2668 / var3;
         }
      }

      var1.field2667.vmethod4315(var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "()Ldb;"
   )
   protected TaskDataNode vmethod4311() {
      class216 var1 = (class216)this.field2696.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2667 != null?var1.field2667:this.vmethod4312()));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldb;"
   )
   protected TaskDataNode vmethod4312() {
      class216 var1;
      do {
         var1 = (class216)this.field2696.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2667 == null);

      return var1.field2667;
   }

   @ObfuscatedName("d")
   protected int vmethod4313() {
      return 0;
   }

   @ObfuscatedName("z")
   protected void vmethod4314(int[] var1, int var2, int var3) {
      this.field2695.vmethod4314(var1, var2, var3);

      for(class216 var6 = (class216)this.field2696.getFront(); var6 != null; var6 = (class216)this.field2696.getNext()) {
         if(!this.field2694.method4166(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2669) {
                  this.method4329(var6, var1, var4, var5, var4 + var5);
                  var6.field2669 -= var5;
                  break;
               }

               this.method4329(var6, var1, var4, var6.field2669, var4 + var5);
               var4 += var6.field2669;
               var5 -= var6.field2669;
            } while(!this.field2694.method4167(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("c")
   protected void vmethod4315(int var1) {
      this.field2695.vmethod4315(var1);

      for(class216 var3 = (class216)this.field2696.getFront(); var3 != null; var3 = (class216)this.field2696.getNext()) {
         if(!this.field2694.method4166(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2669) {
                  this.method4317(var3, var2);
                  var3.field2669 -= var2;
                  break;
               }

               this.method4317(var3, var3.field2669);
               var2 -= var3.field2669;
            } while(!this.field2694.method4167(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lju;",
      garbageValue = "-742554119"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isHollow) {
            var1.clipType = 0;
            var1.blocksProjectile = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILcf;ZB)I",
      garbageValue = "-125"
   )
   static int method4333(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class94.field1418:ItemLayer.field1668;
      if(var0 == 1500) {
         class80.intStack[++class80.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class80.intStack[++class80.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class80.intStack[++class80.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class80.intStack[++class80.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class80.intStack[++class80.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class80.intStack[++class80.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
