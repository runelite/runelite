import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class190 extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2131215387
   )
   int field2791 = 0;
   @ObfuscatedName("e")
   static class182 field2792;
   @ObfuscatedName("f")
   public static NodeCache field2793 = new NodeCache(64);
   @ObfuscatedName("w")
   short[] field2794;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2088879697
   )
   int field2795;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 332770531
   )
   int field2796;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1060944175
   )
   public int field2797 = -1;
   @ObfuscatedName("q")
   short[] field2798;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 399680397
   )
   int field2799 = 0;
   @ObfuscatedName("v")
   short[] field2800;
   @ObfuscatedName("h")
   short[] field2801;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -392540839
   )
   int field2802 = 128;
   @ObfuscatedName("k")
   public static NodeCache field2803 = new NodeCache(30);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1682779463
   )
   int field2804 = 128;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1558147497
   )
   int field2805 = 0;
   @ObfuscatedName("i")
   static class182 field2806;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "578218480"
   )
   void method3401(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3402(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "101"
   )
   void method3402(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2796 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2797 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2802 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2804 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2791 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2805 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2799 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2798 = new short[var3];
            this.field2794 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2798[var4] = (short)var1.readUnsignedShort();
               this.field2794[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2800 = new short[var3];
            this.field2801 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2800[var4] = (short)var1.readUnsignedShort();
               this.field2801[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "31"
   )
   public final Model method3414(int var1) {
      Model var2 = (Model)field2803.get((long)this.field2795);
      if(var2 == null) {
         ModelData var3 = ModelData.method1452(field2792, this.field2796, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(null != this.field2798) {
            for(var4 = 0; var4 < this.field2798.length; ++var4) {
               var3.method1483(this.field2798[var4], this.field2794[var4]);
            }
         }

         if(this.field2800 != null) {
            for(var4 = 0; var4 < this.field2800.length; ++var4) {
               var3.method1476(this.field2800[var4], this.field2801[var4]);
            }
         }

         var2 = var3.method1480(this.field2805 + 64, this.field2799 + 850, -30, -50, -30);
         field2803.put(var2, (long)this.field2795);
      }

      Model var5;
      if(this.field2797 != -1 && var1 != -1) {
         var5 = GameEngine.getAnimation(this.field2797).method3712(var2, var1);
      } else {
         var5 = var2.method1542(true);
      }

      if(this.field2802 != 128 || this.field2804 != 128) {
         var5.method1555(this.field2802, this.field2804, this.field2802);
      }

      if(this.field2791 != 0) {
         if(this.field2791 == 90) {
            var5.method1550();
         }

         if(this.field2791 == 180) {
            var5.method1550();
            var5.method1550();
         }

         if(this.field2791 == 270) {
            var5.method1550();
            var5.method1550();
            var5.method1550();
         }
      }

      return var5;
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([LWidget;IB)V",
      garbageValue = "12"
   )
   static final void method3419(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(null != var3.children) {
                  method3419(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2311((long)var3.id);
               if(var4 != null) {
                  class32.method656(var4.id, var1);
               }
            }

            class18 var5;
            if(var1 == 0 && null != var3.field2315) {
               var5 = new class18();
               var5.field187 = var3;
               var5.field188 = var3.field2315;
               Ignore.method191(var5);
            }

            if(var1 == 1 && null != var3.field2316) {
               if(var3.index >= 0) {
                  Widget var6 = class191.method3433(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var6.children[var3.index] != var3) {
                     continue;
                  }
               }

               var5 = new class18();
               var5.field187 = var3;
               var5.field188 = var3.field2316;
               Ignore.method191(var5);
            }
         }
      }

   }
}
