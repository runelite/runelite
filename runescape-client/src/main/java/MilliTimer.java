import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1880554725
   )
   int field2209;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 134241459
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("j")
   long[] field2212;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2100527215
   )
   int field2208;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 4154243649992876609L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1245020093
   )
   int field2213;

   public MilliTimer() {
      this.field2212 = new long[10];
      this.field2209 = 256;
      this.sleepTime = 1;
      this.field2208 = 0;
      this.milliTime = class74.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2212[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "437016417"
   )
   public int vmethod3004(int var1, int var2) {
      int var3 = this.field2209;
      int var4 = this.sleepTime;
      this.field2209 = 300;
      this.sleepTime = 1;
      this.milliTime = class74.currentTimeMs();
      if(0L == this.field2212[this.field2213]) {
         this.field2209 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2212[this.field2213]) {
         this.field2209 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2212[this.field2213]));
      }

      if(this.field2209 < 25) {
         this.field2209 = 25;
      }

      if(this.field2209 > 256) {
         this.field2209 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2212[this.field2213]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2212[this.field2213] = this.milliTime;
      this.field2213 = (this.field2213 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2212[var5] != 0L) {
               this.field2212[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      class10.method51((long)this.sleepTime);

      for(var5 = 0; this.field2208 < 256; this.field2208 += this.field2209) {
         ++var5;
      }

      this.field2208 &= 255;
      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "102"
   )
   public void vmethod3010() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2212[var1] = 0L;
      }

   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "128"
   )
   static final void method2939() {
      for(int var0 = 0; var0 < Client.field1166; ++var0) {
         --Client.field1169[var0];
         if(Client.field1169[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(Client.field965, Client.field1167[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.field1169[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.field1169[var0] < 0) {
               int var2;
               if(Client.field1170[var0] != 0) {
                  int var3 = (Client.field1170[var0] & 255) * 128;
                  int var4 = Client.field1170[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - XGrandExchangeOffer.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field1170[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - XGrandExchangeOffer.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     Client.field1169[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field1148 / var3;
               } else {
                  var2 = Client.field974;
               }

               if(var2 > 0) {
                  class108 var10 = var9.method1961().method2005(class11.field262);
                  class118 var11 = class118.method2232(var10, 100, var2);
                  var11.method2184(Client.field1168[var0] - 1);
                  class56.field679.method1894(var11);
               }

               Client.field1169[var0] = -100;
            }
         } else {
            --Client.field1166;

            for(int var1 = var0; var1 < Client.field1166; ++var1) {
               Client.field1167[var1] = Client.field1167[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.field1168[var1] = Client.field1168[var1 + 1];
               Client.field1169[var1] = Client.field1169[var1 + 1];
               Client.field1170[var1] = Client.field1170[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1163 && !RSSocket.method3030()) {
         if(Client.field1024 != 0 && Client.field1095 != -1) {
            class66.method1144(class253.indexTrack1, Client.field1095, 0, Client.field1024, false);
         }

         Client.field1163 = false;
      }

   }
}
