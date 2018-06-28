import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class222 extends TaskDataNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   class218 field2566;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   Deque field2565;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   class88 field2564;

   @ObfuscatedSignature(
      signature = "(Lho;)V"
   )
   class222(class218 var1) {
      this.field2565 = new Deque();
      this.field2564 = new class88();
      this.field2566 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lhy;[IIIII)V",
      garbageValue = "-898408839"
   )
   void method4426(class219 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2566.field2503[var1.field2518] & 4) != 0 && var1.field2532 < 0) {
         int var6 = this.field2566.field2516[var1.field2518] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2538) / var6;
            if(var7 > var4) {
               var1.field2538 += var6 * var4;
               break;
            }

            var1.field2536.vmethod4424(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2538 += var6 * var7 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class103 var10 = var1.field2536;
            if(this.field2566.field2506[var1.field2518] == 0) {
               var1.field2536 = class103.method2316(var1.field2524, var10.method2331(), var10.method2322(), var10.method2323());
            } else {
               var1.field2536 = class103.method2316(var1.field2524, var10.method2331(), 0, var10.method2323());
               this.field2566.method4239(var1, var1.field2519.field2555[var1.field2523] < 0);
               var1.field2536.method2327(var8, var10.method2322());
            }

            if(var1.field2519.field2555[var1.field2523] < 0) {
               var1.field2536.method2318(-1);
            }

            var10.method2329(var8);
            var10.vmethod4424(var2, var3, var5 - var3);
            if(var10.method2333()) {
               this.field2564.method2049(var10);
            }
         }
      }

      var1.field2536.vmethod4424(var2, var3, var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lhy;II)V",
      garbageValue = "-1147854344"
   )
   void method4427(class219 var1, int var2) {
      if((this.field2566.field2503[var1.field2518] & 4) != 0 && var1.field2532 < 0) {
         int var3 = this.field2566.field2516[var1.field2518] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2538) / var3;
         var1.field2538 = var3 * var2 + var1.field2538 & 1048575;
         if(var4 <= var2) {
            if(this.field2566.field2506[var1.field2518] == 0) {
               var1.field2536 = class103.method2316(var1.field2524, var1.field2536.method2331(), var1.field2536.method2322(), var1.field2536.method2323());
            } else {
               var1.field2536 = class103.method2316(var1.field2524, var1.field2536.method2331(), 0, var1.field2536.method2323());
               this.field2566.method4239(var1, var1.field2519.field2555[var1.field2523] < 0);
            }

            if(var1.field2519.field2555[var1.field2523] < 0) {
               var1.field2536.method2318(-1);
            }

            var2 = var1.field2538 / var3;
         }
      }

      var1.field2536.vmethod4425(var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Ldu;"
   )
   protected TaskDataNode vmethod4421() {
      class219 var1 = (class219)this.field2565.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2536 != null?var1.field2536:this.vmethod4422()));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldu;"
   )
   protected TaskDataNode vmethod4422() {
      class219 var1;
      do {
         var1 = (class219)this.field2565.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2536 == null);

      return var1.field2536;
   }

   @ObfuscatedName("d")
   protected int vmethod4423() {
      return 0;
   }

   @ObfuscatedName("s")
   protected void vmethod4424(int[] var1, int var2, int var3) {
      this.field2564.vmethod4424(var1, var2, var3);

      for(class219 var6 = (class219)this.field2565.getFront(); var6 != null; var6 = (class219)this.field2565.getNext()) {
         if(!this.field2566.method4260(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2537) {
                  this.method4426(var6, var1, var4, var5, var5 + var4);
                  var6.field2537 -= var5;
                  break;
               }

               this.method4426(var6, var1, var4, var6.field2537, var4 + var5);
               var4 += var6.field2537;
               var5 -= var6.field2537;
            } while(!this.field2566.method4234(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("g")
   protected void vmethod4425(int var1) {
      this.field2564.vmethod4425(var1);

      for(class219 var3 = (class219)this.field2565.getFront(); var3 != null; var3 = (class219)this.field2565.getNext()) {
         if(!this.field2566.method4260(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2537) {
                  this.method4427(var3, var2);
                  var3.field2537 -= var2;
                  break;
               }

               this.method4427(var3, var3.field2537);
               var2 -= var3.field2537;
            } while(!this.field2566.method4234(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-105"
   )
   public static boolean method4445(int var0) {
      return var0 >= WorldMapDecorationType.field2772.rsOrdinal && var0 <= WorldMapDecorationType.field2793.rsOrdinal;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "310421263"
   )
   public static char method4446(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "-26"
   )
   static final void method4447(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class7.method85(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field875 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
