import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class20 implements Runnable {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 956328889
   )
   public static int field208;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -662781303
   )
   int field210 = 0;
   @ObfuscatedName("q")
   int[] field211 = new int[500];
   @ObfuscatedName("d")
   int[] field212 = new int[500];
   @ObfuscatedName("p")
   boolean field213 = true;
   @ObfuscatedName("g")
   Object field214 = new Object();

   public void run() {
      for(; this.field213; class104.method1988(50L)) {
         Object var1 = this.field214;
         synchronized(this.field214) {
            if(this.field210 < 500) {
               this.field211[this.field210] = class115.field1805;
               this.field212[this.field210] = class115.field1814;
               ++this.field210;
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIII[LCollisionData;B)V",
      garbageValue = "-46"
   )
   static final void method198(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var1 + var7 > 0 && var7 + var1 < 103 && var2 + var8 > 0 && var2 + var8 < 103) {
                  var5[var6].flags[var1 + var7][var8 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               WidgetNode.method188(var10, var7, var8 + var1, var2 + var9, var3, var4, 0);
            }
         }
      }

   }
}
