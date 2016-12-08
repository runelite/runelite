import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class190 extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1698889357
   )
   int field2792 = 128;
   @ObfuscatedName("b")
   static NodeCache field2793 = new NodeCache(64);
   @ObfuscatedName("g")
   static NodeCache field2794 = new NodeCache(30);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 432772475
   )
   int field2795;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1939132997
   )
   int field2796;
   @ObfuscatedName("k")
   short[] field2797;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1942383845
   )
   int field2798 = 0;
   @ObfuscatedName("c")
   short[] field2799;
   @ObfuscatedName("o")
   public static class182 field2800;
   @ObfuscatedName("z")
   short[] field2801;
   @ObfuscatedName("u")
   short[] field2802;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 913348987
   )
   public int field2803 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1405350121
   )
   int field2804 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1143283151
   )
   int field2805 = 128;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2000360047
   )
   int field2806 = 0;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "298312921"
   )
   void method3378(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3379(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "56"
   )
   void method3379(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2796 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2803 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2792 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2805 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2804 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2798 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2806 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2799 = new short[var3];
            this.field2802 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2799[var4] = (short)var1.readUnsignedShort();
               this.field2802[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2797 = new short[var3];
            this.field2801 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2797[var4] = (short)var1.readUnsignedShort();
               this.field2801[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "-171166673"
   )
   public final Model method3387(int var1) {
      Model var2 = (Model)field2794.get((long)this.field2795);
      if(null == var2) {
         ModelData var3 = ModelData.method1434(class187.field2783, this.field2796, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(null != this.field2799) {
            for(var4 = 0; var4 < this.field2799.length; ++var4) {
               var3.method1448(this.field2799[var4], this.field2802[var4]);
            }
         }

         if(null != this.field2797) {
            for(var4 = 0; var4 < this.field2797.length; ++var4) {
               var3.method1449(this.field2797[var4], this.field2801[var4]);
            }
         }

         var2 = var3.method1465(64 + this.field2798, 850 + this.field2806, -30, -50, -30);
         field2794.put(var2, (long)this.field2795);
      }

      Model var5;
      if(this.field2803 != -1 && var1 != -1) {
         var5 = class31.getAnimation(this.field2803).method3667(var2, var1);
      } else {
         var5 = var2.method1524(true);
      }

      if(this.field2792 != 128 || this.field2805 != 128) {
         var5.method1537(this.field2792, this.field2805, this.field2792);
      }

      if(this.field2804 != 0) {
         if(this.field2804 == 90) {
            var5.method1532();
         }

         if(this.field2804 == 180) {
            var5.method1532();
            var5.method1532();
         }

         if(this.field2804 == 270) {
            var5.method1532();
            var5.method1532();
            var5.method1532();
         }
      }

      return var5;
   }
}
