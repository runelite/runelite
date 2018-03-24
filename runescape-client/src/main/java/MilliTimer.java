import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("h")
   static int[] field2140;
   @ObfuscatedName("t")
   long[] field2138;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1506442905
   )
   int field2135;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1369393305
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -8038848451047001839L
   )
   long field2137;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2022492181
   )
   int field2134;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 520579797
   )
   int field2139;

   MilliTimer() {
      this.field2138 = new long[10];
      this.field2135 = 256;
      this.sleepTime = 1;
      this.field2134 = 0;
      this.field2137 = WorldMapRegion.method465();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2138[var1] = this.field2137;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public void vmethod3325() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2138[var1] = 0L;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1292093981"
   )
   public int vmethod3323(int var1, int var2) {
      int var3 = this.field2135;
      int var4 = this.sleepTime;
      this.field2135 = 300;
      this.sleepTime = 1;
      this.field2137 = WorldMapRegion.method465();
      if(this.field2138[this.field2139] == 0L) {
         this.field2135 = var3;
         this.sleepTime = var4;
      } else if(this.field2137 > this.field2138[this.field2139]) {
         this.field2135 = (int)((long)(var1 * 2560) / (this.field2137 - this.field2138[this.field2139]));
      }

      if(this.field2135 < 25) {
         this.field2135 = 25;
      }

      if(this.field2135 > 256) {
         this.field2135 = 256;
         this.sleepTime = (int)((long)var1 - (this.field2137 - this.field2138[this.field2139]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2138[this.field2139] = this.field2137;
      this.field2139 = (this.field2139 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2138[var5] != 0L) {
               this.field2138[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      class93.method1982((long)this.sleepTime);

      for(var5 = 0; this.field2134 < 256; this.field2134 += this.field2135) {
         ++var5;
      }

      this.field2134 &= 255;
      return var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "1335151755"
   )
   static char method3187(char var0, int var1) {
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;Ljava/lang/String;Ljava/lang/String;B)Lkm;",
      garbageValue = "20"
   )
   public static Font method3182(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      return AbstractSoundSystem.method2222(var0, var1, var4, var5);
   }
}
