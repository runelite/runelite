import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 628689353
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1510535339
   )
   int field2166;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1740049913
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("c")
   long[] field2175;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2058811615
   )
   int field2169;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -1808231953264829063L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 483266493
   )
   int field2171;

   MilliTimer() {
      this.field2175 = new long[10];
      this.field2166 = 256;
      this.sleepTime = 1;
      this.field2169 = 0;
      this.milliTime = class157.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2175[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2139277964"
   )
   public int vmethod2910(int var1, int var2) {
      int var3 = this.field2166;
      int var4 = this.sleepTime;
      this.field2166 = 300;
      this.sleepTime = 1;
      this.milliTime = class157.currentTimeMs();
      if(this.field2175[this.field2171] == 0L) {
         this.field2166 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2175[this.field2171]) {
         this.field2166 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2175[this.field2171]));
      }

      if(this.field2166 < 25) {
         this.field2166 = 25;
      }

      if(this.field2166 > 256) {
         this.field2166 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2175[this.field2171]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2175[this.field2171] = this.milliTime;
      this.field2171 = (this.field2171 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2175[var5] != 0L) {
               this.field2175[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      Occluder.method2829((long)this.sleepTime);

      for(var5 = 0; this.field2169 < 256; this.field2169 += this.field2166) {
         ++var5;
      }

      this.field2169 &= 255;
      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2145399515"
   )
   public void vmethod2909() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2175[var1] = 0L;
      }

   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "150254274"
   )
   static void method2851(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.field3467; ++var4) {
         ItemComposition var5 = class10.getItemDefinition(var4);
         if((!var1 || var5.field3513) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               WorldMapType3.field380 = -1;
               WorldMapType3.field361 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      WorldMapType3.field361 = var2;
      class83.field1334 = 0;
      WorldMapType3.field380 = var3;
      String[] var8 = new String[WorldMapType3.field380];

      for(int var9 = 0; var9 < WorldMapType3.field380; ++var9) {
         var8[var9] = class10.getItemDefinition(var2[var9]).name;
      }

      Preferences.method1539(var8, WorldMapType3.field361);
   }
}
