import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("o")
   short[] field3330;
   @ObfuscatedName("e")
   public static NodeCache field3331;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 446206125
   )
   int field3333;
   @ObfuscatedName("t")
   public static NodeCache field3334;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2045694815
   )
   public int field3335;
   @ObfuscatedName("i")
   short[] field3336;
   @ObfuscatedName("f")
   short[] field3337;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1878737339
   )
   int field3338;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 61303959
   )
   int field3339;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1242401799
   )
   int field3340;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2042058889
   )
   int field3341;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1936039025
   )
   int field3342;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -925940865
   )
   int field3343;
   @ObfuscatedName("p")
   public static IndexDataBase field3344;
   @ObfuscatedName("c")
   short[] field3346;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "43"
   )
   void method4210(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4211(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "305055793"
   )
   void method4211(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3333 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3335 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3340 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3341 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3342 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3343 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3338 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3336 = new short[var3];
            this.field3337 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3336[var4] = (short)var1.readUnsignedShort();
               this.field3337[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3346 = new short[var3];
            this.field3330 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3346[var4] = (short)var1.readUnsignedShort();
               this.field3330[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IS)LModel;",
      garbageValue = "15583"
   )
   public final Model method4213(int var1) {
      Model var2 = (Model)field3334.get((long)this.field3339);
      if(var2 == null) {
         ModelData var3 = ModelData.method2310(class217.field2792, this.field3333, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3336 != null) {
            for(var4 = 0; var4 < this.field3336.length; ++var4) {
               var3.method2322(this.field3336[var4], this.field3337[var4]);
            }
         }

         if(this.field3346 != null) {
            for(var4 = 0; var4 < this.field3346.length; ++var4) {
               var3.method2320(this.field3346[var4], this.field3330[var4]);
            }
         }

         var2 = var3.light(this.field3343 + 64, this.field3338 + 850, -30, -50, -30);
         field3334.put(var2, (long)this.field3339);
      }

      Model var5;
      if(this.field3335 != -1 && var1 != -1) {
         var5 = GameEngine.getAnimation(this.field3335).method4580(var2, var1);
      } else {
         var5 = var2.method2394(true);
      }

      if(this.field3340 != 128 || this.field3341 != 128) {
         var5.method2409(this.field3340, this.field3341, this.field3340);
      }

      if(this.field3342 != 0) {
         if(this.field3342 == 90) {
            var5.method2427();
         }

         if(this.field3342 == 180) {
            var5.method2427();
            var5.method2427();
         }

         if(this.field3342 == 270) {
            var5.method2427();
            var5.method2427();
            var5.method2427();
         }
      }

      return var5;
   }

   Spotanim() {
      this.field3335 = -1;
      this.field3340 = 128;
      this.field3341 = 128;
      this.field3342 = 0;
      this.field3343 = 0;
      this.field3338 = 0;
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZB)V",
      garbageValue = "-39"
   )
   static void method4223(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2661 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2661 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2661 == 2) {
         var0.width = var1 * var0.originalWidth >> 14;
      }

      if(var0.field2662 == 0) {
         var0.height = var0.field2666;
      } else if(var0.field2662 == 1) {
         var0.height = var2 - var0.field2666;
      } else if(var0.field2662 == 2) {
         var0.height = var2 * var0.field2666 >> 14;
      }

      if(var0.field2661 == 4) {
         var0.width = var0.field2754 * var0.height / var0.field2759;
      }

      if(var0.field2662 == 4) {
         var0.height = var0.width * var0.field2759 / var0.field2754;
      }

      if(Client.field1076 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1078 = var0;
      }

      if(var3 && var0.field2706 != null && (var4 != var0.width || var0.height != var5)) {
         class69 var6 = new class69();
         var6.field822 = var0;
         var6.field821 = var0.field2706;
         Client.field1105.method3505(var6);
      }

   }

   static {
      field3331 = new NodeCache(64);
      field3334 = new NodeCache(30);
   }
}
