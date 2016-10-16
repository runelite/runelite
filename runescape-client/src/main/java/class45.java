import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class45 extends CacheableNode {
   @ObfuscatedName("k")
   short[] field986;
   @ObfuscatedName("f")
   short[] field987;
   @ObfuscatedName("t")
   public static NodeCache field988 = new NodeCache(64);
   @ObfuscatedName("s")
   static class170 field989;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1268868791
   )
   int field990;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 750799349
   )
   public int field991 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 463316533
   )
   int field992 = 0;
   @ObfuscatedName("mt")
   static byte field993;
   @ObfuscatedName("h")
   short[] field994;
   @ObfuscatedName("r")
   short[] field995;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1219608029
   )
   int field996 = 128;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 247271309
   )
   int field997 = 128;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1706552771
   )
   int field998 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1800139327
   )
   int field999 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -148458355
   )
   int field1000;
   @ObfuscatedName("y")
   public static NodeCache field1003 = new NodeCache(30);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "6314"
   )
   void method912(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field990 = var1.method2668();
      } else if(var2 == 2) {
         this.field991 = var1.method2668();
      } else if(var2 == 4) {
         this.field996 = var1.method2668();
      } else if(var2 == 5) {
         this.field997 = var1.method2668();
      } else if(var2 == 6) {
         this.field998 = var1.method2668();
      } else if(var2 == 7) {
         this.field999 = var1.method2481();
      } else if(var2 == 8) {
         this.field992 = var1.method2481();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2481();
            this.field987 = new short[var3];
            this.field986 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field987[var4] = (short)var1.method2668();
               this.field986[var4] = (short)var1.method2668();
            }
         } else if(var2 == 41) {
            var3 = var1.method2481();
            this.field994 = new short[var3];
            this.field995 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field994[var4] = (short)var1.method2668();
               this.field995[var4] = (short)var1.method2668();
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2008333059"
   )
   public static void method913(Component var0) {
      var0.removeMouseListener(class143.mouse);
      var0.removeMouseMotionListener(class143.mouse);
      var0.removeFocusListener(class143.mouse);
      class143.field2182 = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1383150778"
   )
   void method914(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method912(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "863000929"
   )
   public final Model method915(int var1) {
      Model var2 = (Model)field1003.get((long)this.field1000);
      if(null == var2) {
         ModelData var3 = ModelData.method2184(class181.field2955, this.field990, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(null != this.field987) {
            for(var4 = 0; var4 < this.field987.length; ++var4) {
               var3.method2197(this.field987[var4], this.field986[var4]);
            }
         }

         if(null != this.field994) {
            for(var4 = 0; var4 < this.field994.length; ++var4) {
               var3.method2234(this.field994[var4], this.field995[var4]);
            }
         }

         var2 = var3.method2203(64 + this.field999, this.field992 + 850, -30, -50, -30);
         field1003.put(var2, (long)this.field1000);
      }

      Model var5;
      if(this.field991 != -1 && var1 != -1) {
         var5 = class4.getAnimation(this.field991).method883(var2, var1);
      } else {
         var5 = var2.method2297(true);
      }

      if(this.field996 != 128 || this.field997 != 128) {
         var5.method2333(this.field996, this.field997, this.field996);
      }

      if(this.field998 != 0) {
         if(this.field998 == 90) {
            var5.method2327();
         }

         if(this.field998 == 180) {
            var5.method2327();
            var5.method2327();
         }

         if(this.field998 == 270) {
            var5.method2327();
            var5.method2327();
            var5.method2327();
         }
      }

      return var5;
   }

   @ObfuscatedName("pp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-997377358"
   )
   protected static final void method923() {
      class59.field1236 = null;
      class8.field131 = null;
      class47.field1028 = null;
   }
}
