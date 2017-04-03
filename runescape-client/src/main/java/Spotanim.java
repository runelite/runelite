import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("i")
   static IndexDataBase field2803;
   @ObfuscatedName("u")
   public static NodeCache field2804 = new NodeCache(64);
   @ObfuscatedName("f")
   static IndexDataBase field2805;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2106934821
   )
   int field2806;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -849164299
   )
   int field2807;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1655441633
   )
   public int field2808 = -1;
   @ObfuscatedName("m")
   short[] field2809;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -184813323
   )
   int field2811 = 0;
   @ObfuscatedName("j")
   short[] field2812;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2062318307
   )
   int field2813 = 128;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -927933793
   )
   int field2814 = 128;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1976116427
   )
   int field2815 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1816929395
   )
   int field2816 = 0;
   @ObfuscatedName("n")
   short[] field2817;
   @ObfuscatedName("h")
   public static NodeCache field2818 = new NodeCache(30);
   @ObfuscatedName("w")
   short[] field2819;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-62"
   )
   void method3515(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3528(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "-2128441759"
   )
   public final Model method3517(int var1) {
      Model var2 = (Model)field2818.get((long)this.field2806);
      if(null == var2) {
         ModelData var3 = ModelData.method1495(field2803, this.field2807, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field2817 != null) {
            for(var4 = 0; var4 < this.field2817.length; ++var4) {
               var3.method1509(this.field2817[var4], this.field2809[var4]);
            }
         }

         if(null != this.field2819) {
            for(var4 = 0; var4 < this.field2819.length; ++var4) {
               var3.method1510(this.field2819[var4], this.field2812[var4]);
            }
         }

         var2 = var3.method1524(64 + this.field2816, this.field2811 + 850, -30, -50, -30);
         field2818.put(var2, (long)this.field2806);
      }

      Model var5;
      if(this.field2808 != -1 && var1 != -1) {
         var5 = Friend.getAnimation(this.field2808).method3791(var2, var1);
      } else {
         var5 = var2.method1585(true);
      }

      if(this.field2813 != 128 || this.field2814 != 128) {
         var5.method1614(this.field2813, this.field2814, this.field2813);
      }

      if(this.field2815 != 0) {
         if(this.field2815 == 90) {
            var5.method1656();
         }

         if(this.field2815 == 180) {
            var5.method1656();
            var5.method1656();
         }

         if(this.field2815 == 270) {
            var5.method1656();
            var5.method1656();
            var5.method1656();
         }
      }

      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1016876911"
   )
   void method3528(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2807 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2808 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2813 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2814 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2815 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2816 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2811 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2817 = new short[var3];
            this.field2809 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2817[var4] = (short)var1.readUnsignedShort();
               this.field2809[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2819 = new short[var3];
            this.field2812 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2819[var4] = (short)var1.readUnsignedShort();
               this.field2812[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }
}
