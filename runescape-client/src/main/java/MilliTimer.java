import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 1475905987
   )
   static int field2218;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 235969303
   )
   int field2216;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 967780253
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("i")
   long[] field2223;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -97339205
   )
   int field2219;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -6613736603147461401L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -355158773
   )
   int field2215;

   public MilliTimer() {
      this.field2223 = new long[10];
      this.field2216 = 256;
      this.sleepTime = 1;
      this.field2219 = 0;
      this.milliTime = class45.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2223[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "19136800"
   )
   public int vmethod3051(int var1, int var2) {
      int var3 = this.field2216;
      int var4 = this.sleepTime;
      this.field2216 = 300;
      this.sleepTime = 1;
      this.milliTime = class45.currentTimeMs();
      if(this.field2223[this.field2215] == 0L) {
         this.field2216 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2223[this.field2215]) {
         this.field2216 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2223[this.field2215]));
      }

      if(this.field2216 < 25) {
         this.field2216 = 25;
      }

      if(this.field2216 > 256) {
         this.field2216 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2223[this.field2215]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2223[this.field2215] = this.milliTime;
      this.field2215 = (this.field2215 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2223[var5]) {
               this.field2223[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      NPC.method1702((long)this.sleepTime);

      for(var5 = 0; this.field2219 < 256; this.field2219 += this.field2216) {
         ++var5;
      }

      this.field2219 &= 255;
      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   public void vmethod3050() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2223[var1] = 0L;
      }

   }

   @ObfuscatedName("j")
   static final void method2988(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)Lck;",
      garbageValue = "-2121434397"
   )
   static Script method2993(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1857(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(class165.method3159(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-1724977913"
   )
   public static void method2990(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2990(var0, var1, var2, var5 - 1);
         method2990(var0, var1, var5 + 1, var3);
      }

   }
}
