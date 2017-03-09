import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("y")
   short[] field2812;
   @ObfuscatedName("g")
   short[] field2813;
   @ObfuscatedName("d")
   static NodeCache field2814 = new NodeCache(64);
   @ObfuscatedName("x")
   static class182 field2815;
   @ObfuscatedName("h")
   int[] field2816;
   @ObfuscatedName("u")
   short[] field2817;
   @ObfuscatedName("k")
   short[] field2818;
   @ObfuscatedName("j")
   static class182 field2820;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1118180789
   )
   public int field2821 = -1;
   @ObfuscatedName("q")
   public boolean field2822 = false;
   @ObfuscatedName("e")
   int[] field2823 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("bm")
   static class184 field2825;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1517782859"
   )
   void method3505(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3512(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2071285908"
   )
   public boolean method3506() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field2823[var2] != -1 && !field2820.method3374(this.field2823[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   @Export("ready")
   public boolean ready() {
      if(null == this.field2816) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2816.length; ++var2) {
            if(!field2820.method3374(this.field2816[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-13"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field2816 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field2816.length];

         for(int var2 = 0; var2 < this.field2816.length; ++var2) {
            var1[var2] = ModelData.method1522(field2820, this.field2816[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.field2817 != null) {
            for(var3 = 0; var3 < this.field2817.length; ++var3) {
               var4.method1555(this.field2817[var3], this.field2818[var3]);
            }
         }

         if(this.field2813 != null) {
            for(var3 = 0; var3 < this.field2813.length; ++var3) {
               var4.method1536(this.field2813[var3], this.field2812[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1539222737"
   )
   void method3512(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2821 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.field2816 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2816[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.field2822 = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2817 = new short[var3];
            this.field2818 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2817[var4] = (short)var1.readUnsignedShort();
               this.field2818[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2813 = new short[var3];
            this.field2812 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2813[var4] = (short)var1.readUnsignedShort();
               this.field2812[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field2823[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-76"
   )
   public ModelData method3527() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var5 = 0; var5 < 5; ++var5) {
         if(this.field2823[var5] != -1) {
            var1[var2++] = ModelData.method1522(field2820, this.field2823[var5], 0);
         }
      }

      ModelData var3 = new ModelData(var1, var2);
      int var4;
      if(null != this.field2817) {
         for(var4 = 0; var4 < this.field2817.length; ++var4) {
            var3.method1555(this.field2817[var4], this.field2818[var4]);
         }
      }

      if(null != this.field2813) {
         for(var4 = 0; var4 < this.field2813.length; ++var4) {
            var3.method1536(this.field2813[var4], this.field2812[var4]);
         }
      }

      return var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)LCombatInfo2;",
      garbageValue = "-55"
   )
   public static CombatInfo2 method3529(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field2828.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field2827.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method3531(new Buffer(var2));
         }

         CombatInfo2.field2828.put(var1, (long)var0);
         return var1;
      }
   }
}
