import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -637821587
   )
   int field2772;
   @ObfuscatedName("k")
   public static class182 field2773;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1663982699
   )
   int field2774 = 0;
   @ObfuscatedName("r")
   static NodeCache field2775 = new NodeCache(30);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -69172687
   )
   int field2776;
   @ObfuscatedName("y")
   public static class182 field2777;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -150853637
   )
   public int field2778 = -1;
   @ObfuscatedName("d")
   short[] field2779;
   @ObfuscatedName("n")
   short[] field2780;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1775150207
   )
   int field2781 = 0;
   @ObfuscatedName("s")
   short[] field2782;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -668180795
   )
   int field2783 = 128;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1419857045
   )
   int field2784 = 128;
   @ObfuscatedName("c")
   short[] field2785;
   @ObfuscatedName("o")
   static NodeCache field2786 = new NodeCache(64);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1434041035
   )
   int field2787 = 0;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "15217"
   )
   void method3456(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3459(var1, var2);
      }
   }

   @ObfuscatedName("so")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-502048616"
   )
   protected static final void method3457() {
      class94.field1589.vmethod2039();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1780[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1773[var0] = 0L;
      }

      class49.field958 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "-91"
   )
   public final Model method3458(int var1) {
      Model var2 = (Model)field2775.get((long)this.field2776);
      if(null == var2) {
         ModelData var3 = ModelData.method1470(field2777, this.field2772, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field2779 != null) {
            for(var4 = 0; var4 < this.field2779.length; ++var4) {
               var3.method1474(this.field2779[var4], this.field2780[var4]);
            }
         }

         if(null != this.field2785) {
            for(var4 = 0; var4 < this.field2785.length; ++var4) {
               var3.method1484(this.field2785[var4], this.field2782[var4]);
            }
         }

         var2 = var3.method1491(64 + this.field2781, 850 + this.field2787, -30, -50, -30);
         field2775.put(var2, (long)this.field2776);
      }

      Model var5;
      if(this.field2778 != -1 && var1 != -1) {
         var5 = TextureProvider.getAnimation(this.field2778).method3769(var2, var1);
      } else {
         var5 = var2.method1607(true);
      }

      if(this.field2783 != 128 || this.field2784 != 128) {
         var5.method1621(this.field2783, this.field2784, this.field2783);
      }

      if(this.field2774 != 0) {
         if(this.field2774 == 90) {
            var5.method1574();
         }

         if(this.field2774 == 180) {
            var5.method1574();
            var5.method1574();
         }

         if(this.field2774 == 270) {
            var5.method1574();
            var5.method1574();
            var5.method1574();
         }
      }

      return var5;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-21"
   )
   void method3459(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2772 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2778 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2783 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2784 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2774 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2781 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2787 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2779 = new short[var3];
            this.field2780 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2779[var4] = (short)var1.readUnsignedShort();
               this.field2780[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2785 = new short[var3];
            this.field2782 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2785[var4] = (short)var1.readUnsignedShort();
               this.field2782[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }
}
