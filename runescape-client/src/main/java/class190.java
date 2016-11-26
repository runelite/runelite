import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class190 extends CacheableNode {
   @ObfuscatedName("p")
   short[] field2794;
   @ObfuscatedName("d")
   public static class182 field2795;
   @ObfuscatedName("m")
   static NodeCache field2796 = new NodeCache(64);
   @ObfuscatedName("h")
   static NodeCache field2797 = new NodeCache(30);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1319275531
   )
   int field2798;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1618591619
   )
   int field2799;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1185487101
   )
   public int field2800 = -1;
   @ObfuscatedName("q")
   short[] field2802;
   @ObfuscatedName("g")
   short[] field2803;
   @ObfuscatedName("z")
   short[] field2804;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1869014729
   )
   int field2805 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1001905865
   )
   int field2806 = 128;
   @ObfuscatedName("n")
   public static class182 field2807;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -45763097
   )
   int field2808 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 502328815
   )
   int field2809 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1171135781
   )
   int field2810 = 128;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "1123769135"
   )
   public final Model method3510(int var1) {
      Model var2 = (Model)field2797.get((long)this.field2798);
      if(var2 == null) {
         ModelData var3 = ModelData.method1491(field2795, this.field2799, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field2794 != null) {
            for(var4 = 0; var4 < this.field2794.length; ++var4) {
               var3.method1490(this.field2794[var4], this.field2803[var4]);
            }
         }

         if(null != this.field2804) {
            for(var4 = 0; var4 < this.field2804.length; ++var4) {
               var3.method1506(this.field2804[var4], this.field2802[var4]);
            }
         }

         var2 = var3.method1512(64 + this.field2808, 850 + this.field2809, -30, -50, -30);
         field2797.put(var2, (long)this.field2798);
      }

      Model var5;
      if(this.field2800 != -1 && var1 != -1) {
         var5 = class9.getAnimation(this.field2800).method3811(var2, var1);
      } else {
         var5 = var2.method1583(true);
      }

      if(this.field2810 != 128 || this.field2806 != 128) {
         var5.method1595(this.field2810, this.field2806, this.field2810);
      }

      if(this.field2805 != 0) {
         if(this.field2805 == 90) {
            var5.method1590();
         }

         if(this.field2805 == 180) {
            var5.method1590();
            var5.method1590();
         }

         if(this.field2805 == 270) {
            var5.method1590();
            var5.method1590();
            var5.method1590();
         }
      }

      return var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "291857884"
   )
   void method3511(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2799 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2800 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2810 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2806 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2805 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2808 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2809 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2794 = new short[var3];
            this.field2803 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2794[var4] = (short)var1.readUnsignedShort();
               this.field2803[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2804 = new short[var3];
            this.field2802 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2804[var4] = (short)var1.readUnsignedShort();
               this.field2802[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)Ljava/lang/String;",
      garbageValue = "2147418571"
   )
   static String method3513(Buffer var0, int var1) {
      try {
         int var2 = var0.method3003();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class210.field3108.method2915(var0.payload, var0.offset, var3, 0, var2);
         String var4 = VertexNormal.method1664(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-469052445"
   )
   void method3526(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3511(var1, var2);
      }
   }
}
