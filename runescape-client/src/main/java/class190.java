import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class190 extends CacheableNode {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 151287147
   )
   int field2766 = 0;
   @ObfuscatedName("z")
   short[] field2767;
   @ObfuscatedName("i")
   public static NodeCache field2768 = new NodeCache(64);
   @ObfuscatedName("a")
   public static NodeCache field2769 = new NodeCache(30);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1978162011
   )
   int field2770;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1197955211
   )
   int field2771;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1558635045
   )
   public int field2772 = -1;
   @ObfuscatedName("l")
   short[] field2773;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -410438703
   )
   int field2774 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1293950025
   )
   int field2775 = 128;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1217993801
   )
   int field2776 = 128;
   @ObfuscatedName("g")
   short[] field2777;
   @ObfuscatedName("u")
   public static class182 field2778;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1493547477
   )
   int field2779 = 0;
   @ObfuscatedName("t")
   short[] field2780;
   @ObfuscatedName("x")
   public static class182 field2781;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "-81"
   )
   public final Model method3446(int var1) {
      Model var2 = (Model)field2769.get((long)this.field2770);
      if(var2 == null) {
         ModelData var3 = ModelData.method1463(field2781, this.field2771, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field2773 != null) {
            for(var4 = 0; var4 < this.field2773.length; ++var4) {
               var3.method1427(this.field2773[var4], this.field2777[var4]);
            }
         }

         if(null != this.field2767) {
            for(var4 = 0; var4 < this.field2767.length; ++var4) {
               var3.method1469(this.field2767[var4], this.field2780[var4]);
            }
         }

         var2 = var3.method1486(this.field2766 + 64, 850 + this.field2774, -30, -50, -30);
         field2769.put(var2, (long)this.field2770);
      }

      Model var5;
      if(this.field2772 != -1 && var1 != -1) {
         var5 = CombatInfo2.getAnimation(this.field2772).method3754(var2, var1);
      } else {
         var5 = var2.method1517(true);
      }

      if(this.field2776 != 128 || this.field2775 != 128) {
         var5.method1514(this.field2776, this.field2775, this.field2776);
      }

      if(this.field2779 != 0) {
         if(this.field2779 == 90) {
            var5.method1525();
         }

         if(this.field2779 == 180) {
            var5.method1525();
            var5.method1525();
         }

         if(this.field2779 == 270) {
            var5.method1525();
            var5.method1525();
            var5.method1525();
         }
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-266841107"
   )
   void method3447(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3456(var1, var2);
      }
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1472949768"
   )
   static final void method3448() {
      for(class25 var0 = (class25)Client.field545.method2391(); var0 != null; var0 = (class25)Client.field545.method2393()) {
         if(var0.field577 > 0) {
            --var0.field577;
         }

         if(var0.field577 == 0) {
            if(var0.field570 < 0 || GameEngine.method2120(var0.field570, var0.field574)) {
               class44.method792(var0.field584, var0.field567, var0.field568, var0.field569, var0.field570, var0.field571, var0.field574);
               var0.unlink();
            }
         } else {
            if(var0.field576 > 0) {
               --var0.field576;
            }

            if(var0.field576 == 0 && var0.field568 >= 1 && var0.field569 >= 1 && var0.field568 <= 102 && var0.field569 <= 102 && (var0.field572 < 0 || GameEngine.method2120(var0.field572, var0.field581))) {
               class44.method792(var0.field584, var0.field567, var0.field568, var0.field569, var0.field572, var0.field585, var0.field581);
               var0.field576 = -1;
               if(var0.field572 == var0.field570 && var0.field570 == -1) {
                  var0.unlink();
               } else if(var0.field572 == var0.field570 && var0.field571 == var0.field585 && var0.field574 == var0.field581) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1730564851"
   )
   void method3456(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2771 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2772 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2776 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2775 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2779 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2766 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2774 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2773 = new short[var3];
            this.field2777 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2773[var4] = (short)var1.readUnsignedShort();
               this.field2777[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2767 = new short[var3];
            this.field2780 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2767[var4] = (short)var1.readUnsignedShort();
               this.field2780[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1539948422"
   )
   static void method3457() {
      class45.field888 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class45.field887[var0] = null;
         class45.field886[var0] = 1;
      }

   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "0"
   )
   static final void method3458(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field545.method2391(); var10 != null; var10 = (class25)Client.field545.method2393()) {
         if(var10.field584 == var0 && var10.field568 == var1 && var10.field569 == var2 && var10.field567 == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class25();
         var9.field584 = var0;
         var9.field567 = var3;
         var9.field568 = var1;
         var9.field569 = var2;
         class114.method2175(var9);
         Client.field545.method2394(var9);
      }

      var9.field572 = var4;
      var9.field581 = var5;
      var9.field585 = var6;
      var9.field576 = var7;
      var9.field577 = var8;
   }
}
