import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -227850213
   )
   public int field2813 = 255;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -795606279
   )
   public int field2814 = 70;
   @ObfuscatedName("i")
   public static NodeCache field2815 = new NodeCache(64);
   @ObfuscatedName("x")
   static class182 field2816;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1663757073
   )
   public int field2817;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1783736423
   )
   public int field2819 = 255;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1000853931
   )
   public int field2820 = 0;
   @ObfuscatedName("u")
   static class182 field2821;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -764249279
   )
   public int field2822 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -852495031
   )
   public int field2823 = 1;
   @ObfuscatedName("a")
   public static NodeCache field2824 = new NodeCache(64);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1399671791
   )
   int field2826 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1685117081
   )
   @Export("healthScale")
   public int healthScale = 30;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 436809189
   )
   int field2828 = -1;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-30"
   )
   void method3513(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2813 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2819 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2822 = 0;
      } else if(var2 == 5) {
         this.field2814 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2828 = var1.method2790();
      } else if(var2 == 8) {
         this.field2826 = var1.method2790();
      } else if(var2 == 11) {
         this.field2822 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2820 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "243854838"
   )
   void method3515(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3513(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "2094299187"
   )
   public SpritePixels method3517() {
      if(this.field2826 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2824.get((long)this.field2826);
         if(var1 != null) {
            return var1;
         } else {
            var1 = TextureProvider.method1410(field2816, this.field2826, 0);
            if(var1 != null) {
               field2824.put(var1, (long)this.field2826);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "951473425"
   )
   public SpritePixels method3519() {
      if(this.field2828 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2824.get((long)this.field2828);
         if(null != var1) {
            return var1;
         } else {
            var1 = TextureProvider.method1410(field2816, this.field2828, 0);
            if(var1 != null) {
               field2824.put(var1, (long)this.field2828);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "24"
   )
   public static int method3531(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-594376510"
   )
   static final void method3532(int var0) {
      class33.method695();

      for(class31 var1 = (class31)class31.field703.method2391(); null != var1; var1 = (class31)class31.field703.method2393()) {
         if(var1.field712 != null) {
            var1.method677();
         }
      }

      int var4 = class30.method674(var0).field2749;
      if(var4 != 0) {
         int var2 = class165.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               class84.method1606(0.9D);
               ((TextureProvider)class84.field1434).method1386(0.9D);
            }

            if(var2 == 2) {
               class84.method1606(0.8D);
               ((TextureProvider)class84.field1434).method1386(0.8D);
            }

            if(var2 == 3) {
               class84.method1606(0.7D);
               ((TextureProvider)class84.field1434).method1386(0.7D);
            }

            if(var2 == 4) {
               class84.method1606(0.6D);
               ((TextureProvider)class84.field1434).method1386(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(Client.field517 != var3) {
               if(Client.field517 == 0 && Client.field444 != -1) {
                  class107.method2001(class37.field781, Client.field444, 0, var3, false);
                  Client.field519 = false;
               } else if(var3 == 0) {
                  class9.method118();
                  Client.field519 = false;
               } else {
                  ChatLineBuffer.method886(var3);
               }

               Client.field517 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field358 = 127;
            }

            if(var2 == 1) {
               Client.field358 = 96;
            }

            if(var2 == 2) {
               Client.field358 = 64;
            }

            if(var2 == 3) {
               Client.field358 = 32;
            }

            if(var2 == 4) {
               Client.field358 = 0;
            }
         }

         if(var4 == 5) {
            Client.field303 = var2;
         }

         if(var4 == 6) {
            Client.field445 = var2;
         }

         if(var4 == 9) {
            Client.field558 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field557 = 127;
            }

            if(var2 == 1) {
               Client.field557 = 96;
            }

            if(var2 == 2) {
               Client.field557 = 64;
            }

            if(var2 == 3) {
               Client.field557 = 32;
            }

            if(var2 == 4) {
               Client.field557 = 0;
            }
         }

         if(var4 == 17) {
            Client.field448 = var2 & '\uffff';
         }

         class40[] var5;
         if(var4 == 18) {
            var5 = new class40[]{class40.field802, class40.field798, class40.field800, class40.field799};
            Client.field306 = (class40)class181.method3258(var5, var2);
            if(Client.field306 == null) {
               Client.field306 = class40.field799;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field412 = -1;
            } else {
               Client.field412 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var5 = new class40[]{class40.field802, class40.field798, class40.field800, class40.field799};
            Client.field307 = (class40)class181.method3258(var5, var2);
            if(Client.field307 == null) {
               Client.field307 = class40.field799;
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1967797845"
   )
   static final int method3533(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "-1205259170"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3044.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3042.method3272(12, var0);
         var1 = new Sequence();
         if(null != var2) {
            var1.method3776(new Buffer(var2));
         }

         var1.method3751();
         Sequence.field3044.put(var1, (long)var0);
         return var1;
      }
   }
}
